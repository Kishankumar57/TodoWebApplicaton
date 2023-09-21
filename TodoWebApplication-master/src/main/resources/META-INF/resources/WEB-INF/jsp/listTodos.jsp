
    <%@ include file ="common/header.jspf" %>
	<%@ include file ="common/navigation.jspf" %>
	<div class="container">

		<div>
			<h3>Todos</h3>
		</div>
		<table class="table">
			<thead>
				<tr>
					
					<th>Description</th>
					<th>TargetDate</th>
					<th>IsDone</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todo}" var="tod">
					<tr>
						
						<td>${tod.description}</td>
						<td>${tod.targetDate}</td>
						<td>${tod.done}</td>
						<td><a href="dlt-todo?id=${tod.id}" class="btn btn-warning">DELETE</a></td>
						<td><a href="update-todo?id=${tod.id}" class="btn btn-info">UPDATE</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>
       <%@ include file ="common/footer.jspf" %>
		