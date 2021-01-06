public class Node{
 public Node(String value){
   data = value;
 }
 private String data;
 private Node next,prev;
 public Node getNext(){
   return next;
 }
 public void setNext(Node newNext){
   next = newNext;
 }
 

}
