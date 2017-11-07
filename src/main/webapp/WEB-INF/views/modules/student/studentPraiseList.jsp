<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>表扬管理</title>
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
		<li class="active"><a href="${ctx}/student/studentPraise/">表扬列表</a></li>
		<shiro:hasPermission name="student:studentPraise:edit"><li><a href="${ctx}/student/studentPraise/form">表扬添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="studentPraise" action="${ctx}/student/studentPraise/" method="post" class="breadcrumb form-search">
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

				<shiro:hasPermission name="student:studentPraise:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="studentPraise">
			<tr>

				<td><a href="${ctx}/student/studentPraise/form?id=${studentPraise.id}">
					<fmt:formatDate value="${studentPraise.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>

				<shiro:hasPermission name="student:studentPraise:edit"><td>
    				<a href="${ctx}/student/studentPraise/form?id=${studentPraise.id}">修改</a>
					<a href="${ctx}/student/studentPraise/delete?id=${studentPraise.id}" onclick="return confirmx('确认要删除该表扬吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>