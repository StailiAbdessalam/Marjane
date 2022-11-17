<%@ page import="java.util.List" %>
<%@ page import="Models.Promotion" %>
<%@ page import="Models.Centreadmin" %>
<%@ page import="Models.Manager" %><%--
  Created by IntelliJ IDEA.
  User: abdessalm staili
  Date: 11/14/2022
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0);
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/daisyui@2.37.0/dist/full.css" rel="stylesheet" type="text/css"/>

<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
    <script defer src="https://unpkg.com/alpinejs@3.10.4/dist/cdn.min.js"></script>
    <link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.dataTables.min.css" rel="stylesheet">
    <style>
        /*Overrides for Tailwind CSS */
        /*Form fields*/
        .dataTables_wrapper select,
        .dataTables_wrapper .dataTables_filter input {
            color: #4a5568;
            /*text-gray-700*/
            padding-left: 1rem;
            /*pl-4*/
            padding-right: 1rem;
            /*pl-4*/
            padding-top: .5rem;
            /*pl-2*/
            padding-bottom: .5rem;
            /*pl-2*/
            line-height: 1.25;
            /*leading-tight*/
            border-width: 2px;
            /*border-2*/
            border-radius: .25rem;
            border-color: #edf2f7;
            /*border-gray-200*/
            background-color: #edf2f7;
            /*bg-gray-200*/
        }
        /*Row Hover*/
        table.dataTable.hover tbody tr:hover,
        table.dataTable.display tbody tr:hover {
            background-color: #ebf4ff;
            /*bg-indigo-100*/
        }
        /*Pagination Buttons*/
        .dataTables_wrapper .dataTables_paginate .paginate_button {
            font-weight: 700;
            /*font-bold*/
            border-radius: .25rem;
            /*rounded*/
            border: 1px solid transparent;
            /*border border-transparent*/
        }
        /*Pagination Buttons - Current selected */
        .dataTables_wrapper .dataTables_paginate .paginate_button.current {
            color: #fff !important;
            /*text-white*/
            box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .1), 0 1px 2px 0 rgba(0, 0, 0, .06);
            /*shadow*/
            font-weight: 700;
            /*font-bold*/
            border-radius: .25rem;
            /*rounded*/
            background: #667eea !important;
            /*bg-indigo-500*/
            border: 1px solid transparent;
            /*border border-transparent*/
        }
        /*Pagination Buttons - Hover */
        .dataTables_wrapper .dataTables_paginate .paginate_button:hover {
            color: #fff !important;
            /*text-white*/
            box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .1), 0 1px 2px 0 rgba(0, 0, 0, .06);
            /*shadow*/
            font-weight: 700;
            /*font-bold*/
            border-radius: .25rem;
            /*rounded*/
            background: #667eea !important;
            /*bg-indigo-500*/
            border: 1px solid transparent;
            /*border border-transparent*/
        }
        /*Add padding to bottom border */
        table.dataTable.no-footer {
            border-bottom: 1px solid #e2e8f0;
            /*border-b-1 border-gray-300*/
            margin-top: 0.75em;
            margin-bottom: 0.75em;
        }
        /*Change colour of responsive icon*/
        table.dataTable.dtr-inline.collapsed>tbody>tr>td:first-child:before,
        table.dataTable.dtr-inline.collapsed>tbody>tr>th:first-child:before {
            background-color: #667eea !important;
            /*bg-indigo-500*/
        }
    </style>
</head>

<%
    List<Promotion> allpromotion = (List<Promotion>) request.getAttribute("allpromotion");
    Manager profile = (Manager) request.getAttribute("profile");
