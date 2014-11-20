package kenyonprater.com.github.changegame.world;

import java.util.ArrayList;

import kenyonprater.com.github.changegame.launch.Launcher;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class World {

	public ArrayList<Entity> entityList;
	public Image bg;
	public TileMapBlender tiles;
	private Camera c;

	public World(ArrayList<TiledMap> tileList, Image background)
	{
		tiles = tiles;
		bg = background;
		entityList = new ArrayList<Entity>();
	}
	
	public void addEntity(Entity e)
	{
		entityList.add(e);
		e.setWorld(this);
	}
	
	public void popEntity(Entity e)
	{
		entityList.remove(e);
		e.setWorld(null);
	}
	
	public World(String[] tile, String background)
	{
		ArrayList<TiledMap> tileList = new ArrayList<TiledMap>();
		try {
			
			for(int i = 0; i < tile.length; i++)
			{
				tileList.add(new TiledMap(tile[i]));
			}
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tiles = new TileMapBlender(tileList.get(0).getWidth(), tileList.get(0).getHeight(), tileList);
		
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
		tiles.update(delta);
		for (int i = 0; i < entityList.size(); i++)
		{
			entityList.get(i).update(this, delta);
		}
	}
	
	public void draw(Graphics g)
	{
		bg.draw(0, 0, Launcher.WID, Launcher.HEI);
		if(c!=null)
		{c.beginDraw(g);}
		
		
		tiles.render(0, 0);
		for (int i = 0; i < entityList.size(); i++)
		{
			entityList.get(i).draw();
		}
		if(c!=null)
		{c.endDraw(g);}
		
	}
	
	public Camera getCamera() {
		return c;
	}

	public void setCamera(Camera c) {
		this.c = c;
	}
}
