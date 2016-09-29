package com.crewguru.contolers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping(value="html",method = RequestMethod.GET)
    public String getIndexPage() {
        return "index.html";
    }

}
