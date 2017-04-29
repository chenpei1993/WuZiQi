package NewChess;

import java.util.LinkedList;
import java.util.Random;

public class Startlib {
	Win win=new Win();
	Random ra=new Random();
	int choose=0;
	public int[] Startlib(LinkedList<NewChess.Blackpiece> blackpiece,LinkedList<NewChess.Whitepiece> whitepiece){
		int Computerlocate []=new int [2];
		int blackpiecelang =blackpiece.size();
		if(blackpiecelang==1){
			choose=ra.nextInt(4);
			choose=choose+1;
		}
		switch(choose) {
		case 1:
			if(blackpiecelang==1){
				Computerlocate[0]=blackpiece.get(0).getBlocatex()+30;
				Computerlocate[1]=blackpiece.get(0).getBlocatey();
			}
			if(blackpiecelang==2){
				if(win.ExistBlack(blackpiece, blackpiece.get(1).getBlocatex()+30, blackpiece.get(1).getBlocatey())){
					Computerlocate[0]=blackpiece.get(1).getBlocatex();
					Computerlocate[1]=blackpiece.get(1).getBlocatey()+30;
				}else{
					Computerlocate[0]=blackpiece.get(1).getBlocatex()+30;
					Computerlocate[1]=blackpiece.get(1).getBlocatey();
				}
			}
			
			return Computerlocate;
			
		
		case 2:		
			if(blackpiecelang==1){
				Computerlocate[0]=blackpiece.get(0).getBlocatex()+30;
				Computerlocate[1]=blackpiece.get(0).getBlocatey()+30;
			}
			if(blackpiecelang==2){
				if(win.ExistBlack(blackpiece, blackpiece.get(1).getBlocatex()+30, blackpiece.get(1).getBlocatey()+30)){
					Computerlocate[0]=blackpiece.get(1).getBlocatex();
					Computerlocate[1]=blackpiece.get(1).getBlocatey()+30;
				}else{
					Computerlocate[0]=blackpiece.get(1).getBlocatex()+30;
					Computerlocate[1]=blackpiece.get(1).getBlocatey()+30;
				}
			};
			return Computerlocate;
			
		case 3:
			if(blackpiecelang==1){
				Computerlocate[0]=blackpiece.get(0).getBlocatex()-30;
				Computerlocate[1]=blackpiece.get(0).getBlocatey()-30;
			}
			if(blackpiecelang==2){
				if(win.ExistBlack(blackpiece, blackpiece.get(1).getBlocatex()-30, blackpiece.get(1).getBlocatey()-30)){
					Computerlocate[0]=blackpiece.get(1).getBlocatex();
					Computerlocate[1]=blackpiece.get(1).getBlocatey()+30;
				}else{
				Computerlocate[0]=blackpiece.get(1).getBlocatex()-30;
				Computerlocate[1]=blackpiece.get(1).getBlocatey()-30;
				}
			};
			return Computerlocate;
			
		case 4:
			if(blackpiecelang==1){
				Computerlocate[0]=blackpiece.get(0).getBlocatex()+30;
				Computerlocate[1]=blackpiece.get(0).getBlocatey()+30;
			}
			if(blackpiecelang==2){
				if(win.ExistBlack(blackpiece, blackpiece.get(1).getBlocatex()+30, blackpiece.get(1).getBlocatey()+30)){
					Computerlocate[0]=blackpiece.get(1).getBlocatex();
					Computerlocate[1]=blackpiece.get(1).getBlocatey()+30;
				}else if(win.ExistBlack(blackpiece, blackpiece.get(1).getBlocatex()+30, blackpiece.get(1).getBlocatey()-30)){
					Computerlocate[0]=blackpiece.get(1).getBlocatex()-30;
					Computerlocate[1]=blackpiece.get(1).getBlocatey()+30;
				}else if(win.ExistBlack(blackpiece, blackpiece.get(1).getBlocatex()-30, blackpiece.get(1).getBlocatey()+30)){
					Computerlocate[0]=blackpiece.get(1).getBlocatex()+30;
					Computerlocate[1]=blackpiece.get(1).getBlocatey()-30;
				}
				
				else{
					Computerlocate[0]=blackpiece.get(1).getBlocatex()+30;
					Computerlocate[1]=blackpiece.get(1).getBlocatey()+30;
				}
			};
			return Computerlocate;

			
			
		default:
			Computerlocate[0]=0;
			Computerlocate[1]=0;
			return Computerlocate;
		}
		
		
		
		
	}
	
}
