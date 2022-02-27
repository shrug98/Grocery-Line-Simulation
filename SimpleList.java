import java.util.AbstractList;
import java.util.NoSuchElementException;
import java.util.Iterator;

//Simple linked list class based on AbstractList
//READ THE DOCUMENTATION for AbstractList for more information
//on how these methods should work and when exceptions should
//be thrown. This data structure does not allow adding null
//elements.
class SimpleList<T> extends AbstractList<T> {
	//Add more instance variables here...
	//private or protected only!
	private int size; 
	private DoubleNode<T> tail = null; 
	//Constructor
	/**
	 * Constructs a new SimpleList instance and sets the size to 0
	 */
	public SimpleList() {
		//O(1)
		this.size = 0; 
	}
	
	/**
	 * Return the size of the SimpleList 
	 * @return the size of the SimpleList 
	 */
	//returns the size
	public int size(){
		//O(1)
		return size;
	}
	
	/**
	 * Return the value at a given index  
	 * @return the value at a given index 
	 */
	//returns the value at a given index
	public T get(int index) {
		//O(n)
		
		DoubleNode<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		
		if (current.value == null) {
			System.out.println(index);
		} 
		return current.value;
	}
	
	
	/**
	 * sets the value at given index with given value  
	 * @param index. Index is an integer value where the new value will be put.  
	 * value which is of type T is the new item to be put 
	 * @return old item at index 
	 */
	//sets the value at a given index and returns
	//the old value
	public T set(int index, T value) {
		//O(n)
		
		DoubleNode<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		T oldValue = current.value;
		current.value = value; 
		return oldValue;
	}
	
	/**
	 * Adds a new value at the specified index
	 * shifts the nodes to the right if needed
	 * @param index. Index is an integer value that determines the position at which value to be stored.  
	 * value of type T which is what will be put in the specified location 
	 */
	//adds a value at a given index
	public void add(int index, T value) {
		//O(n)
		DoubleNode<T> current = head;
		DoubleNode<T> node = new DoubleNode<>(value);
		if (index == 0) {
			node.next = current;
			current.prev = node;
			head = node; 
		}
		else {
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			} 
			node.next = current.next; 
			current.next = node;
		} 
		size++; 
		
	}
	
	/**
	 * Adds a new value at the end of the list 
	 * @param value. value of type T which is what will be put in the specified location   
	 * @return 
	 */
	//appends a value
	public boolean add(T value) {
		//O(1)
		DoubleNode<T> node = new DoubleNode<>(value);
		if (size == 0) {
			head = node;
		}
		else {
			tail.next = node;
		}
		tail = node; 
		size++; 
		return true;
	}
	
	
	/**
	 * removes the value at given index   
	 * shifts elements to remove any gap in the list 
	 * @param index. Index is an integer value which gives the position of the value to be removed   
	 * @return value that was removed 
	 */
	
	//removes the value at a given index and returns
	//the value removed
	public T remove(int index) {
		//O(n)
		T val; 
		if (index == 0) {
			val = head.value;
			head = head.next; 
			if (size == 0) {
				tail = null;
			}
		}
		else {
			DoubleNode<T> current = head.next;
			DoubleNode<T> previous = head;
			for (int i = 0; i < index - 1; i++) {
				previous = previous.next;
				current = previous.next; 
			}
			previous.next = current.next; 
			val = current.value; 
			if(size == index - 1) {
				tail = previous;
			} 
		}
		size--; 
		
			

			
		return val;
	}
	
	//-------------------------------------------------------------
	// Main Method For Your Testing -- Edit all you want
	//-------------------------------------------------------------
	
	public static void main(String[] args){
		SimpleList<Character> letters = new SimpleList<>();
		for (int i=0; i<5; i++)
			letters.add((char)(97+i*2));
			
			
		
		if (letters.size() == 5 && letters.get(0) == 'a'){
			System.out.println("Yay 1");
		}
		
		if (letters.set(1,'b') == 'c' && letters.get(1) == 'b'){
			System.out.println("Yay 2");
		}
		
		letters.add(2,'c');
		if (letters.size() == 6 && letters.get(2) == 'c' && letters.get(3)=='e'){
			System.out.println("Yay 3");
		}
		
		if (letters.remove(3)=='e' && letters.size() == 5 && letters.get(3)=='g'){
			System.out.println("Yay 4");
		}
	}
	
	//-------------------------------------------------------------
	// DO NOT EDIT ANYTHING BELOW THIS LINE EXCEPT TO ADD JAVADOCS
	//-------------------------------------------------------------
	
	//bad practice to have public inst. variables, but we want to test this...
	public DoubleNode<T> head = null;
	
	//provided doubly-linked list node class
	//bad practice to have public inst. variables,
	//in a public nested class, but we want to test this...
	public static class DoubleNode<T> {
		public T value;
		
		public DoubleNode<T> next;
		public DoubleNode<T> prev;
		
		public DoubleNode() { }
		public DoubleNode(T value) { this.value = value; }
	}
	
	//provided toString() method
	public String toString(){
		StringBuilder sBuilder = new StringBuilder("");
		for (T value : this){
			sBuilder.append(value);
			sBuilder.append(" ");
		}
		return sBuilder.toString();
	}
	
	//provided iterator, if your code is working, this should
	//work too...
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			DoubleNode<T> current = head;
			
			public T next() {
				if(!hasNext()) throw new NoSuchElementException();
				T val = current.value;
				current = current.next;
				return val;
			}
			
			public boolean hasNext() {
				return (current != null);
			}
		};
	}
}