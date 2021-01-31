package project.handler;

import project.go.outside.domain.User;
import project.util.Prompt;

public class UserHandler {

  Node first;
  Node last;
  int size = 0;  

  public void add() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[회원 등록]");

    User u = new User();

    u.no = Prompt.inputInt("번호? ");
    u.name = Prompt.inputString("이름? ");
    u.country = Prompt.inputString("국가? ");
    u.email = Prompt.inputString("이메일? ");
    u.password = Prompt.inputString("암호? ");
    u.tel = Prompt.inputString("전화? ");
    u.registeredDate = new java.sql.Date(System.currentTimeMillis());

    Node node = new Node(u);

    if (last == null) {
      last = node;
      first = node;
    } else { 
      last.next = node; 
      node.prev = last; 
      last = node; 
    }

    this.size++;
    System.out.println("회원을 등록하였습니다.");
  }

  public void list() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[회원 목록]");

    Node cursor = first;

    while (cursor != null) {
      User u = cursor.user;

      System.out.printf("[%d] %s ㅣ %s ㅣ %s ㅣ %s ㅣ %s\n", 
          u.no, u.name, u.country, u.email, u.tel, u.registeredDate);

      cursor = cursor.next;
    }
  }

  public boolean exist(String name) {
    Node cursor = first;

    while (cursor != null) {
      User u = cursor.user;
      if (name.equals(u.name)) {
        return true;
      }
      cursor = cursor.next;
    }
    return false;
  }

  public void detail() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[회원 상세보기]");

    int no = Prompt.inputInt("번호? ");

    User user = findByNo(no);
    if (user == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", user.name);
    System.out.printf("이메일: %s\n", user.email);
    System.out.printf("국가: %s\n", user.country);
    System.out.printf("전화: %s\n", user.tel);
    System.out.printf("가입일: %s\n", user.registeredDate);

  }

  public void update() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[회원 변경]");

    int no = Prompt.inputInt("번호? ");

    User user = findByNo(no);
    if (user == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", user.name);
    System.out.printf("이메일: %s\n", user.email);
    System.out.printf("국가: %s\n", user.country);
    System.out.printf("전화: %s\n", user.tel);
    System.out.printf("가입일: %s\n", user.registeredDate);

    String name = Prompt.inputString(String.format("이름(%s) >  ", user.name));
    String email = Prompt.inputString(String.format("이메일(%s) >  ", user.email));
    String country = Prompt.inputString(String.format("국가(%s) >  ", user.country));
    String tel = Prompt.inputString(String.format("전화(%s) >  ", user.tel));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      user.name = name;
      user.email = email;
      user.country = country;
      user.tel = tel;
      System.out.println("회원을 변경하였습니다.");

    } else {
      System.out.println("회원 변경을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("[회원 삭제]");
    System.out.println();

    int no = Prompt.inputInt("번호? ");

    User user = findByNo(no);
    if (user == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      Node cursor = first;
      while (cursor != null) {
        if (cursor.user == user) {
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

          break;
        }
        cursor = cursor.next;
      }

      System.out.println("회원을 삭제하였습니다.");

    } else {
      System.out.println("회원 삭제를 취소하였습니다.");
    }

  }


  User findByNo(int userNo) {
    Node cursor = first;
    while (cursor != null) {
      User u = cursor.user;
      if (u.no == userNo) {
        return u;
      }
      cursor = cursor.next;
    }
    return null;
  }

  static class Node {
    User user;
    Node next;
    Node prev;

    Node(User u) {
      this.user = u;
    }
  }
}






