package kenyonprater.com.github.changegame.world.player;

import java.util.ArrayList;

import kenyonprater.com.github.changegame.world.Entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;

public class Player extends Entity {

	private ArrayList<Animation> sprites;
	private Input input;
	
	public Player(float x, float y, ArrayList<Animation> anims, Input in) {
		super(x, y, anims.get(0));
		sprites = anims;
		input = in;
	}
	
	@Override
	public void update(double delta)
	{
		super.update(delta);
		if(input.isKeyDown(input.KEY_LEFT) || input.isKeyDown(input.KEY_A))
		{
			this.setDx((float)Math.max(this.getDx()-800*delta, -150));
			this.setSpriteAsActive(0);
		}
		if(input.isKeyDown(input.KEY_RIGHT) || input.isKeyDown(input.KEY_D))
		{
			this.setDx((float)Math.min(this.getDx()+800*delta, 150));
			this.setSpriteAsActive(1);
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
