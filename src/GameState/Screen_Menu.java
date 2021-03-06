package GameState;

import java.awt.event.KeyEvent;

import javax.media.opengl.GL;

import com.sun.opengl.util.texture.Texture;
import Bloxorz.RSSound;
import Bloxorz.Skybox;
import framework.game;
import framework.iState;

public class Screen_Menu extends iState{
	static int mMaxItem = 3;
	Skybox mSky;
	int mW,mH;
	float mCamPos[];
	float mAngle;
	float mCamR=170;
	
	Texture mTex[];
	int mIndex,mNextIndex;
	float mProgress;
	int mDir;
	public Screen_Menu (){
		mID = ID.MAIN_MENU;
	}
	public void reshape(int x, int y, int width,int height){
		game.gl.glViewport(0, 0, width, height);
		game.gl.glMatrixMode(GL.GL_PROJECTION);
		game.gl.glLoadIdentity ();
		
		game.glu.gluPerspective(45.0f, (double)width/ (double)height,1, 1000);
		
		game.gl.glMatrixMode(GL.GL_MODELVIEW);
		game.gl.glLoadIdentity();
		
		mW = width;
		mH = height;
	}
	public void Init (){
		game.gl.glClearColor(0.0f, 1.0f, 0.0f, 0.0f);
		game.gl.glDrawBuffer(GL.GL_FRONT_AND_BACK);
		game.gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		game.gl.glEnable(GL.GL_TEXTURE_2D);
		game.gl.glEnable(GL.GL_DEPTH_TEST);
		
		mSky = new Skybox(Global.IMG_SKYBOX_TOP, Global.IMG_SKYBOX_BOTTOM, Global.IMG_SKYBOX_FRONT, Global.IMG_SKYBOX_BACK, Global.IMG_SKYBOX_LEFT, Global.IMG_SKYBOX_RIGHT);
		mCamPos = new float[3];
		
		mCamPos[0] = (float) (Math.cos(mAngle)* mCamR);
		mCamPos[1] = (float) 0;
		mCamPos[2] = (float) (Math.sin(mAngle)* mCamR);
		
		mTex = new Texture[mMaxItem];
		mTex[0]=Global.get().LoadTexture(Global.IMG_MENU_PLAY);
		mTex[1]=Global.get().LoadTexture(Global.IMG_MENU_ABOUT);
		mTex[2]=Global.get().LoadTexture(Global.IMG_MENU_EXIT);
		
		RSSound.get().mBackMenu.play(false, true);
		
		mIndex = mNextIndex = 0; 
		mProgress = 0;
		mDir = 0;
	}
	@Override
	public void Draw (GL gl){
//		game.gl.glClearColor(0, 1, 0, 1);
		gl.glClear(GL.GL_COLOR_BUFFER_BIT| GL.GL_DEPTH_BUFFER_BIT| GL.GL_STENCIL_BUFFER_BIT);
		gl.glLoadIdentity();
		
		DrawSkyBox(gl);
		
		DrawItemMenu(gl);
		
	}
	@Override
	public void Update (float _time){
		mAngle+= _time*0.4*mDir;
		mCamPos[0] = (float) (Math.cos(mAngle)* mCamR);
		mCamPos[1] = (float) 0;
		mCamPos[2] = (float) (Math.sin(mAngle)* mCamR);
		
		if ( mIndex != mNextIndex){
			mProgress += _time;
			if (mProgress > 1){
				mIndex = mNextIndex;
				mProgress =0;
			}
		}

	}
	@Override
	public void Release (){
		
	}
	public void DrawItemMenu(GL gl) {
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(0, mW/100.0f, 0, mH/100.0f, 0,1000);
		
		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glLoadIdentity();
		mGame.glu.gluLookAt(0, 0, 1, 
					0, 0, 0,
					0,1,0);		

//		DrawItemImage(gl, mTex[mIndex]);
		
		if (mIndex == mNextIndex){
			DrawItemImage(gl, mTex[mIndex]);
		}else {
			if(mDir > 0){
				gl.glPushMatrix();
					gl.glTranslatef((-mProgress)*mW/100.0f, 0, 0);
					DrawItemImage(gl, mTex[mIndex]);
				gl.glPopMatrix();
				
				gl.glPushMatrix();
					gl.glTranslatef((1-mProgress)*mW/100.0f, 0, 0);
					DrawItemImage(gl, mTex[mNextIndex]);
				gl.glPopMatrix();
			}else{
				gl.glPushMatrix();
					gl.glTranslatef((mProgress)*mW/100.0f, 0, 0);
					DrawItemImage(gl, mTex[mIndex]);
				gl.glPopMatrix();
				
				gl.glPushMatrix();
					gl.glTranslatef((mProgress-1)*mW/100.0f, 0, 0);
					DrawItemImage(gl, mTex[mNextIndex]);
				gl.glPopMatrix();
			}
		}
		
	}
	public void DrawItemImage(GL gl,Texture _Tex) {
		gl.glEnable(GL.GL_TEXTURE);
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_DST_ALPHA,GL.GL_ONE_MINUS_SRC_ALPHA);
		_Tex.bind();
		
		gl.glPushMatrix();
			gl.glBegin(GL.GL_QUADS);
				gl.glTexCoord2f(0, 1); gl.glVertex3f(1, 1, 0);
				gl.glTexCoord2f(1, 1); gl.glVertex3f(mW/100.0f-1,1,0);
				gl.glTexCoord2f(1, 0); gl.glVertex3f(mW/100.0f-1,mH/100.0f-1, 0);
				gl.glTexCoord2f(0, 0); gl.glVertex3f(1, mH/100.0f-1, 0);
			gl.glEnd ();
		gl.glPopMatrix();
		
		gl.glDisable(GL.GL_TEXTURE);
		gl.glDisable(GL.GL_BLEND);
	}
	public void  DrawSkyBox(GL gl) {
		game.gl.glMatrixMode(GL.GL_PROJECTION);
		game.gl.glLoadIdentity ();
		
		game.glu.gluPerspective(45.0f, (double)mW/ (double)mH,1, 1000);
		
		game.gl.glMatrixMode(GL.GL_MODELVIEW);
		game.gl.glLoadIdentity();
		
		game.glu.gluLookAt(mCamPos[0], mCamPos[1], mCamPos[2],
				0, 0, 0,
				0, 1, 0);
		
		gl.glPushMatrix();
			mSky.Draw(gl, 100,mCamPos[0], mCamPos[1], mCamPos[2]);
		gl.glPopMatrix();
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(mIndex != mNextIndex){
			return;
		}
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT:
				RSSound.get().mChose.play();
				mNextIndex = (mIndex+1)%mMaxItem;
				mProgress =0;
				mDir = 1;
			break;
		case KeyEvent.VK_LEFT:
				RSSound.get().mChose.play();
				mNextIndex = (mIndex-1);
				if(mNextIndex < 0) mNextIndex =mMaxItem-1;
				mProgress =0;
				mDir = -1;
			break;
		case KeyEvent.VK_SPACE:
			switch(mIndex){
				case 0: // play now
					RSSound.get().mPerffect.play();
					mGame.mNextState = new Screen_ChoseLevel ();
					break;
				case 2:// Exit game
					System.exit(0);
					break;
			}
			break;
		}
	}
}
