import { Injectable } from '@angular/core';
import {  HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';


const endpoint = 'http://localhost:8000/api/auth';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable()
export class LoginApiService {
  constructor(private http: HttpClient) {}
    public extractData(res: Response) {
      const body = res;
      return body || { };
  }

  authenticatepi(credentials): Observable<any> {
    return this.http.post<any>(endpoint , credentials, httpOptions).pipe(
      map(this.extractData));
  }
}
