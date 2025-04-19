import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-option-button',
  imports: [CommonModule, RouterModule ],
  templateUrl: './option-button.component.html',
  styleUrl: './option-button.component.css'
})
export class OptionButtonComponent {
  @Input() estiloClase!: string;
  @Input() ruta!: string; // 👈 nueva propiedad para el routerLink
  @Input() texto!: string; // 👈 si querés que el botón muestre texto

}
