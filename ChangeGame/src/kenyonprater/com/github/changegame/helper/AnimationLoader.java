package kenyonprater.com.github.changegame.helper;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class AnimationLoader {

	public static Animation getEmpty()
	{
		try {
			return new Animation(new SpriteSheet("/res/emptyimg.png", 1, 0), 1000);
		} catch (SlickException e) {
			e.printStackTrace();
			return new Animation();
		}
	}
	public static Animation load(String s, int length, int height)
	{
		try {
			return new Animation(new SpriteSheet(s, length, height), 100);
		} catch (SlickException e) {
			e.printStackTrace();
			if(!s.equalsIgnoreCase("/res/testimg.png"))
			{
				System.out.println("file not found:" + s);
				return load("/res/testimg.png",1,1,1000);
			}else{
				System.out.println("something went badly wrong in animation loading.");
				return new Animation();
			}
		}
	}
	public static Animation load(String s, int length, int height, int time)
	{
		try {
			return new Animation(new SpriteSheet(s, length, height), time);
		} catch (SlickException e) {
			e.printStackTrace();
			if(!s.equalsIgnoreCase("/res/testimg.png"))
			{
				return load("/res/testimg.png",1,1,1000);
			}else{
				System.out.println("something went badly wrong in animation loading.");
				return new Animation();
			}
		}
	}
}
