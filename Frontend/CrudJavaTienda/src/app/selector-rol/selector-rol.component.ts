import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RolService, RolUsuario } from '../../service/rol.service';

@Component({
  selector: 'app-selector-rol',
  imports: [CommonModule, FormsModule],
  templateUrl: './selector-rol.component.html',
  styleUrl: './selector-rol.component.css'
})
export class SelectorRolComponent {
  rolSeleccionado: RolUsuario = 'normal';

  constructor(private rolService: RolService) {}

  ngOnInit(): void {
    this.rolService.obtenerRol().subscribe(rol => {
      this.rolSeleccionado = rol;
    });
  }

  cambiarRol(): void {
    this.rolService.cambiarRol(this.rolSeleccionado);
  }
}
