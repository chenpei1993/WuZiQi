package NewChess;

import java.util.LinkedList;

public class Defend {
	Win win=new Win();
	boolean danger=false;
	public int [] defendHorizontal(LinkedList<NewChess.Blackpiece> blackpiece,LinkedList<NewChess.Whitepiece> whitepiece){
		int[] Computerlocate=new int [2];
		int score=0;
		//从第一行到第n行开始扫描
		for(int y=95;y<550;y=y+30){
			//第n行的第一个棋子开始
			for (int x=95;x<430;x=x+30){
				score=0;
				Computerlocate[0]=0;
				Computerlocate[1]=0;
				//棋子向后扫描4个
				
				for(int i=0;i<150;i=i+30){		
						if(win.ExistBlack(blackpiece, x+i, y)){
							score=score-2;
						}else if(win.ExistWhite(whitepiece, x+i, y)){
							score=score+2;
						}else{
							Computerlocate[0]=x+i;
							Computerlocate[1]=y;
							System.out.println("x = "+Computerlocate[0]);
							System.out.println("y = "+Computerlocate[1]);
						}	
				}
				System.out.println("x= "+x+" y "+y+" "+score);
				if(win.ExistBlack(blackpiece, x, y)){
					if(win.ExistWhite(whitepiece, x-30, y)||(win.ExistWhite(whitepiece, x-30, y)||win.ExistWhite(whitepiece, x+150, y))){
						if(score==-8)
							break;
						else
						continue;
					}
				}
				if(score<=-6){
					//如果没有填满则break
					if(!(Computerlocate[0]==0&&Computerlocate[1]==0)){
						break;
					}
				}
			}
			if(score<=-6){
				danger=true;
				break;
			}	
		}	
		if(danger){
			System.out.println("danger" + Computerlocate[0]);
			System.out.println("danger" + Computerlocate[1]);
			danger=false;
			return Computerlocate;
		}else{
			Computerlocate[0]=0;
			Computerlocate[1]=0;
			return Computerlocate;
		}
	}
	public int[] defendVertical(LinkedList<Blackpiece> blackpiece, LinkedList<Whitepiece> whitepiece) {
		// TODO Auto-generated method stub
		int[] Computerlocate=new int [2];
		int score=0;
		//从第一行到第n行开始扫描
		for(int x=95;x<550;x=x+30){
			//第n行的第一个棋子开始
			for (int y=95;y<430;y=y+30){
				score=0;
				Computerlocate[0]=0;
				Computerlocate[1]=0;
				//棋子向后扫描4个
				for(int i=0;i<150;i=i+30){
					if(win.ExistBlack(blackpiece, x, y+i)){
						score=score-2;
					}else if(win.ExistWhite(whitepiece, x, y+i)){
						score=score+2;
					}else{
						Computerlocate[0]=x;
						Computerlocate[1]=y+i;
						System.out.println("x = "+Computerlocate[0]);
						System.out.println("y = "+Computerlocate[1]);
					}	
				}
				System.out.println("x= "+x+" y "+y+" "+score);
				if(win.ExistBlack(blackpiece, x, y)){
					if(win.ExistWhite(whitepiece, x, y-30)){
						if(score==-8)
							break;
						else
							continue;
					}
				}
				if(score<=-6){
					if(!(Computerlocate[0]==0&&Computerlocate[1]==0)){
						break;
					}
				}
			}
			if(score<=-6){	
				danger=true;
				break;
			}	
		}	
		if(danger){
			System.out.println("danger" + Computerlocate[0]);
			System.out.println("danger" + Computerlocate[1]);
			danger=false;
			return Computerlocate;
		}else{
			Computerlocate[0]=0;
			Computerlocate[1]=0;
			return Computerlocate;
		}
	}
	public int[] defendUpright(LinkedList<Blackpiece> blackpiece, LinkedList<Whitepiece> whitepiece) {
		// TODO Auto-generated method stub
		int[] Computerlocate=new int [2];
		int score=0;
		//从第一行到第n行开始扫描
		for(int y=95;y<450;y=y+30){
			//第n行的第一个棋子开始
			for (int x=215;x<550;x=x+30){
				score=0;
				Computerlocate[0]=0;
				Computerlocate[1]=0;
				//棋子向后扫描4个
				for(int i=0;i<150;i=i+30){
					if(win.ExistBlack(blackpiece, x-i, y+i)){
						score=score-2;
					}else if(win.ExistWhite(whitepiece, x-i, y+i)){
						score=score+2;
					}else{
						Computerlocate[0]=x-i;
						Computerlocate[1]=y+i;
						System.out.println("x = "+Computerlocate[0]+" y = "+Computerlocate[1]);
					}	
				}
				System.out.println("x= "+x+" y "+y+" "+score);
				if(win.ExistBlack(blackpiece, x, y)){
					if(win.ExistWhite(whitepiece, x+30, y-30)){
						if(score==-8)
							break;
						else
							continue;
					}
				}
				if(score<=-6){
					if(!(Computerlocate[0]==0&&Computerlocate[1]==0)){
						break;
					}
				}
			}
			if(score<=-6){	
				danger=true;
				break;
			}	
		}	
		if(danger){
			System.out.println("danger" + Computerlocate[0]);
			System.out.println("danger" + Computerlocate[1]);
			danger=false;
			return Computerlocate;
		}else{
			Computerlocate[0]=0;
			Computerlocate[1]=0;
			return Computerlocate;
		}
	}
	public int[] defendUpleft(LinkedList<Blackpiece> blackpiece, LinkedList<Whitepiece> whitepiece) {
		// TODO Auto-generated method stub
		int[] Computerlocate=new int [2];
		int score=0;
		//从第一行到第n行开始扫描
		for(int y=95;y<450;y=y+30){
			//第n行的第一个棋子开始
			for (int x=95;x<450;x=x+30){
				score=0;
				Computerlocate[0]=0;
				Computerlocate[1]=0;
				//棋子向后扫描4个
				for(int i=0;i<150;i=i+30){
					if(win.ExistBlack(blackpiece, x+i, y+i)){
						score=score-2;
					}else if(win.ExistWhite(whitepiece, x+i, y+i)){
						score=score+2;
					}else{
						Computerlocate[0]=x+i;
						Computerlocate[1]=y+i;
						System.out.println("x = "+Computerlocate[0]+" y = "+Computerlocate[1]);
					}	
				}
				System.out.println("x= "+x+" y "+y+" "+score);
				if(win.ExistBlack(blackpiece, x, y)){
					if(win.ExistWhite(whitepiece, x-30, y-30)){
						if(score==-8)
							break;
						else
							continue;
					}
				}
				if(score<=-6){
					if(!(Computerlocate[0]==0&&Computerlocate[1]==0)){
						break;
					}
				}
			}
			if(score<=-6){	
				danger=true;
				break;
			}	
		}	
		if(danger){
			System.out.println("danger" + Computerlocate[0]);
			System.out.println("danger" + Computerlocate[1]);
			danger=false;
			return Computerlocate;
		}else{
			Computerlocate[0]=0;
			Computerlocate[1]=0;
			return Computerlocate;
		}
	}
}
