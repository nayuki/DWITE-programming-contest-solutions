/* 
 * DWITE programming contest solutions
 * October 2008 - Problem 5: "Moving Stuff in Boxes"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */

import java.util.Arrays;


public final class dwite200810p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200810p5().run("DATA5.txt", "OUT5.txt");
	}
	
	
	protected void runOnce() {
		Item[] items = new Item[io.readIntLine()];
		int filled = 0;  // To compute a lower bound for the number of boxes
		for (int i = 0; i < items.length; i++) {
			char[][] lines = new char[5][];
			int j;
			for (j = 0; ; j++) {
				String line = io.readLine();
				if (line == null || line.equals(""))
					break;
				lines[j] = line.toCharArray();
				for (char c : lines[j]) {
					if (c == '#')
						filled++;
				}
			}
			items[i] = new Item(lines[0].length, j, Arrays.copyOf(lines, j));
		}
		
		for (int i = (filled + 24) / 25; i <= 10; i++) {  // Try an increasing number of boxes
			if (fitsInBoxes(items, 0, new boolean[i][5][5])) {
				io.println(i);
				return;
			}
		}
		throw new IllegalArgumentException();
	}
	
	
	private static boolean fitsInBoxes(Item[] items, int start, boolean[][][] boxCellsFilled) {
		if (start == items.length)
			return true;
		
		Item item = items[start];
		for (int i = 0; i < 4; i++) {  // For each rotational orientation
			for (int j = 0; j < boxCellsFilled.length; j++) {  // For each box
				for (int y = 1 - item.height; y < boxCellsFilled[j].length; y++) {  // For each y offset
					for (int x = 1 - item.width; x < boxCellsFilled[j][0].length; x++) {  // For each x offset
						if (item.fits(x, y, boxCellsFilled[j])) {
							item.put(x, y, boxCellsFilled[j]);
							if (fitsInBoxes(items, start + 1, boxCellsFilled))
								return true;
							item.unput(x, y, boxCellsFilled[j]);
						}
					}
				}
			}
			item.rotateClockwise();
		}
		return false;
	}
	
	
	
	private static final class Item {
		
		public int width;
		public int height;
		
		public char[][] cells;
		
		
		public Item(int width, int height, char[][] cells) {
			this.width = width;
			this.height = height;
			this.cells = cells;
		}
		
		
		public void rotateClockwise() {
			char[][] result = new char[width][height];
			for (int y = 0; y < width; y++) {
				for (int x = 0; x < height; x++)
					result[y][x] = cells[height - 1 - x][y];
			}
			cells = result;
			int temp = width;
			width = height;
			height = temp;
		}
		
		
		public boolean fits(int offX, int offY, boolean[][] box) {
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					if (cells[y][x] == '#') {
						int boxX = offX + x;
						int boxY = offY + y;
						if (boxY < 0 || boxY >= box.length || boxX < 0 || boxX >= box[boxY].length || box[boxY][boxX])
							return false;
					}
				}
			}
			return true;
		}
		
		
		public void put(int offX, int offY, boolean[][] box) {
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					if (cells[y][x] == '#') {
						int boxX = offX + x;
						int boxY = offY + y;
						if (boxY < 0 || boxY >= box.length || boxX < 0 || boxX >= box[boxY].length || box[boxY][boxX])
							throw new IllegalArgumentException();
						box[boxY][boxX] = true;
					}
				}
			}
		}
		
		
		public void unput(int offX, int offY, boolean[][] box) {
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					if (cells[y][x] == '#') {
						int boxX = offX + x;
						int boxY = offY + y;
						if (boxY < 0 || boxY >= box.length || boxX < 0 || boxX >= box[boxY].length || !box[boxY][boxX])
							throw new IllegalArgumentException();
						box[boxY][boxX] = false;
					}
				}
			}
		}
		
	}
	
}
