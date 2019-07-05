function onClearCartClick() {
	$.ajax({
		url: "CarrelloServlet",
		method: 'POST',
		data: {
			codiceP: "all",
			action: "rimuovitutto"
		}
	}).done(data => {
		alert("Prodotti rimossi, ricaricare la pagina");
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
		alert("Prodotto rimosso, ricaricare la pagina");
	})
}

//Paypal
//Ottienere gli oggetti attualmente nel carrello e passarli a paypal
const createOrderFunction = (data, actions) => {
    // Set up the transaction
    return actions.order.create({
        purchase_units: [{
            amount: {
                value: "9.00", //Costo totale
                breakdown: { //Informazioni sulle spese
                    item_total: { //Costo totale dei prodotti
                        currency_code: "EUR", //Valuta
                        value: "9.00" //Costo
                    }
                }
            },
            description: "Ordine su StudyMe", //Riepilogo dell'ordine
            items: [ //Lista dei prodotti acquistati
                {
                    name: "Pacchetto 1", //Nome prodotto
                    unit_amount: { // Costo del singolo prodotto
                        currency_code: "EUR",
                        value: "4.50"
                    },
                    quantity: 1 //Quantità del prodotto
                },
                {
                    name: "Pacchetto 2",
                    unit_amount: {
                        currency_code: "EUR",
                        value: "4.50"
                    },
                    quantity: 1
                }
            ]
        }]
    });
}

//Fare una funzione ajax che richiama la servlet che consiste nel registrare l'ordine nel DB
const successFunction = (data, actions) => {
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

//ELIMINARE DAL DATABASE GLI ATTRIBUTI FUTULI: 
//-ordine: numFattura, nomeCliente, iva, imponibile