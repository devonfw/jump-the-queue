import { Injectable } from '@angular/core';

@Injectable()
export class AuthService {
    private logged = false;
    private user = '';

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
}
