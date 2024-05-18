import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpClientModule } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {

  private apiUrl = 'http://localhost:8080/api/reservations'; 

  constructor(private http: HttpClient) { }

  createReservation(reservation: any, room:any): Observable<any> {
    console.log(room);
    return this.http.post<any>(this.apiUrl, reservation);
  }
}
