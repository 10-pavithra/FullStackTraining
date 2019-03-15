import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {MatDialog} from '@angular/material';
import {LoginApiService} from '../../services/login.service';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { FormGroup, FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private apiService: LoginApiService,private _formBuilder: FormBuilder) { }

  loginForm: FormGroup;
  username: String;
  password: String;
    ngOnInit() {
      this.loginForm = this._formBuilder.group({
        'email':[''],
      'password': ['']
      });
    }

    login(): void {
      this.username = this.loginForm.controls['email'].value;
      const credentials = this.loginForm.getRawValue();
console.log(credentials);
      this.apiService.authenticatepi(credentials).subscribe((response) => {
        try{
          if (response.email === 'maker@test.com') {
            this.router.navigate(['maker']);
           } else if (response.email && response.email === 'checker@test.com') {
             this.router.navigate(['checker']);
           } else {
            this.router.navigate(['']);
           }
        } catch(ex) {
          this.router.navigate(['']);
        }

      });
    }
    }


