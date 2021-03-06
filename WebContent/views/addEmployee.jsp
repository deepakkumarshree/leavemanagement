<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Spring MVC Form Handling</title>
 </head>
 <body>
  <h2>Add Employee Data</h2>
  <form:form method="POST" action="/leavemanagement/save" modelAttribute="userForm" >
      <table>
      
       <tr>
           <td><form:label path="id">Employee ID:</form:label></td>
           <td><form:input path="id" value="${employee.id}" /></td>
           <td align="left"><form:errors path="id" class="control-label"/></td>
       </tr>
       <tr>
           <td><form:label path="firstname">Employee first Name:</form:label></td>
           <td><form:input path="firstname" value="${employee.firstname}"/></td>
            <td align="left"><form:errors path="firstname" class="control-label"/></td>
       </tr>
       <tr>
           <td><form:label path="middlename">Employee middle Name:</form:label></td>
           <td><form:input path="middlename" value="${employee.middlename}"/></td>
       </tr>
       <tr>
           <td><form:label path="lastname">Employee last Name:</form:label></td>
           <td><form:input path="lastname" value="${employee.lastname}"/></td>
           <td align="left"><form:errors path="firstname" class="control-label"/></td>
       </tr>
       <tr>
           <td><form:label path="mailId">Employee Email ID:</form:label></td>
           <td><form:input path="mailId" value="${employee.mailId}"/></td>
       </tr>
       <tr>
           <td><form:label path="address">Employee Address:</form:label></td>
                    <td><form:input path="address" value="${employee.address}"/></td>
       </tr>
       <tr>
           <td><form:label path="supervisor">Employee Supervisor Name:</form:label></td>
           <td><form:input path="supervisor" value="${employee.supervisor}"/></td>
       </tr>
          <tr>
         <td colspan="2"><input type="submit" value="Submit"/></td>
        </tr>
   </table> 
  </form:form>
  
<%--   <c:if test="${!empty employees}">
  <h2>List Employees</h2>
 <table align="left" border="1">
  <tr>
   <th>Employee ID</th>
   <th>Employee Name</th>
   <th>Employee Age</th>
   <th>Employee Salary</th>
   <th>Employee Address</th>
           <th>Actions on Row</th>
  </tr>

  <c:forEach items="${employees}" var="employee">
   <tr>
    <td><c:out value="${employee.id}"/></td>
    <td><c:out value="${employee.name}"/></td>
    <td><c:out value="${employee.age}"/></td>
    <td><c:out value="${employee.salary}"/></td>
    <td><c:out value="${employee.address}"/></td>
    <td align="center"><a href="edit.html?id=${employee.id}">Edit</a> | <a href="delete.html?id=${employee.id}">Delete</a></td>
   </tr>
  </c:forEach> 
 </table>
</c:if>  --%>

 </body>
</html>