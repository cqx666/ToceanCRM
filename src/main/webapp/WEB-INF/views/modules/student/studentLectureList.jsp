<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>演讲管理</title>
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
		<li class="active"><a href="${ctx}/student/studentLecture/">当前功能 >> 演讲列表</a></li>
		<shiro:hasPermission name="student:studentLecture:edit"><li><a href="${ctx}/student/studentLecture/form">新增</a></li></shiro:hasPermission>
	</ul>
	<%--@elvariable id="studentLecture" type="act"--%>
	<form:form id="searchForm" modelAttribute="studentLecture" action="${ctx}/student/studentLecture/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns">
				<form:input path="content" htmlEscape="false" maxlength="100" class="input-medium"/>
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>

		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th><input type="checkbox"/></th>
				<th>序号</th>
				<th>班级</th>
				<th>学员</th>
				<th>演讲日期</th>
				<th>演讲内容</th>
				<th>项目经理</th>
                <th>评价</th>
				<th>评分</th>
			</tr>
		</thead>
		<tbody>

        <c:forEach items="${page.list}" var="studentLecture">
			<tr>
                <td>
                   <input type="checkbox" value="${studentLecture.id}"/>
                </td>
                <td>
					<c:set var="i" value="${i+1}"></c:set>
					<c:out value="${i}"></c:out>
				</td>
				<td>
					${studentLecture.classname}
				</td>
				<td>
					${studentLecture.studentname}
				</td>
				<td>
					<fmt:formatDate value="${studentLecture.date}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					${studentLecture.content}
				</td>
				<td>
					...
				</td>
				<td>
					${studentLecture.advice}
				</td>
				<td>
					${studentLecture.score}
				</td>





			</tr>
        </c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
