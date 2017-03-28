<!DOCTYPE html>
<html lang="en">
<head>
  <title>IOT demo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css"
 href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css"
 href="${pageContext.request.contextPath}/resources/css/style.css">
  <link rel="stylesheet" type="text/css"
 href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.min.css">
</head>
<body>
  
<div class="container-fluid">
<div class="row heading">
<div class="col-sm-1 text-center submit"><button class="btn btn-info" type="button" onclick="home();">Home</button></div>
<div class="col-sm-1 text-center submit"><button class="btn btn-info" id="bck" type="button" onclick="lmsHome();">Go back</button></div>
<div class="row heading">
<div class="col-md-4"><img src="./resources/images/logo-white-header.png" alt="logo"></div>
<div class="col-md-4">
  <b><h2>Legrand BTicino lightSystem</h2></b></div>
  <div class="col-sm-1 text-center submit"><button class="btn btn-info" type="button" onclick="lms_lights_config();">Lights config</button></div>
  </div>
</div>

<div class="container">
<div><h3 class="row lighting"><b>Lighting</b></h3></div>
<div class="row" id="listitems"></div>
</div>

<script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/jquery-2.0.3.js"></script>
  <script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/home.js"></script>
  <script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
   <script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min1.10.7.js"></script>
<script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/light.js"></script>
  
 </body>
</html>