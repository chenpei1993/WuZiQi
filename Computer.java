package NewChess;

import java.util.LinkedList;

public class Computer {
	 static final int blackspacescore=-1;
	 static final int blackscore=-2;
	 static final int whitescore=2;
	 boolean danger=false;
	 //ɨ5��
	 //1�� 4�� -6 ����   ��=0 	-2
	 //2�� 3�� -7 ����      		-4
	 
	 //3�� 2 �� -8 �������� 		-6
	 //3 �� 1 �� 1 �� 		-4
	 //4 �� 1 �� -7 ���� ���� 	-8
	 //4 �� 1 �� -6 ����		-6
	 //���û�� -6 ���֣������
	 
	
	 Win win=new Win();
	 Startlib startlib =new Startlib();
	 Attack attack=new Attack();
	 Defend defend=new Defend();
	public int []ComputerStep(LinkedList<NewChess.Blackpiece> blackpiece,LinkedList<NewChess.Whitepiece> whitepiece) {
	
		int []ComputerLocate=new int [2];
		//����AI
		
		ComputerLocate=check(blackpiece,whitepiece);
		
		return ComputerLocate;
		// TODO Auto-generated method stub
		
	}
	
	public int [] check(LinkedList<NewChess.Blackpiece> blackpiece,LinkedList<NewChess.Whitepiece> whitepiece){
		int []Computerlocate=new int[2];
		//���ֿ�
	
		Computerlocate=startlib.Startlib(blackpiece, whitepiece);
	
		//���ط�
		//ÿ��
		if(Computerlocate[0]==0&&Computerlocate[1]==0){
			System.out.println("������ؿ�ʼxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate = defend.defendHorizontal(blackpiece, whitepiece);
		}
		if(Computerlocate[0]==0&&Computerlocate[1]==0){
			System.out.println("������ؿ�ʼxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate = defend.defendVertical(blackpiece, whitepiece);
		}
		if (Computerlocate[0]==0&&Computerlocate[1]==0) {
			System.out.println("���Ϸ��ؿ�ʼxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate = defend.defendUpright(blackpiece, whitepiece);
		}
		if (Computerlocate[0]==0&&Computerlocate[1]==0) {
			System.out.println("���Ϸ��ؿ�ʼxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate = defend.defendUpleft(blackpiece, whitepiece);
		}
		System.out.println(Computerlocate[0]);
		System.out.println(Computerlocate[1]);
		
		//�������Ҫ���� �� ��ʼ����
		System.out.println("������ʼxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		if(Computerlocate[0]==0&&Computerlocate[1]==0){
			System.out.println("���������ʼxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate=attack.ActtackHorizontal(blackpiece, whitepiece);
		}
		if(Computerlocate[0]==0&&Computerlocate[1]==0){
			System.out.println("���������ʼxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate=attack.ActtackVertical(blackpiece, whitepiece);
		}
		if(Computerlocate[0]==0&&Computerlocate[1]==0){
			System.out.println("���Ͻ�����ʼxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate=attack.ActtackUpright(blackpiece, whitepiece);
		}
		if(Computerlocate[0]==0&&Computerlocate[1]==0){
			System.out.println("���Ͻ�����ʼxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate=attack.ActtackUpleft(blackpiece, whitepiece);
		}
		
	
		return Computerlocate;

	}	
	
}
