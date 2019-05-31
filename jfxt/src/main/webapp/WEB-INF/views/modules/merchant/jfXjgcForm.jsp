<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>巡检过程管理</title>
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
		<li><a href="${ctx}/merchant/jfXjgc/list">巡检过程列表</a></li>
		<li class="active"><a href="${ctx}/merchant/jfXjgc/form?id=${jfXjgc.id}">巡检过程<shiro:hasPermission name="merchant:jfXjgc:edit">${not empty jfXjgc.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="merchant:jfXjgc:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="jfXjgc" action="${ctx}/merchant/jfXjgc/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">巡检网元：</label>
			<div class="controls">
				<form:select path="xjjf" class="input-xlarge required"  cssStyle="width:176px;">
					<form:options items="${jfXxList}" itemLabel="name" itemValue="id" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">巡检时间：</label>
			<div class="controls">
				<input name="xjsj" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					   value="<fmt:formatDate value="${jfXjgc.xjsj}" pattern="yyyy-MM-dd"/>"
					   onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/>

			</div>
		</div>
		<div class="control-group">
			<label class="control-label">巡检人员：</label>
			<div class="controls">

				<sys:treeselect id="xjry" name="xjry.id" value="${jfXjgc.xjry.id}" labelName="xjry.name" labelValue="${jfXjgc.xjry.name}"
								title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="false" notAllowSelectParent="true"/>

			</div>
		</div>
		<div class="control-group">
			<label class="control-label">现场图片：</label>
			<div class="controls">
				<form:hidden id="xczp" path="xczp" htmlEscape="false" class="input-xlarge" cssStyle="border: 0px;"
							 placeholder="请上传现场图片！" readonly="true"/>
				<sys:ckfinder input="xczp" type="images" uploadPath="/merchant/jfXjgc" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">整改判断：</label>
			<div class="controls">
				<form:textarea path="zgpd"  rows="4"  htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">巡检是否通过：</label>
			<div class="controls">
				<form:select path="xjsftg" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">巡检打分：</label>
			<div class="controls">
				<form:input path="xjdf" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">备注：</label>--%>
			<%--<div class="controls">--%>
				<%--<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">扩展字段1：</label>--%>
			<%--<div class="controls">--%>
				<%--<form:input path="kzzd1" htmlEscape="false" maxlength="255" class="input-xlarge "/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">扩展字段2：</label>--%>
			<%--<div class="controls">--%>
				<%--<form:input path="kzzd2" htmlEscape="false" maxlength="255" class="input-xlarge "/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">扩展字段3：</label>--%>
			<%--<div class="controls">--%>
				<%--<form:input path="kzzd3" htmlEscape="false" maxlength="255" class="input-xlarge "/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="control-group">--%>
			<%--<label class="control-label">扩展字段4：</label>--%>
			<%--<div class="controls">--%>
				<%--<form:input path="kzzd4" htmlEscape="false" maxlength="255" class="input-xlarge "/>--%>
			<%--</div>--%>
		<%--</div>--%>
		<div class="form-actions">
			<shiro:hasPermission name="merchant:jfXjgc:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>