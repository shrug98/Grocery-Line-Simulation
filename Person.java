//class representing a person and their cart
class Person {
	//Add more instance variables here...
	//private or protected only!
	private int numItems; 
	
	//Sets up a person with a given number of items.
	/**
	 * Constructs a new Person of grocery line with the specified number of items
	 * @param numItems numItems is an interger value of the 
	 * number of items the person has. 
	 */
	public Person(int numItems) {
		//O(1)
		//throws an IllegalArgumentException if numItems is
		//invalid (the person has less than one item)
		if (numItems < 1) {
			throw new IndexOutOfBoundsException(); 
		}
		else {
			this.numItems = numItems;
		}
	}
	
	/**
	 * Return the number of items the person still has 
	 * @return the number of items the person still has 
	 */
	//Gets how many items the person still has.
	public int getNumItems() {
		//O(1)
		return numItems;
	}
	
	/**
	 * Removes one item from the persons total number of items. 
	 */
	//Removes one item from this person (i.e. "checks out"
	//one item from this person.
	public void removeItem() {
		//O(1)
		this.numItems = this.numItems - 1; 
	}
	
	/**
	 * Returns a boolean value to indicate whether the person has 
	 * any more items left.
	 * @return true if no more items left, false if items are left 
	 */
	//Indicates whether or not this person has any more
	//items left to "check out".
	public boolean done() {
		//O(1)
		if (this.numItems == 0) {
			return true;
		}
		else {
			return false ;
		}
	}
	
	//-------------------------------------------------------------
	// Main Method For Your Testing -- Edit all you want
	//-------------------------------------------------------------
	
	public static void main(String[] args){
		Person mason = new Person(2); 
		if (mason.getNumItems() == 2 && !mason.done()){
			System.out.println("Yay 1");
		}
		
		mason.removeItem();
		boolean ok = (mason.getNumItems() == 1);
		mason.removeItem();
		if ( ok && mason.done()){
			System.out.println("Yay 2");
		}
	}
	
	//-------------------------------------------------------------
	// DO NOT EDIT ANYTHING BELOW THIS LINE EXCEPT TO ADD JAVADOCS
	//-------------------------------------------------------------
	
	//provided toString() method
	public String toString() {
		return "Person("+getNumItems()+")";
	}
}