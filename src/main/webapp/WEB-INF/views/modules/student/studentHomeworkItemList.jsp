<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>作业管理</title>
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
        function deleteHomeworkItem(){
            var ids=[];
            $('input[name="chose1"]:checked').each(function(){
                ids.push("id="+$(this).val());
            });
            var param = ids.join("&");
            var message=confirm("是否删除所选的作业吗?");
            if(message==true){
                window.location.href="${ctx}/student/studentHomeworkItem/delete?"+param;
            }
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/student/studentHomeworkItem/">作业列表</a></li>
		<shiro:hasPermission name="student:studentHomeworkItem:edit"><li><a href="${ctx}/student/studentHomeworkItem/form">作业添加</a></li></shiro:hasPermission>
	</ul>
	<%--@elvariable id="studentHomeworkItem" type="act"--%>
	<form:form id="searchForm" modelAttribute="studentHomeworkItem" action="${ctx}/student/studentHomeworkItem/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>作业标题：</label>
				<form:input path="homeworkId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			<shiro:hasPermission name="student:studentHomeworkItem:edit">
				<a href="${ctx}/student/studentHomeworkItem/form">
					<input id="btnadd" class="btn btn-primary" type="button" value="新增"/>
				</a></shiro:hasPermission>
			<input id="btndelete" class="btn btn-primary" type="button" onclick="deleteHomeworkItem()" value="删除"/>
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th><input type="checkbox"/></th>
				<th>序号</th>
				<th>学员</th>
				<th>班级</th>
				<th>作业标题</th>
				<th>课程</th>
				<th>分数</th>
				<th>修改时间</th>
				<shiro:hasPermission name="student:studentHomeworkItem:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="studentHomeworkItem">
			<tr>
				<td>
					<input type="checkbox" value="${studentHomeworkItem.id}" name="chose1"/>
				</td>
				<td>
					<c:set var="i" value="${i+1}"></c:set>
					<c:out value="${i}"></c:out>
				</td>
				<td><a href="${ctx}/student/studentHomeworkItem/form?id=${studentHomeworkItem.id}">
					${studentHomeworkItem.studentId}
				</a></td>
				<td>
					${studentHomeworkItem.classesId}
				</td>
				<td>
					${studentHomeworkItem.homeworkId}
				</td>
				<td>
					${studentHomeworkItem.courseId}
				</td>
				<td>
					${studentHomeworkItem.score}
				</td>
				<td>
					<fmt:formatDate value="${studentHomeworkItem.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="student:studentHomeworkItem:edit"><td>
    				<a href="${ctx}/student/studentHomeworkItem/form?id=${studentHomeworkItem.id}">修改</a>
					<a href="${ctx}/student/studentHomeworkItem/delete?id=${studentHomeworkItem.id}" onclick="return confirmx('确认要删除该作业吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>