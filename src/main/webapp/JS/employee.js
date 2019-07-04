

function getReimbForm() {
	
	let xhr= new XMLHttpRequest(); // calling get from the servlet
	xhr.onreadystatechange = function(){
		if (xhr.readyState === 4 && xhr.status===200)//check the response is ready and finished
			{
			let form = JSON.parse(xhr.responseText);
			pending(form);
			}
		
		
		
	}
	xhr.open("GET","viewAllReimbursement",true);// open xhr 
	xhr.send();
}

function pending(form){
	    const tableBody = document.getElementById("newform");
	    tableBody.innerHTML="";
	for(i=0 ; i< form.length; i++){
		tableBody.innerHTML+=`
		<tr>
		<td>${form[i].firstname}</td>
		<td>${form[i].lastname}</td>
		<td>${form[i].username}</td>
		<td>${form[i].course_type}</td>
		<td>${form[i].course_location}</td>
		<td>${form[i].course_date}</td>
		<td>${form[i].course_time}</td>
		<td>${form[i].grade_format}</td>
		<td>${form[i].passing_grade}</td>
		<td>${form[i].work_related_justification}</td>
		<td>${form[i].course_discripton}</td>
		<td>${form[i].course_cost}</td>	
		</tr>
		`;
	
	}
	
}


window.onload = function() {
 getReimbForm();
}




