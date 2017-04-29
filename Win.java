package NewChess;


import java.util.LinkedList;

import NewChess.Whitepiece;
import NewChess.Blackpiece;


public class Win {
	//�жϰ�����Ӯ
	 public boolean WinWhite(LinkedList<Whitepiece> Piece){
	 boolean is=false;
		 int Whitepiecelang = Piece.size();
		 if(Whitepiecelang>4){
			 //ѭ������
			 for(int i =0;i<Whitepiecelang;i++){
				 boolean WinStep[]=new boolean[5];
				 int wx=Piece.get(i).getWlocatex();
				 int wy=Piece.get(i).getWlocatey();
				 int interval=0;
				 //�������
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
				//�������
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
				 
				 //б��
				 
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
				 
				 //б��
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
	 
	//�жϺ�����Ӯ	
	 public boolean WinBlack(LinkedList<Blackpiece> Piece){

		 boolean is=false;
		 int Whitepiecelang = Piece.size();
		 if(Whitepiecelang>4){
			 //ѭ������
			 for(int i =0;i<Whitepiecelang;i++){
				 boolean WinStep[]=new boolean[5];
				 int wx=Piece.get(i).getBlocatex();
				 int wy=Piece.get(i).getBlocatey();
				 int interval=0;
				 //�������
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
				//�������
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
				 
				 //б��
				 
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
				 
				 //б��
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
	
//���ʱ���к���
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
//����Ƿ��а���
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
