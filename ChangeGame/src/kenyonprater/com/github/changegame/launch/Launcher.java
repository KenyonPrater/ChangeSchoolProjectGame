package kenyonprater.com.github.changegame.launch;

import java.util.logging.Level;
import java.util.logging.Logger;

import kenyonprater.com.github.changegame.game.ChangeGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Launcher {
	
	public static String APPNAME = "Change Game for English";
	private static boolean DEBUG = true;
	
	public static final int HEI = 480;
	public static final int WID = 640;
	
	public static void main(String[] args)
	{
		
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new ChangeGame(APPNAME, DEBUG));
			appgc.setDisplayMode(WID, HEI, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(ChangeGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
