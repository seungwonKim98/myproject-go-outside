package project.go.outside;

import project.handler.MemberHandler;
import project.handler.NoticeHandler;
import project.handler.ReviewHandler;
import project.util.Prompt;

public class App {

  static int choice;

  public static void main(String[] args) {

    MemberHandler member = new MemberHandler();
    NoticeHandler notice = new NoticeHandler();
    ReviewHandler review = new ReviewHandler();


    while(true){
      System.out.println("---------------------------------------------------------------------------------------------------------");
      System.out.println("[Go outside]");
      System.out.println();
      System.out.println("please select number (ex/ 1)");
      System.out.println("↓[@ If you don't know how to use it, please check the manual first.]");
      System.out.println();
      System.out.println("[1] helpManual");
      System.out.println("[2] signUp");
      System.out.println("[3] memberMenu");
      System.out.println("[4] Non-memberMenu");
      System.out.println("[5] admin");
      System.out.println();

      String command = Prompt.inputString("명령> ");

      if(command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("exit")) {
        System.out.println();
        System.out.println("사용해주셔서 감사합니다.");
        break;

      }else if(command.equals("1")) {
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("If you want to use this program, you have to select the number of the   menu.");
        System.out.println("If you enter a different value than the number of the menu, you will be   prompted to check and re-enter.");
        System.out.println("Enter \"exit or quit\" to exit the program.");
        System.out.println();
        System.out.println();
        System.out.println(">[signUp]");
        System.out.println("   >[sign Up] - sing Up.");
        System.out.println();
        System.out.println(">[memberMenu] \n"
            + "   >[Create a posts] - Only create member posts.\n"
            + "   >[List of posts] - Only view member posts.");
        System.out.println();
        System.out.println(">[Non-memberMenu] \n"
            + "   >[Create a posts] - Only create Non-member posts.\n"
            + "   >[List of posts] - Only view Non-member posts.");
        System.out.println();
        System.out.println(">[admin] \n"
            + "Menu for administrators only.\n"
            + "You can access data from any menu.");
        System.out.println("---------------------------------------------------------------------------------------------------------");

      }else if(command.equals("2")) {
        System.out.println();
        member.add();
      }else if(command.equals("3")) {
        System.out.println();
        System.out.println("[1] [Create a posts]");
        System.out.println("[2] [List of posts]");
        System.out.println();
        choice = Prompt.inputInt("> ");
        switch(choice) {
          case 1:
            System.out.println();
            notice.add();
            break;

          case 2:
            System.out.println();
            notice.list();
            break;
        }


      }else if(command.equals("4")) {
        System.out.println();
        System.out.println("[1] [Create a posts]");
        System.out.println("[2] [List of posts]");
        System.out.println();

        choice = Prompt.inputInt("> ");
        switch(choice) {
          case 1:
            System.out.println();
            review.add();
            break;

          case 2:
            System.out.println();
            review.list();
            break;
        }

      }else if(command.equals("5")) {
        System.out.println();
        System.out.println("[1] [Member list]");
        System.out.println("[2] [Delete Membership]");
        System.out.println("[3] [Modify Member Posts]");
        System.out.println("[4] [Delete Member Posts]");
        System.out.println("[5] [Modify Non-Member Posts]");
        System.out.println("[6] [Delete Non-Member Posts]");
        System.out.println();

        choice = Prompt.inputInt("> ");
        switch(choice) {
          case 1:
            System.out.println();
            member.list();
            break;

          case 2:
            System.out.println();
            //member.delete();
            break;

          case 3:
            System.out.println();
            //notice.update();
            break;

          case 4:
            System.out.println();
            //notice.delete();
            break;

          case 5:
            System.out.println();
            //review.update();
            break;

          case 6:
            System.out.println();
            //review.delete();
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


/*
if(command.equalsIgnoreCase("/member/add")) {
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

}else if(command.equalsIgnoreCase("/admin")) {
  System.out.println();
  admin.admin();

} */
