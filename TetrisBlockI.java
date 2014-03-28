import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.grid.Location;

public class TetrisBlockI extends TetrisBlock {
	public void TetrisBlock(){
		rotationPos = 0;
		gr = TetrisGame.world.getGrid();

		// ==> LAMEST GAME OVER EVER !!! <==
		// if the Grid does not have room for the TetrisBlock.. GameOver
		if (gr.get(new Location(0, 5)) != null
				|| gr.get(new Location(1, 5)) != null) {
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
	}
	public void act() {
		setDirection(180);
		for (TetrisBug tb : blocks)
			tb.setDirection(180);
		if (canMoveDown())
			moveDown();
		else if (!TetrisGame.currentBlock.canMoveDown())
			TetrisGame.nextTetrisBlock();
	}
	
	public void moveDown() {
		if (rotationPos == 0) {
			move();
			blocks.get(0).move();
		} else if (rotationPos == 1) {
			blocks.get(0).move();
			move();
		}
	}
	
	public boolean canMoveDown() {
		if (rotationPos == 0)
			return canMove();
		else if (rotationPos == 1)
			return canMove() && blocks.get(0).canMove();
		else
			return true;
	}
	
	public void moveRight() {
		setDirection(90);
		for (TetrisBug tb : blocks)
			tb.setDirection(90);
		if (rotationPos == 0) {
			if (canMove() && blocks.get(0).canMove()) {
				
				blocks.get(0).move();
				move();
			}
		} else if (rotationPos == 1) {
			if (canMove()) {
				move();
				blocks.get(0).move();
			}
		}
	}
	
	public void moveLeft() {
		setDirection(270);
		for (TetrisBug tb : blocks)
			tb.setDirection(270);
		if (rotationPos == 0) {
			if (canMove() && blocks.get(0).canMove()) {
				blocks.get(0).move();
				move();
			}
		} else if (rotationPos == 1) {
			if (blocks.get(0).canMove()) {
				
				blocks.get(0).move();
				move();
			
			}
		}

	}
	
	public void rotate() {
		Location nextLoc;
		if (rotationPos == 0) {
			// only one block must move
			nextLoc = new Location(getLocation().getRow() - 1, 
					getLocation().getCol() + 1);
			if (gr.isValid(nextLoc) && gr.get(nextLoc) == null) {
				moveTo(nextLoc);
				rotationPos = (rotationPos + 1) % 2;// will be % 4 with 4 blocks
			}
		} else if (rotationPos == 1) {

				nextLoc = new Location(getLocation().getRow() + 1,   //(1,5) +1 =  (1,6)
						getLocation().getCol() - 1);                 //(1,6) -1 =  **(0,6)**
				if (gr.isValid(nextLoc) && gr.get(nextLoc) == null) {
					moveTo(nextLoc);
					rotationPos = (rotationPos + 1) % 2;// will be % 4 with 4 blocks
				}
			
		}

	}


}
