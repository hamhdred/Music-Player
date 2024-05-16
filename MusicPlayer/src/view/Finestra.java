package view;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class Finestra extends JFrame {

	private static final long serialVersionUID = 1L;
	

	private Panello panello;

	
	public Finestra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panello = new Panello();
		panello.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panello);
		setTitle("JTubeDownloader");
		setVisible(true);
	}

	
	public Panello returnPannello() {
		
		return panello;
		
	}
}
