import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserToken } from '../model/user-token';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor {

  constructor() { }


  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let user = JSON.parse(sessionStorage.getItem('token') ?? '{}') as UserToken;

    const authReq = req.clone({
      headers: req.headers.set('Authorization', `Bearer ${user.token}`)
    });

    return next.handle(authReq);
  }

}
