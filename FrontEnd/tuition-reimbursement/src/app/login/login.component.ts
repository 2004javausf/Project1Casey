import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  SERVER_URL = "http://localhost:8080/Reimbursement/login";
  loginForm:FormGroup;

  constructor(
    private http: HttpClient,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: [''],
      password: ['']
    })

  }

  submitForm(){
    let formData: any = new FormData();
    formData.append("username", this.logIn.get('username').value);
    formData.append("password", this.logIn.get('password').value);

    this.http.post('http://localhost:8080/Reimbursement/login', formData).subscribe(
      (response) => console.log(response),
      (error) => console.log(error)
    )
  }
}

