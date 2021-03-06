package controller;
// 컨트롤러

// 컨트롤러는 데이터베이스로부터 값을 받아서 뷰어에 뿌려줄 값을
// 객체의 형태로 보내주거나
// 아니면 뷰어에서 입력받은 값을 객체의 형태로 받아서
// 데이터베이스로 보내주는
// 일종의 중간다리 역할을 맞는 클래스이다

//단, 지금 현재는 우리에게 데이터베이스가 없다는 문제가 있기 때문에
//유사 데이터베이스 역할을 해줄 ArrayList<BoardDTO>를 필드로 하나 가지게 된다.
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
            b.setTitle("제목 :" + i);
            b.setWriter("작성자 : " + i);
            b.setContent("내용 : " + i);

            insert(b);
        }
    }

    // 뷰어에서 보낸 BoardDTO 객체에
    // id를 추가한 후에 list 에 저장하는
    // insert()
    public void insert(BoardDTO b) {
        b.setId(nextId++);
        list.add(b);
    }

    // 뷰어에 출력한 게시글 리스트를
    // 원본에서 딥 카피한 버전을 보내줄
    // selectAll()
    public ArrayList<BoardDTO> selectAll() {
        ArrayList<BoardDTO> temp = new ArrayList<>();
        
        for(BoardDTO b : list) {
            temp.add(new BoardDTO(b));
        }
        
        return temp;
    }
    
    // 특정 id값을 가진
    // BoardDTO 객체를 리턴하는 selectOne()
    // 단 해당 id값이 존재핮 ㅣ않는다면
    // null 이 리턴된다
    public BoardDTO selectOne(int id) {
        for(BoardDTO b : list) {
            if(b.getId() == id) {
                return new BoardDTO(b);
            }
        }
        
        return null;
    }
    //리스트의 특정 개체를 수정하는
    //update()
    public void update(BoardDTO b) {
        int index = list.indexOf(b);
        list.set(index, b);
    }
    //리스트의 특징 개체를 삭제하는
    //delete
    public void delete(int id) {
        list.remove(new BoardDTO(id));
    }
}
