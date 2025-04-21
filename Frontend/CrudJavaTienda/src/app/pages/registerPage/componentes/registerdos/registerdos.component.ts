import { UserService } from './../../../../../service/user.service';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { peronid, userCreate } from '../../../../../Models/user.models';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router'; 
@Component({
  selector: 'app-registerdos',
  imports: [RouterModule,FormsModule],
  templateUrl: './registerdos.component.html',
  styleUrl: './registerdos.component.css'
})
export class RegisterdosComponent {
  constructor(private userService:UserService, private router: Router){

  }

 
user: userCreate = {
    userName: '',
    password: '',
    person: {
      personId: 0  
    }
  };

  
  onSubmit() {
    this.userService.ultimaPersona().subscribe(
      (data: peronid) => {
        // Asignamos el personId antes de registrar
        this.user.person.personId = data.person_id;
        console.log(this.user)
        // Ahora sí registramos el usuario
        this.userService.register(this.user).subscribe(
          (response) => {
            console.log('Usuario registrado:', response);
            this.router.navigate(['/inicio']);
          },
          (error) => {
            console.error('Error al registrar el usuario:', error);

          }
        );
      },
      (error) => {
        console.error('Error al obtener el último personId:', error);
      }
    );
  }

 

}
