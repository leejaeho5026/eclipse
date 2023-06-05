package kr.co.tjoeun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tjoeun.model.Test2Service;

@WebServlet("*.mvc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// System.out.println("HomeController");
		//요청한 주소(URL)를 가져옴
		String url =  request.getRequestURI();
		// view로 사용하는 jsp
		String viewName = null;
		
		if(url.contains("main.mvc")) {   	// contains 포함하다 -> main.mvc모델을 포함하고 있다면
			// System.out.println("main 요청");
			viewName = "main.jsp";
			
		}else if(url.contains("test1.mvc")) {   	
			 // System.out.println("test1 요청");
		
		// parameter 추출하기
			String strnumber1 = request.getParameter("number1"); //문자열로 받기 파라미터로
			String strnumber2 = request.getParameter("number2");			
			int number1 = Integer.parseInt(strnumber1); // 문자열을 숫자열로 변환
			int number2 = Integer.parseInt(strnumber2);

		    int result = number1 + number2; 
			//메모리에 result 라는 이름(변수)으로 
			// 위에 있는 result 변수에 할당된 값을 올림 <- test1.jsp에서 이 값을 받는다.
			request.setAttribute("result", result);		
			viewName = "test1.jsp";   // 	<h2>result :${result }</h2> result라는 변수 이름으로 test1.jsp에 받아서 출력
			


		  //  int result = number3 + number4; 
			//메모리에 result 라는 이름(변수)으로 
			// 위에 있는 result 변수에 할당된 값을 올림 <- test1.jsp에서 이 값을 받는다.
	
		}else if(url.contains("test2.mvc")) {   
			
			// parameter로 받기
		 int result = Test2Service.minus(request);
			
		 request.setAttribute("result", result);			
			// System.out.println("test2 요청");
			viewName = "test2.jsp";
		}
		RequestDispatcher dis = request.getRequestDispatcher(viewName);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
