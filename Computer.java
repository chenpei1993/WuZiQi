package NewChess;

import java.util.LinkedList;

public class Computer {
	 static final int blackspacescore=-1;
	 static final int blackscore=-2;
	 static final int whitescore=2;
	 boolean danger=false;
	 //扫5子
	 //1黑 4空 -6 忽略   空=0 	-2
	 //2黑 3空 -7 忽略      		-4
	 
	 //3黑 2 空 -8 调出防守 		-6
	 //3 黑 1 空 1 白 		-4
	 //4 黑 1 空 -7 跳出 防守 	-8
	 //4 黑 1 白 -6 防守		-6
	 //如果没有 -6 出现，则进攻
	 
	
	 Win win=new Win();
	 Startlib startlib =new Startlib();
	 Attack attack=new Attack();
	 Defend defend=new Defend();
	public int []ComputerStep(LinkedList<NewChess.Blackpiece> blackpiece,LinkedList<NewChess.Whitepiece> whitepiece) {
	
		int []ComputerLocate=new int [2];
		//运用AI
		
		ComputerLocate=check(blackpiece,whitepiece);
		
		return ComputerLocate;
		// TODO Auto-generated method stub
		
	}
	
	public int [] check(LinkedList<NewChess.Blackpiece> blackpiece,LinkedList<NewChess.Whitepiece> whitepiece){
		int []Computerlocate=new int[2];
		//开局库
	
		Computerlocate=startlib.Startlib(blackpiece, whitepiece);
	
		//防守方
		//每行
		if(Computerlocate[0]==0&&Computerlocate[1]==0){
			System.out.println("横向防守开始xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate = defend.defendHorizontal(blackpiece, whitepiece);
		}
		if(Computerlocate[0]==0&&Computerlocate[1]==0){
			System.out.println("纵向防守开始xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate = defend.defendVertical(blackpiece, whitepiece);
		}
		if (Computerlocate[0]==0&&Computerlocate[1]==0) {
			System.out.println("右上防守开始xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate = defend.defendUpright(blackpiece, whitepiece);
		}
		if (Computerlocate[0]==0&&Computerlocate[1]==0) {
			System.out.println("左上防守开始xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate = defend.defendUpleft(blackpiece, whitepiece);
		}
		System.out.println(Computerlocate[0]);
		System.out.println(Computerlocate[1]);
		
		//如果不需要防守 则 开始进攻
		System.out.println("进攻开始xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		if(Computerlocate[0]==0&&Computerlocate[1]==0){
			System.out.println("横向进攻开始xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate=attack.ActtackHorizontal(blackpiece, whitepiece);
		}
		if(Computerlocate[0]==0&&Computerlocate[1]==0){
			System.out.println("竖向进攻开始xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate=attack.ActtackVertical(blackpiece, whitepiece);
		}
		if(Computerlocate[0]==0&&Computerlocate[1]==0){
			System.out.println("右上进攻开始xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate=attack.ActtackUpright(blackpiece, whitepiece);
		}
		if(Computerlocate[0]==0&&Computerlocate[1]==0){
			System.out.println("左上进攻开始xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			Computerlocate=attack.ActtackUpleft(blackpiece, whitepiece);
		}
		
	
		return Computerlocate;

	}	
	
}
