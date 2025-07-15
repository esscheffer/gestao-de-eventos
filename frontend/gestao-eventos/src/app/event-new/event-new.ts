import { Component, ViewChild } from '@angular/core';
import { EventForm } from "../event-form/event-form";
import { EventDataService } from '../service/event-data';

@Component({
  selector: 'app-event-new',
  imports: [EventForm],
  templateUrl: './event-new.html',
  styleUrl: './event-new.css'
})
export class EventNew {
  @ViewChild(EventForm) eventForm: EventForm | undefined;

  constructor(private eventDataService: EventDataService) { }

  onFormResult(result: any) {
    this.eventDataService.createEvent(result).subscribe(data => console.log(data));
  }
}
