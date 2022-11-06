<%@ page import="Models.Centreadmin" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="Models.Manager" %><%--
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
<% List<Manager> AllManager = (ArrayList<Manager>)request.getAttribute("AllManager");%>

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
    <%for(Manager manager:AllManager){%>
    <tr class="border-b border-gray-200 dark:border-gray-700">
      <td scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap bg-gray-50 dark:text-white dark:bg-gray-800">
        <%=manager.getId()%>
      </td>
      <td class="py-4 px-6">
        <%=manager.getMfullname()%>
      </td>
      <td class="py-4 px-6 bg-gray-50 dark:bg-gray-800">
        <%=manager.getMemail()%>
      </td>
      <td
              class="px-6 py-4 text-sm font-medium leading-5 text-right border-b border-gray-200 whitespace-nowrap"
      >
        <div class="flex justify-around">
                      <span class="text-yellow-500 flex justify-center">
                        <a href="#" class="mx-2 px-2 rounded-md"
                        ><svg
                                xmlns="http://www.w3.org/2000/svg"
                                class="h-5 w-5 text-green-700"
                                viewBox="0 0 20 20"
                                fill="currentColor"
                        >
                            <path
                                    d="M17.414 2.586a2 2 0 00-2.828 0L7 10.172V13h2.828l7.586-7.586a2 2 0 000-2.828z"
                            />
                            <path
                                    fill-rule="evenodd"
                                    d="M2 6a2 2 0 012-2h4a1 1 0 010 2H4v10h10v-4a1 1 0 112 0v4a2 2 0 01-2 2H4a2 2 0 01-2-2V6z"
                                    clip-rule="evenodd"
                            />
                          </svg>
                        </a>
                        <form method="DELETE" action="AdminManagerList">
                          <input type="hidden" name="idmanager" value="<%=manager.getId()%>">
                          <button type="submit" class="mx-2 px-2 rounded-md">
                            <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    class="h-5 w-5 text-red-700"
                                    viewBox="0 0 20 20"
                                    fill="currentColor"
                            >
                              <path
                                      fill-rule="evenodd"
                                      d="M9 2a1 1 0 00-.894.553L7.382 4H4a1 1 0 000 2v10a2 2 0 002 2h8a2 2 0 002-2V6a1 1 0 100-2h-3.382l-.724-1.447A1 1 0 0011 2H9zM7 8a1 1 0 012 0v6a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v6a1 1 0 102 0V8a1 1 0 00-1-1z"
                                      clip-rule="evenodd"
                              />
                            </svg>
                          </button>
                        </form>
                      </span>
        </div>
      </td>
    </tr>
    <%}%>
    </tbody>
  </table>
</div>

</body>
</html>
