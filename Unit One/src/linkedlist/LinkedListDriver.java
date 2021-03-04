package linkedlist;

import java.util.Scanner;

public class LinkedListDriver {
    public static void main(String[] args) {

        Scanner ni = new Scanner (System.in);
        ContactLinkedList contacts = new ContactLinkedList();
        boolean ends = false;
        Scanner options = new Scanner (System.in);
        String yes = "Yes";
        String yes2 = "yes";
        String yes3 = "y";

        while (!ends){

            System.out.println("");
            System.out.println("To add a contact press 1");
            System.out.println("To display all contacts press 2");
            System.out.println("To display a specific contact press 3");
            System.out.println("To delete a contact press 4");
            System.out.println("");
            System.out.println("____________________________");
            System.out.println("");

            int option = Integer.parseInt(options.nextLine());

            System.out.println("");
            System.out.println("____________________________");
            System.out.println("");

            if (option == 1)
                newContact(contacts);

            else if (option == 2) {
                ContactLinkedList.printList(contacts);
                System.out.println("");
                System.out.println("____________________________");
            }

            else if (option == 3)
                searchContact(contacts);

            else if (option == 4)
                deleteContact(contacts);

            System.out.println("");
            System.out.println("If you would like to use the menu again please type Yes , and if not please type No");

            String end = (ni.nextLine());

            if (end.equals(yes) || end.equals(yes2) || end.equals(yes3)){
                ends = false;
                System.out.println("");
                System.out.println("____________________________");
            }

            else{
                ends = true;
            }
        }

        ni.close();
        options.close();
    }
    private static void newContact(ContactLinkedList contacts){

        Scanner in = new Scanner (System.in);

        System.out.print("Please Enter the Last Name: ");
        String LastN = (in.nextLine());

        System.out.print("Please Enter the First Name: ");
        String FirstN = (in.nextLine());

        System.out.print("Please Enter the Phone Number: ");
        String pNumber = (in.nextLine());

        Contact f = new Contact(FirstN, LastN, pNumber);
        contacts.add(f);

        System.out.println("");
        System.out.println("____________________________");

    } 


    private static void searchContact(ContactLinkedList contacts){ 

        Scanner in = new Scanner (System.in); 

        System.out.print("Please Enter the Last Name of the Contact: ");

        String lName = (in.nextLine());
        contacts.search(lName);

        System.out.println("");
        System.out.println("____________________________");
        
    }


    private static void deleteContact(ContactLinkedList contacts){

        Scanner in = new Scanner (System.in);

        System.out.println("Please enter the phone number of the contact you would like to delete: ");

        String num = (in.nextLine());
        contacts.remove(num);

        System.out.println("");
        System.out.println("____________________________");

    }
}