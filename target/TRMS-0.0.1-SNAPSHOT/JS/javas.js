

function getQueryVariable(variable)
{
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return pair[1];}
       }
       return(false);	
}

window.onload = function() {
	let error = getQueryVariable("error");
	
	$("#error").text("");
	
	if(error == 1) {
		{$("#error").text("Invalid Email or Password");
	}
			//$("#emailHelp").hide();
	}
}