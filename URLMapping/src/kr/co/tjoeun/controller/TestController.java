package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // 컨트롤러라고 인식 해주는 것
public class TestController {

	@RequestMapping("test1") // (value="/test1", method=RequestMethod.GET)이 생략되어 있는 것
	public String test1() {
		return "test1"; // 접미사 접두사가 들어가므로 WEB-INF/views/test1.jsp/가 있는 것
	}

	@RequestMapping("test2")
	public String test2() {
		return "test2";
	}


}
