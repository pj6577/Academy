package controller;
// ��Ʈ�ѷ�

// ��Ʈ�ѷ��� �����ͺ��̽��κ��� ���� �޾Ƽ� �� �ѷ��� ����
// ��ü�� ���·� �����ְų�
// �ƴϸ� ���� �Է¹��� ���� ��ü�� ���·� �޾Ƽ�
// �����ͺ��̽��� �����ִ�
// ������ �߰��ٸ� ������ �´� Ŭ�����̴�

//��, ���� ����� �츮���� �����ͺ��̽��� ���ٴ� ������ �ֱ� ������
//���� �����ͺ��̽� ������ ���� ArrayList<BoardDTO>�� �ʵ�� �ϳ� ������ �ȴ�.
import java.util.ArrayList;

import model.BoardDTO;

public class BoardController {
    private ArrayList<BoardDTO> list;
    private int nextId;

    public BoardController() {
        list = new ArrayList<>();
        nextId = 1;

        for (int i = 0; i < i; i++) {
            BoardDTO b = new BoardDTO();
            b.setTitle("���� :" + i);
            b.setWriter("�ۼ��� : " + i);
            b.setContent("���� : " + i);

            insert(b);
        }
    }

    // ���� ���� BoardDTO ��ü��
    // id�� �߰��� �Ŀ� list �� �����ϴ�
    // insert()
    public void insert(BoardDTO b) {
        b.setId(nextId++);
        list.add(b);
    }

    // �� ����� �Խñ� ����Ʈ��
    // �������� �� ī���� ������ ������
    // selectAll()
    public ArrayList<BoardDTO> selectAll() {
        ArrayList<BoardDTO> temp = new ArrayList<>();
        
        for(BoardDTO b : list) {
            temp.add(new BoardDTO(b));
        }
        
        return temp;
    }
    
    // Ư�� id���� ����
    // BoardDTO ��ü�� �����ϴ� selectOne()
    // �� �ش� id���� �����F �Ӿʴ´ٸ�
    // null �� ���ϵȴ�
    public BoardDTO selectOne(int id) {
        for(BoardDTO b : list) {
            if(b.getId() == id) {
                return new BoardDTO(b);
            }
        }
        
        return null;
    }
    //����Ʈ�� Ư�� ��ü�� �����ϴ�
    //update()
    public void update(BoardDTO b) {
        int index = list.indexOf(b);
        list.set(index, b);
    }
    //����Ʈ�� Ư¡ ��ü�� �����ϴ�
    //delete
    public void delete(int id) {
        list.remove(new BoardDTO(id));
    }
}
