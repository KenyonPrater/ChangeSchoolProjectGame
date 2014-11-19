package kenyonprater.com.github.changegame.world;

import java.util.ArrayList;

import org.newdawn.slick.tiled.TiledMap;

public class TileMapBlender {

	private ArrayList<TiledMap> maps = new ArrayList<TiledMap>();
	public final int width;
	public final int height;
	
	private int[][] mapIndex;
	private int[][] prevMapIndex;
	private float[][] fadeTime;
	
	public TileMapBlender(int w, int h, ArrayList<TiledMap> maplist)
	{
		width = w;
		height = h;
		maps = maplist;
		
		mapIndex = new int[w][h];
		prevMapIndex = new int[w][h];
		fadeTime = new float[w][h];
		
		for(int i = 0; i < mapIndex.length; i++)
		{
			for(int j = 0; j < mapIndex[0].length; j++)
			{
				mapIndex[i][j] = i%2;
				fadeTime[i][j] = 0.0f;
			}
		}
		
	}
	
	public void render(int x, int y)
	{
		for(int layer = 0; layer < maps.get(0).getLayerCount(); layer++)
		{
			for(int i = 0; i < mapIndex.length; i++)
			{
				for(int j = 0; j < mapIndex[0].length; j++)
				{
					maps.get(mapIndex[i][j]).getTileImage(i, j, layer).draw(x+maps.get(0).getTileWidth()*i, y+maps.get(0).getTileHeight()*j);
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
				}
			}
		}
	}
	
	
}
