
//User authentication page
function User_authentication()
{
	var usr_name =$('#username').val();
	var pwd =$('#password').val();
	$.ajax({
		type : "POST",
		url  : 'FIOTZ/login',
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify({
			"usr_name" : usr_name,
			"pwd" : pwd
		}),
	success  : function(data)
		{
			if(data==true)
				window.location.href="./home";
			else
				alert('Sorry, FIOTZ doesnot recognize that username or password');
		},

	});
	
//	window.location.href="./home";
}	 
