
import { Routes, RouterModule } from '@angular/router';
import { EventList } from './event-list/event-list';
import { EventDetails } from './event-details/event-details';
import { EventNew } from './event-new/event-new';

export const routes: Routes = [
    { path: '', redirectTo: 'events', pathMatch: 'full' },
    { path: 'events', component: EventList },
    { path: 'details/:id', component: EventDetails },
    { path: 'events/new', component: EventNew },
];

