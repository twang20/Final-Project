import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Walls {
	ArrayList<Point> walls = new ArrayList<Point>();

	public Walls() {
		Random random = new Random();
		for (int rows = 4; rows < Level1.GAMEWIDTH; rows++)
			for (int cols = 4; cols < Level1.GAMEWIDTH; cols++) {
				int num = random.nextInt(10);
				if (num == 0)
					walls.add(new Point(cols, rows));
			}
		//walls();
	}

	public ArrayList<Point> walls() {
		return walls;
	}
}
