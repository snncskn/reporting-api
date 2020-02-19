import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AlertService, AuthenticationService } from '@/_services';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from '@/_models';

@Component({ templateUrl: 'login.component.html' })
export class LoginComponent implements OnInit {
    private currentUserSubject: BehaviorSubject<User>;
    public loginForm: FormGroup;
    public loading = false;
    public submitted = false;
    public returnUrl: string;
    public currentUser: Observable<User>;



    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService
    ) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
        // redirect to home if already logged in
        if (this.authenticationService.currentUserValue) {
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            email: ['', Validators.required],
            password: ['', Validators.required]
        });

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;

        // reset alerts on submit
        this.alertService.clear();

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }        


        this.loading = true;
        this.authenticationService.login(this.f.email.value, this.f.password.value)
            .subscribe(
                data => {
                    localStorage.setItem('currentUser', JSON.stringify(data.data));
                    this.loading = false;
                    this.currentUserSubject.next(data.data);
                    this.router.navigate([this.returnUrl]);
                    window.location.reload();
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
