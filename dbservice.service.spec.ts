import { TestBed } from '@angular/core/testing';

import { DBserviceService } from './dbservice.service';

describe('DbserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DBserviceService = TestBed.get(DBserviceService);
    expect(service).toBeTruthy();
  });
});
