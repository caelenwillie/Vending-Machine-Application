package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Scanner;

public class VendingMachineCLI extends VendingMachine {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	private Menu menu;
	double balance = 0.0;
	Scanner userInput = new Scanner(System.in);

	public double addToBalance (double additionalFunds) {
		balance += additionalFunds;
		return balance;
	}


	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println(printItems());
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println();
				System.out.println("Your current is: $" + balance);
				System.out.println();
				String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if (purchaseChoice == PURCHASE_MENU_OPTION_FEED_MONEY) {
					try {
						System.out.println("How much money would you like to input? ");
						String additionalFundsString = userInput.nextLine();
						double additionalFunds = Double.parseDouble(additionalFundsString);
						addToBalance(additionalFunds);
					} catch (NumberFormatException e){
						System.out.println("Please enter a valid numerical amount");
					}
				} else if (purchaseChoice == PURCHASE_MENU_OPTION_SELECT_PRODUCT) {
					System.out.println("Test");
				} else if (purchaseChoice == PURCHASE_MENU_OPTION_FINISH_TRANSACTION) {
					System.out.println("Test");
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you for using the Vend-o-matic-800!  Have a good day :)");
				break;
			}
		}

	}

}


