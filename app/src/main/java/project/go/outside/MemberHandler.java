package project.go.outside;

import java.sql.Date;

public class MemberHandler {

  //회원 데이터 member
  static final int LENGTH = 100;
  static int[] no = new int[LENGTH]; // 회원 번호 
  static String[] name = new String[LENGTH]; // 회원 이름
  static String[] country = new String[LENGTH]; // 회원 국가
  static String[] email = new String[LENGTH]; // 이메일
  static String[] password = new String[LENGTH]; // 비밀 번호
  static String[] tel = new String[LENGTH]; // 전화 번호
  static Date[] registeredDate = new Date[LENGTH]; // 가입일
  static int size = 0;

  static void add() {
    System.out.println("[회원 등록]");


    no[size] = Prompt.inputInt("번호? ");
    name[size] = Prompt.inputString("이름? ");
    country[size] = Prompt.inputString("국가? ");
    email[size] = Prompt.inputString("이메일? ");
    password[size] = Prompt.inputString("암호? ");
    tel[size] = Prompt.inputString("전화? ");

    registeredDate[size] = new java.sql.Date(System.currentTimeMillis());

    size++;
  }

  static void list() {
    System.out.println("[회원 목록]");

    for (int i = 0; i < size; i++) {
      // 번호, 이름, 국가, 이메일, 전화, 가입일
      System.out.printf("[%d] ㅣ 이름 : %s, 국가 : %s, 이메일 : %s, 번호 : %s, 가입일 : %s\n", // 출력 형식 지정
          no[i], name[i], country[i], email[i], tel[i], registeredDate[i]);
    }
  }
}
