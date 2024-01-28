package LL_Practice;
import java.util.Scanner;

public class Node {
    int data;
    static int size=5;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
    Node(int data, Node next){
        this.data=data;
        this.next=next;
    }

    static Node default_list(int x){
        System.out.println("This is your default List");
        Node start=new Node(x);
        Node p=start;
        for(int i=2; i<=size; i++){
            p.next=new Node(x*i);
            p=p.next;
        }
        return start;
    }

    static void display(Node start){
        int count=0;
        if(start==null){
            System.out.println("List is empty");
        }
        for(Node p=start; p!=null; p=p.next){
            System.out.print(p.data);
            count++;
            if(count<size){
                System.out.print(" -> ");
            }
        }
        System.out.println("null\n");
    }
    static int size(){
        return size;
    }
   
    static Node EmptyList(Node start){
        start=null;
        size=0;           
        return start;
    }

    static Node insert(Node start, int x){
       	//list should be sorted --> pre-condition
		//list is sorted with new element inserted --> post condition
        Node p=start;
        size++;
        if(start==null || start.data>x){
            start=new Node(x,start);
        }
        else{
        while(p.next!=null){
            if(p.next.data>x){
                break;
            }
            p=p.next;
        }
        p.next=new Node(x,p.next);
    }
        return start;
    }
    static Node delete(Node start,int x){
        //list must be in ascending order for deletion and insertion
	    //first occurrence will be delete if there are multioccurence of x
        Node p=start;
        if(start==null || start.data>x){
            System.out.println("Number not found!");
          return start;
        }
        else if(start.data==x){
            size--;
            System.out.println("deleted successfully!");
            return start.next;
        }
        while(p.next!=null){
            if(p.next.data>x){//x is not in the list
            System.out.println("Number not found!");
            break;}

            if(p.next.data==x){
                p.next=p.next.next;
                size--;
                System.out.println("deleted successfully!");
                break;
            }
            p=p.next;
        }
        return start;
    }
    static Node replace(Node start, int pos, int val){
        Node p=start;
        int count=0;
        if(pos>0 && pos<=size){
         while(p!=null){
            count++;
            if(count==pos){
              p.data=val;
            }
            p=p.next;
         }
        }
        else
        System.out.println("Position doesn't exist");
        return start;
    }
    static int sum(Node start){
        Node p=start;
        int sum=0;
        while(p!=null){
          sum+=p.data;
            p=p.next;
        }
        return sum;
    }
    static Node reverse(Node start){
        int count=0;
        int arr[]=new int[size];
        for(Node p=start; p!=null; p=p.next){
            arr[count]=p.data;
            count++;
        }
        int ArrCopy[]=new int[size];
        System.arraycopy(arr, 0, ArrCopy, 0, count);
        for(int i=0; i<arr.length; i++){
            arr[i]=ArrCopy[arr.length-1-i];
        }
        System.out.println();
        Node newList=new Node(arr[0]);
        Node q=newList;
        for(int i=1; i<arr.length; i++){
            q.next=new Node(arr[i]);
            q=q.next;
        }
        return newList;
    }
    static Node concatenate(Node start1, Node start2){

        for(Node p=start2; p!=null; p=p.next){
            start1=insert(start1, p.data);
        }
        return start1;
    }
    static Node copylist(Node start, Node start2) {
		Node p = start;
	    start2=null;
		// Iterate from the second node onwards
		while (p != null ) {
			if (start2 == null) {
				start2 = new Node(p.data);
			} else {
				start2 = insert(start2, p.data);
			}
			p = p.next;
		}
	
		return start2;
	}	
    static Node sublist(Node start, int x, int y) {
		Node start2 = null;
		Node p = start;
		int count = 1;
	
		while (p != null && count <= y) {
			if (count >= x && count <= y) {
				if (start2 == null) {
					start2 = new Node(p.data);
				} else {
					start2.next = new Node(p.data);
					start2 = start2.next;
				}
			}
			p = p.next;
			count++;
		}
		return start2; 
	}
    static void displaylists(Node start1, Node start2){
      System.out.print("LIST 1 : ");
      for(Node p=start1; p!=null; p=p.next){
        System.out.print(p.data+"-->");
      }
      System.out.print("null");
      System.out.print("\n\nLIST 2 : ");
      for(Node p=start2; p!=null; p=p.next){
        System.out.print(p.data+" ");
      }
      System.out.print("null\n");
    }
    static void user_Interface(Node start){
        Scanner input=new Scanner(System.in);
        int option;
        do{
            System.out.println("Select from the following: ");
            System.out.println("1. Empty default list");
            System.out.println("2. Insert new element");
            System.out.println("3. Delete existing element");
            System.out.println("4. Display List");//for checking purpose
                                                    // after making changes to the default list
            System.out.println("5. Replace element by some other");
            System.out.println("6. Sum of all elements in the list");
            System.out.println("7. Reverse list");
            System.out.println("8. Display Sublist");
            System.out.println("9. Operations with 2 lists");
            System.out.println("10. Exit");
            
            System.out.println("Enter your choice: ");
            option=input.nextInt();
            switch (option) {
                case 1:
                    {start=EmptyList(start);
                    break;}
                case 2:{
                    System.out.print("Enter number to be inserted (integer): ");
                    int x=input.nextInt();
                    System.out.println();
                    start=insert(start, x);
                    break;}
                case 3:{
                    System.out.print("Enter number to be deleted (integer): ");
                    int x=input.nextInt();
                    System.out.println();
                    start=delete(start, x);
                    break;
                }
                case 4:
                    {display(start);
                    break;}
                case 5:{
                    System.out.println("Enter position of element to be replaced(integer): ");
                    int pos=input.nextInt();
                    System.out.println("Enter value(integer) : ");
                    int val=input.nextInt();
                    start=replace(start,pos,val);
                    break;
                }
                case 6:{
                    System.out.println("SUM : "+sum(start));
                    break;
                }
                case 7:{
                    Node start3=reverse(start);
                    display(start3);
                    break;
                }
                case 8:{
                    System.out.println("Enter start position: ");
                    int x=input.nextInt();
                    System.out.println("Enter end position: ");
                    int y=input.nextInt();
                    Node start2=sublist(start, x, y);
                    display(start2);
                    break;
                }
                case 9:{
                    Node start2=default_list(20);
                    System.out.println("2nd default list: ");
                    display(start2);
                    user_Interface2(start, start2);
                   break;
                }
                case 10:
                    {System.exit(0);
                    break;}
                default:
                    {System.out.println("Invalid input");
                    break;}
            }
        }while(option!=9 || option!=10);
    }

