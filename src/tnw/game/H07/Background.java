package tnw.game.H07;

//閭梧勹---------------------

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class Background {
	BufferedImage PNG;

	//蛻晄悄蛹�
	public Background(){

	}


	//繧ｰ繝ｩ繝輔ぅ繝�繧ｯ隱ｭ縺ｿ霎ｼ縺ｿ窶補�補�補�補�補�補�補��
		public void Load(){

		//繝輔ぃ繧､繝ｫ縺ｮ隱ｭ縺ｿ霎ｼ縺ｿ窶補�補�補�補�補�補�補�補�補�補�補�補��
		try{
			PNG = ImageIO.read(getClass().getResource("image/bg_02.png"));//繝輔ぃ繧､繝ｫ蜷�
		}
			catch(IOException e){//隱ｭ縺ｿ霎ｼ縺ｿ繧ｨ繝ｩ繝ｼ縺ｮ蝣ｴ蜷�
				e.printStackTrace();
		}
		}//繝｡繧ｽ繝�繝磯哩縺�

		//繧ｰ繝ｩ繝輔ぅ繝�繧ｯ陦ｨ遉ｺ窶補�補�補�補�補�補�補�補�補�補�補��
		public void Draw(JFrame Wind,Graphics2D g){


		g.drawImage(PNG,
				0,0,960,600,
				0,0,800,600,Wind); //

		}

}