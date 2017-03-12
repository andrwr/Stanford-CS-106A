
import acm.graphics.*;
import acm.program.*;

public class CheckBoard extends GraphicsProgram{

	private static final int NROWS = 8;
	private static final int NCOLUMNS = 8;
	
	public void run() {
		int sqSize = getHeight() / NROWS ;
		for (int i = 0; i < NCOLUMNS; i++) {
			for (int j = 0; j < NROWS; j++) {
				GRect sq = new GRect(j * sqSize, i * sqSize, sqSize, sqSize);
				sq.setFilled((i + j) % 2 != 0);
				add(sq);
			}
		}
	}
	
}
