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
		System.out.println("���̵� �Է��ϼ���");
		String id=in.nextLine();
		m.setId(id);
		M.cheak(m);
		if(m.getId()!=null) {
			System.out.println("�ߺ� id�� �ֽ��ϴ�.");
		}else {
			m.setId(id);
			System.out.println("�̸��� �Է��ϼ���");
			String name=in.nextLine();
			m.setName(name);
			System.out.println("��й�ȣ�� �Է��ϼ���");
			String pass=in.nextLine();
			m.setPass(pass);
			System.out.println("�ּҸ� �Է��ϼ���");
			String addr=in.nextLine();
			m.setAddr(addr);
			System.out.println("����Ʈ�� �Է��ϼ���");
			int point=in.nextInt();
			in.nextLine();
			m.setPoint(point);
			M.input(m);
			System.out.println("�Է¿Ϸ�");
		}

	
	
	}
	
	public void modi() {
		MemberInfo m=new MemberInfo();
		System.out.println("������ ����� id�� �Է��ϼ���");
		String id=in.nextLine();
		m.setId(id);
		M.cheak(m);
		if(m.getId()==null) {
			System.out.println("�ش�id�� �����ϴ�.");
			return;
		}else {
			System.out.println("���� �� �̸��� �Է��ϼ���");
			String name=in.nextLine();
			m.setName(name);
			System.out.println("���� �� ��й�ȣ�� �Է��ϼ���");
			String pass=in.nextLine();
			m.setPass(pass);
			System.out.println("���� �� �ּҸ� �Է��ϼ���");
			String addr=in.nextLine();
			m.setAddr(addr);
			System.out.println("���� �� ����Ʈ�� �Է��ϼ���");
			int point=in.nextInt();
			in.nextLine();
			m.setPoint(point);
			M.modi(m);
			System.out.println("�����Ϸ�");
		}

		
	}
	
	public void del() {
		System.out.println("������ ȸ���� ���̵� �Է��ϼ���");
		String id=in.nextLine();
		System.out.println("aaa");
		M.del(id);
		System.out.println("�����Ϸ�");
		
	}
	
	public void prt() {
		ArrayList<MemberInfo> mList=M.prt();
		for(MemberInfo m:mList) {
			System.out.println("���̵�: "+m.getId());
			System.out.println("�̸�: "+m.getName());
			System.out.println("��й�ȣ: "+m.getPass());
			System.out.println("�ּ�: "+m.getAddr());
			System.out.println("����Ʈ: "+m.getPoint());
			System.out.println("------------");
		}
	}
	
	
	
	public void menu() {
		System.out.println("1. �����");
		System.out.println("2. ����Ϻ���");
		System.out.println("3. ������");
		System.out.println("4. ������");
		System.out.println("5. ���˻�");
		System.out.println("--�޴�����--");
	}
	
	public void search() {
		MemberInfo m=new MemberInfo();
		System.out.println("�˻��� ȸ���� id�� �Է��ϼ���");
		String id=in.nextLine();
		m.setId(id);
		M.search(m);
	}
	
	
	
	
	
	
	
}
