import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserToken } from 'src/app/model/user-token';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  risposta: string = 'non eseguito';

  constructor(
    private http: HttpClient,
  ) { }

  ngOnInit() {
  }

  login(email: string, password: string) {
    this.http.post<UserToken>('http://localhost:8080/auth/login', {email: email, password: password}).subscribe({
      next: r => {
        sessionStorage.setItem('token', JSON.stringify(r));
      }
    });
  }

  verifica() {
    this.http.get('http://localhost:8080/secure/hello').subscribe({
      next: r => {
        this.risposta = JSON.stringify(r);
      }
    });
  }
}
