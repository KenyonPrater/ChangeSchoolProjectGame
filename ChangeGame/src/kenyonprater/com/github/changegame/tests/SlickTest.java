package kenyonprater.com.github.changegame.tests;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class SlickTest extends BasicGame
{
	
	public static final int HEI = 480;
	public static final int WID = 640;
	
	public SlickTest(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.drawString("Howdy!", 10, 100);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SlickTest("Simple Slick Game"));
			appgc.setDisplayMode(WID, HEI, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SlickTest.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}