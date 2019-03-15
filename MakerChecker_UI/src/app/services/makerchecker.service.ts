import { Injectable } from '@angular/core';
import {  HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';


const endpoint = 'http://localhost:8083/makerchecker/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};
@Injectable()
export class ApiService {
  constructor(private http: HttpClient) {}
    public extractData(res: Response) {
      const body = res;
      return body || { };
  }
  getSubmittedRequest(): Observable<any> {
    return this.http.get(endpoint + 'findAll').pipe(
      map(this.extractData));
  }

  submitRequest(customer): Observable<any>
  {
    return this.http.post<any>(endpoint + 'saveCustomer', customer, httpOptions).pipe(
      map(this.extractData));

}

findByCustId(id): Observable<any> {
  return this.http.get(endpoint + 'findByCustId/' + id).pipe(
    map(this.extractData));
}

getCriteriaSearch(criteria): Observable<any>{
return this.http.post<any>(endpoint + 'checkerSearch', criteria, httpOptions).pipe(
  map(this.extractData));
}

updateStatus(checker): Observable<any>{
  return this.http.post<any>(endpoint + 'updateStatus', checker, httpOptions).pipe(
    map(this.extractData));
  }

  delete (id): Observable<any>{
    return this.http.delete<any>(endpoint + 'delete/' + id).pipe(map(this.extractData));
  }
}

