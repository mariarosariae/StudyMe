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