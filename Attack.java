package NewChess;

import java.util.LinkedList;

public class Attack {
	 //进攻
	 //1 白 4空                      2
	 //1白 1 黑 3 空		0
	 //1白 2 黑  2空		-2
	 //2白 1 黑 2 空              2
	 //2 白 2 黑 1空              0
	 //2白  3 空                     4 进攻
	 //3白 1 黑 1 空		4分
	 //3白 2 空                      6 进攻
	 //
	Win win=new Win();
	boolean attack=false;

	public int[] ActtackHorizontal(LinkedList<Blackpiece> blackpiece, LinkedList<Whitepiece> whitepiece) {
		int[] Computerlocate=new int [2];
		int score=0;
		//从第一行到第n行开始扫描白子
		for(int y=95;y<550;y=y+30){
			//第n行的第一个棋子开始
			for (int x=95;x<430;x=x+30){
				score=0;
				Computerlocate[0]=0;
				Computerlocate[1]=0;
				//棋子向后扫描4个
				for(int i=0;i<150;i=i+30){
					System.out.println("x = "+x+" i "+i);
					if(win.ExistWhite(whitepiece, x+i, y)){
						score=score+2;
					}else if(win.ExistBlack(blackpiece, x+i, y)){
						score=score-2;
					}else{
						Computerlocate[0]=x+i;
						Computerlocate[1]=y;
					}	
				}
				System.out.println("x= "+x+" y "+y+" "+score);
				if(score>=2){	
						break;	
				}
			}
			if(score>=2){
				System.out.println("attack"+ Computerlocate[0]);
				System.out.println("attack" + Computerlocate[1]);
				return Computerlocate;
			}	
		}
	
		
		Computerlocate[0]=0;
		Computerlocate[1]=0;
		return Computerlocate;
		
	}	

	
	//进攻 竖向
	public int[] ActtackVertical(LinkedList<Blackpiece> blackpiece, LinkedList<Whitepiece> whitepiece) {
		int[] Computerlocate=new int [2];
		int score=0;
		//从第一行到第n行开始扫描白子
		for(int x=95;x<550;x=x+30){
			//第n行的第一个棋子开始
			for (int y=95;y<430;y=y+30){
				score=0;
				Computerlocate[0]=0;
				Computerlocate[1]=0;
				//棋子向后扫描4个
				for(int i=0;i<150;i=i+30){
					System.out.println("x = "+x+" i "+i);
					if(win.ExistWhite(whitepiece, x, y+i)){
						score=score+2;
					}else if(win.ExistBlack(blackpiece, x, y+i)){
						score=score-2;
					}else{
						Computerlocate[0]=x;
						Computerlocate[1]=y+i;
					}	
				}
				System.out.println("x= "+x+" y "+y+" "+score);
				if(score>=4){	
						break;	
				}
			}
			if(score>=4){
				attack=true;
				break;
			}	
		}
	
		if(attack){
			System.out.println("attack"+ Computerlocate[0]);
			System.out.println("attack" + Computerlocate[1]);
			return Computerlocate;
		}else{
			Computerlocate[0]=0;
			Computerlocate[1]=0;
			return Computerlocate;
		}
	}


	public int[] ActtackUpleft(LinkedList<Blackpiece> blackpiece, LinkedList<Whitepiece> whitepiece) {
		// TODO Auto-generated method stub
		return null;
	}


	public int[] ActtackUpright(LinkedList<Blackpiece> blackpiece, LinkedList<Whitepiece> whitepiece) {
		// TODO Auto-generated method stub
		return null;
	}

}
