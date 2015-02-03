<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<nav>
	<ul>
		<li><a href="<c:url value='/' />">${menu_home}</a></li>
		<li><a href="#">${menu_tab_one}</a>
			<ul>
				<li><a href="#">${menu_tab_one_1}</a></li>
				<li><a href="#">${menu_tab_one_2}</a></li>
				<li><a href="#">${menu_tab_one_3}</a>
					<ul>
						<li><a href="#">HTML</a></li>
						<li><a href="#">CSS</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li><a href="#">${menu_tab_two}</a>
			<ul>
				<li><a href="#">${menu_tab_one_1}</a></li>
				<li><a href="#">${menu_tab_one_2}</a></li>
			</ul>
		</li>
		<li><a href="#">${menu_tab_three}</a></li>
	</ul>
	<ul class="menuLogin">
		<li><a href="#">${menu_sign_up}</a></li>
		<li><a href="#">${menu_login}</a></li>
	</ul>
</nav>