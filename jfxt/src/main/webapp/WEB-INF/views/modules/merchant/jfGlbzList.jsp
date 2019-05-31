<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>网元管理标准和要求管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/merchant/jfGlbz/list");
			$("#searchForm").submit();
        	return false;
        }

        function jfbzShow(id) {
            layer.open({
                type: 2,
                title: '公告内容',
                shadeClose: true,
                shade: 0.5,
                maxmin: true,
                area: ["60%", "90%"],
                content:"${loc}/show/jfbzShow.html?id="+id,
                end: function () {
                    layer.close(); //再执行关闭
                    location.reload();
                }
            });
        }

	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/merchant/jfGlbz/list">网元管理标准和要求列表</a></li>
		<shiro:hasPermission name="merchant:jfGlbz:edit"><li><a href="${ctx}/merchant/jfGlbz/form">网元管理标准和要求添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="jfGlbz" action="${ctx}/merchant/jfGlbz/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>标准定制</th>
				<shiro:hasPermission name="merchant:jfGlbz:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jfGlbz">
			<tr>

				<td>
					<a href="#" onclick="jfbzShow('${jfGlbz.id}')">
							${jfGlbz.ddbh}
					</a>
				</td>
				<shiro:hasPermission name="merchant:jfGlbz:edit"><td>
    				<a href="${ctx}/merchant/jfGlbz/form?id=${jfGlbz.id}">修改</a>
					<a href="${ctx}/merchant/jfGlbz/delete?id=${jfGlbz.id}" onclick="return confirmx('确认要删除该网元管理标准和要求吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>