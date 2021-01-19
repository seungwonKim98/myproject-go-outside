package project.go.outside;

import java.sql.Date;

public class NoticeHandler {


  // 공지 데이터 notice
  static final int LENGTH = 100;
  static int[] nno = new int[LENGTH]; // 게시글 번호
  static String[] ntitle = new String[LENGTH]; // 글 제목
  static String[] ncontent = new String[LENGTH]; // 글 내용
  static String[] nname = new String[LENGTH]; // 작성자 이름
  static String[] npassword = new String[LENGTH]; // 비밀 번호
  static Date[] noticeDate = new Date[LENGTH]; // 작성일 

  static int nsize = 0;

  static void add() {
    System.out.println("[공지 등록]");


    nno[nsize] = Prompt.inputInt("번호? ");
    ntitle[nsize] = Prompt.inputString("제목? ");
    ncontent[nsize] = Prompt.inputString("내용? ");
    nname[nsize] = Prompt.inputString("작성자? ");
    npassword[nsize] = Prompt.inputString("암호? ");

    noticeDate[nsize] = new java.sql.Date(System.currentTimeMillis());

    nsize++;
  }

  static void list() {
    System.out.println("[공지 목록]");

    for (int i = 0; i < nsize; i++) {
      System.out.printf("[%d] ㅣ 제목 : %s, 내용 : %s, 작성자 : %s, 작성일 : %s\n", // 출력 형식 지정
          nno[i], ntitle[i], ncontent[i], nname[i], noticeDate[i]);
    }
  }
}
