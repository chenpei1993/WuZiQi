package NewChess;


import java.util.LinkedList;

import NewChess.Whitepiece;
import NewChess.Blackpiece;


public class Win {
	//判断白棋输赢
	 public boolean WinWhite(LinkedList<Whitepiece> Piece){
	 boolean is=false;
		 int Whitepiecelang = Piece.size();
		 if(Whitepiecelang>4){
			 //循环棋子
			 for(int i =0;i<Whitepiecelang;i++){
				 boolean WinStep[]=new boolean[5];
				 int wx=Piece.get(i).getWlocatex();
				 int wy=Piece.get(i).getWlocatey();
				 int interval=0;
				 //纵向查找
				 for(int j=0;j<5;j++){	 
					 WinStep[j]= ExistWhite(Piece,wx,(wy+interval));
					 if(!WinStep[j]){
						 
						 break;
					 }
					 interval=interval+30;

				 }
				 if(WinStep[0]&&WinStep[1]&&WinStep[2]&&WinStep[3]&&WinStep[4]){
					 is = true;
					 break;
				 }
				//横向查找
				interval=0;
				 for(int j=0;j<5;j++){	 
					 WinStep[j]= ExistWhite(Piece,wx+interval,wy);
					
					 if(!WinStep[j]){
						 
						 break;
					 }
					 interval=interval+30;

				 }
				 if(WinStep[0]&&WinStep[1]&&WinStep[2]&&WinStep[3]&&WinStep[4]){
					 
					 is = true;
					 break;
				 }
				 
				 //斜下
				 
				 interval=0;
				 for(int j=0;j<5;j++){	 
					 WinStep[j]= ExistWhite(Piece,wx+interval,wy+interval);
					 if(!WinStep[j]){
						 break;
					 }
					 interval=interval+30;

				 }
				 if(WinStep[0]&&WinStep[1]&&WinStep[2]&&WinStep[3]&&WinStep[4]){
					 
					 is = true;
					 break;
				 }
				 
				 //斜上
				 interval=0;
				 for(int j=0;j<5;j++){	 
					 WinStep[j]= ExistWhite(Piece,wx+interval,wy-interval);
					
					 if(!WinStep[j]){
						 
						 break;
					 }
					 interval=interval+30;

				 }
				 if(WinStep[0]&&WinStep[1]&&WinStep[2]&&WinStep[3]&&WinStep[4]){
					 
					 is = true;
					 break;
				 }
			 }
		 }
		 return is;
	}
	 
	//判断黑棋输赢	
	 public boolean WinBlack(LinkedList<Blackpiece> Piece){

		 boolean is=false;
		 int Whitepiecelang = Piece.size();
		 if(Whitepiecelang>4){
			 //循环棋子
			 for(int i =0;i<Whitepiecelang;i++){
				 boolean WinStep[]=new boolean[5];
				 int wx=Piece.get(i).getBlocatex();
				 int wy=Piece.get(i).getBlocatey();
				 int interval=0;
				 //纵向查找
				 for(int j=0;j<5;j++){	 
					 WinStep[j]= ExistBlack(Piece,wx,(wy+interval));
					 if(!WinStep[j]){
						
						 break;
					 }
					 interval=interval+30;

				 }
				 if(WinStep[0]&&WinStep[1]&&WinStep[2]&&WinStep[3]&&WinStep[4]){
					 
					 is = true;
					 break;
				 }
				//横向查找
				interval=0;
				 for(int j=0;j<5;j++){	 
					 WinStep[j]= ExistBlack(Piece,wx+interval,wy);
					 if(!WinStep[j]){
						 
						 break;
					 }
					 interval=interval+30;

				 }
				 if(WinStep[0]&&WinStep[1]&&WinStep[2]&&WinStep[3]&&WinStep[4]){
					 
					 is = true;
					 break;
				 }
				 
				 //斜下
				 
				 interval=0;
				 for(int j=0;j<5;j++){	 
					 WinStep[j]= ExistBlack(Piece,wx+interval,wy+interval);
					 if(!WinStep[j]){
						 
						 break;
					 }
					 interval=interval+30;

				 }
				 if(WinStep[0]&&WinStep[1]&&WinStep[2]&&WinStep[3]&&WinStep[4]){
					 
					 is = true;
					 break;
				 }
				 
				 //斜上
				 interval=0;
				 for(int j=0;j<5;j++){	 
					 WinStep[j]= ExistBlack(Piece,wx+interval,wy-interval);
					 if(!WinStep[j]){
						 break;
					 }
					 interval=interval+30;

				 }
				 if(WinStep[0]&&WinStep[1]&&WinStep[2]&&WinStep[3]&&WinStep[4]){
					 is = true;
					 break;
				 }
			 }
		 }
		 return is;
	} 
	
//检查时候有黑子
	 public boolean ExistBlack(LinkedList<Blackpiece> Piece,int x,int y){
		 boolean Exist = false;
		 int Blackpiecelang=Piece.size();
		 for(int i=0;i<Blackpiecelang;i++){
			if(x==Piece.get(i).getBlocatex())
			 if(y==Piece.get(i).getBlocatey())
				 Exist=true;
		}
		return Exist;	
	 } 
//检查是否有白子
	 public boolean ExistWhite(LinkedList<Whitepiece> Piece,int x,int y){

		 boolean Exist = false;
		 int Whitepiecelang=Piece.size();
		 for(int i=0;i<Whitepiecelang;i++){
			if(x==Piece.get(i).getWlocatex()){
				if(y==Piece.get(i).getWlocatey()){
					 Exist=true;
				}		
			}
		}
		return Exist;	
	 } 
}
