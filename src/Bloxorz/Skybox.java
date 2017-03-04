package Bloxorz;
import javax.media.opengl.GL;

import GameState.Global;

import com.sun.opengl.util.texture.Texture;

public class Skybox {
	public Texture[] mTex;
	public Skybox (String _top,String _buttom,String _font,String _back,String _left,String _right){
		mTex = new Texture[6];
		
		mTex[0] = Global.get().LoadTexture(_top);
		mTex[1] = Global.get().LoadTexture(_buttom);
		mTex[2] = Global.get().LoadTexture(_font);
		mTex[3] = Global.get().LoadTexture(_back);
		mTex[4] = Global.get().LoadTexture(_right);
		mTex[5] = Global.get().LoadTexture(_left);
		
		
		for(int i=0;i<6;i++){
			mTex[i].setTexParameteri(GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP_TO_EDGE);
			mTex[i].setTexParameteri(GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP_TO_EDGE);
		}
		
	}
	public void Draw (GL gl,float _size,float _CamX,float _CamY,float _CamZ){
		float m_size=_size;
		gl.glPushMatrix();
			gl.glTranslatef(_CamX, _CamY, _CamZ);
			gl.glPushAttrib(GL.GL_FOG_BIT | GL.GL_DEPTH_BUFFER_BIT | GL.GL_LIGHTING_BIT);
			gl.glDisable(GL.GL_DEPTH_TEST);
			gl.glEnable(GL.GL_TEXTURE);
//			Top
			mTex[0].bind();
			gl.glBegin(GL.GL_QUADS);	
				gl.glTexCoord2f(0.0f, 1.0f);
				gl.glVertex3f(-m_size, m_size, -m_size);
				gl.glTexCoord2f(1.0f, 1.0f);
				gl.glVertex3f(m_size, m_size, -m_size);
				gl.glTexCoord2f(1.0f, 0.0f);
				gl.glVertex3f(m_size, m_size, m_size);				
				gl.glTexCoord2f(0.0f, 0.0f); 
				gl.glVertex3f(-m_size, m_size, m_size);
			gl.glEnd();
//			Bottom
			mTex[1].bind();
			gl.glBegin(GL.GL_QUADS);
				gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f(m_size, -m_size, -m_size);
				gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f(-m_size, -m_size, -m_size);
				gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f(-m_size, -m_size, m_size);
				gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f(m_size, -m_size, m_size);
			gl.glEnd();
//			Font
			mTex[2].bind();
			gl.glBegin(GL.GL_QUADS);
				gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f(-m_size, -m_size, -m_size);
				gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f(m_size, -m_size, -m_size);
				gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f(m_size, m_size, -m_size);
				gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f(-m_size, m_size, -m_size);
			gl.glEnd();
//			Back
			mTex[3].bind();
			gl.glBegin(GL.GL_QUADS);
				gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f(m_size, -m_size, m_size);
				gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f(-m_size, -m_size, m_size);
				gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f(-m_size, m_size, m_size);
				gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f(m_size, m_size, m_size);
			gl.glEnd();
//			Right
			mTex[4].bind();
			gl.glBegin(GL.GL_QUADS);
				gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f(m_size, -m_size, m_size);
				gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f(m_size, m_size, m_size);
				gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f(m_size, m_size, -m_size);
				gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f(m_size, -m_size, -m_size);
			gl.glEnd();
//			Left
			mTex[5].bind();
			gl.glBegin(GL.GL_QUADS);
				gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f(-m_size, -m_size, -m_size);
				gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f(-m_size, m_size, -m_size); 
				gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f(-m_size, m_size, m_size);
				gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f(-m_size, -m_size, m_size);
			gl.glEnd();
			gl.glPopAttrib();
		gl.glPopMatrix();
	}
}
