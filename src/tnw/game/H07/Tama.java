package tnw.game.H07;

//蠑ｾ---------------------------------

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class Tama {

	final double FRAMTIME=(1.0/60.0);//16.66666[ms]
	Aircraft AC;//繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ縺ｮ螟画焚

	BufferedImage PNG;//

	//蠑ｾ縺ｮ謨ｰ
	final int all=12;

	double[] No=new double[all]; //繧｢繝九Γ縺ｮ繧ｳ繝�
	double[] x=new double[all]; //蠎ｧ讓�
	double[] y=new double[all];
	double[] x_sp=new double[all]; //蛻晞��
	double[] y_sp=new double[all];


	int[] flag=new int[all];//繧ｳ繝ｳ繝医Ο繝ｼ繝ｫ繝輔Λ繧ｰ
								//0:豸医∴繧�
								//1:蜃ｺ迴ｾ荳ｭ

	double timer; //謨ｵ繧貞�ｺ迴ｾ縺輔○繧九ち繧､繝槭�ｼ


	//-----------------------
	//  蛻晄悄蛹悶Γ繧ｽ繝�繝�
	//-----------------------
	public  Tama(Aircraft AC){

		this.AC=AC;

		for(int i=0;i<all;i++){

			flag[i]=0;

		}//flag

	}
// 蛻晄悄蛹悶Γ繧ｽ繝�繝�



	//-----------------------
	//  謨ｵ繧抵ｼ台ｽ捺凾髢薙ｒ豎ｺ繧√※蜃ｺ迴ｾ
	//-----------------------
	public void Req(){

		timer -= FRAMTIME ;

		if (timer>0) return;

		timer=0.2;


		for(int i=0;i<all;i++){
			if(flag[i]==0){
				x[i]=AC.X+20;
				y[i]=AC.Y-20; //蠑ｾ縺ｮ蜃ｺ迴ｾ蠎ｧ讓�
				No[i]=0;
				y_sp[i]=-300; //-荳翫�ｮ譁ｹ遘ｻ蜍輔��+荳九�ｮ譁ｹ遘ｻ蜍�

				flag[i]=1; //蜃ｺ迴ｾ縺励ｍ

				break; //隕九▽縺代◆繧臥ｵゅｏ繧�
			}
		}
	}//Req

	//-----------------------
	// 襍ｷ蜍�
	//-----------------------
	public void Move(){
		//遘ｻ蜍�---------------------

		Req();


		for(int i=0;i<all;i++){
			if(flag[i]!=0){
				y[i]=y[i]+FRAMTIME*y_sp[i];

				//豸医∴縺溘°�ｼ滂ｼ�
				if(x[i]>960){flag[i]=0;}//讓ｪ蠎ｧ讓吶�ｮ繝√ぉ繝�繧ｯ(960-謨ｰ蟄�) 讓ｪ謚懊￠蜃ｺ縺苓ｨｭ螳�
				if(y[i]>600){flag[i]=0;}//邵ｦ蠎ｧ讓吶�ｮ繝√ぉ繝�繧ｯ(540-謨ｰ蟄�) 邵ｦ謚懊￠蜃ｺ縺苓ｨｭ螳�
				if(x[i]<-40){flag[i]=0;}//讓ｪ蠎ｧ讓吶�ｮ繝√ぉ繝�繧ｯ 48縺ｯ繧ｭ繝｣繝ｩ繧ｵ繧､繧ｺ
				if(y[i]<-40){flag[i]=0;}//邵ｦ蠎ｧ讓吶�ｮ繝√ぉ繝�繧ｯ


			}//if end
		}//for end
	}//Move End

	//-----------------------
	//  繝輔ぃ繧､繝ｫ縺ｮ隱ｭ縺ｿ霎ｼ縺ｿ
	//-----------------------
	public void Load(){
		try {
			PNG = ImageIO.read(getClass().getResource("tama.png"));// 繝輔ぃ繧､繝ｫ蜷�
			} catch (IOException e) {// 隱ｭ縺ｿ霎ｼ縺ｿ繧ｨ繝ｩ繝ｼ縺ｮ蝣ｴ蜷�
			e.printStackTrace();
			}

	}//Load End



	//-----------------------
	//  繝輔ぃ繧､繝ｫ縺ｮ陦ｨ遉ｺ
	//-----------------------
	public void Draw(Graphics2D 	g,JFrame	Wind){
		for(int i=0; i<all; i++) {
			if(flag[i]!=0){
				g.drawImage(PNG,
						(int)x[i],(int)y[i],(int)x[i]+18,(int)y[i]+18,//XY�ｼ井ｽ咲ｽｮ縲∽ｽ咲ｽｮ+繧ｵ繧､繧ｺ�ｼ�
						270,30,288,48,
						Wind);
			}//flag end
		}//for end
	}//Draw End


}