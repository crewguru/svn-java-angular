package com.crewguru.contolers;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crewguru.bean.Location;
import com.crewguru.bean.User;
import com.crewguru.bean.UserProfile;
import com.crewguru.bean.WorkExperience;
import com.crewguru.business.service.UserProfileService;
import com.crewguru.business.service.UserService;

import com.crewguru.component.S3Service;

import com.crewguru.util.MailService;



@RestController
@RequestMapping("/data")
public class UserController {
	
	//@Autowired
	//private IUserService personService;
	
	@Autowired
	private S3Service s3service;
	
	@Resource
	private UserService userService;
	
	@Resource
	private UserProfileService userProfileService;
	
	/*@RequestMapping("/person")
	public Person getPersonDetail(@RequestParam(value = "id",required = false,
	                                                    defaultValue = "0") Integer id) {
		Person p = personService.getPersonDetail(id);
		return p;
	}*/
	
	
	@RequestMapping(value = "/userProfile",produces = "application/json")
	public String createUserProfile(@RequestBody User user){
		
		System.out.println("UserName is :======================="+user.getFirstname());
		//user.setUserId("g12@test.com");
		//user.setPassword("password");
		//userService.create(user);
		return "{ \"success\": true }";
	}
	
	@RequestMapping(value = "/user",produces = "application/json")
	public String createUser(@RequestBody User user){
		
		System.out.println("UserName is :"+ user.getUserId());
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
		String pwd = RandomStringUtils.random( 15, 0, 0, false, false, characters.toCharArray(), new SecureRandom() );
		
		user.setPassword(pwd);
		userService.create(user);
		
		MailService.sendEmail(user.getUserId(), user.getFirstname(), pwd);
		return "{ \"success\": true }";
		
		
	}
	
	@RequestMapping(value = "/saveuserprofile",produces = "application/json")
	public String saveUserProfile(@RequestBody User user){
		
		System.out.println("UserName is :"+ user.getUserId());
		//user.setPassword("password");
		userService.save(user);
		return "{ \"success\": true }";
		
		
	}
	
	@RequestMapping(value = "/getuser/{username}",produces = "application/json")
	public User getUser(@PathVariable("username") String username){
		
		System.out.println("UserName is :"+ username.trim());
		
		//userService.findById(username);
		return userService.findById(username);
		
		
	}
	
	@RequestMapping(value = "/getselecteduser",produces = "application/json")
	public User getUserProfile(@RequestBody Map<String, String> json){
		
		
		String username=json.get("username");
		String editflag=json.get("editflag");
		System.out.println("UserName is :"+ username);
		
		User user=userService.findById(username);
		System.out.println("edit falg  is:"+editflag);
		if(editflag.equals("Y"))
		{
			System.out.println("location obj :"+user.getListOfLocation());
			if(user.getListOfLocation() !=null && user.getListOfLocation().size() ==0)
			{
				List<Location> locList=new ArrayList<Location>();
				Location location=new Location();
				location.setUserId(user.getUserId());
				location.setType("C");
				locList.add(location);
				Location location1=new Location();
				location1.setType("F");
				location1.setUserId(user.getUserId());
				locList.add(location1);
				user.setListOfLocation(locList);
				
			}
			
			if(user.getListOfWorkExperience() !=null && user.getListOfWorkExperience().size() ==0)
			{
				List<WorkExperience> workList=new ArrayList<WorkExperience>();
				WorkExperience workExp=new WorkExperience();
				workExp.setUserId(user.getUserId());
				
				user.setListOfWorkExperience(workList);
				
			}
			
		}
		//System.out.println("user "+user);
		return user;
		
		
	}
	
	@RequestMapping(value = "/userprofiles",produces = "application/json")
	public List<UserProfile> getUserProfiles(){
		
		System.out.println("User Profiles is :");
		//user.setPassword("password");
		List<UserProfile> ups=userProfileService.findAll();
		return ups;
		
		
	}
	
	 @RequestMapping(method = RequestMethod.POST, value = "/fileupload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("userId") String userId,@RequestParam("imageType") String imageType,
								   RedirectAttributes redirectAttributes) {

		String response=null;
		String s3url=null;
		 if (!file.isEmpty() && userId !=null) {
			try {
				String fileKey="";
				if(imageType !=null && imageType.equals("profileimage"))
					fileKey=userId+"pf";
				if(imageType !=null && imageType.equals("bgimage"))
					fileKey=userId+"bg";
				
				 s3url=s3service.uploadFile("profiles/"+fileKey, file.getInputStream(), "www.crewguru.com");
				//Files.copy(file.getInputStream(), Paths.get(ROOT, file.getOriginalFilename()));
				
				System.out.println(" File URL :"+s3url);
				System.out.println(" User id :"+userId);
				
				redirectAttributes.addFlashAttribute("message",
						"You successfully uploaded " + file.getOriginalFilename() + "!");
				User user=userService.findById(userId);
				UserProfile up=new UserProfile();
				if(user.getListOfUserProfile() !=null && user.getListOfUserProfile().size() > 0)
				{
					up=user.getListOfUserProfile().get(0); 
					if(imageType !=null && imageType.equals("profileimage"))
						up.setProfileImage(s3url);
					if(imageType !=null && imageType.equals("bgimage"))
						up.setBackgroundImage(s3url);
					up.setUserId(user.getUserId());
					userProfileService.update(up);
				}
				else
				{
					up.setId(-1);
					up.setUserId(user.getUserId());
					if(up.getProfession() ==null)
						up.setProfession(" ");
					if(imageType !=null && imageType.equals("profileimage"))
						up.setProfileImage(s3url);
					if(imageType !=null && imageType.equals("bgimage"))
						up.setBackgroundImage(s3url);
					userProfileService.create(up);
				}
				
				response= "{ \"success\": true, \"picpath\": \""+s3url+"\"}";
			} /*catch (IOException|RuntimeException e) {
				e.printStackTrace();
				response= "{ \"success\": false}";
				//redirectAttributes.addFlashAttribute("message", "Failued to upload " + file.getOriginalFilename() + " => " + e.getMessage());
			}*/
			catch (Exception e) {
				e.printStackTrace();
				response= "{ \"success\": false}";
				//redirectAttributes.addFlashAttribute("message", "Failued to upload " + file.getOriginalFilename() + " => " + e.getMessage());
			}
		} else {
			response= "{ \"success\": false}";
			redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " because it was empty");
		}

		return response;
	}
	
	
	@RequestMapping(value = "/authenticate",produces = "application/json")
	public User authenticateUser(@RequestBody UserModel user1){
		System.out.println("in Authenticate function");
		System.out.println(" User Name"+user1.getUsername());
		//User user=personService.findByName(user1.getUsername());
		
		User user=userService.findById(user1.getUsername());
		//System.out.println("in Authenticate function");
		if (user !=null && user.getPassword().equals(user1.getPassword()))
			return  user;//return "{ \"success\": true }";
		else
			return null; //"{ success: false, message: 'Username or password is incorrect' }";
		
		
	}
}