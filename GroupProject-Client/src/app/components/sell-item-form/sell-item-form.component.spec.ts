import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SellItemFormComponent } from './sell-item-form.component';

describe('SellItemFormComponent', () => {
  let component: SellItemFormComponent;
  let fixture: ComponentFixture<SellItemFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SellItemFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SellItemFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
