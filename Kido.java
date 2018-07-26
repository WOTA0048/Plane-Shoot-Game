package tnw.game.g10;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Kido{
    Font f = new Font("Default", 2, 24);
    final double FrameTime = 0.016;
    final double Speed = 200.0;
    final int Max = 200;
    BufferedImage PNG;
    double[] ani = new double[Max];
    double[] X = new double[Max];
    double[] Y = new double[Max];
    double[] X_sp = new double[Max];
    double[] Y_sp = new double[Max];
    double[] X_spg = new double[Max];
    double[] Y_spg = new double[Max];
    double[] Kaku = new double[Max];
    int[] Nx = new int[Max];
    int[] Ny = new int[Max];
    double[] R = new double[Max];
    int[] flag2 = new int[Max];
    int[] flag = new int[Max];
    double timer;
    int counter;
    int col_no;
    String Name = "TNW";
    String Name2 = "TNW";
    Jtama JT;

    public Kido() {
       for(int i = 0; i < 200; ++i) {
          flag[i] = 99;
          col_no = 0;
       }

    }




    public void Req() {
       timer -= 0.016;
       if(timer < 0.0) {
          timer = 0.10;
          for(int i = 0; i < 200; ++i) {

             if(flag[i] == 99) {
                char N = Name2.charAt(i);
                if(N == 35) {
                   col_no = 0;

                } else {
                   if(N == 58) {
                      ++col_no;                  }
                   Nx[i] = (N - 32) % 16;
                   Ny[i] = (N - 32) / 16;
                   Ny[i] += 6 * col_no;
                   X[i] = 960.0;
                   Y[i] = 240.0;
                   X_sp[i] = -200.0;
                   Y_sp[i] = 200.0;
                   Kaku[i] = 180.0;
                   flag[i] = 0;
                }               break;            }
          }
       }

    }





    public void Update() {
       Req();
       int cnt;
       for(cnt = 0; cnt < 200; ++cnt) {

       if(flag[cnt] < 99) {

          if(flag2[cnt] == 0) {
             X[cnt] += 0.016 * X_sp[cnt];
             Y[cnt] += 0.016 * Y_sp[cnt] * (double)((float)Math.sin(Kaku[cnt] * 3.14 / 180.0));

          } else {
                Y_sp[cnt] += 0.016 * Y_spg[cnt];
                Y[cnt] += 0.016 * Y_sp[cnt];

             }

             double a = Jiki.X + 48.0 - (X[cnt] + 8.0);
             double Y_sa = Jiki.Y + 58.0 - (Y[cnt] + 8.0);
             double D = Math.sqrt(a * a + Y_sa * Y_sa);
             if(D < 30.0 && flag2[cnt] == 0) {

                X_sp[cnt] = 0.0;
                Y_sp[cnt] = 10.0;
                Y_spg[cnt] = 200.0;
                flag2[cnt] = 1;

             }

             if(JT.Hit(X[cnt], Y[cnt]) == 1 && flag[cnt] != 0) {
                X_sp[cnt] = 0.0;
                Y_sp[cnt] = -200.0;
                Y_spg[cnt] = 200.0;
                flag2[cnt] = 1;

             }

             switch(flag[cnt]) {
             case 0:
                if(X[cnt] < 0.0) {
                   X_sp[cnt] = 50.0;
                   Y_sp[cnt] = 50.0;
                   Kaku[cnt] = 270.0;
                   flag[cnt] = 1;
                }
                break;
             case 1:
                Kaku[cnt] += 3.0;
                X_sp[cnt] += 0.3;
                Y_sp[cnt] += 0.75;
                if(X[cnt] > 940.0) {
                   flag[cnt] = 0;
                   X_sp[cnt] = -200.0;
                   Y_sp[cnt] = 0.0;
                   flag[cnt] = 2;
                }
                break;
             case 2:
                if(X[cnt] < 0.0) {
                   X_sp[cnt] = 50.0;
                   Y_sp[cnt] = 50.0;
                   Kaku[cnt] = 270.0;
                   flag[cnt] = 1;



                }
             }

             if(640.0 < Y[cnt]) {
                flag2[cnt] = 2;


             }
          }
       }

       cnt = 0;      int arg;
       for(arg = 0; arg < 200; ++arg) {
          if(flag2[arg] == 2) {
             ++cnt;
          }
       }
       arg = Name2.length() - 1;
       if(cnt == arg) {
          for(int i = 0; i < 200; ++i) {
             flag[i] = 99;
             flag2[i] = 0;


          }
       }

    }

    public void Disp(Graphics2D g, JFrame Wind) {
       for(int i = 0; i < 200; ++i) {
          if(flag[i] != 99) {


       g.drawImage(PNG, (int)X[i], (int)Y[i], (int)X[i] + 20, (int)Y[i] + 20,
            	 20 * Nx[i], 20 * Ny[i], 20 * Nx[i] + 20, 20 * Ny[i] + 20,
            	 	Wind);
          }
       }

    }

    public void Load() {
       try {
          PNG = ImageIO.read(this.getClass().getResource("image2/moji.png"));

       } catch (IOException arg1) {
          arg1.printStackTrace();
       }

    }
 }