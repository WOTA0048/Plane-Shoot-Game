package tnw.game.H07;

import java.awt.Graphics2D;

//-------------------------------------------------------------------------------
//蜷榊燕繧貞虚縺九☆
//--------------------------------------------------------------------------------

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Name {

	final double FRAMTIME=(1.0/60.0); //16.666666[ms]
	final int all=61; //61譁�蟄�

	BufferedImage PNG;

	int[] Ny = new int [all]; //邵ｦ縺ｮ谿ｵ蟾ｮ�ｼ井ｽ墓ｮｵ逶ｮ�ｼ�
	double[] No = new double[all] ; //讓ｪ縺ｮ菴慕分逶ｮ

	double[] y = new double[all] ;
	double[] x = new double[all] ;

	double[] x_sp = new double[all];
	double[] y_sp = new double[all];

	double[] angle = new double[all]; //隗貞ｺｦ縲�ﾂｰ

	int[] flag = new int [all]; //謨ｵ繧偵さ繝ｳ繝医Ο繝ｼ繝ｫ縺吶ｋ縺溘ａ縺ｮ繝輔Λ繧ｰ
								//0:蠕�讖�   1:蜃ｺ迴ｾ荳ｭ   2:縺上ｋ縺上ｋ   3:讓ｪ   4:關ｽ縺｡繧�   5:謇薙◆繧�   6:豁ｻ縺ｬ

	double timer; //謨ｵ繧貞�ｺ迴ｾ縺輔○繧具ｾ��ｽｲ�ｾ擾ｽｰ

	//-----------------------
	//蛻晄悄蛹�
	//-----------------------

	public Name(){
		for (int i=0;i<all;i++){
			x[i]=-200;
			y[i]=-200;
			flag[i] = 0; //蛻晄悄蛹悶〒縺吶∋縺ｦ縺ｮ謨ｵ繧貞ｾ�讖溘＆縺帙ｋ
		}

		//縺吶∋縺ｦ縺ｮ譁�蟄励ｒ險ｭ螳壹☆繧�
		//繧ｪ繝ｬ繝ｳ繧ｸ縺ｮ----------------
		Ny[0] = 9;	No[0] = 4; //T
		Ny[1] = 8;	No[1] = 14; //N
		Ny[2] = 9;	No[2] = 7; //W
		Ny[3] = 6;	No[3] = 8; //(
		Ny[4] = 7;	No[4] = 2; //2
		Ny[5] = 7;	No[5] = 0; //0
		Ny[6] = 7;	No[6] = 1; //1
		Ny[7] = 7;	No[7] = 7; //7
		Ny[8] = 7;	No[8] = 1; //1
		Ny[9] = 7;	No[9] = 2; //1
		Ny[10] = 7;	No[10] = 1; //1
		Ny[11] = 7;	No[11] = 7; //4
		Ny[12] = 6;	No[12] = 9; //)
		Ny[13] = 7;	No[13] = 10; //:
		Ny[14] = 2;	No[14] = 8; //H
		Ny[15] = 4;	No[15] = 5; //e
		Ny[16] = 4;	No[16] = 14; //n
		Ny[17] = 4;	No[17] = 4; //d
		Ny[18] = 4;	No[18] = 1; //a
		Ny[19] = 5;	No[19] = 2; //r
		Ny[20] = 5;	No[20] = 4; //t
		Ny[21] = 4;	No[21] = 15; //o
		//逋ｽ縺ｮ----------------------
		Ny[25] = 6;	No[25] = 10; //*
		//髱偵�ｮ----------------------
		Ny[37] = 14;	No[37] = 11; //K
		Ny[38] = 16;	No[38] = 5; //e
		Ny[39] = 16;	No[39] = 14; //n
		Ny[40] = 16;	No[40] = 14; //n
		Ny[41] = 16;	No[41] = 5; //e
		Ny[42] = 16;	No[42] = 12; //l
		Ny[43] = 17;	No[43] = 9; //y
		//鮟�縺ｮ----------------------
		Ny[53] = 18;	No[53] = 10; //*

	}




	//-----------------------
	//謨ｵ繧抵ｼ台ｽ捺凾髢薙ｒ豎ｺ繧√※蜃ｺ迴ｾ
	//-----------------------
	public void Req(){

		timer -= FRAMTIME ;

		if (timer>0) return;

		timer = 0.15;

		for (int i=0;i<all;i++){   //蛻晄悄險ｭ螳�
			if (flag[i]==0) {
				x[i] = 1000;
				y[i] = 280;
				x_sp[i]=-140;
				y_sp[i]=0;
				angle[i] =0;
				flag[i] = 1; //蜃ｺ迴ｾ縺励ｍ
				break; //隕九▽縺代◆繧臥ｵゅｏ繧�
			}//flag
		}//for
	}



	//-----------------------
	//邨ｵ繧貞虚縺九☆
	//-----------------------
	public void Move(){

		Req();

		//遘ｻ蜍�----------------------

		for (int i=0;i<all;i++){

			switch(flag[i]){
			case 1:
				x[i]=x[i]+FRAMTIME*x_sp[i]; //蟾ｦ蜷代″
				if (x[i]<=0){
					x_sp[i]= 10;
					y_sp[i] = 50;
					flag[i]= 2;
				}
				break;

			case 2:
				angle[i] -= 2.0;
				x_sp[i] += 0.3 ;
				y_sp[i] += 0.6;
				x[i]= x[i]+( FRAMTIME*x_sp[i]);
				y[i]= y[i]+FRAMTIME*y_sp[i]*(Math.sin(angle[i] * Math.PI/180));
				if (x[i]>=940){
					y[i]=280;
					x_sp[i]= -140;
					y_sp[i] = 0;
					flag[i]= 3;
				}
				break;

			case 3:
				x[i]=x[i]+FRAMTIME*x_sp[i]; //蟾ｦ蜷代″
				if (x[i]<=0){
					angle[i]= 0;
					x_sp[i]= 10;
					y_sp[i] = 50;
					flag[i]= 2;
				}
				break;

			case 4:
				y_sp[i] = 100;
				y[i]=y[i]+FRAMTIME*y_sp[i]; //關ｽ縺｡繧�
				break;

			case 5:
				y_sp[i] += 10;
				y[i]=y[i]+FRAMTIME*y_sp[i]; //關ｽ縺｡繧�
				if (y_sp[i] >= 0){
					flag[i]= 4;
				}
				break;

			case 6:
				y[i]=-200;
				x_sp[i]=0;
				y_sp[i]=0;
				angle[i] =0;
				int count=0;

				for (int j=0;j<all;j++){
					if (flag[j] == 6) {
						count += 1;
					}
					if (count == all) {
						for (int k=0;k<all;k++){
							flag[k] =0;
						}
					}
				}//for

				break;
			}//switch

			//豸医∴縺溘°�ｼ�
			if(y[i]>620){flag[i]=6;}

		}//for




	}

	//繧ｰ繝ｩ繝輔ぅ繝�繧ｯ隱ｭ縺ｿ霎ｼ縺ｿ窶補�補�補�補�補�補�補��
		public void Load(){

		//繝輔ぃ繧､繝ｫ縺ｮ隱ｭ縺ｿ霎ｼ縺ｿ窶補�補�補�補�補�補�補�補�補�補�補�補��
		try{
			PNG = ImageIO.read(getClass().getResource("moji.png"));//繝輔ぃ繧､繝ｫ蜷�
		}
			catch(IOException e){//隱ｭ縺ｿ霎ｼ縺ｿ繧ｨ繝ｩ繝ｼ縺ｮ蝣ｴ蜷�
				e.printStackTrace();
		}
		}//繝｡繧ｽ繝�繝磯哩縺�

		//繧ｰ繝ｩ繝輔ぅ繝�繧ｯ陦ｨ遉ｺ窶補�補�補�補�補�補�補�補�補�補�補��
		public void Draw(JFrame Wind,Graphics2D g){

		for (int i=0;i<all;i++){
			if (flag[i]!=0){
				g.drawImage(PNG,
					(int)x[i],(int)y[i],(int)x[i]+20,(int)y[i]+20, //XY�ｼ井ｽ咲ｽｮ縲∽ｽ咲ｽｮ+繧ｵ繧､繧ｺ�ｼ�
					20*(int)No[i],20*Ny[i],20*(int)No[i]+20,20*Ny[i]+20, //
					Wind);

			} //flag
		}
	}


}
