<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Employee</h1>
       <form:form method="post" action="save" modelAttribute="emp">  
      	<table >  
      	<tr>  
          <td>Employee Id :</td>  
          <td><form:input  path="id" /></td>
         </tr> 
         <tr>
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>  
          <td>Location:</td>  
          <td><form:input path="location" /></td>
         </tr> 
         <tr>  
          <td>Phoneno :</td>  
          <td><form:input path="phoneno" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
