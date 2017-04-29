package NewChess;

import java.util.LinkedList;

public class Attack {
	 //����
	 //1 �� 4��                      2
	 //1�� 1 �� 3 ��		0
	 //1�� 2 ��  2��		-2
	 //2�� 1 �� 2 ��              2
	 //2 �� 2 �� 1��              0
	 //2��  3 ��                     4 ����
	 //3�� 1 �� 1 ��		4��
	 //3�� 2 ��                      6 ����
	 //
	Win win=new Win();
	boolean attack=false;

	public int[] ActtackHorizontal(LinkedList<Blackpiece> blackpiece, LinkedList<Whitepiece> whitepiece) {
		int[] Computerlocate=new int [2];
		int score=0;
		//�ӵ�һ�е���n�п�ʼɨ�����
		for(int y=95;y<550;y=y+30){
			//��n�еĵ�һ�����ӿ�ʼ
			for (int x=95;x<430;x=x+30){
				score=0;
				Computerlocate[0]=0;
				Computerlocate[1]=0;
				//�������ɨ��4��
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

	
	//���� ����
	public int[] ActtackVertical(LinkedList<Blackpiece> blackpiece, LinkedList<Whitepiece> whitepiece) {
		int[] Computerlocate=new int [2];
		int score=0;
		//�ӵ�һ�е���n�п�ʼɨ�����
		for(int x=95;x<550;x=x+30){
			//��n�еĵ�һ�����ӿ�ʼ
			for (int y=95;y<430;y=y+30){
				score=0;
				Computerlocate[0]=0;
				Computerlocate[1]=0;
				//�������ɨ��4��
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
