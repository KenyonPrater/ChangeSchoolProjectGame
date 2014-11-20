package kenyonprater.com.github.changegame.helper;

import java.util.ArrayList;

import kenyonprater.com.github.changegame.world.player.Player;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class PlayerFactory {

	public static Player getChild(Input in)
	{
		ArrayList<Animation> anims = new ArrayList<Animation>();
		for(String s: ImageRefs.child)
		{
			try {
				anims.add(new Animation(new SpriteSheet(s,16,32),250));
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
		Player p = new Player(0, 0, anims, in);
		p.setState(1);
		return p;
	}
	
}
