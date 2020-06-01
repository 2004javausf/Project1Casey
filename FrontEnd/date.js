
function changeDate(){
    console.log("in changeDate");
    let date= document.getElementById("today").value;
    //Step 1
    var xhr= new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange= function(){
        console.log("in ORSC");
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }
    //Step 3
    xhr.open("POST","http://localhost:8080/Reimbursement/changedate",true);
    //Step 4
    var data=JSON.stringify({"date": date});
    console.log(data);
    xhr.send(data);
    alert("Date changed successfully.")
    window.location.href="home.html";

}

window.onload= function(){
    console.log("in onload");
    document.getElementById("submit").addEventListener("click",changeDate,false);
}