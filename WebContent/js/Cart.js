document.addEventLister('DOMContentLoaded', function(){
	paypal.Buttons({
		createOrder: createOrderFunction, error: function(error){
			console.log(error);
		}
	}).render('.paypalCheckOut');
})

let createOrderFunction = (data,actions) =>{
	return actions.order.create({
		//lista oggetti presenti nel carrello
		purchase_units:[{
			amount: {
				value: "49.90" //prezzo
			},
			description: "pacchetto1"
		},{
			amount: {
				value: "55.50"
			},
			description: "pacchetto2"
		}]
	})
}