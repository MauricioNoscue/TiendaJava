import { ProveedorService } from './../../../../service/proveedor.service';
import { Component, OnInit } from '@angular/core';
import { proveedor } from '../../../../Models/proveedores.models';
import { CommonModule } from '@angular/common';
import { TarjetaProveedorComponent } from "../componentes/tarjeta-proveedor/tarjeta-proveedor.component";
import { ProveedorCrearComponent } from "../componentes/proveedor-crear/proveedor-crear.component";

declare var bootstrap: any;
@Component({
  selector: 'app-proveedor',
  imports: [CommonModule, TarjetaProveedorComponent, ProveedorCrearComponent],
  templateUrl: './proveedor.component.html',
  styleUrl: './proveedor.component.css'
})
export class ProveedorComponent implements OnInit {

  proveedorrSeleccionada!: proveedor | null;
  modalEditarRef: any = null;
  modalCrearRef: any = null; 
  cards: proveedor[] = [];

  constructor (private proveedorService: ProveedorService) {}

  ngOnInit(): void {
    this.proveedorService.TraerTodo().subscribe({
      next: (data) => {
        this.cards = data;
        console.log(data)
      },
      error: (err) => {
        console.error('Error al obtener categorías', err);
      }
    });
  }


  onEditarproveedorr(proveedorr: proveedor) {
    this.proveedorrSeleccionada = null; // Limpiamos primero
        
          // Esperamos un poco para que Angular detecte el cambio
          setTimeout(() => {
            this.proveedorrSeleccionada = { ...proveedorr }; // Nueva categoría
            const modal = document.getElementById('modalEditarproveedorr');
      if (modal) {
        this.modalEditarRef = new bootstrap.Modal(modal);
        this.modalEditarRef.show();
      }

    });
  }

  recargarProveedor() {
    this.proveedorService.TraerTodo().subscribe({
      next: (data) => this.cards = data,
      error: (err) => console.error('Error al obtener proveedores', err),
     
    });

    console.log("se recargo")
  }

  recargarProveedorYCerrarModal() {
    this.recargarProveedor();
  
    if (this.modalEditarRef) {
      this.modalEditarRef.hide();
      this.modalEditarRef = null;
  
      // Esperamos un pequeño tiempo para asegurarnos que el DOM esté actualizado
      setTimeout(() => {
        const backdrop = document.querySelector('.modal-backdrop');
        if (backdrop) {
          backdrop.remove();
        }
  
        // Eliminar clases que Bootstrap agrega al body
        document.body.classList.remove('modal-open');
        document.body.style.removeProperty('padding-right');
      }, 300); // 300ms suele ser suficiente para que el modal se haya ocultado
    }
  }

  recargarProductosYCerrarModalCrear() {
    this.recargarProveedor();
  
    if (this.modalCrearRef) {
      this.modalCrearRef.hide();
      this.modalCrearRef = null;
  
      setTimeout(() => {
        const backdrop = document.querySelector('.modal-backdrop');
        if (backdrop) {
          backdrop.remove();
        }
        document.body.classList.remove('modal-open');
        document.body.style.removeProperty('padding-right');
      }, 300);
    }
  }
  ngAfterViewInit() {
    const modalCrear = document.getElementById('modalCrearProveedor');
    if (modalCrear) {
      this.modalCrearRef = new bootstrap.Modal(modalCrear);
    }
  }

  eliminarProveedor(id: number) {
    this.proveedorService.Eliminar(id).subscribe({
      next: () => {
        console.log('proveedor eliminada');
        this.recargarProveedor();
      },
      error: (err) => {
        console.error('Error al eliminar proveedor', err);
      }
    });
  }
}
