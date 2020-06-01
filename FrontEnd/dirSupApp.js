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
    username = getCookie("username");
    if (username != "") {
    } else {
      alert("Please log in");
      window.location.href = "index.html";
    }
}

function setPage(tableContents){
    for(i=0; i<tableContents.length; i++){ //5 fields per item
            document.getElementById("tables").innerHTML+="<tr><td>" + tableContents[i].id + "</td>";
            document.getElementById("tables").innerHTML+="<td>" + tableContents[i].username + "</td>";
            document.getElementById("tables").innerHTML+="<td>" + tableContents[i].request + "</td>";
        //discard request state
            document.getElementById("tables").innerHTML+="<td>" + tableContents[i].deadline + "</td></tr>";
    }
}

function getSupervisorTables(){
    var xhr= new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange= function(){
        console.log("in ORSC");
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            let tableContents= JSON.parse(xhr.responseText);
            setPage(tableContents);
        }
    }
    //Step 3
    xhr.open("POST","http://localhost:8080/Reimbursement/getsupervisortables",true);
    //Step 4
    var data=JSON.stringify({"username": username});
    console.log(data);
    xhr.send(data);
}

window.onload= function(){
    console.log("in onload");
    this.checkCookie();
    this.getSupervisorTables();
    document.getElementById("approve").addEventListener(click,approve,false);
    document.getElementById("deny").addEventListener(click,deny,false);
}