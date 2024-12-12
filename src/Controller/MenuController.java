package Controller;

import Materia.Models.Contact;
import View.ConsoleView;

public class MenuController {
    private ContactManager contactManager;
    private ConsoleView conseloView;

    public MenuController() {
        this.contactManager = new ContactManager();
        this.conseloView = new ConsoleView();
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            conseloView.displayMenu();
            String option = conseloView.getInput("");
            switch (option) {
                case "1":
                    addContact();
                    break;
                case "2":
                    findContactByName();
                    break;
                case "3":
                    deleteContactByName();
                    break;
                case "4":
                    printList();
                    break;
                case "5":
                    exit = true;
                    conseloView.showMessage("Exiting.....");
                    break;

                default:
                    conseloView.showMessage("Invalid option.");

                    break;
            }
        }
    }

    private void deleteContactByName() {
        String name = conseloView.getInput("Enter a name to delete: ");
        contactManager.deleteContactByName(name);
        conseloView.showMessage("Contact delete if it existed");
    }

    

    private void findContactByName() {
        String name = conseloView.getInput("Enter a name to search: ");
        Contact<?,?> contact = contactManager.findContactByName(name);
        if (contact != null) {
            conseloView.showMessage("Contact found: " + contact);
        }else{
            conseloView.showMessage("Contact not found 404");
        }
    }

    private void addContact() {
        String name = conseloView.getInput("Enter name : ");
        String phone = conseloView.getInput("Enter phone : ");
        Contact<String, String> contact = new Contact<>(name, phone);
        contactManager.addContact(contact);
        conseloView.showMessage("Contact added");
    }
    
    private void printList() {
        contactManager.printList();
    }

}