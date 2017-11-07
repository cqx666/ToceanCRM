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
        function checkAll(){
            var checkall=document.getElementsByName("checkbox");
            for(var i=0 ;i<checkall.length;i++){
                checkall[i].checked = !checkall[i].checked;
            }
        }
        function deletecheck(){
            var idObjs = document.getElementsByName("checkboxed");
            var cgid=[];
            for(var i=0;i<idObjs.length;i++){
                if(idObjs[i].checked==true){
                    cgid.push(idObjs[i].value);
                }
            }
            if(cgid.length == 0){
               // return confirmx('请先选择记录再删除!','');
                alert('请先选择记录再删除!');
                return;
            }

            //提示用户确定要删除吗
           // var isSure =confirmx('确定删除多个吗?','');//返回一个boolean
            var isSure = confirm('确定删除多个吗?');
            if(!isSure){ //如果用户取消，直接返回，后面代码不执行
                return;
            }
            var url = "${ctx}/student/studentInfo/delete?id="+cgid.join(",");
            //alert(url);
            window.location.href=url;
        }
		function upload(){
            var upload=document.getElementById("uploadform");
            upload.submit();
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">

		<li class="active"><a href="${ctx}/student/studentInfo/">学生列表</a></li>
		<shiro:hasPermission name="student:studentInfo:edit"><li><a href="${ctx}/student/studentInfo/form">学生添加</a></li></shiro:hasPermission>
	</ul>
	
		<%--@elvariable id="studentInfo" type=""--%>
	<form:form id="searchForm" modelAttribute="studentInfo" action="${ctx}/student/studentInfo/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<div>

			<label>班级：</label>
				<sys:treeselect id="classes" name="classes.id" value="${studentInfo.classes.name}" labelName="classes.name" labelValue="${studentInfo.classes.name}"
								title="班级" url="/student/classes/listalljson" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>

			<label>学员名称：</label>
			<input id="name"  name="name"  type="text"  maxlength="20"  value="${param.name}"/>
			&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

				<%--${ctx}/student/studentInfo/delete?id=${studentInfo.id}" onclick="return confirmx('确认要删除该档案吗？', this.href)--%>
			<a href="#" onclick="javascript:deletecheck();" class="btn btn-primary">删除</a>
			<a href="${ctx}/student/studentInfo/form"  class="btn btn-primary">添加</a>
			<%--<a href="${ctx}/student/studentInfo/form?id=${studentInfo.id}"  class="btn btn-primary">导入学员</a>--%>
			<a href="#myModal" role="button"  data-toggle="modal" class="btn btn-primary">导入学员</a>
			</div>
		</form:form>


	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th><input type="checkbox" onclick="javacript:checkAll();"/></th>
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

			</tr>
		</thead>
		<tbody>
		<form:form id="searchForm" modelAttribute="studentInfo" action="${ctx}/student/studentInfo/delete" method="post" class="breadcrumb form-search">
		<c:forEach items="${page.list}" var="studentInfo" varStatus="stauts">
			<tr>
				<td><input type="checkbox" value="${studentInfo.id}" name="checkboxed"></td>
				<td>${stauts.index+1}</td>
				<td><a href="${ctx}/student/studentInfo/form?id=${studentInfo.id}">
						${studentInfo.name}
				</a></td>
				<td>${studentInfo.studentnumber}</td>
				<td>${studentInfo.classes.name}</td>
				<td>${studentInfo.sex}</td>
				<td>${studentInfo.schoolrecord}</td>

				<td>${studentInfo.telephone}</td>
				<td>${studentInfo.gtelephone}</td>
				<td>${studentInfo.createby}</td>
				<td><fmt:formatDate value="${studentInfo.createdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${studentInfo.updateby}</td>
				<td><fmt:formatDate value="${studentInfo.updatedate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>

			</tr>
		</c:forEach>
		</form:form>
		</tbody>
	</table>
	<!-- Modal start-->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="myModalLabel">导入学员信息</h3>
		</div>
		<div class="modal-body">
			<table class="table table-bordered ">
				<tr>
					<td>导入说明：</td>
					<td>
						<p>1、导入文件为Excel97~2003版本，文件扩展名为.xls.如果使用高版本的，请另存为Excel97~2003版本</p>
						<p>2、点击<a href="${ctx}/student/download">学员信息模版</a>下载，并按照说明录入学员信息</p>
						<p>3、导入文件内容填写完毕，请在下方选择导入文件，点击导入按钮</p>
					</td>
				</tr>
				<tr>
					<td>选择导入文件：</td>
					<td>
						<form id="uploadform" action="${ctx}/student/studentInfo/upload" method="post" enctype="multipart/form-data">
							<input type="file" name="xyxximportfile" id="xyxximportfile"  />
						</form>
					</td>
				</tr>
			</table>
		</div>
		<div class="modal-footer">
			<button class="btn btn-primary" onclick="javacript:upload();">上传</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		</div>
	</div>
	<!-- Modal end-->
	<div class="pagination">${page}</div>
</body>
</html>