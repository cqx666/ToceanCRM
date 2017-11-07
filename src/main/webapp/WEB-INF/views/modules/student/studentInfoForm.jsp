<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学生管理</title>
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
	<li><a href="${ctx}/student/studentInfo/">学生列表</a></li>
	<li class="active"><a href="${ctx}/student/studentInfo/form?id=${studentInfo.id}">学生<shiro:hasPermission name="student:studentInfo:edit">${not empty studentInfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="student:studentInfo:edit">查看</shiro:lacksPermission></a></li>
</ul><br/>
<%--@elvariable id="studentInfo" type=""--%>
<form:form id="inputForm" modelAttribute="studentInfo" action="${ctx}/student/studentInfo/save" method="post" class="form-horizontal">
	<form:hidden path="id"/>
	<sys:message content="${message}"/>
	<!--~~~~~~~~~~~~~~~~~~~~基本信息资料内容~~~~~~~~~~~~~~-->
	<div class="control-group">
		<table id="contentTable" class="table table-striped table-bordered">
			<thead>
			<tr>
				<th>基本信息资料</th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td>
					<label>姓名：</label>
				</td>
				<td>
					<form:input path="name" htmlEscape="false" maxlength="100" class="input-xlarge "/>
					<span class="help-inline"><font color="red">*</font> </span>
				</td>
				<td>
					<label>学号：</label>
				</td>
				<td>
					<form:input path="studentnumber" htmlEscape="false" maxlength="20" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>班级：</label>
				</td>
				<td>
					<form:select path="classes.name" class="input-medium">
						<form:option value="" label=""/>
					</form:select>
				</td>
				<td><label>班级编号：</label></td>
				<td><form:input path="classes.id" htmlEscape="false" maxlength="20" class="input-xlarge "/></td>
			</tr>
			<tr>
				<td>
					<label>性别：</label>
				</td>
				<td>
					<form:radiobuttons path="sex" items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false" class=""/>
				</td>

				<td>
					出生日期：
				</td>
				<td>
					<input name="birthday" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
						   value="<fmt:formatDate value="${studentInfo.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/>"
						   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>出生地：</label>
				</td>
				<td>
					<form:input path="birthplace" htmlEscape="false" maxlength="100" class="input-xlarge "/>
				</td>
				<td>
					<label>婚姻情况：</label>
				</td>
				<td>
					<form:select path="married" class="input-xlarge ">
						<form:option value="" label=""/>
						<form:options items="${fns:getDictList('married_show_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>
					<label>毕业的学校：</label>
				</td>
				<td>
					<form:input path="school" htmlEscape="false" maxlength="50" class="input-xlarge "/>
				</td>
				<td>
					<label>院系：</label>
				</td>
				<td>
					<form:input path="department" htmlEscape="false" maxlength="20" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>专业：</label>
				</td>
				<td>
					<form:input path="collegemajor" htmlEscape="false" maxlength="20" class="input-xlarge "/>
				</td>
				<td>
					<label>学历：</label>
				</td>
				<td>
					<form:select path="schoolrecord" class="input-xlarge ">
						<form:option value="" label=""/>
						<form:options items="${fns:getDictList('schoolrecord_show_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>
					<label>毕业时间：</label>
				</td>
				<td>
					<form:input path="graduatedate" htmlEscape="false" maxlength="10" class="input-xlarge "/>
				</td>
				<td>
					<label>学籍改变：</label>
				</td>
				<td>
					<form:input path="statuschange" htmlEscape="false" maxlength="500" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>学生类型：</label>
				</td>
				<td>
					<form:select path="studenttype" class="input-xlarge ">
						<form:option value="" label=""/>
						<form:options items="${fns:getDictList('studenttype_show_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
				</td>
				<td>
					<label>考勤号：</label>
				</td>
				<td>
					<input  htmlEscape="false" maxlength="50" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>备注信息：</label>
				</td>
				<td colspan="3">
					<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
				</td>
			</tr>
			</tbody>
		</table>
	</div>
	<!--~~~~~~~~~~~~~~~~~~~~联系方式内容~~~~~~~~~~~~~~-->
	<div class="control-group">
		<table id="TableConnetion" class="table table-striped table-bordered">
			<thead>
			<tr>
				<th>联系方式</th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td>
					<label>入学时联系电话：</label>
				</td>
				<td>
					<form:input path="telephone" htmlEscape="false" maxlength="50" class="input-xlarge "/>
				</td>
				<td>
					<label>毕业时联系电话：</label>
				</td>
				<td>
					<form:input path="gtelephone" htmlEscape="false" maxlength="50" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>邮箱：</label>
				</td>
				<td>
					<form:input path="email" htmlEscape="false" maxlength="50" class="input-xlarge "/>
				</td>
				<td>
					<label>QQ：</label>
				</td>
				<td>
					<form:input path="qq" htmlEscape="false" maxlength="50" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>MSN：</label>
				</td>
				<td>
					<form:input path="msn" htmlEscape="false" maxlength="50" class="input-xlarge "/>
				</td>
				<td>
					<label>家庭电话：</label>
				</td>
				<td>
					<form:input path="homephone" htmlEscape="false" maxlength="50" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>家庭地址：</label>
				</td>
				<td>
					<form:input path="homeaddress" htmlEscape="false" maxlength="50" class="input-xlarge "/>
				</td>
				<td>
					<label>证件号码：</label>
				</td>
				<td>
					<form:input path="credentialno" htmlEscape="false" maxlength="50" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>监护人：</label>
				</td>
				<td>
					<form:input path="guardian" htmlEscape="false" maxlength="10" class="input-xlarge "/>
				</td>
				<td>
					<label>监护人联系电话：</label>
				</td>
				<td>
					<form:input path="guardianphone" htmlEscape="false" maxlength="50" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>与本人关系：</label>
				</td>
				<td>
					<form:input path="relation" htmlEscape="false" maxlength="10" class="input-xlarge "/>
				</td>
				<td>
					<label>紧急联系人：</label>
				</td>
				<td>
					<form:input path="urgencyperson" htmlEscape="false" maxlength="20" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>紧急联系人电话：</label>
				</td>
				<td>
					<form:input path="urgencyphone" htmlEscape="false" maxlength="20" class="input-xlarge "/>
				</td>
				<td></td>
				<td></td>
			</tr>
			</tbody>
		</table>
	</div>

	<!--~~~~~~~~~~~~~~~~~~~后期信息内容~~~~~~~~~~~~~~-->
	<div class="control-group">
		<table id="backMsgTable" class="table table-striped table-bordered">
			<thead>
			<tr>
				<th>后期信息</th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td>
					<label>职业素质基础分：</label>
				</td>
				<td>
					<form:input path="qulityscore" htmlEscape="false" class="input-xlarge required number"/>
					<span class="help-inline"><font color="red">*</font> </span>
				</td>
				<td>
					<label>技术能力基础分：</label>
				</td>
				<td>
					<form:input path="skillscore" htmlEscape="false" class="input-xlarge required number"/>
					<span class="help-inline"><font color="red">*</font> </span>
				</td>
			</tr>
			<tr>
				<td>
					<label>第一次考试成绩：</label>
				</td>
				<td>
					<form:input path="firstwritten" htmlEscape="false" class="input-xlarge  number"/>
				</td>
				<td>
					<label>第二次考试成绩：</label>
				</td>
				<td>
					<form:input path="secondwritten" htmlEscape="false" class="input-xlarge  number"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>第三次考试成绩：</label>
				</td>
				<td>
					<form:input path="thirdwritten" htmlEscape="false" class="input-xlarge  number"/>
				</td>
				<td>
					<label>SCJP考试成绩：</label>
				</td>
				<td>
					<form:input path="scjp" htmlEscape="false" class="input-xlarge  number"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>第一次项目考核成绩：</label>
				</td>
				<td>
					<form:input path="firstpoll" htmlEscape="false" class="input-xlarge  number"/>
				</td>
				<td>
					<label>第二次项目考核成绩：</label>
				</td>
				<td>
					<form:input path="secondpoll" htmlEscape="false" class="input-xlarge  number"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>第三次项目考核成绩：</label>
				</td>
				<td>
					<form:input path="thirdpoll" htmlEscape="false" class="input-xlarge  number"/>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>
					<label>职务：</label>
				</td>
				<td>
					<form:select path="innerheadship" class="input-xlarge ">
						<form:option value="" label=""/>
						<form:options items="${fns:getDictList('handship')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
				</td>
				<td>
					<label>达内毕业时间：</label>
				</td>
				<td>
					<input name="daneigraduatedate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
						   value="<fmt:formatDate value="${studentInfo.daneigraduatedate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
						   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>是否还清贷款：</label>
				</td>
				<td>
					<form:radiobuttons path="repayedcredit" items="${fns:getDictList('repayedcredit')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
					<span class="help-inline"><font color="red">*</font> </span>
				</td>
				<td>
					<label>就业公司：</label>
				</td>
				<td>
					<form:input path="company" htmlEscape="false" maxlength="20" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>就业职务：</label>
				</td>
				<td>
					<input  htmlEscape="false" maxlength="20" class="input-xlarge "/>
				</td>
				<td>
					<label>就业薪水：</label>
				</td>
				<td>
					<form:input path="salary" htmlEscape="false" maxlength="11" class="input-xlarge  digits"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>班主任评价：</label>
				</td>
				<td colspan="3">
					<form:textarea path="teacherevaluation" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>项目经理评价：</label>
				</td>
				<td colspan="3">
					<form:textarea path="pmevaluation" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>就业感言：</label>
				</td>
				<td colspan="3">
					<form:textarea path="careerexclamation" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>照片：</label>
				</td>
				<td colspan="3">
					<form:input path="pic" htmlEscape="false" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>简历：</label>
				</td>
				<td colspan="3">
					<form:input path="resume" htmlEscape="false" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>回访记录：</label>
				</td>
				<td colspan="3">
					<form:textarea path="returnvist" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
				</td>
			</tr>
			</tbody>
		</table>
	</div>

	<!--~~~~~~~~~~~~~~~~~~~附加信息内容~~~~~~~~~~~~~~-->
	<div class="control-group">
		<table id="MsgTable" class="table table-striped table-bordered">
			<thead>
			<tr>
				<th>附加信息</th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td>
					<label>原参加培训的公司：</label>
				</td>
				<td>
					<form:input path="traincompany" htmlEscape="false" maxlength="50" class="input-xlarge "/>
				</td>
				<td>
					<label>培训时间：</label>
				</td>
				<td>
					<form:input path="traintime" htmlEscape="false" maxlength="255" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>培训内容：</label>
				</td>
				<td>
					<form:input path="traincontext" htmlEscape="false" maxlength="50" class="input-xlarge "/>
				</td>
				<td>
					<label>原工作单位：</label>
				</td>
				<td>
					<form:input path="oldcompany" htmlEscape="false" maxlength="50" class="input-xlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>原单位职位：</label>
				</td>
				<td>
					<form:input path="oldheadship" htmlEscape="false" maxlength="20" class="input-xlarge "/>
				</td>
				<td>
					<label>原单位薪水：</label>
				</td>
				<td>
					<form:input path="oldsalary" htmlEscape="false" maxlength="11" class="input-xlarge  digits"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>家庭背景：</label>
				</td>
				<td>
					<form:textarea path="familybackgroud" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
				</td>
				<td>
					<label>父母状况：</label>
				</td>
				<td>
					<form:textarea path="parentstatus" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>职业规划：</label>
				</td>
				<td>
					<form:textarea path="jobdesign" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
				</td>
				<td>
					<label>期望目标：</label>
				</td>
				<td>
					<form:textarea path="target" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
				</td>
			</tr>
			<tr>
				<td>
					<label>爱好：</label>
				</td>
				<td>
					<form:textarea path="hobby" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
				</td>
				<td>
					<label>经济能力：</label>
				</td>
				<td>
					<form:textarea path="economy" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
				</td>
			</tr>
			</tbody>
		</table>
	</div>

	<div class="form-actions">
		<shiro:hasPermission name="student:studentInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
	</div>
</form:form>
</body>
</html>