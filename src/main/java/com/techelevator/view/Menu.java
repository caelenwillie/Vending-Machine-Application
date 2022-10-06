package com.techelevator.view;

import java.io.*;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	//Balance Methods
//	double balance = 0.00;
//
//	try (Scanner fileScanner = new Scanner(System.in)) {
//
//	} catch (IOException e) {
//
//	}
//
//	public double addToBalance() {
//
//		balance += input;
//	}
//
//	try ()) {
//
//	} catch (IOException e) {
//
//	if (balance >= item.getPrice) {
//
//		public double updateBalance() {
//			if () {
//				balance -= item.getPrice()
//			}
//		}
//	} else {
//		System.out.println("No enough funds");
//	}
//
//		try (Scanner fileScanner = new Scanner(sourceFile);
//			 PrintWriter writer = new PrintWriter(destinationFile)
//		) {
//			while (fileScanner.hasNextLine()) {
//				String line = fileScanner.nextLine();
//				writer.println(line.replace(searchWord, replacementWord));
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("File Not Found");
//		}





}