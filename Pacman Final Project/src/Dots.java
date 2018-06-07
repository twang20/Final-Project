import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Dots {
	ArrayList<Point> dots = new ArrayList<Point>();
	int size;
	int width;
	int height;
	int dWidth = 2;
	int dHeight = 2;

	public Dots(int size, int width, int height) {
		super();
		this.size = size;
		this.width = width;
		this.height = height;
		dots(width, height);
	}

	public ArrayList<Point> getDots() {
		return dots;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ArrayList<Point> dots(int width, int height) {
		for (int rows = 0; rows < Level1.GAMEWIDTH; rows++)
			for (int cols = 0; cols < Level1.GAMEWIDTH; cols++) {
				dots.add(new Point(cols, rows));
			}
		return dots;
	}
}
