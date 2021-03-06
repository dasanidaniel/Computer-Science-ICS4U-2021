package linkedlist;

public class ContactLinkedList {
    private ContactNode head;
  
    public ContactLinkedList() {
      this.head = null;
    }
  

    /**
     * Code below is responsible for adding new contacts to the list.
     * @param c the contact being added to the list.
     */
    public void add(Contact c) {

      ContactNode node = new ContactNode(c, null);
      if (head == null)
        head = node;

      else {
        // iterate to the end and add it there
        ContactNode ptr = head;
        while (ptr.getLink() != null) {
          ptr = ptr.getLink();
        }
  
        ptr.setLink(node);

      }
    }

    /**
     * The code below is responsible for removing contacts. 
     * @param phone the phone number attached to the contact to be removed.
     */

    public void remove(String phone) {

      if (head == null)
        return;
      else if (head.getData().getPhone().equals(phone))
        head = head.getLink();
      else {
        ContactNode ptr = head;
        while (ptr.getLink() != null && !ptr.getLink().getData().getPhone().equals(phone)) {
          ptr = ptr.getLink();
        }
        if (ptr.getLink() == null)
          return;
        else
          ptr.setLink(ptr.getLink().getLink());
      }
  
    }

    // Search through contacts via comparing lName
    public void search (String lName){

        ContactNode ptr = head;

        while(ptr != null){

            if (ptr.getData().getlName().equals(lName)) {
                // Print contact info
                System.out.println(ptr.getData().toString()); 
                ptr = ptr.getLink();
            }
            
            else {
                ptr = ptr.getLink();
            }
        }

    }
    
    /**
     * Code below responsible for printing a list of all contacts
     * @param list
     */
    public static void printList(ContactLinkedList list) { 

        ContactNode ptr = list.head; 

        System.out.print("Contacts: "); 
        // Loop to print all contacts
        while (ptr != null) { 
            
            System.out.print(ptr.data + " "); 
    
            ptr = ptr.getLink(); 

        } 
    
    } 

}