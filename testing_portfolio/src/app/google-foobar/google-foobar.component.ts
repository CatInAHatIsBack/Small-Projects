import { Component, ChangeDetectionStrategy } from '@angular/core'
import { NbMenuItem } from '@nebular/theme';

@Component({
  selector: 'app-google-foobar',
  templateUrl: './google-foobar.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  styleUrls: ['./google-foobar.component.scss']
})
export class GoogleFoobarComponent {

  items: NbMenuItem[] = [
    {
      title: 'Level 3',
      expanded: true,
      children: [
        {
          title: '3.1 Doomsday Fuel',
          link: '/doomsday-fuel' 
        },
        {
          title: '3.2 Prepare the Bunnies Escape',
          link: '/prep-bunny-escape' 
        },
        {
          title: '3.3 Fuel Injection Perfection',
        },
      ],
    },
    {
      title: 'Level 4',
      children: [
        {
          title: '4.1 Running with Bunnies',
        },
        {
          title: '4.2 Escape Pods',
        },
      ],
    },
    {
      title: '5.1 Expanding Nebula',
    },
  ];

}
