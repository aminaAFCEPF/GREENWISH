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
		textnode2=document.createTextNode("De "+newHour1+" : "+newMinute1+" &#x00E0; "+newHour2+" : "+newMinute2);
		cell1.appendChild(textnode1);
		//cell1.innerHTML = "De "+newHour1+" : "+newMinute1+" &#x00E0; "+newHour2+" : "+newMinute2;
		//cell2.appendChild(textnode2);
		cell2.innerHTML = "De "+newHour1+" : "+newMinute1+" &#x00E0; "+newHour2+" : "+newMinute2;
		row.appendChild(cell1);
		row.appendChild(cell2);
		tabBody.appendChild(row);		
		hiddenDay = document.createElement("input");
		hiddenH1 = document.createElement("input");
		hiddenM1 = document.createElement("input");
		hiddenH2 = document.createElement("input");
		hiddenM2 = document.createElement("input");
		hiddenDay.setAttribute("type", "hidden");
		hiddenH1.setAttribute("type", "hidden");
		hiddenM1.setAttribute("type", "hidden");
		hiddenH2.setAttribute("type", "hidden");
		hiddenM2.setAttribute("type", "hidden");

		hiddenDay.setAttribute("name", "day");
		hiddenH1.setAttribute("name", "h1");
		hiddenM1.setAttribute("name", "m1");
		hiddenH2.setAttribute("name", "h2");
		hiddenM2.setAttribute("name", "m2");
		
		hiddenDay.setAttribute("value", newDay);
		hiddenH1.setAttribute("value", newHour1);
		hiddenM1.setAttribute("value", newMinute1);
		hiddenH2.setAttribute("value", newHour2);
		hiddenM2.setAttribute("value", newMinute2);
		
		row.appendChild(hiddenDay);
		row.appendChild(hiddenH1);
		row.appendChild(hiddenM1);
		row.appendChild(hiddenH2);
		row.appendChild(hiddenM2);
		
		
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