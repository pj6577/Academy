package model;
//��
//�� Ŭ�������� �������� Ʋ�� ����ϴ� Ŭ�����̴�.
//�� Ŭ���� �ȿ��� � �����Ͱ� ������ ���� (=�ʵ�)
//����/����
//�׸��� java.lang.Object �� �������̵� �� �޼ҵ常 ���� �ȴ�.

// DTO VS VO
// Data Transfer Object : ������ ���� ��ü -> �����ͺ��̽��κ��� ���� �����͸�
// ��ü�� ��Ƽ� ����ڿ��� �����ٶ� ���� Ʋ + ����ڰ� �Է��� �����͸�
// ��ü�� ��Ƽ� �����ͺ��̽��� �����ٶ� ���� Ʋ
// Value Object : �� ��ü -> �����ͺ��̽��κ��� ���� �����͸� ��ü�� ��Ƽ�
// ����ڿ��� �����ٶ� ���� Ʋ

public class BoardDTO {
    //�ʵ�
    private int id;
 
    private String title;
    private String content;
    private String writer;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String tite) {
        this.title = tite;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    
    public BoardDTO() {
        title = new String();
        content = new String();
        writer = new String();
    }
   
    public BoardDTO(int id){
        this.id = id;
        title = new String();
        content = new String();
        writer = new String();
    }

    public BoardDTO(BoardDTO origin){
        id = origin.id;
        title = origin.title;
        writer = origin.writer;
        content = origin.content;
    }

    public boolean equals(Object o){
        if(o instanceof BoardDTO){
            BoardDTO b = (BoardDTO)o;
            return id == b.id;
        }
        return false;
    }


    
}
