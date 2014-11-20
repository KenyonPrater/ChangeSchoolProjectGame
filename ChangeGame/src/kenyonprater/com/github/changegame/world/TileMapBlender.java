package kenyonprater.com.github.changegame.world;

import java.util.ArrayList;

import org.lwjgl.Sys;
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
				mapIndex[i][j] = i%2;
				prevMapIndex[i][j] = (i+1)%2;
				fadeTime[i][j] = 1.0f;
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
						System.out.println("Yep");
					}
				}
			}
		}
	}
	
	public void changeTile(int x, int y, int newTileID, float fadeTime)
	{
		
	}
	
	
}
