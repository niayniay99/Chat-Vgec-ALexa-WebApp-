<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>AI based Banking | Add Event Information</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.addons.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/jquery.toast.min.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/images/favicon.png" />
</head>

<body>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->


		<jsp:include page="header.jsp"></jsp:include>


		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->


			<jsp:include page="menu.jsp"></jsp:include>



			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
					<div class="row grid-margin">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Add Event Information</h4>
									<f:form class="cmxform" id="commentForm" method="post"
										action="saveEventtypeinfo" modelAttribute="EventtypeinfoVO"
										onsubmit="return addBranch()">
										<fieldset>

											<div class="form-group">
												<label for="cname">Event Name</label>
												<f:select path="eventtypeVO.eventtypeid" class="form-control"
													id="selectArea">
													<option selected="selected" value="none"
														disabled="disabled">Select Event</option>
													<c:forEach items="${eventtypeList}" var="i">
														<option value="${i.eventtypeid}">${i.eventName}</option>
													</c:forEach>

												</f:select>
											</div>

											<div class="form-group">
												<label for="cname">Cost Of Event</label>
												<f:input id="costofEvent" class="form-control"
													name="costofEvent" type="text" path="costofEvent"
													onkeypress='return event.charCode>=65 && event.charCode<=90 || event.charCode>=97 && event.charCode<=122 || event.charCode==32' />
											</div>

											<div class="form-group">
												<label for="cname">Time Duration</label>
												<f:input id="timeDuration" class="form-control"
													name="timeDuration" type="text" path="timeDuration"
													onkeypress='return event.charCode>=65 && event.charCode<=90 || event.charCode>=97 && event.charCode<=122 || event.charCode==32' />
											</div>
											
											<div class="form-group">
												<label for="cname">Faculty Coordinator</label>
												<f:input id="facultyCoordinator" class="form-control"
													name="facultyCoordinator" type="text" path="facultyCoordinator"
													onkeypress='return event.charCode>=65 && event.charCode<=90 || event.charCode>=97 && event.charCode<=122 || event.charCode==32' />
											</div>
											
											<div class="form-group">
												<label for="cname">Student Coordinator</label>
												<f:input id="studentCoordinator" class="form-control"
													name="studentCoordinator" type="text" path="studentCoordinator"
													onkeypress='return event.charCode>=65 && event.charCode<=90 || event.charCode>=97 && event.charCode<=122 || event.charCode==32' />
											</div>
											
											<f:hidden path="eventtypeinfoid" />
											<input class="btn btn-primary" type="submit" value="Submit">
										</fieldset>
									</f:form>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- content-wrapper ends -->
				<!-- partial:../../partials/_footer.html -->

				<jsp:include page="footer.jsp"></jsp:include>

				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.base.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.addons.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script src="<%=request.getContextPath()%>/adminResources/js/off-canvas.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/hoverable-collapse.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/template.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/settings.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="<%=request.getContextPath()%>/adminResources/js/bt-maxLength.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/jquery.toast.min.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/toaster.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/custom/customValidation.js"></script>

	<!-- End custom js for this page-->
</body>

</html>
