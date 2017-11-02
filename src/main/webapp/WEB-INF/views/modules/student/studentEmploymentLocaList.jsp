<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>就业地点管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/student/studentEmploymentLoca/">就业地点列表</a></li>
		<shiro:hasPermission name="student:studentEmploymentLoca:edit"><li><a href="${ctx}/student/studentEmploymentLoca/form">就业地点添加</a></li></shiro:hasPermission>
	</ul>
	<%--@elvariable id="studentEmploymentLoca" type="act"--%>
	<form:form id="searchForm" modelAttribute="studentEmploymentLoca" action="${ctx}/student/studentEmploymentLoca/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
				<input id="btnadd" class="btn btn-primary" type="submit" value="新增"/>
				<input id="btndelete" class="btn btn-primary" type="submit" value="删除"/>
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th colspan="3">就业推荐地点信息列表</th>
			</tr>
			<tr>
				<th><input type="checkbox"></th>
				<th>序号</th>
				<th>就业推荐地点</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="studentEmploymentLoca">
			<tr>
				<td><input type="checkbox" value="${studentEmploymentLoca.id}"/></td>
				<td>
					<c:set var="i" value="${i+1}"></c:set>
					<c:out value="${i}"></c:out>
				</td>
				<td>
					${studentEmploymentLoca.locaName}
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>