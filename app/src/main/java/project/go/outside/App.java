package project.go.outside;

import java.sql.Date;
import java.util.Scanner;


public class App {

  public static void main(String[] args) {
    Scanner keyboardScan = new Scanner(System.in);


    // 회원 데이터 member
    final int LENGTH = 100;
    int[] no = new int[LENGTH]; // 회원 번호 
    String[] name = new String[LENGTH]; // 회원 이름
    String[] country = new String[LENGTH]; // 회원 국가
    String[] email = new String[LENGTH]; // 이메일
    String[] password = new String[LENGTH]; // 비밀 번호
    String[] tel = new String[LENGTH]; // 전화 번호
    Date[] registeredDate = new Date[LENGTH]; // 가입일
    int size = 0;

    // 공지 데이터 notice
    int[] nno = new int[LENGTH]; // 게시글 번호
    String[] ntitle = new String[LENGTH]; // 글 제목
    String[] ncontent = new String[LENGTH]; // 글 내용
    String[] nname = new String[LENGTH]; // 작성자 이름
    String[] npassword = new String[LENGTH]; // 비밀 번호
    Date[] noticeDate = new Date[LENGTH]; // 작성일 

    int nsize = 0;

    // 후기 데이터 review

    int[] rno = new int[LENGTH]; // 게시글 번호
    int[] rstars = new int[LENGTH]; // 평점
    String[] rtitle = new String[LENGTH]; // 제목
    String[] rcontent = new String[LENGTH]; // 게시글 내용
    String[] rpassword = new String[LENGTH]; // 암호
    String[] rname = new String[LENGTH]; // 작성자 
    Date[] reviewDate = new Date[LENGTH]; // 작성일
    int[] rstatus = new int[LENGTH]; //  모험 상태 

    int csize = 0;



    while(true){
      System.out.println("명령어 = /member/add, /member/list, /notice/add, /notice/list, /review/add, /review/list");
      System.out.print("명령어>");
      String input = keyboardScan.nextLine();

      if(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
        System.out.println();
        System.out.println("사용해주셔서 감사합니다.");
        break;

      }else if(input.equalsIgnoreCase("/member/add")) {
        System.out.println();
        System.out.println("[회원 등록]");

        System.out.print("번호? ");
        no[size] = Integer.parseInt(keyboardScan.nextLine());

        System.out.print("이름? ");
        name[size] = keyboardScan.nextLine();

        System.out.print("국가? ");
        country[size] = keyboardScan.nextLine();

        System.out.print("이메일? ");
        email[size] = keyboardScan.nextLine();

        System.out.print("암호? ");
        password[size] = keyboardScan.nextLine();

        System.out.print("전화? ");
        tel[size] = keyboardScan.nextLine();

        registeredDate[size] = new java.sql.Date(System.currentTimeMillis());

        size++;
      }else if(input.equalsIgnoreCase("/member/list")) {
        System.out.println("[회원 목록]");

        for (int i = 0; i < size; i++) {
          // 번호, 이름, 국가, 이메일, 전화, 가입일
          System.out.printf("[%d], 이름 : %s, 국가 : %s, 이메일 : %s, 번호 : %s, 가입일 : %s\n", // 출력 형식 지정
              no[i], name[i], country[i], email[i], tel[i], registeredDate[i]);
        }

      }else if(input.equalsIgnoreCase("/notice/add")){
        System.out.println();
        System.out.println("[공지 등록]");

        System.out.print("번호? ");
        nno[nsize] = Integer.valueOf(keyboardScan.nextLine());

        System.out.print("제목? ");
        ntitle[nsize] = keyboardScan.nextLine();

        System.out.print("내용? ");
        ncontent[nsize] = keyboardScan.nextLine();

        System.out.print("작성자? ");
        nname[nsize] = keyboardScan.nextLine();

        System.out.print("암호? ");
        npassword[nsize] = keyboardScan.nextLine();

        noticeDate[size] = new java.sql.Date(System.currentTimeMillis());

        nsize++;

      }else if(input.equalsIgnoreCase("/notice/list")) {
        System.out.println();
        System.out.println("[공지 목록]");

        for (int i = 0; i < nsize; i++) {
          System.out.printf("[%d], 제목 : %s, 내용 : %s, 작성자 : %s, 작성일 : %s\n", // 출력 형식 지정
              nno[i], ntitle[i], ncontent[i], nname[i], noticeDate[i]);
        }

      }else if(input.equalsIgnoreCase("/review/add")) {
        System.out.println();
        System.out.println("[리뷰 등록]");

        System.out.print("번호? ");
        rno[csize] = Integer.parseInt(keyboardScan.nextLine());

        System.out.print("평점? ");
        rstars[csize] = Integer.parseInt(keyboardScan.nextLine());

        System.out.print("제목? ");
        rtitle[csize] = keyboardScan.nextLine();

        System.out.print("내용? ");
        rcontent[csize] = keyboardScan.nextLine();

        System.out.print("암호? ");
        rpassword[csize] = keyboardScan.nextLine();

        System.out.print("작성자? ");
        rname[csize] = keyboardScan.nextLine();

        reviewDate[size] = new java.sql.Date(System.currentTimeMillis());

        System.out.println("모험상태?");
        System.out.println("0: 모험실패");
        System.out.println("1: 모험중");
        System.out.println("2: 모험완료");
        System.out.print("> ");
        rstatus[csize] = Integer.valueOf(keyboardScan.nextLine());

        csize++;

      }else if(input.equalsIgnoreCase("/review/list")) {
        System.out.println();
        System.out.println("[리뷰 목록]");


        for (int i = 0; i < csize; i++) {
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
          System.out.printf("[%d],평점 : %d, 제목 : %s, 내용: %s, 작성자 : %s, 작성일 : %s, %s\n", // 출력 형식 지정
              rno[i], rstars[i], rtitle[i], rcontent[i], rname[i], reviewDate[i], stateLabel);
        }


      }else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println();

    }

    keyboardScan.close();
  }
}


