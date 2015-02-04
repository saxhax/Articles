<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<div class="ads">
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
	<div class="flag"></div>
</div>