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

<div class="col-md-4"><img src="./resources/images/logo-white-header.png" alt="logo"></div>

<!-- <img src="cinqueterre.jpg" class="img-rounded" alt="Cinque Terre" width="304" height="236"> -->


<div class="col-md-4">
  <b><h1>XDK sensor info</h1></b></div>
  </div>
</div>

 </div>
<!--  <div id="xdkreport"></div> -->
 
 <table id="diffReport" class="dataTable"><thead><tr>
	<th>Temperature ('C) </th><th>Pressure (Bar)</th><th>Light (Lux)</th><th>Humidity (RH%)</th><th>Accelerometer (Mg)</th><th>Gyroscope (mdeg/s)</th><th>Magnetometer (uT)</th></tr></thead><tbody></tbody></table>

</div>

 <!-- <div class="row submit">
  <div class="col-sm-3 text-center"><button class="btn btn-warning" type="button" onclick="">Accelerator</button></div>
  <div class="col-sm-3 text-center"><button class="btn btn-warning" type="button" onclick="">Gyroscope</button></div>
  <div class="col-sm-3 text-center"><button class="btn btn-warning" type="button" onclick="">Magnetometer</button></div>
  <div class="col-sm-3 text-center"><button class="btn btn-warning" type="button" onclick="">Light</button></div>
  <div class="col-sm-3 text-center"><button class="btn btn-warning" type="button" onclick="">Temperature</button></div>
  <div class="col-sm-3 text-center"><button class="btn btn-warning" type="button" onclick="">Pressure</button></div>
  <div class="col-sm-3 text-center"><button class="btn btn-warning" type="button" onclick="">Humidity</button></div>
  <div class="col-md-4"><img src="./resources/images/fidzeallogo.png" alt="logo"></div>
 
  </div> -->
  
  <script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/jquery-2.0.3.js"></script>
  <script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
   <script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min1.10.7.js"></script>
  <script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/home.js"></script> 
   <script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/xdk_home.js"></script>
  
  
</body>
</html>

