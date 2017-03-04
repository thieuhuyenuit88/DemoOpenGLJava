package GameState;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.media.opengl.GL;

import Bloxorz.Cube;
import Bloxorz.CubeActive;
import Bloxorz.CubeDraw;
import Bloxorz.CubeNormal;
import Bloxorz.CubeO;
import Bloxorz.CubePlayer;
import Bloxorz.ManagerLevel;
import Bloxorz.CubePlayer.Action;
import Bloxorz.CubeX;
import Bloxorz.Level;
import Bloxorz.RSSound;
import Bloxorz.Skybox;

import com.sun.opengl.util.texture.Texture;

import framework.game;
import framework.iState;

public class Screen_Play extends iState{
	Skybox mSky;
	CubeNormal[][] mArrCube;
	int X,Z;
	CubePlayer mCubePlayer;
	float mCamPos[];
	float OldPoint[];
	float mAngleX,mAngleZ,mCamR;
	int mLevel=0;
	/**
	 * Kich thuot cua man hinh
	 */
	int mW,mH;
	/**
	 * Xu ly luc win va lose
	 */
	Texture mTexWin,mTexLose;
	/**
	 * Vi tri theo truc y cua cai dialog win va lose
	 */
	float mPosTranslate;
	/**
	 * = 0 : Normal
	 * = 1 : Win
	 * =-1 : Lose
	 * = 2 : Menu
	 */
	int mState;
	/**
	 * 
	 * @param _level tu 1-> 11
	 */
	public Screen_Play (int _level){
		mID = ID.MENU;
		mLevel = _level;
		
	}
	/**
	 * @param width 
	 * @param height 
	 */
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
		
//		mSky = new Skybox(Global.IMG_SKYBOX_TOP, Global.IMG_SKYBOX_BOTTOM, Global.IMG_SKYBOX_FRONT, Global.IMG_SKYBOX_BACK, Global.IMG_SKYBOX_LEFT, Global.IMG_SKYBOX_RIGHT);
		
		mSky = new Skybox(Global.IMG_SKYBOXG_TOP, Global.IMG_SKYBOXG_BOTTOM, Global.IMG_SKYBOXG_FRONT, Global.IMG_SKYBOXG_BACK, Global.IMG_SKYBOXG_LEFT, Global.IMG_SKYBOXG_RIGHT);
		mCamPos = new float[3];
		OldPoint = new float[2];
		mAngleX=(float) (Math.PI*0.5f);
		mAngleZ=(float) (Math.PI*0.25f);
		mCamR=170;
		
		mCamPos[0] = (float) (Math.cos(mAngleX)* Math.sin(mAngleZ)*mCamR);
		mCamPos[1] = (float) (Math.cos(mAngleZ)*mCamR);
		mCamPos[2] = (float) (Math.sin(mAngleX)* Math.sin(mAngleZ)* mCamR);
		
		mTexWin = Global.get().LoadTexture(Global.IMG_DIALOG_WIN);
		mTexLose = Global.get().LoadTexture(Global.IMG_DIALOG_LOSE);
		
