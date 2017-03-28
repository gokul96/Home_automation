$(document).ready(function(){
	intesis_devfeatlist();
	$('#myButton').click(function () {
        $('#two').toggle({direction: 'left' }, 2000);
//		$('#two').toggle();
        });
	$('#on').click(function(){
    	if(this.id == 'on'){
//    		alert('On clicked');
    		command = "SET,1:ONOFF,ON";
    		AcOnOff(command);
    	}
	});
	$('#off').click(function(){
        if(this.id == 'off'){
//    		alert('Off clicked');
    	   command = "SET,1:ONOFF,OFF";
    	   AcOnOff(command);
    	}
    	});
	$('#setmode').click(function(){ 
//	    alert($('#mode :selected').val());
	    modeS = $('#mode :selected').val();
	    if(modeS == "AUTO"){
	    	modeSel = "SET,1:MODE,AUTO";
	    	AcMode(modeSel,modeS);
	    }
	    else if(modeS == "HEAT"){
	    	modeSel = "SET,1:MODE,HEAT";
	    	AcMode(modeSel,modeS);
	    }
	    else if(modeS == "DRY"){
	    	modeSel = "SET,1:MODE,DRY";
	    	AcMode(modeSel,modeS);
	    }
	    else if(modeS == "FAN"){
	    	modeSel = "SET,1:MODE,FAN";
	    	AcMode(modeSel,modeS);
	    }
	    else if(modeS == "COOL"){
	    	modeSel = "SET,1:MODE,COOL";
	    	AcMode(modeSel,modeS);
	    }
	    });
	$('#fanset').click(function(){ 
//	    alert($('#mode1 :selected').val());
	    modeF = $('#mode1 :selected').val();
	    if(modeF == "AUTO"){
	    	modeFSel = "SET,1:FANSP,AUTO";
	    	AcFanSpeed(modeFSel,modeF);
	    }
	    else if(modeF == "1"){
	    	modeFSel = "SET,1:FANSP,1";
	    	AcFanSpeed(modeFSel,modeF);
	    }
	    else if(modeF == "2"){
	    	modeFSel = "SET,1:FANSP,2";
	    	AcFanSpeed(modeFSel,modeF);
	    }
	    else if(modeF == "3"){
	    	modeFSel = "SET,1:FANSP,3";
	    	AcFanSpeed(modeFSel,modeF);
	    }
	    else if(modeF == "4"){
	    	modeFSel = "SET,1:FANSP,4";
	    	AcFanSpeed(modeFSel,modeF);
	    }
	    else if(modeF == "5"){
	    	modeFSel = "SET,1:FANSP,5";
	    	AcFanSpeed(modeFSel,modeF);
	    }
	    else if(modeF == "6"){
	    	modeFSel = "SET,1:FANSP,6";
	    	AcFanSpeed(modeFSel,modeF);
	    }
	    else if(modeF == "7"){
	    	modeFSel = "SET,1:FANSP,1";
	    	AcFanSpeed(modeFSel,modeF);
	    }
	    else if(modeF == "8"){
	    	modeFSel = "SET,1:FANSP,8";
	    	AcFanSpeed(modeFSel,modeF);
	    }
	    else if(modeF == "9"){
	    	modeFSel = "SET,1:FANSP,9";
	    	AcFanSpeed(modeFSel,modeF);
	    }
	});
	$('#vudset').click(function(){ 
//	    alert($('#mode2 :selected').val());
	    modeV = $('#mode2 :selected').val();
	    if(modeV == "AUTO"){
	    	modeVSel = "SET,1:VANEUD,AUTO";
	    	AcVaneUD(modeVSel,modeV);
	    }
	    else if(modeV == "1"){
	    	modeVSel = "SET,1:VANEUD,1";
	    	AcVaneUD(modeVSel,modeV);
	    }
	    else if(modeV == "2"){
	    	modeVSel = "SET,1:VANEUD,2";
	    	AcVaneUD(modeVSel,modeV);
	    }
	    else if(modeV == "3"){
	    	modeVSel = "SET,1:VANEUD,3";
	    	AcVaneUD(modeVSel,modeV);
	    }
	    else if(modeV == "4"){
	    	modeVSel = "SET,1:VANEUD,4";
	    	AcVaneUD(modeVSel,modeV);
	    }
	    else if(modeV == "5"){
	    	modeVSel = "SET,1:VANEUD,5";
	    	AcVaneUD(modeVSel,modeV);
	    }
	    else if(modeV == "6"){
	    	modeFSel = "SET,1:VANEUD,6";
	    	AcVaneUD(modeVSel,modeV);
	    }
	    else if(modeV == "7"){
	    	modeVSel = "SET,1:VANEUD,1";
	    	AcVaneUD(modeVSel,modeV);
	    }
	    else if(modeV == "8"){
	    	modeVSel = "SET,1:VANEUD,8";
	    	AcVaneUD(modeVSel,modeV);
	    }
	    else if(modeV == "9"){
	    	modeVSel = "SET,1:VANEUD,9";
	    	AcVaneUD(modeVSel,modeV);
	    }
	    else if(modeV == "SWING"){
	    	modeVSel = "SET,1:VANEUD,SWING";
	    	AcVaneUD(modeVSel,modeV);
	    }
	});
	$('#vlrset').click(function(){ 
//	    alert($('#mode3 :selected').val());
	    modeVLR = $('#mode3 :selected').val();
	    if(modeVLR == "AUTO"){
	    	modeVLRSel = "SET,1:VANELR,AUTO";
	    	AcVaneLR(modeVLRSel,modeVLR);
	    }
	    else if(modeVLR == "1"){
	    	modeVLRSel = "SET,1:VANELR,1";
	    	AcVaneLR(modeVLRSel,modeVLR);
	    }
	    else if(modeVLR == "2"){
	    	modeVLRSel = "SET,1:VANELR,2";
	    	AcVaneLR(modeVSel,modeV);
	    }
	    else if(modeVLR == "3"){
	    	modeVLRSel = "SET,1:VANELR,3";
	    	AcVaneLR(modeVLRSel,modeVLR);
	    }
	    else if(modeVLR == "4"){
	    	modeVLRSel = "SET,1:VANELR,4";
	    	AcVaneLR(modeVLRSel,modeVLR);
	    }
	    else if(modeVLR == "5"){
	    	modeVLRSel = "SET,1:VANELR,5";
	    	AcVaneLR(modeVLRSel,modeVLR);
	    }
	    else if(modeVLR == "6"){
	    	modeVLRSel = "SET,1:VANELR,6";
	    	AcVaneLR(modeVLRSel,modeVLR);
	    }
	    else if(modeVLR == "7"){
	    	modeVLRSel = "SET,1:VANELR,1";
	    	AcVaneLR(modeVLRSel,modeVLR);
	    }
	    else if(modeVLR == "8"){
	    	modeVLRSel = "SET,1:VANELR,8";
	    	AcVaneLR(modeVLRSel,modeVLR);
	    }
	    else if(modeVLR == "9"){
	    	modeVLRSel = "SET,1:VANELR,9";
	    	AcVaneLR(modeVLRSel,modeV);
	    }
	    else if(modeVLR == "SWING"){
	    	modeVLRSel = "SET,1:VANELR,SWING";
	    	AcVaneLR(modeVLRSel,modeVLR);
	    }
	});
	$('#tempset').click(function(){ 
		var temp = $('#tempinp').val();
		var mTemp = temp * 10;
		var modTemp = "SET,1:SETPTEMP,"+mTemp;
		SetTemp(modTemp,temp);
		
	});
//	$('#idd').click(function(){ 
//		var id = "ID";
//		Id(id);
//	});
	
	
});


