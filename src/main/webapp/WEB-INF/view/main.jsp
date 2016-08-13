<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/resources/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/resources/js/easyui/themes/icon.css">
<link href="/resources/css/main.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="/resources/js/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="/resources/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="/resources/js/main.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息管理系统</title>
</head>
<body class="easyui-layout" style="width: 700px; height: 700px;">
	<div data-options="region:'north'" style="height: 50px"></div>
	<div data-options="region:'west',split:true" style="width: 200px;overflow:hidden;">
		<div class="easyui-accordion css3menu" style="width: 100%;">
			<div title="基础管理" data-options="iconCls:'icon-search'"
				style="overflow: auto; padding: 10px;">
				<a id="searchCust" href="javascript:ustc.addTab('注册用户', 'regCustom', 'icon-add', true);" rel="regCustom" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',pain:true" style="width:100%">注册用户</a>
				<a id="searchCust" href="javascript:ustc.addTab('人员查询', 'custSearch', 'icon-search', true);" rel="custSearch" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',pain:true" style="width:100%">查询</a>
				<a id="searchCust" href="javascript:ustc.addTab('订单管理', 'custSearch', 'icon-large_smartart', true);" rel="custSearch" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',pain:true" style="width:100%">订单管理</a>
				<a id="searchCust" href="javascript:ustc.addTab('规章制定', 'custSearch', 'icon-search', true);" rel="custSearch" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',pain:true" style="width:100%">规章制定</a>
				<a id="searchCust" href="javascript:ustc.addTab('材料管理', 'custSearch', 'icon-search', true);" rel="custSearch" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',pain:true" style="width:100%">材料管理</a>
				<a id="searchCust" href="javascript:ustc.addTab('施工队伍', 'custSearch', 'icon-search', true);" rel="custSearch" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',pain:true" style="width:100%">施工队伍</a>
			</div>
			<div title="现场管理" data-options="iconCls:'icon-edit'"
				style="padding: 10px;">
				<a id="searchCust" href="javascript:ustc.addTab('现场管理', 'custSearch', 'icon-search', true);" rel="custSearch" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',pain:true" style="width:100%">现场管理</a>
				<a id="searchCust" href="javascript:ustc.addTab('现场检查', 'custSearch', 'icon-search', true);" rel="custSearch" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',pain:true" style="width:100%">现场检查</a>
				<a id="searchCust" href="javascript:ustc.addTab('工程承揽情况', 'custSearch', 'icon-search', true);" rel="custSearch" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',pain:true" style="width:100%">工程承揽情况</a>
			</div>
		</div>
	</div>
	<div data-options="region:'center',title:'',iconCls:'icon-ok'" id="mainPanel"></div>
</body>
</html>
