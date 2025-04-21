import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TarjetaProveedorComponent } from './tarjeta-proveedor.component';

describe('TarjetaProveedorComponent', () => {
  let component: TarjetaProveedorComponent;
  let fixture: ComponentFixture<TarjetaProveedorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TarjetaProveedorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TarjetaProveedorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
