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
        function deletedire(){
		    var ids=[];
		    $("input[name='number']:checked").each(function(){
		        ids.push("id="+$(this).val());
			});
		    var param=ids.join("&");
            var message=confirm("是否删除所选的推荐内容?");
            if(message==true){
                window.location.href="${ctx}/student/studentEmploymentDire/delete?"+param;
            }
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/student/studentEmploymentDire/">当前功能>>>就业列表</a></li>
	</ul>
	<%--@elvariable id="studentEmploymentDire" type="act"--%>
	<form:form id="searchForm" modelAttribute="studentEmploymentDire" action="${ctx}/student/studentEmploymentDire/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns">
				<shiro:hasPermission name="student:studentEmploymentDire:edit">
				<a href="${ctx}/student/studentEmploymentDire/form">
					<input id="btnadd" class="btn btn-primary" type="button" value="新增"/>
				</a></shiro:hasPermission>
				<input id="btndelete" class="btn btn-primary" type="button" value="删除" onclick="deletedire()"/>
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<td colspan="4">就业推荐方向列表</td>
			</tr>
			<tr>
				<th><input type="checkbox"></th>
				<th>序号</th>
				<th>就业推荐方向</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="studentEmploymentDire">
			<tr>
				<td><input type="checkbox" value="${studentEmploymentDire.id}" name="number"/></td>
				<td>
					<c:set var="i" value="${i+1}"></c:set>
					<c:out value="${i}"/>
				</td>
				<td>${studentEmploymentDire.direName}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">
			${page}
	</div>
</body>
</html>