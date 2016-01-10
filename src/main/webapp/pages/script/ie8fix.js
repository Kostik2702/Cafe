var vh = $(window).height();
$("#wrap, #wrap2, #sliderbox, #sliderarrow").css("height",vh+"px");

$(window).resize(function(){
	vh = $(window).height();
	$("#wrap, #wrap2, #sliderbox, #sliderarrow").css("height",vh+"px");
});