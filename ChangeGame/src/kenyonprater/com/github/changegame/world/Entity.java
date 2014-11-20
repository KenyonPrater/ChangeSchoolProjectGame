package kenyonprater.com.github.changegame.world;

import org.newdawn.slick.Animation;

public class Entity {

	private World world;
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	private Animation sprite;
	private float x;
	private float y;
	private float dx;
	private float dy;

	public Entity(float x, float y, Animation anim, World w)
	{
		this.x = x;
		this.y = y;
		world = w;
		this.sprite = anim;
	}

	public void draw()
	{
		sprite.draw(getX(), getY());
	}
	
	public void update(World w, double dt)
	{
		x += (dx*dt);
		y += (dy*dt);
	}
	
	public Animation getSprite() {
		return sprite;
	}

	public void setSprite(Animation sprite) {
		this.sprite = sprite;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}
}
