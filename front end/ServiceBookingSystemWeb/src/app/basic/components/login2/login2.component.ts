import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from 'express';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { AuthService } from '../../services/auth/auth.service';

@Component({
  selector: 'app-login2',
  templateUrl: './login2.component.html',
  styleUrl: './login2.component.scss'
})
export class Login2Component {

  validateForm!:FormGroup;

  constructor(
    private fb:FormBuilder,
    private authService:AuthService,
    private notification:NzNotificationService,
    private router:Router,

  ){}

  ngOnInit(){
    this.validateForm=this.fb.group({
      userName:[null,[Validators.required]],
      password:[null,[Validators.required]],
    })
  }

  submitForm(){
    this.authService.login(this.validateForm.get(['userName'])!.value,this.validateForm.get(['password'])!.value)
    .subscribe(res=>{
      console.log(res);
    },
  error=>{
    this.notification.error('ERROR','Bad credentials',{nzDuration:5000})
  });
  }




}
