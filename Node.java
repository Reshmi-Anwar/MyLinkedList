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
 public Node getPrev(){
   return prev;
 }
 public void setPrev(Node newPrev){
   prev = newPrev;
 }
 public String getData(){
   return data;
 }
 public void setData(String newData){
   data = newData;
 }
}
