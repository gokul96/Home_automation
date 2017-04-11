$(document).ready(function(){
	oneTimeSW_req();
	
});

/*Control the switches...*/
function Arduino_sw1(status){
		
	alert(status);
	$.ajax({
		type : "POST",
		url : './Ardunio/control',
		contentType:"application/json",
		dataType: 'json',
		data : JSON.stringify({
		    "status": status
		}),
		success : function(data) 
		{
			alert('*****')
			console.log(data);
			
			if(data.ACK =! null)
			{
				
	            $(function() {
	                $('#toggle-one').bootstrapToggle();
	            })
			}
		else
			{
				alert("Sorry, Your BTicino server is not connected with network :(");
			}
			
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
	});
}

function oneTimeSW_req()
{
//	alert('oneTimeSW_req');
	$.ajax({
		type : "GET",
		url  : './Ardunio/oneTimeSW_req',
		success : function(data) {
			console.log(data);
			
//			if(data.a[1]==0)
//				{
//				alert('******');
//					$(function() {
//		                $('#toggle-one').bootstrapToggle();
//		            })
//				}
			
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
	});

}



//User authentication page
	function User_authentication()
	{
//		alert('##############');
		window.location.href="./home";
	}
		 

  
  