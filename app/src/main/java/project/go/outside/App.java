package project.go.outside;

import project.handler.MemberHandler;
import project.handler.NoticeHandler;
import project.handler.ReviewHandler;
import project.util.Prompt;

public class App {

  public static void main(String[] args) {


    while(true){
      System.out.println("명령어 = /member/add, /member/list, /notice/add, /notice/list, /review/add, /review/list");
      String command = Prompt.inputString("명령> ");

      if(command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("exit")) {
        System.out.println();
        System.out.println("사용해주셔서 감사합니다.");
        break;

      }else if(command.equalsIgnoreCase("/member/add")) {
        System.out.println();
        MemberHandler.add();

      }else if(command.equalsIgnoreCase("/member/list")) {
        System.out.println();
        MemberHandler.list();
      }else if(command.equalsIgnoreCase("/notice/add")){
        System.out.println();
        NoticeHandler.add();

      }else if(command.equalsIgnoreCase("/notice/list")) {
        System.out.println();
        NoticeHandler.list();

      }else if(command.equalsIgnoreCase("/review/add")) {
        System.out.println();
        ReviewHandler.add();

      }else if(command.equalsIgnoreCase("/review/list")) {
        System.out.println();
        ReviewHandler.list();


      }else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println();

    }

    Prompt.close();
  }
}


