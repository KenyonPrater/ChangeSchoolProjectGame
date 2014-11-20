package kenyonprater.com.github.changegame.game;

import java.util.ArrayList;

import kenyonprater.com.github.changegame.helper.AnimationLoader;
import kenyonprater.com.github.changegame.helper.PlayerFactory;
import kenyonprater.com.github.changegame.helper.WorldRefs;
import kenyonprater.com.github.changegame.world.Trigger;
import kenyonprater.com.github.changegame.world.World;
import kenyonprater.com.github.changegame.world.WorldLoader;
import kenyonprater.com.github.changegame.world.player.Player;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class InGame extends BasicGameState{

	private static int ID;
	private World w;
	private Input in;
	
	InGame(int id)
	{
		super();
		ID = id;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		WorldRefs.init();
		w = WorldLoader.createWorld(WorldRefs.hosproom, 2, container.getInput(), 64, 400);
		w.addEntity(new Trigger(400,400,20,container.getInput(), true, "GOTO hosproom 400 400 3", w, this));
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
		in = container.getInput();
	}
	
	@Override
	public int getID() {
		return 1;
	}

	public void handleTrigger(String msg) {
		if( msg.contains("GOTO"))
		{
			String[] args = msg.split(" ");
			int x = Integer.parseInt(args[2]);
			int y = Integer.parseInt(args[3]);
			String map = args[1];
			int state = Integer.parseInt(args[4]);
			w = WorldLoader.createWorld(WorldRefs.refs.get(map), state, in, x, y);
		}
	}

}
