import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DFACheckBasic {
	public static void main(String[] args) {
		String inputFile = args[0];
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(inputFile));
			String line;
			while ((line = bfReader.readLine()) != null) {
				testLine(line);
			}
			bfReader.close();
		} catch (IOException e) {
			System.out.println("DFACheckBasic: the file " + inputFile + " could not be opened.");
		}
	}

	/*
	 * DFA States as Enumeration
	 */
	public enum State {
		A, B, C, D, E, F, G, H, I, J;
	}

	/*
	 * Process the String with the DFA.
	 */
	static void testLine(String line) {
		State currentState = State.A;
		char[] cArr = line.toCharArray();
		for (char c : cArr) {
			switch (currentState) {
			case A:
				if (c == '0') {
					currentState = State.B;
				} else if (c == '1') {
					currentState = State.C;
				}
				break;
			case B:
				if (c == '0') {
				} else if (c == '1') {
					currentState = State.E;
				}
				break;
			case C:
				if (c == '0') {
					currentState = State.D;
				} else if (c == '1') {
				}
				break;
			case D:
				if (c == '0') {
					currentState = State.B;
				} else if (c == '1') {
					currentState = State.G;
				}
				break;
			case E:
				if (c == '0') {
					currentState = State.F;
				} else if (c == '1') {
					currentState = State.C;
				}
				break;
			case F:
				if (c == '0') {
					currentState = State.B;
				} else if (c == '1') {
					currentState = State.I;
				}
				break;
			case G:
				if (c == '0') {
					currentState = State.H;
				} else if (c == '1') {
					currentState = State.C;
				}
				break;
			case H:
				if (c == '0') {
					currentState = State.B;
				} else if (c == '1') {
					currentState = State.J;
				}
				break;
			case I:
				if (c == '0') {
					currentState = State.J;
				} else if (c == '1') {
					currentState = State.C;
				}
				break;
			case J:
				// Once currentState is J, it can't be anything else.
				break;
			default:
				System.out.println("Current character has no valid state.");
			}
		}

		if (currentState != State.J) {
			System.out.println(line + " accepted");
		} else {
			System.out.println(line + " rejected");
		}
	}
}
