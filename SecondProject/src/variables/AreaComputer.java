package variables;

public class AreaComputer {
	
	  /** Main method */
	  public static void main(String[] args) {
		final double PI = 3.14159; 
		final int SIZE = 32;

	    double area;
	       
	    
	    // Compute area
	    area = SIZE * SIZE * PI;
	    
	    // Display results
	    System.out.println("The area for the circle of radius " +
	    		SIZE + " is " + area);
	  }
	}
