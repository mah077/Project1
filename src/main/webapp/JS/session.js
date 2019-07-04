function checkSession() {
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {//ready state =4 request finish resp ready status =200 resquest succsess
			let logged = xhr.responseText; //the response comming from the server
			
			console.log(logged);
			
			if(logged == 0) {// if its zero means it not connected to the server
				window.location.href = "./firstPage.html";// go back to the home page
			}
		}//else condistion
	}
	
	xhr.open("GET", "./auth", true);// it calling the authServlet to see if the user log in or no from web.xml
	
	xhr.send();
}

window.onload = function() {
	checkSession();
}