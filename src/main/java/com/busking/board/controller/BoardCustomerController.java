package com.busking.board.controller;

import java.io.IOException;

import com.busking.board.service.BoardCustomerService;
import com.busking.board.service.BoardCustomerServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.customer")
public class BoardCustomerController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청을 분기
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI(); // ip, port번호 제외된 주소
		String path = request.getContextPath(); // 프로젝트 식별 주소
		String command = uri.substring(path.length());

		System.out.println("요청됨 " + command); // 요청 되는지 보기

		// BoardService 선언해두기
		BoardCustomerService service;

		if (command.equals("/customer_center/customer_center_index.customer")) {
			// 누르면 데이터가 필요하면 서비스
			// 아니면 리다이렉트

			// 데이터 필요한 공지
			service = new BoardCustomerServiceImpl();
			service.getList(request, response);

			System.out.println("공지 화면 이동");
			
			//response.sendRedirect("customer_center_index.jsp");
			//response.sendRedirect(request.getContextPath() + "/customer_center_index.jsp");

		} else if (command.equals("/customer_center/customer_center_month.customer")) {
			//이달의 예약
			
			response.sendRedirect("/customer_center/customer_center_month.jsp");
			
		} else if (command.equals("/customer_center/customer_center_guide.customer")) {
			//이용안내
			
			response.sendRedirect("/customer_center/customer_center_guide.jsp");

		} else if (command.equals("/customer_center/customer_center_FAQ.customer")) {
			//자주묻는질문FAQ
			response.sendRedirect("/customer_center/customer_center_FAQ.jsp");

		} else if (command.equals("/customer_center/registForm.customer")) {
			//글 등록
			
			service = new BoardCustomerServiceImpl();
			service.regist(request, response);
			
			System.out.println("컨트롤러에서 글 등록 화면으로");
			
		}

	}
}
