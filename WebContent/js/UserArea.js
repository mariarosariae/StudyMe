function showUpdateAccount(){
	document.getElementById("UpdateUserName").style.display = ("block");
	document.getElementById("ordini").style.display = "none";
	var name = event.target;
	name.classList.add("active");
	document.getElementById("myOrder").classList.remove("active");
	
	$("#updateAccount").animate({
		padding: "10px"
	}, 500);
	
	$("#myOrder").animate({
		padding: "0"
	}, 500);
}

function showOrders(){	
	document.getElementById("UpdateUserName").style.display = ("none");
	document.getElementById("ordini").style.display = "block";
	var name = event.target;
	name.classList.add("active");
	document.getElementById("updateAccount").classList.remove("active");

	$("#myOrder").animate({
		padding: "10px"
	}, 500);
	
	$("#updateAccount").animate({
		padding: "0"
	}, 500);
	
	const checkElement = document.querySelector(".orderHeader");
	
	if(checkElement != null)
		return;
	
	$.ajax({
		url: "GetListaProdottiUtente",
		method : 'POST',
	}).done( data => {
		const response = JSON.parse(data);
		
		if(response.ok == true) {
			const element = document.querySelector(".divTableHeading");
			const content = response.content;
			
			content.forEach(ordine => {
				let div = "<div class='divTableRow'><div class='orderHeader'>";
				div += "<span class='nOrdine'><b>Numero ordine:</b> " + ordine.numOrdine + " </span><span class='data'><b>Data Ordine:</b> " + ordine.data+"</span>";
				div += "</div><div class = 'orderInfo'>";
				
				const pacchettiAcquistati = ordine.pacchettiAcquistati;
				pacchettiAcquistati.forEach(dettOrdine => {
					let sottoOrdine = "<div class='pacchettoOrdine'>";
					sottoOrdine += "<img src='" + dettOrdine.foto + "'/>";
					sottoOrdine += "<span class='titolo'>"+ dettOrdine.titolo + "</span>";
					sottoOrdine += "<span class='prezzo'> " + dettOrdine.prezzo + "&euro;</span>";
					sottoOrdine += "</div>";
					
					div += sottoOrdine;
				})
				
				div += "</div></div>";
				
				element.innerHTML = element.innerHTML + div;
			})
		}
	})
}

$(document).ready(() => {
    //Seleziono le due form: login e registrazione con jquery
    const formUpdateEmail = $("[name='updateEmail']");
    const formUpdatePassword = $("[name= 'updatePassword']");
 
    //Chiama l'evento onLoginSubmit o onSignUpSubmit quando viene fatto il submit della form
    formUpdateEmail.on('submit', changeEmail);   
    formUpdatePassword.on('submit', changePassword);   
})

const changeEmail = event => {
	event.preventDefault();
	
	let newUserEmail = document.getElementById("changeEmail");
    
    $.ajax({
        url: "UpdateServlet",
        method: 'POST',
        data: {
            NuovaEmailUtente: newUserEmail.value
        }
    }).done(data => {
    	const response = JSON.parse(data);
    	
    	if(response.ok == true){
    		document.getElementById("formEmail").style.display = "none";
    		document.getElementById("email").style.display = "block";
    	} else{
    		const messageError = $("#messageErrorEmail");
	        messageError.text(response.message);
	        messageError.css("opacity", "1");
    		newUserEmail.value = "Riprova";
    		newUserEmail.style.border = "1px solid red";
    	}
    })
}

const changePassword  = event => {
	event.preventDefault();
	
    let newUserPassword = document.getElementById("changePassword");
    let newUserPasswordConf = document.getElementById("confChangePassword");
    
    $.ajax({
        url: "UpdateServlet",
        method: 'POST',
        data: {
            NuovaPasswordUtente: newUserPassword.value,
            ConfermaNuovaPasswordUtente: newUserPasswordConf.value
        }
    }).done(data => {
    	const response = JSON.parse(data);
    	
    	if(response.ok == true){
    		const messageError = $("#messageErrorPassword");
    		messageError.css("opacity", "0");
    		document.getElementById("formPassword").style.display = "none";
    		document.getElementById("password").style.display = "block";
    	} else{
    		const messageError = $("#messageErrorPassword");
    		messageError.text(response.message);
        	messageError.css("opacity", "1");
    		newUserPassword.value= null;
    		newUserPasswordConf.value = null;
    		newUserPassword.style.border = "1px solid red";
    		newUserPasswordConf.style.border = "1px solid red";
    	}
    })
}