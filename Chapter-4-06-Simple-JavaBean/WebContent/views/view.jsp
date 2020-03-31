<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightyellow">
<h1> Browsing the JavaBean </h1>

<jsp:useBean id="lapTop" class="be.bt.beans.Product" scope="request"
            ></jsp:useBean>
    
 <h2>The product is described below </h2>            
 <ul>
     <li> Model :  <b><jsp:getProperty  name="lapTop" property="name" />  </b> 
     <li> Price :  <b><jsp:getProperty  name="lapTop" property="price" />  </b>
 </ul>             

</body>
</html>