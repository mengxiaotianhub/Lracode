<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8"/>
<title>用户信息</title>
</head>
<body>
<p>we have these users:
<table border=1>
<#list userlist as user>
<tr><td>${user.id}</td><td>${user.userName}</td></tr
</table>
</#list>
</table>
</body>
</html>