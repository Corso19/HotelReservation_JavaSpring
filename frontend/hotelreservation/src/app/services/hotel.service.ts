import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class HotelService {

  private apiUrl = 'http://localhost:8080/api/hotel'; // replace with your Spring Boot app's domain

  constructor(private http: HttpClient) { }

  getAllHotels(range: number, latitude: number, longitude: number): Observable<any> {
    console.log("Getting hotels for range:", range, "latitude:", latitude, "longitude:", longitude);
    const url = `${this.apiUrl}?rangeInKm=${range}&latitude=${latitude}&longitude=${longitude}`;
    return this.http.get<any>(url);
  }
}