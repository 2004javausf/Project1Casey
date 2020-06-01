function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
      var c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }

function checkCookie(){
    var username = getCookie("username");
    if (username != "") {
     document.getElementById("greeting").innerHTML="Welcome, "+ username;
    } else {
      alert("Please log in");
      window.location.href = "index.html";
    }
}

function setCookieExpiry(cname, cvalue) {
    var d = new Date();
    d.setTime(d.getTime());
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
  }

function logout(){
    var username = getCookie("username");
    setCookieExpiry("username", username);
    console.log("cookie deleted");
    window.location.href = "index.html";
}


window.onload= function(){
    console.log("in onload");
    this.checkCookie();
    document.getElementById("logout").addEventListener("click",logout,false);
}







/* previous attempt failed. holding 
function loggedIn(authenticate){
    if(true){
        document.getElementById("test").innerHTML="It's working, Jim";
    }else{
        document.getElementById("test").innerHTML="It's not working, Jim";
    }
}

function getLogin(){
    console.log("in get Login");
    //Step 1
    var xhr= new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange= function(){
        console.log("in ORSC");
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var authenticate= JSON.parse(xhr.responseText);
            loggedIn(authenticate);
        }
    }
    //Step 3
    xhr.open("POST","http://localhost:8080/Reimbursement/loggedIn",true);
    //Step 4
    console.log();
    xhr.send();
}
window.onload= function(){
    console.log( "in onload");
    this.getLogin(true);
}
*/