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
            <div class="col-md-4"><img src="./resources/images/logo-white-header.png" alt="logo" style="height: 82px;width: 147px;">
            </div>
            <div class="col-md-4">
                <b><h1>IOT AUTOMATION</h1></b>
            </div>
        </div>
    </div>

    <!-- <div class="row submit">
  <div class="col-sm-6 text-center"><button class="btn btn-success btn-md" type="button" onclick="philipsHome()">Philips</button></div>
  <div class="col-sm-6 text-center"><button class="btn btn-success" type="button" onclick="xdkHome()">XDK</button></div>
  <div class="col-sm-6 text-center"><button class="btn btn-success" type="button" onclick="lmsHome()">LMS</button></div>
  <div class="col-sm-6 text-center"><button class="btn btn-success" type="button" onclick="Intesis_home()">Intesis</button></div>
  </div> -->


    <div class="row submit">
        <div class="col-sm-3 text-center">
            <label class="switch">
                <input type="checkbox" onclick="Arduino_sw1('1')">
                <div class="slider">
                </div>
            </label>
            <p>Hall</p>
        </div>
        <div class="col-sm-3 text-center">
            <label class="switch">
                <input type="checkbox" onclick="Arduino_sw1('2')">
                <div class="slider">
                </div>
            </label>
            <p>Office</p>
        </div>
        <div class="col-sm-3 text-center">
            <label class="switch">
                <input type="checkbox" onclick="Arduino_sw1('3')">
                <div class="slider">
                </div>
            </label>
            <p>Kitchen</p>
        </div>
        <div class="col-sm-3 text-center">
            <label class="switch">
                <input type="checkbox" onclick="Arduino_sw1('4')">
                <div class="slider">
                </div>
            </label>
            <p>BedRoom</p>
        </div>
        <div class="col-sm-3 text-center">
            <label class="switch">
                <input type="checkbox" onclick="Arduino_sw1('5')">
                <div class="slider">
                </div>
            </label>
            <p>Balcony</p>
        </div>
        <div class="col-sm-3 text-center">
            <label class="switch">
                <input type="checkbox" onclick="Arduino_sw1('6')">
                <div class="slider">
                </div>
            </label>
            <p>Hall</p>
        </div>
        <div class="col-sm-3 text-center">
            <label class="switch">
                <input type="checkbox" onclick="Arduino_sw1('7')">
                <div class="slider">
                </div>
            </label>
            <p>Kitchen</p>
        </div>
        <div class="col-sm-3 text-center">
            <label class="switch">
                <input type="checkbox" onclick="Arduino_sw1('8')">
                <div class="slider">
                </div>
            </label>
            <p>Kitchen</p>
        </div>
    </div>
    </div>


    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.0.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/home.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min1.10.7.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/rangeslider.js"></script>

    <div class="col-sm-3 text-center">
        <div class="btn btn-md" style="background-color: rgba(189, 183, 183, 0.87);margin-left:83px;margin-top:53px;">
            <div>Dimmer</div>
            <div style="display:inline-block;">
                <input id="slider" type="range" min="0" max="3" value="0" step="1" onchange="Intensity($(this).val())">
                <div id="range" style="display:inline-block;margin-left: 35 px;text-align:center">0
                </div>
            </div>
        </div>
    </div>
    
    
    <div class="btn btn-md" style="background-color: rgba(189, 183, 183, 0.87);margin-left:83px;margin-top:53px;">
	<div>IR</div>
     <select id="Dtimer" onchange= "D_OnOfftimer('+count+')" class="btn btn-default">
       <option>Select</option>
       <option>command 1</option>
        <option>command 2</option>
         <option>command 3</option>
          <option>command 4</option>
          <option>command 5</option>
       </select>  
	</div>

</body>

</html>