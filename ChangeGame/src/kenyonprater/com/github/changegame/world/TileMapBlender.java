package kenyonprater.com.github.changegame.world;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;

public class TileMapBlender {

	private ArrayList<TiledMap> maps = new ArrayList<TiledMap>();
	public final int width;
	public final int height;
	
	private int[][] mapIndex;
	private int[][] prevMapIndex;
	private float[][] fadeTime;
	private float maxFadeTime;
	
	public TileMapBlender(int w, int h, ArrayList<TiledMap> maplist, float fade)
	{
		width = w;
		height = h;
		maps = maplist;
		maxFadeTime = fade;
		
		mapIndex = new int[w][h];
		prevMapIndex = new int[w][h];
		fadeTime = new float[w][h];
		
		for(int i = 0; i < mapIndex.length; i++)
		{
			for(int j = 0; j < mapIndex[0].length; j++)
			{
				mapIndex[i][j] = 0;
				prevMapIndex[i][j] = 0;
				fadeTime[i][j] = 0.0f;
			}
		}
		
	}
	
	public TileMapBlender(int w, int h, ArrayList<TiledMap> maplist)
	{
		this(w, h, maplist, .5f);
	}
	
	public void render(int x, int y)
	{
		for(int layer = 0; layer < maps.get(0).getLayerCount(); layer++)
		{
			for(int i = 0; i < mapIndex.length; i++)
			{
				for(int j = 0; j < mapIndex[0].length; j++)
				{
					Image tile = maps.get(mapIndex[i][j]).getTileImage(i, j, layer);
					tile.draw(x+maps.get(0).getTileWidth()*i, y+maps.get(0).getTileHeight()*j);
					Image oldtile = maps.get(prevMapIndex[i][j]).getTileImage(i, j, layer);
					oldtile.draw(x+maps.get(0).getTileWidth()*i, y+maps.get(0).getTileHeight()*j, new Color(1,1,1,this.fadeTime[i][j]/this.maxFadeTime));
					
				}
			}
		}
	}
	
	public void update(double delta)
	{
		for(int i = 0; i < mapIndex.length; i++)
		{
			for(int j = 0; j < mapIndex[0].length; j++)
			{
				if(fadeTime[i][j] != 0)
				{
					fadeTime[i][j] = (float) Math.max(fadeTime[i][j]-delta, 0);
					if(fadeTime[i][j] == 0)
					{
						prevMapIndex[i][j] = mapIndex[i][j];
					}
				}
			}
		}
	}
	
	public void changeTile(int x, int y, int newTileID)
	{
		if(mapIndex[x][y] != newTileID)
		{
			
			prevMapIndex[x][y] = mapIndex[x][y];
			mapIndex[x][y] = newTileID;
			fadeTime[x][y] = maxFadeTime;
		}
	}
	
	public void changeAllTileInArea(int centerX, int centerY, int size, int newTileID)
	{
		System.out.println(this.getTileWidth());
		for(int x = centerX-size; x <= centerX+size; x++)
		{
			for(int y = centerY-size; y <= centerY+size; y++)
			{
				if(x >= 0 && x < mapIndex.length && y >=0 && y < mapIndex[0].length)
				{
					changeTile(x, y, newTileID);
				}
			}
		}
	}
	
	public int getTileHeight()
	{
		return maps.get(0).getTileHeight();
	}
	public int getTileWidth()
	{
		return maps.get(0).getTileWidth();
	}
}
