import java.util.Queue;
import java.util.NoSuchElementException;

//Class for a simple queue based on SimpleList
//The "front" of the queue should be the front of
//the list.

//READ THE DOCUMENTATION for the Queue interface for more information
//on how these methods should work and when exceptions should
//be thrown. This data structure does not allow adding null.

//DO NOT re-implement nodes in this class... remember how
//inheritance works in Java and make use of that!
class SimpleQueue<T> extends SimpleList<T> implements Queue<T> {
	
	/**
	 * Adds a new item at the end of the queue using simplelist functions 
	 * @param item. item is the value that is added to the end of the queue  
	 * @return true if item is successfully added and false if item is null 
	 */
	public boolean add(T item) {
		//O(1)
		if (item == null) {
			return false;
		} 
		super.add(item);
		System.out.println("adding" + item); 
		return true;
	}
	
	/**
	 * Adds a new item at the end of the queue using simplelist functions 
	 * @param item. item is the value that is added to the end of the queue  
	 * @return true if item is successfully added and false if item is null 
	 */
	public boolean offer(T item) {
		//O(1)
		if (item == null) {
			return false;
		} 
		super.add(item); 
		return true; 
	}

	/**
	 * Removes the item at the end of the queue using simplelist functions  
	 * throws an exception if the size of queue is 0   
	 * @return the value that has been removed  
	 */
	public T remove() {
		//O(1)
		if (super.size() == 0) {
			throw new NoSuchElementException();
		}
		T value = super.remove(0); 
		return value;
	}

	/**
	 * Removes the item at the end of the queue using simplelist functions  
	 * Performs the same task as the remove() function   
	 * @return the value that has been removed or null if size of queue is 0 
	 */
	public T poll() {
		//O(1)
		if (super.size() == 0) {
			return null; 
		}
		T value = super.remove(0); 
		return value;
	}
	
	/**
	 * Gets the item at the front of the queue using simplelist functions  
	 * throws an exception if the size of queue is 0   
	 * @return the value at the beginning of the queue  
	 */
	public T element() {
		//O(1)
		//System.out.println(this.size());  
		if (this.size() == 0) {
			throw new NoSuchElementException(); 
		}
		T value = super.get(0); 
		return value;
	}
	
	/**
	 * Gets the item at the front of the queue using simplelist functions  
	 * Performs the same task as the element() function   
	 * @return the value or null if size of queue is 0 
	 */
	public T peek() {
		//O(1)
		if (super.size() == 0) {
			return null;  
		}
		T value = super.get(0); 
		return value;
	}
	
	//-------------------------------------------------------------
	// Main Method For Your Testing -- Edit all you want
	//-------------------------------------------------------------
	
	public static void main(String[] args){
		SimpleQueue<Integer> nums = new SimpleQueue<>();
		
		nums.offer(2);
		nums.offer(3);
		nums.offer(5);
		
		if (nums.peek() == 2 && nums.size()==3){
			System.out.println("Yay 1");
		}
		
		if (nums.poll() == 2 && nums.poll() == 3 
			&& nums.poll() == 5 && nums.poll() == null){
			System.out.println("Yay 2");			
		}
	}
}