package daytwo.linkedlistcontactlist;

import java.util.LinkedList;

public class AddressBook {

	int numberOfContacts;
	LinkedList<Contact> contactList;

	public AddressBook() {
	    contactList = new LinkedList<>();
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
			System.out.println(contactList.get(i).toString());
		}
	}
	
	public void addContact(Contact contact) {
		contactList.add(contact);
		numberOfContacts++;
	}
	
	public void destroy(String lastName) {
		for(int i = 0; i < numberOfContacts; i++) {
			if(contactList.get(i).getLastName().equals(lastName)) {
				contactList.remove(contactList.get(i));
				if(i != numberOfContacts) {
					contactList.add(i, contactList.getLast());
					contactList.removeLast();
				}
				numberOfContacts--;
				System.out.println(lastName + " who?");
				return;
			}
				
		}
		System.out.println("You never had a contact named " + lastName);
		
		
	}

	public String find(String lastName) {
		for(int i = 0; i < numberOfContacts; i++) {
			if(lastName.equals(contactList.get(i).getLastName()))
				return contactList.get(i).toString();
		}
		return "You don't have any contacts with last name " + lastName;
		
	}
}
