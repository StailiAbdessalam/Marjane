<%@ page import="Models.Centreadmin" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: abdessalm staili
  Date: 10/30/2022
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<% List<Centreadmin> Allcenteradmin = (ArrayList<Centreadmin>)request.getAttribute("Allcenteradmin");%>

<div class="overflow-x-auto relative shadow-md sm:rounded-lg mt-[60px]">
  <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
    <thead class="text-xs text-gray-700 uppercase dark:text-gray-400">
    <tr>
      <th scope="col" class="py-3 px-6 bg-gray-50 dark:bg-gray-800">
        Id
      </th>
      <th scope="col" class="py-3 px-6 bg-gray-50 dark:bg-gray-800">
        Full Name
      </th>
      <th scope="col" class="py-3 px-6">
        Email
      </th>
    </tr>
    </thead>
    <tbody>
    <%for(Centreadmin centerAdmin:Allcenteradmin){%>
    <tr class="border-b border-gray-200 dark:border-gray-700">
      <td scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap bg-gray-50 dark:text-white dark:bg-gray-800">
        <%=centerAdmin.getId()%>
      </td>
      <td class="py-4 px-6">
        <%=centerAdmin.getCafullname()%>
      </td>
      <td class="py-4 px-6 bg-gray-50 dark:bg-gray-800">
        <%=centerAdmin.getCaemail()%>
      </td>
    </tr>
    <%}%>
    </tbody>
  </table>
</div>

</body>
</html>
