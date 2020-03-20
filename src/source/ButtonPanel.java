package source;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonPanel extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnPlay = new JButton("PLAY");
	ImageIcon help = new ImageIcon("help.png");
	JButton btnHelp = new JButton("HELP");
	
	public ButtonPanel() {
		System.out.println("a");
		setLayout(new FlowLayout());
		initializeIcon();
		initializeButtonLocation();
		setButtonVisible();
		addButton();
		initializeButtonActionListener();
		setVisible(true);
	}

	private void initializeIcon() {
		try {
			ImageIO.read(Board.class.getResource("/icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addButton() {
		add(btnHelp);
		add(btnPlay);
	}

	private void initializeButtonActionListener() {
		btnHelp.addActionListener(this);
		btnPlay.addActionListener(this);
	}

	private void setButtonVisible() {
		btnHelp.setVisible(true);
		btnPlay.setVisible(true);
	}

	private void initializeButtonLocation() {
		btnPlay.setLocation(500, 200);
		btnHelp.setLocation(300, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPlay) {
			new WindowFrame();
		} else if (e.getSource() == btnHelp) {
			JOptionPane.showMessageDialog(this,
					"W/ ^ = rotate\nA/Arrow <- = Left" + "\nD/Arrow -> = Right\nShift = Change Brick");
		}
	}

}