%>
<body>
<jsp:include page="../Components/Manager/Header_Manager.jsp"/>
    <div class="flex flex-col flex-1 mt-[100px]">
        <main class="flex-1 pb-8">
            <!-- Page header -->
            <div class="bg-white shadow">
                <div class="px-4 sm:px-6 lg:max-w-6xl lg:mx-auto lg:px-8">
                    <div class="py-6 md:flex md:items-center md:justify-between lg:border-t lg:border-gray-200">
                        <div class="flex-1 min-w-0">
                            <!-- Profile -->
                            <div class="flex items-center">
                                <img class="hidden h-16 w-16 rounded-full sm:block" src="https://help.apple.com/assets/6171BC0AA6FD916CFE7F2466/6171BC0BA6FD916CFE7F246D/en_US/a680a1fa3ff752496abe814aade94e39.png" alt="">
                                <div>
                                    <div class="flex items-center">
                                        <img class="h-16 w-16 rounded-full sm:hidden" src="https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2.6&w=256&h=256&q=80" alt="">
                                        <h1 class="ml-3 text-2xl font-bold leading-7 text-gray-900 sm:leading-9 sm:truncate">Bonjour <%=profile.getMfullname()%> </h1>
                                    </div>
                                    <div class="mt-6 flex flex-col sm:ml-3 sm:mt-1 sm:flex-row sm:flex-wrap">
                                        <dt class="sr-only">Company</dt>
                                        <div class="flex items-center text-sm text-gray-500 font-medium capitalize sm:mr-6">
                                            <!-- Heroicon name: solid/office-building -->
                                            <svg class="flex-shrink-0 mr-1.5 h-5 w-5 text-gray-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                                <path fill-rule="evenodd" d="M4 4a2 2 0 012-2h8a2 2 0 012 2v12a1 1 0 110 2h-3a1 1 0 01-1-1v-2a1 1 0 00-1-1H9a1 1 0 00-1 1v2a1 1 0 01-1 1H4a1 1 0 110-2V4zm3 1h2v2H7V5zm2 4H7v2h2V9zm2-4h2v2h-2V5zm2 4h-2v2h2V9z" clip-rule="evenodd" />
                                            </svg>
                                            <%=profile.getMemail()%>
                                        </div>
                                        <div class="sr-only">Account status</div>
                                        <div class="mt-3 flex items-center text-sm text-gray-500 font-medium sm:mr-6 sm:mt-0 capitalize">
                                            <!-- Heroicon name: solid/check-circle -->
                                            <svg class="flex-shrink-0 mr-1.5 h-5 w-5 text-green-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                                <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd" />
                                            </svg>
                                            account Active
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="mt-6 flex space-x-3 md:mt-0 md:ml-4">
                            <button type="button" class="inline-flex items-center px-4 py-2 border border-gray-300 shadow-sm text-sm font-medium rounded-md text-gray-700 bg-white hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-cyan-500">Edit accout</button>
                            <button type="button" class="inline-flex items-center px-4 py-2 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-cyan-600 hover:bg-cyan-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-cyan-500">démissionner</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="mt-8">

                <div  class="px-2 w-full  h-screen">
                    <!--Title-->
                    <h1 class="flex items-center justify-center font-sans font-bold break-normal text-indigo-500 px-2 py-8 text-xl md:text-2xl">
                        All Promotion
                    </h1>
                    <!--Card-->
                    <div id='recipients' class="p-8 mt-6 lg:mt-0 rounded shadow bg-white">
                        <table id="example" class="stripe hover" style="width:100%; padding-top: 1em;  padding-bottom: 1em;">
                            <thead>
                                    <tr>
                                        <th class="px-6 py-3 bg-gray-50 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Description</th>
                                        <th class="px-6 py-3 bg-gray-50 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Action</th>
                                        <th class="px-6 py-3 bg-gray-50 text-right text-xs font-medium text-gray-500 uppercase tracking-wider">Porsentage</th>
                                        <th class="px-6 py-3 bg-gray-50 text-right text-xs font-medium text-gray-500 uppercase tracking-wider">Status</th>
                                        <th class="px-6 py-3 bg-gray-50 text-right text-xs font-medium text-gray-500 uppercase tracking-wider">Date Expiration</th>
                                    </tr>
                            </thead>
                            <% if(allpromotion==null){%>
                            <tbody></tbody>
                            <%}%>
                            <% if(allpromotion!=null){%>
                            <tbody>
                            <% for (Promotion promotion : allpromotion){%>
                            <tr class="bg-white">
                                            <td class="max-w-0 w-full px-6 py-4 whitespace-nowrap text-sm text-gray-900">
                                                <div class="flex">
                                                        <svg class="flex-shrink-0 h-5 w-5 text-gray-400 group-hover:text-gray-500" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                                            <path fill-rule="evenodd" d="M4 4a2 2 0 00-2 2v4a2 2 0 002 2V6h10a2 2 0 00-2-2H4zm2 6a2 2 0 012-2h8a2 2 0 012 2v4a2 2 0 01-2 2H8a2 2 0 01-2-2v-4zm6 4a2 2 0 100-4 2 2 0 000 4z" clip-rule="evenodd" />
                                                        </svg>
                                                        <p class="ml-4 text-gray-500 truncate group-hover:text-gray-900"><%=promotion.getDescription()%></p>
                                                </div>
                                            </td>
                                            <td>
                                                <% if (!promotion.getPStatus().equals("Pending")){%>
                                                <%}%>
                                                <%if (promotion.getPStatus().equals("Pending")){%>
                                                <div class="flex">
                                                    <label for="my-modal-3" class="btn bg-green-100 text-green-700">Accept</label>
                                                    <label for="my-modal-2" class="btn bg-red-100 text-red-700">Rejecter</label>
                                                </div>
                                                <!-- Put this part before </body> tag -->
                                                <input type="checkbox" id="my-modal-3" class="modal-toggle"/>
                                               <div class="modal">
                                                    <div class="modal-box relative">
                                                        <label for="my-modal-3"
                                                               class="btn btn-sm btn-circle absolute right-2 top-2">✕</label>
                                                        <h3>Are you sure you want to accept this promotion?</h3>
                                                        <form action="acceptPromotion.manager" method="post">
                                                            <input type="hidden" name="id"
                                                                   value="<%=promotion.getId()%>">
                                                            <button type="submit"
                                                                    class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                                                            >
                                                                Accept
                                                            </button>
                                                        </form>
                                                    </div>
                                                </div>
                                                <input type="checkbox" id="my-modal-2" class="modal-toggle"/>
                                                <div class="modal">
                                                    <div class="modal-box relative">
                                                        <label for="my-modal-2"
                                                               class="btn btn-sm btn-circle absolute right-2 top-2">✕</label>
                                                        <h3>why you want to rejected these promotion ?</h3>
                                                        <form action="rejecterpromotion.manager" method="post">
                                                            <input type="hidden" name="id"
                                                                   value="<%=promotion.getId()%>">
                                                            <button type="submit"
                                                                    class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                                                            >
                                                                Rejecter
                                                            </button>
                                                        </form>

                                                    </div>
                                                </div>
                                                <%}%>
                                            </td>
                                            <td class="px-6 py-4 text-right whitespace-nowrap text-sm text-gray-500">
                                                <span class="text-gray-900 font-medium flex justify-center"><%=promotion.getPPoint()%><span> %</span></span>
                                            </td>
                                            <td class=" flex justify-center hidden px-6 py-4 whitespace-nowrap text-sm text-gray-500 md:block">
                                                <span class=" status inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-medium capitalize"><%=promotion.getPStatus()%></span>
                                            </td>
                                            <td class="px-6 py-4 text-right whitespace-nowrap text-sm text-gray-500">
                                                <time datetime="2020-07-11"><%=promotion.getDatExpire()%></time>
                                            </td>
                                        </tr>
                                        <%}%>
                            </tbody>
                            <%}%>
                        </table>
                    </div>
                </div>
            </div>
        </main>
<%--    </div>--%>
<%--</div>--%>

<script>
    const status = document.querySelectorAll('.status');
    status.forEach((status) => {
        if (status.innerText === 'Accepter') {
            status.classList.add('bg-green-100', 'text-green-700')
        } else if (status.innerText === 'Pending') {
            status.classList.add('bg-yellow-100', 'text-yellow-700')
        } else if (status.innerText === 'Refuser') {
            status.classList.add('bg-red-100', 'text-red-700')
        }
    })
</script>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>
<script>
    $(document).ready(function() {
        var table = $('#example').DataTable({
            responsive: true
        })
            .columns.adjust()
            .responsive.recalc();
    });
</script>
</body>
</html>
