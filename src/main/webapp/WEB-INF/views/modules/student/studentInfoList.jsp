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
	
		<%--@elvariable id="studentInfo" type=""--%>
		<form:form id="searchForm" modelAttribute="studentInfo" action="${ctx}/student/studentInfo/" method="post" class="breadcrumb form-search">
		<div>
			<label>班级：&nbsp;</label>
			<form:select path="" class="input-medium">
				<form:option value="" label="班级"/>
				<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</form:select>
			<label>学员：</label>
			<input id="beginDate"  name="beginDate"  type="text"  maxlength="20"  value=""/>
			&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<a href="${ctx}/student/studentInfo/form?id=${studentInfo.id}"  class="btn btn-primary">新增</a>
			<a href="${ctx}/student/studentInfo/delete?id=${studentInfo.id}" onclick="return confirmx('确认要删除该档案吗？', this.href)"  class="btn btn-primary">删除</a>
			<a href="${ctx}/student/studentInfo/form?id=${studentInfo.id}"  class="btn btn-primary">导入学员</a>
			</div>
		</form:form>


	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>序号</th>
				<th>学员名称 </th>
				<th>学号</th>
				<th>班级 </th>
				<th>性别</th>
				<th>学历 </th>
				<th>入学时联系电话 </th>
				<th>毕业时联系电话</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>修改时间</th>
				<shiro:hasPermission name="student:studentInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="studentInfo" varStatus="stauts">
			<tr>

				<td></td>
				<td><a href="${ctx}/student/studentInfo/form?id=${studentInfo.id}">
						${studentInfo.name}
				</a></td>
				<td>${studentInfo.studentnumber}</td>
				<td>${studentInfo.classes.name}</td>
				<td>${studentInfo.sex}</td>
				<td>${studentInfo.schoolrecord}</td>
				<td>${studentInfo.sex}</td>
				<td>${studentInfo.telephone}</td>
				<td>${studentInfo.gtelephone}</td>
				<td><fmt:formatDate value="${studentInfo.updatedate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${studentInfo.guardianphone}</td>
				<td><fmt:formatDate value="${studentInfo.updatedate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>

			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>