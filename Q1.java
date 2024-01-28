import java.util.Scanner;
class FireAir{
    static class Node{
         String song;
        Node nextNode;
        Node(String song){
            this.song=song;
            nextNode=null;
        }
    }
     Node head=null;
     int size=0;

     int getSize(){
        return size;
     }
     void displaySong(){
        System.out.println("THE LIST: ");
        for(Node p=head; p!=null;p=p.nextNode){
            System.out.println(p.song);
        }
    }
    boolean isEmpty(){
        return (head==null );
    }
     void addNode(String song) {
        Node newNode = new Node(song);
        size++;
        if (isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }
            temp.nextNode = newNode;
        }
    }
    void insertAtStart(String song) {
        Node newNode = new Node(song);
        size++;
        newNode.nextNode = head;
        head = newNode;
    }
    void insertAtEnd(String song) {
        Node newNode = new Node(song);
        size++;
        if (isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }
            temp.nextNode = newNode;
        }
    }
    void insertAt(String song, int pos) {
        if (pos == 1) {
            insertAtStart(song);
        } else if (pos == size + 1) {
            insertAtEnd(song);
        } else if (pos > 1 && pos <= size) {
            Node newNode = new Node(song);
            Node temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.nextNode;
            }
            newNode.nextNode = temp.nextNode;
            temp.nextNode = newNode;
            size++;
        } else {
            System.out.println("Not Possible");
        }
    }
void deleteAtStart() {
        if (!isEmpty()) {
            head = head.nextNode;
        } else {
            System.out.println("List is empty.");
        }
    }

    void deleteAtEnd() {
        if (!isEmpty()) {
            if (head.nextNode == null) {
                head = null;
            } else {
                Node temp = head;
                while (temp.nextNode.nextNode != null) {
                    temp = temp.nextNode;
                }
                temp.nextNode = null;
            }
        } else {
            System.out.println("List is empty.");
        }
    }

    void deleteAtAnyPosition(int position) {
        if (!isEmpty()) {
            if (position == 0) {
                deleteAtStart();
            } else if (position == getSize() - 1) {
                deleteAtEnd();
            } else if (position > 0 && position < getSize() - 1) {
                Node temp = head;
                for (int i = 0; i < position - 1; i++) {
                    temp = temp.nextNode;
                }
                temp.nextNode = temp.nextNode.nextNode;
            } else {
                System.out.println("Invalid position.");
            }
        } else {
            System.out.println("List is empty.");
        }
    }

    void searchSong(String song) {
        Node temp = head;
        int pos = 0;
        boolean found = false;
        while (temp != null) {
            if (temp.song.equalsIgnoreCase(song)) {
                System.out.println("Song found at position " + pos);
                found = true;
                break;
            }
            temp = temp.nextNode;
            pos++;
        }
        if (!found) {
            System.out.println("Song not found.");
        }
    }

    int getSize2() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.nextNode;
        }
        return count;
    }
    void options(){
        Scanner sc=new Scanner(System.in);
         int choice;
      do{
        System.out.println("Select what you want to do with your songs list");
        System.out.println("1: Display songs");
        System.out.println("2: insert song at start");
        System.out.println("3: insert song at end");
        System.out.println("4: insert song at any position");
        System.out.println("5: delete song at start");
        System.out.println("6: delete song at end");
        System.out.println("7: delete song at any position");
        System.out.println("8: Search song");
        System.out.println("9: Exit");
        System.out.println("\n Enter your choice: ");
         choice=sc.nextInt();
        switch(choice){
            case 1:{displaySong();
                 break;
            }
            case 2:{System.out.println("Enter new song to be inserted at start:");
                 String song=sc.next();
                 insertAtStart(song);
                 break;
            }
            case 3:{ System.out.println("Enter new song to be inserted at end:");
                 String song=sc.next();
                 insertAtEnd(song);
                 break;
            }
               case 4:{ System.out.println("Enter position: ");
               int pos=sc.nextInt();
                System.out.println("Enter name of song:");
                 String song=sc.next();
                 insertAt(song, pos);
                 break;
            }
            case 5:{deleteAtStart();
                 break;
            }
            case 6:{ deleteAtEnd();
                 break;
            }
               case 7:{ System.out.println("Enter position: ");
               int pos=sc.nextInt();
                deleteAtAnyPosition(pos);
                 break;
            }
            case 8:{ System.out.println("Enter name of song which you want to search: ");
                 String song=sc.next();
                 searchSong(song);
                 break;
            }
            case 9:{ System.out.println("Exited successfully");
                 System.exit(0);
                break;
            }
            default:{System.out.println("Invalid choice \nTry Again...");
                break;
            }
        }
    }while(choice!=9);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FireAir obj = new FireAir();
        System.out.println("WELCOME TO FIREAIR MUSIC APP");
        String choice;
        do {
            System.out.println("Enter song name: ");
            String s = sc.next();
            obj.addNode(s);
            System.out.println("Do you want to add another song? (y/n)");
            choice = sc.next();
        } while (choice.equalsIgnoreCase("y"));

        obj.options();   
    }
}