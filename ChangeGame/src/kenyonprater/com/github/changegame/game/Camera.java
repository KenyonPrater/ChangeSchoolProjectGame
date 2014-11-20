package kenyonprater.com.github.changegame.game;

import kenyonprater.com.github.changegame.launch.Launcher;
import kenyonprater.com.github.changegame.world.Entity;
import kenyonprater.com.github.changegame.world.World;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

public class Camera extends Entity{

	public Entity target;
	
	

	public Camera(float x, float y, World w) {
		super(x, y, new Animation(), w);
		target = null;
	}

	public Camera(Entity target, World w)
	{
		super(target.getX(), target.getY(), new Animation(), w);
		this.target = target;
	}
	public void draw()
	{
		return;
	}
	public void update(World w, double delta)
	{
		super.update(w, delta);
		if(target!=null)
		{
			System.out.println(Launcher.WID/2);
			this.setX(Math.min(Math.max(target.getX(),Launcher.WID/2),w.tiles.width*w.tiles.getTileWidth()-Launcher.WID/2));
			this.setY(target.getY());
		}
	}
	public void beginDraw(Graphics g)
	{
		g.pushTransform();
		g.translate(-this.getX()+Launcher.WID/2, 0);//+1/2*Launcher.WID+1/2*Launcher.HEI
	}
	public void endDraw(Graphics g)
	{
		g.popTransform();
	}
	public Entity getTarget() {
		return target;
	}

	public void setTarget(Entity target) {
		this.target = target;
	}
}
