
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
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
<!-- <div class="container-fluid"> -->
<div class="row heading">

<div class="col-sm-1 text-center submit"><button class="btn btn-info" type="button" onclick="home();">Home</button></div>

<div class="col-md-4"><img src="./resources/images/logo-white-header.png" alt="logo"></div>
<div class="col-md-4">
<b><h1>Philips Hue lightSystem</h1></b></div>
  </div>
  
 <div id="reportDevice"></div>

<!-- <table id="diffReport" class="dataTable" style="overflow-x:hidden;"><thead><tr><th style="padding: 8px 0px;"><div class="squaredOne" style="margin-left:20px;"><input class="headCheck icheckbox" type="checkbox" name=editBtnAll id=editBtn onclick=checkBox() /><label for="squaredOne"></label></div></th>
		<th><span>DeviceId</span></th><th><span>DeviceName</span></th><th><span>Colour Loop</span></th><th><span>Color</span></th><th><span>Brightness</span></th><th>On/Off</th><th>Reachable</th></tr></thead><tbody></tbody></table>
 -->
 
</div>
 
</div>
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Details of Device</h4>
        </div>
        <div class="modal-body">
        <div class="row">
        <div class="col-md-5">
          <span><b>Device Version:</b></span><span></span><br>
			<span><b>OS Version:</b></span><span></span><br>
			<span><b>Device Model:</b></span><span></span><br><br>
			<div class="btn-group" id="toggle_event_editing">
	         <button type="button" class="btn btn-info locked_active" id="offStatus">OFF</button>
	         <button type="button" class="btn btn-default unlocked_inactive" id="onStatus">ON</button>
       </div></div>
        <div class="col-md-6">
       <form action="action_page.php">
  Select your color:
  <input type="color" name="favcolor" id="colorId" value="#ff0000">
  <input id= "onsubmit" type="button" name="submit" value="submit">
</form>
</div>
        </div>
       </div>
      </div>
    </div>
  </div>

  <!-- <div class="col-md-1 submit text-center bg-danger"><button type="button" onclick="fnFetchId();" >SUBMIT</button></div> -->
  <div class="text-center submit"><button class="btn btn-success" type="button" onclick="fnFetchId();" >SUBMIT</button></div>
  
  
   <script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/jquery-2.0.3.js"></script>
  <script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/devicelist.js"></script>
  <script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
   <script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min1.10.7.js"></script>
    <script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/js/home.js"></script>
</body>
</html>

