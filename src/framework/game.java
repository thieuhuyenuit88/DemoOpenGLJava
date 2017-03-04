package framework;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.xml.bind.JAXBElement.GlobalScope;

import Bloxorz.ManagerLevel;
import GameState.Global;
import GameState.Screen_Play;

import com.sun.opengl.util.FPSAnimator;


public class game  extends Frame implements GLEventListener,KeyListener,MouseListener,MouseMotionListener  {
	static public int HEIGHT = 600, WIDTH = 800;
	static public GL gl; // interface to OpenGL
	static public GLU glu;
	static GLCanvas canvas; // drawable in a frame
	static FPSAnimator  animator; // drive display() in a loop
	
	long lasttime =System.currentTimeMillis(); // Tinh deta time
	long savetime =System.currentTimeMillis(); // Tinh FPS
	int countFPS =0; // Dem FPS
	
	public iState mCurState,mNextState;
	
	public game (){
		// 1. specify a drawable: canvas
		canvas = new GLCanvas();
		
		// 2. listen to the events related to canvas: init, reshape, display, and displayChanged
		canvas.addGLEventListener(this);

		// 3. add the canvas to fill the Frame container
		this.add(canvas, BorderLayout.CENTER);

		// 4. interface to OpenGL functions
		gl = canvas.getGL();
		glu = new GLU ();
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				animator.stop(); // stop animation
				System.exit(0);
			}
		});
		canvas.addMouseListener(this);
		canvas.addKeyListener(this);
		canvas.addMouseMotionListener(this);
		Global.get();
		
		/**
		 * @author Tri
		 * Load level unlock
		 */
		ManagerLevel.Load();
		
		iState.mGame = this;
		mCurState = new iState();
		mNextState = mCurState;
		mCurState.Init();
		
	}
	@Override
	public void init(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		// 2. clear the background to black
				gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
				gl.glDrawBuffer(GL.GL_FRONT_AND_BACK);
				gl.glClear(GL.GL_COLOR_BUFFER_BIT);
				gl.glEnable(GL.GL_TEXTURE_2D);
				gl.glEnable(GL.GL_DEPTH_TEST);
				// 3. drive the display() in a loop
				animator = new FPSAnimator(canvas,60,false);
				animator.start(); // start animator thread
				
	}
	@Override
	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		game f = new game();
		// 8. add a title on the frame
		f.setTitle("Begin");

		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
	}
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		// TODO Auto-generated method stub
		WIDTH = width; 
		HEIGHT = height;
		if(mCurState!=null){
			mCurState.reshape(x, y, width, height);
		}
		
	}
	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
		Update(1000.0f);		
		drawable.repaint();
		
	}
	public void Update(float _fps){
		
		if(mCurState!=mNextState){
			mCurState.Release();
			mCurState = mNextState;
			mCurState.Init();
			mCurState.reshape(0, 0, WIDTH, HEIGHT);
		}else{
			float deta =(System.currentTimeMillis()- lasttime);
			if(deta >= 1000.0f/_fps){
				lasttime = System.currentTimeMillis();
				countFPS ++;				
				mCurState.Update(deta/1000.0f);
				mCurState.Draw(gl);
				if(System.currentTimeMillis()-savetime>1000){
					savetime = System.currentTimeMillis();
					setTitle("FPS: "+countFPS);
					countFPS =0;
				}
			}
		}
	}
	public void UpdateChangeState(){
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(mCurState!=null){
			mCurState.mouseClicked(e);
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(mCurState!=null){
			mCurState.mouseEntered(e);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(mCurState!=null){
			mCurState.mouseExited(e);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(mCurState!=null){
			mCurState.mousePressed(e);
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(mCurState!=null){
			mCurState.mouseReleased(e);
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(mCurState!=null){
			mCurState.mouseDragged(e);
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(mCurState!=null){
			mCurState.mouseMoved(e);
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(mCurState!=null){
			mCurState.keyPressed(e);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(mCurState!=null){
			mCurState.keyReleased(e);
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(mCurState!=null){
			mCurState.keyTyped(e);
		}
		
	}
	
	
}
