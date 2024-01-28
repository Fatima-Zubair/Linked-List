//  class Node{
//          String song;
//         Node nextNode;
//         Node(String song){
//             this.song=song;
//             nextNode=null;
//         }
//      Node head=null;
//      int size=0;

//     boolean isEmpty(){
//         return (head==null );
//     }
//     int getSize() {
//         int count = 0;
//         Node temp = head;
//         while (temp != null) {
//             count++;
//             temp = temp.nextNode;
//         }
//         return count;
//     }
//     void insertAtStart(String song) {
//         Node newNode = new Node(song);
//         size++;
//         newNode.nextNode = head;
//         head = newNode;
//     }
//     void insertAtEnd(String song) {
//         Node newNode = new Node(song);
//         size++;
//         if (isEmpty()) {
//             head = newNode;
//         } else {
//             Node temp = head;
//             while (temp.nextNode != null) {
//                 temp = temp.nextNode;
//             }
//             temp.nextNode = newNode;
//         }
//     }
//     void insertAt(String song, int pos) {
//         if (pos == 1) {
//             insertAtStart(song);
//         } else if (pos == size + 1) {
//             insertAtEnd(song);
//         } else if (pos > 1 && pos <= size) {
//             Node newNode = new Node(song);
//             Node temp = head;
//             for (int i = 1; i < pos - 1; i++) {
//                 temp = temp.nextNode;
//             }
//             newNode.nextNode = temp.nextNode;
//             temp.nextNode = newNode;
//             size++;
//         } else {
//             System.out.println("Not Possible");
//         }
//     }
// void deleteAtStart() {
//         if (!isEmpty()) {
//             head = head.nextNode;
//         } else {
//             System.out.println("List is empty.");
//         }
//     }

//     void deleteAtEnd() {
//         if (!isEmpty()) {
//             if (head.nextNode == null) {
//                 head = null;
//             } else {
//                 Node temp = head;
//                 while (temp.nextNode.nextNode != null) {
//                     temp = temp.nextNode;
//                 }
//                 temp.nextNode = null;
//             }
//         } else {
//             System.out.println("List is empty.");
//         }
//     }

//     void deleteAtAnyPosition(int position) {
//         if (!isEmpty()) {
//             if (position == 0) {
//                 deleteAtStart();
//             } else if (position == getSize() - 1) {
//                 deleteAtEnd();
//             } else if (position > 0 && position < getSize() - 1) {
//                 Node temp = head;
//                 for (int i = 0; i < position - 1; i++) {
//                     temp = temp.nextNode;
//                 }
//                 temp.nextNode = temp.nextNode.nextNode;
//             } else {
//                 System.out.println("Invalid position.");
//             }
//         } else {
//             System.out.println("List is empty.");
//         }
//     }

//     void searchSong(String song) {
//         Node temp = head;
//         int pos = 0;
//         boolean found = false;
//         while (temp != null) {
//             if (temp.song.equalsIgnoreCase(song)) {
//                 System.out.println("Song found at position " + pos);
//                 found = true;
//                 break;
//             }
//             temp = temp.nextNode;
//             pos++;
//         }
//         if (!found) {
//             System.out.println("Song not found.");
//         }
//     }
//     void deleteByValue(String song) {
//         Node temp = head;
//         Node prev = null;

//         if (temp != null && temp.song.equals(song)) {
//             head = temp.nextNode;
//             size--;
//             return;
//         }

//         while (temp != null && !temp.song.equals(song)) {
//             prev = temp;
//             temp = temp.nextNode;
//         }

//         if (temp == null) {
//             System.out.println("Song not found");
//             return;
//         }

//         prev.nextNode = temp.nextNode;
//         size--;
//     }
//      void displaySong(){
//         System.out.println("THE LIST: ");
//         for(Node p=head; p!=null;p=p.nextNode){
//             System.out.println(p.song);
//         }
//     }
// }

// public class Q3 {
// public static void main(String[] args) {
//     Node obj = new Node("MY SONGS");

//     // Insertion operations
//     obj.insertAtStart("Song 1");
//     obj.insertAtEnd("Song 2");
//     obj.insertAt("Song 3", 2);
//     obj.insertAt("Song 4", 4);

//     // Display the list
//     obj.displaySong();

//     // Delete operations
//     obj.deleteAtStart();
//     obj.deleteAtEnd();
//     obj.deleteAtAnyPosition(1);

//     // Display the updated list after deletion
//     obj.displaySong();

//     // Search for a song
//     obj.searchSong("Song 2");

//     // Delete by value
//     obj.deleteByValue("Song 2");

//     // Display the final list after deletion by value
//     obj.displaySong();
// }
// }
