import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-component',
  templateUrl: './app.component-list.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  name = new FormControl('');
}