package com.techelevator;

import com.techelevator.view.Menu;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	private Scanner in = new Scanner(System.in);

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit Main Menu";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};


	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Deposit Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_END_TRANSACTION = "End Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_END_TRANSACTION};


	private Menu menu;

//	private VendingMachine vendingMachine = new VendingMachine("vendingmachine.csv");

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

//	private boolean getChoiceFromOptions() {
//		return false;
//	}

	private void showProducts(Inventory inventory) throws FileNotFoundException {
		Map<String, Product> productMap = inventory.getInventory();
		for (Map.Entry<String, Product> entry : productMap.entrySet()) {
			Product value = entry.getValue();
			System.out.println(entry.getKey() + " " + value.getName() + " " + (value.getPrice()) + " " + value.getCount());
		}
	}

	public void run() throws FileNotFoundException {
		VendingMachine vm = new VendingMachine();
		Inventory inventory = vm.getInventory();
		inventory.load();

		String[] activeMenu = MAIN_MENU_OPTIONS;

		boolean run = true;

		while (run) {
			String choice = (String) menu.getChoiceFromOptions(activeMenu);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				showProducts(inventory);
				// display vending machine items
//				Map<String, Product> workingInv = vendingMachine.getInventory().inventory;
//				for (Map.Entry<String, Product> entry : workingInv.entrySet()) {
//					System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " + entry.getValue().getPrice());
//				}

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// deposit money
				// select product to purchase
				// end transaction
				activeMenu = PURCHASE_MENU_OPTIONS;

//			} else if (choice.equals(PURCHASE_MENU_OPTION_DEPOSIT_MONEY)) {
//				vendingMachine.feedMoney();


			} else if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				System.out.println("Deposit Money in Whole Dollar Amounts");
				String deposit = in.nextLine();
				vm.feedMoney(Integer.parseInt(deposit));
				if (vm.getCustomerBalance() == 0) {
					System.out.println("Must Deposit Money Before Making Selection");
				} else if (vm.getCustomerBalance() > 0) {
					System.out.println("Current Balance: " + vm.getCustomerBalance() / 100.0);
				}

			} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
				showProducts(inventory);
				System.out.println("");
				System.out.print("Enter Product ID: ");
				String slotID = in.nextLine();
				try {
					Product product = vm.selectProduct(slotID);
					System.out.println("Thanks for your Purchase of: " + product.getName() + " " + product.getPrice() + " " + vm.getCustomerBalance());
					if (product.getCategory().equalsIgnoreCase("chips")) {
						System.out.println("Crunch, Crunch, Yum!");
					} else if (product.getCategory().equalsIgnoreCase("candy")) {
						System.out.println("Munch, Munch, Yum!");
					} else if (product.getCategory().equalsIgnoreCase("drink")) {
						System.out.println("Glug, Glug, Yum!");
					} else if (product.getCategory().equalsIgnoreCase("gum")) {
						System.out.println("Chew, Chew, Yum!");
					}
				} catch (VendExceptions vendExceptions) {
					System.out.println("Sale Failed, Please Add More Money and Try Again");
				}
			} else if (choice.equals(PURCHASE_MENU_OPTION_END_TRANSACTION)) {
				int change = vm.finishTransaction();
				System.out.println("Change Due: " + change / 100.0);
				activeMenu = MAIN_MENU_OPTIONS;

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				// vendingMachine.selectProduct(getChoiceFromOptions());
				System.out.println("Thanks for Viewing Our Products");
				run = false;
			}

		}
	}
			public static void main(String[] args) throws FileNotFoundException {
				Menu menu = new Menu(System.in, System.out);
				VendingMachineCLI cli = new VendingMachineCLI(menu);
//				try {
//					cli.vendingMachine.getInventory().load();
//				} catch (FileNotFoundException e) {
//					System.out.println("Couldn't load the inventory " + e.getMessage());
//				}
				cli.run();
			}
		}





//
//			} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
//				vendingMachine.selectProduct()
//
//			} else if (choice.equals(PURCHASE_MENU_OPTION_END_TRANSACTION)) {
//				vendingMachine.finishTransaction();

//				Product product = null;
//				try {
//					product = vendingMachine.selectProduct(choice2);
//					System.out.println("You just bought " + product.getName());
//				} catch (VendExceptions e) {
//					System.out.println("You can't buy product " + e.getMessage());
//				}

