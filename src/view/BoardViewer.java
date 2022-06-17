package view;
//뷰어

//뷰어는 사용자가 직접적으로 보게 되는 화면단, 즉 프론트 엔드가 된다.
// 단, 지금 현재 우리는 console 에서 프로그래밍을 하므로
//뷰어가 java 클래스가 된다

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import controller.BoardController;
import model.BoardDTO;
import util.ScannerUtil;

//또한, 원칙적으로는 데이터베이스가 존재하기 떄문에
//우리가 필요하면 그 즉식 해당 메소드에서 controller 객체를 생성해서
//해당 객체의 필요한 메소드를 실행시키는게 맞지만
//없다
//그래서 어쩔 수 없이 BoardConTroller 필드를 하나 여기에 만들어 주게 된다.
public class BoardViewer {
    private BoardController controller;
    private Scanner scanner;

    public BoardViewer() {
        controller = new BoardController();
        scanner = new Scanner(System.in);

    }

    // 게시물 관련 메뉴 메소드
    public void showMenu() {
        while (true) {
            String message = "1새 글 작성 2 글 목록보기 3 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                // 글 작성
                wirteBoard();
            } else if (userChoice == 2) {
                printList();
            } else if (userChoice == 3) {
                System.out.println("종료");
                break;
            }
        }
    }

    private void wirteBoard() {
        BoardDTO b = new BoardDTO();

        String message = "글의 제목을 입력해주세요";
        b.setTitle(ScannerUtil.nextLine(scanner, message));
        message = "글의 내용을 입력해주세요";
        b.setContent(ScannerUtil.nextLine(scanner, message));
        message = "작성자 이름을 입력해주세요";
        b.setWriter(ScannerUtil.nextLine(scanner, message));
        
        controller.insert(b);
    }

    private void printList() {
        ArrayList<BoardDTO> list = controller.selectAll();

        if (list.isEmpty()) {
            System.out.println("아직 등록된 글이 존재하지 않습니다.");
        } else {
            Collections.reverse(list);

            for (BoardDTO b : list) {
                System.out.printf("%d. %s\n", b.getId(), b.getTitle());
            }

            String message = "상세보기할 글의 번호나 뒤로 가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && controller.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }

        }

    }

    private void printOne(int id) {

        BoardDTO b = controller.selectOne(id);

        System.out.println("-------");
        System.out.println("글 번호 : " + id);
        System.out.println("글 작성자 : " + b.getWriter());
        System.out.println("---------------------");
        System.out.println(b.getContent());

        String message = "1수정 2 삭제 3 뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if (userChoice == 1) {
            updateBoard(id);
        } else if (userChoice == 2) {
            deleteBoard(id);
        } else if (userChoice == 3) {
            printList();
        }
    }

    private void updateBoard(int id) {
        BoardDTO b = controller.selectOne(id);

        b.setTitle(ScannerUtil.nextLine(scanner, "새로운 제목을 입력"));

        b.setContent(ScannerUtil.nextLine(scanner, " 새로운 내용 입력"));
        controller.update(b);
    }

    private void deleteBoard(int id) {

        String yesNo = ScannerUtil.nextLine(scanner, "정말로 삭제하시겠습니까? Y/N");

        if (yesNo.equalsIgnoreCase("Y")) {
            controller.delete(id);
            printList();
        } else {
            printOne(id);
        }

    }

}
