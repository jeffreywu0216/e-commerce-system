import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditproComponent } from './editpro.component';

describe('EditproComponent', () => {
  let component: EditproComponent;
  let fixture: ComponentFixture<EditproComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditproComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditproComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
