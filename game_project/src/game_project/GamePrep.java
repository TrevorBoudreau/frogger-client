package game_project;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GamePrep extends JFrame implements KeyListener, ActionListener{
	
	private frog frog;
	private vehicle vehicle1[], vehicle2[], vehicle3[];
	private log log1[], log2[], log3[];
	
	private Container content;
	private JLabel backgroundLabel;
	private JLabel frogLabel;
	private JLabel vehicleLabel1[], vehicleLabel2[], vehicleLabel3[];
	private JLabel logLabel1[], logLabel2[], logLabel3[];
	private ImageIcon frogImage, vehicleImage, vehicleImage2, logImage, backgroundImage;
	
	private JButton restartButton;
	
	//score variables
	private JLabel scoreLabel;
	private int score;
	
	public GamePrep() {
		//set up the screen
		setSize(GameProperties.SCREEN_WIDTH, GameProperties.SCREEN_HEIGHT);
		
		content = getContentPane();
		content.setBackground(Color.gray);
		setLayout(null);
		backgroundImage = new ImageIcon(
				getClass().getResource("/images/background.png" )
		);
		backgroundLabel = new JLabel();
		backgroundLabel.setIcon( backgroundImage );
		backgroundLabel.setSize( GameProperties.SCREEN_WIDTH, GameProperties.SCREEN_HEIGHT );
		backgroundLabel.setLocation( 0, 0 );
		
		//set up score label
		score = 0;
		scoreLabel = new JLabel("Score: " + score);
		scoreLabel.setSize( 150, 100 );
		scoreLabel.setLocation(0,0);
		
		//setup frog (user sprite)
		frog = new frog(400, GameProperties.SCREEN_HEIGHT - 200, 100, 90, "frog.png");
		
		frogLabel = new JLabel();
		frogImage = new ImageIcon(
				getClass().getResource("/images/" + frog.getImage() )
		);
		frogLabel.setIcon( frogImage );
		frogLabel.setSize( frog.getWidth(), frog.getHeight() );
		frogLabel.setLocation( frog.getX(), frog.getY() );

		/* (commented out for now as it is redundant with constructor used above)
		frog.setX (100);
		frog.setY(GameProperties.SCREEN_HEIGHT - 200);
		frog.setWidth(90);
		frog.setHeight(100);
		frog.setImage("frog.png");
		*/
		
		//restart button
		restartButton = new JButton("Restart");
		restartButton.setSize(100,100);
		restartButton.setLocation(GameProperties.SCREEN_WIDTH - 100, GameProperties.SCREEN_HEIGHT - 200);
		restartButton.setFocusable(false);
		restartButton.setVisible(false);
		
		//setup 3 vehicle arrays
		vehicleImage = new ImageIcon("/images/blue_car.png");
		vehicleImage2 = new ImageIcon("/images/blue_car_backward.png");
		vehicle1 = new vehicle[4];
		vehicleLabel1 = new JLabel[4];
		for (int i = 0; i < vehicle1.length; i++) {
			//initialize all vehicle objects in array
			vehicle1[i] = new vehicle((i * 300), GameProperties.SCREEN_HEIGHT - 300, 100, 100, "/images/blue_car.png", false);
			vehicle1[i].setFrog(frog); //initialize the frog member of vehicle for collision detection
			vehicle1[i].setStep(GameProperties.CHARACTER_STEP);
			vehicle1[i].setDirection(1);
			
			//initialize all vehicle labels in array
			vehicleLabel1[i] = new JLabel();
			vehicleLabel1[i].setIcon( vehicleImage );
			vehicleLabel1[i].setSize( vehicle1[i].getWidth(), vehicle1[i].getHeight() );
			vehicleLabel1[i].setLocation( vehicle1[i].getX(), vehicle1[i].getY() );
			
			vehicle1[i].setVehicleLabel(vehicleLabel1[i]);
			vehicle1[i].setFrogLabel(frogLabel);
		}
		
		vehicle2 = new vehicle[4];
		vehicleLabel2 = new JLabel[4];
		for (int i = 0; i < vehicle2.length; i++) {
			//initialize all vehicle objects in array
			vehicle2[i] = new vehicle((i * 300), GameProperties.SCREEN_HEIGHT - 400, 100, 100, "/images/blue_car_backward.png", false);
			vehicle2[i].setFrog(frog); //initialize the frog member of vehicle for collision detection
			vehicle2[i].setStep(GameProperties.CHARACTER_STEP_FAST);
			vehicle2[i].setDirection(2);
			
			//initialize all vehicle labels in array
			vehicleLabel2[i] = new JLabel();
			vehicleLabel2[i].setIcon( vehicleImage2 );
			vehicleLabel2[i].setSize( vehicle2[i].getWidth(), vehicle2[i].getHeight() );
			vehicleLabel2[i].setLocation( vehicle2[i].getX(), vehicle2[i].getY() );
			
			vehicle2[i].setVehicleLabel(vehicleLabel2[i]);
			vehicle2[i].setFrogLabel(frogLabel);
		}
		
		vehicle3 = new vehicle[4];
		vehicleLabel3 = new JLabel[4];
		for (int i = 0; i < vehicle3.length; i++) {
			//initialize all vehicle objects in array
			vehicle3[i] = new vehicle((i * 300), GameProperties.SCREEN_HEIGHT - 500, 100, 100, "/images/blue_car.png", false);
			vehicle3[i].setFrog(frog); //initialize the frog member of vehicle for collision detection
			vehicle3[i].setStep(GameProperties.CHARACTER_STEP);
			vehicle3[i].setDirection(1);
			
			//initialize all vehicle labels in array
			vehicleLabel3[i] = new JLabel();
			vehicleLabel3[i].setIcon( vehicleImage );
			vehicleLabel3[i].setSize( vehicle3[i].getWidth(), vehicle3[i].getHeight() );
			vehicleLabel3[i].setLocation( vehicle3[i].getX(), vehicle3[i].getY() );
			
			vehicle3[i].setVehicleLabel(vehicleLabel3[i]);
			vehicle3[i].setFrogLabel(frogLabel);
		}
		
		//setup log arrays
		logImage = new ImageIcon("/images/log.png");
		log1 = new log[4];
		logLabel1 = new JLabel[4];
		for ( int i=0; i < log1.length; i++ ) {
			//set up the logs in array
			log1[i] = new log( (i* 300),GameProperties.SCREEN_HEIGHT - 700, 100, 100, "/images/log.png", false);
			log1[i].setFrog(frog); //set frog member of log object
			log1[i].setStep(GameProperties.CHARACTER_STEP);
			log1[i].setDirection(1);
			
			//initialize log labels in array
			logLabel1[i] = new JLabel();
			logLabel1[i].setIcon( logImage );
			logLabel1[i].setSize( log1[i].getWidth(), log1[i].getHeight() );
			logLabel1[i].setLocation( log1[i].getX(), log1[i].getY() );
			
			log1[i].setLogLabel(logLabel1[i]);
			log1[i].setFrogLabel(frogLabel);
		}
		
		log2 = new log[4];
		logLabel2 = new JLabel[4];
		for ( int i=0; i < log2.length; i++ ) {
			//set up the logs in array
			log2[i] = new log( (i* 300),GameProperties.SCREEN_HEIGHT - 800, 100, 100, "/images/log.png", false);
			log2[i].setFrog(frog); //set frog member of log object
			log2[i].setStep(GameProperties.CHARACTER_STEP_FAST);
			log2[i].setDirection(2);
			
			//initialize log labels in array
			logLabel2[i] = new JLabel();
			logLabel2[i].setIcon( logImage );
			logLabel2[i].setSize( log2[i].getWidth(), log2[i].getHeight() );
			logLabel2[i].setLocation( log2[i].getX(), log2[i].getY() );
			
			log2[i].setLogLabel(logLabel2[i]);
			log2[i].setFrogLabel(frogLabel);
		}
		
		log3 = new log[4];
		logLabel3 = new JLabel[4];
		for ( int i=0; i < log3.length; i++ ) {
			//set up the logs in array
			log3[i] = new log( (i* 300),GameProperties.SCREEN_HEIGHT - 900, 100, 100, "/images/log.png", false);
			log3[i].setFrog(frog); //set frog member of log object
			log3[i].setStep(GameProperties.CHARACTER_STEP);
			log3[i].setDirection(1);
			
			//initialize log labels in array
			logLabel3[i] = new JLabel();
			logLabel3[i].setIcon( logImage );
			logLabel3[i].setSize( log3[i].getWidth(), log3[i].getHeight() );
			logLabel3[i].setLocation( log3[i].getX(), log3[i].getY() );
			
			log3[i].setLogLabel(logLabel3[i]);
			log3[i].setFrogLabel(frogLabel);
		}
		
		//populate screen
		restartButton.addActionListener(this);
		add(restartButton);
		add(frogLabel);
		for (int i = 0; i < vehicle1.length; i++) {
			add(vehicleLabel1[i]);
			add(vehicleLabel2[i]);
			add(vehicleLabel3[i]);
			add(logLabel1[i]);
			add(logLabel2[i]);
			add(logLabel3[i]);
		}
		add(scoreLabel);
		add(backgroundLabel);
		
		
		content.addKeyListener(this);
		content.setFocusable(true); //allows keys to always work within window
		
		// start threads
		for (int i = 0; i < vehicle1.length; i++) {
			vehicle1[i].startThread();
			vehicle2[i].startThread();
			vehicle3[i].startThread();
			log1[i].startThread();
			log2[i].startThread();
			log3[i].startThread();
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GamePrep myGame = new GamePrep();
		myGame.setVisible(true);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		//get current position (will need to be updated later)
		int x = frog.getX();
		int y = frog.getY();
		
		//detect direction & modify coordinates
			if ( e.getKeyCode()==KeyEvent.VK_UP) {
				
				y -= GameProperties.FROG_STEP;
				
				if (y + frog.getHeight() < 0) {
					y = GameProperties.SCREEN_HEIGHT;
				}
				
			} else if ( e.getKeyCode()==KeyEvent.VK_DOWN) {
				
				y += GameProperties.FROG_STEP;
				
				if (y >= GameProperties.SCREEN_HEIGHT) {
					y = -1 * frog.getHeight();
				}
				
			} else if ( e.getKeyCode()==KeyEvent.VK_LEFT) {
		
				x -= GameProperties.FROG_STEP;
				
				if (x + frog.getWidth() < 0) {
					x = GameProperties.SCREEN_WIDTH;
				}
				
			} else if ( e.getKeyCode()==KeyEvent.VK_RIGHT) {
				
				x += GameProperties.FROG_STEP;
				
				if (x >= GameProperties.SCREEN_WIDTH) {
					x = -1 * frog.getWidth();
				}
				
			} else {
				System.out.println("Invalid Operation");
				return;
			}
			
			//set the new coordinates in object
			frog.setX(x);
			frog.setY(y);

			frogLabel.setLocation(frog.getX(), frog.getY() );
			
			System.out.println("x + y: " + frog.getX() + "," + frog.getY());
		}

	@Override
	public void keyReleased(KeyEvent e) {
		
		Boolean logFlag = false;
		
		for (int i = 0; i < log1.length; i++) {
			if (log1[i].getFrogOnLog() == true || log2[i].getFrogOnLog() == true || log3[i].getFrogOnLog() == true) {
				logFlag = true;
				break;
			}
		}
		
		//stop game if frog makes a collision
		for (int i = 0; i < vehicle1.length; i++) {
			
			if (vehicle1[i].getMoving() == false || vehicle2[i].getMoving() == false || vehicle3[i].getMoving() == false || logFlag == false) {
				stopGame();
				break;
			}
			
		}
		
		if (frog.getY() == 0) {
			System.out.println("END ZONE FLAG");
			winGame();
			}
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == restartButton){
			//restart game to initial state
			restartGame();
			}
		}
		
	
	public void stopGame() {
		for (int j = 0; j < vehicle1.length; j++) {
			vehicle1[j].stopThread();
			vehicle2[j].stopThread();
			vehicle3[j].stopThread();
			log1[j].stopThread();
			log2[j].stopThread();
			log3[j].stopThread();
			frogLabel.setIcon( 
					new ImageIcon( getClass().getResource("/images/red_frog.png") ) 
			);
		}
		
		if (score > 0 ) {
			score = score - 50;
			scoreLabel.setText("Score: " + score);
		}
	
		restartButton.setVisible(true);
	}
	
	public void winGame() {
		
		for (int j = 0; j < vehicle1.length; j++) {
			vehicle1[j].stopThread();
			vehicle2[j].stopThread();
			vehicle3[j].stopThread();
			log1[j].stopThread();
			log2[j].stopThread();
			log3[j].stopThread();
		}
		
		score = score + 50;
		scoreLabel.setText("Score: " + score);
	
		restartButton.setVisible(true);
	}
	

	public void restartGame() {
		//reset frog and frog label position
		frog.setX(100);
		frog.setY(GameProperties.SCREEN_HEIGHT - 200);
		frogLabel.setLocation( frog.getX(), frog.getY() );
		
		//RESET CARS
		//vehicle arrays
		for (int i = 0; i < vehicle1.length; i++) {
			
			vehicle1[i].setX(i*300);
			vehicle1[i].setY(GameProperties.SCREEN_HEIGHT - 300);
	        vehicleLabel1[i].setLocation(vehicle1[i].getX(), vehicle1[i].getY());
	        vehicle1[i].setVehicleLabel(vehicleLabel1[i]);
			vehicle1[i].setFrogLabel(frogLabel);
			vehicle1[i].startThread();
			
			vehicle2[i].setX(i*300);
			vehicle2[i].setY(GameProperties.SCREEN_HEIGHT - 400);
	        vehicleLabel2[i].setLocation(vehicle2[i].getX(), vehicle2[i].getY());
	        vehicle2[i].setVehicleLabel(vehicleLabel2[i]);
			vehicle2[i].setFrogLabel(frogLabel);
			vehicle2[i].startThread();
			
			vehicle3[i].setX(i*300);
			vehicle3[i].setY(GameProperties.SCREEN_HEIGHT - 500);
	        vehicleLabel3[i].setLocation(vehicle3[i].getX(), vehicle3[i].getY());
	        vehicle3[i].setVehicleLabel(vehicleLabel3[i]);
			vehicle3[i].setFrogLabel(frogLabel);
			vehicle3[i].startThread();
			
			log1[i].setX(i*300);
			log1[i].setY(GameProperties.SCREEN_HEIGHT - 700);
			logLabel1[i].setLocation(log1[i].getX(), log1[i].getY());
	        log1[i].setLogLabel(logLabel1[i]);
	        log1[i].setFrogLabel(frogLabel);
	        log1[i].startThread();
	        
	        log2[i].setX(i*300);
			log2[i].setY(GameProperties.SCREEN_HEIGHT - 800);
			logLabel2[i].setLocation(log2[i].getX(), log2[i].getY());
	        log2[i].setLogLabel(logLabel2[i]);
	        log2[i].setFrogLabel(frogLabel);
	        log2[i].startThread();
	        
	        log3[i].setX(i*300);
			log3[i].setY(GameProperties.SCREEN_HEIGHT - 900);
			logLabel3[i].setLocation(log3[i].getX(), log3[i].getY());
	        log3[i].setLogLabel(logLabel3[i]);
	        log3[i].setFrogLabel(frogLabel);
	        log3[i].startThread();
			
	    }
		
		restartButton.setVisible(false);
		
	}
	
}


