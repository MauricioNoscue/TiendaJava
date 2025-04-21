import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { login, user, userCreate } from '../../../../../Models/user.models';
import { FormsModule } from '@angular/forms';
import { UserService } from '../../../../../service/user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-formulario-session',
  imports: [RouterModule,FormsModule],
  templateUrl: './formulario-session.component.html',
  styleUrl: './formulario-session.component.css'
})
export class FormularioSessionComponent {
  userr:login= {
  username: '',
  password:'',
  
  }

  constructor(private userService:UserService,private router:Router){}
  onSubmit(){
    this.userService.Login(this.userr).subscribe(
      (response) => {
        console.log('usuairo encontrado:', response);
        // Aquí puedes redirigir o mostrar un mensaje de éxito
        this.router.navigate(['/inicio']);
      },
      (error) => {
        console.error('Error al registrar la persona:', error);
        console.log(this.userr)
        // Aquí puedes mostrar un mensaje de error
      }
    )
  }
}
