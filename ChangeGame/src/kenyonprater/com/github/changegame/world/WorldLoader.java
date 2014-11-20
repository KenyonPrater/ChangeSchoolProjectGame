package kenyonprater.com.github.changegame.world;

import kenyonprater.com.github.changegame.helper.ImageRefs;
import kenyonprater.com.github.changegame.helper.PlayerFactory;
import kenyonprater.com.github.changegame.world.player.Player;

import org.newdawn.slick.Input;

public class WorldLoader {

	public static World createWorld(String[] tileLists, Trigger[] triggers, int state, Input in, int playerstartX, int playerstartY)
	{
		World w = new World(tileLists, ImageRefs.bg[state]);
		Player p;
		
		if(state==1)
		{
			System.out.println(state==1);
			p = PlayerFactory.getChild(w, in);
		}else if(state==2)
		{
			p = PlayerFactory.getStudent(w, in);
		}else
		{
			p = PlayerFactory.getHolden(w, in);
		}
		p.setX(playerstartX);
		p.setY(playerstartY);
		Camera c = new Camera(p, w);
		w.addEntity(p);
		w.addEntity(c);
		w.setCamera(c);
		for(Trigger t: triggers)
		{
			w.addEntity(t);
		}
		return w;
	}
	
}
