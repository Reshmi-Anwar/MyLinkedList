public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   size = 0;
 }
 private Node getNode(int index){
   int i =0;
   Node current = start;
   while(i < index){
     current = current.getNext();
     i++;
   }
   return current;
 }
 public int size(){
   return size;
 }
 /*
 public boolean add(String value);
 public void add(int index, String value);
 public String get(int index);
 public String set(int index, String value);
 public String toString();
 */
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
