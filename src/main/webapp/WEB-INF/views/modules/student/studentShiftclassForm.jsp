<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>

	<title>转班管理</title>

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

	<li><a href="${ctx}/student/studentShiftclass/">转班列表</a></li>
	<li class="active"><a href="${ctx}/student/studentShiftclass/form?id=${studentShiftclass.id}">转班<shiro:hasPermission name="student:studentShiftclass:edit">${not empty studentShiftclass.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="student:studentShiftclass:edit">查看</shiro:lacksPermission></a></li>

</ul><br/>
<form:form id="inputForm" modelAttribute="studentShiftclass" action="${ctx}/student/studentShiftclass/save" method="post" class="form-horizontal">
	<form:hidden path="id"/>
	<sys:message content="${message}"/>
	<div class="control-group">

		<label class="control-label">转班时间：</label>

		<div class="controls">
			<input name="shiftdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
				   value="<fmt:formatDate value="${studentShiftclass.shiftdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
				   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
		</div>
	</div>
	<div class="control-group">

		<label class="control-label">转班原因：</label>

		<div class="controls">
			<form:input path="reason" htmlEscape="false" maxlength="255" class="input-xlarge "/>
		</div>
	</div>
	<div class="control-group">

		<label class="control-label">转到哪里去：</label>

		<div class="controls">
			<form:input path="classtoId" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
		</div>
	</div>
	<div class="control-group">

		<label class="control-label">从哪里转：</label>

		<div class="controls">
			<form:input path="classfromId" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
		</div>
	</div>
	<div class="control-group">

		<label class="control-label">原班级：</label>

		<div class="controls">
			<form:input path="oldclassUserid" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
		</div>
	</div>
	<div class="control-group">

		<label class="control-label">转入班级：</label>

		<div class="controls">
			<form:input path="newclassUserid" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
		</div>
	</div>
	<div class="form-actions">
		<shiro:hasPermission name="student:studentShiftclass:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
	</div>
</form:form>
</body>
</html>