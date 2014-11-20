package kenyonprater.com.github.changegame.game;

import java.util.ArrayList;

import kenyonprater.com.github.changegame.helper.AnimationLoader;
import kenyonprater.com.github.changegame.helper.PlayerFactory;
import kenyonprater.com.github.changegame.world.World;
import kenyonprater.com.github.changegame.world.player.Player;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class InGame extends BasicGameState{

	private static int ID;
	private World w;
	
	InGame(int id)
	{
		super();
		ID = id;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		w = new World(new String[]{"/res/lvl/1-2.tmx","/res/lvl/3-10.tmx"}, "/res/bg/child.png");
		Player p = PlayerFactory.getChild(w,container.getInput());
		p.setX(0);
		p.setY(400);
		w.addEntity(p);
		Camera c = new Camera(p,w);
		w.addEntity(c);
		w.setCamera(c);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		w.draw(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		w.update(delta/1000.0);
	}
	
	@Override
	public int getID() {
		return 1;
	}

}
