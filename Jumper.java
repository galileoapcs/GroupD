
import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Jumper extends Bug{
	
	public Jumper()
    {
        setColor(Color.RED);
  
    }
	
	public void act()
    {
		if(canJump())
		{
			jump();
				
		}
		else
		{
			super.act();
		}
    }
	
	
	public void jump() 
	{
		Grid<Actor> gr = getGrid(); 
		if (gr == null) 
			return; 
		Location loc = getLocation(); 
		Location next = loc.getAdjacentLocation(getDirection());
		Location next2 = next.getAdjacentLocation(getDirection());
		if (gr.isValid(next2)) 
			moveTo(next2);
		else
			removeSelfFromGrid();

	}

	public boolean canJump()
	{  
		Grid<Actor> gr = getGrid(); 
		if (gr == null)
			return false; 
		Location loc = getLocation(); 
		Location next = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next)) 
			return false;
		Actor neighbor = gr.get(next);

		Location next2 = next.getAdjacentLocation(getDirection());
		if (!gr.isValid(next2))
			return false;
		neighbor = gr.get(next2);
		return (neighbor == null)||(neighbor instanceof Flower);
	}
	
	//public void move()
	//{
		//Grid<Actor> gr = getGrid();
		//if(gr == null)
			//return;
	//	Location loc = getLocation();
	//	Location next = loc.getAdjacentLocation(getDirection());
	//	Location next2 = next.getAdjacentLocation(getDirection());
	//	if ((gr.isValid(next2)))
	//		return;
	//}

}
