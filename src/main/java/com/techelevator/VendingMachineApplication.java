package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineApplication {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private Menu menu;

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineApplication cli = new VendingMachineApplication(menu);
		cli.run();
	}

	public VendingMachineApplication(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				System.out.println();
				/*
					1.  Display Vending Machine Options
					2.  Give option to purchase an item
					3.  Insert Money
					4.  Check Balance

				 */
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
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