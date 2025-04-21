import { UserService } from './../../../../../service/user.service';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { peronid, userCreate } from '../../../../../Models/user.models';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router'; 
import { AuthService } from '../../../../../service/auth.service';
@Component({
  selector: 'app-registerdos',
  imports: [RouterModule,FormsModule],
  templateUrl: './registerdos.component.html',
  styleUrl: './registerdos.component.css'
})
export class RegisterdosComponent {
  constructor(private userService:UserService, private router: Router,private authService: AuthService){

  }

 
user: userCreate = {
    userId:0,
    userName: '',
    password: '',
    person: {
      personId: 0  
    }
  };

  
  onSubmit() {
    this.userService.ultimaPersona().subscribe(
      (data: peronid) => {
        this.user.person.personId = data.person_id;
        console.log(this.user);
        
        this.userService.register(this.user).subscribe(
          (response) => {
            console.log('Usuario registrado:', response);
            // Guarda el usuario en el servicio
            this.authService.setCurrentUser(this.user); // o this.user, dependiendo de qué datos necesites
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
