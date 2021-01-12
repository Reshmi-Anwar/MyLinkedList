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
   if ((index > size()) || (index < 0)){
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
     Node x = new Node(value);
     x.setNext(current);
     x.setPrev(current.getPrev());
     current.getPrev().setNext(x);
     current.setPrev(x);
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
   if(size==0){
     return "[]";
   }
   Node current = start;
   String result = "[";
   while(current!= null){
     result += current.getData();
     if((current.getNext() != null)){
       result = result + ", ";
     }
     current = current.getNext();
   }
   result += "]";
   return result;
 }
 public String toStringReversed(){
   if(size == 0){
     return "[]";
   }
   Node current = end;
   String n = "[";
   while(current != null){
      n += current.getData();
      if(current.getPrev() != null){
        n+= ", ";
      }
      current = current.getPrev();
   }
   n += "]";
   return n;
 }

  public String remove(int index){
    if ((index >= size()) || (index < 0)){
      throw new IndexOutOfBoundsException("Out of Bounds");
    }
    size--;
    if(size() == 0){
      String n = start.getData();
      start = null;
      end = null;
      return n;
    }
    if(index == 0){
      String n = start.getData();
      start = start.getNext();
      start.setPrev(null);
      return n;
    }
    if (index == size()){
      String n = end.getData();
      end = end.getPrev();
      end.setNext(null);
      return n;
    }
    Node removedNode = getNode(index);
    removedNode.getNext().setPrev(removedNode.getPrev());
    removedNode.getPrev().setNext(removedNode.getNext());
    return removedNode.getData();
  }

    public void extend(MyLinkedList other){
      if(other.size() < 1){
        return;
      }
      end.setNext(other.start);
      other.start.setPrev(end);
      end = other.end;
      size += other.size();
      other.start = null;
      other.end = null;
      other.size = 0;
    }

}
