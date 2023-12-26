import { Component } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'test',
  templateUrl: './test.component.html',
})
export class TestComponent {
  testDto = this.fb.group({
    name: ['', Validators.required],
    idCard: ['', Validators.required],
    DOB: ['', Validators.required],
    phoneNumb: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
  });

  constructor(private fb: NonNullableFormBuilder) {}
}
