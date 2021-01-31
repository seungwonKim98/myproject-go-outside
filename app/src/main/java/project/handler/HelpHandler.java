package project.handler;

public class HelpHandler {

  public void manual(){

    System.out.println();
    System.out.println("---------------------------------------------------------------------------------------------------------");
    System.out.println("프로그램을 실행시키려면 해당 메뉴의 명령어를 입력하여야 합니다.");
    System.out.println("메뉴의 명령어와 다른 명령어를 입력시 [실행할 수 없는 명령입니다.] 라는 오류 메세지가 출력됩니다.  ");
    System.out.println("프로그램을 종료 시키고 싶으시다면, [exit] 혹은 [close]를 입력해주세요. ");
    System.out.println();
    System.out.println();

    System.out.println("> /help \n"
        + "   >[-] manual - 사용법 \n");

    System.out.println("> /user \n"
        + "   >[-] join - 회원가입 \n"
        + "   >[-] modify - 회원정보 수정 \n");

    System.out.println();
    System.out.println("> /board \n"
        + "   >[-] write - 게시글 작성 \n"
        + "   >[-] list - 게시글 목록 출력 \n"
        + "   >[-] view - 선택 게시글 상세보기 \n"
        + "   >[-] delete - 선택 게시글 삭제 \n");

    System.out.println();
    System.out.println("> /review \n"
        + "   >[-] write - 리뷰 게시글 작성 \n"
        + "   >[-] list - 리뷰 게시글 목록 출력 \n"
        + "   >[-] view - 선택 리뷰 게시글 상세보기 \n"
        + "   >[-] delete - 선택 리뷰 게시글 삭제 \n");

    System.out.println();
    System.out.println("> /admin \n"
        + "   >[-] user/list - 회원관리/ 회원목록 출력 \n"
        + "   >[-] user/delete - 회원관리/ 회원정보 삭제 \n"
        + "   >[-] user/detail - 회원관리/ 회원정보 상세보기 \n");

  }

}
