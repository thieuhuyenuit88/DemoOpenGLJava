package Bloxorz;

import GameState.Global;

import com.sun.opengl.util.texture.Texture;

public class RSManager {
	static RSManager instance = null;
	public Texture Tex_Cube_O ;
	public Texture Tex_Cube_X;
	public Texture Tex_Cube_Normal;
	public Texture Tex_Cube_AC;
	public Texture Tex_Cube_NoneST;
	public Texture Tex_Cube_Win;
	public Texture Tex_Par;
	private RSManager () {
		Tex_Cube_O 		=Global.get().LoadTexture(Global.IMG_O);
		Tex_Cube_X 		=Global.get().LoadTexture(Global.IMG_X);
		Tex_Cube_Normal	=Global.get().LoadTexture(Global.IMG_PLAYER);;
		Tex_Cube_AC 	=Global.get().LoadTexture(Global.IMG_AC);
		Tex_Cube_NoneST =Global.get().LoadTexture(Global.IMG_NONEST);
		Tex_Cube_Win	=Global.get().LoadTexture(Global.IMG_WIN);
		Tex_Par			=Global.get().LoadTexture(Global.IMG_PARTICLE);
	}
	static public RSManager get(){
		if(instance == null){
			instance = new RSManager();
		}
		return instance;
	}
}
