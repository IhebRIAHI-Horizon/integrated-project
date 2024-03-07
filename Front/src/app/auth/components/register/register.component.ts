import { Component } from '@angular/core';
import { UntypedFormGroup, UntypedFormBuilder, Validators, AbstractControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  loginForm!: UntypedFormGroup;
  errorMessage!: string;


  constructor(private formBuilder: UntypedFormBuilder, private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      firstname: ['', [Validators.required, Validators.minLength(3)]],
      lastname: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(8)]],
      password: ['', [Validators.required, Validators.minLength(5)]],
      confirmPassword: ['', [Validators.required]],
    },
    {
      validator: CustomValidator.matches,
    });
  }

  onSubmit() {
    
    const loginFormValue: LoginForm = this.loginForm.value;
    this.authService.register(loginFormValue.firstname,loginFormValue.lastname,loginFormValue.email,loginFormValue.phone, loginFormValue.password).subscribe(
      response => {
        if (response.status === 200) {
          this.router.navigate(['/login']);
        }
      },
      error => {
        if (error.status === 'UNAUTHORIZED') {
          this.errorMessage = 'Invalid email or password';
        } else {
          this.errorMessage = 'An error occurred while logging in';
        }
      }
    );
  }
  //convenience getter for easy access to form fields
  get form(): { [key: string]: AbstractControl; } {
    return this.loginForm.controls;
  }

}

export class CustomValidator {
  static matches(group: FormGroup): { [key: string]: boolean } | null {
    const password = group.get('password')?.value;
    const confirmPassword = group.get('confirmPassword')?.value;

    return password === confirmPassword ? null : { 'passwordMismatch': true };
  }
}

interface LoginForm {
  firstname: string;
  lastname: string;
  email: string;
  phone: string;
  password: string;
}
