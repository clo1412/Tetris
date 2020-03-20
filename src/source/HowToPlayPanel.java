package source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowToPlayPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int IMAGE_X = 150;
	private static final int IMAGE_SIZE = 60;
	private static final int LBL_HEIGHT = 50;
	private static final int LBL_WIDTH = 500;
	private static final Color YELLOW_COLOR = Color.YELLOW;
	private static final int FONT_SIZE = 20;
	private static final Color BLACK_COLOR = Color.BLACK;
	private static final Color RED_COLOR = Color.RED;
	private static final Color BLUE_COLOR = Color.BLUE;
	private static final String ORANGE_KID_FONT = "Orange Kid";
	private static final int BOLD = Font.BOLD;
	private static final int JLABEL_CENTER = JLabel.CENTER;
	BufferedImage up;
	BufferedImage down;
	BufferedImage right;
	BufferedImage left;
	BufferedImage shift;
	BufferedImage space;
	BufferedImage icon;
	BufferedImage icon1;
	int stat = 0;
	JLabel lbl_title, lbl_up, lbl_down, lbl_right, lbl_left, lbl_shift, lbl_space, lbl_space2, back;

	private float h = (float) 0.53358333;
	private float s = (float) 0.5697;
	private float b = (float) 0.9569;

	@Override
	public void paint(Graphics g) {
		setBackground(Color.getHSBColor(h, s, b));
		super.paint(g);
		g.drawImage(icon, 310, 400, 500, 740, null);
		g.drawImage(icon1, -170, 400, 500, 740, null);
		if (stat == 1)
			g.drawImage(up, 150, 100, IMAGE_SIZE, IMAGE_SIZE, null);
		if (stat == 2)
			g.drawImage(down, IMAGE_X, 160, IMAGE_SIZE, IMAGE_SIZE, null);
		if (stat == 3)
			g.drawImage(left, IMAGE_X, 220, IMAGE_SIZE, IMAGE_SIZE, null);
		if (stat == 4) {
			g.drawImage(right, IMAGE_X, 280, IMAGE_SIZE, IMAGE_SIZE, null);
		}
		if (stat == 5) {
			g.drawImage(shift, IMAGE_X, 400, IMAGE_SIZE, IMAGE_SIZE, null);
		}
		if (stat == 6) {
			g.drawImage(space, IMAGE_X, 340, IMAGE_SIZE, IMAGE_SIZE, null);
		}
		if (stat == 7) {
			g.drawImage(space, IMAGE_X, 450, IMAGE_SIZE, IMAGE_SIZE, null);
		}
	}

	public HowToPlayPanel() {
		setLayout(null);
		try {
			icon = ImageIO.read(Board.class.getResource("/icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			icon1 = ImageIO.read(Board.class.getResource("/icon1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			shift = ImageIO.read(Board.class.getResource("/shift.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			space = ImageIO.read(Board.class.getResource("/space.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			up = ImageIO.read(Board.class.getResource("/up.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			down = ImageIO.read(Board.class.getResource("/down.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			left = ImageIO.read(Board.class.getResource("/left.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			right = ImageIO.read(Board.class.getResource("/right.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		lbl_title = new JLabel("HOW TO PLAY", JLABEL_CENTER);
		lbl_title.setBounds(100, 20, 500, 50);
		lbl_title.setFont(new Font(ORANGE_KID_FONT, BOLD, 26));
		lbl_title.setForeground(BLUE_COLOR);
		lbl_title.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl_title.setForeground(BLUE_COLOR);
				stat = 0;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_title.setForeground(RED_COLOR);
				stat = 1;

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		add(lbl_title);

		lbl_up = new JLabel("Rotate Brick", JLABEL_CENTER);
		lbl_up.setBounds(100, 100, LBL_WIDTH, LBL_HEIGHT);
		lbl_up.setFont(new Font(ORANGE_KID_FONT, BOLD, FONT_SIZE));
		lbl_up.setForeground(BLACK_COLOR);
		lbl_up.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl_up.setForeground(BLACK_COLOR);
				stat = 0;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_up.setForeground(RED_COLOR);
				stat = 1;

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		add(lbl_up);

		lbl_down = new JLabel("Soft Drop", JLABEL_CENTER);
		lbl_down.setBounds(100, 160, LBL_WIDTH, LBL_HEIGHT);
		lbl_down.setFont(new Font(ORANGE_KID_FONT, BOLD, FONT_SIZE));
		lbl_down.setForeground(BLACK_COLOR);
		lbl_down.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl_down.setForeground(BLACK_COLOR);
				stat = 0;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_down.setForeground(RED_COLOR);
				stat = 2;

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		add(lbl_down);

		lbl_left = new JLabel("Move To Left", JLABEL_CENTER);
		lbl_left.setBounds(100, 220, LBL_WIDTH, LBL_HEIGHT);
		lbl_left.setFont(new Font(ORANGE_KID_FONT, BOLD, FONT_SIZE));
		lbl_left.setForeground(BLACK_COLOR);
		lbl_left.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl_left.setForeground(BLACK_COLOR);
				stat = 0;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_left.setForeground(RED_COLOR);
				stat = 3;
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		add(lbl_left);

		lbl_right = new JLabel("Move To Right", JLABEL_CENTER);
		lbl_right.setBounds(100, 280, LBL_WIDTH, LBL_HEIGHT);
		lbl_right.setFont(new Font(ORANGE_KID_FONT, BOLD, FONT_SIZE));
		lbl_right.setForeground(BLACK_COLOR);
		lbl_right.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl_right.setForeground(BLACK_COLOR);
				stat = 0;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_right.setForeground(RED_COLOR);
				stat = 4;
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		add(lbl_right);

		lbl_shift = new JLabel("Change Brick", JLABEL_CENTER);
		lbl_shift.setBounds(100, 400, LBL_WIDTH, LBL_HEIGHT);
		lbl_shift.setFont(new Font(ORANGE_KID_FONT, BOLD, FONT_SIZE));
		lbl_shift.setForeground(BLACK_COLOR);
		lbl_shift.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl_shift.setForeground(BLACK_COLOR);
				stat = 0;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_shift.setForeground(RED_COLOR);
				stat = 5;
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		add(lbl_shift);

		lbl_space2 = new JLabel("Go To Main Menu After KO!", JLABEL_CENTER);
		lbl_space2.setBounds(100, 450, LBL_WIDTH, LBL_HEIGHT);
		lbl_space2.setFont(new Font(ORANGE_KID_FONT, BOLD, FONT_SIZE));
		lbl_space2.setForeground(BLACK_COLOR);
		lbl_space2.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl_space2.setForeground(BLACK_COLOR);
				stat = 0;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_space2.setForeground(RED_COLOR);
				stat = 7;
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		add(lbl_space2);

		lbl_space = new JLabel("Speed Down", JLABEL_CENTER);
		lbl_space.setBounds(100, 340, LBL_WIDTH, LBL_HEIGHT);
		lbl_space.setFont(new Font(ORANGE_KID_FONT, BOLD, FONT_SIZE));
		lbl_space.setForeground(BLACK_COLOR);
		lbl_space.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl_space.setForeground(BLACK_COLOR);
				stat = 0;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_space.setForeground(RED_COLOR);
				stat = 6;
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		add(lbl_space);

		back = new JLabel("BACK TO MAIN MENU", JLABEL_CENTER);
		back.setBounds(70, 570, LBL_WIDTH, LBL_HEIGHT);
		back.setFont(new Font(ORANGE_KID_FONT, BOLD, FONT_SIZE));
		back.setForeground(BLUE_COLOR);
		back.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				back.setForeground(BLUE_COLOR);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				back.setForeground(YELLOW_COLOR);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				HowToPlayFrame.window.dispose();
				MainMenuPanel.clip.stop();
				new MainMenuFrame();
			}
		});
		add(back);

	}

}
