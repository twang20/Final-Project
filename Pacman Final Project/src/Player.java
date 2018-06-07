import java.awt.Point;
import java.util.ArrayList;

public class Player {

	private int xAxis;
	private int yAxis;
	private boolean isAlive;
	private ArrayList<Point> walls;

	public Player(int xAxis, int yAxis, String imagePath, boolean isAlive, ArrayList<Point> walls) {
		super();
		this.setAlive(isAlive);
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.walls = walls;
	}

	public int getxAxis() {
		return xAxis;
	}

	public void setxAxis(int xAxis) {
		if (xAxis < 0 || xAxis >= Level1.GAMEWIDTH) {
			return;
		}
		if (walls.contains(new Point(xAxis, yAxis)))
		{
			return;
		}
		this.xAxis = xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	public void setyAxis(int yAxis) {
		if (yAxis < 0 || yAxis >= Level1.GAMEWIDTH)
		{
			return;
		}
		System.out.println(walls);
		if (walls.contains(new Point(xAxis, yAxis)))
				{
					return;
				}
		this.yAxis = yAxis;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

}
