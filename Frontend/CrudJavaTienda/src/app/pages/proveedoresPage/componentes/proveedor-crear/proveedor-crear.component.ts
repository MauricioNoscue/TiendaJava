import { ProveedorService } from './../../../../../service/proveedor.service';
import { Component, EventEmitter, Output } from '@angular/core';
import { proveedor,productoProveedor } from '../../../../../Models/proveedores.models';
import { ProductoService } from '../../../../../service/producto.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { productoSelect } from '../../../../../Models/producto.models';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-proveedor-crear',
  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './proveedor-crear.component.html',
  styleUrl: './proveedor-crear.component.css'
})
export class ProveedorCrearComponent {
  @Output() proveedorCreado = new EventEmitter<void>();
  
  form: FormGroup;
  productos: productoSelect[] = [];
  
  constructor(
    private fb: FormBuilder,
    private productoService: ProductoService,
    private proveedorService: ProveedorService
  ) {
    this.form = this.fb.group({
      supplierName: ['', Validators.required],
      address: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', Validators.required],
      productId: [null, Validators.required]
    });
    
    this.cargarProductos();
  }
  
  cargarProductos() {
    this.productoService.TraerTodo().subscribe(productos => {
      this.productos = productos;
    });
  }
  
  onSubmit() {
    if (this.form.valid) {
      // Datos del proveedor
      const proveedor: proveedor = {
        supplierID: 0,
        supplierName: this.form.value.supplierName,
        address: this.form.value.address,
        email: this.form.value.email,
        phone: this.form.value.phone
      };
      
      // ID del producto seleccionado
      const productId = this.form.value.productId;
      
      // Primero creamos el proveedor
      this.proveedorService.Crear(proveedor).subscribe(() => {
        console.log('Proveedor creado');
        
        // Obtenemos el ID del último proveedor creado
        this.proveedorService.obtenerUltimoProveedor().subscribe(ultimoProveedor => {
          // Creamos la relación proveedor-producto
          const productoProveedor: productoProveedor = {
            productId: productId,
            supplierId: ultimoProveedor.supplierID
          };
          
          // Guardamos la relación
          this.proveedorService.crearProductoProveedor(productoProveedor).subscribe(() => {
            console.log('Relación producto-proveedor creada');
            
            // Reiniciamos el formulario
            this.form.reset({
              supplierName: '',
              address: '',
              email: '',
              phone: '',
              productId: null
            });
            
            // Notificamos que se completó la creación
            this.proveedorCreado.emit();
          });
        });
      });
    }
  }
}
