<%--
  Created by IntelliJ IDEA.
  User: abdessalm staili
  Date: 11/2/2022
  Time: 11:48 AM
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
    <link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.4/dist/flowbite.min.css" />
  </head>
  <body>
  <jsp:include page="../Components/AdminCenter/Header_AdminCenter.jsp"/>

  <div class="mt-[100px]">
    <button type="button" class="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded" data-modal-toggle="add_promotion">
      Add Promotion
    </button>
  <div id="add_promotion" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 p-4 w-full md:inset-0 h-modal md:h-full">
    <jsp:include page="../Components/AdminCenter/addPromotion.jsp"/>
  </div>

  <jsp:include page="../Components/AdminCenter/TablePromotion.jsp"/>
  </div>
  </body>
  <script src="https://unpkg.com/flowbite@1.5.4/dist/flowbite.js"></script>
</html>
