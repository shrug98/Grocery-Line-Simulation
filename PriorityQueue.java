import java.util.NoSuchElementException;
import java.util.Date; //for testing

//priority queue where the minimum item has the highest priority
class PriorityQueue<T extends Comparable<T>> extends SimpleQueue<T> {
	//updates an item that's already in the queue
	//NOTE: This should update the exact item in memory, 
	//not just any "equal" item (in other words, you 
	//should use == here and not .equals())
	public void update(T item) 	{
		/*int found = 0; 
		int found1 = 0; 
		T value; 
		for(int i = 0; i < this.size(); i++) {
			System.out.println(i);
			if (this.get(i) == item) {
				

				//System.out.println(this.size()); 
				value = this.remove(i);
				found = 1;
				//System.out.println("new size" + this.size()); 
				
				break;
			}
		}
		if (found == 0) {
			throw new NoSuchElementException(); 
		}
		for (int j = 0; j < this.size(); j++) {
			//System.out.println("hi"); 
			if(this.get(j).compareTo(item) > 0 ) {
				//System.out.println("hi"); 
				//System.out.println(this.get(j)); 
				//System.out.println("item is " + item); 
				//System.out.println("index is " + j);
				this.add(j, item);
				found1 = 1;
				break;
			}
		}
		if(found1 == 0){
			//System.out.println("item is " + item); 
			//System.out.println("size " + this.size()); 
			this.add(this.size(), item);
			//System.out.println("size " + this.size()); 
		}*/ 
				
			
		
				

				
		//O(n)
		//throws NoSuchElementException if item is not
		//in the queue
	}
	
	//You may need to override some other methods from SimpleQueue!
	
	//Restriction 1: all methods from SimpleQueue should still work
	//(as in, if you add(), the value should be added, if you call 
	//size() it should return the correct value, etc.). However, 
	//remove/poll will remove the _minimum_ value from the queue;
	//element/peek will return the _minimum_ value from the queue.
	
	//Restriction 2: element() and peek() must still both be O(1)
	
	//-------------------------------------------------------------
	// Main Method For Your Testing -- Edit all you want
	//-------------------------------------------------------------
	
	public static void main(String[] args){
		PriorityQueue<Date> values = new PriorityQueue<>();
		Date[] dates = new Date[5];
		for (int i=5; i>=1; i--){
			dates[i-1] = new Date(86400000*i);
			values.add(dates[i-1]);
		}
		
		for(Date d : values) {
			System.out.println(d);
		}

		dates[3].setTime(0);
		values.update(dates[3]);
		
		System.out.println();
		for(Date d : values) {
			System.out.println(d);
		}
		
		if(values.peek().equals(dates[3])) {
			System.out.println("\nYay 1");
		}
		PriorityQueue<Integer> v = new PriorityQueue<>();
		v.add(20);
		v.add(24);
		v.add(54);
		v.add(76);
		v.update(76); 
		for(int j : v){
			System.out.println(j);
		} 
		v.remove();
		System.out.println("new balues are "); 
		for(int j : v){
			System.out.println(j);
		}
		System.out.println(v.size()); 
		v.add(23);
		System.out.println(v.size()); 
		//System.out.println("heheu" + v.get(v.size() - 1));
		for(int j : v){
			System.out.println(j);
		}
		v.update(23);
		//System.out.println(v.get(v.size() - 1));
	}
}