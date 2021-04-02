<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/main.js" />"></script>
<title>Customer Management Screen</title>
</head>
<body>

	<div class="parent">
		<div class="origin">
			<div>
				<c:forEach var="position" items="${listPosition}">
					<!-- p style='position: absolute; top:${position.pos_yo}px;left:${position.pos_xo}px'  draggable="true" id="dragtarget" >${position.panel_name}</p -->
					<p id="${position.panel_name}" class="draggable" draggable="true"
						ondragstart="onDragStart(event);">${position.panel_name}</p>

				</c:forEach>
				A
			</div>
		</div>

		<div class="dropzone" ondragover="onDragOver(event);"
			ondrop="onDrop(event);">B</div>
	</div>

</body>
</html>