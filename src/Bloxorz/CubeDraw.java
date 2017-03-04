package Bloxorz;

import javax.media.opengl.GL;

import com.sun.opengl.util.texture.Texture;

public class CubeDraw {
	public Texture mTex; // Texture for draw
	public boolean mbTex; // flag for texture
	
	/*
	 * Constructor cube view
	 * Parameter
	 * 		Texture
	 * 		have null if don't texture
	 */
	public CubeDraw (Texture _Tex) {
		if(_Tex != null){
			mTex = _Tex;
			mbTex = true;
		}else{
			mTex = null;
			mbTex = false;
		}
	}
	
	/*
	 * Draw cube have center (0,0,0)
	 * Parameter
	 * 		GL gl
	 * 		float Size 
	 */
	public void Draw (GL gl){		
		float _size =1;
		gl.glPushMatrix();
			//gl.glTranslatef(-_size/2, -_size/2, -_size/2);
			gl.glNormal3f (0,-1,0);
			
			//top
			gl.glPushMatrix();
			gl.glTranslatef(0, _size, 0);
			gl.glScalef(1, -1, 1);
			DrawPlane(gl);			
			gl.glPopMatrix();
			
			//button
			gl.glPushMatrix();
			gl.glTranslatef(0, -_size, 0);
			gl.glScalef(1, -1, 1);
			DrawPlane(gl);			
			gl.glPopMatrix();
			
			
			//left
			gl.glPushMatrix();
			gl.glTranslatef(-_size, 0, 0);
			gl.glRotatef(90, 0, 0, 1);
			gl.glScalef(1, -1, 1);
			DrawPlane(gl);			
			gl.glPopMatrix();
			
			//right
			gl.glPushMatrix();
			gl.glTranslatef(_size, 0, 0);
			gl.glRotatef(90, 0, 0, 1);
			DrawPlane(gl);			
			gl.glPopMatrix();
			
			//front
			gl.glPushMatrix();
			gl.glTranslatef(0, 0, _size);
			gl.glRotatef(90, -1, 0, 0);
			DrawPlane(gl);			
			gl.glPopMatrix();
			
			//back
			gl.glPushMatrix();
			gl.glTranslatef(0, 0, -_size);
			gl.glRotatef(90, -1, 0, 0);
			gl.glScalef(1, -1, 1);
			DrawPlane(gl);			
			gl.glPopMatrix();
		
		gl.glPopMatrix ();
		
	}
	/*
	 * Draw Plane with default size 2 and center (0,0,0)
	 */
	public void DrawPlane (GL gl){
		if(mbTex==true){ // Check have texture
			gl.glEnable(GL.GL_TEXTURE); // Enable Texture
			mTex.bind(); // Binding texture
		}
		
		gl.glBegin(GL.GL_TRIANGLE_STRIP);
			gl.glTexCoord2f(1, 0); gl.glVertex3f(1, 0, -1);
			gl.glTexCoord2f(0, 0); gl.glVertex3f(-1,0, -1);
			gl.glTexCoord2f(1, 1); gl.glVertex3f(1, 0, 1);
			gl.glTexCoord2f(0, 1); gl.glVertex3f(-1, 0, 1);
		gl.glEnd();
		
		if(mbTex==true){ // Check have texture
			gl.glDisable(GL.GL_TEXTURE);
		}
	}
	
}
