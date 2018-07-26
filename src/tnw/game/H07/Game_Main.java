package tnw.game.H07;

//菴ｿ縺�縺溘＞�ｽｸ�ｾ暦ｽｽ縺ｮ蜿悶ｊ霎ｼ縺ｿ------繧ｳ繝斐�ｼ繝悶Ο繝�繧ｯ�ｼ�
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

//----------------------
//縺薙％縺九ｉ繧ｯ繝ｩ繧ｹ
//----------------------
public class Game_Main implements MouseListener,MouseMotionListener{

	//Collision CS=new Collision(CB,CG,CR);
	Background BG = new Background();
	Map MAP = new Map();
	Aircraft AC = new Aircraft();
	Tama TM = new Tama(AC);
	Bomb BM = new Bomb();
	Name NM = new Name();
	Collision CS=new Collision(AC,TM,BM,NM,MAP);


//------繧ｳ繝斐�ｼ繝悶Ο繝�繧ｯ2
	final float FrameTime=1.0f/60.0f;//0.031f;
	final int X_Size=960;//�ｽｹ�ｾ橸ｽｰ�ｾ托ｽｳ�ｽｨ�ｾ晢ｾ�ｾ槭�ｮ讓ｪ�ｽｻ�ｽｲ�ｽｽ�ｾ�
	final int Y_Size=540;//�ｽｹ�ｾ橸ｽｰ�ｾ托ｽｳ�ｽｨ�ｾ晢ｾ�ｾ槭�ｮ邵ｦ�ｽｻ�ｽｲ�ｽｽ�ｾ�
	JFrame	Wind=new JFrame("JAVA 課題");//JFrame 縺ｮ蛻晄悄蛹�(�ｾ抵ｾ��ｽｭ�ｽｰ�ｾ奇ｾ橸ｽｰ縺ｮ陦ｨ遉ｺ�ｾ��ｽｲ�ｾ�ｾ�
	BufferStrategy	offimage;//�ｾ��ｾ橸ｾ鯉ｾ橸ｾ呻ｾ奇ｾ橸ｽｯ�ｾ鯉ｽｧ縺ｧ縺｡繧峨▽縺埼亟豁｢
	Insets sz;//�ｾ抵ｾ��ｽｭ�ｽｰ�ｾ奇ｾ橸ｽｰ縺ｮ�ｽｻ�ｽｲ�ｽｽ�ｾ�

	Font	f=new	Font("Default",Font.BOLD,24);//菴ｿ逕ｨ縺吶ｋ繝輔か繝ｳ繝医け繝ｩ繧ｹ螳｣險�

	//------繧ｳ繝斐�ｼ繝悶Ο繝�繧ｯ3
	//-----------------------------
	//	蛻晄悄蛹也畑縺ｮ髢｢謨ｰ
	//	繝ｻWindow逕滓��
	//	繝ｻWindow螟ｧ縺阪＆縺ｮ謖�螳�
	//	繝ｻWindow縺ｮ蝣ｴ謇�
	//-----------------------------
	Game_Main(){


		Wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//髢峨§�ｾ趣ｾ橸ｾ��ｾ晁ｨｱ蜿ｯ
		Wind.setBackground(new Color(0,0,0));//濶ｲ謖�螳�
		Wind.setResizable(false);//�ｽｻ�ｽｲ�ｽｽ�ｾ槫､画峩荳榊庄
		Wind.setVisible(true);//陦ｨ遉ｺor髱櫁｡ｨ遉ｺ

		sz=Wind.getInsets();//�ｾ抵ｾ��ｽｭ�ｽｰ�ｾ奇ｾ橸ｽｰ縺ｮ�ｽｻ�ｽｲ�ｽｽ�ｾ�
		Wind.setSize(X_Size, Y_Size+sz.top+sz.bottom);//�ｽｳ�ｽｨ�ｾ晢ｾ�ｾ橸ｽｳ縺ｮ�ｽｻ�ｽｲ�ｽｽ�ｾ�
		Wind.setLocationRelativeTo(null);//荳ｭ螟ｮ縺ｫ陦ｨ遉ｺ

		//縺｡繧峨▽縺埼亟豁｢縺ｮ險ｭ螳�(�ｾ��ｾ橸ｾ鯉ｾ橸ｾ呻ｾ奇ｾ橸ｽｯ�ｾ鯉ｽｧ�ｾ假ｾ晢ｽｸ�ｾ�)-------------------------------------
		Wind.setIgnoreRepaint(true);//JFrame縺ｮ讓呎ｺ匁嶌縺肴鋤縺亥�ｦ逅�辟｡蜉ｹ
		Wind.createBufferStrategy(2);//2縺ｧ�ｾ��ｾ橸ｾ鯉ｾ橸ｾ�
		offimage=Wind.getBufferStrategy();

		//蜈･蜉幃未騾｣縺ｮ蛻晄悄蛹�
		Wind.addMouseListener(this);
		Wind.addMouseMotionListener(this);


		//繝輔ぃ繧､繝ｫ縺ｮ隱ｭ縺ｿ霎ｼ縺ｿ
		BG.Load();
		MAP.Load();
		AC.Load();
		TM.Load();
		BM.Load();
		NM.Load();


		//�ｾ��ｽｲ�ｾ擾ｽｰ�ｾ��ｽｽ�ｽｸ襍ｷ蜍�----------------------------
		Timer	TM=new	Timer();//�ｾ��ｽｲ�ｾ擾ｽｰ�ｽｸ�ｾ暦ｽｽ縺ｮ螳滉ｽ灘喧
		TM.schedule(new timer_TSK(), 17, 17);//17ms蠕後°繧� 17ms縺翫″縺ｫ
						//縺ｩ縺難ｼ溘��縲�縲�17[ms]=繝励Ο繧ｰ繝ｩ繝�縺悟虚縺榊�ｺ縺呎怙蛻昴�ｮ譎る俣
						//            17[ms]縺昴�ｮ蠕後�ｯ17[ms]郢ｰ繧願ｿ斐＠

	}//Main_Game end



