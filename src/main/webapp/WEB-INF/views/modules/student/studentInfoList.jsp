<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学生管理</title>
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
		<li class="active"><a href="${ctx}/student/studentInfo/">学生列表</a></li>
		<shiro:hasPermission name="student:studentInfo:edit"><li><a href="${ctx}/student/studentInfo/form">学生添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="studentInfo" action="${ctx}/student/studentInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>学生名字：</label>
				<form:input path="name" htmlEscape="false" maxlength="25" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>学生名字</th>
				<th>备注</th>
				<th>修改时间</th>
				<shiro:hasPermission name="student:studentInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="studentInfo">
			<tr>
				<td><a href="${ctx}/student/studentInfo/form?id=${studentInfo.id}">
					${studentInfo.name}
				</a></td>
				<td>
					${studentInfo.remarks}
				</td>
				<td>
					<fmt:formatDate value="${studentInfo.updatedate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="student:studentInfo:edit"><td>
    				<a href="${ctx}/student/studentInfo/form?id=${studentInfo.id}">修改</a>
					<a href="${ctx}/student/studentInfo/delete?id=${studentInfo.id}" onclick="return confirmx('确认要删除该学生吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>