package project.handler;

import java.sql.Date;
import project.util.Prompt;

public class ReviewHandler {

  static class Review{
    int no; // 게시글 번호
    int stars; // 평점
    String title; // 제목
    String content; // 게시글 내용
    String password; // 암호
    String name; // 작성자 
    Date reviewDate; // 작성일
    int status; //  모험 상태 
  }

  // 후기 데이터 review
  static final int LENGTH = 100;
  static Review[] review = new Review[LENGTH];
  static int size = 0;

  public static void add() {
    System.out.println("[리뷰 등록]");

    Review r = new Review();

    r.no = Prompt.inputInt("번호? ");
    r.stars = Prompt.inputInt("평점? ");
    r.title = Prompt.inputString("제목? ");
    r.content = Prompt.inputString("내용? ");
    r.password = Prompt.inputString("암호? ");
    r.name = Prompt.inputString("작성자? ");
    r.reviewDate = new java.sql.Date(System.currentTimeMillis());
    r.status = Prompt.inputInt("모험상태?\n0: 모험실패\n1: 모험중\n2: 모험완료\n> ");

    review[size++] = r;
  }

  public static void list() {
    System.out.println("[리뷰 목록]");

    for (int i = 0; i < size; i++) {
      Review r = review[i];
      String stateLabel = null;
      switch (r.status) {
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
          r.no, r.stars, r.title, r.content, r.name, r.reviewDate, stateLabel);
    }
  }

}