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
<script type="text/javascript" src="/resources/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/resources/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/resources/js/main.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册用户</title>
<script type="text/javascript">

	function submitForm() {
		$.messager.progress(); // 显示一个进度条 

		//调用表单插件的'submit'方法提交
		$('#regCustomForm').form('submit', {
			url : 'regCustom',
			onSubmit : function() {
				var isValid = $(this).form('validate');
				if (!isValid) {
					$.messager.progress('close'); // 当form不合法的时候隐藏工具条
				}
				return isValid; // 返回false将停止form提交 
			},
			success : function(data) {
				$.messager.progress('close'); // 当成功提交之后隐藏进度条
				if (data) {
					Message.confirm('是否继续交费？', function(r) {
	                    if (r) {
	                        ustc.addTab('客户交费', 'customPay?customId='+data, 'icon-search', true);
	                    } else {
	                        ustc.addTab('客户详情', 'customDetail?customId='+data, 'icon-search', true);
	                    }
	                });
				}
			}
		});
	}
</script>
</head>
<body>
<div class="container">
    <form method="post" id="regCustomForm">
        <table class="tableclass" width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td class="label">姓名：</td>
                <td>
                    <input class="easyui-validatebox" type="text" name="custname" data-options="required:true"></input>
                </td>
                <td class="label">身份证号：</td>
                <td>
                    <input class="easyui-validatebox" type="text" name="idcard" data-options="required:true"></input>
                </td>
            </tr>
            <tr>
                <td class="label">电话号码：</td>
                <td>
                    <input class="easyui-validatebox" name="mobile" data-options="validType:'length[11, 11]'">
                </td>
                <td class="label">性别：</td>
                <td>
                    <select name="sex">
                        <option value="1" selected>男</option>
                        <option value="0">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="label">生日：</td>
                <td>
                    <input class="easyui-datebox" type="text" id="birthday" name="birthday" style="width:100px" data-options="editable:false,value:'1985-03-06'"/>
                </td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td class="label">上线：</td>
                <td colspan="3">
                    <input class="easyui-validatebox" type="text" name="prepText" readonly />
                    <input type="hidden" name="prep" />
                    <a id="btn" href="javascript:;" class="easyui-linkbutton blueButton" onclick="javascript:searchCust();" data-options="iconCls:'icon-search'">查找</a>
                </td>
            </tr>
            <tr>
                <td class="label">地址：</td>
                <td colspan="3"><input class="easyui-validatebox" type="text" name="address" style="width:100%"></input></td>
            </tr>
        </table>
        <table width="100%">
            <tr>
                <td align="right"><a id="btn" href="javascript:;" class="easyui-linkbutton blueButton" onclick="javascript:submitForm();" data-options="iconCls:'icon-save'">保存用户</a></td>
                <td align="left"><a id="btn" href="javascript:;" class="easyui-linkbutton blueButton" onclick="javascript:$('#regCustomForm').form('clear');" data-options="iconCls:'icon-clear'">清空数据</a></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
