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