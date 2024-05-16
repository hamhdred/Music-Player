package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;

public class Panello extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textLink;

	
	
	public JButton btnVai;
	public JButton btnPause;
	public JButton btnRestart;
	public JButton btnStop;
	public JButton btnPlay;
	public JButton btnstop;

	
	public Panello() {
		setForeground(new Color(0, 0, 0));
		setLayout(null);
		
		setBackground(Color.RED);
		textLink = new JTextField();
		textLink.setBounds(81, 31, 287, 20);
		add(textLink);
		textLink.setColumns(10);
		
		btnVai = new JButton("DOWNLOAD");
		btnVai.setBounds(161, 79, 130, 23);
		btnVai.setActionCommand("VAI");
		add(btnVai);
		
		
	
		btnPlay = new JButton("Play (recent song)");
		btnPlay.setBounds(81, 178, 198, 23);
		btnPlay.setActionCommand("Play");
		add(btnPlay);
		
		btnstop = new JButton("STOP");
		btnstop.setEnabled(false);
		btnstop.setBounds(279, 178, 89, 23);
		btnstop.setActionCommand("STOP");
		add(btnstop);
		
	
		
		

	}
	
	
	
	
	public void registraEvento(Controller controller) {
		btnVai.addActionListener( controller);
		btnPlay.addActionListener(controller);
		btnstop.addActionListener(controller);
	}
	
	
	
	//ABILITAZIONI
	
	public void disabilitaPlay() {
		
		btnPlay.setEnabled(false);
	}
	public void abilitaPlay() {
		btnPlay.setEnabled(true);
	}
	public void abilitaStop() {
		
		btnstop.setEnabled(true);
	}
	public void disabilitaStop() {
		
		btnstop.setEnabled(false);
	}
	
	
	
	public void noLink() {
		
		JOptionPane opzJOptionPane = new JOptionPane();
	 opzJOptionPane.showConfirmDialog(this, "Nessun link inserito","Avviso",opzJOptionPane.WARNING_MESSAGE);
		
	}
	
	public JTextField getLink() {
		
		return textLink;
	}
}
