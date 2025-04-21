import { proveedor } from './../../../../../Models/proveedores.models';
import { Component, EventEmitter, Input, Output } from '@angular/core';

import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ProveedorService } from '../../../../../service/proveedor.service';
import { CommonModule } from '@angular/common';
declare var bootstrap:any;
@Component({
  selector: 'app-proveedor-editar',
  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './proveedor-editar.component.html',
  styleUrl: './proveedor-editar.component.css'
})
export class ProveedorEditarComponent {
  @Input() Proveedor!: proveedor;
  @Output() ProveedorActualizado = new EventEmitter<void>()

  form!: FormGroup;
  
  constructor(
    private fb: FormBuilder,
    private proveedorService: ProveedorService,
  ) {}

  ngOnInit() {
   

    
  
    console.log(this.Proveedor);
    
    this.form = this.fb.group({
      supplierID: [this.Proveedor.supplierID],
      address: [this.Proveedor.address, Validators.required],
      supplierName: [this.Proveedor.supplierName, Validators.required],
      phone: [this.Proveedor.phone, [Validators.required]],
      email: [this.Proveedor.email, Validators.required]
    });
  }
  actualizarProveedor() {
    if (this.form.valid) {
      const ProveedorActualizado : proveedor ={
        supplierID: this.form.value.supplierID,
        address: this.form.value.address,
        supplierName: this.form.value.supplierName,
        phone: this.form.value.phone,
        email: this.form.value.email
      }
      this.proveedorService.actualizar(ProveedorActualizado).subscribe(()=>{
        this.ProveedorActualizado.emit();
        // Cerrar el modal
        const modal = document.getElementById('modalEditarProveedor');
        if (modal) {
          const modalInstance = bootstrap.Modal.getInstance(modal);
          modalInstance?.hide();
        }
      })
    }

  }

}
