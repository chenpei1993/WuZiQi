package NewChess;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;




public class MainFrame extends JFrame{

	
		// TODO Auto-generated method stub
		JButton b1;
		JButton b2;
	    JButton b3;
		JButton b4;

		public MainFrame(String string) {
			super(string);
			
			b1=new JButton("双人游戏");
			b1.setBounds(120,40,160,40);
			b1.addActionListener(new Choose());
			this.add(b1);
			
			b2=new JButton("单人游戏");
			b2.setBounds(120,120,160,40);
			b2.addActionListener(new Choose());
			this.add(b2);
			
			b3=new JButton("信息");
			b3.setBounds(120,200,160,40);
			b3.addActionListener(new Choose());
			this.add(b3);
			
			b4=new JButton("退出");
			b4.setBounds(120,280,160,40);
			b4.addActionListener(new Choose());
			this.add(b4);
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			MainFrame fra = new MainFrame("五子棋");
			int windowWidth=fra.getWidth();
			int windowHeight=fra.getHeight();
			Toolkit kit=Toolkit.getDefaultToolkit();
			Dimension screenSize =kit.getScreenSize();
			int screenWidth=screenSize.width;
			int screenHeight=screenSize.height;
			fra.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
			fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fra.setSize(400,400);
			fra.setLayout(null);
			fra.setVisible(true);
		}
		
		
		public class Choose implements ActionListener {
			Fenster fenster=new Fenster();
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn =(JButton)e.getSource();
				if(btn == b1){
					fenster.fenster1();
				}
				
				if(btn == b2){
					fenster.fenster2();
				}
				
				if(btn == b3){
					fenster.fenster3();
				}
				
				if(btn == b4){
					System.exit(0);
				}		
			}

	}	
}
