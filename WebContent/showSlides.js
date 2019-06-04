$(document).ready(() => {
    scorrimentoFoto();

    $(".barraCategorie").niceScroll(
        {
            cursorborder: "none",
            cursorcolor: "#3490CD"
        }
    );
})

var _slide_index = 0;


function scorrimentoFoto(){
    var elements = document.getElementsByClassName("slideshow");

    for(i = 0; i < elements.length; i++){
        elements[i].style.display = "none";
        elements[i].classList.remove("fade");
    }
      
    elements[_slide_index].style.display = "block";
    elements[_slide_index].classList.add("fade");
    _slide_index++;

    if(_slide_index >= elements.length)
        _slide_index = 0;

    setTimeout("scorrimentoFoto()", 7500);
}

function mostraLogin() { 
	var x = document.getElementsByClassName("sfondo-login");
	var y = document.getElementsByClassName("container-login");
	var i, j;
	
	for (i = 0; i < 1; i++) {
		x[i].style.display = "block";
	}
	
	for (j = 0; j < 1; j++) {
		y[j].style.display = "block";
	}
	
	for (i = 1; i < x.length; i++) {
		x[i].style.display = "none";
	}
	
	for (j = 1; j < y.length; j++) {
		y[j].style.display = "none";
	}
}

function mostraRegistrazione(){
	var x = document.getElementsByClassName("sfondo-login");
	var y = document.getElementsByClassName("container-login");
	var i, j;

	for (i = 0; i < 1; i++) {
		x[i].style.display = "none";
	}
	
	for (j = 0; j < 1; j++) {
		y[j].style.display = "none";
	}
	
	for (i = 1; i < x.length; i++) {
		x[i].style.display = "block";
	}
	
	for (j = 1; j < y.length; j++) {
		y[j].style.display = "block";
	}
}

function nascondi() {
	var x = document.getElementsByClassName("sfondo-login");
	var y = document.getElementsByClassName("container-login");
	var i, j;
	
	for (i = 0; i < x.length; i++) {
		x[i].style.display = "none";
	}
	
	for (j = 0; j < y.length; j++) {
		y[j].style.display = "none";
	}
}