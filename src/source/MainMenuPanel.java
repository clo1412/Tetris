package source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int CENTER_JLABEL = JLabel.CENTER;
	private static final String ORANGE_KID_FONT = "Orange Kid";
	private static final String AUDIO_FILE_PATH = "Sprites/TonariNoTotoro.wav";
	private static final Color YELLOW_COLOR = Color.YELLOW;
	private static final Color BLACK_COLOR = Color.BLACK;
	private static final int BOLD = Font.BOLD;
	JLabel title, upTitle, upUpTitle;
	JLabel play, exit, howToPlay;
	BufferedImage cube;
	BufferedImage img;
	static Clip clip;
	private String highscore = "0";
	private int currHighscore = 0;
	private int newHighscore = 0;

	private float h = (float) 0.53358333;
	private float s = (float) 0.5697;
	private float b = (float) 0.9569;

	@Override
	public void paint(Graphics g) {
		setBackground(Color.getHSBColor(h, s, b));
		super.paint(g);
		g.drawImage(img, 40, 320, null);
		g.drawImage(cube, 250, 30, 130, 130, null);
	}

	public MainMenuPanel() {
		setLayout(null);

		try {
			img = ImageIO.read(Board.class.getResource("/totoro.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			cube = ImageIO.read(Board.class.getResource("/cube.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}


		play = new JLabel("Play", CENTER_JLABEL);
		play.setBounds(60, 170, 500, 50);
		
		play.setFont(new Font(ORANGE_KID_FONT, BOLD, 36));
		play.setForeground(BLACK_COLOR);
		play.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				play.setForeground(BLACK_COLOR);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				play.setForeground(YELLOW_COLOR);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainMenuFrame.window.remove(MainMenuPanel.this);
				new WindowFrame();
			}
		});
		add(play);

		howToPlay = new JLabel("How To Play", CENTER_JLABEL);
		howToPlay.setBounds(60, 213, 500, 50);
		howToPlay.setFont(new Font(ORANGE_KID_FONT, BOLD, 36));
		howToPlay.setForeground(BLACK_COLOR);
		howToPlay.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				howToPlay.setForeground(BLACK_COLOR);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				howToPlay.setForeground(YELLOW_COLOR);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainMenuFrame.window.remove(MainMenuPanel.this);
				new HowToPlayFrame();
			}
		});
		add(howToPlay);

		exit = new JLabel("Exit", CENTER_JLABEL);
		exit.setBounds(60, 250, 500, 50);
		exit.setFont(new Font(ORANGE_KID_FONT, BOLD, 36));
		exit.setForeground(BLACK_COLOR);
		exit.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				exit.setForeground(BLACK_COLOR);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setForeground(YELLOW_COLOR);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);

			}
		});
		add(exit);

		try {
			clip = AudioSystem.getClip();
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(AUDIO_FILE_PATH));
			clip.open(stream);
			clip.start();
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
			e1.printStackTrace();
		}
	}

	public void setHighscore(int score) {
		newHighscore = score;
		if (newHighscore > currHighscore) {
			currHighscore = newHighscore;
			highscore = "" + currHighscore;
		}
	}
}
