import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterdosComponent } from './registerdos.component';

describe('RegisterdosComponent', () => {
  let component: RegisterdosComponent;
  let fixture: ComponentFixture<RegisterdosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegisterdosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterdosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
