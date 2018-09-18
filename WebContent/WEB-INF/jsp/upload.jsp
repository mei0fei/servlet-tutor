<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
    Choose a file: 
    <input type="file" name="multiPartServlet" />
    <input type="file" name="multiPartServlet2" />
    <input type="file" name="multiPartServlet3" />
    <input type="submit" value="Upload" />
</form>

</body>
</html>
]