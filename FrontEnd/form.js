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

submitOk = false;
dropDownValue= "University Course";
indexValue=0;
function formUpdate(index){
    switch(index){
        case 0:
            dropDownValue="University Course";
            indexValue=0;
            break;
        case 1:
            dropDownValue="Seminar";
            indexValue=1;
            break;
        case 2:
            dropDownValue="Certification Prep";
            indexValue=2;
            break;
        case 3:
            dropDownValue="Certification";
            indexValue=3;
            break;
        case 4:
            dropDownValue="Technical Training";
            indexValue=4;
            break;
        case 5:
            dropDownValue="Other";
            indexValue=5;
            break;
    }
}

function submitForm(){

    let finalAmount;
    switch(indexValue){
        case 0:
            finalAmount=.8*document.getElementById("cost").value;
            break;
        case 1:
            finalAmount=.6*document.getElementById("cost").value;
            break;
        case 2:
            finalAmount=.75*document.getElementById("cost").value;
            break;
        case 3:
            finalAmount=document.getElementById("cost").value;
            break;
        case 4:
            finalAmount=.9*document.getElementById("cost").value;
            break;
        case 5:
            finalAmount=.3*document.getElementById("cost").value;
            break;
    }

    if(submitOk == false){
        alert("Please fill out the form properly.")
    }else if(confirm("You are about to submit a request for $" + document.getElementById("cost").value+ " as a(n) " + dropDownValue + ". Is this correct? This will come out to a reimbursement of $"+finalAmount)){
        var xhr= new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange= function(){
        console.log("in ORSC");
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            let outString= (xhr.responseText);
            finalSubmit(outString);
        }
    }
    //Step 3
    xhr.open("POST","http://localhost:8080/Reimbursement/newrequest",true);
    //Step 4
    let date = document.getElementById("date").value;
    var data=JSON.stringify({"username": username, "request": finalAmount, "state": "0", "deadline": date});
    console.log(data);
    xhr.send(data);

    }else{
        alert("Form not submitted");
    }
}
function finalSubmit(outString){
    if(outString=="truefalse"){
        alert("This overdrafts your $1k a year budget. Sorry, we cannot accept this.")
    }else if(outString=="falsetrue"){
        alert("Sorry, it is currently too close to the time of your event. 2 weeks minimum notice is required.")
    }else if(outString=="truetrue"){
        alert("Sorry, this amount both overdrafts your $1k a year budget and you are beyond the 2 week notice threshold.")
    }else{
        alert("Successfully submitted request.")
        window.location.href="home.html"
    }
}
function check(){
    if(document.getElementById('cost').value==""){
        submitOk=false;
        alert("Please enter a number in this field");
    }else{
        submitOk=true;
    }
    
}
window.onload= function(){
    console.log("in onload");
    this.checkCookie();
    document.getElementById("submit").addEventListener("click",submitForm,false);
}