	//------繧ｳ繝斐�ｼ繝悶Ο繝�繧ｯ4
	//---------------------------
	//	�ｾ��ｽｲ�ｾ擾ｽｰ�ｽｸ�ｾ暦ｽｽ縲�1/60遘偵〒1蝗槫虚菴�
	//	extends=邯呎価
	//---------------------------
	class	timer_TSK extends	TimerTask{

		public void run() {

			MAP.Move();
			AC.Move();
			TM.Move();
			BM.Move();
			NM.Move();
			CS.Hit_A_N();
			CS.Hit_T_N();
			CS.Hit_T_M();

			Graphics	g2=offimage.getDrawGraphics();//�ｽｸ�ｾ橸ｾ暦ｾ鯉ｽｨ�ｽｯ�ｽｸ蛻晄悄蛹�
			Graphics2D 	g = (Graphics2D) g2;


			if(offimage.contentsLost()==false)
			{//蛻ｩ蜿ｯ閭ｽ??
				g.translate(sz.left, sz.top);//�ｾ抵ｾ��ｽｭ�ｽｰ�ｾ奇ｾ橸ｽｰ縺ｮ�ｽｻ�ｽｲ�ｽｽ�ｾ櫁｣懈ｭ｣
				g.clearRect(0, 0, X_Size, Y_Size);//逕ｻ髱｢�ｽｸ�ｾ假ｽｱ(蟾ｦ荳街縲∝ｷｦ荳該縲∝承荳休縲∝承荳及)
				g.setColor(Color.BLACK);//濶ｲ謖�螳�
				g.fillRect(0, 0, X_Size, Y_Size);//蝪励ｊ縺､縺ｶ縺�

			//--------------------------------------------------
				//邨ｵ繧�譁�蟄励ｒ陦ｨ遉ｺ

				BG.Draw(Wind, g);
				MAP.Draw(Wind, g);
				AC.Draw(g, Wind);
				TM.Draw(g, Wind);
				BM.Draw(g, Wind);
				NM.Draw(Wind, g);

				//譁�蟄励�ｮ陦ｨ遉ｺ
				g.setColor(Color.GREEN);//濶ｲ謖�螳�
				g.setFont(f);
				g.drawString("1G-H ヘンダルトケネリー",10,Y_Size-10);

			//---------------------------------------------------
				offimage.show();//�ｾ��ｾ橸ｾ鯉ｾ橸ｾ呻ｾ奇ｾ橸ｽｯ�ｾ鯉ｽｧ縺ｮ蛻�繧頑崛縺�
				g.dispose();//�ｽｸ�ｾ橸ｾ暦ｾ鯉ｽｨ�ｽｯ�ｽｸ�ｽｲ�ｾ晢ｽｽ�ｾ��ｾ晢ｽｽ縺ｮ遐ｴ譽�

			}//if end �ｽｸ�ｾ橸ｾ暦ｾ鯉ｽｨ�ｽｯ�ｽｸOK??



		}//run end
	}//timer task class end




	//-----------------------------------
	//	Main 縺薙％縺九ｉ繝励Ο繧ｰ繝ｩ繝�縺悟虚縺�
	//-----------------------------------
	public static void main(String[] args) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�
		//Main_Game縺ｮ�ｽｸ�ｾ暦ｽｽ繧竪M縺ｨ縺�縺�蜷榊燕縺ｧ蜍輔°縺励∪縺�
		//蜍輔°縺吝燕縺ｫ蛻晄悄蛹悶＠縺ｦ縺九ｉ蜍輔°縺呻ｼ�ｼ�

		//------繧ｳ繝斐�ｼ繝悶Ο繝�繧ｯ5縺薙％縺ｯ�ｽｸ�ｾ暦ｽｽ蜷阪ｒ險伜�･-----
		Game_Main GM=new Game_Main();

	}




	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�

	}




	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�

		//Window蟷�險ｭ螳�
		Insets sz=Wind.getInsets();
		AC.X=e.getX()-sz.left-50; //-50縺ｯ髱剃ｸｸ縺ｮ逵溘ｓ荳ｭ
		AC.Y=e.getY()-sz.top-50;
	}




	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�

	}




	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�

	}




	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�

	}




	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�

	}




	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�繝峨�ｻ繧ｹ繧ｿ繝�

	}

}

