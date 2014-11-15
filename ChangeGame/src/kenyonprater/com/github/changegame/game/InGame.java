package kenyonprater.com.github.changegame.game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class InGame extends BasicGameState{

	private static int ID;
	private Entity testEntity;
	
	InGame(int id)
	{
		super();
		ID = id;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		try{
			Image[] image = {new Image("res/testimg.png")};
			testEntity = new Entity(0,0,new Animation(image, 1000));
		}catch(SlickException e)
		{
			e.printStackTrace();
		}
		testEntity.setDx(10);
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		testEntity.draw();
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		testEntity.update(delta/1000.0);
		
	}

	@Override
	public int getID() {
		return 1;
	}

}
