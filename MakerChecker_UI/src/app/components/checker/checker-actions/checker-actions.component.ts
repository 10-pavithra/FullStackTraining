import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators} from '@angular/forms';
  import { Router,ActivatedRoute } from '@angular/router';
  import {ApiService} from '../../../services/makerchecker.service';

@Component({
  selector: 'app-checker-actions',
  templateUrl: './checker-actions.component.html',
  styleUrls: ['./checker-actions.component.scss']
})
export class CheckerActionsComponent implements OnInit {

  constructor(private _formBuilder: FormBuilder,private activeRoute: ActivatedRoute,private router: Router, public rest: ApiService) {
    //this.prepareForm();
   }
  customerviewForm: FormGroup;
  actionForm:FormGroup;
  routeId: Number;
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
    this.actionForm = this._formBuilder.group({
      'customerId': [''],
      'status': [null]
    });
  }
 public  onCancel () {
    this.router
    .navigate(['/checker'])
  }

  public  onReset() {
    this.customerviewForm.enable();
  }

  public onApprove() {
    console.log(this.customerviewForm.get('customerId'));
    this.actionForm.setValue({
      'customerId': this.routeId,
      'status': 'A'
    });
  const checker = this.actionForm.getRawValue();

    this.rest.updateStatus(checker).subscribe((response) => {
      this.router.navigate(['checker']);
    });
  }

  public onReject() {
    this.actionForm.setValue({
      'customerId': this.routeId,
      'status': 'R'
    });
   const checker= this.actionForm.getRawValue();
      this.rest.updateStatus(checker).subscribe((response) => {
       this.router.navigate(['checker']);
      });
    }

  public findByCustId(){
    this.routeId= this.activeRoute.snapshot.params['id'];
    console.log(this.routeId);
    this.rest.findByCustId(this.routeId).subscribe((response) => {
      console.log(response.data);
      console.log(response.data.id);
      //this.customerviewForm=response.data;
      this.customerviewForm.setValue({
        'id':response.data.id,
        'customerEmail': response.data.customerEmail,
        'customerId': response.data.customerId,
        'customerName': response.data.customerName,
        'customerScore': response.data.customerScore,
        'cutomerAddres':  response.data.cutomerAddres,
        'loanAmount': response.data.loanAmount,
        'loanTenure':  response.data.loanTenure,
        'loanType':  response.data.loanType,
        'customerPhone':  response.data.customerPhone,
      });
      this.customerviewForm.disable();



    });
  }
}
