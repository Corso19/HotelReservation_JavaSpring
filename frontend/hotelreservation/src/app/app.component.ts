import { Component, ViewChild, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { HotelService } from './services/hotel.service';
import { NgForOf, NgClass } from '@angular/common';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [HotelService]
})
export class AppComponent implements OnInit{
  title = 'hotelreservation';

  hotels: any[] = [];

  @ViewChild('rangeInput') rangeInput: any; // Template reference variable

  public latitude: number=0;
  public longitude: number=0;

  constructor(private hotelService: HotelService) { }

  ngOnInit() {
    if (!navigator.geolocation) {
      console.log("Location not available");
    }
    navigator.geolocation.getCurrentPosition((position) => {
      this.latitude = position.coords.latitude;
      this.longitude = position.coords.longitude;
      console.log("Latitude:", this.latitude, "Longitude:", this.longitude);
    });
  }

  searchHotels() {
    const range = this.rangeInput.nativeElement.value; // Access value using nativeElement
    console.log("Search range:", range);
    this.hotelService.getAllHotels(range, this.latitude, this.longitude).subscribe({
      next: data => this.hotels = data,
      error: error => console.error(error)
    });
  }
}