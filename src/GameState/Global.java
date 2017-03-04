package GameState;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;


public class Global {
	static Global instance = null;
	
	private Global (){
	}
	static public Global get(){
		if(instance == null){
			instance = new Global();
		}
		return instance;
	}
	public Texture LoadTexture (String _path){
		Texture _result;
		BufferedImage image;
		try{
			image = ImageIO.read(this.getClass().getResource(_path));
			_result = TextureIO.newTexture(image,false);
		}catch(IllegalArgumentException e){
			JOptionPane.showMessageDialog(null, "Can not load file \"" + _path + "\". The application will be exit !", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			return null;
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
		return _result;
	}
	
	
	static public String  IMG_PLANE 		= "Image/Block.png";
//	static public String  IMG_PLANE = "Image/P.png";
	
//	static public String  IMG_AC = "Image/AC.jpg";
	static public String  IMG_AC 			= "Image/X.png";
//	static public String  IMG_PLAYER 		= "Image/Plane.jpg";
	static public String  IMG_PLAYER 		= "Image/LandNormal.png";
	static public String  IMG_O 			= "Image/O.png";
	static public String  IMG_X 			= "Image/X.png";
	static public String  IMG_NONEST		= "Image/nonest.jpg";
	static public String  IMG_WIN			= "Image/Win.png";
	static public String  IMG_PARTICLE		= "Image/parQ.png";
	static public String  IMG_MENU_PLAY		= "Image/Menu_Play.png";
	static public String  IMG_MENU_ABOUT	= "Image/Menu_About.png";
	static public String  IMG_MENU_EXIT		= "Image/Menu_Exit.png";
	static public String  IMG_DIALOG_LOSE	= "Image/lose.png";
	static public String  IMG_DIALOG_WIN	= "Image/winmenu.png";
	
	static public String  IMG_SKYBOX_TOP 	= "Image/Skybox_menu/SkyMenuTop.png";
	static public String  IMG_SKYBOX_BOTTOM = "Image/Skybox_menu/SkyMenuBottom.png";
	static public String  IMG_SKYBOX_FRONT 	= "Image/Skybox_menu/SkyMenuFront.png";
	static public String  IMG_SKYBOX_BACK 	= "Image/Skybox_menu/SkyMenuBack.png";
	static public String  IMG_SKYBOX_LEFT 	= "Image/Skybox_menu/SkyMenuLeft.png";
	static public String  IMG_SKYBOX_RIGHT 	= "Image/Skybox_menu/SkyMenuRight.png";
	
	static public String  IMG_SKYBOXG_TOP 		= "Image/Skybox_menu/SkyBox_Top.jpg";
	static public String  IMG_SKYBOXG_BOTTOM 	= "Image/Skybox_menu/SkyBox_Bottom.jpg";
	static public String  IMG_SKYBOXG_FRONT 	= "Image/Skybox_menu/SkyBox_Front.jpg";
	static public String  IMG_SKYBOXG_BACK 		= "Image/Skybox_menu/SkyBox_Back.jpg";
	static public String  IMG_SKYBOXG_LEFT 		= "Image/Skybox_menu/SkyBox_Left.jpg";
	static public String  IMG_SKYBOXG_RIGHT 	= "Image/Skybox_menu/SkyBox_Right.jpg";
	
	static public String  SOUND_MENU		 	= "sound/backmenu.wav";
	static public String  SOUND_GAME		 	= "sound/backgame.wav";
	static public String  SOUND_BRICK		 	= "sound/addbrick.wav";
	static public String  SOUND_CHOSE		 	= "sound/chose.wav";
	static public String  SOUND_LOST		 	= "sound/lost.wav";
	static public String  SOUND_WIN		 		= "sound/win.wav";
	static public String  SOUND_PERFFECT		= "sound/perffect.wav";
	static public String  SOUND_STATEWIN		= "sound/winstate.wav";
	
//	static public String  IMG_SKYBOXG_TOP 		= "Image/Skybox_menu/up.png";
//	static public String  IMG_SKYBOXG_BOTTOM 	= "Image/Skybox_menu/dn.png";
//	static public String  IMG_SKYBOXG_FRONT 	= "Image/Skybox_menu/ft.png";
//	static public String  IMG_SKYBOXG_BACK 		= "Image/Skybox_menu/bk.png";
//	static public String  IMG_SKYBOXG_LEFT 		= "Image/Skybox_menu/lt.png";
//	static public String  IMG_SKYBOXG_RIGHT 	= "Image/Skybox_menu/rt.png";
	
	
	static public int ID_CUBE_NONE 			= 0;
	static public int ID_CUBE_NORMAL 		= 1;
	static public int ID_CUBE_O 			= 2;
	static public int ID_CUBE_ACTIVE 		= 3;
	static public int ID_CUBE_X 			= 4;
	static public int ID_CUBE_NONE_ST 		= 5;
	static public int ID_CUBE_WIN	 		= 6;
	
//	static public int ID_CUBE
}
