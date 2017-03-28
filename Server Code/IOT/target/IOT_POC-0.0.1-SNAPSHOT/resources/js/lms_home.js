$(document).ready(function(){
	lighting();
});

function lighting(){
	$.ajax({
		tupe: "GET",
		url : 'MyHome/LMS',
		success : function(data) {
			console.log(data);
			loadbuttons();
		}
	});
}

function loadbuttons(){
//	alert('####');
	$('#listbuttons').html('<div class="col-sm-2 text-center submit" id="bt1"><button class="btn btn-success" type="button" onclick="light()">Lighting</button></div>'+
						   '<div class="col-sm-2 text-center submit" id="bt2"><button class="btn btn-success" type="button" onclick="">Blinds</button></div>'+
						   '<div class="col-sm-2 text-center submit" id="bt2"><button class="btn btn-success" type="button" onclick="">Video door entry</button></div>'+
						   '<div class="col-sm-2 text-center submit" id="bt2"><button class="btn btn-success" type="button" onclick="">Automation</button></div>');  
}