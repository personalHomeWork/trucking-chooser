<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>list-truck</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<div class="container">
	<table class="table table-striped">
	<caption>Your truck are</caption>
		<thead>
			<tr>
				<th>id</th>
				<th>no polisi</th>
			</tr>
		</thead>
		<tbody>			
			<c:forEach items="${listAllTruck}" var="truck">
				<tr>
					<td>${truck.id}</td>
					<td>${truck.nopol}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</div>
</body>
</html>