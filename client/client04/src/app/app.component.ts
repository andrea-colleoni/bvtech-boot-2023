import { Component, OnInit } from '@angular/core';
import { Esercizio04 } from './services/esercizio-04.service';
import { Commento } from './model/commento';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'client04';

  commenti: Commento[] = [];

  constructor(
    private es: Esercizio04,
  ) {    
  }

  ngOnInit(): void {
    this.getCommenti();
  }

  getCommenti() {
    return this.es.getCommenti().subscribe({
      next: c => this.commenti = c
    });
  }

}
