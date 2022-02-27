import java.util.Queue;

//A data structure (based on a queue) to represent a grocery
//store line.

//Grocery lines can only contain people and can be compared 
//to eachother based on the number of items left to process
//in the line. The lines also have id numbers.
class GroceryLine extends SimpleQueue<Person> implements Comparable<GroceryLine> {
	//Creates a grocery store line with a given ID.
	int id; 
	/**
	 * Constructs a new GroceryLine of specific id
	 * @param id . id is the integer value of specific id 
	 */
	public GroceryLine(int id) {
		//O(1)
		this.id = id;
		
	}
	
	/**
	 * Return the id of the grocery line 
	 * @return the id of the grocery line 
	 */
	//Returns the ID of the grocery line.
	public int getId() {
		//O(1)
		return id;
	}
	
	/**
	 * Sums up all items for all people in the line 
	 * @return sum of all items in the line  
	 */
	//Sums up all items for all people in the line.
	public int itemsInLine() {
		//O(n), where n = the number of people in line
		int sum = 0 ; 
		for (int i = 0 ; i < this.size(); i++) {
			sum = sum + this.get(i).getNumItems(); 
		}
			
		return sum;
	}
	
	//Compare one grocery line to another based on
	//the number of items in the line and then, if
	//the two lines are tied, by their id.
	/**
	 * Compares two grocery lines 
	 * @param otherline
	 * @return integer value of compare 
	 */
	public int compareTo(GroceryLine otherLine) {
		//O(n+m), where n = the number of people in the
		//first line and m = the number of people in the
		//second line
		//System.out.println(this.toString());
		//System.out.println(otherLine.toString());
		
		
		
		if (this.itemsInLine() < otherLine.itemsInLine()) {
			return -1;
		}
		else if (this.itemsInLine() > otherLine.itemsInLine()) {
			return 1;
		}
		else {
			if (this.getId() < otherLine.getId()) {
				return -1;
			}
			else {
				return 0;
			} 
		}
		
	}
	
	/**
	 * removes one item from the the first person in line 
	 */
	//Processes (removes) one item from the first
	//person in line. If the person has no more
	//items they are removed from the line.
	public void processItem() {
		//O(1)
		//System.out.println(this.element().getNumItems()); 
		if (this.peek() == null) {
			return; 
		} 
		this.element().removeItem(); 
		if (this.element().getNumItems() == 0) {
			this.remove();
		} 
	} 	
	
	/**
	 * converts the line to string 
	 * @return string value of line 
	 */
	
	//Converts the line to a string.
	public String toString() {
		//O(n), where n = the number of people in line
		String n; 
		n = Integer.toString(this.id) + ": ";
		if (this.size() == 0) {
			n = n + "= " + Integer.toString(this.size()) + " shopper(s) with " + this.itemsInLine() + " item(s)";
			return n;
		} 
			
		for(int i = 0 ; i < this.size(); i++){
			n = n + "Person(" + Integer.toString(this.get(i).getNumItems()) + ") ";
		}
		n = n + "= " + Integer.toString(this.size()) + " shopper(s) with " + this.itemsInLine() + " item(s)"; 
			
		return n;
	}
	
	//-------------------------------------------------------------
	// Main Method For Your Testing -- Edit all you want
	//-------------------------------------------------------------
	
	public static void main(String[] args) {
		GroceryLine line = new GroceryLine(0);
		Person mason = new Person(10);
		Person george = new Person(20);
		
		line.offer(mason);
		line.offer(george);
		
		if (line.getId()==0 && line.itemsInLine() == 30){
			System.out.println("Yay 1");
		}
		
		line.processItem();		
		if (line.itemsInLine() == 29 && line.peek().getNumItems()==9){
			System.out.println("Yay 2");
		}

		GroceryLine line2 = new GroceryLine(1);
		Person washington = new Person(40);
		line2.offer(washington);
		
		if (line.compareTo(line2)<0){
			System.out.println("Yay 3");
		}
		//System.out.println(line.toString()); 
	}
}