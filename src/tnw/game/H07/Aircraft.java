package tnw.game.H07;

//閾ｪ蛻�縺ｮ謌ｦ讖�---------------------

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

	//---------------------------------
	// 髱剃ｸｸ�ｼ郁�ｪ讖滂ｼ壹�槭え繧ｹ遘ｻ蜍包ｼ�
	//---------------------------------
	public class Aircraft {


		BufferedImage PNG;//
		double X,Y;

		//---------------------------
		//  蛻晄悄蛹悶Γ繧ｽ繝�繝�(�ｽｺ�ｾ晢ｽｽ�ｾ�ｾ暦ｽｸ�ｾ��ｼ�
		//---------------------------
		public Aircraft(){

			X=100;
			Y=100;

		}// 蛻晄悄蛹悶Γ繧ｽ繝�繝�



		//-----------------------
		//  繝輔ぃ繧､繝ｫ縺ｮ隱ｭ縺ｿ霎ｼ縺ｿ
		//-----------------------
		public void Load(){
			try {
				PNG = ImageIO.read(getClass().getResource("image/jiki2.png"));// 繝輔ぃ繧､繝ｫ蜷�
				} catch (IOException e) {// 隱ｭ縺ｿ霎ｼ縺ｿ繧ｨ繝ｩ繝ｼ縺ｮ蝣ｴ蜷�
				e.printStackTrace();
				}

		}//Load End



		//-----------------------
		//  繝輔ぃ繧､繝ｫ縺ｮ陦ｨ遉ｺ
		//-----------------------
		public void Draw(Graphics2D 	g,JFrame	Wind){


				g.drawImage(PNG,
						(int)X,(int)Y,(int)X+100,(int)Y+100,//XY�ｼ井ｽ咲ｽｮ縲∽ｽ咲ｽｮ+繧ｵ繧､繧ｺ�ｼ�
						0,0,100,100,
						Wind);

		}//Draw End


		//-----------------------
		//  邨ｵ繧貞虚縺九☆
		//-----------------------
		public void Move(){



		}//Move End
	}//Class End