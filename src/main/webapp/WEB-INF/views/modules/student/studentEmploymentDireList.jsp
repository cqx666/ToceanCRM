<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>就业管理</title>
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
		<li class="active"><a href="${ctx}/student/studentEmploymentDire/">当前功能>>>就业列表</a></li>
		<shiro:hasPermission name="student:studentEmploymentDire:edit"><li><a href="${ctx}/student/studentEmploymentDire/form">就业添加</a></li></shiro:hasPermission>
	</ul>
	<%--@elvariable id="studentEmploymentDire" type="act"--%>
	<form:form id="searchForm" modelAttribute="studentEmploymentDire" action="${ctx}/student/studentEmploymentDire/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnadd" class="btn btn-primary" type="submit" value="新增"/></li>
			<li class="btns"><input id="btndelete" class="btn btn-primary" type="submit" value="删除"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>修改时间</th>
				<shiro:hasPermission name="student:studentEmploymentDire:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="studentEmploymentDire">
			<tr>
				<td><a href="${ctx}/student/studentEmploymentDire/form?id=${studentEmploymentDire.id}">
					<fmt:formatDate value="${studentEmploymentDire.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<shiro:hasPermission name="student:studentEmploymentDire:edit"><td>
    				<a href="${ctx}/student/studentEmploymentDire/form?id=${studentEmploymentDire.id}">修改</a>
					<a href="${ctx}/student/studentEmploymentDire/delete?id=${studentEmploymentDire.id}" onclick="return confirmx('确认要删除该就业吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>