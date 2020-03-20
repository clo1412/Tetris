package source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.PositionController;
import controller.ScoreController;

public class Board extends JPanel implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage blocks, bg, frame2, gO;
	
	
	private int[][] board = new int[PositionController.GRIDHEIGHT][PositionController.GRIDWIDTH];
	

	private final Piece piece[] = new Piece[7];
	private CurrentPiece currentPiece;
	private NextPiece nextPiece;
	private HoldPiece holdPiece = null;
	private Timer timer;

	PositionController pos = new PositionController();
	private final int FPS = 60;
	private final int delay = 1000 / FPS;
	
	private boolean gameOver = false;
	private boolean shiftPressed = false;
	private boolean shiftPieceAvail = false;
	private boolean playerShifted = false;
	private boolean shifted = false;

	private float h = (float) 0.53358333;
	private float s = (float) 0.5697;
	private float b = (float) 0.9569;

	public Board() {
		setBackground(Color.getHSBColor(h, s, b));
		GlassPane.imageFeeder(bg, "/totoro.png");
		GlassPane.imageFeeder(gO, "/game_over.jpg");
		GlassPane.imageFeeder(frame2, "/totoroFrames.png");

		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = 0;
			}
		}
		
		GlassPane.imageFeeder(blocks, "/tetris_blocks_21.png");

		timer = new Timer(delay, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});

		timer.start();

		piece[0] = new Piece(blocks.getSubimage(0, 0, PositionController.BLOCKSIZE, PositionController.BLOCKSIZE), new int[][] { { 1, 1, 1, 1 } }, this, 1); // the
																														// stick

		piece[1] = new Piece(blocks.getSubimage(1 * PositionController.BLOCKSIZE, 0, PositionController.BLOCKSIZE, PositionController.BLOCKSIZE),
				new int[][] { { 1, 1, 0 }, { 0, 1, 1 } }, this, 2); // the dog (left)

		piece[2] = new Piece(blocks.getSubimage(2 * PositionController.BLOCKSIZE, 0, PositionController.BLOCKSIZE, PositionController.BLOCKSIZE),
				new int[][] { { 0, 1, 1 }, { 1, 1, 0 } }, this, 3); // the dog (right)

		piece[3] = new Piece(blocks.getSubimage(3 * PositionController.BLOCKSIZE, 0, PositionController.BLOCKSIZE, PositionController.BLOCKSIZE),
				new int[][] { { 1, 0, 0 }, { 1, 1, 1 } }, this, 4); // the L (left)

		piece[4] = new Piece(blocks.getSubimage(4 * PositionController.BLOCKSIZE, 0, PositionController.BLOCKSIZE, PositionController.BLOCKSIZE),
				new int[][] { { 0, 0, 1 }, { 1, 1, 1 } }, this, 5); // the L (right)

		piece[5] = new Piece(blocks.getSubimage(5 * PositionController.BLOCKSIZE, 0, PositionController.BLOCKSIZE, PositionController.BLOCKSIZE),
				new int[][] { { 0, 1, 0 }, { 1, 1, 1 } }, this, 6); // the T

		piece[6] = new Piece(blocks.getSubimage(6 * PositionController.BLOCKSIZE, 0, PositionController.BLOCKSIZE, PositionController.BLOCKSIZE),
				new int[][] { { 1, 1 }, { 1, 1 } }, this, 7); // the Square

		PositionController.curIDX = Helper.randomNum(0, 6);
		currentPiece = new CurrentPiece(piece[PositionController.curIDX].getBlock(), piece[PositionController.curIDX].getCoords().clone(), this,
				piece[PositionController.curIDX].getColor()); // coba

		getNextPiece();
	}

	public void update() {
		if (gameOver) {
			timer.stop();
		}
		currentPiece.update();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bg, 40, 320, null);
		g.setColor(Color.getHSBColor((float) 0.472, (float) 0.5, (float) 0.76));
		g.setColor(new Color(255, 255, 255, 100));
		g.fillRect(pos.getIndentX(), pos.getIndentY() + 4 * PositionController.BLOCKSIZE, PositionController.GRIDWIDTH * PositionController.BLOCKSIZE, (PositionController.GRIDHEIGHT - 4) * PositionController.BLOCKSIZE);
		currentPiece.render(g);
		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board[0].length; col++)
				if (board[row][col] != 0)
					g.drawImage(blocks.getSubimage((board[row][col] - 1) * PositionController.BLOCKSIZE, 0, PositionController.BLOCKSIZE, PositionController.BLOCKSIZE),
							col * PositionController.BLOCKSIZE + pos.getIndentX(), row * PositionController.BLOCKSIZE + pos.getIndentY(), null);

		nextPiece.render(g);
		if (holdPiece != null && (shiftPieceAvail || playerShifted))
			holdPiece.render(g);

		g.drawImage(frame2, 390, 65, null);

		g.setFont(new Font("Agent Red", Font.BOLD, 20));
		g.setColor(Color.BLACK);
		g.drawString("LINES CLEARED: " + ScoreController.scoreString, 50, 40);

		g.setColor(Color.DARK_GRAY);
		for (int i = 0; i <= PositionController.GRIDHEIGHT - 4; i++) {
			g.drawLine(pos.getIndentX(), i * PositionController.BLOCKSIZE + (pos.getIndentY() + (PositionController.BLOCKSIZE * 4)), PositionController.GRIDWIDTH * PositionController.BLOCKSIZE + PositionController.BLOCKSIZE,
					i * PositionController.BLOCKSIZE + (pos.getIndentY() + (PositionController.BLOCKSIZE * 4)));
		}
		for (int i = 0; i <= PositionController.GRIDWIDTH; i++) {
			g.drawLine(i * PositionController.BLOCKSIZE + PositionController.BLOCKSIZE, (pos.getIndentY() + (PositionController.BLOCKSIZE * 4)), i * PositionController.BLOCKSIZE + PositionController.BLOCKSIZE,
					(PositionController.GRIDHEIGHT - 4) * PositionController.BLOCKSIZE + (pos.getIndentY() + (PositionController.BLOCKSIZE * 4)));
		}

		if (gameOver) {
			g.drawImage(gO, 10, 150, 280, 500, null);
		}
	}

	public void getNextPiece() {
		do {
			PositionController.nextIDX = Helper.randomNum(0, 6);
		} while (PositionController.nextIDX == PositionController.curIDX);

		nextPiece = new NextPiece(piece[PositionController.nextIDX].getBlock(), piece[PositionController.nextIDX].getCoords(), this,
				piece[PositionController.nextIDX].getColor());
	}

	public void getPiece() {
		if (shiftPressed && !shifted) {
			shifted = true;
			PositionController.curIDX = currentPiece.getColor() - 1;
			if (PositionController.curIDX == PositionController.holdIDX)
				currentPiece.setcY(pos.getIndentY() + 4 * PositionController.BLOCKSIZE - currentPiece.getCoords().length * PositionController.BLOCKSIZE);
			else {
				int temp = PositionController.holdIDX;
				PositionController.holdIDX = PositionController.curIDX;
				holdPiece = new HoldPiece(piece[PositionController.holdIDX].getBlock(), piece[PositionController.holdIDX].getCoords(), this,
						piece[PositionController.holdIDX].getColor());

				if (shiftPieceAvail) {
					PositionController.curIDX = temp;
					currentPiece = new CurrentPiece(piece[PositionController.curIDX].getBlock(), piece[PositionController.curIDX].getCoords(), this,
							piece[PositionController.curIDX].getColor());
					PositionController.holdIDX = holdPiece.getColor() - 1;
				} else if (!shiftPieceAvail) {
					PositionController.curIDX = nextPiece.getColor() - 1;
					currentPiece = new CurrentPiece(piece[PositionController.nextIDX].getBlock(), piece[PositionController.nextIDX].getCoords(), this,
							piece[PositionController.nextIDX].getColor());

					getNextPiece();
				}
				holdPiece.render(getGraphics());
			}
			shiftPieceAvail = true;
			shiftPressed = false;
		} else if (!shiftPressed) {
			shifted = false;
			currentPiece = new CurrentPiece(piece[PositionController.nextIDX].getBlock(), piece[PositionController.nextIDX].getCoords(), this,
					piece[PositionController.nextIDX].getColor());
			getNextPiece();
		}

		for (int i = 0; i < PositionController.GRIDWIDTH; i++)
			if (board[3][i] != 0) {
				gameOver = true;
				break;
			}
	}
	
	public int[][] getBoard() {
		return board;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			currentPiece.rotate();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			currentPiece.speedDown();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			currentPiece.setdX(-PositionController.BLOCKSIZE);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			currentPiece.setdX(PositionController.BLOCKSIZE);
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			if (!shifted) {
				shiftPressed = true;
			} else {
				playerShifted = true;
				shifted = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (gameOver) {
				MainMenuPanel.clip.stop();
				new MainMenuFrame();

			} else
				currentPiece.placeDown();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			currentPiece.normalSpeed();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean isShiftPressed() {
		return shiftPressed;
	}

	public Piece getHoldPiece() {
		return holdPiece;
	}

	

}
