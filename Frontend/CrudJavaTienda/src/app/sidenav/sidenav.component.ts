import { Component } from '@angular/core';
import { OptionButtonComponent } from '../Buttons/option-button/option-button.component';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-sidenav',
  imports: [OptionButtonComponent,CommonModule],
  templateUrl: './sidenav.component.html',
  styleUrl: './sidenav.component.css'
})
export class SidenavComponent {

}
