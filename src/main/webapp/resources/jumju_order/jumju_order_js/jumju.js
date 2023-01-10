$(document).ready(function() {
	$('#deliver').click(function(){
		$('#deliver').css("background","#2e91fb")
		$("#delivered").css("background","white")
		$('#delivering').css("background","white")
	})
	$('#delivering').click(function() {
		$('#delivering').css("background","#2e91fb")
		$('#deliver').css("background","white")
		$("#delivered").css("background","white")
	})
	$("#delivered").click(function(){
		$("#delivered").css("background","#2e91fb")
		$('#deliver').css("background","white")
		$('#delivering').css("background","white")
	})
})