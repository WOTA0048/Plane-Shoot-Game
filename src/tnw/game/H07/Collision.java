package tnw.game.H07;


//------------------------------
//陦晉ｪ∝愛螳�
//------------------------------
public class Collision {
	Aircraft AC;//繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ縺ｮ螟画焚
	Tama TM;
	Bomb BM;
	Name NM;
	Map MAP;



	//------------------------------
	// 繧ｳ繝ｳ繧ｹ繝医Λ繧ｯ繧ｿ
	//------------------------------
	public Collision(Aircraft AC,Tama TM,Bomb BM,Name NM, Map MAP){

		this.AC=AC;
		this.TM=TM;
		this.NM=NM;
		this.BM=BM;
		this.MAP=MAP;

	}//�ｽｺ�ｾ晢ｽｽ�ｾ�ｾ暦ｽｸ�ｾ�END

	//---------------------------
	// 蠑ｾ 繝槭ャ繝� 陦晉ｪ�
	//---------------------------
	public void Hit_T_M(){

		int Len1=TM.all;//蠑ｾMAX

		for(int i=0;i<Len1;i++){ //蠑ｾ縺ｮ謨ｰ
			if (TM.flag[i]!=0){

				int mx= (int)((TM.x[i]+8)/16);
				int my= (int)((TM.y[i]+8+4860-(int)MAP.yPos)/16);
				if (mx>=0 && mx<60 && my>=0 && my<34*10){ //驟榊�励�ｮ遽�蝗ｲ蜀��ｼ�
					int d= MAP.Hit_D[my][mx]; // 0 or 1
					if (d==1){ //陦晉ｪ√＠縺溘ｉ縺ｩ縺�縺吶ｋ�ｼ�
						TM.flag[i]=0; //豸医☆
						BM.Req(TM.x[i], TM.y[i],MAP.y_sp); //辷�逋ｺ
						TM.x[i]=-100;
						TM.y[i]=-100;
					}
				}//驟榊�礼ｯ�蝗ｲEND
			}
		}//蠑ｾEND
	} //Hit_T_N END

	//---------------------------
	// 閾ｪ讖� 蜷榊燕 陦晉ｪ�
	//---------------------------
	public void Hit_A_N(){

		int Len=NM.all;//驟榊�柚AX

		for(int i=0;i<Len;i++){//邱代�ｮ謨ｰ縺�縺代Ν繝ｼ繝�

			//霍晞屬縺ｮ邂怜�ｺ
			double X_sa=(AC.X+40)-(NM.x[i]+20);//蠎戊ｾｺ
			double Y_sa=(AC.Y+40)-(NM.y[i]+20);//鬮倥＆
			double D=Math.sqrt(X_sa*X_sa+Y_sa*Y_sa);
			if(D<40+20){	//陦晉ｪ√＠縺溘ｉ縺ｩ縺�縺吶ｋ�ｼ�
				NM.flag[i]=4; //關ｽ縺｡繧�

			}
		}
	}//Hit_A_N END

	//---------------------------
	// 蠑ｾ 蜷榊燕 陦晉ｪ�
	//---------------------------
	public void Hit_T_N(){

		int Len1=NM.all;//蜷榊燕MAX
		int Len2=TM.all;//蠑ｾMAX

		for(int i=0;i<Len1;i++){ //蜷榊燕縺ｮ謨ｰ
			for(int j=0;j<Len2;j++){ //蠑ｾ縺ｮ謨ｰ


				//霍晞屬蛻､螳�----------
				double X_sa=(NM.x[i]+10)-(TM.x[j]+9);//蠎戊ｾｺ
				double Y_sa=(NM.y[i]+10)-(TM.y[j]+9);//鬮倥＆

				double D=Math.sqrt(X_sa*X_sa+Y_sa*Y_sa);

				//陦晉ｪ∝愛螳�----------

				if(D<9+10){	//陦晉ｪ√＠縺溘ｉ縺ｩ縺�縺吶ｋ�ｼ�
					TM.flag[j]=0; //豸医☆
					BM.Req(TM.x[j], TM.y[j],0);  //辷�逋ｺ
					TM.x[j]=-100;
					TM.y[j]=-100;
					if (NM.flag[i]!=1){
						NM.y_sp[i] = -200;
						NM.flag[i]=5;
					}
				}

			}//蠑ｾEND
		}//蜷榊燕END
	} //Hit_T_N END

}//Class END
