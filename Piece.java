package NewChess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Piece  {
		
	 static final int BlackpieceWidth =10;
	 static final int BlackpieceHeight=10;
	 static final int WhitepieceWidth =10;
	 static final int WhitepieceHeight=10;
	public void drawBlackpiece(Graphics g,int x, int y){
		Graphics2D f2=(Graphics2D)g;
		f2.setColor(Color.black);
		f2.fillOval(x, y, BlackpieceWidth, BlackpieceHeight);
	}
	
	public void drawWhitepiece(Graphics g,int x, int y){
		Graphics2D f2=(Graphics2D)g;
		f2.setColor(Color.white);
		f2.fillOval(x, y, WhitepieceWidth, WhitepieceHeight);
	}

}

//定义黑色棋子类
class Blackpiece{
	private int Blocatex;
	private int Blocatey;
	Blackpiece(int x,int y){
		setBlocatex(x);
		setBlocatey(y);
	}
	int getBlocatex() {
		return Blocatex;
	}
	void setBlocatex(int blocatex) {
		Blocatex = blocatex;
	}
	public int getBlocatey() {
		return Blocatey;
	}
	public void setBlocatey(int blocatey) {
		Blocatey = blocatey;
	}
}

//定义白色棋子类
class Whitepiece{
	private int Wlocatex;
	private int Wlocatey;
	Whitepiece(int x,int y){
		setWlocatex(x);
		setWlocatey(y);
	}
	public int getWlocatex() {
		return Wlocatex;
	}
	public void setWlocatex(int wlocatex) {
		Wlocatex = wlocatex;
	}
	public int getWlocatey() {
		return Wlocatey;
	}
	public void setWlocatey(int wlocatey) {
		Wlocatey = wlocatey;
	}
	

}