<%@ page import="Models.Promotion" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: abdessalm staili
  Date: 10/30/2022
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<%
    List<Promotion> allpromotionAccepter = (List<Promotion>) request.getAttribute("allpromotionAccepter");
    List<Promotion> allpromotionRefuser = (List<Promotion>) request.getAttribute("allpromotionRefuser");
    List<Promotion> allpromotionPending = (List<Promotion>) request.getAttribute("allpromotionPending");

%>
<body>
<jsp:include page="../Components/Admin/Header_Admin.jsp"/>
<div class="mt-[80px]">
    <div class="max-w-6xl mx-auto px-4 sm:px-6 lg:px-8">
        <h2 class="text-lg leading-6 font-medium text-gray-900">Overview</h2>
        <div class="mt-2 grid grid-cols-1 gap-5 sm:grid-cols-2 lg:grid-cols-3">
            <div class="bg-white overflow-hidden shadow rounded-lg">
                <div class="p-5">
                    <div class="flex items-center">
                        <div class="flex-shrink-0">
                            <!-- Heroicon name: outline/scale -->
                            <svg width="32px" height="32px" viewBox="0 0 32 32" style="fill-rule:evenodd;clip-rule:evenodd;stroke-linejoin:round;stroke-miterlimit:2;" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:serif="http://www.serif.com/" xmlns:xlink="http://www.w3.org/1999/xlink"><g transform="matrix(1,0,0,1,-96,-48)"><g transform="matrix(1.13043,0,0,1.13043,-16.3043,-7.78261)"><circle cx="113.5" cy="63.5" r="11.5" style="fill:rgb(144,224,239);"/></g><path d="M112,50C104.273,50 98,56.273 98,64C98,71.727 104.273,78 112,78C119.727,78 126,71.727 126,64C126,56.273 119.727,50 112,50ZM112,52C118.623,52 124,57.377 124,64C124,70.623 118.623,76 112,76C105.377,76 100,70.623 100,64C100,57.377 105.377,52 112,52ZM116.356,66.032C117.442,66.229 118.165,67.27 117.968,68.356C117.771,69.442 116.73,70.165 115.644,69.968C114.558,69.771 113.835,68.73 114.032,67.644C114.229,66.558 115.27,65.835 116.356,66.032ZM116.293,58.293L106.293,68.293C105.903,68.683 105.903,69.317 106.293,69.707C106.683,70.097 107.317,70.097 107.707,69.707L117.707,59.707C118.097,59.317 118.097,58.683 117.707,58.293C117.317,57.903 116.683,57.903 116.293,58.293ZM108.356,58.032C109.442,58.229 110.165,59.27 109.968,60.356C109.771,61.442 108.73,62.165 107.644,61.968C106.558,61.771 105.835,60.73 106.032,59.644C106.229,58.558 107.27,57.835 108.356,58.032Z" style="fill:rgb(25,144,167);"/></g></svg>
                        </div>
                        <div class="ml-5 w-0 flex-1">
                            <dl>
                                <dt class="text-sm font-medium text-gray-500 truncate">promotion Pending</dt>
                                <dd>
                                    <div class="text-lg font-medium text-gray-900"><%=allpromotionPending.size()%></div>
                                </dd>
                            </dl>
                        </div>
                    </div>
                </div>
                <div class="bg-gray-50 px-5 py-3">
                    <div class="text-sm">
                        <a href="#" class="font-medium text-cyan-700 hover:text-cyan-900"> View all </a>
                    </div>
                </div>
            </div>

            <div class="bg-white overflow-hidden shadow rounded-lg">
                <div class="p-5">
                    <div class="flex items-center">
                        <div class="flex-shrink-0">
                            <!-- Heroicon name: outline/scale -->
                            <svg width="32px" height="32px" viewBox="0 0 32 32" style="fill-rule:evenodd;clip-rule:evenodd;stroke-linejoin:round;stroke-miterlimit:2;" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:serif="http://www.serif.com/" xmlns:xlink="http://www.w3.org/1999/xlink"><g transform="matrix(1,0,0,1,-96,-48)"><g transform="matrix(1.13043,0,0,1.13043,-16.3043,-7.78261)"><circle cx="113.5" cy="63.5" r="11.5" style="fill:rgb(144,224,239);"/></g><path d="M112,50C104.273,50 98,56.273 98,64C98,71.727 104.273,78 112,78C119.727,78 126,71.727 126,64C126,56.273 119.727,50 112,50ZM112,52C118.623,52 124,57.377 124,64C124,70.623 118.623,76 112,76C105.377,76 100,70.623 100,64C100,57.377 105.377,52 112,52ZM116.356,66.032C117.442,66.229 118.165,67.27 117.968,68.356C117.771,69.442 116.73,70.165 115.644,69.968C114.558,69.771 113.835,68.73 114.032,67.644C114.229,66.558 115.27,65.835 116.356,66.032ZM116.293,58.293L106.293,68.293C105.903,68.683 105.903,69.317 106.293,69.707C106.683,70.097 107.317,70.097 107.707,69.707L117.707,59.707C118.097,59.317 118.097,58.683 117.707,58.293C117.317,57.903 116.683,57.903 116.293,58.293ZM108.356,58.032C109.442,58.229 110.165,59.27 109.968,60.356C109.771,61.442 108.73,62.165 107.644,61.968C106.558,61.771 105.835,60.73 106.032,59.644C106.229,58.558 107.27,57.835 108.356,58.032Z" style="fill:rgb(25,144,167);"/></g></svg>

                        </div>
                        <div class="ml-5 w-0 flex-1">
                            <dl>
                                <dt class="text-sm font-medium text-gray-500 truncate">Promotion Accepter</dt>
                                <dd>
                                    <div class="text-lg font-medium text-gray-900"><%=allpromotionAccepter.size()%></div>
                                </dd>
                            </dl>
                        </div>
                    </div>
                </div>
                <div class="bg-gray-50 px-5 py-3">
                    <div class="text-sm">
                        <a href="#" class="font-medium text-cyan-700 hover:text-cyan-900"> View all </a>
                    </div>
                </div>
            </div>

            <div class="bg-white overflow-hidden shadow rounded-lg">
                <div class="p-5">
                    <div class="flex items-center">
                        <div class="flex-shrink-0">
                            <!-- Heroicon name: outline/scale -->
                            <svg width="32px" height="32px" viewBox="0 0 32 32" style="fill-rule:evenodd;clip-rule:evenodd;stroke-linejoin:round;stroke-miterlimit:2;" version="1.1" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:serif="http://www.serif.com/" xmlns:xlink="http://www.w3.org/1999/xlink"><g transform="matrix(1,0,0,1,-96,-48)"><g transform="matrix(1.13043,0,0,1.13043,-16.3043,-7.78261)"><circle cx="113.5" cy="63.5" r="11.5" style="fill:rgb(144,224,239);"/></g><path d="M112,50C104.273,50 98,56.273 98,64C98,71.727 104.273,78 112,78C119.727,78 126,71.727 126,64C126,56.273 119.727,50 112,50ZM112,52C118.623,52 124,57.377 124,64C124,70.623 118.623,76 112,76C105.377,76 100,70.623 100,64C100,57.377 105.377,52 112,52ZM116.356,66.032C117.442,66.229 118.165,67.27 117.968,68.356C117.771,69.442 116.73,70.165 115.644,69.968C114.558,69.771 113.835,68.73 114.032,67.644C114.229,66.558 115.27,65.835 116.356,66.032ZM116.293,58.293L106.293,68.293C105.903,68.683 105.903,69.317 106.293,69.707C106.683,70.097 107.317,70.097 107.707,69.707L117.707,59.707C118.097,59.317 118.097,58.683 117.707,58.293C117.317,57.903 116.683,57.903 116.293,58.293ZM108.356,58.032C109.442,58.229 110.165,59.27 109.968,60.356C109.771,61.442 108.73,62.165 107.644,61.968C106.558,61.771 105.835,60.73 106.032,59.644C106.229,58.558 107.27,57.835 108.356,58.032Z" style="fill:rgb(25,144,167);"/></g></svg>
                        </div>
                        <div class="ml-5 w-0 flex-1">
                            <dl>
                                <dt class="text-sm font-medium text-gray-500 truncate">Promotion Refuser</dt>
                                <dd>
                                    <div class="text-lg font-medium text-gray-900"><%=allpromotionRefuser.size()%></div>
                                </dd>
                            </dl>
                        </div>
                    </div>
                </div>
                <div class="bg-gray-50 px-5 py-3">
                    <div class="text-sm">
                        <a href="#" class="font-medium text-cyan-700 hover:text-cyan-900"> View all </a>
                    </div>
                </div>
            </div>
        </div>
    </div>


<jsp:include page="../Components/Admin/Table.jsp"/>
</div>
</body>
</html>
