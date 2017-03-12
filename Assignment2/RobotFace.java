import java.awt.*;
import acm.graphics.*;
import acm.program.*;

public class RobotFace extends GraphicsProgram{

	private static final int HEAD_WIDTH = 200;
	private static final int HEAD_HEIGHT = 350;
	
	private static final int EYE_RADIUS = 30;
	
	private static final int MOUTH_WIDTH = 150;
	private static final int MOUTH_HEIGHT = 40;
	
	public void run() {
		
		int xMid = getWidth() / 2;
		int yMid = getHeight() / 2;
		
		GRect face = new GRect(xMid - HEAD_WIDTH / 2, yMid - HEAD_HEIGHT / 2, HEAD_WIDTH, HEAD_HEIGHT);
		face.setFilled(true);
		face.setFillColor(Color.GRAY);
		add(face);
		GOval eyeLeft = new GOval(xMid - HEAD_WIDTH / 4 - EYE_RADIUS, yMid - HEAD_HEIGHT / 4 - EYE_RADIUS, EYE_RADIUS * 2, EYE_RADIUS * 2);
		GOval eyeRight = new GOval(xMid + HEAD_WIDTH / 4 - EYE_RADIUS, yMid - HEAD_HEIGHT / 4 - EYE_RADIUS, EYE_RADIUS * 2, EYE_RADIUS * 2);
		
		eyeLeft.setFilled(true);
		eyeLeft.setFillColor(Color.YELLOW);
		eyeLeft.setColor(Color.YELLOW);
		add(eyeLeft);
		
		eyeRight.setFilled(true);
		eyeRight.setFillColor(Color.YELLOW);
		eyeRight.setColor(Color.YELLOW);
		add(eyeRight);
		
		GRect mouth = new GRect(xMid - MOUTH_WIDTH / 2 , yMid + HEAD_HEIGHT / 4 , MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setFillColor(Color.WHITE);
		mouth.setColor(Color.WHITE);
		add(mouth);
	}
}
