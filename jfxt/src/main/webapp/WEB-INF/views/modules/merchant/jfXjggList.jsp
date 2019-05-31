<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>巡检公告管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/merchant/jfXjgg/list");
			$("#searchForm").submit();
        	return false;
        }

        function ggGlShow(id) {
            layer.open({
                type: 2,
                title: '公告内容',
                shadeClose: true,
                shade: 0.5,
                maxmin: true,
                area: ["60%", "90%"],
                content:"${loc}/show/ggGlShow.html?id="+id,
                end: function () {
                    layer.close(); //再执行关闭
                    location.reload();
                }
            });
        }
	</script>
</head>
<body>
<div style="width: 100%;align-content: center;text-align: center;" hidden="hidden" id="showgg">
	<span id="ggBt" style="font-size: 20px"></span>
	<br>
	<br>
	<div id="ggnr" ></div>
</div>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/merchant/jfXjgg/list">巡检公告列表</a></li>
		<shiro:hasPermission name="merchant:jfXjgg:edit"><li><a href="${ctx}/merchant/jfXjgg/form">巡检公告添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="jfXjgg" action="${ctx}/merchant/jfXjgg/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>公告标题：</label>
				<form:input path="ggbt" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<%--<li><label>网元：</label>--%>
				<%--<form:input path="jfid" htmlEscape="false" maxlength="255" class="input-medium"/>--%>
			<%--</li>--%>
			<li><label>是否发布：</label>
				<form:select path="sffb" class="input-medium">
					<form:option value="" label="请选择"/>
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>公告标题</th>
				<th>公告内容</th>
				<th>网元名称</th>
				<th>是否发布</th>
				<th>发布人</th>
				<th>发布日期</th>
				<shiro:hasPermission name="merchant:jfXjgg:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jfXjgg">
			<tr>
				<td><a href="${ctx}/merchant/jfXjgg/form?id=${jfXjgg.id}">
					${jfXjgg.ggbt}
				</a></td>
				<td>
					<a href="#" onclick="ggGlShow('${jfXjgg.id}')">
						查看
					</a>
				</td>
				<td>
						${jfXjgg.jfid.name}
				</td>
				<td>
						${fns:getDictLabel(jfXjgg.sffb, 'yes_no', '')}
				</td>
				<td>
						${jfXjgg.fbr.name}
				</td>
				<td>
					<fmt:formatDate value="${jfXjgg.fbrq}" pattern="yyyy-MM-dd"/>
				</td>
				<shiro:hasPermission name="merchant:jfXjgg:edit"><td>
    				<a href="${ctx}/merchant/jfXjgg/form?id=${jfXjgg.id}">修改</a>
					<a href="${ctx}/merchant/jfXjgg/delete?id=${jfXjgg.id}" onclick="return confirmx('确认要删除该巡检公告吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>