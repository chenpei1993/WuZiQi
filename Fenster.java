package NewChess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Fenster  {
	
	public void fenster1() {
		JFrame f = new JFrame("������");
		f.add(new Djanel(f));
		f.setVisible(true);
		f.setResizable(false);
		f.setSize(800,800);
	}

	public void fenster2() {
		JFrame f =new JFrame("������Ϸ");
		f.add(new Sjanel(f));
		f.setVisible(true);
		f.setResizable(false);
		f.setSize(800,800);	
	}
	
	public void fenster3() {
		JFrame f =new JFrame("˵��");
		f.setVisible(true);
		f.setSize(400,400);
	}

}
