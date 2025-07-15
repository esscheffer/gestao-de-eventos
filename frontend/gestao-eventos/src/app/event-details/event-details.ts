import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Evento } from '../event-form/evento';
import { EventDataService } from '../service/event-data';
import { EventForm } from '../event-form/event-form';
import { MatProgressSpinnerModule } from "@angular/material/progress-spinner";

@Component({
  selector: 'event-details',
  imports: [EventForm, MatProgressSpinnerModule],
  templateUrl: './event-details.html',
  styleUrl: './event-details.css'
})
export class EventDetails {
  eventId = "";
  event: Evento | null = null;
  isLoading = true;

  constructor(private route: ActivatedRoute, private eventDataService: EventDataService) { }

  ngOnInit(): void {
    this.eventId = this.route.snapshot.paramMap.get('id') ?? '';

    this.eventDataService.getEventById(this.eventId).subscribe(data => {
      this.event = data;
      this.isLoading = false;
    });
  }
}
