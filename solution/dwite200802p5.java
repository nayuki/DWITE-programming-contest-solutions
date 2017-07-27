/* 
 * DWITE programming contest solutions
 * February 2008 - Problem 5: "Tetris!"
 * Copyright (c) Project Nayuki. All rights reserved.
 * 
 * https://www.nayuki.io/page/dwite-programming-contest-solutions
 * https://github.com/nayuki/DWITE-programming-contest-solutions
 */


public final class dwite200802p5 extends DwiteSolution {
	
	public static void main(String[] args) {
		new dwite200802p5().run("DATA5.txt", "OUT5.txt");
	}
	
	
	protected void runOnce() {
		char[][] piece = readGrid(io, 4, 4);
		char[][] board = readGrid(io, 10, 6);
		int max = 0;
		for (int i = 0; i < 4; i++) {  // For each orientation (rotation)
			for (int x = 1 - piece[0].length; x < board[0].length; x++) {  // For each horizontal position
				int y = 1 - piece.length;
				while (isPositionLegal(piece, x, y + 1, board))  // Drop the piece downward
					y++;
				if (isPositionLegal(piece, x, y, board))
					max = Math.max(calculateScoredLines(piece, x, y, board), max);
			}
			piece = rotateClockwise(piece);
		}
		io.println(max);
	}
	
	
	private static int calculateScoredLines(char[][] piece, int offX, int offY, char[][] board) {
		int count = 0;
		for (int y = 0; y < board.length; y++) {  // Scan each line for completeness
			boolean complete = true;
			for (int x = 0; x < board[y].length; x++) {
				int pieceX = x - offX;
				int pieceY = y - offY;
				complete &= board[y][x] == '#' ||
					0 <= pieceY && pieceY < piece.length &&
					0 <= pieceX && pieceX < piece[pieceY].length &&
					piece[pieceY][pieceX] == '#';
			}
			if (complete)
				count++;
		}
		return count;
	}
	
	
	private static boolean isPositionLegal(char[][] piece, int offX, int offY, char[][] board) {
		for (int y = 0; y < piece.length; y++) {
			for (int x = 0; x < piece[y].length; x++) {
				if (piece[y][x] == '#') {
					int boardX = offX + x;
					int boardY = offY + y;
					// Note: It's okay for the piece to stick out on the top side
					if (boardY >= 0 && (boardY >= board.length || boardX < 0 || boardX >= board[boardY].length || board[boardY][boardX] == '#'))
						return false;
				}
			}
		}
		return true;
	}
	
	
	private static char[][] rotateClockwise(char[][] grid) {
		char[][] result = new char[grid[0].length][grid.length];
		for (int y = 0; y < result.length; y++) {
			for (int x = 0; x < result[y].length; x++)
				result[y][x] = grid[grid.length - 1 - x][y];
		}
		return result;
	}
	
	
	private static char[][] readGrid(DwiteIo io, int width, int height) {
		char[][] result = new char[height][];
		for (int i = 0; i < height; i++) {
			String line = io.readLine();
			if (line.length() != width)
				throw new IllegalArgumentException();
			result[i] = line.toCharArray();
		}
		return result;
	}
	
}
