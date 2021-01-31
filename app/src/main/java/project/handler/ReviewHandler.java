package project.handler;

import java.sql.Date;
import project.go.outside.domain.Review;
import project.util.Prompt;


public class ReviewHandler {

  UserHandler userList;

  static final int DEFAULT_CAPACITY = 3;

  Node first;
  Node last;
  int size = 0;  

  public void add() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[리뷰 등록]");

    Review r = new Review();

    r.no = Prompt.inputInt("번호? ");
    r.title = Prompt.inputString("평점? ");
    r.title = Prompt.inputString("제목? ");
    r.content = Prompt.inputString("내용? ");
    r.writer = Prompt.inputString("작성자? ");
    r.password = Prompt.inputString("암호? ");
    r.registeredDate = new Date(System.currentTimeMillis());
    r.stars = Prompt.inputInt("모험상태?\n0: 모험실패\n1: 모험중\n2: 모험완료\n> ");




    Node node = new Node(r);

    if (last == null) { 
      last = node;
      first = node;
    } else { 
      last.next = node;
      node.prev = last;
      last = node;
    }

    this.size++;
    System.out.println("리뷰를 등록하였습니다.");
  }

  public void list() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[리뷰 목록]");

    Node cursor = first;

    while (cursor != null) {
      Review r = cursor.review;


      System.out.printf("[%d] %s ㅣ %s ㅣ %s ㅣ %s ㅣ %d ㅣ %d\n", 
          r.no, 
          r.title, 
          r.registeredDate, 
          r.writer,  
          getStars(r.stars),
          r.viewCount,
          r.like);

      cursor = cursor.next;
    }
  }

  public void detail() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[리뷰 상세보기]");

    int no = Prompt.inputInt("번호? ");

    Review review = findByNo(no);
    if (review == null) {
      System.out.println("해당 번호의 리뷰가 없습니다.");
      return;
    }

    review.viewCount++;
    System.out.println("-----------------------------------------------------------");
    System.out.printf("[%s]\n", review.title);
    System.out.println("-----------------------------------------------------------");
    System.out.printf("%s\n", review.content);
    System.out.println("-----------------------------------------------------------");
    System.out.printf("작성자: %s ㅣ 작성일: %s ㅣ 조회수 : %d ㅣ 모험상태 : %s \n",
        review.writer, review.registeredDate, review.viewCount, getStars(review.stars));

  }

  public void update() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[리뷰 변경]");

    int no = Prompt.inputInt("번호? ");

    Review review = findByNo(no);
    if (review == null) {
      System.out.println("해당 번호의 리뷰가 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s) > ", review.title));
    String content = Prompt.inputString(String.format("내용(%s) > ", review.content));
    int stars = Prompt.inputInt(String.format(
        "상태(%s) > \n0: 모험중\n1: 모험실패\n2: 모험완료\n> ", getStars(review.stars)));
    String writer = inputUser(String.format("작성자: %s > (작성취소 = [] 공백) ", review.writer));
    if(writer == null) {
      System.out.println("작업 변경을 취소합니다.");
      return;
    }



    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      review.title = title;
      review.content = content;
      System.out.println("리뷰를 변경하였습니다.");

    } else {
      System.out.println("리뷰 변경을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[리뷰 삭제]");

    int no = Prompt.inputInt("번호? ");

    Review review = findByNo(no);
    if (review == null) {
      System.out.println("해당 번호의 리뷰가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      Node cursor = first;
      while (cursor != null) {
        if (cursor.review == review) {
          if (first == last) {
            first = last = null;
            break;
          }
          if (cursor == first) {
            first = cursor.next;
            cursor.prev = null;
          } else {
            cursor.prev.next = cursor.next;
            if (cursor.next != null) {
              cursor.next.prev = cursor.prev;
            }
          }
          if (cursor == last) {
            last = cursor.prev;
          }
          this.size--;
          break;
        }
        cursor = cursor.next;
      }

      System.out.println("리뷰를 삭제하였습니다.");

    } else {
      System.out.println("리뷰 삭제를 취소하였습니다.");
    }

  }


  Review findByNo(int reviewNo) {
    Node cursor = first;
    while (cursor != null) {
      Review r = cursor.review;
      if (r.no == reviewNo) {
        return r;
      }
      cursor = cursor.next;
    }
    return null;
  }

  String getStars(int stars) {
    switch (stars) {
      case 1:
        return "모험중";
      case 2:
        return "모험실패";
      default:
        return "모험완료";
    }
  }

  static class Node {
    Review review;
    Node next;
    Node prev;

    Node(Review b) {
      this.review = b;
    }
  }

  String inputUser(String promptTitle) {
    while (true) {
      String name = Prompt.inputString(promptTitle);
      if (name.length() == 0) {
        return null;
      } else if (this.userList.exist(name)) {
        return name;
      } else {
        System.out.println("등록된 회원이 아닙니다.");
      }
    }
  }

}






