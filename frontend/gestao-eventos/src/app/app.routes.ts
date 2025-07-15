
import { Routes, RouterModule } from '@angular/router';
import { EventList } from './event-list/event-list';
import { NgModule } from '@angular/core';

export const routes: Routes = [
    { path: '', redirectTo: 'events', pathMatch: 'full' },
    { path: 'events', component: EventList }
];

