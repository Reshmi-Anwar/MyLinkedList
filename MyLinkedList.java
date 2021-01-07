public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   size = 0;
 }
 //private helper
 private Node getNode(int index){
   int i = 0;
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

 public boolean add(String value){
   if (size == 0){
     Node n = new Node(value);
     start = n;
     end = n;
   }
   else{
     Node n = new Node(value);
     n.setPrev(end);
     end.setNext(n);
     end = n;
   }
   size++;
   return true;
 }

 public void add(int index, String value){
   if (index > size){
     throw new IndexOutOfBoundsException("Out of Bounds");
   }
   if(index == 0){
     Node n = start;//creates node
     start = new Node(value);//assigns it to value
     start.setNext(n);
     n.setPrev(start);
   }
   if(index == size()){
     add(value);
     return;
   }
   else{
     Node current = getNode(index);
     Node n = new Node(value);
     n.setNext(current);
     n.setPrev(current.getPrev());
     current.getPrev().setNext(n);
     current.setPrev(n);
   }
   size++;
 }
 /*
 public String get(int index);
 public String set(int index, String value);
 public String toString();
 */
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
