package Bloxorz;

import com.sun.opengl.util.texture.Texture;

public class CubeNoneST extends CubeNormal{
	public boolean miDown = false; 
	public float mVy = 0; 
	public CubeNoneST(Texture _tex) {
		super(_tex);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void Update(float deta) {
		// TODO Auto-generated method stub
		super.Update(deta);
		if (miDown==true){
			mVy += deta*100;
			mPos[1]-= mVy*deta;
		}
	}
	@Override
	public int LinkST (){
		mVy=+40;
		miDown = true;
		return -1;
	}
	@Override
	public int Link (){
		return 0;
	}
}
