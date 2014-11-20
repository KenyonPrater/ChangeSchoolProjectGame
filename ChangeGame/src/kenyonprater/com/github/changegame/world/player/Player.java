package kenyonprater.com.github.changegame.world.player;

import java.util.ArrayList;

import kenyonprater.com.github.changegame.world.Entity;
import kenyonprater.com.github.changegame.world.World;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;

public class Player extends Entity {

	private ArrayList<Animation> sprites;
	private Input input;
	private boolean facing; //right == true
	private int state = 1;
	private boolean debugfollow = true;
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Player(float x, float y, ArrayList<Animation> anims, World w, Input in) {
		super(x, y, anims.get(0), w);
		sprites = anims;
		input = in;
		facing = true;
	}
	
	@Override
	public void update(World w, double delta)
	{
		w.tiles.changeAllTileInArea((int)(this.getX()/w.tiles.getTileWidth()), (int)(this.getY()/w.tiles.getTileHeight()), 5, state);
		
		
		super.update(w, delta);
		if(input.isKeyDown(input.KEY_LEFT) || input.isKeyDown(input.KEY_A))
		{
			this.setDx((float)Math.max(this.getDx()-3*800*delta, 3*-150));
			this.setSpriteAsActive(0);
			facing = false;
		}
		if(input.isKeyDown(input.KEY_RIGHT) || input.isKeyDown(input.KEY_D))
		{
			this.setDx((float)Math.min(this.getDx()+3*800*delta, 3*150));
			this.setSpriteAsActive(1);
			facing = true;
		}
		if(!(input.isKeyDown(input.KEY_RIGHT) || input.isKeyDown(input.KEY_D))&&!(input.isKeyDown(input.KEY_LEFT) || input.isKeyDown(input.KEY_A)))
		{
			if(facing)
			{
				this.setSpriteAsActive(3);
			}else{
				this.setSpriteAsActive(2);
			}
		}
		
		this.setDx(getDx()*(1-(float)delta*6));
	}
	
	public void addSprite(Animation a)
	{
		sprites.add(a);
	}
	
	public Animation getSprite(int index)
	{
		return sprites.get(index);
	}
	
	public void setSpriteAsActive(int index)
	{
		this.setSprite(sprites.get(index));
	}

}
