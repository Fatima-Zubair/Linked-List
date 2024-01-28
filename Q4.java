class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
     boolean isEmpty(Node head){
        return (head==null);
    }
      void addnode(Node head,int data){
        Node newNode=new Node(data);
        if(isEmpty(head)){
          head=newNode;
        }
        else{
          Node p=head;
          while(p.next!=null){
            p=p.next;
          }
          p.next=new Node(data);
        }
      }
      void displayList(Node head){
        for(Node p=head; p!=null;p=p.next){
            System.out.println(p.data);
        }
    }
       int size(Node start){
        int count=0;
        Node tempNode=start;
        while(tempNode!=null){
            count++;
            tempNode=tempNode.next;
        }
        return count;
    }
    int[] list_to_array(Node start){
         int[] arr=new int[size(start)];
        Node p=start;
        int i=0;
        while(p!=null){
            arr[i]=p.data;
            i++;
            p=p.next;
        }

         return arr;
    }
}

public class Q4 {
public static void main(String[] args) {
    Node start=new Node(0);
    start.addnode(start, 1);
    start.addnode(start, 2);
    start.addnode(start, 88);
    start.addnode(start, 4);
    System.out.println("THE LIST : ");
    start.displayList(start);

    int[] arr=start.list_to_array(start);
    System.out.println("THE ARRAY : ");
    for(int i=0; i<arr.length;i++){
        System.out.println("arr["+i+"]="+arr[i]);
                }
}
}
