package com.crewguru.contolers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.crewguru.bean.Payload;
import com.crewguru.bean.User;
import com.crewguru.business.service.UserService;
import com.crewguru.util.ClientSecretsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Resource
	private UserService userService;
	private final ClientSecretsConfiguration secrets=new  ClientSecretsConfiguration();
	public static final String AUTH_HEADER_KEY = "Authorization";
	ObjectMapper mapper=new ObjectMapper();
	
	public static final String CLIENT_ID_KEY = "client_id", REDIRECT_URI_KEY = "redirect_uri",
		      CLIENT_SECRET = "client_secret", CODE_KEY = "code", GRANT_TYPE_KEY = "grant_type",
		      AUTH_CODE = "authorization_code";

	public static final String CONFLICT_MSG = "There is already a %s account that belongs to you",
		      NOT_FOUND_MSG = "User not found", LOGING_ERROR_MSG = "Wrong email and/or password",
		      UNLINK_ERROR_MSG = "Could not unlink %s account because it is your only sign-in method";

@RequestMapping(value = "/google",produces = "application/json")	
public User loginGoogle(@RequestBody Payload payload,  HttpServletRequest request) throws Exception, JsonMappingException, IOException{
		
		System.out.println("login with google");
		request.getAttributeNames();
		final String accessTokenUrl = "https://accounts.google.com/o/oauth2/token";
	    final String peopleApiUrl = "https://www.googleapis.com/plus/v1/people/me/openIdConnect";
	    
	    
	    RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());
        
     // Step 1. Exchange authorization code for access token.
        final MultiValueMap<String, String> accessData = new LinkedMultiValueMap<String, String>();
        accessData.add(CLIENT_ID_KEY, payload.getClientId());
        accessData.add(REDIRECT_URI_KEY, payload.getRedirectUri());
        accessData.add(CLIENT_SECRET, "o0W1U0kEnr74RO9cmDxVcaA2");
        accessData.add(CODE_KEY, payload.getCode());
        accessData.add(GRANT_TYPE_KEY, AUTH_CODE);
        String result = rt.postForObject(accessTokenUrl, accessData, String.class);
		System.out.println(result);
		
		
		Map<String, Object> mymap=readValue(result);
		
		 // Step 2. Retrieve profile information about the current user.
		System.out.println(" access token is :"+mymap.get("access_token"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+mymap.get("access_token"));

		HttpEntity<String> entity = new HttpEntity<String>("",headers);
		 //result = rt.postForObject(peopleApiUrl, entity, String.class);
		 ResponseEntity<String> respEntity = rt.exchange(peopleApiUrl, HttpMethod.GET, entity, String.class);
		 
		 mymap=readValue(respEntity.getBody());
		 User user= userService.findById((String)mymap.get("email"));
		 System.out.println(respEntity);
		 
		 if(user !=null)
		 {
			 
			// return "{ \"success\": true "+ mapper.writeValueAsString(user) + "}";
			 System.out.println(respEntity);
			 
		 }else{
			 user=new User();
			 user.setUserId((String)mymap.get("email"));
			 user.setEmailId((String)mymap.get("email"));
			 user.setFirstname((String)mymap.get("name"));
			 user.setLastname((String)mymap.get("family_name"));
			 user.setPassword("goglesignin");
			 userService.create(user);
			// String json = mapper.writeValueAsString(user);
			 //return "{ \"success\": true "+  mapper.writeValueAsString(user)+ "}";
		 }
		 
		return user;
        
		
	}



	private Map<String, Object> readValue(String result) throws Exception, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		return mapper.readValue(result,new TypeReference<Map<String, Object>>() {});
	}




}
