package project.go.outside;

import project.handler.BoardHandler;
import project.handler.HelpHandler;
import project.handler.ReviewHandler;
import project.handler.UserHandler;
import project.util.Prompt;

public class App {


  public static void main(String[] args) {

    UserHandler user = new UserHandler();
    BoardHandler board = new BoardHandler();
    ReviewHandler review = new ReviewHandler();
    HelpHandler help = new HelpHandler();


    while(true){
      System.out.println("---------------------------------------------------------------------------------------------------------");
      System.out.println("[Go outside]");
      System.out.println();
      System.out.println("[@ 해당 프로그램을 처음 사용하신다면, 사용법을 먼저 읽어주세요.]");
      System.out.println("↓ [메뉴의 명령어를 입력해주세요. (종료 : close / exit ) ]");
      System.out.println();
      System.out.println("/help");
      System.out.println("/user");
      System.out.println("/board");
      System.out.println("/review");
      System.out.println("/admin");
      System.out.println();

      String command = Prompt.inputString("명령> ");

      if(command.equalsIgnoreCase("close") || command.equalsIgnoreCase("exit")) {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("사용해주셔서 감사합니다.");
        break;

      }else if(command.equalsIgnoreCase("/help")) {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("[-] manual");
        System.out.println();
        System.out.println("※ 메뉴를 선택하세요.");

        String select = Prompt.inputString("> /help/");
        switch(select) {
          case "manual":
            System.out.println();
            help.manual();
            break;
        }

      }else if(command.equalsIgnoreCase("/user")) {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("[-] join");
        System.out.println("[-] modify");
        System.out.println();
        System.out.println("※ 메뉴를 선택하세요.");

        String select = Prompt.inputString("> /user/");
        switch(select) {
          case "join":
            System.out.println();
            user.add();
            break;

          case "modify":
            System.out.println();
            user.update();
            break;
        }



      }else if(command.equalsIgnoreCase("/board")) {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("[-] write");
        System.out.println("[-] list");
        System.out.println("[-] view");
        System.out.println("[-] delete");
        System.out.println();
        System.out.println("※ 메뉴를 선택하세요.");
        System.out.println();

        String select = Prompt.inputString("> /board/");
        switch(select) {
          case "write":
            System.out.println();
            board.add();
            break;

          case "list":
            System.out.println();
            board.list();
            break;

          case "view":
            System.out.println();
            board.detail();
            break;

          case "delete":
            System.out.println();
            board.delete();
            break;
        }


      }else if(command.equalsIgnoreCase("/review")) {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("[-] write");
        System.out.println("[-] list");
        System.out.println("[-] view");
        System.out.println("[-] delete");
        System.out.println();
        System.out.println("※ 메뉴를 선택하세요.");
        System.out.println();

        String select = Prompt.inputString("> /review/");
        switch(select) {
          case "write":
            System.out.println();
            review.add();
            break;

          case "list":
            System.out.println();
            review.list();
            break;

          case "view":
            System.out.println();
            review.detail();
            break;

          case "delete":
            System.out.println();
            review.delete();
            break;
        }

      }else if(command.equalsIgnoreCase("/admin")) {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("[-] user/list");
        System.out.println("[-] user/delete");
        System.out.println("[-] user/detail");
        System.out.println();
        System.out.println("※ 메뉴를 선택하세요.");
        System.out.println();

        String select = Prompt.inputString("> /admin/");
        switch(select) {

          case "user/list":
            System.out.println();
            user.list();
            break;

          case "user/delete":
            System.out.println();
            user.delete();
            break;

          case "user/detail":
            System.out.println();
            user.detail();
            break;
        }

      }else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println();

    }

    Prompt.close();
  }
}


