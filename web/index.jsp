<%--
  Created by IntelliJ IDEA.
  User: DingXin
  Date: 2019/1/16
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 角色为：
  <span th:text="${role.roleName}"></span>
  <span th:if="${role.roleName}=='ADMIN'">
    管理员
  </span>
  <ul>
    <li th:each="r:${roles}">
      <span th:text="${r}"></span>
    </li>
  </ul>
  </body>
</html>
