<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>

	<title>介绍管理</title>

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
            var idObjs=document.getElementsByName("chose1");
            var cgid=[];
            for(var i=0;i<idObjs.length;i++){
                if(idObjs[i].checked==true){
                    cgid.push(idObjs[i].value);
				}
			}
			if(cgid.length==0){
                alert("请选择记录");
                return;
			}
            var isSure=confirm("是否删除所选的内容?");
          if(!isSure){
              return;
		  }
        var url="${ctx}/student/studentIntroduce/delete?id="+cgid.join(",");
       window.location.href=url;

        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">

		<li class="active"><a href="${ctx}/student/studentIntroduce/">当前功能：介绍列表</a></li>

	</ul>
	<form:form id="searchForm" modelAttribute="studentIntroduce" action="${ctx}/student/studentIntroduce/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">


			<shiro:hasPermission name="student:studentIntroduce:edit">
				<a href="${ctx}/student/studentIntroduce/form">
					<input id="btnadd" class="btn btn-primary" type="button" value="新增"/>
				</a></shiro:hasPermission>
			<input id="btndelete" class="btn btn-primary" type="button" onclick="deletelecture()" value="删除"/></li>

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
				<th>介绍日期</th>
				<th>介绍学员</th>
				<th>介绍学员班级 </th>
				<th>经手人</th>

			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="studentIntroduce">
			<tr>
				<td>
					<input type="checkbox" value="${studentIntroduce.id}"name="chose1"/>
				</td>
				<td>
					<c:set var="i" value="${i+1}"></c:set>
					<c:out value="${i}"></c:out>
				</td>

				<td>
						${studentIntroduce.student}
				</td>
				<td>
					<fmt:formatDate value="${studentIntroduce.introdate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
						${studentIntroduce.introducestudent}
				</td>
				<td>
						${studentIntroduce.introduceclass}
				</td>
				<td>
						${studentIntroduce.employeename}
				</td>

			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>