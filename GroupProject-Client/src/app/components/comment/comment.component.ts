import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {FormControl, Validators} from "@angular/forms";

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent {
  ratingControl = new FormControl('', [Validators.required]);
  ratings = [
    {score: 1, name: 'That\'s suck'},
    {score: 2, name: 'Can be better'},
    {score: 3, name: 'Acceptable'},
    {score: 4, name: 'Not bad'},
    {score: 5, name: 'Super Awesome'},
  ]

  constructor(
    public dialogRef: MatDialogRef<CommentComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }
  onNoClick(): void {
    this.dialogRef.close();
  }

}
