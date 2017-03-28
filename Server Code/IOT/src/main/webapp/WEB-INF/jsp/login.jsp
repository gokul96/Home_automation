<!DOCTYPE html>
<html lang="en">

<head>
    <title>IOT demo</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.min.css">
</head>

<body>

    <div class="container-fluid">
        <div class="row heading">
            <div class="col-md-4"><img src="./resources/images/logo-white-header.png" alt="logo" style="height: 82px;width: 147px;"></div>
            <div class="col-md-4">
                <b><h1>GOKUL AUTOMATION SOLUTIONS</h1></b></div>
        </div>
    </div>
    <div id="formdiv" style="height:225px;width:325px;border: 3px black;margin-left:40%;margin-top:10%;margin-right:auto;margin-bottom:auto;">
        <fieldset id="inputs">
            <p>Username:</p>
            <input style="margin-top:1px;" placeholder="Enter Username" id="username" type="text">
            <p>Password:</p>
            <input style="margin-top:1px;" placeholder="Enter Password" id="password" type="password">
        </fieldset>
        <fieldset id="actions">
            <button type="submit" id="submit" value="Log in" onclick="User_authentication()">Login</button>
        </fieldset>
    </div>
    <!--
    <div id="formdiv" style="height:225px;width:325px;border: 3px black;margin-left:40%;margin-top:10%;margin-right:auto;margin-bottom:auto;">
        <fieldset id="inputs">
            <p>Username:</p>
            <input style="margin-top:1px;" id="username" type="text">
            <p>Password:</p>
            <input style="margin-top:1px;" id="password" type="password">
        </fieldset>
        <fieldset id="actions">
            <input style="width: 125px;height: auto;margin-top: 5px;margin-left:6%; position: relative;" type="submit" id="submit" value="Log in" onclick="User_authentication()">
        </fieldset>
    </div>
-->

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.0.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/home.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min1.10.7.js"></script>


</body>

</html>
