package kenyonprater.com.github.changegame.game;

import org.newdawn.slick.Animation;

public class Entity {

	private Animation sprite;
	private float x;
	private float y;
	private float dx;
	private float dy;

	public Entity(float x, float y, Animation anim)
	{
		this.x = x;
		this.y = y;
		
		this.sprite = anim;
	}

	public void draw()
	{
		sprite.draw(x, y);
	}
	
	public void update(double dt)
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
