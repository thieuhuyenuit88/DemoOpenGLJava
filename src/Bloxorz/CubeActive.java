package Bloxorz;

import javax.media.opengl.GL;

import com.sun.opengl.util.texture.Texture;

public class CubeActive extends CubeNormal{

	public float mRotate = 90;
	public boolean miCheck = false;
	public CubeActive(Texture _tex) {
		super(_tex);
		miActive = false;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void Update(float deta) {
		// TODO Auto-generated method stub
		super.Update(deta);
		if (miActive == true && miCheck == false){
			mRotate -= deta*100.0f; 
			if (mRotate <=0){
				mRotate =0;
				miCheck = true;
			}			
		}
		if (miActive == false && miCheck == true){
			mRotate += deta*100.0f; 
			if (mRotate >=90){
				mRotate =90;
				miCheck = false;
			}			
		}
			
	}
	
	@Override
	public void Draw(GL gl) {
		// TODO Auto-generated method stub
			gl.glPushMatrix();//			
				gl.glTranslatef(mPos[0], mPos[1], mPos[2]);
				gl.glTranslatef(0, -0.5f, 0);
				gl.glRotatef(mRotate, 1, 0, 0);
				gl.glScalef(1, 0.5f, 1);
				mCubeDraw.Draw(gl);
			gl.glPopMatrix();
	}
	@Override
	public int LinkST() {
		return 0;
	};
	@Override
	public int Link() {
		return 0;
	};
	@Override
	public void ActionLink() {
		
		miActive = !miActive;
		if(mCubeLink != null){
			mCubeLink.ActionLink();
		}
	}

}
