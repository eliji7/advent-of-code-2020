import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day1 {

	public static ArrayList<Integer> nums = new ArrayList<Integer>();

	private static void readFileAndCopyToList() throws IOException {
		try {
			nums = new ArrayList<Integer>();
			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				nums.add(Integer.parseInt(line));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * <Part 1> returns the two numbers in input.txt that add up to sum returns null
	 * if no two numbers exist
	 */
	private static int[] findSumTwoNums(int sum) {
		for (int i = 0; i < nums.size() - 1; i++) {
			int numOne = nums.get(i);
			for (int j = i + 1; j < nums.size(); j++) {
				int numTwo = nums.get(j);
				if (numOne + numTwo == sum) {
					int[] sol = { numOne, numTwo };
					return sol;
				}
			}
		}
		return null;
	}

	/*
	 * <Part 2> returns the three numbers in input.txt that add up to sum returns
	 * null if no two numbers exist
	 */
	private static int[] findSumThreeNums(int sum) {
		for (int i = 0; i < nums.size() - 1; i++) {
			int numOne = nums.get(i);
			for (int j = i + 1; j < nums.size(); j++) {
				int numTwo = nums.get(j);
				for (int k = i + 2; k < nums.size(); k++) {
					int numThree = nums.get(k);
					if (numOne + numTwo + numThree == sum) {
						int[] sol = { numOne, numTwo, numThree };
						return sol;
					}
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			readFileAndCopyToList();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		int[] twoNums = findSumTwoNums(2020);
		System.out.println("The two numbers that sum 2020 are: " + twoNums[0] + ", " + twoNums[1]);
		System.out.println("Their product is: " + twoNums[0] * twoNums[1]);

		int[] threeNums = findSumThreeNums(2020);
		System.out.println(
				"The three numbers that sum 2020 are: " + threeNums[0] + ", " + threeNums[1] + ", " + threeNums[2]);
		System.out.println("Their product is: " + threeNums[0] * threeNums[1] * threeNums[2]);

	}
}
