import { Injectable } from '@angular/core';
import { find } from 'lodash-es';
import { Role } from 'src/app/shared/backendModels/interfaces';
import { config } from 'src/app/config';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private logged = false;
  private user = '';
  private userId = 0;
  private currentRole = 'NONE';
  private token: string;

  public isLogged(): boolean {
    return this.logged;
  }

  public setLogged(login: boolean): void {
    this.logged = login;
  }

  public getUser(): string {
    return this.user;
  }

  public setUser(username: string): void {
    this.user = username;
  }

  public getUserId(): number {
    return this.userId;
  }

  public setUserId(userId: number): void {
    this.userId = userId;
  }

  public getToken(): string {
    return this.token;
  }

  public setToken(token: string): void {
    this.token = token;
  }

  public setRole(role: string): void {
    this.currentRole = role;
  }

  public getPermission(roleName: string): number {
    const role: Role = find(config.roles, { name: roleName }) as Role;
    return role.permission;
  }

  public isPermited(userRole: string): boolean {
    return (
      this.getPermission(this.currentRole) === this.getPermission(userRole)
    );
  }
}
