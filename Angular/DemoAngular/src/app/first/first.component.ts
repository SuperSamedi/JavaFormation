import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {

  private _imageWidth: number = 300;
  private _imageHeight: number = 200;
  private _imagePath: string = "https://picsum.photos/id/" + this.getRandomInt(1, 1000) + "/" + this._imageWidth + "/" + this._imageHeight;
  private _random: number = this.getRandomInt(1, 1000);
  private _fontStyles = ['normal', 'italic'];
  paragrapheFontStyle: any;
  numbers = [0, 1, 2.5, 3, 5.2, 8, 9.123]

  cardData: {
    title: string,
    description: string
  } = {
    title: "Un simple titre",
    description: "Ho la belle carte dis donc! Ça claque bien."
  }


  constructor() { }

  ngOnInit(): void {
  }


  get random(): number {
    this.paragrapheFontStyle = this._fontStyles[this.getRandomInt(0, 1)]
    return this._random;
  }

// Setter
  set random(value) {
    // console.log(value);
    this._random = value;
    this._imagePath = "https://picsum.photos/id/" + value + "/" + this._imageWidth + "/" + this._imageHeight;
  }

  // getter
  get imagePath(): string {
    return this._imagePath;
  }

  getRandomInt(min: number, max: number) : number {
    min = Math.ceil(min);
    max = Math.ceil(max);
    return Math.floor( Math.random() * (max - min + 1)) + min;
  }

  showAlert() {
    alert("Merci 🤓")
  }
}
