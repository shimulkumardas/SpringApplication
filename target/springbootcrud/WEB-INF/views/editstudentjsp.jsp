<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/css/bootstrap.css"     rel="stylesheet">
<link href="/css/custom.css"     rel="stylesheet">
<link href="/css/main.css"    rel="stylesheet">

</head>
<body>
	<div class="form-container">
	<h1>Edit Student Details</h1>
	<form:form method="POST" modelAttribute="student" commandName="student" class="form-horizontal" action="/editsave">
	<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-label" for="id"></label>
					<div class="col-md-7">
						<form:hidden path="id" class="form-control input-sm"/>
						<div class="has-error">
						
						</div>
					</div>
				</div>
	</div>
	<div class ="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-label" for="firstName">First Name</label>
				<div class="col-md-7">
					<form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="firstName" class="help-inline"/>
					</div>
				</div>
			</div>
	</div>
	
	<div class ="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-label" for="lastName">Last Name</label>
				<div class="col-md-7">
					<form:input type="text" path="lastName" id="lastName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="lastName" class="help-inline"/>
					</div>
				</div>
			</div>
	</div>
	
	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-label" for="sex">Sex</label>
			<div class="col-md-7" class="form-control input-sm">
				<form:radiobutton path=" sex" value="M"/>Male
				<form:radiobutton path="sex" value="F"/>Female
				<div class="has-error">
					<form:errors path="sex" class="help-inline"/>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-label" for="email">Email</label>
			<div class="col-md-7">
			<form:input type="text" path="email" id="email" class="form-control input-sm"/>
			<div class="has-errors">
				<form:errors path="email" class="help-inline"/>
 			</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-label" for="section">Section</label>
			<div class="col-md-7" class="form-control input-sm">
				<form:radiobuttons path="section" items="${sections}"/>
				<div class="has-error">
					<form:errors path="section" class="help-inline"/>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-label" for="country">Country</label>
			<div class="col-md-7" class="form-control input-sm">
				<form:select path="country" id="country" class="form-control input-sm">
					<form:option value="">Select Country</form:option>
					<form:options items="${countries}"/>
				</form:select>
				<div class="has-error">
					<form:errors path="country" class="help-inline"/>
				</div>
			</div>		
		</div>
	</div>
	
	<div class="row">
		<div class="form-actions floatRight">
			<input type="submit" value="Edit" class="btn btn-primary btn-sm">
		</div>
	</div>
	</form:form>
	</div>

</body>
</html>