package project.handler;

import project.go.outside.domain.Member;
import project.util.Prompt;

public class Admin {



  //회원 데이터 member
  static final int LENGTH = 100;
  Member[] members = new Member[LENGTH];
  int size = 0;

  public void add() {
    System.out.println("[회원 등록]");

    Member m = new Member();

    m.no = Prompt.inputInt("번호? ");
    m.name = Prompt.inputString("이름? ");
    m.country = Prompt.inputString("국가? ");
    m.email = Prompt.inputString("이메일? ");
    m.password = Prompt.inputString("암호? ");
    m.tel = Prompt.inputString("전화? ");

    m.registeredDate = new java.sql.Date(System.currentTimeMillis());

    this.members[this.size++] = m;
  }

  public void list() {
    System.out.println("[회원 목록]");

    for (int i = 0; i < this.size; i++) {
      Member m = this.members[i];
      // 번호, 이름, 국가, 이메일, 전화, 가입일
      System.out.printf("[%d] ㅣ 이름 : %s, 국가 : %s, 이메일 : %s, 번호 : %s, 가입일 : %s\n", // 출력 형식 지정
          m.no, m.name, m.country, m.email, m.tel, m.registeredDate);
    }
  }
}
