package Bloxorz;

import java.io.IOException;

import GameState.Global;

public class RSSound {
	static RSSound instance;
	public Sound mBackMenu;
	public Sound mBackGame;
	public Sound mAddBrick;
	public Sound mChose;
	public Sound mLost;
	public Sound mWin;
	public Sound mPerffect;
	public Sound mStateWin;

	private RSSound () throws IOException{
		mBackMenu 	= new Sound(ResourceRetriever.getResourceAsStream(Global.SOUND_MENU));
		mBackGame 	= new Sound(ResourceRetriever.getResourceAsStream(Global.SOUND_GAME));
		mAddBrick 	= new Sound(ResourceRetriever.getResourceAsStream(Global.SOUND_BRICK));
		mChose 		= new Sound(ResourceRetriever.getResourceAsStream(Global.SOUND_CHOSE));
		mLost 		= new Sound(ResourceRetriever.getResourceAsStream(Global.SOUND_LOST));
		mWin		= new Sound(ResourceRetriever.getResourceAsStream(Global.SOUND_WIN));
		mPerffect	= new Sound(ResourceRetriever.getResourceAsStream(Global.SOUND_PERFFECT));
		mStateWin	= new Sound(ResourceRetriever.getResourceAsStream(Global.SOUND_STATEWIN));
		
	}
	static public RSSound get() {
		if(instance== null){
			try {
				instance = new RSSound();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}
	public void StopAll() {
		mBackMenu.stop();
		mBackMenu.stop();
		mBackGame.stop();
		mAddBrick.stop();
		mChose.stop();
		mLost.stop();
		mWin.stop();
		mStateWin.stop();
	}
}
