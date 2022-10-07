package member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManager {
	private Scanner in=new Scanner(System.in);
	MemberDAO M=new MemberDAO();
	
	MemberManager(){
		for(;;) {
			menu();{
				int no=in.nextInt();
				in.nextLine();
				if(no==1) {
					input();
				}else if(no==2){
					prt();
				}else if(no==3){
					modi();
				}else if(no==4){
					del();
				}else if(no==5){
					search();
				}
			}
		}
	}
	
	public void input() {
		MemberInfo m=new MemberInfo();
		System.out.println("아이디를 입력하세요");
		String id=in.nextLine();
		m.setId(id);
		M.cheak(m);
		if(m.getId()!=null) {
			System.out.println("중복 id가 있습니다.");
		}else {
			m.setId(id);
			System.out.println("이름을 입력하세요");
			String name=in.nextLine();
			m.setName(name);
			System.out.println("비밀번호를 입력하세요");
			String pass=in.nextLine();
			m.setPass(pass);
			System.out.println("주소를 입력하세요");
			String addr=in.nextLine();
			m.setAddr(addr);
			System.out.println("포인트를 입력하세요");
			int point=in.nextInt();
			in.nextLine();
			m.setPoint(point);
			M.input(m);
			System.out.println("입력완료");
		}

	
	
	}
	
	public void modi() {
		MemberInfo m=new MemberInfo();
		System.out.println("수정할 멤버의 id를 입력하세요");
		String id=in.nextLine();
		m.setId(id);
		M.cheak(m);
		if(m.getId()==null) {
			System.out.println("해당id가 없습니다.");
			return;
		}else {
			System.out.println("수정 될 이름을 입력하세요");
			String name=in.nextLine();
			m.setName(name);
			System.out.println("수정 될 비밀번호를 입력하세요");
			String pass=in.nextLine();
			m.setPass(pass);
			System.out.println("수정 될 주소를 입력하세요");
			String addr=in.nextLine();
			m.setAddr(addr);
			System.out.println("수정 될 포인트를 입력하세요");
			int point=in.nextInt();
			in.nextLine();
			m.setPoint(point);
			M.modi(m);
			System.out.println("수정완료");
		}

		
	}
	
	public void del() {
		System.out.println("삭제할 회원의 아이디를 입력하세요");
		String id=in.nextLine();
		System.out.println("aaa");
		M.del(id);
		System.out.println("삭제완료");
		
	}
	
	public void prt() {
		ArrayList<MemberInfo> mList=M.prt();
		for(MemberInfo m:mList) {
			System.out.println("아이디: "+m.getId());
			System.out.println("이름: "+m.getName());
			System.out.println("비밀번호: "+m.getPass());
			System.out.println("주소: "+m.getAddr());
			System.out.println("포인트: "+m.getPoint());
			System.out.println("------------");
		}
	}
	
	
	
	public void menu() {
		System.out.println("1. 고객등록");
		System.out.println("2. 고객목록보기");
		System.out.println("3. 고객수정");
		System.out.println("4. 고객삭제");
		System.out.println("5. 고객검색");
		System.out.println("--메뉴선택--");
	}
	
	public void search() {
		MemberInfo m=new MemberInfo();
		System.out.println("검색할 회원의 id를 입력하세요");
		String id=in.nextLine();
		m.setId(id);
		M.search(m);
	}
	
	
	
	
	
	
	
}
