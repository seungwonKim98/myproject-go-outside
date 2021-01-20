package project.handler;

import java.sql.Date;
import project.util.Prompt;

public class NoticeHandler {

  static class Notice{

    int no; // 게시글 번호
    String title; // 글 제목
    String content; // 글 내용
    String name; // 작성자 이름
    String password; // 비밀 번호
    Date noticeDate; // 작성일 
  }

  // 공지 데이터 notice
  static final int LENGTH = 100;
  static Notice[] notice = new Notice[LENGTH];
  static int size = 0;

  public static void add() {
    System.out.println("[공지 등록]");
    Notice n = new Notice();

    n.no = Prompt.inputInt("번호? ");
    n.title = Prompt.inputString("제목? ");
    n.content = Prompt.inputString("내용? ");
    n.name = Prompt.inputString("작성자? ");
    n.password = Prompt.inputString("암호? ");
    n.noticeDate = new java.sql.Date(System.currentTimeMillis());

    notice[size++] = n;
  }

  public static void list() {
    System.out.println("[공지 목록]");

    for (int i = 0; i < size; i++) {
      Notice n = notice[i];
      System.out.printf("[%d] ㅣ 제목 : %s, 내용 : %s, 작성자 : %s, 작성일 : %s\n", // 출력 형식 지정
          n.no, n.title, n.content, n.name, n.noticeDate);
    }
  }
}
