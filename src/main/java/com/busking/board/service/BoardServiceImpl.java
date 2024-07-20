package com.busking.board.service;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.busking.board.model.BoardFreeDTO;
import com.busking.board.model.BoardFreeMapper;
import com.busking.util.mybatis.MybatisUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardServiceImpl implements BoardService {
	
	SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
	
	@Override
	public void getFreeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request
		String page = (String)request.getAttribute("page");
		int pageFirst = Integer.parseInt(page) * 20 - 19;
		
		// DTO
		ArrayList<BoardFreeDTO> list = new ArrayList<>();
		
		// Mapper
		SqlSession sql = sqlSessionFactory.openSession(true);
		BoardFreeMapper mapper = sql.getMapper(BoardFreeMapper.class);
		
		list = mapper.getFreeList(pageFirst);
		sql.close();
		// response
		request.setAttribute("freeList", list);
		request.getRequestDispatcher("board_free_list.jsp?page=" + page).forward(request, response);
	}
	
	@Override
	public void writeFree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request
		String freeTitle = request.getParameter("title");
		String freeContent = request.getParameter("content");
		// DTO
		BoardFreeDTO dto = new BoardFreeDTO();
		dto.setFreeWriter("홍길동");
		dto.setFreeTitle(freeTitle);
		dto.setFreeContent(freeContent);
		// Mapper
		SqlSession sql = sqlSessionFactory.openSession(true);
		BoardFreeMapper mapper = sql.getMapper(BoardFreeMapper.class);
		
		mapper.writeFree(dto);
		// response
		response.sendRedirect("board_free_list.board");
	}
	
	@Override
	public void getFreeContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request
		String freeNum = request.getParameter("freeNum");
		
		// DTO
		BoardFreeDTO dto = new BoardFreeDTO();
		
		// Mybatis
		SqlSession sql = sqlSessionFactory.openSession(true);
		BoardFreeMapper mapper = sql.getMapper(BoardFreeMapper.class);
		
		mapper.increaseHit(freeNum);
		dto = mapper.getFreeContent(freeNum);
		
		// response
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("board_free_content.jsp").forward(request, response);
		
	}

}
