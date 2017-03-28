$(document).ready(function(){
	lms_devicelist();
});

var globaldata ;
//var typeId;
//var type;
var D_timer=null;
var D_timer_id;
var R_timer=null;
var R_timer_id;
//var s1;
//var s2="";
var brightness = 1;


// for fetch the config from DB //
function lms_devicelist(){
	$.ajax({
		type : "GET",
		url : 'MyHome/deviceList',
		success : function(data) 
		{
			globaldata =data;
//			console.log(data);
			listdev(data);
		},
 	});
}


// for  Dimmer control 
function D_lightOnOff(count,status){
	
	var s1=status;
		var id = globaldata.lights[count].id;
			if(status==1)
				{
				
					if(D_timer != null)
						{
						
							status = D_timer;
						}
					else if(D_timer == null)
						{
							if(brightness==0)
								status = "*1*1*"+id+"##";
							else
								status = "*1*"+ brightness +"*"+id+"##";
						}
				}
			else
				{
					status = "*1*0*"+id+"##";
				}
	$.ajax({
		type : "POST",
		url : 'MyHome/LMS/control',
		contentType:"application/json",
		dataType: 'json',
		data : JSON.stringify({
		    "cmd":status
		}),
		
		success : function(data) 
		{
			
			console.log(data);
			var len = data.ACK.length;
			 var s2 = data.ACK[0].ACK;
			
				if(s2=="*#*1##" && s1==1){
					$("#D_onbutton").css("background","#00def7");
					$("#D_offbutton").css("background","white");
				}
				else if(s2=="*#*1##" && s1==0){
					$("#D_offbutton").css("background","#00def7");
					$("#D_onbutton").css("background","white");
				}
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
 	});
}


//for  Relay control 
function R_lightOnOff(count,status){
		 var s1=status;
		var id = globaldata.lights[count].id;
			if(status==1)
				{
					if(R_timer != null)
						{
							status = R_timer;
						}
					else if(R_timer == null)
						{
							status = "*1*1*"+id+"##";
						}
				}
			else
				{
					status = "*1*0*"+id+"##";
				}
	$.ajax({
		type : "POST",
		url : 'MyHome/LMS/control',
		contentType:"application/json",
		dataType: 'json',
		data : JSON.stringify({
		    "cmd":status
		}),
		
		success : function(data) 
		{
			console.log(data);
			var len = data.ACK.length;
			 var s2 = data.ACK[0].ACK;
			
			if(s2=="*#*1##" && s1==1){
				  $("#R_onbutton").css("background","#00def7");
				  $("#R_offbutton").css("background","white");
				 }
				 else if(s2=="*#*1##" && s1==0){
				  $("#R_offbutton").css("background","#00def7");
				  $("#R_onbutton").css("background","white");
				 }
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
 	});
}


//Function called at element with id="slider".
function Intensity(count,bri) {
//  $('#range').html(bri); //onchange get value from element with id="slider" and show it in the element with id="range".
  var status;
  brightness = bri;
  var id = globaldata.lights[count].id;
//  alert("brightness : "+brightness);
//  alert("count : "+count);
  if(brightness == 0)
  {
 	brightness = 0;
 	bri=0;
 	status = "*1*"+ brightness +"*"+id+"##";
  }
  else if(brightness == 1)
  {
	brightness = 3;
	bri=10;
	status = "*1*"+ brightness +"*"+id+"##";
  }
  else if(brightness == 2)
  {
	brightness = 4;
	bri=20;
	status = "*1*"+ brightness +"*"+id+"##";
  }
  else if(brightness == 3)
  {
	brightness = 5;
	bri=30;
	status = "*1*"+ brightness +"*"+id+"##";
  }
  else if(brightness == 4)
  {
	brightness = 6;
	bri=40;
	status = "*1*"+ brightness +"*"+id+"##";
  }
  else if(brightness == 5)
  {
	brightness = 7;
	bri=50;
	status = "*1*"+ brightness +"*"+id+"##";
  }
  else if(brightness == 6)
  {
	brightness = 8;
	bri=60;
	status = "*1*"+ brightness +"*"+id+"##";
  }
  else if(brightness == 7)
  {
	brightness = 9;
	bri=70;
	status = "*1*"+ brightness +"*"+id+"##";
  }
  else if(brightness == 8)
  {
	brightness = 10;
	bri=100;
	status = "*1*"+ brightness +"*"+id+"##";
  }
  
  $.ajax({
		type : "POST",
		url : 'MyHome/LMS/control',
		contentType:"application/json",
		dataType: 'json',
		data : JSON.stringify({
		    "cmd":status
		}),
		
		success : function(data) 
		{
			console.log(data);
			
			if(brightness!=0)
			{
				$("#D_onbutton").css("background","#00def7");
				$("#D_offbutton").css("background","white");
			}
			else{
				$("#D_offbutton").css("background","#00def7");
				$("#D_onbutton").css("background","white");
			}
			
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
	});
  $('#range').html(bri);
}

// Timmer for Dimmer
function D_OnOfftimer(count){
	
	var time = $('#Dtimer option:selected').text()
	D_timer_id = globaldata.lights[count].id
	if (time == "Disabled")
		D_timer = null;
	else if(time == "0.5 second")
		D_timer = "*1*18*"+D_timer_id+"##";
	else if(time == "30 seconds")
		D_timer = "*1*17*"+D_timer_id+"##";
	else if(time == "1 minute")
		D_timer = "*1*11*"+D_timer_id+"##";
	else if(time == "2 minutes")
		D_timer = "*1*12*"+D_timer_id+"##";
	else if(time == "3 minutes")
		D_timer = "*1*13*"+D_timer_id+"##";
	else if(time == "4 minutes")
		D_timer = "*1*14*"+D_timer_id+"##";
	else if(time == "5 minutes")
		D_timer = "*1*15*"+D_timer_id+"##";
	else if(time == "15 minutes")
		D_timer = "*1*16*"+D_timer_id+"##";
	
}

//Timmer for Relay
function R_OnOfftimer(count){
	var time = $('#Rtimer option:selected').text()
	R_timer_id = globaldata.lights[count].id
	
	if (time == "Disabled")
		R_timer = null;
	else if(time == "0.5 second")
		R_timer = "*1*18*"+R_timer_id+"##";
	else if(time == "30 seconds")
		R_timer = "*1*17*"+R_timer_id+"##";
	else if(time == "1 minute")
		R_timer = "*1*11*"+R_timer_id+"##";
	else if(time == "2 minutes")
		R_timer = "*1*12*"+R_timer_id+"##";
	else if(time == "3 minutes")
		R_timer = "*1*13*"+R_timer_id+"##";
	else if(time == "4 minutes")
		R_timer = "*1*14*"+R_timer_id+"##";
	else if(time == "5 minutes")
		R_timer = "*1*15*"+R_timer_id+"##";
	else if(time == "15 minutes")
		R_timer = "*1*16*"+R_timer_id+"##";
}


function listdev(data)
{
 var len = data.lights.length;
 for(var count=0;count<len;count++)
 {
  var type = data.lights[count].type ;  
//  alert(type);
  if(type == 'Dimmer'){  
   $('#listitems').append('<li class="nav-pills"><button id= "btnn" class="class="btn btn-info button1" onclick = slide("Dimmer")><h3>'+data.lights[count].customized_name+'</h3></button>'+
     '<div class="dimmer" style="display:none" id="slidedim">'+
     '<h4>'+data.lights[count].customized_name+'</h4></br>'+
     '<div class="btn-group" id="toggle_event_editing">'+
     '<button type="button" id="D_offbutton" class="btn btn-default" onclick=D_lightOnOff('+count+',"0")>OFF</button>'+
     '<button type="button" id="D_onbutton" class="btn btn-default"  onclick=D_lightOnOff('+count+',"1")>ON</button>'+
     '</div><br>'+
     '<br><div>Light Intensity</div>'+
     '<br><div style="display:inline-block;"><input id="slider" type="range" min="0" max="8" value="0" step="1" onchange="Intensity('+count+',$(this).val())"></input><div id="range" style="display:inline-block;margin-left: 35 px;text-align:center">0</div></div>'+
     '<div>Timer</div>'+
     '<select id="Dtimer" onchange= "D_OnOfftimer('+count+')" class="btn btn-default">'+
       '<option>Disabled</option>'+
       '<option>0.5 second</option>'+
        '<option>30 seconds</option>'+
         '<option>1 minute</option>'+
          '<option>2 minutes</option>'+
          '<option>3 minutes</option>'+
          '<option>4 minutes</option>'+
          '<option>5 minutes</option>'+
          '<option>15 minutes</option>'+
       '</select><br></div>'+  
   '</li>');
  }
  else{
   $('#listitems').append('<li class="nav-pills"><button id= "btnn" class="class="btn btn-info" onclick = slide("Relay")><h3>'+data.lights[count].customized_name+'</h3></button>'+
     '<div class="Relay" style="display:none" id="sliderelay">'+
     '<h4>'+data.lights[count].customized_name+'</h4></br>'+
     '<div class="btn-group" id="toggle_event_editing">'+
     '<button type="button" id="R_offbutton" class="btn btn-default" onclick=R_lightOnOff('+count+',"0")>OFF</button>'+
     '<button type="button" id="R_onbutton" class="btn btn-default"  onclick=R_lightOnOff('+count+',"1")>ON</button>'+
     '</div><br><br>'+
     '<div>Timer</div>'+
     '<select id="Rtimer" onchange= "R_OnOfftimer('+count+')" class="btn btn-default">'+
       '<option>Disabled</option>'+
       '<option>0.5 second</option>'+
        '<option>30 seconds</option>'+
         '<option>1 minute</option>'+
          '<option>2 minutes</option>'+
          '<option>3 minutes</option>'+
          '<option>4 minutes</option>'+
          '<option>5 minutes</option>'+
          '<option>15 minutes</option>'+
       '</select><br></div>'+  
     '</div>'+
     '</div>'+
     '</li>');
  }
  }
// lms_monitor();
}


function slide(data)
	{   
			if( data == 'Dimmer')
			{
				$('#slidedim').stop(true).slideToggle('slow');
				$('#sliderelay').hide();
				lms_monitor();
			}
			else if(data == 'Relay'){
			    $('#sliderelay').stop(true).slideToggle('slow');	
			    $('#slidedim').hide();
			    lms_monitor();
			}
	}


function lms_monitor(){
	$.ajax({
		type : "GET",
		url : 'MyHome/LMS/lights/monitor',
		success : function(data) 
		{
			console.log("monitor : "+ data);
			monitor();
		},
		
	});
}

function monitor(){
	lms_monitor();
}

