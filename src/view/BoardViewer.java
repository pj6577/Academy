package view;
//���

//���� ����ڰ� ���������� ���� �Ǵ� ȭ���, �� ����Ʈ ���尡 �ȴ�.
// ��, ���� ���� �츮�� console ���� ���α׷����� �ϹǷ�
//�� java Ŭ������ �ȴ�

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import controller.BoardController;
import model.BoardDTO;
import util.ScannerUtil;

//����, ��Ģ�����δ� �����ͺ��̽��� �����ϱ� ������
//�츮�� �ʿ��ϸ� �� ��� �ش� �޼ҵ忡�� controller ��ü�� �����ؼ�
//�ش� ��ü�� �ʿ��� �޼ҵ带 �����Ű�°� ������
//����
//�׷��� ��¿ �� ���� BoardConTroller �ʵ带 �ϳ� ���⿡ ����� �ְ� �ȴ�.
public class BoardViewer {
    private BoardController controller;
    private Scanner scanner;

    public BoardViewer() {
        controller = new BoardController();
        scanner = new Scanner(System.in);

    }

    // �Խù� ���� �޴� �޼ҵ�
    public void showMenu() {
        while (true) {
            String message = "1�� �� �ۼ� 2 �� ��Ϻ��� 3 ����";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                // �� �ۼ�
                wirteBoard();
            } else if (userChoice == 2) {
                printList();
            } else if (userChoice == 3) {
                System.out.println("����");
                break;
            }
        }
    }

    private void wirteBoard() {
        BoardDTO b = new BoardDTO();

        String message = "���� ������ �Է����ּ���";
        b.setTitle(ScannerUtil.nextLine(scanner, message));
        message = "���� ������ �Է����ּ���";
        b.setContent(ScannerUtil.nextLine(scanner, message));
        message = "�ۼ��� �̸��� �Է����ּ���";
        b.setWriter(ScannerUtil.nextLine(scanner, message));
        
        controller.insert(b);
    }

    private void printList() {
        ArrayList<BoardDTO> list = controller.selectAll();

        if (list.isEmpty()) {
            System.out.println("���� ��ϵ� ���� �������� �ʽ��ϴ�.");
        } else {
            Collections.reverse(list);

            for (BoardDTO b : list) {
                System.out.printf("%d. %s\n", b.getId(), b.getTitle());
            }

            String message = "�󼼺����� ���� ��ȣ�� �ڷ� ���Ƿ��� 0�� �Է����ּ���.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && controller.selectOne(userChoice) == null) {
                System.out.println("�߸� �Է��ϼ̽��ϴ�.");
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
        System.out.println("�� ��ȣ : " + id);
        System.out.println("�� �ۼ��� : " + b.getWriter());
        System.out.println("---------------------");
        System.out.println(b.getContent());

        String message = "1���� 2 ���� 3 �ڷΰ���";
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

        b.setTitle(ScannerUtil.nextLine(scanner, "���ο� ������ �Է�"));

        b.setContent(ScannerUtil.nextLine(scanner, " ���ο� ���� �Է�"));
        controller.update(b);
    }

    private void deleteBoard(int id) {

        String yesNo = ScannerUtil.nextLine(scanner, "������ �����Ͻðڽ��ϱ�? Y/N");

        if (yesNo.equalsIgnoreCase("Y")) {
            controller.delete(id);
            printList();
        } else {
            printOne(id);
        }

    }

}
