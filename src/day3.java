import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class day3 {

	/*
	 * <Part 1> returns the number of trees you land on by moving right 3, down 1
	 */
	private static int countTrees3Right1Down() throws IOException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("day-3-input.txt"));
			int trees = 0;
			int col = 0;
			while (true) {
				String line = reader.readLine();
				if (line == null)
					break;
				// always start on an open square, so do not need to worry about first check
				// counting an extra tree
				if (line.charAt(col) == '#')
					trees++;
				for (int i = 0; i < 3; i++) {
					col = (col + 1) % line.length();
				}
			}
			return trees;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/*
	 * <Part 2> returns the number of trees you land on by moving right and down the
	 * specified amount
	 */
	private static int countTrees(int right, int down) throws IOException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("day-3-input.txt"));
			int trees = 0;
			int col = 0;
			int row = 0;
			while (true) {
				String line = reader.readLine();
				if (line == null)
					break;
				if (row % down == 0) {
					// always start on an open square, so do not need to worry about first check
					// counting an extra tree
					if (line.charAt(col) == '#')
						trees++;
					for (int i = 0; i < right; i++) {
						col = (col + 1) % line.length();
					}
				}
				row++;
			}
			return trees;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void main(String[] args) {
		try {
			System.out.println("Number of trees encountred moving right 3 down 1: " + countTrees3Right1Down());
			// requires long cast because product exceeds max int value
			System.out.println("Product of specified traversals: " + (countTrees(1, 1) * countTrees(3, 1)
					* countTrees(5, 1) * countTrees(7, 1) * (long) countTrees(1, 2)));
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
