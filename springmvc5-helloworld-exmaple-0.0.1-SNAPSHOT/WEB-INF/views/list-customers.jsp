<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>list</title>
<link href='<c:url value="/resources/css/bootstrap.min.css" />' rel="stylesheet">
<script src='<c:url value="/resources/js/jquery-1.11.1.min.js" />' ></script>
<script src='<c:url value="/resources/js/bootstrap.min.css" />' ></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<input type="button" value="Add Customer"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" /> <br />
			<br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Employee List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Action</th>
						</tr>

						<!-- loop over and print our employees -->
						<c:forEach var="tempEmployee" items="${employees}">

							<!-- construct an "update" link with customer id -->
							<c:url var="updateLink" value="/employee/updateForm">
								<c:param name="employeeId" value="${tempEmployee.id}" />
							</c:url>

							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/employee/delete">
								<c:param name="employeeId" value="${tempEmployee.id}" />
							</c:url>

							<tr>
								<td>${tempEmployee.firstName}</td>
								<td>${tempEmployee.lastName}</td>
								<td>${tempEmployee.email}</td>

								<td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>

					</table>

				</div>
			</div>
		</div>

	</div>
</body>

</html>









