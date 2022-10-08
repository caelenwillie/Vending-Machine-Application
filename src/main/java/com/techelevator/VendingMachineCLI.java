package com.techelevator;

import com.techelevator.view.Menu;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Date;
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

	Balance balance = new Balance();

	private Menu menu;

	Scanner userInput = new Scanner(System.in);

	File purchaseLog = new File("Log.txt");

//	Date date = new Date();
//	Time time = new Time();



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
			String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println(printItems());
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println();
				System.out.println("Current Money Provided: $" + balance.getBalance());
				System.out.println();
				String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if (purchaseChoice == PURCHASE_MENU_OPTION_FEED_MONEY) {
					try {
						System.out.println("How much money would you like to input? ");
						double additionalFunds = userInput.nextDouble();
						balance.addToBalance(additionalFunds);
						System.out.println("Your current balance is: " + balance.getBalance());
					} catch (NumberFormatException e){
						System.out.println("Please enter a valid numerical amount");
					}
				} else if (purchaseChoice == PURCHASE_MENU_OPTION_SELECT_PRODUCT) {
					System.out.println(printItems());
					System.out.println("Please enter the two digit code of the item you would like to order: ");
					String orderCode = userInput.nextLine();
					for (Item item : importItems()) {
						try (PrintWriter logWriter = new PrintWriter(purchaseLog)) {
							if (orderCode.equals(item.getCode())) {
								if (balance.getBalance() >= item.getPrice() && item.getCount() > 0) {
									item.setCount(item.getCount() - 1);
									System.out.println(item.getCount());
									balance.removeFromBalance(item.getPrice());
									System.out.println("Vending Selected Item: " + item.getName());
									System.out.println(item.getSound());
									System.out.println("Current Balance: " + balance.getBalance());
									logWriter.println("Test Print");
								} else if (item.getCount() == 0) {
									System.out.println("Sorry, item is currently Sold-Out");
								} else if (balance.getBalance() < item.getPrice()) {
									System.out.println("Sorry, the price of this item is greater than the available balance.  Please enter more funds.");
								}
							}
							} catch (Exception e){
								System.out.println("Sorry there was an Error.  Please try again.");
							}
						}

				} else if (purchaseChoice == PURCHASE_MENU_OPTION_FINISH_TRANSACTION) {
					System.out.println(balance.changeCalculator(balance.getBalance()));
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you for using the Vendo-Matic-800!  Have a good day :)");
				break;
			}
		}

	}

}


