
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
	private JLabel[][] fields = new JLabel[10][10];
	private int x = 5;
	private int y = 5;
	private int deltaX = 1;
	private int deltaY = 0;

	public Snake() {

		add(p1);
		addKeyListener(new Key());
		p1.setLayout(new GridLayout(10, 10));
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

		fields[x][y].setBackground(Color.BLACK);
		fields[x][y].setOpaque(true);

		setTitle("Snake Game");
		setSize(800, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Timer t = new Timer(1000, new Action());
		t.start();

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				fields[y][x].setBackground(Color.WHITE);
				x += deltaX;
				y += deltaY;
				fields[y][x].setBackground(Color.BLACK);
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

	public class SnakeLabel {

		int[] snake = new int[3];
		int x;
		int y;

		public SnakeLabel(int x, int y) {
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

	public static void main(String[] args) {
		new Snake();

	}

}
