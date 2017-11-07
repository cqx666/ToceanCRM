<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>作业布置管理</title>
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
		<li class="active"><a href="${ctx}/student/studentHomeworkItem/">作业布置列表</a></li>
		<shiro:hasPermission name="student:studentHomeworkItem:edit"><li><a href="${ctx}/student/studentHomeworkItem/form">作业布置添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="studentHomeworkItem" action="${ctx}/student/studentHomeworkItem/" method="post" class="breadcrumb form-search">
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
				<shiro:hasPermission name="student:studentHomeworkItem:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="studentHomeworkItem">
			<tr>
				<td><a href="${ctx}/student/studentHomeworkItem/form?id=${studentHomeworkItem.id}">
					<fmt:formatDate value="${studentHomeworkItem.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<shiro:hasPermission name="student:studentHomeworkItem:edit"><td>
    				<a href="${ctx}/student/studentHomeworkItem/form?id=${studentHomeworkItem.id}">修改</a>
					<a href="${ctx}/student/studentHomeworkItem/delete?id=${studentHomeworkItem.id}" onclick="return confirmx('确认要删除该作业布置吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>