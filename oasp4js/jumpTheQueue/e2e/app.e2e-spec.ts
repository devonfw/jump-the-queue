import { JumpTheQueryPage } from './app.po';

describe('jump-the-query App', () => {
  let page: JumpTheQueryPage;

  beforeEach(() => {
    page = new JumpTheQueryPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
