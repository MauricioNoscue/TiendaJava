import { Person } from './../../../../../person.models';
import { user, peronid } from './../../../../../Models/user.models';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { productoSelect } from '../../../../../Models/producto.models';
import { categoriaSelect } from '../../../../../Models/categoria.models';
import { CommonModule } from '@angular/common';
import { ProductoEditarComponent } from '../producto-editar/producto-editar.component';
import { RolService } from '../../../../../service/rol.service';
import Swal from 'sweetalert2';
import { FacturaService } from '../../../../../service/factura.service';
import { AuthService } from '../../../../../service/auth.service';
import { factura, facturaProducto } from '../../../../../Models/factura.models';

@Component({
  selector: 'app-tarjeta-producto',
  imports: [CommonModule],
  templateUrl: './tarjeta-producto.component.html',
  styleUrl: './tarjeta-producto.component.css'
})
export class TarjetaProductoComponent {
  @Input() producto!: productoSelect;
  esAdmin: boolean = false;
  @Output() editar = new EventEmitter<void>();
  @Output() editarProducto = new EventEmitter<productoSelect>();
  @Output() eliminarProducto= new EventEmitter<number>();
  constructor(private rolService: RolService,private facturaService:FacturaService,private authService: AuthService) {}
  onEditar3() {
    this.editarProducto.emit(this.producto);
  }
  ngOnInit(): void {
    // Suscribirse al observable de rol
    this.rolService.esAdministrador().subscribe(esAdmin => {
      this.esAdmin = esAdmin;
    });
    const userData = this.authService.getCurrentUser();
    console.log("el usaurio bro",userData)
    
    // Cargar productos

  }

  eliminar() {
    if (confirm(`¿Estás seguro de eliminar la categoría "${this.producto.productName}"?`)) {
      this.eliminarProducto.emit(this.producto.productId);
    }
  }


  mostrarAlerta() {
    Swal.fire({
      title: '¿Estás seguro de comprar este producto?',
      text: 'La mejor compra de tu vida',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sí, continuar',
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
        const userData = this.authService.getCurrentUser();
        const userId = userData?.person?.personId;
  
        if (!userId) {
          Swal.fire('Error', 'No se pudo obtener el ID de la persona.', 'error');
          return;
        }
  
        const fechaHoy = new Date().toISOString().split('T')[0]; // formato "YYYY-MM-DD"
  
        // Asegúrate que el backend espera exactamente estos campos
        const nuevaFactura = {
          userId: userId,
          date: fechaHoy
        };
  
        this.facturaService.crearFactura(nuevaFactura).subscribe({
          next: () => {
            this.facturaService.obtenerUltimaFactura().subscribe({
              next: (res) => {
                const data = {
                  invoicesId: res.invoices_id,
                  productId: this.producto.productId
                };
  
                this.facturaService.agregarProductoAFactura(data).subscribe({
                  next: () => {
                    Swal.fire('¡Compra exitosa!', 'Gracias por tu compra.', 'success');
                  },
                  error: () => {
                    Swal.fire('Error', 'No se pudo agregar el producto a la factura.', 'error');
                  }
                });
              },
              error: () => {
                Swal.fire('Error', 'No se pudo obtener la última factura.', 'error');
              }
            });
          },
          error: (err) => {
            console.error('Error al crear la factura:', err);
            Swal.fire('Error', 'No se pudo crear la factura.', 'error');
          }
        });
      }
    });
  }
  
  

}
