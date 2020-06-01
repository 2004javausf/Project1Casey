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
        //Check if this overdrafts. if it doesn't,
        //submit finalAmount and username.
    }else{
        alert("Form not submitted");
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