$(document).ready(function(){
	xdksensordata();
});

/*draw the xdk information*/
// function showacc(){
//	 $.ajax({
//			type : "GET",
//			url : "XDK110/sensorData",
//			success : function(data) 
//			{
//				console.log(data);
//				 var acc=data.XdkData.temperature;
//				 alert("the acc value is "+acc);
//				/*'<td class="boldText">'+data.XdkData.pressure+'</td>'+
//			    '<td style="max-width:140px;word-wrap: break-word;">'+data.XdkData.light+'</td>'+
//			    '<td class="boldText">'+data.XdkData.humidity+'</td>'+
//			    '<td class="boldText">'+data.XdkData.accelerometer+'</td>'+
//			    '<td class="boldText">'+data.XdkData.gyroscope+'</td>'+
//			    '<td class="boldText">'+data.XdkData.magnetometer+'</td>'+
//				*/
//				
//				/*drawXDKsensorData(data);*/
//				
//			},
//			error: function(xhr, statusText, err){
//			}
//		});
// }

function xdksensordata(){
	setInterval( function() {  // for auto refresh
	$.ajax({
		type : "GET",
		url : "XDK110/sensorData",
		success : function(data) 
		{
			console.log(data);
			drawXDKsensorData(data);
		},
		error: function(xhr, statusText, err){
		}
	}); },500);
}


 function drawXDKsensorData(data){	
	 
  if(data!=null) {
			 $('#diffReport tbody').html('<tr>'+
					 	'<td class="boldText">'+data.XdkData.temperature+'</td>'+
						'<td class="boldText">'+data.XdkData.pressure+'</td>'+
					    '<td style="max-width:140px;word-wrap: break-word;">'+data.XdkData.light+'</td>'+
					    '<td class="boldText">'+data.XdkData.humidity+'</td>'+
					    '<td class="boldText">'+data.XdkData.accelerometer+'</td>'+
					    '<td class="boldText">'+data.XdkData.gyroscope+'</td>'+
					    '<td class="boldText">'+data.XdkData.magnetometer+'</td>'+
			   '</tr>');
  }
 }

// function sensors(){
//	 window.location.href="./xdk_home";
//	 }
// 
 
// for pop up window
 
// function myOpen() {
//     window.open("Sample.htm", null, "height=200, width=400, status=yes, toolbar=no, menubar=no, location=no");
// }
 
 
 