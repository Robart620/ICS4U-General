package dayone.contactlist;

public class AddressBook {

	int numberOfContacts;
	Contact[] contactList;

	public AddressBook() {
	    contactList = new Contact[20]; //not my problem if it runs out of space.
		numberOfContacts = 0;
	}

	public int getListSize() {
		return numberOfContacts;
	}

	public void displayMenu() {
		System.out.println("You have " + numberOfContacts + " contacts saved.");
		System.out.println("You can: ");
		System.out.println("\tSee all contacts (type \"show\").");
		System.out.println("\tAdd new contact (type \"new\").");
		System.out.println("\tSearch for a contact (type \"search\").");
		System.out.println("\tSearch and remove a contact (type \"destroy\").");
		System.out.println();

	}

	public void displayContactList() {
		for (int i = 0; i < numberOfContacts; i++) {
			System.out.println(contactList[i].getFirstName() + " " + contactList[i].getLastName() + " - "
					+ contactList[i].getPhone());
		}
	}
	
	public void addContact(Contact contact) {
		contactList[numberOfContacts] = contact;
		numberOfContacts++;
	}
	
	public void destroyContact(Contact contact) {
		//TODO remove the selected contact
		numberOfContacts++;
	}
}
