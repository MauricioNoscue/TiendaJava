import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioSessionComponent } from './formulario-session.component';

describe('FormularioSessionComponent', () => {
  let component: FormularioSessionComponent;
  let fixture: ComponentFixture<FormularioSessionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormularioSessionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormularioSessionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
