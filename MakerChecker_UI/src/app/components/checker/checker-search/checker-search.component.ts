import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder,
  FormGroup,
  FormControl,
  Validators} from '@angular/forms';
  import { Router } from '@angular/router';
  import {ApiService} from '../../../services/makerchecker.service';
  import { MatTableDataSource, MatPaginator } from '@angular/material';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';


  export interface CheckerTable {
    id: number;
    customerId: number;
    createdBy: string;
    createdDate: string;
    modifiedBy: string;
    modifiedDate: string;
    authorizedBy: string;
    authorizedDate: string;
    status: string;
    active: string;
  }

@Component({
  selector: 'app-checker-search',
  templateUrl: './checker-search.component.html',
  styleUrls: ['./checker-search.component.scss']
})



export class CheckerSearchComponent implements OnInit {

  searchForm: FormGroup;

  table_data: CheckerTable[];
  table_display:FormGroup;
  displayedColumns: string[] = ['customerId', 'createdBy', 'createdDate',
   'ModifiedBy', 'ModifiedDate', 'AuthorizedBy', 'AuthorizedDate', 'status'];
   dataSource = new MatTableDataSource();
   @ViewChild(MatPaginator) paginator: MatPaginator;
  constructor(private formBuilder: FormBuilder, private apiService : ApiService , private router: Router) { }

  ngOnInit() {
    this.prepareForm();
  }
  prepareForm(){
  this.searchForm = this.formBuilder.group({
    'customerId': [],
    'createdBy': [''],
    'createdDate': [''],
    'status': ['']
  });
  this.table_display = this.formBuilder.group({
  });
  }

  public  onReset() {
    this.prepareForm();
   this. table_display.disable();
  }

  public  onCancel () {
    this.router
    .navigate(['/checker'])
  }

  public onSearch(){
    const criteria = this.searchForm.getRawValue();
    this. table_display.enable();

    this.apiService.getCriteriaSearch(criteria).subscribe( response =>{
      this.table_data = response.data;
      this.dataSource.data = this.table_data;
      this.dataSource.paginator = this.paginator;
console.log(response.data);
    });
  }
}
