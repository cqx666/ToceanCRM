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
	<form:form id="searchForm" modelAttribute="studentEmploymentLoca" action="${ctx}/student/studentEmploymentLoca/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>修改时间</th>
				<shiro:hasPermission name="student:studentEmploymentLoca:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="studentEmploymentLoca">
			<tr>
				<td><a href="${ctx}/student/studentEmploymentLoca/form?id=${studentEmploymentLoca.id}">
					<fmt:formatDate value="${studentEmploymentLoca.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<shiro:hasPermission name="student:studentEmploymentLoca:edit"><td>
    				<a href="${ctx}/student/studentEmploymentLoca/form?id=${studentEmploymentLoca.id}">修改</a>
					<a href="${ctx}/student/studentEmploymentLoca/delete?id=${studentEmploymentLoca.id}" onclick="return confirmx('确认要删除该就业地点吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>