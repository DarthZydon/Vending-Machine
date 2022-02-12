package com.techelevator;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI{

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String PURCHASE_MENU_OPTION_DEPOSIT_MONEY = "Customer Makes Deposit";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Display Selected Product";
	private static final String PURCHASE_MENU_OPTION_END_TRANSACTION = "End Transaction";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_DEPOSIT_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_END_TRANSACTION };

	private Menu menu;
	private VendingMachine vendingMachine = new VendingMachine("vendingmachine.csv");


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
				Map<String, Product> workingInv = vendingMachine.getWorkingInventory().inventoryMap;
				for (Map.Entry<String, Product> entry : workingInv.entrySet()) {
					System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " + entry.getValue().getPrice());
				}

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				//TO DO : User should enter this value through scanner
				activeMenu = PURCHASE_MENU_OPTIONS;

			} else if (choice.equals(PURCHASE_MENU_OPTION_DEPOSIT_MONEY)) {
				String deposit = (String) menu.getChoiceFromOptions(DEPOSIT_MENU_OPTIONS);
				vendingMachine.feedMoney(deposit);

			} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
				vendingMachine

			} else if (choice.equals(PURCHASE_MENU_OPTION_END_TRANSACTION)) {
				vendingMachine.finishTransaction();
			}

//				Product product = null;
//				try {
//					product = vendingMachine.selectProduct(choice2);
//					System.out.println("You just bought " + product.getName());
//				} catch (VendExceptions e) {
//					System.out.println("You can't buy product " + e.getMessage());
//				}

			}
		}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		try {
			cli.vendingMachine.getWorkingInventory().load();
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't load the inventory " + e.getMessage());
		}
		cli.run();
	}
}
