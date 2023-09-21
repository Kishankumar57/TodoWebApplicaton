
    <%@ include file ="common/header.jspf" %>
	<%@ include file ="common/navigation.jspf" %>
	<div class="container">

		<div>
			<h3>Enter your Todo</h3>
			<form:form method="post" modelAttribute="todo">

				<fieldset class="mb-3">
					<form:label path="description"> Description</form:label>
					<form:input type="text" name="description" path="description"
						required="required" />
					<form:errors path="description" cssClass="text-warning" />
				</fieldset>

				<fieldset class="mb-3">
					<form:label path="targetDate"> TargetDate</form:label>
					<form:input type="text" path="targetDate" required="required" />
					<form:errors path="targetDate" cssClass="text-warning" />
				</fieldset>

				<form:input type="hidden" name="description" path="done" />
				<form:input type="hidden" name="description" path="id" />

				<input type="submit" class="btn btn-success" />
			</form:form>
		</div>
	</div>
	<%@ include file ="common/footer.jspf" %>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'yyyy-mm-dd'
		});
	</script>