		initLevel(mLevel);
		RSSound.get().StopAll();
		RSSound.get().mBackGame.play(false,true);
	
	}
	@Override
	public void Draw (GL gl){
//		game.gl.glClearColor(0, 1, 0, 1);
		gl.glClear(GL.GL_COLOR_BUFFER_BIT| GL.GL_DEPTH_BUFFER_BIT| GL.GL_STENCIL_BUFFER_BIT);
		gl.glLoadIdentity();
		game.glu.gluLookAt(mCamPos[0], mCamPos[1], mCamPos[2],
				0, 0, 0,
				0, 1, 0);
		mSky.Draw(gl, 100,mCamPos[0], mCamPos[1], mCamPos[2]);
		
		gl.glPushMatrix();
		gl.glTranslatef(-X*5, 0, -Z*5);
		gl.glScalef(5, 5, 5);
			DrawArrCube(gl);
			DrawPlayer(gl);	
		gl.glPopMatrix();
		
		switch (mState) {
		case 1:	
			drawWin(gl);
			break;
		case -1:
			drawLose(gl);
			break;
		case 2:
			break;
		default:
			break;
		}
	}
	public void Update (float _time){
		updateAllCube(_time);
		if(mCubePlayer.iProgress()){
			mCubePlayer.Update(_time);
			if(!mCubePlayer.iProgress()){
				int iCheck =CheckCubeVSBoard(mCubePlayer, mArrCube, X, Z); 
				if(iCheck ==0 ){ // Ko thang ko thua
//					mGame.mNextState = new iState ();
				}else{
					if(iCheck < 0){// Thua
						RSSound.get().StopAll();
						RSSound.get().mLost.play(false, true);
						mCubePlayer.SetLose();	
						mState = -1;
						mPosTranslate = mH/200.0f;
					}else{ // Thang
						RSSound.get().StopAll();
						RSSound.get().mStateWin.play(false, true);
						mCubePlayer.SetWin();
						mState = 1;
						mPosTranslate = mH/200.0f;
						ActiveNewLevel(mLevel);
					}
				}
			}
		}
		switch (mState) {
		case  1:				
		case -1:
			updateWinLose(_time);
			break;
		case 2:
			break;
		default:
			break;
		}
	}
	public void Release (){
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (mState) {
		case 0:
			KeyPressNormal(e);
			break;
		case 1:
			KeyPressWin(e);
			break;
		case -1:
			KeyPressLose(e);
			break;
		default:
			break;
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		OldPoint[0] = e.getX();
		OldPoint[1] = e.getY(); 
	}
	@Override
	public void mouseDragged(MouseEvent e) {

		// TODO Auto-generated method stub
		float detaX= e.getX()-OldPoint[0];
		
		float detaY = e.getY()-OldPoint[1];
		
		mAngleX -= Math.atan(detaX/2.0f/mCamR);
		mAngleZ += Math.atan(detaY/2.0f/mCamR);
		
		System.out.println(""+this.toString()+"AngleX: "+mAngleX+", AngleZ: "+mAngleZ);
		OldPoint[0] = e.getX();
		OldPoint[1] = e.getY(); 
		
		mCamPos[0] = (float) (Math.cos(mAngleX)* Math.sin(mAngleZ)*mCamR);
		mCamPos[1] = (float) (Math.cos(mAngleZ)*mCamR);
		mCamPos[2] = (float) (Math.sin(mAngleX)* Math.sin(mAngleZ)* mCamR);
	}
	
	private void DrawArrCube (GL gl){
		gl.glPushMatrix();		
//		gl.glScalef(5, 5, 5);
		
		for (int i =0 ; i < X;i++){
			for (int j=0; j <Z; j++){
				gl.glPushMatrix();
//				gl.glTranslatef(i, 0, j);
				mArrCube[i][j].Draw(gl);
				gl.glPopMatrix();
				
			}
		}
		gl.glPopMatrix();
	}
	private void DrawPlayer (GL gl){
		gl.glPushMatrix();		
			mCubePlayer.Draw(gl);
		gl.glPopMatrix();
	}
	private int CheckCubeVSBoard (CubePlayer _Player,CubeNormal[][] _Cubes,int _x,int _z){
		int result= 0;
		// ra ngoai board
		if (_Player.mX < 0 ||
				_Player.mX >= _x ||
				_Player.mZ <0 ||
				_Player.mZ >= _z) return -1;
		
		// Vi tri do khong co o co the dung dc
		if (_Cubes[_Player.mX][_Player.mZ].miActive==false)return -1;
		
		// o trang thai dung
		if(_Player.mAction == Action.ST){
			return _Cubes[_Player.mX][_Player.mZ].LinkST();
		}
		if(_Player.mAction == Action.LR){
			_Cubes[_Player.mX][_Player.mZ].Link();
			if(_Player.mX+1 >= _x) return -1;
			if(_Cubes[_Player.mX+1][_Player.mZ].miActive==false) return -1;
			return _Cubes[_Player.mX+1][_Player.mZ].Link();
		}
		if(_Player.mAction == Action.UD){
			_Cubes[_Player.mX][_Player.mZ].Link();
			if(_Player.mZ+1 >= _z) return -1;
			if(_Cubes[_Player.mX][_Player.mZ+1].miActive==false) return -1;			
			return _Cubes[_Player.mX][_Player.mZ+1].Link();
		}
		return result;
	}
	public void initLevel (int _level){
		mState = 0;
		X= 20;
		Z= 10;
		mCubePlayer = new CubePlayer(Global.get().LoadTexture(Global.IMG_PLANE));
		mArrCube=new CubeNormal[X][Z];
		switch (_level) {
		case 1:
			Level.Level1(mCubePlayer,mArrCube, X, Z);
			break;
		case 2:
			Level.Level2(mCubePlayer,mArrCube, X, Z);
			break;
		case 3:
			Level.Level3(mCubePlayer,mArrCube, X, Z);
			break;
		case 4:
			Level.Level4(mCubePlayer,mArrCube, X, Z);
			break;
		case 5:
			Level.Level5(mCubePlayer,mArrCube, X, Z);
			break;
		case 6:
			Level.Level6(mCubePlayer,mArrCube, X, Z);
			break;
		case 7:
			Level.Level7(mCubePlayer,mArrCube, X, Z);
			break;
		case 8:
			Level.Level8(mCubePlayer,mArrCube, X, Z);
			break;
		case 9:
			Level.Level9(mCubePlayer,mArrCube, X, Z);
			break;
		case 10:
			Level.Level10(mCubePlayer,mArrCube, X, Z);
			break;
		case 11:
			Level.Level11(mCubePlayer,mArrCube, X, Z);
			break;
		default:
			Level.Level1(mCubePlayer,mArrCube, X, Z);
			break;
		}
				
	}
	void updateAllCube (float _time){
		for (int i =0 ; i < X;i++){
			for (int j=0; j <Z; j++){
				mArrCube[i][j].Update(_time);
			}
		}
	}
	
	private void updateWinLose (float _time){
		if( mPosTranslate > 0){
			mPosTranslate -=_time*2;
		}
	}
	
	private void  drawWin(GL gl) {
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glPushMatrix();
		gl.glLoadIdentity();
		gl.glOrtho(0, mW/100.0f, 0, mH/100.0f, 0,1000);
		
		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glLoadIdentity();
		mGame.glu.gluLookAt(0, 0, 1, 
					0, 0, 0,
					0,1,0);		

		gl.glPushMatrix();
			gl.glTranslatef(0, mPosTranslate, 0);
			DrawItemImage(gl, mTexWin);
		gl.glPopMatrix();
		
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glPopMatrix();
		gl.glMatrixMode(GL.GL_MODELVIEW);
	}
	private void drawLose(GL gl){
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glPushMatrix();
		gl.glLoadIdentity();
		gl.glOrtho(0, mW/100.0f, 0, mH/100.0f, 0,1000);
		
		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glLoadIdentity();
		mGame.glu.gluLookAt(0, 0, 1, 
					0, 0, 0,
					0,1,0);		

		gl.glPushMatrix();
			gl.glTranslatef(0, mPosTranslate, 0);
			DrawItemImage(gl, mTexLose);
		gl.glPopMatrix();
		
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glPopMatrix();
		gl.glMatrixMode(GL.GL_MODELVIEW);
	}
	public void DrawItemImage(GL gl,Texture _Tex) {
		
		gl.glEnable(GL.GL_TEXTURE);
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_DST_ALPHA,GL.GL_ONE_MINUS_SRC_ALPHA);
		_Tex.bind();
		
		float W = mW/100.0f;
		float H = mH/100.0f;
		float SW = 6;
		float SH = 4;
		gl.glPushMatrix();
			gl.glBegin(GL.GL_QUADS);
				gl.glTexCoord2f(0, 1); gl.glVertex3f((W-SW)/2, (H-SH)/2, 0);
				gl.glTexCoord2f(1, 1); gl.glVertex3f(W - (W-SW)/2 ,(H-SH)/2,0);
				gl.glTexCoord2f(1, 0); gl.glVertex3f(W - (W-SW)/2 ,H -(H-SH)/2, 0);
				gl.glTexCoord2f(0, 0); gl.glVertex3f((W-SW)/2, H -(H-SH)/2, 0);
			gl.glEnd ();
		gl.glPopMatrix();
		
		gl.glDisable(GL.GL_TEXTURE);
		gl.glDisable(GL.GL_BLEND);
	}
	/**
	 * Xu ly key press khi lose ( o cac trang thai con la thi ko)
	 * @param e
	 */
	private void KeyPressLose(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			mGame.mNextState = new Screen_Play(mLevel);
			break;
		case KeyEvent.VK_RIGHT:
			mGame.mNextState = new Screen_Menu();
			break;			
		case KeyEvent.VK_ESCAPE:
			break;
		}
		
	}
	/**
	 * Xu ly key event khi win
	 * @param e Key event
	 */
	private void KeyPressWin(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			mGame.mNextState = new Screen_Play(mLevel);
			break;
		case KeyEvent.VK_DOWN:
			mGame.mNextState = new Screen_Menu();
			break;	
		case KeyEvent.VK_RIGHT:
			mGame.mNextState = new Screen_Play(mLevel+1);
			break;	
		case KeyEvent.VK_ESCAPE:
			break;
		}
	}
	/**
	 * Xu ly key press khi choi
	 * @param e
	 */
	private void KeyPressNormal(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			if(mCubePlayer!=null)	mCubePlayer.SetNextUp();
			break;
		case KeyEvent.VK_DOWN:
			if(mCubePlayer!=null)	mCubePlayer.SetNextDown();
			break;
		case KeyEvent.VK_LEFT:
			if(mCubePlayer!=null)	mCubePlayer.SetNextLeft();
			break;
		case KeyEvent.VK_RIGHT:
			if(mCubePlayer!=null)	mCubePlayer.SetNextRight();
			break;			
		case KeyEvent.VK_ESCAPE:
			break;
		}
	}
	/**
	 * @author Tri 
	 * Kiem tra xem level tiep theo se duoc unlock
	 * Neu da het level thi ko unlock nua
	 * @param _CurLevel Level hien tai cua nguoi choi
	 */
	private void ActiveNewLevel(int _CurLevel) {
		if(_CurLevel+1 < ManagerLevel.msTotal && _CurLevel == ManagerLevel.msUnlock){
			ManagerLevel.msUnlock = _CurLevel+1;
			ManagerLevel.Save();
		}
	}
}
