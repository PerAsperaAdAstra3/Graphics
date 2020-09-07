package GraphicsElements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GridPanel extends JPanel {

	private int columnCount = 60;
	private int rowCount = 60;
	private List<ColorRectangle> cells;

	public GridPanel() {
		cells = new ArrayList<ColorRectangle>(columnCount * rowCount);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1000, 1000);
	}

	@Override
	public void invalidate() {
		cells.clear();
		super.invalidate();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();

		int width = getWidth();
		int height = getHeight();

		int cellWidth = width / columnCount;
		int cellHeight = height / rowCount;

		int xOffset = (width - (columnCount * cellWidth)) / 2;
		int yOffset = (height - (rowCount * cellHeight)) / 2;

		if (cells.isEmpty()) {
			for (int row = 0; row < rowCount; row++) {
				for (int col = 0; col < columnCount; col++) {
					ColorRectangle cell = new ColorRectangle();
					cell.setBounds(xOffset + (col * cellWidth), yOffset + (row * cellHeight), cellWidth, cellHeight);
					cells.add(cell);
				}
			}
		}

		int index = columnCount / 2 - 2;
		ColorRectangle cell = cells.get(index);
		cell.setColor(Color.BLUE);
		g2d.setColor(Color.BLUE);
		g2d.fill(cell);

		index = columnCount / 2 - 1;
		cell = cells.get(index);
		cell.setColor(Color.RED);
		g2d.setColor(Color.RED);
		g2d.fill(cell);

		index = columnCount / 2;
		cell = cells.get(index);
		cell.setColor(Color.PINK);
		g2d.setColor(Color.PINK);
		g2d.fill(cell);

		index = columnCount / 2 + 1;
		cell = cells.get(index);
		cell.setColor(Color.ORANGE);
		g2d.setColor(Color.ORANGE);
		g2d.fill(cell);

		index = 0;
		List<Color> colorList = new ArrayList<Color>();
		colorList.add(Color.BLUE);
		colorList.add(Color.RED);
		colorList.add(Color.PINK);
		colorList.add(Color.ORANGE);

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				index = j + (i * columnCount);
				columnCount = 60;
				if (columnCount / 2 - 2 - i < j && j < columnCount / 2 + 1 + i) {
					boolean shouldBreak = true;
					while (shouldBreak) {
						int randomNumber = (int) (Math.random() * (4 - 0) + 0);
						if (((colorList.get(randomNumber) == cells.get(index - 60).getColor()) // Control/restrictions for generating next row.
								|| (colorList.get(randomNumber) == cells.get(index - 59).getColor()))
								|| (cells.get(index - 60).getColor() == Color.GRAY) || (cells.get(index - 60)
										.getColor() == null)/*
															 * && (colorList.get(randomNumber) != cells.get(index -
															 * 59).getColor()) /*&& (colorList.get(randomNumber) !=
															 * cells.get(index - 61).getColor())
															 */) {
							cell = cells.get(index);
							cell.setColor(colorList.get(randomNumber));
							g2d.setColor(colorList.get(randomNumber));
							g2d.fill(cell);
							shouldBreak = false;
						}
					}
				}
			}
		}

		g2d.setColor(Color.GRAY);
		for (Rectangle cell1 : cells) {
			g2d.draw(cell1);
		}

		g2d.dispose();
		System.out.println("END");
	}
}
