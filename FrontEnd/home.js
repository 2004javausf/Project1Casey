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
function getPermissionLevel(){
    var xhr= new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange= function(){
        console.log("in ORSC");
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            let plvl= (xhr.responseText);
            setPage(plvl);
        }
    }
    //Step 3
    xhr.open("POST","http://localhost:8080/Reimbursement/permissionlevel",true);
    //Step 4
    var data=JSON.stringify({"username": username});
    console.log(data);
    xhr.send(data);
}
function setPage(plvl){
    console.log("in setPage");
    switch(plvl){
        case "1":
            document.getElementById("dirSupApp").innerHTML="<input type=\"button\" id=\"dirSup\" value=\"Direct Supervisor Portal\"><br>"
            document.getElementById("dirManGrade").innerHTML="<input type=\"button\" id=\"dirManGrade\" value=\"Direct Supervisor Grade Portal\"><br>"
            document.getElementById("dirSupApp").addEventListener("click",dirSupApp,false);
            document.getElementById("dirManGrade").addEventListener("click",dirManGrade,false);
            break;
        case "2":
            document.getElementById("dirSupApp").innerHTML="<input type=\"button\" id=\"dirSup\" value=\"Direct Supervisor Portal\"><br>"
            document.getElementById("deptHeadApp").innerHTML="<input type=\"button\" id=\"deptHead\" value=\"Department Head Portal\"><br>"
            document.getElementById("dirSupApp").addEventListener("click",dirSupApp,false);
            document.getElementById("deptHeadApp").addEventListener("click",deptHeadApp,false);
            break;
        case "3":
            document.getElementById("dirSupApp").innerHTML="<input type=\"button\" id=\"dirSup\" value=\"Direct Supervisor Portal\"><br>"
            document.getElementById("benCoApp").innerHTML="<input type=\"button\" id=\"benCo\" value=\"BenCo Portal\"><br>"
            document.getElementById("benCoGrade").innerHTML="<input type=\"button\" id=\"benCoGrade\" value=\"BenCo Grade Portal\"><br>"
            document.getElementById("dirSupApp").addEventListener("click",dirSupApp,false);
            document.getElementById("benCoApp").addEventListener("click",benCoApp,false);
            document.getElementById("benCoGrade").addEventListener("click",benCoGrade,false);
            break;
        case "4":
            document.getElementById("dirSupApp").innerHTML="<input type=\"button\" id=\"dirSup\" value=\"Direct Supervisor Portal\"><br>"
            document.getElementById("deptHeadApp").innerHTML="<input type=\"button\" id=\"deptHead\" value=\"Department Head Portal\"><br>"
            document.getElementById("benCoApp").innerHTML="<input type=\"button\" id=\"benCo\" value=\"BenCo Portal\"><br>"
            document.getElementById("benCoGrade").innerHTML="<input type=\"button\" id=\"benCoGrade\" value=\"BenCo Grade Portal\"><br>"
            document.getElementById("dirManGrade").innerHTML="<input type=\"button\" id=\"dirManGrade\" value=\"Direct Supervisor Grade Portal\"><br>"
            document.getElementById("dirSupApp").addEventListener("click",dirSupApp,false);
            document.getElementById("deptHeadApp").addEventListener("click",deptHeadApp,false);
            document.getElementById("benCoApp").addEventListener("click",benCoApp,false);
            document.getElementById("benCoGrade").addEventListener("click",benCoGrade,false);
            document.getElementById("dirManGrade").addEventListener("click",dirManGrade,false);
            break;
    }
}
function form(){
    window.location.href="form.html";
}
function date(){
    window.location.href="date.html";
}
function grade(){
    window.location.href="grade.html";
}
function dirSupApp(){
    window.location.href="dirSupApp.html";
}
function deptHeadApp(){
    window.location.href="deptHeadApp.html";
}
function benCoApp(){
    window.location.href="benCoApp.html";
}
function benCoGrade(){
    window.location.href="benCoGrade.html";
}
function dirManGrade(){
    window.location.href="dirManGrade.html";
}


window.onload= function(){
    console.log("in onload");
    this.checkCookie();
    this.getPermissionLevel();
    document.getElementById("logout").addEventListener("click",logout,false);
    document.getElementById("form").addEventListener("click",form,false);
    document.getElementById("date").addEventListener("click",date,false);
    document.getElementById("grade").addEventListener("click",grade,false);
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