function intesis_devfeatlist(){
    $('#listdev').html('<div id="devicelist" style="position:absolute;width:149px;height:55px;background-color:grey;">Device1</div><button id="myButton"style="position:absolute;margin-left:55px;height:55px;background-color:LightGrey;"><h>></h></button>');
    $('#two').html('<div id= "onoff" style="display:inline-block;width:300px;height: 85px;border:2px solid Grey ;background-color:black;overflow:auto;"><h style="position:relative;margin-left:90px;margin-top:10px;"></h><button id="on" style="position:relative;margin-left:auto;margin-top:10px;width:50px;text-align:center;">ON</button><button id="off" style="position:absolute;margin-left:auto;margin-top:10px;width:50px;text-align:center;">OFF</button></div></div>'+
    		'<div style="display:inline-block;width:300px;height: 85px;border:2px solid Grey ;background-color:black;overflow:auto;"><h style="position:relative;margin-left:50px;margin-top:10px;">Mode </h><select id="mode" style="position:relative;margin-top:10px;margin-left:auto"><option>AUTO</option><option>HEAT</option><option>DRY</option><option>FAN</option><option>COOL</option></select><button id="setmode" style="position:relative;margin-top:10px;margin-left:auto;">set</button><div id="modestat" style="position:absolute;margin-top:20px;margin-left:100px;"></div></div>'+
    		'<div style="display:inline-block;width:300px;height: 85px;border:2px solid Grey ;background-color:black;overflow:auto;"><h style="position:relative;margin-left:auto;margin-top:10px;">Temperature </h><input id="tempinp"style="position:relative;margin-top:10px;margin-left:auto"type="text"></input><button id="tempset" style="position:relative;margin-top:10px;margin-left:auto;">set</button><div id="tempstat" style="position:absolute;margin-top:20px;margin-left:100px;"></div></div>'+
    		'<div style="display:inline-block;width:300px;height: 85px;border:2px solid Grey ;background-color:black;overflow:auto;"><h style="position:relative;margin-left:50px;margin-top:10px;">Fan Speed </h><select id="mode1" style="position:relative;margin-top:10px;margin-left:auto"><option>AUTO</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option></select><button id="fanset" style="position:relative;margin-top:10px;margin-left:auto;">set</button><div id="fanstat" style="position:absolute;margin-top:20px;margin-left:100px;"></div></div>'+
    		'<div style="display:inline-block;width:300px;height: 85px;border:2px solid Grey ;background-color:black;overflow:auto;"><h style="position:relative;margin-left:50px;margin-top:10px;">Vane position U/D </h><select id="mode2" style="position:relative;margin-top:10px;margin-left:auto"><option>AUTO</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>SWING</option></select><button id="vudset" style="position:relative;margin-top:10px;margin-left:auto;">set</button><div id="vudstat" style="position:absolute;margin-top:20px;margin-left:100px;"></div></div>'+
    		'<div style="display:inline-block;width:300px;height: 85px;border:2px solid Grey ;background-color:black;overflow:auto;"><h style="position:relative;margin-left:50px;margin-top:10px;">Vane position L/R </h><select id="mode3" style="position:relative;margin-top:10px;margin-left:auto"><option>AUTO</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>SWING</option></select><button id="vlrset" style="position:relative;margin-top:10px;margin-left:auto;">set</button><div id="vlrstat" style="position:absolute;margin-top:20px;margin-left:100px;"></div></div>');
   
    //<div><button id="idd">ID</button></div>
}
//<div id="conoff" onclick="AcOnOff()">!</div>
function AcOnOff(command){
	$.ajax({
		type : "POST",
		url : 'Intesis/control',
		contentType:"application/json",
		dataType: 'json',
		data : JSON.stringify({
		    "command":command
		}),
		
		success : function(data) 
		{
			console.log(data);
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
 	});
}

function AcMode(modeSel){
//	var value = $('#mode').val();
	console.log(modeSel);
	var value = modeS;
	$('#modestat').html(value + " mode selected.");
	$.ajax({
		type : "POST",
		url : 'Intesis/control',
		contentType:"application/json",
		dataType: 'json',
		data : JSON.stringify({
		    "command":modeSel
		}),
		
		success : function(data) 
		{
			console.log(data);
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
 	});
}

function AcFanSpeed(modeFSel,modeF){
	var Fvalue = modeF;
	$('#fanstat').html(Fvalue + " mode selected.");
	$.ajax({
		type : "POST",
		url : 'Intesis/control',
		contentType:"application/json",
		dataType: 'json',
		data : JSON.stringify({
		    "command":modeFSel
		}),
		
		success : function(data) 
		{
			console.log(data);
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
 	});
	
	
}

function AcVaneUD(modeVSel,modeV){
	var Vvalue = modeV;
	$('#vudstat').html(Vvalue + " mode selected.");
	$.ajax({
		type : "POST",
		url : 'Intesis/control',
		contentType:"application/json",
		dataType: 'json',
		data : JSON.stringify({
		    "command":modeVSel
		}),
		
		success : function(data) 
		{
			console.log(data);
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
 	});
}

function AcVaneLR(modeVLRSel,modeVLR){
	var VLRvalue = modeVLR;
	$('#vlrstat').html(VLRvalue + " mode selected.");
	$.ajax({
		type : "POST",
		url : 'Intesis/control',
		contentType:"application/json",
		dataType: 'json',
		data : JSON.stringify({
		    "command":modeVLRSel
		}),
		
		success : function(data) 
		{
			console.log(data);
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
 	});
}

function SetTemp(modTemp,temp){
	var temperature = temp;
	$('#tempstat').html("Temperaure is set to " + temperature + " &#8451;");
	$.ajax({
		type : "POST",
		url : 'Intesis/control',
		contentType:"application/json",
		dataType: 'json',
		data : JSON.stringify({
		    "command":modTemp
		}),
		
		success : function(data) 
		{
			console.log(data);
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
 	});
	
}
function Id(id){
	$.ajax({
		type : "POST",
		url : 'Intesis/control',
		contentType:"application/json",
		dataType: 'json',
		data : JSON.stringify({
		    "command":id
		}),
		
		success : function(data) 
		{
			console.log(data);
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
 	});
	
}