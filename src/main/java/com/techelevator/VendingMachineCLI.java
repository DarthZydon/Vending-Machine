package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI{

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;
	private VendingMachine vendingMachine = new VendingMachine("vendingmachine.csv");


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	private boolean getChoiceFromOptions() {
		return false;
	}

	public String run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				Map<String, Product> workingInv = vendingMachine.getWorkingInventory().inventoryMap;
				for(Map.Entry<String, Product> entry : workingInv.entrySet()) {
					System.out.println(entry.getKey() + " " + entry.getValue().getName());
				}
					

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				//TO DO : User should enter this value through scanner
				String choice2 = "A1";
				Product product = null;
				try {
					product = vendingMachine.selectProduct(choice2);
					System.out.println("You just bought " + product.getName());
				} catch (VendExceptions e) {
					System.out.println("You can't buy product " + e.getMessage());
				}


			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
