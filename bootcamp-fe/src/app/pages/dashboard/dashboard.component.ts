import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
})
export class DashboardComponent implements OnInit {
  fullName: string = '';
  role: string = '';

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    const profile = this.authService.getProfile();
    if (profile) {
      console.log(profile);

      this.fullName = profile.fullName;
      this.role = profile.roleName;
    }
  }
}
