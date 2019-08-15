<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
* {
	text-decoration: none;
}

#otherModel {
	left: 50%;
}

#msg {
	position: absolute;
	left: 60%;
}

#rememberPwd {
	position: absolute;
	top:53px;
	left: 850px;
}
</style>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"
	charset=UTF-8">
	
</script>
<title>登录页面</title>
</head>
<body>
	<script type="text/javascript">
		function login() {
			var param = {
				type : "post",
				url : "beforeLogin/loginAction",
				data : {
					customId : $("#customId").val(),
					customPwd : $("#customPwd").val()
				},
				success : function(r) {
					if (r == 'right') {
						document.location = 'http://localhost:8080/webShopSSM/beforeLogin/queryAllGoods';
					} else {
						$("#msg").text(r);
					}
				}
			}
			$.ajax(param);
		}
	</script>
	<center>
		<div class="otherModel">
			<a href="beforeLogin/queryAllGoods">游客模式</a>
		</div>
		<div>
			<form action="beforeLogin/loginAction" method="post">
				<div>
					账号：<input id="customId" type="text" value="${custom.customId}"
						placeholder="请输入登录账号" name="customId"> <font id="msg"
						color="red"></font>
				</div>
				<div>
					密码：<input id="customPwd" type="password"
						value="${custom.customPwd }" placeholder="请输入登录密码"
						name="customPwd">
				</div>
				<div>
					<input type="button" value="登录" onclick="login()">
				</div>
				<div id="rememberPwd">
					<input type="checkbox" name="remeberCustom" checked>记住密码
				</div>
				没有账号？<a href="beforeLogin/regidtAction">注册</a>
			</form>
			<div>
				<a href="beforeLogin/test">test</a>
			</div>
		</div>
	</center>
</body>
</html>