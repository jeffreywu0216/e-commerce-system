import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { S3UploadComponent } from './s3-upload.component';

describe('S3UploadComponent', () => {
  let component: S3UploadComponent;
  let fixture: ComponentFixture<S3UploadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ S3UploadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(S3UploadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
