<%@ page import="java.util.List" %>
<%@ page import="Models.Promotion" %><%--
  Created by IntelliJ IDEA.
  User: abdessalm staili
  Date: 11/2/2022
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List< Promotion> allpromotion = (List<Promotion>) request.getAttribute("AllPromotion");
  int size = allpromotion.size();
%>
<html>
<head>
  <title>Title</title>
  <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>

<div class="flex flex-col mt-6">
  <div
          class="py-2 -my-2 overflow-x-auto sm:-mx-6 sm:px-6 lg:-mx-8 lg:px-8"
  >
    <div
            class="inline-block min-w-full overflow-hidden align-middle border-b border-gray-200 shadow sm:rounded-lg"
    >
      <table class="min-w-full">
        <thead>
        <tr>
          <th
                  class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase bg-gray-100 border-b border-gray-200"
          >
            Id
          </th>
          <th
                  class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase bg-gray-100 border-b border-gray-200"
          >
            Date
          </th>
          <th
                  class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase bg-gray-100 border-b border-gray-200"
          >
            Status
          </th>
          <th
                  class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase bg-gray-100 border-b border-gray-200"
          >
            Description

          </th>

        </tr>
        </thead>
        <tbody class="bg-white">
        <%for (Promotion promo : allpromotion){%>
        <tr>
          <td
                  class="px-6 py-4 border-b border-gray-200 whitespace-nowrap"
          >
            <div class="flex items-center">
              <div class="flex-shrink-0 w-10 h-10">
                <img
                        class="w-10 h-10 rounded-full"
                        src="../../assets/promotion.png"
                        alt="profile pic"
                />
              </div>

              <div class="ml-4">
                <div
                        class="text-sm font-medium leading-5 text-gray-900"
                >
                  <c:out value="<%=promo.getId()%>"></c:out>
                </div>
                <div class="text-sm leading-5 text-gray-500">
                  <%--                      <c:out value="<%=promo.getPCategorie().getTname()%>"></c:out>--%>
                </div>
              </div>
            </div>
          </td>
          <td
                  class="px-6 py-4 border-b border-gray-200 whitespace-nowrap"
          >
            <div class="text-sm leading-5 text-gray-900">
              <c:out value="<%=promo.getDateDebut()%>"></c:out>
            </div>
            <div class="text-sm leading-5 text-gray-500">
              <c:out value="<%=promo.getDatExpire()%>"></c:out>
            </div>
          </td>

          <td
                  class="px-6 py-4 border-b border-gray-200 whitespace-nowrap"
          >
                    <span class="status inline-flex px-2 text-xs font-semibold leading-5 rounded-full"
                    >
                    <c:out value="<%=promo.getPStatus()%>"></c:out>
                    </span
                    >
          </td>

          <td
                  class="px-6 py-4 text-sm leading-5 text-gray-500 border-b border-gray-200 whitespace-nowrap"
          >
            <c:out value="<%=promo.getDescription()%>"></c:out>
          </td>
        </tr>
        <%};%>
        </tbody>
      </table>
    </div>
  </div>
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
</div>
</body>
</html>
