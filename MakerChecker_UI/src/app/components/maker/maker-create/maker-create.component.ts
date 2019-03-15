import { Component, OnInit } from '@angular/core';
import { FormBuilder,
  FormGroup,
  FormControl,
  Validators} from '@angular/forms';
  import { Router } from '@angular/router';
  import {ApiService} from '../../../services/makerchecker.service';


@Component({
  selector: 'app-maker-create',
  templateUrl: './maker-create.component.html',
  styleUrls: ['./maker-create.component.scss']
})
export class MakerCreateComponent implements OnInit {

  constructor(private _formBuilder: FormBuilder,private router: Router, public rest: ApiService) { }
  customerForm: FormGroup;

  ngOnInit() {
    this.prepareForm();
  }
  prepareForm(){
    this.customerForm = this._formBuilder.group({
    'customerEmail': [null, [Validators.required,  Validators.email]],
    'customerId': [null, [Validators.maxLength(8), Validators.required]],
    'customerName': [null, [Validators.required,  Validators.pattern('^[a-zA-Z]+$')]],
    'customerScore': [''],
    'cutomerAddres': [''],
    'loanAmount': [''],
    'loanTenure': [''],
    'loanType': [''],
    'customerPhone': ['']
    }
    );
  }
 public  onCancel () {
    this.router
    .navigate(['/maker'])
  }

  public  onReset() {
    this.prepareForm();
  }

  public onSubmit() {
    const customer = this.customerForm.getRawValue();
    console.log(customer);
    this.rest.submitRequest(customer).subscribe((response) => {
    alert('Record Saved');
    });
  }

}
