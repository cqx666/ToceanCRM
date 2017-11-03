<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>讨论管理</title>
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
    <li class="active"><a href="${ctx}/student/studentDiscuss/">当前功能 >>讨论管理</a></li>
</ul>
<%--@elvariable id="studentDiscuss" type="act"--%>
<form:form id="searchForm" modelAttribute="studentDiscuss" action="${ctx}/student/studentDiscuss/" method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li class="btns">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
            <shiro:hasPermission name="student:studentDiscuss:edit">
                <a href="${ctx}/student/studentDiscuss/form">
                    <input id="btnadd" class="btn btn-primary" type="button" value="新增"/>
                </a></shiro:hasPermission>
            <input id="btndelete" class="btn btn-primary" type="submit" value="删除"/>
        </li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr><th colspan="9">分组讨论信息列表</th></tr>
    <tr>
        <td><input type="checkbox"/></td>
        <td>序号</td>
        <td>班级</td>
        <td>小组</td>
        <td>讨论日期</td>
        <td>讨论内容</td>
        <td>项目经理</td>
        <td>评价</td>
        <td>评分</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="studentDiscuss">
        <tr>
            <td>

            </td>
            <td>
            </td>
            <td>
                ...
            </td>
            <td>
                ...
            </td>
            <td>
                ...
            </td>
            <td>
                ...
            </td>
            <td>
                ...
            </td>
            <td>
                ...
            </td>
            <td>
                ...
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>