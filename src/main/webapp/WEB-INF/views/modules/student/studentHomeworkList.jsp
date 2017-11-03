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
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/student/studentHomework/">作业列表</a></li>
    <shiro:hasPermission name="student:studentHomework:edit"><li><a href="${ctx}/student/studentHomework/form">作业添加</a></li></shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="studentHomework" action="${ctx}/student/studentHomework/" method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>作业标题：</label>
            <form:input path="title" htmlEscape="false" maxlength="50" class="input-medium"/>
        </li>
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>序号</th>
        <th>作业标题</th>
        <th>班级</th>
        <th>布置日期</th>
        <th>老师</th>
        <th>课程</th>
        <th>状态</th>
        <th>修改时间</th>
        <shiro:hasPermission name="student:studentHomework:edit"><th>操作</th></shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="studentHomework" varStatus="status">
        <tr>
            <td>
                    ${status.index+1}
                </a></td>
            <td><a href="${ctx}/student/studentHomework/form?id=${studentHomework.id}">
                    ${studentHomework.title}
            </a></td>
            <td>
                    ${studentHomework.classesId}
            </td>
            <td>
                <fmt:formatDate value="${studentHomework.makedate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                    ${studentHomework.teacher}
            </td>
            <td>
                    ${studentHomework.courseId}
            </td>
            <td>
                    ${studentHomework.status}
            </td>
            <td>
                <fmt:formatDate value="${studentHomework.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <shiro:hasPermission name="student:studentHomework:edit"><td>
                <a href="${ctx}/student/studentHomework/form?id=${studentHomework.id}">修改</a>
                <a href="${ctx}/student/studentHomework/delete?id=${studentHomework.id}" onclick="return confirmx('确认要删除该作业吗？', this.href)">删除</a>
            </td></shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>