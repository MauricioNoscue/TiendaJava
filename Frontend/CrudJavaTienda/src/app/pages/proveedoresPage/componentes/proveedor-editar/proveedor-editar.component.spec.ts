import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProveedorEditarComponent } from './proveedor-editar.component';

describe('ProveedorEditarComponent', () => {
  let component: ProveedorEditarComponent;
  let fixture: ComponentFixture<ProveedorEditarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProveedorEditarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProveedorEditarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
