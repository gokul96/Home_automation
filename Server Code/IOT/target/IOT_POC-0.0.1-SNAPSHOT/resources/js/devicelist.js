var colorloop=false;
$(document).ready(function(){
	fnfetchDevicedata();
});

/*draw the bridge information*/
var onOroff = false;
var deciceId = 0;
var reachable ;
function fnfetchDevicedata(){
	$.ajax({
		type : "GET",
		url : 'HueBridge/lights',
		success : function(data) {
			console.log(data);
			if(data.status == "sucess")
			{
				fnDrawDeviceTableData(data);
				var len =data.device.length;
				for(var i=0;i<len;i++)
					{
						reachable=data.device[i].reachable;
					}
				
				if(reachable == false)
					{
						alert('Sorry..! currently your devices are not reachable...');
						$('#reportDevice').css("pointer-events","none");
					}
			}
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
	});
}

 function fnDrawDeviceTableData(data){
//	 console.log(data);
$('#reportDevice').html('<table id="diffReport" class="dataTable" style="overflow-x:hidden;"><thead><tr><th style="padding: 8px 0px;"><div class="squaredOne" style="margin-left:20px;"><input class="headCheck icheckbox" type="checkbox" name=editBtnAll id=editBtn onclick=checkBox() /><label for="squaredOne"></label></div></th>'+
		'<th><span>DeviceId</span></th><th><span>DeviceName</span></th><th><span>Colour Loop</span></th><th><span>Color</span></th><th><span>Brightness</span></th><th>On/Off</th><th>Reachable</th></tr></thead><tbody></tbody></table>');
/*if (data.users)*/
var len = data.device.length;
/*$("#userCount").text(len);*/
if(len > 0){					
	for(var count =0 ; count <len;count++){ 
		
		if (data.device[count].colorloop == true) {
		    colorloop = '<td class="boldText"><input type="checkbox" class="chkNumber'+(count)+'" value="colorloop" checked/"></td>';
	    } else {
	    	colorloop = '<td class="boldText"><input type="checkbox" class="chkNumber'+(count)+'" value="colorloop" /"></td>';	
	    }
		
//		console.log(data.device[count].xy);
		var xy = (data.device[count].xy);
		
		var num = parseFloat(xy[0]);
		var str = num.toFixed(5);
		str1 = str.substring(0, str.length-3);
		var num = parseFloat(xy[1]);
		var str = num.toFixed(5);
		str2 = str.substring(0, str.length-3);
		var temp = str1+","+str2;
		
		var colorDisable="";
		
		if ( temp == "0.40,0.51" ){
		  var xyStr = '</option><option value="0.3174,0.3207" >White </option><option value="0.168,0.041">Blue</option><option value="0.408,0.517" selected>Dark Green </option><option value="0.674,0.322">Dark Red</option><option value="0.4859,0.4599">Gold</option><option value="0.3824,0.1601">Magenta</option>'
		} else if (temp == "0.67,0.32" ){
			var xyStr = '<option value="0.3174,0.3207" >White </option><option value="0.168,0.041">Blue</option><option value="0.408,0.517" >Dark Green </option><option value="0.674,0.322" selected>Dark Red</option><option value="0.4859,0.4599">Gold</option><option value="0.3824,0.1601">Magenta</option>'	
		} else if (temp == "0.16,0.04" ){
			var xyStr = '<option value="0.3174,0.3207" >White </option><option value="0.168,0.041" selected>Blue</option><option value="0.408,0.517" >Dark Green </option><option value="0.674,0.322">Dark Red</option><option value="0.4859,0.4599">Gold</option><option value="0.3824,0.1601">Magenta</option>'	
		} else if ((temp == "0.48,0.45" ) || (temp == "0.48,0.46" )) {
			var xyStr = '<option value="0.3174,0.3207" >White </option><option value="0.168,0.041" >Blue</option><option value="0.408,0.517" >Dark Green </option><option value="0.674,0.322">Dark Red</option><option value="0.4859,0.4599" selected>Gold</option><option value="0.3824,0.1601">Magenta</option>'	
		}else if (temp == "0.38,0.16" ) {
			var xyStr = '<option value="0.3174,0.3207" >White </option><option value="0.168,0.041" >Blue</option><option value="0.408,0.517" >Dark Green </option><option value="0.674,0.322">Dark Red</option><option value="0.4859,0.4599">Gold</option><option value="0.3824,0.1601" selected>Magenta</option>'
		}else{
			var xyStr = '<option value="0.3174,0.3207" selected>White </option><option value="0.168,0.041" >Blue</option><option value="0.408,0.517" >Dark Green </option><option value="0.674,0.322">Dark Red</option><option value="0.4859,0.4599">Gold</option><option value="0.3824,0.1601">Magenta</option>'
		}
		
		$('#diffReport tbody').append('<tr>'+
				'<td><div class="squaredOne" style="margin-left:10px"><input type=checkbox name=editBtn class="checkall icheckbox" id=editBtn'+(count)+'></input><label for="squaredOne"></label></div>'+
				' <input type=hidden id=deviceId'+(count)+' value="'+data.device[count].id+'">'+
				
				'</td>'+
				'<td class="boldText">'+data.device[count].id+'</td>'+
				 '<td class="boldText"><input id=name'+(count)+' type=text value='+data.device[count].device_name+'></td>'+
				     colorloop+
				    '<td class="boldText"><select name="carlist" id="colorvalue'+(count)+'">'+xyStr+'</select></td>'+
				    '<td class="boldText"><input  id=bright'+(count)+' maxlength="3" type=text  value='+data.device[count].bri+'></td>'+
				    '<td class="boldText">'+'<div class="btn-group" id="toggle_event_editing" ><button type="button" class="btn btn-default" onclick="off('+data.device[count].id+');" id="offStatus'+data.device[count].id+'">OFF</button><button type="button" class="btn btn-default" onclick="on('+data.device[count].id+');" id="onStatus'+data.device[count].id+'">ON</button></div>'+'</td>'+
				    '<td class="boldText">'+data.device[count].reachable+'</td>'+
		        '</tr>');
		if(data.device[count].on == true){
			$("#onStatus"+(data.device[count].id)).css("background","green");
		}
		else{
			$("#offStatus"+(data.device[count].id)).css("background","red");
		}
	     }
     }
   }
 
/*InputcheckBoxClickAll*/

 function checkBox(){
		 $("#editBtn").change(function () {
			 $("input:checkbox").prop('checked', $(this).prop("checked"));
		    $('.chkNumber0').prop('checked', false);
		    $('.chkNumber1').prop('checked', false);
		    $('.chkNumber2').prop('checked', false);
		});
 }

 /*InputcheckBoxClickAllFinish*/

 
 function fnsubmitDevicedata(id){
//	 setInterval ( function () {
		$.ajax({
			type : "POST",
			url : 'HueBridge/lights/state',
			contentType:"application/json",
			dataType: 'json',
			data : JSON.stringify({
	            "id":id,
	            "onof":""+onOroff,
	          
			}),
			success : function(data) {
				console.log(data);
				if(data.reachable==false)
				{
					$("#offStatus"+id).css("background","red");
					$("#onStatus"+id).css("background","none");
					$('#reportDevice').css("pointer-events","none");
//					alert('Sorry..! currently your devices are not reachable...');
				}
				/*var len = data.length; //data.device.length;
				alert('len'+len);
				for(var count =0 ; count <len;count++){ 
				if(data.device[count].reachable == false){
					console.log(data.device[count].reachable);
				}
				}*/
					/*console.log(data[0].success["/lights/"+id+"/state/on"]);
					if(data[0].success["/lights/"+id+"/state/on"]==true){
						$("#onStatus"+id).css("background","green");
					}
					else{
						$("#onStatus"+id).css("background","red");
					}*/
					

					//local.href = "./HueBridge/deviceList";
				/*}*/
			
				//local.href = "./HueBridge/deviceList";
			},
			error: function(xhr, statusText, err){
			    console.log(xhr);
			}
		});
//		} ,1000);
		
	}

function off(id){
	onOroff = false;
	fnsubmitDevicedata(id);
	$("#offStatus"+id).css("background","red");
	$("#onStatus"+id).css("background","none");
}
function on(id){
	onOroff= true;
	fnsubmitDevicedata(id);
	$("#onStatus"+id).css("background","green");
	$("#offStatus"+id).css("background","none");
}

	function fnFetchId() {
	    var id = [];
	    var deviceRow = [];
	    var idValue = "";
	    var name = "";
	    var brightness ="";
		var oTable=$('#diffReport').dataTable();
		var nodes = oTable.fnGetNodes();
	   if(nodes != null) {
	   	var checked = [];
			var count = 0;
			for(var n = 0; n < nodes.length; n++) {
				console.log("selected : "+$('#editBtn' + n).is(":checked"));
				if ($('#editBtn' + n).is(":checked")) {
					var id_n ={};
					
					checked.push(count++);
					idValue =$('#deviceId'+n).val();
					id.push(idValue);
					name       =$('#name'+n).val();
					brightness =$('#bright'+n).val();
					
					if(brightness>254||brightness<1)
						{
							alert('Brightness range 1 to 254');
						}
					
//					 var durationValue = $('#durationvalue'+n+' option:selected').val();
					  var colorvalue = $('#colorvalue'+n+' option:selected').val();
					  console.log("name : "+name);
					  console.log("id : "+idValue);
					  console.log("brightn : "+brightness);
					  //console.log("durationValue : "+durationValue);
					  console.log("colorvalue : "+colorvalue);
					  
					  /*alert("the color value is "+colorvalue);*/
					  var colorloop = $('.chkNumber' + n).is(":checked");
					  
					  console.log("colorloop :",$('.chkNumber' + n).is(":checked"));
					  id_n.brigtness = brightness;
					  id_n.name = name;
					  id_n.colorValue = colorvalue;
					  deviceRow.push(id_n);
					  
					  
					  $.ajax({
							type : "POST",
							url : 'HueBridge/lights/new_state',
							contentType:"application/json",
							dataType: 'json',
							data : JSON.stringify({
								    "id":idValue,
						            "brightness":brightness,
						            //"duration":durationValue,
						            "color":colorvalue,
						            "colorloop":colorloop,
						            "name":name,
//						            "onof":""+onOroff
							}),
							success : function(data) {
								fnfetchDevicedata();
								console.log(data);
//								alert('sucess');
//								alert('******');
								/*if(data.status == "success"){
									fnfetchDevicedata();
									//local.href = "./HueBridge/deviceList";
								}*/
							
								//local.href = "./HueBridge/deviceList";
							},
							error: function(xhr, statusText, err){
							    console.log(xhr);
							}
						});
				}
				
				
			}
			
	   }
	}
