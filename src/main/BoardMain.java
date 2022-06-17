package main;
import view.BoardViewer;

//1.번 학생 관리 시스템을 MVC 패턴으로 구축하시오
//2번 사용자 관리 시스템을 만드시오
//단 회원가입시 동일한 아이디는 만들 수 없습니다
//3번 사원관리 시스템을 MVC패턴으로 구축하시오
public class BoardMain {
    public static void main(String[] args) {
        BoardViewer boardViewer = new BoardViewer();
        boardViewer.showMenu();
    }
}
