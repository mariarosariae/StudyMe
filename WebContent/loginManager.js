/*
    Funzioni estetiche
*/

function ValidateEmail(inputText)
{
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(inputText.value.match(mailformat))
	{
		document.form1.text1.focus();
			return true;
	}
	else
	{
		alert("You have entered an invalid email address!");
		document.form1.text1.focus();
		return false;
	}
}

function allLetter(inputtxt)
{ 
	//Solo lettere e/o numeri ed abbia una lunghezza minima di 6 e massima di 12 caratteri
	var letters = /^[a-z0-9]{6,12}+$/;
	if(inputtxt.value.match(letters))
	{
		alert('Your name have accepted : you can try another');
		return true;
	}
		else
	{
			alert('Please input alphabet characters only');
			return false;
	}
}

function togglePassword(event) {
	var showClass = "fa-eye-slash";
	var hideClass = "fa-eye";
	
	var x = event.target; /*Memorizza chi ha chiamato l'evento*/
	var input = x.parentElement.querySelector("input");
	
	if (input.type === "password") {
		input.type = "text";
		x.classList.remove(showClass);
		x.classList.add(hideClass);
	} else {
		input.type = "password";
		x.classList.remove(hideClass);
		x.classList.add(showClass);
	}
}

function mostraLogin() { 
	var x = document.getElementsByClassName("sfondo-login");
	var y = document.getElementsByClassName("container-login");
	var i, j;
	
	x[0].style.display = "block";
	
	y[0].style.display = "block";
	
	x[1].style.display = "none";
	
	y[1].style.display = "none";
}

function mostraRegistrazione(){
	var x = document.getElementsByClassName("sfondo-login");
	var y = document.getElementsByClassName("container-login");
	
	x[0].style.display = "none";
	
	y[0].style.display = "none";
	
	x[1].style.display = "block";
	
	y[1].style.display = "block";
}

function mostraRecuperoPassword(){
	var x = document.getElementsByClassName("sfondo-login");
	var y = document.getElementsByClassName("container-login");
	
	x[0].style.display = "none";
	
	y[0].style.display = "none";
	
	x[1].style.display = "none";
	
	y[1].style.display = "none";
	
	x[2].style.display = "block";
	
	y[2].style.display = "block";
}

function nascondi() {
	var x = document.getElementsByClassName("sfondo-login");
	var y = document.getElementsByClassName("container-login");
	
	var i, j;
	
	x[0].style.display = "none";
	
	x[1].style.display = "none";
	
	x[2].style.display = "none";
	
	y[0].style.display = "none";
	
	y[1].style.display = "none";
	
	x[2].style.display = "none";
	
	document.getElementById('messageError').style.opacity= "0";
	document.getElementById('myName').style.border= "1px solid #ccc";
	document.getElementById('myPass').style.border= "1px solid #ccc";
	document.getElementById('myName').style.border= "1px solid #ccc";
	document.getElementById('regPass').style.border= "1px solid #ccc";
	document.getElementById('regPassRepeat').style.border= "1px solid #ccc";
}

/*
    Interfaccia con il backend
*/

$(document).ready(() => {
    //Seleziono le due form: login e registrazione con jquery
    const formLogin = $("[name='login']");
    const formSignUP = $("[name='sign-up']");

    //Chiama l'evento onLoginSubmit o onSignUpSubmit quando viene fatto il submit della form
    formLogin.on('submit', onLoginSubmit);
    formSignUP.on('submit', onSignUpSubmit);
})

const onLoginSubmit = event => {
    //Evita di fare il submit
    event.preventDefault();

    //Selezioniamo gli elementi del login
    let userInput = document.getElementById("myName");
    let userPassword = document.getElementById("myPass");

    $.ajax({
        url: "LoginServlet",
        method: 'POST',
        data: {
            NomeUtente: userInput.value,
            Password: userPassword.value
        }
    }).done(data => {
        const response = JSON.parse(data);

        if(response.ok == true){
        	window.location.reload();
        }else {
        	const messageError = $("#messageError");
        	messageError.text(response.message);
        	messageError.css("opacity", "1");
            userInput.style.border = "1px solid red";
            userPassword.style.border = "1px solid red";
            userInput.value = null;
            userPassword.value = null;
        }         
    })
}

const onSignUpSubmit = event => {
	 event.preventDefault();
	
	 let userInput = document.getElementById("newName");
	 let userEmail = document.getElementById("newEmail");
	 let userPassword = document.getElementById("regPass");
	 let userConfPassword = document.getElementById("regPassRepeat");
	 $.ajax({
	       url: "SignUpServlet",
	       method: 'POST',
	       data: {
	           NomeUtente: userInput.value,
	           Email : userEmail.value,
	           Password: userPassword.value,
	           ConfermaPassword: userConfPassword.value        
	       }
	 }).done(data => {
	       const response = JSON.parse(data);
	        
	       if(response.ok == true){
	    	   window.location.reload();
	       }else {
		        const messageError = $("#signUpMessageError");
		        messageError.text(response.message);
		        messageError.css("opacity", "1");
		        userPassword.style.border = "1px solid red";
		        userConfPassword.style.border = "1px solid red";
		        userPassword.value = null;
		        userConfPassword.value = null;
	       }         
	 })
}