package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	/*
	 * => 기본적으로 WebContexnt는 인식하므로 return "/WEB-INF/views/index.jsp"; 이런식으로 작성 
	 * =>"/WEB-INF/views/index.jsp" 에서 /WEB-INF/views/ 이 부분을 prefix로 설정 (접두사) 
	 * => .jsp" 이 부분을 suffix로 (접미사)로 설정해서 => return "index" 라고만 coding 해도 전체 경로를 인식하게 한다. 
	 * =>servlet-context.xml파일에서 설정
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		System.out.println("home");
		return "index";
	}
	
	@RequestMapping(value="/tjoeun", method=RequestMethod.GET)
	public String tjoeun() {
		System.out.println("tjoeun");
		return null;
	}
	
}





