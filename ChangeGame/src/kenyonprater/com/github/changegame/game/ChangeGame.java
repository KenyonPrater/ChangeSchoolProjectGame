package kenyonprater.com.github.changegame.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ChangeGame extends StateBasedGame{

	private static int STATETITLE = 0;
	private static int STATEGAME = 1;
	private static int STATECREDITS = 2;
	
	public final boolean ISDEBUG;
	
	public ChangeGame(String name, boolean debug) {
		super(name);
		ISDEBUG = debug;
		this.getContainer().setShowFPS(debug);

	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new InGame(STATEGAME));
	}

}
