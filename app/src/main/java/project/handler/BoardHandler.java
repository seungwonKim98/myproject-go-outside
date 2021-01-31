package project.handler;


import java.sql.Date;
import project.go.outside.domain.Board;
import project.util.Prompt;

public class BoardHandler {

  static final int DEFAULT_CAPACITY = 3;

  Node first;
  Node last;
  int size = 0;  

  public void add() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[게시글 등록]");

    Board b = new Board();

    b.no = Prompt.inputInt("번호? ");
    b.title = Prompt.inputString("제목? ");
    b.content = Prompt.inputString("내용? ");
    b.writer = Prompt.inputString("작성자? ");
    b.password = Prompt.inputString("암호? ");
    b.registeredDate = new Date(System.currentTimeMillis());

    Node node = new Node(b);

    if (last == null) { 
      last = node;
      first = node;
    } else { 
      last.next = node;
      node.prev = last;
      last = node;
    }

    this.size++;
    System.out.println("게시글을 등록하였습니다.");
  }

  public void list() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[게시글 목록]");

    Node cursor = first;

    while (cursor != null) {
      Board b = cursor.board;


      System.out.printf("[%d] %s ㅣ %s ㅣ %s ㅣ %d ㅣ %d\n", 
          b.no, 
          b.title, 
          b.registeredDate, 
          b.writer, 
          b.viewCount,
          b.like);

      cursor = cursor.next;
    }
  }

  public void detail() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[게시글 상세보기]");

    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    board.viewCount++;
    System.out.println("-----------------------------------------------------------");
    System.out.printf("[%s]\n", board.title);
    System.out.println("-----------------------------------------------------------");
    System.out.printf("%s\n", board.content);
    System.out.println("-----------------------------------------------------------");
    System.out.printf("작성자: %s ㅣ 작성일: %s ㅣ 조회수 : %d\n", board.writer, board.registeredDate, board.viewCount);

  }

  public void update() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[게시글 변경]");

    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s) > ", board.title));
    String content = Prompt.inputString(String.format("내용(%s) > ", board.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      board.title = title;
      board.content = content;
      System.out.println("게시글을 변경하였습니다.");

    } else {
      System.out.println("게시글 변경을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[게시글 삭제]");

    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      Node cursor = first;
      while (cursor != null) {
        if (cursor.board == board) {
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

      System.out.println("게시글을 삭제하였습니다.");

    } else {
      System.out.println("게시글 삭제를 취소하였습니다.");
    }

  }


  Board findByNo(int boardNo) {
    Node cursor = first;
    while (cursor != null) {
      Board b = cursor.board;
      if (b.no == boardNo) {
        return b;
      }
      cursor = cursor.next;
    }
    return null;
  }

  static class Node {
    Board board;
    Node next;
    Node prev;

    Node(Board b) {
      this.board = b;
    }
  }

}






