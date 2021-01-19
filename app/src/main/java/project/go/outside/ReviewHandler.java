package project.go.outside;

import java.sql.Date;

public class ReviewHandler {

  // 후기 데이터 review
  static final int LENGTH = 100;
  static int[] rno = new int[LENGTH]; // 게시글 번호
  static int[] rstars = new int[LENGTH]; // 평점
  static String[] rtitle = new String[LENGTH]; // 제목
  static String[] rcontent = new String[LENGTH]; // 게시글 내용
  static String[] rpassword = new String[LENGTH]; // 암호
  static String[] rname = new String[LENGTH]; // 작성자 
  static Date[] reviewDate = new Date[LENGTH]; // 작성일
  static int[] rstatus = new int[LENGTH]; //  모험 상태 

  static int rsize = 0;

  static void add() {
    System.out.println("[리뷰 등록]");

    rno[rsize] = Prompt.inputInt("번호? ");
    rstars[rsize] = Prompt.inputInt("평점? ");
    rtitle[rsize] = Prompt.inputString("제목? ");
    rcontent[rsize] = Prompt.inputString("내용? ");
    rpassword[rsize] = Prompt.inputString("암호? ");
    rname[rsize] = Prompt.inputString("작성자? ");

    reviewDate[rsize] = new java.sql.Date(System.currentTimeMillis());

    rstatus[rsize] = Prompt.inputInt("모험상태?\n0: 모험실패\n1: 모험중\n2: 모험완료\n> ");

    rsize++;
  }

  static void list() {
    System.out.println("[리뷰 목록]");


    for (int i = 0; i < rsize; i++) {
      String stateLabel = null;
      switch (rstatus[i]) {
        case 1:
          stateLabel = "모험실패";
          break;
        case 2:
          stateLabel = "모험중";
          break;
        default:
          stateLabel = "모험완료";
      }
      // 글 번호, 평점, 제목, 내용, 작성자, 작성일, 모험상태 
      System.out.printf("[%d] ㅣ 평점 : %d, 제목 : %s, 내용: %s, 작성자 : %s, 작성일 : %s, %s\n", // 출력 형식 지정
          rno[i], rstars[i], rtitle[i], rcontent[i], rname[i], reviewDate[i], stateLabel);
    }
  }

}
