import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Level1 extends JPanel implements KeyListener {

	public static final int GAMEWIDTH = 15;
	private JFrame window = new JFrame();
	private ImageIcon background = new ImageIcon("background.jpg");
	private Player player;
	private Dots dot;
	private Walls wall;
	private int speed = 1;
	private JButton[][] myPanels;
	private String imagePath = "Pacman.jpg";
	private ImageIcon img = new ImageIcon(imagePath);
	private String dotPath = "dot.jpg";
	private ImageIcon dotImage = new ImageIcon(dotPath);
	private int points = 0;

	public Level1() {
		this.setFocusable(true);
		this.addKeyListener(this);
		window.add(this);
		window.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		window.setState(Frame.NORMAL);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		dot = new Dots(300, Toolkit.getDefaultToolkit().getScreenSize().width,
				Toolkit.getDefaultToolkit().getScreenSize().height);
		wall = new Walls();
		player = new Player(0, 0, "Pacman.jpg", true, wall.walls());
		myPanels = new JButton[GAMEWIDTH][GAMEWIDTH];
		this.setLayout(new GridLayout(GAMEWIDTH, GAMEWIDTH));
		for (int rows = 0; rows < myPanels.length; rows++)
			for (int cols = 0; cols < myPanels[0].length; cols++) {
				myPanels[rows][cols] = new JButton();
				myPanels[rows][cols].setBackground(Color.GRAY);
				this.add(myPanels[rows][cols]);
				myPanels[rows][cols].setBorder(null);
				if (wall.walls().contains(new Point(cols, rows))) {
					myPanels[rows][cols].setBackground(Color.RED);
				} else {
					myPanels[rows][cols].setIcon(dotImage);
				}
			}
		myPanels[0][0].setIcon(img);

	}

	// public void paint(Graphics g) {
	// g.drawImage(background.getImage(), 0, 0, null);
	// player.drawPlayer(g);
	// dot.drawDots(g);
	// }

	public void eat() {
		for (int i = 0; i < dot.getDots().size(); i++) {
			if (player.getxAxis() == dot.getDots().get(i).getX() && player.getyAxis() == dot.getDots().get(i).getY()) {
				dot.getDots().remove(i);
				points++;
				System.out.println(points);
				break;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		Point playerPos = new Point(player.getxAxis(), player.getyAxis());
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setxAxis(player.getxAxis() + speed);
		} else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setxAxis(player.getxAxis() - speed);
		} else if (ke.getKeyCode() == KeyEvent.VK_UP) {
			player.setyAxis(player.getyAxis() - speed);
		} else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			player.setyAxis(player.getyAxis() + speed);
		}
		myPanels[(int) playerPos.getY()][(int) playerPos.getX()].setIcon(null);
		myPanels[player.getyAxis()][player.getxAxis()].setIcon(img);
		eat();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
