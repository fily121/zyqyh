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
</head>
<body>
<div class="container">
        <table class="tableclass" width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td class="label">姓名：</td>
                <td>
                    ${customer.custname}
                </td>
                <td class="label">身份证号：</td>
                <td>
                    ${customer.idcard}
                </td>
            </tr>
            <tr>
                <td class="label">电话号码：</td>
                <td>
                    ${customer.mobile}
                </td>
                <td class="label">性别：</td>
                <td>
                    ${customer.sex eq '1'}
                </td>
            </tr>
            <tr>
                <td class="label">生日：</td>
                <td>
                    ${customer.birthday}
                </td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td class="label">上线：</td>
                <td colspan="3">
                    ${customer.prep}
                </td>
            </tr>
            <tr>
                <td class="label">地址：</td>
                <td colspan="3">${customer.address}</td>
            </tr>
        </table>
</div>
</body>
</html>
