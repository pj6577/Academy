package main;
import view.BoardViewer;

//1.�� �л� ���� �ý����� MVC �������� �����Ͻÿ�
//2�� ����� ���� �ý����� ����ÿ�
//�� ȸ�����Խ� ������ ���̵�� ���� �� �����ϴ�
//3�� ������� �ý����� MVC�������� �����Ͻÿ�
public class BoardMain {
    public static void main(String[] args) {
        BoardViewer boardViewer = new BoardViewer();
        boardViewer.showMenu();
    }
}