    static void user_Interface2(Node start1, Node start2){
        Scanner input=new Scanner(System.in);
        int option;
        do{
            System.out.println("Select operation from the following: ");
            System.out.println("1. Concatenate 2nd list with 1st list");
            System.out.println("2. Copy 1st list into 2nd list");
            System.out.println("3. Display Lists");
            System.out.println("4. Operations with single list");
            System.out.println("5. Exit");
            
            System.out.println("Enter your choice: ");
            option=input.nextInt();
            switch (option) {
                case 1:
                    {
                        start1=concatenate(start1, start2);
                    break;
                }
                case 2:{
                    start2=copylist(start1, start2);
                    break;}
                case 3:{
                   displaylists(start1, start2);
                    break;
                }
                case 4:
                    {System.out.println("With list 1 or 2 ? ");
                    int choice=input.nextInt();
                    if(choice==1){
                        user_Interface(start1);
                    }
                    else if(choice==2){
                        user_Interface(start2);
                    }
                    else
                    System.out.println("Invalid input");
                    break;}
                case 5:{
                    System.exit(0);
                    break;
                }
                default:
                    {System.out.println("Invalid input");
                    break;}
            }
        }while(option!=5 );
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Node start=default_list(10);
        display(start);
        
        System.out.println("do you want to make changes to the list?(y/n)");
        String choice=input.next();
       
        if(choice.equalsIgnoreCase("y")){
       user_Interface(start);
    }
    else{
        System.out.println("Program Ended...!");
    }
    

    }
}
