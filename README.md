package ba.bitcamp.week7.day4.snake;

import java.awt.Color;

public class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


}














package ba.bitcamp.week7.day4.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Snake extends JFrame {

	private static final long serialVersionUID = -8753185824210866132L;

	private JPanel p1 = new JPanel();
	private int length = 3;
	private Point[] points = new Point[length];
	private int fieldSize = 15;
	private JLabel[][] fields = new JLabel[fieldSize][fieldSize];
	private int x = 5;
	private int y = 5;
	private int deltaX = 1;
	private int deltaY = 0;
	private int foodX;
	private int foodY;

	public Snake() {
//		for (int i = 0; i < length; i++) {
//			points[i] = new Point(1, 1);
//		}
		
		add(p1);
		addKeyListener(new Key());
		p1.setLayout(new GridLayout(fieldSize, fieldSize));
		p1.setBorder(BorderFactory.createTitledBorder("Panel 1"));
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++) {
				fields[i][j] = new JLabel();
				fields[i][j].setBackground(Color.WHITE);
				fields[i][j].setOpaque(true);
				fields[i][j].setPreferredSize(new Dimension(10, 10));
				p1.add(fields[i][j]);
			}

		}
		generateFood();

		fields[x][y].setBackground(Color.GREEN);
		fields[x][y].setOpaque(true);

		setTitle("Snake Game");
		setSize(800, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Timer t = new Timer(400, new Action());
		t.start();

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				fields[y][x].setBackground(Color.WHITE);
				x += deltaX;
				y += deltaY;
				fields[y][x].setBackground(Color.GREEN);
				if (x == foodY && y == foodX) {
					addPoint(foodX,foodY);
					generateFood();
					resize(points);
				}
				
				p1.repaint();
			} catch (ArrayIndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(null, "Game Over");
				System.exit(0);
			}
		}
	}

	private class Key implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				deltaX = 0;
				deltaY = -1;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				deltaX = 0;
				deltaY = 1;
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				deltaX = -1;
				deltaY = 0;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				deltaX = 1;
				deltaY = 0;
			}

		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				deltaX = 0;
				deltaY = -1;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				deltaX = 0;
				deltaY = 1;
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				deltaX = -1;
				deltaY = 0;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				deltaX = 1;
				deltaY = 0;
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public void generateFood() {
		foodX = (int) (Math.random() * fieldSize);
		foodY = (int) (Math.random() * fieldSize);
		fields[foodX][foodY].setBackground(Color.RED);

	}
	

	public void addPoint(int foodX, int foodY) {

		for (int i = 0; i < length; i++) {
			points[i] = new Point(foodX, foodY);
		}
		if (length == points.length) {
			resize(points);
		}
	}

	public int getLength() {
		return length;
	}


	public void resize(Point[] points) {
		Point[] temp = new Point[points.length + 1];
		for (int i = 0; i < points.length; i++) {
			fields[points[i].getX()][points[i].getY()].setBackground(Color.GREEN);;
			temp[i] = points[i];
		}
		points = temp;
	}
	


	public static void main(String[] args) {
		new Snake();

	}
}
