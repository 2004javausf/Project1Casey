function loadPage(authenticate){
    if(authenticate==true){
        window.location.href = "home.html";
    }else{
        document.getElementById("invalid").innerHTML="Invalid username or password. Please try again.";
    }

}


function getLogin(){
    console.log("in get Login");
    let username= document.getElementById('username').value;
    let password= document.getElementById('password').value;
    //Step 1
    var xhr= new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange= function(){
        console.log("in ORSC");
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var authenticate= JSON.parse(xhr.responseText);
            loadPage(authenticate);
        }
    }
    //Step 3
    xhr.open("POST","http://localhost:8080/Reimbursement/login",true);
    //Step 4
    var data=JSON.stringify({"username": username, "password": password});
    console.log(data);
    xhr.send(data);
}
window.onload= function(){
    console.log( "in onload");
    document.getElementById("login").addEventListener("click",getLogin,false);
}