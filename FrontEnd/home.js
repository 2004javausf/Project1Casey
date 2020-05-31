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