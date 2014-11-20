package kenyonprater.com.github.changegame.helper;

import kenyonprater.com.github.changegame.world.Entity;
import kenyonprater.com.github.changegame.world.World;
import kenyonprater.com.github.changegame.world.player.Player;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;

public class Trigger extends Entity{

	Input in;
	int rad;
	boolean keypress;
	String msg;
	
	public Trigger(float x, float y, int triggerradius, Input in, boolean requireskeypress, String message, World w) {
		super(x, y, new Animation(), w);
		this.in = in;
		this.rad = triggerradius;
		this.keypress = requireskeypress;
		this.msg = message;
	}

	@Override
	public void update(World w, double dt)
	{
		for(int i = 0; i < w.entityList.size(); i++)
		{
			if(w.entityList.get(i) instanceof Player)
			{
				Player p = (Player)w.entityList.get(i);
				if(Math.abs(p.getX()-this.getX())<rad)
				{
					if(keypress)
					{
						if(in.isKeyDown(in.KEY_DOWN))
						{
							System.out.println("Triggers work, now use them");
						}
					}else{
						System.out.println("Triggers work, now use them");
					}
				}
			}
		}
	}
	
	@Override
	public void draw()
	{
		return;
	}
	
}
