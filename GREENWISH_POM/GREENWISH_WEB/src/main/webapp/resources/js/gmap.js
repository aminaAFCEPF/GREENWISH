var mylat = [];
var mylng = [];
var mytitle = [];
var valLat1;
var valLng1;
var val;
var val2;
var markers = [];
var img = [];
var contentString;
var infowindow = null;

function initMap() {

	mylat = document.getElementsByClassName("tdLat");
	mylng = document.getElementsByClassName("tdLng");
	mytitle = document.getElementsByClassName("title");
	img = document.getElementsByClassName("img");

	var myOptions = {

		zoom : 10,
		center : new google.maps.LatLng(mylat[0].innerHTML, mylng[0].innerHTML),
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};

	map = new google.maps.Map(document.getElementById('map'), myOptions);

	infowindow = new google.maps.InfoWindow({
		   content: contentString
		 });
	
	// personnalisation des markers : 
	var image = {
		    // Adresse de l'icône personnalisée
		    url: '../resources/img/marker.png',
		    // Taille de l'icône personnalisée
		    size: new google.maps.Size(25, 40),
		    // Origine de l'image, souvent (0, 0)
		    origin: new google.maps.Point(0,0),
		    // L'ancre de l'image. Correspond au point de l'image que l'on raccroche à la carte. Par exemple, si votre îcone est un drapeau, cela correspond à son mâts
		    anchor: new google.maps.Point(0, 20)
		};
	var iconReSize ={
			url :'../resources/img/marker.png',
			scaledSize : new google.maps.Size(25,30),
			origin: new google.maps.Point(0,0),
			anchor : new google.maps.Point(0,20)
			}
	for (var i = 0; i < mylat.length; i++) {
		var valLat = mylat[i].innerHTML;

		var valLng = mylng[i].innerHTML;
		 marker = new google.maps.Marker({
			map : map,
			position : new google.maps.LatLng(mylat[i].innerHTML, mylng[i].innerHTML),
			title: mytitle[i].innerHTML,
			icon:iconReSize
				
		});
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


