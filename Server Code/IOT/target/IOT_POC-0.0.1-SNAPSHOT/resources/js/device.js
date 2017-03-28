$(document).ready(function(){
	fnfetchbridgedata();
});

/*draw the bridge information*/
function fnfetchbridgedata(){
	$.ajax({
		type : "GET",
		url : 'HueBridge/configuration',
		success : function(data) {
		/*	var data={
					"name": "FZ Hue-1",
					"mac": "00:17:88:1c:89:0e",
					"ipaddress": "192.168.1.147",
					"swversion": "01033978",
					"apiversion": "1.14.0",
				};*/
			console.log(data);
			fnDrawbridgeTableData(data);
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
	});
}

 function fnDrawbridgeTableData(data){	
	 console.log(data);
	 var len = data.Controllers.length;
	 if(len>0) 
	 {
		for(var count= 0; count<len;count++)
		  {
			 $('#diffReport tbody').append('<tr onclick="fnlistview()">'+
					 	'<td class="boldText">'+data.Controllers[count].name+'</td>'+
						'<td class="boldText">'+data.Controllers[count].IP+'</td>'+
					    '<td style="max-width:140px;word-wrap: break-word;">'+data.Controllers[count].mac+'</td>'+
					    
					    /*'<td class="boldText">'+data.Controllers[count].swversion+'</td>'+
					    '<td class="boldText">'+data.Controllers[count].apiversion+'</td>'+*/
			   '</tr>');
		  }
	 }
 }

 function fnlistview(){
	 window.location.href="./deviceList";
	 }
 
