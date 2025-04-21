import { Component, EventEmitter, Input, Output } from '@angular/core';
import { productoSelect } from '../../../../../Models/producto.models';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ProductoService } from '../../../../../service/producto.service';
import { CommonModule } from '@angular/common';
import { categoriaSelect } from '../../../../../Models/categoria.models';
import { CategoriaService } from '../../../../../service/categoria.service';
declare var bootstrap: any;
@Component({
  selector: 'app-producto-editar',

  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './producto-editar.component.html',
  styleUrl: './producto-editar.component.css'
})
export class ProductoEditarComponent {
  @Input() producto!: productoSelect;
  @Output() productoActualizado = new EventEmitter<void>();
  
  form!: FormGroup;
  categorias: categoriaSelect[] = [];
  
  constructor(
    private fb: FormBuilder,
    private productService: ProductoService,
    private categoriaService: CategoriaService
  ) {}
  
  ngOnInit() {
   
    this.cargarCategorias();
    
  
    console.log(this.producto);
    
    this.form = this.fb.group({
      productId: [this.producto.productId],
      productName: [this.producto.productName, Validators.required],
      description: [this.producto.description, Validators.required],
      productPrice: [this.producto.productPrice, [Validators.required, Validators.min(0)]],
      categoryId: [this.producto.category?.categoryId, Validators.required]
    });
  }
  
  cargarCategorias() {
    this.categoriaService.TraerTodo().subscribe(categorias => {
      this.categorias = categorias;
    });
  }
  
  actualizarProducto() {
    if (this.form.valid) {
      const productoActualizado: productoSelect = {
        productId: this.form.value.productId,
        productName: this.form.value.productName,
        description: this.form.value.description,
        productPrice: this.form.value.productPrice,
        category: this.producto.category, // Mantenemos la referencia original a la categoría
        categoryId: this.form.value.categoryId
      };
      
      this.productService.actualizar(productoActualizado).subscribe(() => {
        console.log("Producto actualizado");
        this.productoActualizado.emit();
        
        // Cerrar el modal
        const modal = document.getElementById('modalEditarProducto');
        if (modal) {
          const modalInstance = bootstrap.Modal.getInstance(modal);
          modalInstance?.hide();
        }
      });
    }
  }
}
