package Bloxorz;

import javax.media.opengl.GL;

import com.sun.opengl.util.texture.Texture;

public class CubeDrawLR extends CubeDraw{

	float[] Vertices = {
//			Top
			0,2,0,
			4,2,0,
			4,2,-2,
			0,2,-2,
//			Bottom
			0,0,0,
			4,0,0,
			4,0,-2,
			0,0,-2,
//			Left
			0,0,0,
			0,2,0,
			0,2,-2,
			0,0,-2,
//			Right
			4,0,0,
			4,2,0,
			4,2,-2,
			4,0,-2,
//			Front
			0,0,0,
			4,0,0,
			4,2,0,
			0,2,0,
//			Back
			0,0,-2,
			4,0,-2,
			4,2,-2,
			0,2,-2,
			
//			
	};
	public CubeDrawLR(Texture _Tex) {
		super(_Tex);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void Draw (GL gl){	
		if(mbTex==true){ // Check have texture
			gl.glEnable(GL.GL_TEXTURE); // Enable Texture
			mTex.bind(); // Binding texture
		}		
		gl.glBegin(GL.GL_QUADS);
		for(int i =0; i<6;i++){
			gl.glTexCoord2f(0, 0);
			gl.glVertex3f(Vertices[i*12], Vertices[i*12+1], Vertices[i*12+2]);
			gl.glTexCoord2f(0, 1);
			gl.glVertex3f(Vertices[i*12+3], Vertices[i*12+4], Vertices[i*12+5]);
			gl.glTexCoord2f(1, 1);
			gl.glVertex3f(Vertices[i*12+6], Vertices[i*12+7], Vertices[i*12+8]);
			gl.glTexCoord2f(1, 0);
			gl.glVertex3f(Vertices[i*12+9], Vertices[i*12+10], Vertices[i*12+11]);
		}			 
		gl.glEnd();
		
		if(mbTex==true){ // Check have texture
			gl.glDisable(GL.GL_TEXTURE);
		}
	}
}
