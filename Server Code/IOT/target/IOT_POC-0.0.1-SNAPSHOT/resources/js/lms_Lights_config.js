$(document).ready(function(){
 lms_lights_config();
 var gbdata;
});


function lms_lights_config(){
 $.ajax({
  type : "GET",
  url : 'MyHome/LMS/device_list',
  success : function(data) 
	  {
	   console.log(data);
	   gbdata = data;           
	   listdevices();
	  },
  });
}

function listdevices(){
 
 var len = gbdata.device_list.length;
 var slno=1;
 if(len>0){
 for(count = 0;count<len;count++){
	 $('#diffReport tbody').append('<tr>'+'<td>'+(slno++)+'</td>'+
    '<td><div id="port'+(count)+'">'+gbdata.device_list[count].id +'</div></td>'+
    '<td>'+ '<select name="devicetype" id ="type'+(count)+'">'+'<option value="Relay">Relay</option>'+'<option value="Dimmer">Dimmer</option>' +'</td>'+
    '<td>'+ '<input id="inp'+(count)+'" type=text></text>'+'</td>'+'</tr>');
 	}
 }
}

function sendDataToDB(){
 var id = ""
 var customized_name = "";
    var dev_type = "";
    var pTable =$('#diffReport').dataTable();
    var nodes = pTable.fnGetNodes();
    if(nodes != null){
     for(n = 0; n < nodes.length;n++){
//    console.log(n);
      id = $('#port'+n).text();
      customized_name = $('#inp'+n).val();
      dev_type = $('#type'+n).val();
      $.ajax({
			    type : "POST",
			    url : 'MyHome/LMS/set_config',
			    contentType:"application/json",
			    dataType: 'json',
			    data : JSON.stringify(
			    		{
				    		"id":id,
				            "customized_name":customized_name,
				            "type":dev_type,
			    		}),
			    success : function(data) {
			    console.log(data);
			    },
			    error: function(xhr, statusText, err){
			    console.log(xhr);
			    }
   });
 }
     
     alert('Success..,  your devices are configured...');
     }     
    
}