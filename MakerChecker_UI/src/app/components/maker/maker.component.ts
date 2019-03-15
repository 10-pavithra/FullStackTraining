import { Component, OnInit, ViewEncapsulation, ɵConsole, ViewChild } from '@angular/core';
import {Router} from '@angular/router';
import {MatDialog} from '@angular/material';
import { FormBuilder,
  FormGroup,
  FormControl,
  Validators} from '@angular/forms';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import {ApiService} from '../../services/makerchecker.service';


export interface MakerTable {
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
  selector: 'app-maker',
  templateUrl: './maker.component.html',
  styleUrls: ['./maker.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class MakerComponent implements OnInit {
   table_data: MakerTable[];
  displayedColumns: string[] = ['customerId', 'createdBy', 'createdDate',
   'ModifiedBy', 'ModifiedDate', 'AuthorizedBy', 'AuthorizedDate', 'status','actionsColumn'];
  dataSource = new MatTableDataSource();
  customerIdFilter = new FormControl('');
  createdByFilter = new FormControl('');
  createdDateFilter = new FormControl('');
  ModifiedByFilter = new FormControl('');
  ModifiedDateFilter = new FormControl('');
  AuthorizedByFilter = new FormControl('');
  AuthorizedDateFilter = new FormControl('');
  statusFilter = new FormControl('');
  EnabledFilter = new FormControl('');
 flagM: boolean;
 flagMBy: boolean;
 flagABy: boolean;
 flagA: boolean;


products: boolean;
  filterValues = {

    customerId: '',
    createdBy: '',
    createdDate: '',
    modifiedBy: '',
    modifiedDate: '',
    authorizedBy: '',
    authorizedDate: '',
    status: '',
    enabled: ''
  };

  @ViewChild(MatPaginator) paginator: MatPaginator;
  constructor(public rest: ApiService, private route: Router) {
    //this.getApprovedRequest();


  }

  ngOnInit() {
    this.getApprovedRequest();
    this.customerIdFilter.valueChanges
    .subscribe(
      customerId => {
        this.filterValues.customerId = customerId;
        this.dataSource.filter = JSON.stringify(this.filterValues);
      }
    )
    this.createdByFilter.valueChanges
    .subscribe(
      createdBy => {
        this.filterValues.createdBy = createdBy;
        this.dataSource.filter = JSON.stringify(this.filterValues);
      }
    );
    this.dataSource.filterPredicate = this.createFilter();

  }



  getApprovedRequest() {

    this.rest.getSubmittedRequest().subscribe((response) => {

      this.table_data = response.data;
      this.dataSource.data = this.table_data;
      this.dataSource.paginator = this.paginator;
      console.log(this.table_data);

    });
  }
  routeCustomer(id){
    let url: string = `/viewCustomer/${id}`;
    this.route.navigate([url]);
  }

  onDelete(id){
    this.rest.delete(id).subscribe((response) => {
      alert(response.message);
      this.getApprovedRequest()
    })
  }


  createFilter(): (data: any, filter: string) => boolean {
    const filterFunction = function(data, filter): boolean {
      const searchTerms = JSON.parse(filter);
      //console.log(data);
    // if (data.modifiedBy != null) {
    //   this.flagM = data.modifiedBy.indexOf(searchTerms.modifiedBy) !== -1;
    // }
    // if (data.modifiedDate != null) {
    //   this.flagMBy = data.modifiedDate.indexOf(searchTerms.modifiedDate) !== -1;
    // }
    // if (data.authorizedBy != null) {
    //   this.flagA = data.authorizedBy.indexOf(searchTerms.authorizedBy) !== -1;
    // }
    // if (data.authorizedDate != null) {
    //   this.flagABy = data.authorizedDate.indexOf(searchTerms.authorizedDate) !== -1;
    // }


      return  data.createdBy.toLowerCase().indexOf(searchTerms.createdBy) !== -1
        && data.customerId.toString().toLowerCase().indexOf(searchTerms.customerId) !== -1;
        // || this.flagM
        // || this.flagMBy
        // || this.flagA
        // || this.flagABy
        // && data.status.indexOf(searchTerms.status) !== -1
        // && data.enabled.indexOf(searchTerms.enabled) !== -1;

    };
    return filterFunction;
  }

}
