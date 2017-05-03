function addRow()
{
	var newDay = document.getElementById("day").value;
	var newHour1 = document.getElementById("hourOne").value;
	var newMinute1 = document.getElementById("minuteOne").value;
	var newHour2 = document.getElementById("hourTwo").value;
	var newMinute2 = document.getElementById("minuteTwo").value;

	if(newDay !== "Jour"){
		tabBody=document.getElementsByTagName("tbody").item(0);
		row=document.createElement("tr");
		cell1 = document.createElement("td");
		cell2 = document.createElement("td");
		textnode1=document.createTextNode(newDay);
		textnode2=document.createTextNode("De "+newHour1+" : "+newMinute1+" à "+newHour2+" : "+newMinute2);
		cell1.appendChild(textnode1);
		cell2.appendChild(textnode2);
		row.appendChild(cell1);
		row.appendChild(cell2);
		tabBody.appendChild(row);		

	}else{
		alert("Merci d'entrer un jour valide");
	}	
}

$('#tableDispos').on('click', 'tr', function(event) {
	$(this).addClass('active').siblings().removeClass('active');
});

function deleteRow()
{
	tabBody=document.getElementsByTagName("tbody").item(0);
	document.removeChild(tabBody);
}

function passwordAccess(){

	var previousMdp = document.getElementById("previousMdp").value;
	var mdp = "admin";
	if(previousMdp == null || previousMdp !== mdp){
		document.getElementById('newMdp').disabled = true;
		document.getElementById('newMdpConf').disabled = true;
	}


}