package kenyonprater.com.github.changegame.world;

import kenyonprater.com.github.changegame.game.InGame;
import kenyonprater.com.github.changegame.world.player.Player;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;

public class Trigger extends Entity{

	Input in;
	int rad;
	boolean keypress;
	String msg;
	InGame ig;
	
	public Trigger(float x, float y, int triggerradius, Input in, boolean requireskeypress, String message, World w, InGame ig) {
		super(x, y, new Animation(), w);
		this.in = in;
		this.rad = triggerradius;
		this.keypress = requireskeypress;
		this.msg = message;
		this.ig = ig;
	}
	
	public Trigger(float x, float y, int triggerradius, boolean requireskeypress, String message) {
		super(x, y, new Animation(), null);
		this.in = InGame.in;
		this.rad = triggerradius;
		this.keypress = requireskeypress;
		this.msg = message;
		this.ig = InGame.instance;
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
							ig.handleTrigger(msg);
						}
					}else{
						ig.handleTrigger(msg);
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
