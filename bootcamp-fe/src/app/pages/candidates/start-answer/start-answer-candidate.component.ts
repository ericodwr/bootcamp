import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ProgressStatus } from '../../../constant/progress.constant';
import { AnswerService } from '../../../services/answer.service';
import { CandidateStartDatesResDto } from 'src/app/dto/candidate/candidate-start-dates.res.dto';
import { CandidateQuestionTotalResDto } from 'src/app/dto/candidate/candidate-question-total.res.dto';
import { MenuItem } from 'primeng/api';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'candidate-start-answer',
  templateUrl: 'start-answer-candidate.component..html',
  styleUrls: ['./start-answer.styles.css'],
})
export class StartAnswerComponent implements OnInit {
  startDate: string = '';
  endDate: string = '';
  totalQuestion?: CandidateQuestionTotalResDto;
  navbar: MenuItem[] | undefined;
  profile: MenuItem[] | undefined;
  imgUrl: string = '';

  constructor(
    private answerService: AnswerService,
    private router: Router,
    private fb: NonNullableFormBuilder,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    const profile = this.authService.getProfile();
    if (profile?.photoId) {
      this.imgUrl = `http://localhost:8080/files/${profile.photoId}`;
    } else {
      this.imgUrl = 'http://localhost:8080/files/1';
    }

    this.answerService.getAllQuestion().subscribe((res) => {
      this.totalQuestion = res;
    });

    this.answerService.getDates().subscribe((res) => {
      const startDate = new Date(res.startDate).toLocaleString('ina-ID', {
        timeZoneName: 'short',
      });
      const endDate = new Date(res.endDate).toLocaleString('ina-ID', {
        timeZoneName: 'short',
      });

      this.startDate = startDate;
      this.endDate = endDate;
    });

    this.navbar = [
      {
        label: 'Bootcamp',
        routerLink: '/dashboard',
      },
    ];

    this.profile = [
      {
        label: 'Profile',
        routerLink: '/users/profile',
      },
      {
        label: 'Change Password',
        routerLink: '/users/changepassword',
      },
      {
        label: 'Logout',
        command: () => this.onLogout(),
      },
    ];
  }

  onLogout(): void {
    localStorage.clear();
    this.router.navigateByUrl('/login');
  }

  data = Object.values(JSON.parse(localStorage.getItem('data') || '{}'));

  startAnswer = this.fb.group({
    candidateId: Number(this.data[0]),
    statusId: ProgressStatus.ON_PROGRESS,
    resultId: null,
    notes: null,
    score: null,
  });

  onClick() {
    this.answerService
      .startAnswer(this.startAnswer.getRawValue())
      .subscribe((res) =>
        this.router.navigateByUrl('/candidates/answer-question')
      );
  }
}
