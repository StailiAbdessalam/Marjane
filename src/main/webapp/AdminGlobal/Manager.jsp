<%@ page import="org.hibernate.Session" %>
<%@ page import="Models.Categorie" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: abdessalm staili
  Date: 10/31/2022
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.3/dist/flowbite.min.css" />
</head>
<body>
<jsp:include page="../Components/Admin/Header_Admin.jsp"/>
<div class="mt-[100px]">
    <jsp:include page="../Components/AdminCenter/Table.jsp"/>
</div>

<script src="https://unpkg.com/flowbite@1.5.3/dist/flowbite.js"></script>
</body>
</html>
