package com.app.controller;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//MANDATORY
@RequestMapping("/test")//OPTIONAL CLASS LEVEL MAPPING
//BUT recommanded for functional separation
public class TestController {
public TestController() {
	System.out.println("In ctor of"+getClass());
}
//add request handling method to genertae dyn response using model attr:model & View class

@GetMapping("/test1")
public ModelAndView testModelAndView() {
	System.out.println("in test m n v");
	// MOVEL AND VIEW CTOR(Str LVN,str modelAttrName,Object modelAttrVal )
	return new ModelAndView("/test/test1", "server_ts",LocalDateTime.now());
	//AVN :/WEB-INF/views/test/test1.jsp
}

//add req handling methgod to generate dyn resp using model attr:via Model Map
@GetMapping("/test2")
public String testModelMap(Model map)//D.I.
{
System.out.println("in test model map"+map);//{} EMPTY MAP HANDELR REQ SPRING CONTAINER GIVE MY EMPTY MAP
//Model API:public Model addAttribute(String attrName,Object attrValue)
map.addAttribute("server_ts",new Date())
.addAttribute("num_list",Arrays.asList(10,20,30,40));
System.out.println("map again"+map);//{.....}
return "/test/test1";//AVN:/WEB-INF/views/test/test1.jsp
//SC will impl ret populated model map along with LVN
}

}
