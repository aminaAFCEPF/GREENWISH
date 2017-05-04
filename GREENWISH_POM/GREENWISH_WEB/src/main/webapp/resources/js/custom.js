

window.onload = function () {
    
    var btnSearch = document.getElementById("btnSearch");
    var btnLogin = document.getElementById("btnLogin");
    var loginDiv = document.getElementById("loginDiv");
    btnSearch.onclick = recherche;
    var searchDiv = document.getElementById("searchDiv");
    var divNotif = document.getElementById("divNotifs");
    var btnNotif = document.getElementById("btnNotif");
    btnNotif.onclick = notif;
    searchDiv.style.display = "none";
    loginDiv.style.display = "none";
    divNotif.style.display ="none";
    btnLogin.onmouseover = login;
    btnLogin.onmouseout = notLogin;
    loginDiv.onmouseout = notLogin;
}

function recherche() {

    var searchDiv = document.getElementById("searchDiv");
    var searchIco = document.getElementById("btnSearch");

    if (searchDiv.style.display == "none") {
        searchDiv.style.display = "block";
        searchIco.classList.remove("glyphicon-search");
        searchIco.classList.add("glyphicon-remove");
    } else {
        searchDiv.style.display = "none";
        searchIco.classList.remove("glyphicon-remove");
        searchIco.classList.add("glyphicon-search");
    }
    return false;
}

function login() {

    var loginDiv = document.getElementById("loginDiv");

    if (loginDiv.style.display == "none") 
    {
        loginDiv.style.display = "block";
    }
    return false;
}

function notLogin() {
    
    var loginDiv = document.getElementById("loginDiv");
    var btnLogin = document.getElementById("btnLogin");
    
    loginDiv.onmouseover = function() {
        loginDiv.style.display = "block";
    }
    if (loginDiv.onmouseout)
    {
        loginDiv.style.display = "none";
    }
    return false;
}
function notif(){
    var divNotif = document.getElementById("divNotifs");
    
    if (divNotif.style.display == "none") {
        divNotif.style.display = "block";
    } else {
        divNotif.style.display = "none";
    }
    return false;
}