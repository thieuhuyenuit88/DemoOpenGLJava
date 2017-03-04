package framework;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;

import GameState.Screen_Menu;
import GameState.Screen_Play;

public class iState {
	public enum ID{
		START,
		MAIN_MENU,
		MENU,
		PLAY,
	}
	public ID mID;
	static public game mGame;

	public iState (){
		mID = ID.START;
	}
	
	public void reshape(int x, int y, int width,int height){
		game.gl.glViewport(0, 0, width, height);
		game.gl.glMatrixMode(GL.GL_PROJECTION);
		game.gl.glLoadIdentity ();
		
		game.glu.gluPerspective(45.0f, (double)width/ (double)height,1, 1000);
		
		game.gl.glMatrixMode(GL.GL_MODELVIEW);
		game.gl.glLoadIdentity();
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT:
			mGame.mNextState = new Screen_Menu();
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		}
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void Init (){
		
	}
	public void Draw (GL gl){
		gl.glClearColor((float)Math.random(), (float)Math.random(), (float)Math.random(), 1);
		gl.glClear(GL.GL_COLOR_BUFFER_BIT| GL.GL_DEPTH_BUFFER_BIT| GL.GL_STENCIL_BUFFER_BIT);
	}
	public void Update (float _time){
		mGame.mNextState = new Screen_Menu();
	}
	public void Release (){
		
	}
}
