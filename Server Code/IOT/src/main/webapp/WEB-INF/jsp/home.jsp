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
                <b><h1>IOT AUTOMATION</h1></b></div>
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
                <input type="checkbox" checked onclick="Arduino_sw1('1')">
                <div class="slider round">
                </div>
            </label>
            <p>Hall</p>

        </div>
        <div class="col-sm-3 text-center">
            <label class="switch">
                <input type="checkbox" checked onclick="Arduino_sw1('2')">
                <div class="slider round">
                </div>
            </label>
            <p>Office</p>

        </div>
        <div class="col-sm-3 text-center">
            <label class="switch">
                <input type="checkbox" checked onclick="Arduino_sw1('3')">
                <div class="slider round">
                </div>
            </label>
            <p>Kitchen</p>

        </div>
        <div class="col-sm-3 text-center">
            <label class="switch">
                <input type="checkbox" checked onclick="Intesis_home()">
                <div class="slider round">
                </div>
            </label>
            <p>Balcony</p>
        </div>
        <!--
         <div class="col-sm-3 text-center">
        <button class="btn btn-success" type="button" onclick="Arduino_sw1()">Hall</button>
        </div>
      <div class="col-sm-3 text-center">
    <button class="btn btn-success" type="button" onclick="Arduino_sw2()">Office</button>
</div>
<div class="col-sm-3 text-center">
    <button class="btn btn-success" type="button" onclick="Arduino_sw3()">Kitchen</button>
</div>
<div class="col-sm-3 text-center">
    <button class="btn btn-success" type="button" onclick="Intesis_home()">Balcony</button>
</div>
-->
    </div>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.0.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/home.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min1.10.7.js"></script>
    <script>
        < script >
            $(function() {
                $('#toggle-one').bootstrapToggle();
            })

    </script>
    </script>
</body>

</html>
