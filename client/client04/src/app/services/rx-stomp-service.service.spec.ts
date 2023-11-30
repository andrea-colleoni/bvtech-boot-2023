/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { RxStompServiceService } from './rx-stomp-service.service';

describe('Service: RxStompService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RxStompServiceService]
    });
  });

  it('should ...', inject([RxStompServiceService], (service: RxStompServiceService) => {
    expect(service).toBeTruthy();
  }));
});
