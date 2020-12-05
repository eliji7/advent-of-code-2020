import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class day2 {

	/*
	 * <Part 1> returns the number of valid passwords in day-2-input.txt. A password
	 * is valid if the number of occurrences of the specified character is within
	 * the specified range
	 */
	private static int validPasswordsPart1() throws IOException {
		try {
			int validPass = 0;
			BufferedReader reader = new BufferedReader(new FileReader("day-2-input.txt"));
			while (true) {
				String line = reader.readLine();
				if (line == null)
					break;
				int min = Integer.parseInt(line.substring(0, line.indexOf('-')));
				int max = Integer.parseInt(line.substring(line.indexOf('-') + 1, line.indexOf(':') - 2));
				String pass = line.substring(line.indexOf(':') + 2);
				char requiredChar = line.charAt(line.indexOf(':') - 1);
				int charCounter = 0;

				for (int i = 0; i < pass.length(); i++) {
					if (pass.charAt(i) == requiredChar)
						charCounter++;
				}

				if (charCounter >= min && charCounter <= max)
					validPass++;
			}
			return validPass;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * <Part 2> returns the number of valid passwords in day-2-input.txt. A valid
	 * password contains the specified character at exactly one of the specified
	 * positions
	 */
	private static int validPasswordsPart2() throws IOException {
		try {
			int validPass = 0;
			BufferedReader reader = new BufferedReader(new FileReader("day-2-input.txt"));
			while (true) {
				String line = reader.readLine();
				if (line == null)
					break;
				int index1 = Integer.parseInt(line.substring(0, line.indexOf('-'))) - 1;
				int index2 = Integer.parseInt(line.substring(line.indexOf('-') + 1, line.indexOf(':') - 2)) - 1;
				String pass = line.substring(line.indexOf(':') + 2);
				char requiredChar = line.charAt(line.indexOf(':') - 1);

				if (pass.charAt(index1) == requiredChar ^ pass.charAt(index2) == requiredChar)
					validPass++;

			}
			return validPass;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println("Number of vlaid passwords (part1): " + validPasswordsPart1());
			System.out.println("Number of vlaid passwords (part2): " + validPasswordsPart2());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
