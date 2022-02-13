package com.techelevator;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI{



	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit Main Menu";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_END_TRANSACTION = "End Transaction";
	private static final String PURCHASE_MENU_OPTION_DEPOSIT_MONEY = "Deposit Money";

	private static final String DEPOSIT_MENU_OPTIONS_DOLLAR_AMOUNT = "Please Deposit $1, $5, or $10";
	private static final String DEPOSIT_MENU_OPTIONS_EXIT = "Exit from Deposit Menu";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_DEPOSIT_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_END_TRANSACTION };
	private static final String[] DEPOSIT_MENU_OPTIONS = { DEPOSIT_MENU_OPTIONS_DOLLAR_AMOUNT, DEPOSIT_MENU_OPTIONS_EXIT };


	private Menu menu;
//	private VendingMachine vendingMachine = new VendingMachine("vendingmachine.csv");


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	private boolean getChoiceFromOptions() {
		return false;
	}

	String[] activeMenu = MAIN_MENU_OPTIONS;

	public String run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(activeMenu);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				Map<String, Product> workingInv = vendingMachine.getInventory().inventory;
				for (Map.Entry<String, Product> entry : workingInv.entrySet()) {
					System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " + entry.getValue().getPrice());
				}

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// deposit money
				// select product to purchase
				// end transaction
				activeMenu = PURCHASE_MENU_OPTIONS;

//			} else if (choice.equals(PURCHASE_MENU_OPTION_DEPOSIT_MONEY)) {
//				vendingMachine.feedMoney();

			} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
					// vendingMachine.selectProduct(getChoiceFromOptions());
					System.out.println("select product code");

			} else if (choice.equals(PURCHASE_MENU_OPTION_END_TRANSACTION)) {
				activeMenu = MAIN_MENU_OPTIONS;
				}
//
//			} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
//				vendingMachine.selectProduct()
//
//			} else if (choice.equals(PURCHASE_MENU_OPTION_END_TRANSACTION)) {
//				vendingMachine.finishTransaction();
			}

//				Product product = null;
//				try {
//					product = vendingMachine.selectProduct(choice2);
//					System.out.println("You just bought " + product.getName());
//				} catch (VendExceptions e) {
//					System.out.println("You can't buy product " + e.getMessage());
//				}

			}


	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		try {
			cli.vendingMachine.getInventory().load();
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't load the inventory " + e.getMessage());
		}
		cli.run();
	}
}
