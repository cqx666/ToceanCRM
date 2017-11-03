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
        function deletelocal(){
		    var ids=[];
		    $("input[name='localid']:checked").each(function(){
		        ids.push("id="+$(this).val());
			});
            var param=ids.join("&");
            var message=confirm("是否删除所选的推荐内容?");
            if(message==true){
                window.location.href="${ctx}/student/studentEmploymentLoca/delete?"+param;
            }
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/student/studentEmploymentLoca/">当前功能>>就业地点列表</a></li>
	</ul>
	<%--@elvariable id="studentEmploymentLoca" type="act"--%>
	<form:form id="searchForm" modelAttribute="studentEmploymentLoca" action="${ctx}/student/studentEmploymentLoca/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns">
				<shiro:hasPermission name="student:studentEmploymentLoca:edit">
					<a href="${ctx}/student/studentEmploymentLoca/form">
						<input id="btnadd" class="btn btn-primary" type="button" value="新增"/>
					</a></shiro:hasPermission>
				<input id="btndelete" class="btn btn-primary" type="button" value="删除" onclick="deletelocal()"/>
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th colspan="3">就业推荐地点信息列表</th>
			</tr>
			<tr>
				<th><input type="checkbox"></th>
				<th>序号</th>
				<th>就业推荐地点</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="studentEmploymentLoca">
			<tr>
				<td><input type="checkbox" value="${studentEmploymentLoca.id}" name="localid"/></td>
				<td>
					<c:set var="i" value="${i+1}"></c:set>
					<c:out value="${i}"></c:out>
				</td>
				<td>
					${studentEmploymentLoca.locaName}
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>