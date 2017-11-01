<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>演讲管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/student/studentLecture/">演讲列表</a></li>
		<li class="active"><a href="${ctx}/student/studentLecture/form?id=${studentLecture.id}">演讲<shiro:hasPermission name="student:studentLecture:edit">${not empty studentLecture.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="student:studentLecture:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="studentLecture" action="${ctx}/student/studentLecture/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">

			<label class="control-label">学员：</label>

			<div class="controls">
				<form:input path="createrid" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">

			<label class="control-label">演讲内容：</label>

			<div class="controls">
				<form:textarea path="content" htmlEscape="false" rows="4" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">

			<label class="control-label">演讲日期：</label>

			<div class="controls">
				<input name="date" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${studentLecture.date}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">

			<label class="control-label">评价：</label>

			<div class="controls">
				<form:input path="evaluation" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">

			<label class="control-label">评分：</label>

			<div class="controls">
				<form:input path="score" htmlEscape="false" maxlength="11" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">

			<label class="control-label">建议：</label>

			<div class="controls">
				<form:input path="advice" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">

			<label class="control-label">项目经理：</label>
			<div class="controls">
				<form:input path="pmId" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">学员：</label>

			<div class="controls">
				<form:input path="studentId" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="student:studentLecture:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>