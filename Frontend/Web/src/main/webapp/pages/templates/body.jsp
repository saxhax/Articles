<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<style>
.body {
	background: ${template.background};
}
</style>
<body class="body">
	<div class="frame">
		<div class="leftAddition">
			<a href="?language=en"><img class="flag shadow" src="<c:url value='images/en.jpg'/>"></a>
			<a href="?language=ba"><img class="flag shadow" src="<c:url value='images/ba.jpg' />"></a>
			<a href="?language=de"><img class="flag shadow" src="<c:url value='images/de.jpg' />"></a>
			<a href="?language=hr"><img class="flag shadow" src="<c:url value='images/hr.jpg' />"></a>
			<a href="?language=rs"><img class="flag shadow" src="<c:url value='images/rs.jpg' />"></a>
			<div class="flag"></div>
			<a href="?template=red" class="flag red shadow"></a>
			<a href="?template=green" class="flag green shadow"></a>
			<a href="?template=blue" class="flag blue shadow"></a>
			<a href="?template=grey" class="flag grey shadow"></a>
			<a href="?template=white" class="flag white shadow"></a>
			
		</div>
		<div class="main">
			<div class="shadow margin">
				<jsp:include page="header.jsp" />
			</div>
			<div class="margin menu">
				<jsp:include page="menu.jsp" />
			</div>
			<div class="shadow margin center">
				<jsp:include page="main.jsp" />
			</div>
		</div>
		<div class="rightAddition">
			<div class="shadow rightLogin margin">
			</div>
			<div class="shadow rightLogin margin">
			</div>
			<div class="shadow rightLogin margin">
			</div>
			<div class="shadow rightLogin margin">
			</div>
		</div>
		<div class="shadow margin footer">
			<jsp:include page="footer.jsp" />
		</div>
	</div>
</body>