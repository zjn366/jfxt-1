<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>巡检公告管理</title>
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
		<li><a href="${ctx}/merchant/jfXjgg/list">巡检公告列表</a></li>
		<li class="active"><a href="${ctx}/merchant/jfXjgg/form?id=${jfXjgg.id}">巡检公告<shiro:hasPermission name="merchant:jfXjgg:edit">${not empty jfXjgg.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="merchant:jfXjgg:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="jfXjgg" action="${ctx}/merchant/jfXjgg/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">公告标题：</label>
			<div class="controls">
				<form:input path="ggbt" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">公告内容：</label>
			<div class="controls">
				<form:textarea path="ggnr" id="ggnr" htmlEscape="false"  rows="4"  class="input-xxlarge"/>
				<sys:ckeditor replace="ggnr" uploadPath="/merchant/jfXjgg"/>
			</div>
		</div>
		<%--<div class="control-group">
			<label class="control-label">网元：</label>
			<div class="controls">
				<form:input path="jfid" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发布日期：</label>
			<div class="controls">
				<form:input path="fbrq" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发布人：</label>
			<div class="controls">
				<form:input path="fbr" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">扩展字段1：</label>
			<div class="controls">
				<form:input path="kzzd1" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">扩展字段2：</label>
			<div class="controls">
				<form:input path="kzzd2" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">扩展字段3：</label>
			<div class="controls">
				<form:input path="kzzd3" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">扩展字段4：</label>
			<div class="controls">
				<form:input path="kzzd4" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>--%>
        <div class="control-group">
            <label class="control-label">网元名称：</label>
            <div class="controls">
                    <form:select path="jfid" class="input-xlarge required"  cssStyle="width:176px;">
                        <form:options items="${jfXxList}" itemLabel="name" itemValue="id" htmlEscape="false"/>
                    </form:select>
            </div>
        </div>
		<div class="control-group">
			<label class="control-label">是否发布：</label>
			<div class="controls">
				<form:select path="sffb" class="input-xlarge ">
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="merchant:jfXjgg:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>