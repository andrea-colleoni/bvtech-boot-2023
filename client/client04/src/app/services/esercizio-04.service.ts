import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Commento } from '../model/commento';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class Esercizio04 {

    urlServizio: string = 'http://localhost:8080/json-test';

    constructor(
        private http: HttpClient
    ) { }

    getCommenti(): Observable<Commento[]> {
        return this.http.get<Commento[]>(`${this.urlServizio}/commenti`);
    }

}
