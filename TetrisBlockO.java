import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.grid.Location;


public class TetrisBlockO extends TetrisBlock {
	public TetrisBlockO(){
		super.act();
		setDirection(getDirection() + Location.SOUTH); 
	}
	
	public void TetrisBlock(){
		gr = TetrisGame.world.getGrid();

		// ==> LAMEST GAME OVER EVER !!! <==
		// if the Grid does not have room for the TetrisBlock.. GameOver
		if (gr.get(new Location(0, 5)) != null
				|| gr.get(new Location(1, 5)) != null 
				|| gr.get(new Location(0,6)) != null
				|| gr.get(new Location(1,6)) != null) {
			javax.swing.JOptionPane.showMessageDialog(null, "Score: "
					+ TetrisGame.score, "GAME OVER!", 0);
			System.exit(0);
		}
		putSelfInGrid(gr, new Location(1, 5));

		blocks = new ArrayList<TetrisBug>();
		TetrisBug a;
		// create TetrisBugs for ArrayList blocks and put them in Grid gr
		a = new TetrisBug(Color.blue);
		a.putSelfInGrid(gr, new Location(0, 5));
		blocks.add(a);
		
		// TetrisBlock subclasses will add two more TetrisBug objects to blocks
		TetrisBug b;
		b = new TetrisBug(Color.blue);
		b.putSelfInGrid(gr, new Location(0, 6));
		blocks.add(b);
		TetrisBug c;
		c = new TetrisBug(Color.blue);
		c.putSelfInGrid(gr, new Location(1, 6));
		blocks.add(c);
		

	}
	
	
	public void act(){
		setDirection(180);
		for (TetrisBug tb : blocks)
			tb.setDirection(180);
		if (canMoveDown())
			moveDown();
		else if (!TetrisGame.currentBlock.canMoveDown())
			TetrisGame.nextTetrisBlock();
		
	}
	
	public void moveDown(){
		blocks.get(0).move();

		
	}
	
	public boolean canMoveDown(){
		if (rotationPos == 0)
			return canMove();
		else
			return true;	
	}
	
	public void moveRight(){
		setDirection(90);
		for (TetrisBug tb : blocks)
			tb.setDirection(90);
	}
	
	public void moveLeft(){
		setDirection(270);
		for (TetrisBug tb : blocks)
			tb.setDirection(270);
		
	}
	public void rotate() {


	}
	
	
}
