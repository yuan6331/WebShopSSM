<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function addToCartFunction(event) {
		var goods_id = event.target.id;
		var param = {
			type : "post",
			url : "/webShopSSM/afterLogin/addToCart",
			data : {
				goodsId : goods_id
			},
			success : function(result) {
				if (result == "isNotLogin") {
					alert("请先登录账号！");
					document.location = 'http://localhost:8080/webShopSSM/'
				} else {
					alert(result);
				}
			}
		}
		$.ajax(param)
	}

	function loginOff() {
		var param = {
			type : "post",
			url : "/webShopSSM/beforeLogin/loginOff",
			success : function(r) {
				if (r == "loginOff") {
					alert("已退出账号！");
				} else {
					alert("服务器故障");
				}
			}
		}
		$.ajax(param)
	}
</script>
<style type="text/css">
* {
	position: absolute;
	list-style: none;
	margin: 0px;
	padding: 0px;
	text-decoration: none;
	list-style: none;
}

#goodsList {
	border: 1px solid transparent;
	width: 900px;
	height: 300px;
	left: 250px;
	top: 150px;
}

#goods {
	position: relative;
	border: 1px solid grey;
	width: 160px;
	height: 250px;
	margin: 10px 15px;
	padding: 10px 5px;
	float: left;
}

li {
	position: relative;
	border: 1px solid grey;
	padding: 3px;
	margin: 5px;
	top: 1px;
}

#turnPage {
	border: 1px solid red;
	width: 100px;
	height: 50px;
	top: 600px;
	left: 500px;
}

font {
	position: absolute;
	border: 1px solid transparent;
	width: 200px;
	height: 25px;
	top: 100px;
	left: 600px;
}

#uuid {
	position: absolute;
	border: 1px solid transparent;
	width: 400px;
	height: 25px;
	top: 50px;
	left: 500px;
}

#loginButton {
	position: absolute;
	border: 1px solid transparent;
	width: 50px;
	height: 25px;
	top: 30px;
	left: 1200px;
	background-color: #999;
	border-radius: 5px;
	text-align: center;
}

#loginButton:HOVER {
	background-color: #555;
	color: orange;
	font-weight: bolder;
}

#liButton {
	position: absolute;
	border: 1px solid grey;
	border-color: grey;
	height: 22px;
	width: 70px;
	left: 40px;
	top: 230px;
	padding-left: 3px;
}

#liButton:HOVER {
	box-shadow: black;
	background-color: yellow;
}

.pageUp {
	position: absolute;
	border: 1px solid grey;
	top: 500px;
	left: 550px;
	font-size: 16px;
	line-height: 18px;
}

.pageDown {
	position: absolute;
	border: 1px solid grey;
	top: 500px;
	left: 700px;
	font-size: 16px;
	line-height: 18px;
}

#myCart {
	position: absolute;
	border: 1px solid blue;
	width: 100px;
	height: 20px;
	top: 30px;
	left: 1300px;
	line-height: 20px;
	text-align: center;
	border-radius: 5px;
}

#myCart:HOVER {
	background-color: #0000;
	font-weight: bolder;
	color: black;
	border-color: black;
}

#loginOff {
	position: absolute;
	border: 1px solid transparent;
	width: 50px;
	height: 25px;
	top: 30px;
	left: 1100px;
	background-color: #999;
	border-radius: 5px;
	text-align: center;
	font-size: 16px;
	line-height: 16px;
}

#loginOff:HOVER {
	background-color: #555;
	color: orange;
	font-weight: bolder;
}

#myCart{
	position: absolute;
	border: 1px solid transparent;
	width: 50px;
	height: 25px;
	top: 50px;
	left: 1100px;
	background-color: #999;
	border-radius: 5px;
	text-align: center;
	font-size: 16px;
	line-height: 16px;
}

#myCart:HOVER {
	background-color: #555;
	color: orange;
	font-weight: bolder;
}
</style>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"
	charset="UTF-8">
	
</script>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="uuid">uuid: ${cookie.sessionId.value}</div>
	<br>
	<a id="loginButton" href="http://localhost:8080/webShopSSM/">登录</a>
	<input id="loginOff" type="button" value="退出" onclick="loginOff()">
	<a id="myCart" href="/webShopSSM/afterLogin/checkMyCart">我的购物车</a>
	<div id="goodsList">
		<c:forEach items="${goodsList}" var="goods">
			<ul id="goods">
				<li class="goods">${goods.goodsId}</li>
				<li class="goods">商品图片${goods.goodsImg}</li>
				<li class="goods">商品信息${goods.goodsDetail}</li>
				<li class="goods">价格${goods.goodsPrice}</li>
				<li class="goods">剩余数量${goods.goodsNum}</li>
				<li id="liButton"><input type="button" value="加入购物车"
					id="${goods.goodsId}" onclick="addToCartFunction(event)" /></li>
			</ul>
		</c:forEach>
	</div>
	<input class="pageUp" type="button" value="上一页" name="pageUp"
		onclick="pageUp()">
	<input class="pageDown" type="button" value="下一页" name="pageDown"
		onclick="pageDown()">
	<div>
		<font color="green" id="cartMsg"></font>
	</div>
</body>
</html>