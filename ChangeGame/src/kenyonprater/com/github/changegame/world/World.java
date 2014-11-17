package kenyonprater.com.github.changegame.world;

import java.util.ArrayList;

import kenyonprater.com.github.changegame.helper.AnimationLoader;
import kenyonprater.com.github.changegame.launch.Launcher;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class World {

	public ArrayList<Entity> entityList;
	public Image bg;
	public TiledMap tileMap;
	
	public World(TiledMap tile, Image background)
	{
		tileMap = tile;
		bg = background;
		entityList = new ArrayList<Entity>();
	}
	
	public void addEntity(Entity e)
	{
		entityList.add(e);
	}
	
	public void popEntity(Entity e)
	{
		entityList.remove(e);
	}
	
	public World(String tile, String background)
	{
		try {
			tileMap = new TiledMap(tile);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bg = new Image(background);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entityList = new ArrayList<Entity>();
	}
	
	public void update(double delta)
	{
		for (int i = 0; i < entityList.size(); i++)
		{
			entityList.get(i).update(delta);
		}
	}
	
	public void draw()
	{
		bg.draw(0, 0, Launcher.WID, Launcher.HEI);
		tileMap.render(0, 0);
		for (int i = 0; i < entityList.size(); i++)
		{
			entityList.get(i).draw();
		}
		
	}
	
}
