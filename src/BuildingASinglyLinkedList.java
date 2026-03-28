public class BuildingASinglyLinkedList {
    public static void main(String [] args){
        CustomeLinkedList list = new CustomeLinkedList();
        list.add(10);
        list.add(20);
        list.add(5);
        list.display();
    }
}

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class CustomeLinkedList{
    Node head;
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            // 1. Just find the end. Don't do anything inside the loop!
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public void display(){
//        Node temp = head;
        for(Node temp = head; temp != null; temp = temp.next){
            System.out.print(temp.data+" -> ");
        }
        System.out.print("null");
    }
}