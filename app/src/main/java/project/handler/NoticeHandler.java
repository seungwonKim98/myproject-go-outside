package project.handler;

import project.go.outside.domain.Notice;
import project.util.Prompt;

public class NoticeHandler {


  // 공지 데이터 notice
  static final int LENGTH = 100;
  Notice[] notice = new Notice[LENGTH];
  int size = 0;

  public void add() {
    System.out.println("[공지 등록]");
    Notice n = new Notice();

    n.no = Prompt.inputInt("번호? ");
    n.title = Prompt.inputString("제목? ");
    n.content = Prompt.inputString("내용? ");
    n.name = Prompt.inputString("작성자? ");
    n.password = Prompt.inputString("암호? ");
    n.noticeDate = new java.sql.Date(System.currentTimeMillis());

    this.notice[this.size++] = n;
  }

  public void list() {
    System.out.println("[공지 목록]");

    for (int i = 0; i < this.size; i++) {
      Notice n = this.notice[i];
      System.out.printf("[%d] ㅣ 제목 : %s, 내용 : %s, 작성자 : %s, 작성일 : %s\n", // 출력 형식 지정
          n.no, n.title, n.content, n.name, n.noticeDate);
    }
  }
}
