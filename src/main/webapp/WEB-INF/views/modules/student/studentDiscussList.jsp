<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>讨论管理</title>
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
		<li class="active"><a href="${ctx}/student/studentDiscuss/">讨论管理</a></li>
		<shiro:hasPermission name="student:studentDiscuss:edit"><li><a href="${ctx}/student/studentDiscuss/form">讨论添加</a></li></shiro:hasPermission>
	</ul>
	<%--@elvariable id="studentDiscuss" type="act"--%>
	<form:form id="searchForm" modelAttribute="studentDiscuss" action="${ctx}/student/studentDiscuss/" method="post" class="breadcrumb form-search">
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
			<tr><th colspan="9">分组讨论信息列表</th></tr>
			<tr>
				<td><input type="checkbox"/></td>
				<td>序号</td>
				<td>班级</td>
				<td>小组</td>
				<td>讨论日期</td>
				<td>讨论内容</td>
				<td>项目经理</td>
				<td>评价</td>
				<td>评分</td>
				<shiro:hasPermission name="student:studentDiscuss:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="studentDiscuss">
			<tr>
				<shiro:hasPermission name="student:studentDiscuss:edit"><td>
    				<a href="${ctx}/student/studentDiscuss/form?id=${studentDiscuss.id}">修改</a>
					<a href="${ctx}/student/studentDiscuss/delete?id=${studentDiscuss.id}" onclick="return confirmx('确认要删除该讨论吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>