package game_project;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class vehicle extends sprite implements Runnable{

	private Boolean moving;
	private Thread t;
	private JLabel vehicleLabel;
	private frog frog;
	private JLabel frogLabel;
	
	private int step;
	private int direction;
	
	public Boolean getMoving() {
		return moving;
	}
	public void setMoving(Boolean moving) {
		this.moving = moving;
	}
	
	public vehicle() {
		super();
		//vehicleLabel = new JLabel();
		// TODO Auto-generated constructor stub
	}
	
	public vehicle(Boolean moving) {
		super();
		this.moving = moving;
		//vehicleLabel = new JLabel();
	}

	public vehicle(int x, int y, int height, int width, String image, Boolean moving) {
		
		super(x, y, height, width, image);
		this.moving = moving;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//System.out.println("Thread Started");
		
		//set the icons to default
		this.frogLabel.setIcon( 
				new ImageIcon( getClass().getResource("/images/frog.png") ) 
		);
		
		this.vehicleLabel.setIcon( 
				new ImageIcon( getClass().getResource(this.image) ) 
		);
		
		while (this.moving) {
			//moving code
			int x = this.x;
			
			//determine direction of vehicle
			if (direction == 1) {
				x += step;
			} else if (direction == 2){
				x -= step;
			}
			
			//set wrap based on direction
			if ( x >= GameProperties.SCREEN_WIDTH && direction == 1) {
				x = -1 * this.width;
				
			} else if (( x + this.getWidth() <= 0 && direction == 2) ) {
				x = GameProperties.SCREEN_WIDTH;
				
			}
			
			this.setX(x); //this.x = x; do not directly because rectangle doesn't update
						
			vehicleLabel.setLocation(this.x,this.y);
			
			//detect collision between frog && vehicle
			this.detectCollision();
			
			//System.out.println("x + y: " + this.x + "," + this.y);
			
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		//System.out.println("Thread Stopped");
		
	}
	
	//start function to call the thread
	public void startThread() {
		
		//if thread already started, do not run again
		//System.out.println("start thread." + this.moving);
		if ( !this.moving ) {
			
			this.moving = true;
			t = new Thread(this, "vehicle Thread");
			t.start();
		}
	}
	
	public void stopThread() {
		this.moving = false;
		
	}
	
	public void setStep (int temp) {
		this.step = temp;
	}
	
	public void setVehicleLabel(JLabel temp) {
		vehicleLabel = temp;
	}
	
	public void setFrog(frog temp) {
		frog = temp;
	}
	
	public void setFrogLabel(JLabel temp) {
		frogLabel = temp;
	}
	
	public void setDirection(int temp) {
		direction = temp;
	}
	
	private void detectCollision() {
		if ( r.intersects(frog.getRectangle() ) ) {
			System.out.println("COLLISION!");
			this.moving = false;
			
			this.frogLabel.setIcon( 
					new ImageIcon( getClass().getResource("/images/red_frog.png") ) 
			);
				
			this.stopThread(); //stop active thread upon collision
		}
	}
	
}
 