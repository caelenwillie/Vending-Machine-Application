package com.techelevator;

import com.techelevator.view.Menu;

import java.io.*;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;

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

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	Balance balance = new Balance();
	Scanner userInput = new Scanner(System.in);
	File purchaseLog = new File("Log.txt");
	DecimalFormat decimalFormat = new DecimalFormat("0.00");
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss a");


	public void run() {

	List<Item> currentItemsList = importItems();

		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				printItems(currentItemsList);
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println();
				System.out.println("Current Money Provided: $" + decimalFormat.format(balance.getBalance()));
				System.out.println();
				String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if (purchaseChoice == PURCHASE_MENU_OPTION_FEED_MONEY) {
					try {
						System.out.println("How much money would you like to input? ");
						double additionalFunds = userInput.nextDouble();
						balance.addToBalance(additionalFunds);
						System.out.println("Your current balance is: " + decimalFormat.format(balance.getBalance()));
						try(FileWriter logWriter = new FileWriter(purchaseLog, true)) {
							logWriter.append(dateFormat.format(LocalDateTime.now()) + " FEED MONEY:" + " $" + (decimalFormat.format(balance.getBalance() - additionalFunds)) + " $" + decimalFormat.format(balance.getBalance()) + "\n");
						} catch (IOException e) {
							System.out.println("Sorry there was an error.  Please try again.");
						}
					} catch (NumberFormatException e){
						System.out.println("Please enter a valid numerical amount");
					}
				} else if (purchaseChoice == PURCHASE_MENU_OPTION_SELECT_PRODUCT) {
					printItems(currentItemsList);
					System.out.println("Please enter the two digit code of the item you would like to order: ");
					String orderCode = userInput.next().toLowerCase();
					for (Item item : currentItemsList) {
							if (orderCode.equals(item.getCode().toLowerCase())) {
								if (balance.getBalance() >= item.getPrice() && Integer.parseInt(item.getCount()) > 0) {
									item.setCount("" + (Integer.parseInt(item.getCount())  - 1));
									balance.removeFromBalance(item.getPrice());
									System.out.println("Vending Selected Item: " + item.getName());
									System.out.println(item.getSound());
									System.out.println("Current Balance: " + decimalFormat.format(balance.getBalance()));
									try(FileWriter logWriter = new FileWriter(purchaseLog, true)) {
										logWriter.append(dateFormat.format(LocalDateTime.now()) + " " + item.getName() + " " + item.getCode() + " $" + decimalFormat.format(item.getPrice()) + " $" + decimalFormat.format(balance.getBalance()) + "\n");
									} catch (IOException e) {
										System.out.println("Sorry there was an error.  Please try again.");
									}
								} else if (Integer.parseInt(item.getCount()) == 0) {
									item.setCount("SOLD OUT");
									System.out.println("Sorry, this item is currently Sold-Out");
								} else if (balance.getBalance() < item.getPrice()) {
									System.out.println("Sorry, the price of this item is greater than the available balance.  Please enter more funds.");
								}
							}
						}

				} else if (purchaseChoice == PURCHASE_MENU_OPTION_FINISH_TRANSACTION) {
					System.out.println(balance.changeCalculator(balance.getBalance()));
					try(FileWriter logWriter = new FileWriter(purchaseLog, true)) {
						logWriter.append(dateFormat.format(LocalDateTime.now()) + " GIVE CHANGE:" + " $" + (decimalFormat.format(balance.getBalance())) + " $0.00\n");
					} catch (IOException e) {
						System.out.println("Sorry there was an error.  Please try again.");
					}
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you for using the Vendo-Matic-800!  Have a good day :)");
				break;
			}
		}

	}

}


