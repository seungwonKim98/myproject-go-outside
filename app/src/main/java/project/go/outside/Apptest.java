package project.go.outside;

import project.handler.MemberHandler;
import project.handler.NoticeHandler;
import project.handler.ReviewHandler;
import project.util.Prompt;

public class Apptest {

  public static void main(String[] args) {

    MemberHandler member = new MemberHandler();
    NoticeHandler notice = new NoticeHandler();
    ReviewHandler review = new ReviewHandler();


    while(true){
      System.out.println("명령어 = /member/add, /member/list, /notice/add, /notice/list, /review/add, /review/list");
      String command = Prompt.inputString("명령> ");

      if(command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("exit")) {
        System.out.println();
        System.out.println("사용해주셔서 감사합니다.");
        break;

      }else if(command.equalsIgnoreCase("/member/add")) {
        System.out.println();
        member.add();

      }else if(command.equalsIgnoreCase("/member/list")) {
        System.out.println();
        member.list();
      }else if(command.equalsIgnoreCase("/notice/add")){
        System.out.println();
        notice.add();

      }else if(command.equalsIgnoreCase("/notice/list")) {
        System.out.println();
        notice.list();

      }else if(command.equalsIgnoreCase("/review/add")) {
        System.out.println();
        review.add();

      }else if(command.equalsIgnoreCase("/review/list")) {
        System.out.println();
        review.list();


      }else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println();

    }

    Prompt.close();
  }
}


