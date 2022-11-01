<%--
  Created by IntelliJ IDEA.
  User: abdessalm staili
  Date: 10/31/2022
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.3/dist/flowbite.min.css" />
</head>
<body>
<jsp:include page="../Components/AdminCenter/Header_AdminCenter.jsp"/>
<div class="mt-[100px]">
    <button class="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded" data-modal-toggle="add_manager">
        Add Manager
    </button>
    <div id="add_manager" tabindex="-1" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full">
        <jsp:include page="../Components/AdminCenter/AddManager.jsp" />
    </div>
    <jsp:include page="../Components/AdminCenter/Table.jsp"/>
</div>

<script src="https://unpkg.com/flowbite@1.5.3/dist/flowbite.js"></script>
</body>
</html>
