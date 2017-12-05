import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-slideshow',
  templateUrl: './slideshow.component.html',
  styleUrls: ['./slideshow.component.css']
})
export class SlideshowComponent implements OnInit {
  slideIndex = 1;
  constructor() { }

  ngOnInit() {
    this.slideIndex = 1;
    this.plusDivs(1);
  }

  plusDivs(n) {
    this.showDivs(this.slideIndex += n);
    setTimeout( () => this.plusDivs(1), 4000);
  }

  showDivs(n) {
    // const x = document.getElementsByClassName("mySlides");
    if (n > 4) {
      this.slideIndex = 1;
    }
    if (n < 1) {
      this.slideIndex = 4;
    }
  }
}
