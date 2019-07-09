function modificaLezione(){
	document.getElementById("sfondoModificaLezione").style.display = "block";
	document.getElementById("containerModificaLezione").style.display = "block";
}

function nascondiModifiche(){
	document.getElementById("sfondoModificaLezione").style.display = "none";
	document.getElementById("containerModificaLezione").style.display = "none";
}

function AddLesson(){
	document.getElementById("sfondoAggiungiLezione").style.display = "block";
	document.getElementById("containerAggiungiLezione").style.display = "block";
}

function nascondiAggiunta(){
	document.getElementById("sfondoAggiungiLezione").style.display = "none";
	document.getElementById("containerAggiungiLezione").style.display = "none";
}

$(document).ready(function(){
	  $('[data-toggle="tooltip"]').tooltip();   
});