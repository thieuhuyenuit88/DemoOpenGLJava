package Bloxorz;

import java.util.Random;

import com.sun.opengl.util.texture.Texture;

public class Particle {
	public float mX,mY,mZ;
	public float mVx,mVy,mVz;
	public float mG;
	public Texture mTexture;
	public Random mRan;
	public Particle (){
		mX = mY = mZ = 0;
		mVx = mVy = 0;
	}
}
