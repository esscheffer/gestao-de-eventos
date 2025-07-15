import { AfterViewInit, Component, OnInit } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { EventDataService } from '../service/event-data';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';

@Component({
  selector: 'event-list',
  imports: [MatTableModule, MatProgressSpinnerModule],
  templateUrl: './event-list.html',
  styleUrl: './event-list.css'
})
export class EventList implements OnInit {

  isLoading = true;

  constructor(private eventDataService: EventDataService) { }

  ngOnInit(): void {
    this.eventDataService.getEvents().subscribe(data => {
      this.events = data.content;
      this.isLoading = false;
    });
  }

  events = [];


}
