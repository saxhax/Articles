<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<style>
.body {
	background: ${template.background};
}
</style>
<body class="body">
	<div class="frame">
		<div class="shadow margin cap">
			<jsp:include page="cap.jsp" />
		</div>
		<div class="leftAddition">
			<jsp:include page="left.jsp" />
		</div>
		<div class="top">
			<div class="shadow margin header">
				<jsp:include page="header.jsp" />
			</div>
			<div class="margin menu">
				<jsp:include page="menu.jsp" />
			</div>
		</div>
		<div class="rightAddition">
			<jsp:include page="right.jsp" />
		</div>
		<div class="main margin">
			<div class="shadow center">
				<jsp:include page="main.jsp" />
			</div>
		</div>
		<div class="middle margin">
			<jsp:include page="middle.jsp" />
		</div>
		<div class="middle margin">
			<jsp:include page="middle2.jsp" />
		</div>
		<div class="shadow margin footer">
			<jsp:include page="footer.jsp" />
		</div>
		<div class="shadow margin footerLine">
			<jsp:include page="footerLine.jsp" />
		</div>
	</div>
</body>
