<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.BoardDAO"%>
<%@ page import="com.example.bean.BoardVO" %>
<%@ page import="com.example.util.FileUpload" %>
<%
	String sid = request.getParameter("id");
	if (sid != ""){
		int id = Integer.parseInt(sid);
		BoardDAO boardDAO = new BoardDAO();
		BoardVO u = new BoardVO();
		u.setSeq(id);
		// 업로드한 photo 파일 삭제
		String filename = boardDAO.getPhotoFilename(id);
		if(filename !=null){
			FileUpload.deleteFile(request,filename);
		}
		boardDAO.deleteBoard(u);
	}
	response.sendRedirect("posts.jsp");
%>