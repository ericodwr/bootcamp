import { Component, OnInit } from '@angular/core';
import { FormArray, NonNullableFormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CandidateAnswerInsertReqDto } from '../../../dto/candidate/candidate-answer-insert.req.dto';
import { CandidateQuestionResDto } from '../../../dto/question/candidate-question.res.dto';
import { QuestionResDto } from '../../../dto/question/question.res.dto';
import { AnswerService } from '../../../services/answer.service';
import { QuestionsService } from '../../../services/questions.service';
import { MenuItem } from 'primeng/api';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'answer-question',
  templateUrl: './answer-question.component.html',
  styleUrls: ['./answer-question.styles.css'],
})
export class AnswerQuestionComponent implements OnInit {
  navbar: MenuItem[] | undefined;
  profile: MenuItem[] | undefined;
  imgUrl: string = '';

  questionList: QuestionResDto[] | any = [];

  loading = false;

  candidateQuestionList: CandidateQuestionResDto[] = [];

  candidateAnswerDto: CandidateAnswerInsertReqDto[] = [];

  candidateAnswers = this.fb.group({
    data: this.fb.array(this.candidateAnswerDto),
  });

  constructor(
    private questionService: QuestionsService,
    private answerService: AnswerService,
    private router: Router,
    private fb: NonNullableFormBuilder,
    private authService: AuthService
  ) {}

  get answers() {
    return this.candidateAnswers.get('data') as FormArray;
  }

  get candidateQuestion() {
    return this.questionList as FormArray;
  }

  getData() {
    this.questionService.getCandidateQuestions().subscribe((res) => {
      this.questionList = res;
    });

    this.questionService
      .getCandidateQuestionList()
      .subscribe((res) => (this.candidateQuestionList = res));

    this.questionService.getCandidateQuestionList().subscribe((res) => {
      this.candidateQuestionList = res;

      for (let i = 0; i < this.candidateQuestionList.length; i++) {
        if (this.candidateQuestionList[i].typeId === 2) {
          this.answers.push(
            this.fb.group({
              essayAnswer: ['', Validators.required],
              questionId: this.candidateQuestionList.at(i)?.questionId,
              questionOptionId: [null],
              candidateAssignId:
                this.candidateQuestionList.at(i)?.candidateAssignId,
              [`questionOptionIdTemp${i}`]: [],
            })
          );
        } else {
          this.answers.push(
            this.fb.group({
              essayAnswer: [null],
              questionId: this.candidateQuestionList.at(i)?.questionId,
              questionOptionId: [0, Validators.required],
              candidateAssignId:
                this.candidateQuestionList.at(i)?.candidateAssignId,
              [`questionOptionIdTemp${i}`]: [],
            })
          );
        }
      }
    });
  }

  patchOption(e: any, i: number) {
    this.answers.at(i).patchValue({
      questionOptionId: e.value,
    });
  }

  ngOnInit(): void {
    this.getData();

    const profile = this.authService.getProfile();
    if (profile?.photoId) {
      this.imgUrl = `http://localhost:8080/files/${profile.photoId}`;
    } else {
      this.imgUrl = 'http://localhost:8080/files/1';
    }

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

  onSubmit() {
    if (this.candidateAnswers.valid) {
      this.loading = true;
      const data = this.candidateAnswers.getRawValue().data;
      this.answerService.insertAnswer(data).subscribe((res) => {
        localStorage.clear();
        this.router.navigateByUrl('/login');
      });
    }
  }
}
