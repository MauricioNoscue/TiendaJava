import { user } from './../../../Models/user.models';
import { Component } from '@angular/core';
import { CardComponent } from '../../inicioComponents/card/card.component';
import { AuthService } from '../../../service/auth.service';

@Component({
  selector: 'app-inicio',
  imports: [CardComponent],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css'
})
export class InicioComponent {
 constructor(private authService: AuthService){}

ngOnInit() {
  const userData = this.authService.getCurrentUser();
  console.log("user", userData)
}
}
