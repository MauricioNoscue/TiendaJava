import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
export type RolUsuario = 'administrador' | 'normal';
@Injectable({
  providedIn: 'root'
})
export class RolService {
  private rolActual = new BehaviorSubject<RolUsuario>('normal');

  constructor() {
    // Verificar si hay un rol guardado en localStorage al iniciar
    const rolGuardado = localStorage.getItem('rolUsuario');
    if (rolGuardado && (rolGuardado === 'administrador' || rolGuardado === 'normal')) {
      this.rolActual.next(rolGuardado as RolUsuario);
    }
  }

  // Cambiar el rol actual
  cambiarRol(nuevoRol: RolUsuario): void {
    // Guardamos en localStorage para persistencia
    localStorage.setItem('rolUsuario', nuevoRol);
    this.rolActual.next(nuevoRol);
  }

  // Obtener un Observable del rol actual
  obtenerRol(): Observable<RolUsuario> {
    return this.rolActual.asObservable();
  }

  // Método de conveniencia para verificar si es admin
  esAdministrador(): Observable<boolean> {
    return new Observable<boolean>(observer => {
      this.rolActual.subscribe(rol => {
        observer.next(rol === 'administrador');
      });
    });
  }
}
