import { Component } from '@angular/core';

@Component({
  selector: 'app-music',
  templateUrl: './music.component.html',
  styleUrls: ['./music.component.css']
})
export class MusicComponent {

  role = 'ADMIN';

  musicList = [
    {
      title: 'Shape of You',
      artist: 'Ed Sheeran',
      youtubeLink: 'https://www.youtube.com'
    },
    {
      title: 'Believer',
      artist: 'Imagine Dragons',
      youtubeLink: 'https://www.youtube.com'
    }
  ];

}
