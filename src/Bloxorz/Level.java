package Bloxorz;

import java.awt.geom.Point2D;

import GameState.Global;

import com.sun.opengl.impl.StaticGLInfo;

public class Level {

//	static public void Level1 ()
	static public CubeNormal[][]  InitArray (CubeNormal[][] pCubes,int pArr[],int x,int z){
//		CubeNormal[][] pCubes = new CubeNormal[x][z];
		for(int i=0;i<x*z;i++){
			switch (pArr[i]) {
			case 1:
				pCubes[i%x][i/x] = new CubeNormal(RSManager.get().Tex_Cube_Normal);
				break;
			case 2:		
				System.out.println("i="+i%x+",j="+i/x+",ID="+pArr[i]);
				pCubes[i%x][i/x] = new CubeO(RSManager.get().Tex_Cube_O);
				break;
			case 3:
				System.out.println("i="+i%x+",j="+i/x+",ID="+pArr[i]);
				pCubes[i%x][i/x] = new CubeActive(RSManager.get().Tex_Cube_Normal);
				pCubes[i%x][i/x].miActive = false;
				break;
			case 4:
				System.out.println("i="+i%x+",j="+i/x+",ID="+pArr[i]);
				pCubes[i%x][i/x] = new CubeX(RSManager.get().Tex_Cube_X);
				break;
			case 5:
				System.out.println("i="+i%x+",j="+i/x+",ID="+pArr[i]);
				pCubes[i%x][i/x] = new CubeNoneST(RSManager.get().Tex_Cube_NoneST);
				break;
			case 6:
				System.out.println("i="+i%x+",j="+i/x+",ID="+pArr[i]);
				pCubes[i%x][i/x] = new CubeWin(RSManager.get().Tex_Cube_Win);
				break;
					
			default:
				pCubes[i%x][i/x] = new CubeNormal(RSManager.get().Tex_Cube_Normal);
				pCubes[i%x][i/x].miActive = false;
				break;
			}			
			
			pCubes[i%x][i/x].mPos[0] = i%x*2;
			pCubes[i%x][i/x].mPos[2] = i/x*2;
		}
		pCubes[8][8].SetCubeLink( pCubes[8][5]);
		pCubes[13][4].SetCubeLink( pCubes[8][5]);
		pCubes[10][8].SetCubeLink( pCubes[8][5]);
		return pCubes;
	};
static public CubeNormal[][]  Level1 (CubePlayer pCubePlayer,CubeNormal[][] pCubes,int _X,int _Z){
		
		_X= 20;	
		_Z = 10;
		
		int ArrCube[] = {
			  //0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//9
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//8
				0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//7
				0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0,//6
				0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,//5
				0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0,//4
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 6, 1, 1, 0, 0, 0, 0, 0,//3
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0,//2
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//1
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//0
		};
		
		InitArray(pCubes, ArrCube, _X, _Z);
		pCubePlayer.mX = 6;
		pCubePlayer.mNextX = 6;
		pCubePlayer.mZ = 3;
		pCubePlayer.mNextZ = 3;
		return pCubes;
		
	};
static public CubeNormal[][]  Level2 (CubePlayer pCubePlayer,CubeNormal[][] pCubes,int _X,int _Z){
		
		_X= 20;	
		_Z = 10;
		
		int ArrCube[] = {
			  //0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//0
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//1
				0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0,//2
				0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 4, 1, 0, 0, 1, 6, 1, 0, 0, 0,//3
				0, 0, 1, 1, 2, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0,//4
				0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0,//5
				0, 0, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 3, 3, 1, 1, 1, 0, 0, 0,//6
				0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,//7
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//8
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//9
		};
		
		InitArray(pCubes, ArrCube, _X, _Z);
		
		pCubes[4][4].SetCubeLink( pCubes[6][6]);
		pCubes[6][6].SetCubeLink( pCubes[7][6]);
		
		pCubes[10][3].SetCubeLink( pCubes[12][6]);
		pCubes[12][6].SetCubeLink( pCubes[13][6]);
		
		pCubePlayer.mX = 3;
		pCubePlayer.mNextX = 3;
		pCubePlayer.mZ = 6;
		pCubePlayer.mNextZ = 6;
		return pCubes;
		
	};
static public CubeNormal[][]  Level3 (CubePlayer pCubePlayer,CubeNormal[][] pCubes,int _X,int _Z){
		
		_X= 20;	
		_Z = 10;
		
		int ArrCube[] = {
			  //0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//9
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//8
				0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0,//7
				0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0,//6
				0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0,//5
				0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 6, 1, 0, 0, 0,//4
				0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0,//3
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0,//2
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//1
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//0		
		};
		
		InitArray(pCubes, ArrCube, _X, _Z);
		
		
		
		pCubePlayer.mX = 3;
		pCubePlayer.mNextX = 3;
		pCubePlayer.mZ = 5;
		pCubePlayer.mNextZ = 5;
		return pCubes;
		
	};
static public CubeNormal[][]  Level4 (CubePlayer pCubePlayer,CubeNormal[][] pCubes,int _X,int _Z){
		
		_X= 20;	
		_Z = 10;
		
		int ArrCube[] = {
			  //0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
				0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0,//9
				0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0,//8
				0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0,//7
				0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0,//6
				0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 5, 5, 5, 5, 5, 0, 0, 0, 0,//5
				0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 5, 5, 5, 5, 5, 0, 0, 0, 0,//4
				0, 0, 1, 1, 1, 0, 0, 1, 6, 1, 0, 0, 5, 5, 1, 5, 0, 0, 0, 0,//3
				0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 5, 5, 5, 5, 0, 0, 0, 0,//2
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//1
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//0		
		};
		
		InitArray(pCubes, ArrCube, _X, _Z);
		
		
		
		pCubePlayer.mX = 3;
		pCubePlayer.mNextX = 3;
		pCubePlayer.mZ = 5;
		pCubePlayer.mNextZ = 5;
		return pCubes;
		
	};
static public CubeNormal[][]  Level5 (CubePlayer pCubePlayer,CubeNormal[][] pCubes,int _X,int _Z){
		
		_X= 20;	
		_Z = 10;
		
		int ArrCube[] = {
			  //0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0,//0
				0, 0, 0, 1, 1, 1, 1, 3, 3, 1, 2, 1, 1, 1, 1, 1, 1, 0, 0, 0,//1
				0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0,//2
				0, 0, 0, 1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//3
				0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//4
				0, 0, 0, 0, 0, 1, 1, 1, 4, 1, 3, 3, 1, 1, 1, 0, 0, 0, 0, 0,//5
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 0, 0, 0,//6
				0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0,//7
				0, 0, 1, 6, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0,//8
				0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//9
		};
		
		InitArray(pCubes, ArrCube, _X, _Z);
		
		pCubes[10][1].SetCubeLink( pCubes[8][1]);
		pCubes[8][1].SetCubeLink( pCubes[7][1]);
		
		pCubes[8][5].SetCubeLink( pCubes[10][5]);
		pCubes[10][5].SetCubeLink( pCubes[11][5]);

		
		pCubes[16][6].SetCubeLink( pCubes[7][8]);
		pCubes[7][8].SetCubeLink( pCubes[6][8]);
		
		pCubePlayer.mX = 15;
		pCubePlayer.mNextX = 15;
		pCubePlayer.mZ = 1;
		pCubePlayer.mNextZ = 1;
		return pCubes;
		
	};
static public CubeNormal[][]  Level6 (CubePlayer pCubePlayer,CubeNormal[][] pCubes,int _X,int _Z){
		
		_X= 20;	
		_Z = 10;
		
		int ArrCube[] = {
			 //0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
				0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0,//9
				0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0,//8
				0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0,//7
				0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0,//6
				0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 6, 1, 0, 0, 0,//5
				0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0,//4
				0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0,//3
				0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0,//2
				0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0,//1
				0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,//0	
		};
		
		InitArray(pCubes, ArrCube, _X, _Z);
		
		pCubePlayer.mX = 2;
		pCubePlayer.mNextX = 2;
		pCubePlayer.mZ = 3;
		pCubePlayer.mNextZ = 3;
		return pCubes;
		
	};
static public CubeNormal[][]  Level7 (CubePlayer pCubePlayer,CubeNormal[][] pCubes,int _X,int _Z){
		
		_X= 20;	
		_Z = 10;
		
		int ArrCube[] = {
			  //0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//0
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//1
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,//2
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,//3
				0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0,//4
				0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 6, 1, 0, 0, 0,//5
				0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 4, 0, 0, 1, 1, 1, 0, 0, 0,//6
				0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0,//7
				0, 0, 0, 1, 1, 3, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//8
				0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//9	
		};
		
		InitArray(pCubes, ArrCube, _X, _Z);
		
		pCubes[11][6].SetCubeLink( pCubes[5][8]);
		
		pCubePlayer.mX = 3;
		pCubePlayer.mNextX = 3;
		pCubePlayer.mZ = 5;
		pCubePlayer.mNextZ = 5;
		return pCubes;
		
	};
static public CubeNormal[][]  Level8 (CubePlayer pCubePlayer,CubeNormal[][] pCubes,int _X,int _Z){
		_X= 20;	
		_Z = 10;
		
		int ArrCube[] = {
			  //0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
				0, 0, 0, 0, 0, 1, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//0
				0, 0, 0, 0, 0, 1, 6, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//1
				0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//2
				0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0,//3
				0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0,//4
				0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0,//5
				0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0,//6
				0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0,//7
				0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0,//8
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0,//9	
		};
		
		InitArray(pCubes, ArrCube, _X, _Z);
		
		pCubes[10][6].SetCubeLink( pCubes[8][0]);
		pCubes[8][0].SetCubeLink( pCubes[8][1]);
		
		pCubePlayer.mX = 4;
		pCubePlayer.mNextX = 4;
		pCubePlayer.mZ = 5;
		pCubePlayer.mNextZ = 5;
		return pCubes;
		
		
	};
static public CubeNormal[][]  Level9 (CubePlayer pCubePlayer,CubeNormal[][] pCubes,int _X,int _Z){
		
		
		
		_X= 20;	
		_Z = 10;
		
		int ArrCube[] = {
			  //0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0,//0
				0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0,//1
				0, 0, 0, 0, 0, 0, 0, 1, 4, 1, 1, 1, 1, 1, 3, 0, 0, 0, 0, 0,//2
				0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0,//3
				0, 0, 0, 0, 0, 1, 6, 1, 3, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0,//4
				0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0,//5
				0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0,//6
				0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0,//7
				0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//8
				0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//9	
		};
		
		InitArray(pCubes, ArrCube, _X, _Z);
		
		pCubes[8][2].SetCubeLink( pCubes[14][2]);
		pCubes[14][0].SetCubeLink( pCubes[8][4]);
		
		pCubePlayer.mX = 4;
		pCubePlayer.mNextX = 4;
		pCubePlayer.mZ = 6;
		pCubePlayer.mNextZ = 6;
		return pCubes;
		
	};
static public CubeNormal[][]  Level10 (CubePlayer pCubePlayer,CubeNormal[][] pCubes,int _X,int _Z){
		
		_X= 20;	
		_Z = 10;
		
		int ArrCube[] = {
			  //0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
				0, 0, 0, 1, 1, 1, 5, 1, 1, 1, 1, 5, 1, 1, 1, 1, 0, 0, 0, 0,//0
				0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0,//1
				0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0,//2
				0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0,//3
				0, 0, 0, 1, 1, 1, 5, 5, 5, 1, 6, 1, 0, 0, 1, 1, 1, 0, 0, 0,//4
				0, 0, 0, 1, 1, 1, 0, 0, 5, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0,//5
				0, 0, 0, 0, 0, 1, 0, 0, 5, 5, 5, 5, 5, 1, 1, 0, 0, 0, 0, 0,//6
				0, 0, 0, 0, 0, 1, 1, 1, 5, 5, 1, 5, 5, 5, 0, 0, 0, 0, 0, 0,//7
				0, 0, 0, 0, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0,//8
				0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0,//9	
		};
		
		InitArray(pCubes, ArrCube, _X, _Z);
		
		
		pCubePlayer.mX = 15;
		pCubePlayer.mNextX = 15;
		pCubePlayer.mZ = 3;
		pCubePlayer.mNextZ = 3;
		return pCubes;
		
	};
static public CubeNormal[][]  Level11 (CubePlayer pCubePlayer,CubeNormal[][] pCubes,int _X,int _Z){
		
		_X= 20;	
		_Z = 10;
		
		int ArrCube[] = {
			  //0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0,//0
				0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0,//1
				0, 0, 0, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0,//2
				0, 0, 0, 1, 3, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 4, 1, 0, 0, 0,//3
				0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0,//4
				0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0,//5
				0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0,//6
				0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0,//7
				0, 0, 0, 0, 1, 1, 6, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0,//8
				0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 4, 0, 0, 0,//9	
		};
		
		InitArray(pCubes, ArrCube, _X, _Z);
		
		pCubes[4][2].SetCubeLink( pCubes[5][2]);
		pCubes[4][3].SetCubeLink( pCubes[5][3]);
		
		pCubes[15][3].SetCubeLink( pCubes[4][2]);
		pCubes[16][9].SetCubeLink( pCubes[4][3]);
		
		pCubePlayer.mX = 7;
		pCubePlayer.mNextX = 7;
		pCubePlayer.mZ = 2;
		pCubePlayer.mNextZ = 2;
		return pCubes;
		
	};
//	static public CubeNormal[][]  LevelTest (int _X,int _Z){
//		
//		_X= 20;	
//		_Z = 10;
//		CubeNormal[][] pCubes;
//		int ArrCube[] = {
//				//0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
//				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0,//9
//				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0,//8
//				0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0,//7
//				0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0,//6
//				0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0,//5
//				0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0,//4
//				0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0,//3
//				0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 5, 1, 1, 1, 0, 0, 0, 0, 0, 0,//2
//				0, 0, 0, 0, 0, 0, 0, 1, 6, 1, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0,//1
//				0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,//0		
//		};
//		
//		InitArray(pCubes, ArrCube, _X, _Z);
//		pCubes[8][8].SetCubeLink( pCubes[8][5]);
//		pCubes[13][4].SetCubeLink( pCubes[8][5]);
//		pCubes[10][8].SetCubeLink( pCubes[8][5]);
//		
//		return pCubes;
//		
//	};
		
}
