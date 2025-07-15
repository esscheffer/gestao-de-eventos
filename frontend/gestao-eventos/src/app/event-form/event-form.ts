import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Evento } from './evento';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { DateAdapter, provideNativeDateAdapter } from '@angular/material/core';

@Component({
  selector: 'event-form',
  imports: [ReactiveFormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatDatepickerModule],
    providers: [provideNativeDateAdapter()],
  templateUrl: './event-form.html',
  styleUrl: './event-form.css'
})
export class EventForm implements OnInit {

  @Input() evento = new Evento();
  eventForm: FormGroup<any>;

  constructor(private fb: FormBuilder) {
    this.eventForm = this.fb.group({
      titulo: ['', Validators.required],
      descricao: ['', Validators.required],
      dataHora: ['', Validators.required],
      local: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.eventForm = new FormGroup({
      titulo: new FormControl(this.evento.titulo, Validators.required),
      descricao: new FormControl(this.evento.descricao),
      dataHora: new FormControl(this.evento.dataHora, Validators.required),
      local: new FormControl(this.evento.local)
    });
  }

  onSubmit() {
  }
}
