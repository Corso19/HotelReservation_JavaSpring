import { Component, ViewChild, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { HotelService } from './services/hotel.service';
import { ReservationsService } from './services/reservations.service';
import { NgForOf, NgClass } from '@angular/common';
import { CommonModule } from '@angular/common';
import { FormGroup, FormControl,FormBuilder } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule, CommonModule,ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [HotelService, ReservationsService, HttpClientModule, HttpClient]
})


export class AppComponent implements OnInit {
  title = 'hotelreservation';
  feedbackModal = false;
  reservationModal = false;
  reviewModal = false;
  hotels: any[] = [];
  availableRooms: any[] = [];
  selectedHotel: any;
  feedbackForm: FormGroup;
  reservationForm: FormGroup;
  selectedRoom: any;

  @ViewChild('rangeInput') rangeInput: any; // Template reference variable

  public latitude: number=0;
  public longitude: number=0;

  constructor(private hotelService: HotelService, private reservationsService: ReservationsService, private formBuilder: FormBuilder) { // inject FormBuilder
    this.feedbackForm = this.formBuilder.group({ // initialize feedbackForm here
      username: '',
      comment: '',
      rating: ''
    });

    this.reservationForm = this.formBuilder.group({ // initialize reservationForm here
      room: '',
      startDate: '',
      endDate: ''
    });
  }

  openFeedbackModal(hotel: any) {
    this.selectedHotel = hotel;
    this.feedbackModal = true;
  }

  openReservationModal(hotel: any) {
    this.selectedHotel = hotel;
    this.reservationModal = true;
    this.hotelService.getAvailableRooms(hotel.id, this.reservationForm.value.startDate, this.reservationForm.value.endDate).subscribe({
      next: data => {
        console.log('Available rooms:', data);
        this.availableRooms = data;
        this.reservationModal = true;
      },
      error: error => console.error('Error getting available rooms', error)
    });
  }

  submitFeedback() {
    const feedback = this.feedbackForm.value;
    // submit the feedback here
    this.feedbackForm.reset();
    this.feedbackModal = false; // close the modal
  }

  submitReservation() {
    const reservation = this.reservationForm.value;
    this.reservationsService.createReservation(reservation, this.selectedRoom).subscribe({
      next: data => {
        console.log('Reservation created successfully', data);
        this.reservationForm.reset();
        this.reservationModal = false; // close the modal
      },
      error: error => console.error('Error creating reservation', error)
    });
  }

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