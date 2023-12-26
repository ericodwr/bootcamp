import { Component } from '@angular/core';
import { FormArray, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'boottest-erico-angular';

  data = this.fb.group({
    inputs: this.fb.array([]),
    data1: this.fb.group({
      data11: '',
    }),
  });

  constructor(private fb: FormBuilder) {}

  onAdd() {
    this.inputs.push(this.fb.control(''));
  }

  get inputs() {
    return this.data.get('inputs') as FormArray;
  }
  
  remove(i: number) {
    this.inputs.removeAt(i);
  }
}
