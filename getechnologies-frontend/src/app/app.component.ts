import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{


  public createFormPerson!: FormGroup;
  public editFormPerson!: FormGroup;


  public createFormInvoice!: FormGroup;
  public editFormInvoice!: FormGroup;



  public visibleCreatePDrawer = false;
  public visibleEditPDrawer = false;

  public visibleCreateFDrawer = false;
  public visibleEditFDrawer = false;

  ngOnInit(): void {

    this.createFormPerson = this.fb.group({
      userName: [null, [Validators.required]],
      password: [null, [Validators.required]],
      remember: [true]
    });

    this.editFormPerson = this.fb.group({
      userName: [null, [Validators.required]],
      password: [null, [Validators.required]],
      remember: [true]
    });

    this.createFormInvoice = this.fb.group({
      userName: [null, [Validators.required]],
      password: [null, [Validators.required]],
      remember: [true]
    });

    this.editFormInvoice = this.fb.group({
      userName: [null, [Validators.required]],
      password: [null, [Validators.required]],
      remember: [true]
    });



  }

  constructor(private fb: FormBuilder) {

  }



  public submitCreateFormPerson() {

    if (!this.createFormPerson.valid) {

      Object.values(this.createFormPerson.controls).forEach(control => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });

      return;
    } 


    console.log('submit', this.createFormPerson.value);



  }

  public submitEditFormPerson() {

    if (!this.editFormPerson.valid) {

      Object.values(this.editFormPerson.controls).forEach(control => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });

      return;
    } 


    console.log('submit', this.editFormPerson.value);



  }

  public submitCreateFormInvoice() {

    if (!this.createFormInvoice.valid) {

      Object.values(this.createFormInvoice.controls).forEach(control => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });

      return;
    } 


    console.log('submit', this.createFormInvoice.value);


  }

  public submitEditormInvoice() {

    if (!this.editFormInvoice.valid) {

      Object.values(this.editFormInvoice.controls).forEach(control => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });

      return;
    } 


    console.log('submit', this.editFormInvoice.value);


  }

  public showCreateDrawerPerson = () => { this.visibleCreatePDrawer = true; }
  public hideCreateDrawerPerson = () => { this.visibleCreatePDrawer = false; }

  public showCreateDrawerInvoice = () => { this.visibleCreateFDrawer = true; }
  public hideDCreaterawerInvoice = () => { this.visibleCreateFDrawer = false; }


  public showEditDrawerPerson = () => { this.visibleEditPDrawer = true; }
  public hideeditDrawerPerson = () => { this.visibleEditPDrawer = false; }

  public showEditDrawerInvoice = () => { this.visibleEditFDrawer = true; }
  public hideEditDrawerInvoice = () => { this.visibleEditFDrawer = false; }




  





  title = 'getechnologies-frontend';


  listOfData: Person[] = [
    {
      key: '1',
      name: 'John Brown',
      age: 32,
      address: 'New York No. 1 Lake Park'
    },
    {
      key: '2',
      name: 'Jim Green',
      age: 42,
      address: 'London No. 1 Lake Park'
    },
    {
      key: '3',
      name: 'Joe Black',
      age: 32,
      address: 'Sidney No. 1 Lake Park'
    }
  ];

}



interface Person {
  key: string;
  name: string;
  age: number;
  address: string;
}