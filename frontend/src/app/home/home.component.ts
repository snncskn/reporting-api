import { Component, OnInit } from "@angular/core";
import { first } from "rxjs/operators";
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';

import { User } from "@/_models";
import { UserService, AuthenticationService } from "@/_services";

@Component({ templateUrl: "home.component.html" })
export class HomeComponent implements OnInit {
  public form: FormGroup;

  currentUser: User;
  users = [];
  public list = [
    {count:11,total:12313,currency:'$'},
    {count:11,total:12313,currency:'$'},
    {count:11,total:12313,currency:'$'},
    {count:11,total:12313,currency:'$'},

  ];

  constructor(
    private authenticationService: AuthenticationService,
    private userService: UserService,
    private readonly formBuilder: FormBuilder
  ) {
    this.currentUser = this.authenticationService.currentUserValue;
    const firtDate = new Date();
    firtDate.setDate(firtDate.getDate() - 30);

    this.form = formBuilder.group({
      requestStartTime: ['00:00'],
      requestCloseTime: ['23:59'],
      stockCode: [''],
      itemDescription: [''],
      siteName: [''],
      moveNumber: [''],
      quantity: [''],
      moveType: [''],
      createdDate: [''],
    });

  }

  ngOnInit() {
    this.userService.getAll().subscribe(
      data => {
          console.log(data);
      },
      error => {
      });;;
  }

}