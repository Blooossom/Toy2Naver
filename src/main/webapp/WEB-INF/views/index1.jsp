<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
  <meta charset="UTF-8">
  <title>네이버 페이</title>
  <link rel="stylesheet" href="/resources/css/style.css" type="text/css">
</head>
<body>
<header><jsp:include page="layout/header.jsp"/></header>
<%@include file="./messages/showMessage.jsp"%>
<%
  showMessage(request, response, "logout", Status.SUCCESS);
  showMessage(request, response, "withdraw", Status.SUCCESS);
%>
<main>
  <h1>Hello ${uId}</h1>
  <h2>Current Time - ${now}</h2>
  <%
    LocalDateTime now = null;
    if(request.getAttribute("now")!=null){
      now=(LocalDateTime) request.getAttribute("now");
    }
  %>
  <aside class="aside">
    <div class="option-title">페이 메뉴</div>
    <ul>
      <li><a href="/members/login">로그인</a></li>
      <li><a href="/members/signup">회원가입</a></li>
      <li><a href="/members/payHome">나만의 Pay</a> </li>
    </ul>
  </aside>
  <h2>Current Time - <%=now%></h2>
</main>
<footer><jsp:include page="layout/footer.jsp"/></footer>
</body>
</html>
