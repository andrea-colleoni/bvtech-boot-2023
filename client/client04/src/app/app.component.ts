import { Component, OnInit } from '@angular/core';
import { Esercizio04 } from './services/esercizio-04.service';
import { Commento } from './model/commento';
import { Observable } from 'rxjs';
import { RxStompService } from './services/rx-stomp.service';
import { Message } from '@stomp/stompjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'client04';

  commenti: Commento[] = [];
  messaggi: string[] = [];

  constructor(
    private es: Esercizio04,
    private rxStompService: RxStompService,
  ) {    
  }

  ngOnInit(): void {
    this.rxStompService.watch('/topic/greetings').subscribe((message: Message) => {
      this.messaggi.push(message.body);
      console.debug(message);
    });
  }

  getCommenti() {
    return this.es.getCommenti().subscribe({
      next: c => this.commenti = c
    });
  }

}
