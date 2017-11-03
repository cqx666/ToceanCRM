<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>

	<title>转班管理</title>

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
        function deletelecture(){
            var ids=[];
            $('input[name="chose1"]:checked').each(function(){
                ids.push("id="+$(this).val());
            });
            var param = ids.join("&")
            window.location.href="${ctx}/student/studentShiftclass/delete?"+param;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">

		<li class="active"><a href="${ctx}/student/studentShiftclass/">当前功能：转班列表</a></li>

	</ul>
	<form:form id="searchForm" modelAttribute="studentShiftclass" action="${ctx}/student/studentShiftclass/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns">


			<shiro:hasPermission name="student:studentShiftclass:edit">
				<a href="${ctx}/student/studentShiftclass/form">
					<input id="btnadd" class="btn btn-primary" type="button" value="新增"/>
				</a></shiro:hasPermission>
			<input id="btndelete" class="btn btn-primary" type="button" onclick="deletelecture()" value="删除"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
		<tr>
			<th colspan="9">学籍变更信息列表</th>
		</tr>
			<tr>
				<th><input type="checkbox"/></th>
				<th>序号</th>
				<th>学员</th>
				<th>转班时间</th>
				<th>原班级</th>
				<th>转入班级</th>
				<th>转班原因</th>

			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="studentShiftclass">
			<tr>
				<td>
					<input type="checkbox" value="${studentShiftclass.id}" name="chose1"/>
				</td>
				<td>
					<c:set var="i" value="${i+1}"></c:set>
					<c:out value="${i}"></c:out>
				</td>

				<td>
						${studentShiftclass.studentname}
				</td>
				<td>
					<fmt:formatDate value="${studentShiftclass.shiftdate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
						${studentShiftclass.classfromname}
				</td>
				<td>
						${studentShiftclass.classtoname}
				</td>
				<td>
						${studentShiftclass.reason}
				</td>

			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>