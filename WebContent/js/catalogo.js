function mostraLezioneGratis(){
	document.getElementById("sfondoVideo").style.display = "block";
	document.getElementById("video").style.display = "block";
}

function nascondiLezioneGratis(){
	document.getElementById("sfondoVideo").style.display = "none";
	document.getElementById("video").style.display = "none";
	document.getElementById("video").pause();
}

function aggiungiAlCarrello() {
	let caller = event.target;
	const pacchetto = caller.getAttribute("data");
	let dataAction = caller.getAttribute("action");
	let action;
	
	if(dataAction == "false") {
		dataAction = "true";
		action = "aggiungiAlCarrello";
	}
	else {
		dataAction = "false";
		action = "rimuoviDalCarrello";
	}
	
	caller.setAttribute("action", dataAction);
	
	$.ajax({
		url: "CarrelloServlet",
		method: 'post',
		data: {
			codiceP: pacchetto,
			action: action
		}
	}).done(data => {
		const response = JSON.parse(data);
		
		if(response.ok == true) {
			if(action == "aggiungiAlCarrello") {
				document.getElementById("aggiungiAlCarrello").style.background = "red";
				document.getElementById("aggiungiAlCarrello").innerHTML = "Rimuovi dal carrello" + " <i class='fas fa-trash-alt'></i>";
			}
			else {
				document.getElementById("aggiungiAlCarrello").style.background = "#4CAF50";
				document.getElementById("aggiungiAlCarrello").innerHTML = "Aggiungi al carrello" + " <i class='fas fa-cart-plus'></i>";
			}
		}
	})
}