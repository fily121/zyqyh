<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/resources/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/resources/js/jquery/jquery.min.js"></script>
<script type="text/javascript">
function inputValue(thisInput) {
	if ($(thisInput).val()) {
        $(thisInput).parent().addClass('val');
    } else {
        $(thisInput).parent().removeClass('val');
    }
}

$(function(){
	$("input").each(function(){
		if ($(this).val()) {
	        $(this).parent().addClass('val');
	    } else {
	        $(this).parent().removeClass('val');
	    }
	})
})
</script>
</head>
<body>
	<div class="container">
		<div class="login">
			<form method="post" action="login" class="AuthForm" id="AuthForm">
				<ul class="Form FancyForm clearfix">
					<li>
					    <input type="text" class="stext" name="username" id="username" onkeyup="inputValue(this)"> <label>用户名</label> <span class="fff"></span>
					</li>
					<li>
					    <input type="password" class="stext" name="password" id="password" onkeyup="inputValue(this)"><label>登录密码</label> <span class="fff"></span>
					</li>
					<li class="clearfix">
						<button class="Button blueButton Button18" type="submit" style="float: left; font-size: 18px">登录</button>
					</li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>