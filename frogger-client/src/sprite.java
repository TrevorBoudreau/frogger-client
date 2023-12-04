/*
 * 
 * 1. Create the class skeleton
 * 2. Identify all class attributes (members, data members)
 * 3. Create getters/setters (accessors/mutators)
 * 4. Create a default constructor
 * 5. Create a secondary constructor(s)
 * 6. print/display function
 * 7. any other code
 * 8. test in a application
 * 
 */


import java.awt.Rectangle;

public class sprite {

	protected int x, y; //upper left, top positions
	protected int height, width;
	protected String image;
	protected Rectangle r;
	
	//default constructor
	public sprite() {
		super();
		r = new Rectangle(0, 0, 0, 0);
	}
	
	//secondary constructor (all fields passed)
	public sprite(int x, int y, int height, int width, String image) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.image = image;
		r = new Rectangle(x,y,width,height);
	}
	
	//getters and setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		this.r.x = this.x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
		this.r.y = this.y;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public Rectangle getRectangle() {
		return this.r;
	}
	
	
}
