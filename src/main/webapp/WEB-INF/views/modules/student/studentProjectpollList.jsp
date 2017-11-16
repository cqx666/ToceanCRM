<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>项目考核管理</title>
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
        function deleteProjectpoll(){
            var ids=[];
            $('input[name="chose1"]:checked').each(function(){
                ids.push("id="+$(this).val());
            });
            var param = ids.join("&");
            var message=confirm("是否删除所选的项目吗?");
            if(message==true){
                window.location.href="${ctx}/student/studentProjectpoll/delete?"+param;
            }
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/student/studentProjectpoll/">项目考核列表</a></li>
    <shiro:hasPermission name="student:studentProjectpoll:edit"><li><a href="${ctx}/student/studentProjectpoll/form">项目考核添加</a></li></shiro:hasPermission>
</ul>
<%--@elvariable id="studentProjectpoll" type="act"--%>
<form:form id="searchForm" modelAttribute="studentProjectpoll" action="${ctx}/student/studentProjectpoll/" method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>项目名称：</label>
            <form:input path="projectname" htmlEscape="false" maxlength="50" class="input-medium"/>
        </li>
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
            <shiro:hasPermission name="student:studentProjectpoll:edit">
                <a href="${ctx}/student/studentProjectpoll/form">
                    <input id="btnadd" class="btn btn-primary" type="button" value="新增"/>
                </a></shiro:hasPermission>
            <input id="btndelete" class="btn btn-primary" type="button" onclick="deleteProjectpoll()" value="删除"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th><input type="checkbox"/></th>
        <th>序号</th>
        <th>项目名称</th>
        <th>班级</th>
        <th>小组</th>
        <th>考核日期</th>
        <th>总分</th>
        <th>考核类型</th>
        <th>修改时间</th>
        <shiro:hasPermission name="student:studentProjectpoll:edit"><th>操作</th></shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="studentProjectpoll">
        <tr>
            <td>
                <input type="checkbox" value="${studentProjectpoll.id}" name="chose1"/>
            </td>
            <td>
                <c:set var="i" value="${i+1}"></c:set>
                <c:out value="${i}"></c:out>
            </td>
            <td><a href="${ctx}/student/studentProjectpoll/form?id=${studentProjectpoll.id}">
                    ${studentProjectpoll.projectname}
            </a></td>
            <td>
                    ${studentProjectpoll.classesId}
            </td>
            <td>
                    ${studentProjectpoll.team}
            </td>
            <td>
                <fmt:formatDate value="${studentProjectpoll.polldate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                    ${studentProjectpoll.score}
            </td>
            <td>
                    ${studentProjectpoll.polltype}
            </td>
            <td>
                <fmt:formatDate value="${studentProjectpoll.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <shiro:hasPermission name="student:studentProjectpoll:edit"><td>
                <a href="${ctx}/student/studentProjectpoll/form?id=${studentProjectpoll.id}">修改</a>
                <a href="${ctx}/student/studentProjectpoll/delete?id=${studentProjectpoll.id}" onclick="return confirmx('确认要删除该项目考核吗？', this.href)">删除</a>
            </td></shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>