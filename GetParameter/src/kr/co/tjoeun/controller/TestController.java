package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TestController {

	
	// <a href="test1?number1=100&number2=200&numbers=300&numbers=400"> test1 get</a> index에서 이렇게 요청 하면 
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		
		String[] numbers = request.getParameterValues("numbers");
		
		
		System.out.println("number1:" + number1);
		System.out.println("number2:" +	number2);
		
		int index = 0;
		for(String number : numbers) {
			System.out.println("numbers[" + index + "] : " + number);
			index += 1;
		}

		return "result";
	}
	
	@PostMapping(value="/test2")
	public String test2(HttpServletRequest request) {
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		
		String[] numbers = request.getParameterValues("numbers");
		
		
		System.out.println("number1:" + number1);
		System.out.println("number2:" +	number2);
		
		if ( numbers != null) {
		int index = 0;
		for(String number : numbers) {
			System.out.println("numbers[" + index + "] : " + number);
			index += 1;
		}
	}	
		return "result";
	}
	
	//webRequest
	@GetMapping("/test3")
	public String test1(WebRequest request) {
		
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		
		String[] numbers = request.getParameterValues("numbers");
		
		
		System.out.println("number1:" + number1);
		System.out.println("number2:" +	number2);
		
		int index = 0;
		for(String number : numbers) {
			System.out.println("numbers[" + index + "] : " + number);
			index += 1;
		}

		return "result";
	}
	//<a href= "test4/111/222/333"> test4</a> jsp에서 요청한 값
	//PathVariable로 받기
	@GetMapping("/test4/{num1}/{num2}/{num3}")
	public String test4(@PathVariable String num1,@PathVariable String num2,@PathVariable String num3) {
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
		
	
	return "result";
	}
	

	@GetMapping("/test5/{int1}/{int2}/{int3}/{int4}")
	public String test5(@PathVariable String int1,@PathVariable String int2,
						@PathVariable String int3,@PathVariable String int4) {
		
		System.out.println("int1 : " + int1);
		System.out.println("int2 : " + int2);
		System.out.println("int3 : " + int3);
		System.out.println("int4 : " + int4);
		return "result";
	}

	@GetMapping("/test6/{n1}/{n2}/{n3}/{n4}/{n5}")
	public String test6(@PathVariable int n1,@PathVariable int n2,@PathVariable int n3,
						@PathVariable int n4,@PathVariable int n5) {
		
		
		int sum = n1+n2+n3+n4+n5;
		System.out.println("합계 : " + sum);
		
		return "result";
	}
	// <a href= "test7?num1=11&num2=22&nums=33&nums=44"> test7</a>
	// RequestParam으로 받기
	@GetMapping("/test7")
	public String test7(@RequestParam int num1,@RequestParam int num2,@RequestParam int[] nums) {
		//int로 바로 받아서 사용 변수이름이 같게 사용
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("nums[0] : " + nums[0]);
		System.out.println("nums[1] : " + nums[1]);
	
		int sum = num1 + num2 + nums[0] + nums[1];
		System.out.println("합계 : " + sum);
		
		return "result";
	}

	//보내는 변수이름과 받는 변수이름을 다르게 할 때 
	@GetMapping("/test8")
	public String test8(@RequestParam(value="num1")int number1,
						@RequestParam(value="num2")int number2,
						@RequestParam(value="nums")int[] numbers) {
		
		
		System.out.println("num1 : " + number1);
		System.out.println("num1 : " + number2);
		System.out.println("nums[0] : " + numbers[0]);
		System.out.println("nums[1] : " + numbers[1]);
	
		int sum = number1 + number2 + numbers[0] + numbers[1];
		System.out.println("합계 : " + sum);
		
		return "result";
		
		
	}
	// 넘기는 갯수와 받는 갯수가 달라도 오류가 안 생긴다. (num2가 없음)
	@GetMapping("/test9")
	public String test9(@RequestParam int num1,@RequestParam int[] nums) {

		
		System.out.println("num1 : " + num1);
		System.out.println("nums[0] : " + nums[0]);
		System.out.println("nums[1] : " + nums[1]);
	
		int sum = num1  + nums[0] + nums[1];
		System.out.println("합계 : " + sum);
		
		return "result";
	}

	//넘어오지 않는 값을 더 받았을 경우 ( @RequestParam int num3 가 더 추가됨 index에는 없음)
	// 400에러 발생
	@GetMapping("/test10")
	public String test10(@RequestParam int num1,@RequestParam int num2,@RequestParam int num3,@RequestParam int[] nums) {
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
		System.out.println("nums[0] : " + nums[0]);
		System.out.println("nums[1] : " + nums[1]);
	
		int sum = num1 + num2 + num3+ nums[0] + nums[1];
		System.out.println("합계 : " + sum);
		
		return "result";
	}

	//넘어오지 않는 값을 더 받았을 경우 ( @RequestParam int num3, String num4 가 더 추가됨)
	// 	required : false로 설정하면 지정된 이름의 파라미터가 없는 경우
	//   null이 주입됨 String일 때 사용
	//@RequestParam(required=false) int num3 => 일단 null값으로 받고 int type으로 형변환하려고 하여 오류발생
	//@RequestParam(required=false) String num4 String이라서 null값 주입 
	@GetMapping("/test11")
	public String test11(@RequestParam int num1,
			@RequestParam int num2,
//			@RequestParam(required=false) int num3,
			@RequestParam(required=false) String num4,
			@RequestParam int[] nums) {
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
//		System.out.println("num3 : " + num3);
		System.out.println("num4 : " + num4);
		System.out.println("nums[0] : " + nums[0]);
		System.out.println("nums[1] : " + nums[1]);
	
//		int sum = num1 + num2 + num3+ num4+ nums[0] + nums[1];
//		System.out.println("합계 : " + sum);
		
		return "result";
	}

	
	//넘어오지 않는 값을 더 받았을 경우 (num3 추가됨)
	
 	//defaultValue="0"으로 설정하면 지정된 이름의 파라미터가 없는 경우
 	//			 "0"이 주입됨
	@GetMapping("/test12")
	public String test12(@RequestParam int num1,
			@RequestParam int num2,
			@RequestParam(defaultValue="0") int num3,
			@RequestParam int[] nums) {
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
		System.out.println("nums[0] : " + nums[0]);
		System.out.println("nums[1] : " + nums[1]);
	
		int sum = num1 + num2 + num3+  nums[0] + nums[1];
		System.out.println("합계 : " + sum);
		
		return "result";
	}
	
	
	
	
	
	

}
