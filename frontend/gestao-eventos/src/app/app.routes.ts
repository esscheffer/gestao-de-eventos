
import { Routes, RouterModule } from '@angular/router';
import { EventList } from './event-list/event-list';
import { EventForm } from './event-form/event-form';
import { EventDetails } from './event-details/event-details';

export const routes: Routes = [
    { path: '', redirectTo: 'events', pathMatch: 'full' },
    { path: 'events', component: EventList },
    { path: 'details/:id', component: EventDetails }
];

