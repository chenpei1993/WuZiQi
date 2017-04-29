package NewChess;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import NewChess.Djanel.Action;
import NewChess.Djanel.AllListen;
import NewChess.Piece;
import NewChess.Blackpiece;
import NewChess.Whitepiece;

public class Djanel extends JPanel {
	
	JFrame f;
		
	int BlackStep=0;
	int WhiteStep=0;
	
	int count=1;
	//定义黑色棋子链表
	LinkedList<Blackpiece> Blackpiece= new LinkedList<Blackpiece>(); 
	LinkedList<Whitepiece> Whitepiece= new LinkedList<Whitepiece>(); 
	Win win=new Win();
	
	
	public void paint(Graphics g){
		super.paint(g);
		//画出棋盘
			g.setColor(Color.black);
			for (int i = 100;i<580;i=i+30){
				g.drawLine(i, 100, i, 550);
				g.drawLine(100, i, 550, i);
			}
			Piece Piece=new Piece();
			
			
				
			int Blackpiecelang=Blackpiece.size();
			for(int i=0;i<Blackpiecelang;i++){
				int bx=Blackpiece.get(i).getBlocatex();
				int by=Blackpiece.get(i).getBlocatey();
				Piece.drawBlackpiece(g,bx,by);
			}
					
			int Whitepiecelang=Whitepiece.size();
			for(int i=0;i<Whitepiecelang;i++){
				int wx=Whitepiece.get(i).getWlocatex();
				int wy=Whitepiece.get(i).getWlocatey();
				Piece.drawWhitepiece(g,wx,wy);
			}
			
			repaint();
	}
	
	 Djanel(JFrame fra){  
		 //设置监听
		 	f=fra;
			JMenuBar jmenubar =new JMenuBar();
			JMenu jmenu=new JMenu("选项");
			JMenu jmenu2=new JMenu("帮助");
		    jmenubar.add(jmenu);
			jmenubar.add(jmenu2);
			JMenuItem jmi1 =new JMenuItem("开始新游戏");
			jmi1.addActionListener(new Action());
			jmi1.setActionCommand("newgame");
			JMenuItem jmi2 =new JMenuItem("退出游戏");
			jmi2.addActionListener(new Action());
			jmi2.setActionCommand("exit");
			JMenuItem jmi3 =new JMenuItem("撤销");
			jmi3.addActionListener(new Action() );
			jmi3.setActionCommand("undo");
			jmenu.add(jmi1);
			jmenu.add(jmi2);
			jmenu.add(jmi3);
			f.setJMenuBar(jmenubar);
//			JLabel jl1=new JLabel("BlackStep "+BlackStep);
//			jl1.setBounds(600,200,200,100);
//			jl1.setFont(new Font("Arial",Font.BOLD,24));
			this.setLayout(null);
			this.addMouseListener(new AllListen()); 
	 }
	public class Action implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if(arg0.getActionCommand().equals("newgame")){
				Clear();
			}else if(arg0.getActionCommand().equals("undo")){
				Undo(Blackpiece,Whitepiece);
			} else if(arg0.getActionCommand().equals("exit")){
				System.exit(0);
			}
		}
	 }
	 




	//设置监听函数

	 public class AllListen implements MouseListener {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int x,y;
				x=e.getX();
				y=e.getY();
				chesslocate(x,y);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		}
	 
	 public void chesslocate(int x,int y) {
			//判定棋子的位置
			int i;
			int j;
			int chessx = 0;
			int chessy = 0;
			
			if(100<x&&x<550&&100<y&&y<550){
				for(i=0;i<15;i++){
					if((85+30*i)<x&&x<(115+30*i)){
						chessx=95+i*30;
						break;
					}
				}
				
				for( j=0;j<15;j++){
					if((85+30*j)<y&&y<(115+30*j)){
						chessy=95+j*30;
						break;
					}
				}
				
				//写入棋子到黑色
				if (chessx !=0 && chessy!=0){
					//是否已存在棋子
					boolean is=win.ExistBlack(Blackpiece,chessx,chessy)||win.ExistWhite(Whitepiece,chessx,chessy);
					if(!is){
						if(BlackStep==WhiteStep){
							Blackpiece.add(new Blackpiece(chessx,chessy));
							if(win.WinBlack(Blackpiece)){
								fenster(f);
							}else{
								BlackStep++;
								
							}
						}else{
							Whitepiece.add(new Whitepiece(chessx,chessy));
							if(win.WinWhite(Whitepiece)){
								fenster(f);
							}else{
								WhiteStep++;
							}
							
						}
					}else{
						fenster2(f);
					}	
				}
			}
	 }
	 
	 
	 public void Clear(){
		  Blackpiece.clear();
		  BlackStep=0;
		  Whitepiece.clear();
		  WhiteStep=0;
	 }
	 
	 public void Undo(LinkedList<Blackpiece> blackpiece,LinkedList<Whitepiece> whitepiece){
		 if(BlackStep>WhiteStep){
			 blackpiece.removeLast();
			 BlackStep--;
		 }else{
			 whitepiece.removeLast();
			 WhiteStep--;
		 }
	 }
	 
	public void fenster(JFrame f) {
			JDialog jd = new JDialog(f,"对话框",true);
			jd.setSize(300,200);
			jd.setResizable(false);
			jd.setModal(true);
			Container c=jd.getContentPane();
			c.setLayout(null);
			c.setVisible(true);
			JLabel lab=new JLabel("Win");
			lab.setFont(new Font("宋体",Font.BOLD,20));
			lab.setBounds(90, 20, 150, 50);
			JButton jb=new JButton("确定");
			jb.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Clear();
					jd.dispose();
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
	
				});
				
			jb.setBounds(100, 100, 60, 30);
			c.add(lab);
			c.add(jb);
			jd.setVisible(true);//添加完组建后，显示
			jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
		} 
	public void fenster2(JFrame f) {
		JDialog jd= new JDialog(f,"对话框",true);
		
		jd.setSize(300,200);
		jd.setResizable(false);
		jd.setModal(true);
		Container c=jd.getContentPane();
		c.setLayout(null);
		c.setVisible(true);
		JLabel lab=new JLabel("此处有棋子");
		lab.setFont(new Font("宋体",Font.BOLD,20));
		lab.setBounds(90, 20, 150, 50);
		JButton jb=new JButton("确定");
		jb.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				jd.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			});
			
		jb.setBounds(100, 100, 60, 30);
		c.add(lab);
		c.add(jb);
		jd.setVisible(true);//添加完组建后，显示
		jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	
	} 

}