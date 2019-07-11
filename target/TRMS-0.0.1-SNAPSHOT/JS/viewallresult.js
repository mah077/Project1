

function getReimbForm2() {
	
	let xhr= new XMLHttpRequest(); // calling get from the servlet
	xhr.onreadystatechange = function(){
		if (xhr.readyState === 4 && xhr.status===200)//check the response is ready and finished
			{
			let form = JSON.parse(xhr.responseText);
			pending(form);
			}
		
		
		
	}
	xhr.open("GET","UpdateGrade",true);// open xhr 
	xhr.send();
}

function pending(form){
	    const tableBody = document.getElementById("newform");
	    tableBody.innerHTML="";
	for(i=0 ; i< form.length; i++){
		tableBody.innerHTML+=`
		<tr>
		<td>${form[i].rbf_id}</td>
		<td>${form[i].username}</td>
		<td>${form[i].course_type}</td>
		<td>${form[i].grade_format}</td>
		<td>${form[i].passing_grade}</td>
		<td>${form[i].update_grade}</td>	
		<td>${form[i].course_cost}</td>	
		</tr>
		`;
	
	}
	
}


window.onload = function() {
 getReimbForm2();
}






