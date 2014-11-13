package kenyonprater.com.github.changegame.launch;

import java.util.logging.Level;
import java.util.logging.Logger;

import kenyonprater.com.github.changegame.game.ChangeGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Launcher {
	
	public static String APPNAME = "Change Game for English";
	private boolean DEBUG = false;
	
	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new ChangeGame(APPNAME, DEBUG));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(ChangeGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
