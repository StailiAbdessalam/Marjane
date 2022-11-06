<%--
  Created by IntelliJ IDEA.
  User: abdessalm staili
  Date: 11/2/2022
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                Name
              </th>
              <th
                      class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase bg-gray-100 border-b border-gray-200"
              >
                Title
              </th>
              <th
                      class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase bg-gray-100 border-b border-gray-200"
              >
                Status
              </th>
              <th
                      class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase bg-gray-100 border-b border-gray-200"
              >
                Role
              </th>
              <th
                      class="px-6 py-3 bg-gray-100 border-b border-gray-200"
              ></th>
            </tr>
            </thead>

            <tbody class="bg-white">
            <tr v-for="(u, index) in wideTableData" :key="index">
              <td
                      class="px-6 py-4 border-b border-gray-200 whitespace-nowrap"
              >
                <div class="flex items-center">
                  <div class="flex-shrink-0 w-10 h-10">
                    <img
                            class="w-10 h-10 rounded-full"
                            src="https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80"
                            alt="profile pic"
                    />
                  </div>

                  <div class="ml-4">
                    <div
                            class="text-sm font-medium leading-5 text-gray-900"
                    >
                      {{ u.name }}
                    </div>
                    <div class="text-sm leading-5 text-gray-500">
                      {{ u.email }}
                    </div>
                  </div>
                </div>
              </td>

              <td
                      class="px-6 py-4 border-b border-gray-200 whitespace-nowrap"
              >
                <div class="text-sm leading-5 text-gray-900">
                  {{ u.title }}
                </div>
                <div class="text-sm leading-5 text-gray-500">
                  {{ u.title2 }}
                </div>
              </td>

              <td
                      class="px-6 py-4 border-b border-gray-200 whitespace-nowrap"
              >
                    <span
                            class="inline-flex px-2 text-xs font-semibold leading-5 text-green-800 bg-green-100 rounded-full"
                    >{{ u.status }}</span
                    >
              </td>

              <td
                      class="px-6 py-4 text-sm leading-5 text-gray-500 border-b border-gray-200 whitespace-nowrap"
              >
                {{ u.role }}
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
                        <form method="POST">
                          <button class="mx-2 px-2 rounded-md" >
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
            </tbody>
          </table>
        </div>
      </div>
    </div>
</body>
</html>
