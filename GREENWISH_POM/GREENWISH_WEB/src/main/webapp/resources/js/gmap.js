var mylat = [];
var mylng = [];
var mytitle = [];
var valLat1;
var valLng1;
var val;
var val2;
var contentString;
var infowindow = null;

function initMap() {

	console.log("je suis dans l'initMap !");
	mylat = document.getElementsByClassName("tdLat");
	mylng = document.getElementsByClassName("tdLng");
	mytitle = document.getElementsByClassName("title");

	var myOptions = {

		zoom : 10,
		center : new google.maps.LatLng(mylat[0].innerHTML, mylng[0].innerHTML),
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};

	map = new google.maps.Map(document.getElementById('map'), myOptions);
	console.log("map créée");
	
	
	// personnalisation des markers : 
	
	var iconReSize ={
			url :'../resources/img/marker.png',
			scaledSize : new google.maps.Size(25,30),
			origin: new google.maps.Point(0,0),
			anchor : new google.maps.Point(0,20)
	}
	for (var i = 0; i < mylat.length; i++) {
		var valLat = mylat[i].innerHTML;

		var valLng = mylng[i].innerHTML;
		var marker = new google.maps.Marker({
			map : map,
			position : new google.maps.LatLng(mylat[i].innerHTML, mylng[i].innerHTML),
			title: mytitle[i].innerHTML,
			icon:iconReSize
				
		});
		console.log("marker créé");
		contentString = "Adresse principale";
		infowindow = new google.maps.InfoWindow({
		   content: contentString
		 });


		marker.addListener('mouseover', function() {
			infowindow.open(map, marker);
		});

		// infowindow.open(map, marker);
		
	}
	
}
window.onload = initMap;


