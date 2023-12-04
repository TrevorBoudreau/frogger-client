
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class log extends sprite implements Runnable{

	private Boolean moving;
	private Thread t;
	
	private JLabel logLabel;
	private frog frog;
	private JLabel frogLabel;
	
	private Boolean frogOnLog;
	
	private int step;
	private int direction;
	
	
	public Boolean getMoving() {
		return moving;
	}
	
	public void setMoving(Boolean moving) {
		this.moving = moving;
	}
	
	public log() {
		super();
		// TODO Auto-generated constructor stub
	}
	public log(Boolean moving) {
		super();
		this.moving = moving;
	}
	public log(int x, int y, int height, int width, String image, Boolean moving) {
		
		super(x, y, height, width, image);
		this.moving = moving;
		// TODO Auto-generated constructor stub
	}
	
	//start function to call the thread
	public void startThread() {
			
	//if thread already started, do not run again
	if ( !this.moving ) {
				
		this.moving = true;
		t = new Thread(this, "log Thread");
		t.start();
			
	}
	}
	public void stopThread() {
		this.moving = false;
			
	}
	
	public void setStep (int temp) {
		this.step = temp;
	}
	
	public void setLogLabel(JLabel temp) {
		logLabel = temp;
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
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//System.out.println("Thread Started");
		
		//set the icons to default
		this.frogLabel.setIcon( 
				new ImageIcon( getClass().getResource("/images/frog.png") ) 
		);
		
		this.logLabel.setIcon( 
				new ImageIcon( getClass().getResource(this.image) ) 
		);
		
		this.frogOnLog = true;
		
		while (this.moving) {
			//moving code
			int x = this.x;
			
			//determine direction of log
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
			logLabel.setLocation(this.x,this.y);
			
			//detect collision between frog && log
			//this.detectCollision();
			if (frog.getY() < 400 && frog.getY() >= 100) {this.detectCollision();}
			
			
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void detectCollision() {
			
			if ( (r.intersects(frog.getRectangle() ) ) == false ) {
				
				this.frogOnLog = false;
				
			} else {this.frogOnLog = true;}
			
			if (frogOnLog == true) {
				
				if (direction == 1) {
					frog.setX( frog.getX() + step);
					frogLabel.setLocation(frog.getX(), frog.getY() );
				}
				else if (direction == 2) {
					frog.setX( frog.getX() - step);
					frogLabel.setLocation(frog.getX(), frog.getY() );
				}
				
			}
		
	}
	
	public Boolean getFrogOnLog() {
		return frogOnLog;
	}

}
