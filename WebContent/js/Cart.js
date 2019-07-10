function onClearCartClick() {
	$.ajax({
		url: "CarrelloServlet",
		method: 'POST',
		data: {
			codiceP: "all",
			action: "rimuovitutto"
		}
	}).done(data => {
		window.location.reload();
	})
}

function onRemoveClick() {
	let caller = event.target;
	const pacchetto = caller.getAttribute("data");
	
	$.ajax({
		url: "CarrelloServlet",
		method: 'POST',
		data:{
			codiceP: pacchetto,
			action: "rimuoviDalCarrello"
		}
	}).done(data =>{
		alert("Prodotto rimosso");
		window.location.reload();
	})
}

const ajaxCallbackFunction = data => {
    const response = JSON.parse(data);

    if(!response.ok) {
        alert("Errore interno al server. Riprova più tardi");
        return null;
    }

    const responseContent = response.content;
    const totalPrice = responseContent.total;
    const products = [];
    responseContent.pacchetti.forEach(product => {
        let result = {
            name: product.titolo,
            unit_amount: {
                currency_code: 'EUR',
                value: "" + product.prezzo
            },
            quantity: 1
        }

        products.push(result);
    })

    return {
        total: "" + totalPrice,
        products: products
    };
}

//Paypal
//Ottienere gli oggetti attualmente nel carrello e passarli a paypal
const createOrderFunction = (data, actions) => {
    let orderInfo;

    $.ajax({
      url: "CheckOutServlet",
      method: 'POST'
    }).done(data => {
        orderInfo = ajaxCallbackFunction(data);
        // Set up the transaction
        return actions.order.create({
            purchase_units: [{
                amount: {
                    value: orderInfo.total, //Costo totale
                    breakdown: { //Informazioni sulle spese
                        item_total: { //Costo totale dei prodotti
                            currency_code: "EUR", //Valuta
                            value: orderInfo.total //Costo
                        }
                    }
                },
                description: "Ordine su StudyMe", //Riepilogo dell'ordine
                items: orderInfo.products
            }]
        });
    });

}
//fare una funzione ajax che richiama la servlet che consiste nel registrare l'ordine nel db
const successFunction = (data, actions) => {	
/*
{function paypalCheckOut(){
	$.ajax({
		url:"AcquistoServlet",
		method:'POST',
	}).done(data =>{
			alert("Prodotto Acquistato");
			window.location.reload();
		})
	}
	*/
    return actions.order.capture().then(function (details) {
        alert('Transaction completed by ' + details.payer.name.given_name);
    })
}

const errorFunction = (err) => {
	if(document.querySelector(".paypalCheckOut") != null)
		alert("Problema con il pagamento. Riprova più tardi");
}

paypal.Buttons({
    createOrder: createOrderFunction,
    onApprove: successFunction,
    onError: errorFunction
}).render('.paypalCheckOut');