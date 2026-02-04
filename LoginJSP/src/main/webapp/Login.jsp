<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   
    String u = request.getParameter("username");
    String p = request.getParameter("password");

  
    if (u == null) u = "";
    if (p == null) p = "";

    
    if (u.equals("ABC") && p.equals("MNK")) {
       
        response.sendRedirect("UserProflie.html");
    } else {
        
        response.sendRedirect("Login.html");
    }
%>