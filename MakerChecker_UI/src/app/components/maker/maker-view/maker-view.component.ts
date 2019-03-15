import { Component, OnInit } from '@angular/core';
import { FormBuilder,
  FormGroup,
  FormControl,
  Validators} from '@angular/forms';
  import { Router,ActivatedRoute } from '@angular/router';
  import {ApiService} from '../../../services/makerchecker.service';


@Component({
  selector: 'app-maker-view',
  templateUrl: './maker-view.component.html',
  styleUrls: ['./maker-view.component.scss']
})
export class MakerViewComponent implements OnInit {

  constructor(private _formBuilder: FormBuilder,private activeRoute: ActivatedRoute,private router: Router, public rest: ApiService) {
    //this.prepareForm();
   }
  customerviewForm :FormGroup;
  submitButton = true;
  ngOnInit() {
    this.prepareForm();
    this.findByCustId();
  }
  prepareForm(){
    console.log("Hello");
    this.customerviewForm = this._formBuilder.group({
      'id':[''],
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
    this.customerviewForm.enable();
    this.submitButton = false;
  }

  public onSubmit() {
    const customer = this.customerviewForm.getRawValue();
    console.log(customer);
    this.rest.submitRequest(customer).subscribe((response) => {
      alert('Record Saved');
    });
  }

  public findByCustId(){
    let id: string = this.activeRoute.snapshot.params['id'];
    console.log(id);
    this.rest.findByCustId(id).subscribe((response) => {
      console.log(response.data);
      console.log(response.data.id);
      this.customerviewForm.setValue(response.data);
      //this.customerviewForm=response.data;
      // this.customerviewForm.setValue({
      //   'id':response.data.id,
      //   'customerEmail': response.data.customerEmail,
      //   'customerId': response.data.customerId,
      //   'customerName': response.data.customerName,
      //   'customerScore': response.data.customerScore,
      //   'cutomerAddres':  response.data.cutomerAddres,
      //   'loanAmount': response.data.loanAmount,
      //   'loanTenure':  response.data.loanTenure,
      //   'loanType':  response.data.loanType,
      //   'customerPhone':  response.data.customerPhone,
      // });
      this.customerviewForm.disable();



    });
  }

}
