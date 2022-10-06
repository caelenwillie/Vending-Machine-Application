package com.techelevator;

import com.techelevator.view.Menu;

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
	int balance = 0;


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
				for (int i =0; i < importItems().size(); i++) {
					System.out.println(importItems().get(i).getCode() + " " + importItems().get(i).getName() + " " + importItems().get(i).getPrice() + " " + importItems().get(i).getCategory() + " (" + importItems().get(i).getCount() + " still remaining)");
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println();
				System.out.println("Current money provided: $" + balance);
				System.out.println();
				menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						System.out.println("Test Working");
//					} else if () {
//
//					} else if () {
//
//					} else {
//
					}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you for using the Vend-o-matic-800");
				break;
			}
		}

	}

}

/*
					1.  Display Vending Machine Options


					2.  Give option to purchase an item
					3.  Insert Money
					4.  Check Balance

				 */