function mostraLezioneGratis(url){
	document.getElementById("sfondoVideo").style.display = "block";
	var iframe = document.createElement('iframe');
	iframe.src = url;
	document.getElementById("video").appendChild(iframe);
	document.getElementById("video").style.display = "block";
}

function nascondiLezioneGratis(){
	document.getElementById("sfondoVideo").style.display = "none";
	var iframes = document.querySelectorAll('iframe');
	for (var i = 0; i < iframes.length; i++) {
	    iframes[i].parentNode.removeChild(iframes[i]);
	}
	document.getElementById("video").style.display = "none";
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

function mostraModifiche(codicePacchetto, titolo, prezzo, descrizione){
	document.getElementById("sfondoModificaPacchetto").style.display = "block";
	document.getElementById("containerModificaPacchetto").style.display = "block";
	document.getElementsByName('codPacc')[0].placeholder = codicePacchetto;
	document.getElementsByName('titolo')[0].placeholder = titolo;
	document.getElementsByName('prezzo')[0].placeholder = prezzo;
	document.getElementsByName('descrizione')[0].placeholder = descrizione;	
}

function nascondiModifiche(){
	document.getElementById("sfondoModificaPacchetto").style.display = "none";
	document.getElementById("containerModificaPacchetto").style.display = "none";
}