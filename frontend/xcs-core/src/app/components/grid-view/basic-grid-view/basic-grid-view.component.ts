import {Component, Input, OnInit} from '@angular/core';
import {GridViewConfig} from '../models/grid-view-domain';
import {LoggerService} from '../../../@core/logger/logger.service';

@Component({
  selector: 'xcs-basic-grid-view',
  templateUrl: './basic-grid-view.component.html',
  styleUrls: ['./basic-grid-view.component.scss']
})
export class BasicGridViewComponent implements OnInit {

  @Input() gridConfig: GridViewConfig;

  constructor(private log: LoggerService) {
  }

  ngOnInit() {
  }

  validateConfig(gridConfig: GridViewConfig): boolean {
    return gridConfig.columns.length >= 0;
  }

}
