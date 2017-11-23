import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BpmPanelComponent } from './bpm-panel.component';

describe('BpmPanelComponent', () => {
  let component: BpmPanelComponent;
  let fixture: ComponentFixture<BpmPanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BpmPanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BpmPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
