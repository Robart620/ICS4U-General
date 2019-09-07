package dayone.contactlist;

import java.util.Scanner;

public class AddressBookDriver {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		AddressBook contacts = new AddressBook();
		int result;

		while (true) {
			contacts.displayMenu();
			result = processComand(getCommand(in.nextLine()), contacts);

		}

	}

	private static int processComand(int id, AddressBook contacts) {
		if (id == 5) {
			System.out.println("That is an invalid command. Try again");
			return 0;
		} else if (id == 0) {
			if (contacts.getListSize() == 0) {
				System.out.println("There ain't nothin to show");
				return 0;
			} else {
				contacts.displayContactList();
				return 0;
			}
		} else if (id == 1) {
			Contact contact = new Contact();
			System.out.print("Please enter the first name of the new contact: ");
			contact.setFirstName(in.nextLine());
			System.out.println();
			System.out.print("Please enter the last name of the new contact: ");
			contact.setFirstName(in.nextLine());
			System.out.println();
			System.out.print("Please enter the phone number of the new contact: ");
			contact.setFirstName(in.nextLine());
			System.out.println();

			contacts.addContact(contact);
			return 0;
		} else if(id == 2) {
			System.out.println("Enter the last name of the person you're looking for: ");
			in.nextLine();
			System.out.println();
		}

		return 0;
	}

	private static int getCommand(String command) {
		command.toLowerCase().replaceAll(" ", "");
		try {
			if (command.equals("show"))
				return 0;
			if (command.equals("new"))
				return 1;
			if (command.equals("search"))
				return 2;
			if (command.equals("destroy"))
				return 3;
		} catch (Exception ex) {
		}
		return 5;
	}

}
