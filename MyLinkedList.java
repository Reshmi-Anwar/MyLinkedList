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
   if ((index >= size()) || (index < 0)){
     throw new IndexOutOfBoundsException("Out of Bounds");
   }
   if(index == size()){
     add(value);
     return;
   }
   if(index == 0){
     Node n = start;//creates node
     start = new Node(value);//assigns it to value
     start.setNext(n);
     n.setPrev(start);
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

 public String get(int index){
   if ((index >= size()) || (index < 0)){
     throw new IndexOutOfBoundsException("Out of Bounds");

   }
   return (getNode(index).getData());
 }

 public String set(int index, String value){
   if ((index >= size()) || (index < 0)){
     throw new IndexOutOfBoundsException("Out of Bounds");

   }
   Node current = getNode(index);
   String n = current.getData();
   current.setData(value);
   return n;
 }

 public String toString(){
   Node current = start;
   String result = "[";
   while(current.getNext()!= null){
     result = result + current.getData();
     current = current.getNext();
     if(current.getNext() != null){
       result = result + ", ";
     }
   }
   result += "]";
   return result;
 }

}
