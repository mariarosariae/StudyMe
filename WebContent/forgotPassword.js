/**
 * 
 */
/* Un modo più semplice per implemetare la password dimenticata è quello di creare un div che compare quando premo
 * su "password dimenticata" nel quale chiedo all'utente di inserire la sua email e al premere del pulsante "recupera password" 
 * invio la richiesta alla servlet così come ho fatto per login e registrazione con ajax. Dopo di che la servlet si richiama il metodo
 * send email.
 */
$(document).ready(() => {
   const passForgot = $("[class = 'dim']");

   passForgot.on('click', recoveryPassword);
})

const recoveryPassword = event => {
    event.preventDefault();

    $.ajax({
    	url: "ForgotPasswordServlet",
    	method: 'POST'
    }).done(data => {
    	
    }
}