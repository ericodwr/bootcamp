import { NgModule } from '@angular/core';
import { NavbarModule } from '../navbar/navbar.module';
import { BaseComponent } from './base.component';
import { RouterModule } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { FooterComponent } from '../footer/footer.component';

@NgModule({
  declarations: [BaseComponent],
  imports: [NavbarModule, RouterModule, FooterComponent],
  // exports: [BaseComponent],
})
export class BaseModule {}
