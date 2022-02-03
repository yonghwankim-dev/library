<%@include file="./views/config/jstl.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>통합 도서관</title>
    <link rel="stylesheet" href="/Library/resources/css/reset/reset.css">
   	<link rel="stylesheet" href="/Library/resources/css/home/index.css">	
</head>
<body>
	<!-- header section -->	
	<c:import url="./views/common/header.jsp">
		<c:param name="member" value="${member}"/>
	</c:import>
	
	
    <!-- nav section -->
    <c:import url="./views/home/nav.jsp"/>
    
    <!-- main section -->
    <c:import url="./views/home/main.jsp">
    	<c:param name="books" value="${books}"/>
    	<c:param name="library" value="${library}"/>
    </c:import>
    
    <script type="module" src="/Library/resources/js/home/index.js"></script>
    
</body>

</html>