import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;

public class TetrisBug extends Bug{
	public TetrisBug(Color bugColor)
	{
		super.getColor();
		setDirection(getDirection() + Location.SOUTH); 
	}

	public void move()
	{
		Grid<Actor> gr = getGrid(); 
		 if (gr == null) 
		 return; 
		 Location loc = getLocation(); 
		 Location next = loc.getAdjacentLocation(getDirection()); 
		 if (gr.isValid(next)) 
		 moveTo(next); 
		 else 
		 removeSelfFromGrid(); 
	}
	
	public void act()
	{
		
	}
	
	
}

/**
I'm so done with group projects
done
done
done
done
whywhyvwhywhywhywhy
**/