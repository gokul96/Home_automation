$(document).ready(function(){
	oneTimeSW_req();
	
});

/*Control the switches...*/
function Arduino_sw1(status){
//	alert('*****')
	$.ajax({
		type : "POST",
		url : './Ardunio/control',
		contentType:"application/json",
		dataType: 'json',
		data : JSON.stringify({
		    "status": status
		}),
		success : function(data) {
			console.log(data);
		},
		error: function(xhr, statusText, err){
		    console.log(xhr);
		}
	});
}

function oneTimeSW_req()
{
	alert('oneTimeSW_req');
	$.ajax({
		type : "GET",
		url  : './Ardunio/oneTimeSW_req',
		success : function(data) {
			console.log(data);
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
		 

  
  