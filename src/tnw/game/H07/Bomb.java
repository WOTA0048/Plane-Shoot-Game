package tnw.game.H07;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Bomb {

	//final int WX=960;
	//final int XY=540;

	final double FRAMTIME=(1.0/60.0);//16.66666[ms]

	//蠑ｾ縺ｮ謨ｰ
	final int all=12;

	BufferedImage PNG;//

	double timer; //謨ｵ繧貞�ｺ迴ｾ縺輔○繧九ち繧､繝槭�ｼ

	double[] No=new double[all]; //繧｢繝九Γ縺ｮ繧ｳ繝�
	double[] x=new double[all]; //蠎ｧ讓�
	double[] y=new double[all];
	double[] y_sp=new double[all]; //邵ｦ譁ｹ蜷代�ｮ縺ｿ遘ｻ蜍包ｼ医せ繧ｯ繝ｭ繝ｼ繝ｫ縺ｨ蜷梧悄�ｼ�

	int[] flag=new int[all];//繧ｳ繝ｳ繝医Ο繝ｼ繝ｫ繝輔Λ繧ｰ
							//0:豸医∴繧�
							//1:蜃ｺ迴ｾ荳ｭ



	//-----------------------
	//  蛻晄悄蛹悶Γ繧ｽ繝�繝�
	//-----------------------
	public  Bomb(){

		for(int i=0;i<all;i++){

			flag[i]=0;

		}//flag

	}

	//-----------------------
	//  謨ｵ繧抵ｼ台ｽ捺凾髢薙ｒ豎ｺ繧√※蜃ｺ迴ｾ
	//-----------------------
	public void Req( double xx, double yy, double sp){

		for(int i=0;i<all;i++){
			if(flag[i]==0){
				flag[i]=1;
				No[i]=0;
				x[i]=xx+2;
				y[i]=yy+5; //蠑ｾ縺ｮ蜃ｺ迴ｾ蠎ｧ讓�
				y_sp[i]=sp; //蜍輔°縺鈴�溷ｺｦ
				break; //隕九▽縺代◆繧臥ｵゅｏ繧�
			}
		}
	}//Req

	//-----------------------
	// 襍ｷ蜍�
	//-----------------------
	public void Move(){

		//Req(200, 200);

		//遘ｻ蜍�---------------------
		for(int i=0;i<all;i++){
			if(flag[i]!=0){
				No[i]=No[i]+FRAMTIME*15; //�ｽｱ�ｾ��ｾ定ｨ育ｮ�
				y[i] += y_sp[i]*FRAMTIME; //蠎ｧ讓呵ｨ育ｮ�
				if(No[i]>=3) {
					x[i]=-100;
					y[i]=-100;
					No[i]=0;
					flag[i]=0;
				}
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
						(int)x[i],(int)y[i],(int)x[i]+16,(int)y[i]+16,//XY�ｼ井ｽ咲ｽｮ縲∽ｽ咲ｽｮ+繧ｵ繧､繧ｺ�ｼ�
						16*(int)No[i],128,16*(int)No[i]+16,144,
						Wind);
			}//flag end
		}//for end
	}//Draw End

}
