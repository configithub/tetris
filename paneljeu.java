import java.awt.*;
import javax.swing.*;
import javax.swing.JComponent;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.Graphics.*;
import java.awt.image.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.applet.*;
import java.applet.Applet;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.net.*;




public class paneljeu extends JLabel {
	

	int i[] = new int[10000];
	int j[] = new int[10000];
	int ip;
	int jp;
	int up;
	int x[] = new int[10];
	int y[] = new int[26];
	int signature[][] = new int[10][26];
	boolean xynonoqp[][] = new boolean[10][26];
	boolean D[][] = new boolean[10][26];
	boolean ligneoqp[] = new boolean[26];
	boolean libredroite;
	boolean libregauche;
	boolean librebas;
	boolean librerotat;
	int lvl;
	int d;
	int e;
	int polyx[][] = new int[1][8];
	int polyy[][] = new int[1][8];
	int k;
	int t;
	int t0;
	int nblignecassee;
	int jmax;
	int ie;
	int je;
	int jd;
	int id;
	int jl;
	int il;
	int nbl;
	boolean cassage;
	boolean gover;
	boolean gover1;
	public static final int VK_LEFT = 37;
	public static final int VK_RIGHT = 39;
	public static final int VK_DOWN = 40;
	public static final int VK_UP = 38;
	Random piece = new Random();
	int quellepiece;
	Graphics buffer;
	Image image;
	Graphics bufferzig;
	Image imagezig;
	Graphics bufferzag;
	Image imagezag;
	Graphics bufferbarre;
	Image imagebarre;
	Graphics buffert;
	Image imaget;
	Graphics bufferl;
	Image imagel;
	Graphics bufferle;
	Image imagele;
	Graphics buffer1;
	Image image1;
	URL tocurl;
	Applet applet;
	AudioClip toc;
	
	URL lignedispurl;
	AudioClip lignedisp;
	
	URL tetrisdispurl;
	AudioClip tetrisdisp;
	
	URL musicurl;
	AudioClip music;
	
	URL lvlupurl;
	AudioClip lvlup;
	
	URL gameoverurl;
	AudioClip gameoverwav;
	
	public paneljeu() {
		
		try{
		tocurl=new URL("file:" + new File(".").getCanonicalPath()+"/" + "toc.wav");
		
			toc = applet.newAudioClip(tocurl);
		}catch(Exception e){
            System.out.println(e.toString());
        }
        
        try{
		lignedispurl=new URL("file:" + new File(".").getCanonicalPath()+"/" + "lignedisp.wav");
		
			lignedisp = applet.newAudioClip(lignedispurl);
		}catch(Exception e){
            System.out.println(e.toString());
        }
        
        try{
		tetrisdispurl=new URL("file:" + new File(".").getCanonicalPath()+"/" + "tetrisdisp.wav");
		
			tetrisdisp = applet.newAudioClip(tetrisdispurl);
		}catch(Exception e){
            System.out.println(e.toString());
        }
        
        try{
		musicurl=new URL("file:" + new File(".").getCanonicalPath()+"/" + "music.wav");
		
			music = applet.newAudioClip(musicurl);
		}catch(Exception e){
            System.out.println(e.toString());
        }
        
        try{
		lvlupurl=new URL("file:" + new File(".").getCanonicalPath()+"/" + "lvlup.wav");
		
			lvlup = applet.newAudioClip(lvlupurl);
		}catch(Exception e){
            System.out.println(e.toString());
        }
        
        try{
		gameoverurl=new URL("file:" + new File(".").getCanonicalPath()+"/" + "gameover.wav");
		
			gameoverwav = applet.newAudioClip(gameoverurl);
		}catch(Exception e){
            System.out.println(e.toString());
        }
        
		
		super.setOpaque(false);
		
	
		for (k=0;k<1;k++){
		polyx[k][0]=3+21*k;
		polyx[k][1]=18+21*k;
		polyx[k][2]=21+21*k;
		polyx[k][3]=21+21*k;
		polyx[k][4]=18+21*k;
		polyx[k][5]=3+21*k;
		polyx[k][6]=0+21*k;
		polyx[k][7]=0+21*k;
		
      	polyy[k][0]=0+21*k;
		polyy[k][1]=0+21*k;
		polyy[k][2]=3+21*k;
		polyy[k][3]=18+21*k;
		polyy[k][4]=21+21*k;
		polyy[k][5]=21+21*k;
		polyy[k][6]=18+21*k;
		polyy[k][7]=3+21*k;
      	}
      	
		super.setFocusable(true);
		requestFocusInWindow();
		cassage=false;
		gover=false;
		gover1=false;
		
		
		for (t=0;t<100;t++) {
			for (i[t]=0;i[t]<10;i[t]++) {
				x[i[t]]=22*i[t];
			};
		
			for (j[t]=0;j[t]<25;j[t]++) {
				y[j[t]]=22*j[t];
			};
		};
		
		for (jp=0;jp<26;jp++){
			ligneoqp[jp]=false;
		}
		
		for (k=0;k<10;k++) {
			for(t=0;t<26;t++){
				xynonoqp[k][t]=true;
			}
		}
		
		for (t=0;t<1000;t++) {
			i[t] = 0;
			j[t] = 0;
		
		}
		
		//touche gauche
		KeyListener LeftListener = new KeyListener(){
       		public void keyPressed(KeyEvent e ) {
       			if (e.getKeyCode()==VK_LEFT){
       				
       				if (libregauche){
       				i[t]=i[t]-1;
       				
       				
       					updatelibre();
       					repaint();
       				
       					
       				
       				}
       			}
       		}
       		public void keyReleased(KeyEvent e ) {}
       		public void keyTyped(KeyEvent e ) {}
       	};
       	addKeyListener(LeftListener);
       	
       	
       	
       	//touche droite
       	KeyListener RightListener = new KeyListener(){
			public void keyPressed(KeyEvent e ) {
       			if (e.getKeyCode()==VK_RIGHT){
       			
       				if (libredroite){
       				i[t]=i[t]+1;
       				
       					updatelibre();
       					repaint();
       				
       				
       				}
       			}
       		}
       		public void keyReleased(KeyEvent e ) {}
       		public void keyTyped(KeyEvent e ) {}
       	};
       	addKeyListener(RightListener);
       	
       	
       	
       	//touche bas
       	KeyListener DownListener = new KeyListener(){
       		public void keyPressed(KeyEvent e ) {
       			if (e.getKeyCode()==VK_DOWN){
       			
       				if (librebas) {
       				j[t]=j[t]+1;
       			
       				
       					updatelibre();
       					repaint();
       				
       				
       				}
       			}
       		}
       		public void keyReleased(KeyEvent e ) {}
       		public void keyTyped(KeyEvent e ) {}
       	};
       	addKeyListener(DownListener);
       	
       	//touche haut
       	KeyListener UpListener = new KeyListener(){
       		public void keyPressed(KeyEvent e ) {
       			if (e.getKeyCode()==VK_UP){
       				
       				if (librerotat){
       				
       					if(up<3){
       					up=up+1;
       					}else{
       						up=0;
       					}
       					updatelibre();
       					repaint();
       				}
       				
       			}
       		}
       		public void keyReleased(KeyEvent e ) {}
       		public void keyTyped(KeyEvent e ) {}
       	};
       	addKeyListener(UpListener);
		
	
		
		t=0;
		nblignecassee=0;
		music.loop();
				piecechutte();
				
		
		
		
	};
	
	public void randompiece() {
		quellepiece = piece.nextInt(7);
		up=0;
		piecechutte();
		
	}
	
	
	public void piecechutte() {
	
		
		//position initale de la piece
		
		j[t]=0;
		i[t]=5;
		
		//limites de la piece pour les collisions
		updatelibre();
		
	
		
		
		//initialisation du boolean qui indique si la piece est immobile ou non 
		//(contact avec les autres pieces ou avec la limite basse du panel
		
		
		//lancement du timer chutte des pieces
		
		final Timer T = new Timer();
		T.schedule(new TimerTask() {public void run() {
										if(gover==false){
										
											if(librebas){ 
											
												j[t]=j[t]+1;
												updatelibre();
												
												repaint();
												
											
			
											}else{
												T.cancel();
												toc.play();
												lvl = lignecassee()/5;
												
												System.out.println(lvl);
												
												updateoccupation();
												
											
												
												
												updateligne();
											
												lignecassee();
												System.out.println("ligne cassée : "+nblignecassee);
												t=t+1;
												
												randompiece();
												
												gameover0();
												
												
												
											}
										}else{
											T.cancel();
											gover1=true;
											music.stop();
											gameoverwav.play();
											id=0;
											jd=0;
											final Timer E = new Timer();
											E.schedule(new TimerTask() {public void run(){
												
												if(id==9){
													
													if(jd<24){
														D[id][jd]=true;
														jd=jd+1;
														id=id-9;
														
														repaint();
													}else{
														E.cancel();
														return;
													}
												}else{
													D[id][jd]=true;
													id=id+1;
													
													repaint();
												}
												
												
												
												
												}},100,5);
											
											il=0;
											jl=0;
												
												final Timer F = new Timer();
											F.schedule(new TimerTask() {public void run(){
												
												if(il==9){
													
													if(jl<24){
														D[il][jl]=false;
														jl=jl+1;
														il=il-9;
														repaint();
													}else{
														F.cancel();
														return;
													}
												}else{
													D[il][jl]=false;
													il=il+1;
													
													repaint();
												}
												
												
												
												
												}},1500,5);
												
											repaint();
											
											System.out.println(gover1);
											return;
												
										}
		 							}
		 },5,1000-99*lvl);   	
       				
	}
	
	
	
	public void paintComponent(Graphics m) {
		
		
		super.paintComponent(m);
		
		
		
		
		
		//carre
		if(buffer==null){
			
        image = createImage(22,22);
        buffer = image.getGraphics();
        }
       	
       	buffer.setColor(new Color(0,0,0,0));
		buffer.fillRect(0,0,22,22);
       	
        buffer.setColor(Color.green);
		buffer.fillRoundRect(0,0,21,21,4,4);
		
		
		buffer.setColor(Color.black);
		buffer.drawPolygon(polyx[0], polyy[0], 8);
		buffer.drawString(":p",7,15);
		
		//zig
		if(bufferzig==null){
			
        imagezig = createImage(22,22);
        bufferzig = imagezig.getGraphics();
        }
       	
       	//bufferzig.setColor(Color.white);
		//bufferzig.fillRect(0,0,22,22);
       	
        bufferzig.setColor(Color.magenta);
		bufferzig.fillRoundRect(0,0,21,21,4,4);
		
		
		bufferzig.setColor(Color.black);
		bufferzig.drawPolygon(polyx[0], polyy[0], 8);
		bufferzig.drawString(":o",7,15);
		
		
		//zag
		if(bufferzag==null){
		
        imagezag = createImage(22,22);
        bufferzag = imagezag.getGraphics();
        }
        
        //bufferzag.setColor(Color.white);
		//bufferzag.fillRect(0,0,22,22);
       	
       	
        bufferzag.setColor(Color.yellow);
		bufferzag.fillRoundRect(0,0,21,21,4,4);
		
		
		bufferzag.setColor(Color.black);
		bufferzag.drawPolygon(polyx[0], polyy[0], 8);
		bufferzag.drawString(":/",7,15);
		
		//barre
		if(bufferbarre==null){
			
        imagebarre = createImage(22,22);
        bufferbarre = imagebarre.getGraphics();
        }
        
        //bufferbarre.setColor(Color.white);
		//bufferbarre.fillRect(0,0,22,22);
       
       	
        bufferbarre.setColor(Color.orange);
		bufferbarre.fillRoundRect(0,0,21,21,4,4);
		
		
		bufferbarre.setColor(Color.black);
		bufferbarre.drawPolygon(polyx[0], polyy[0], 8);
		bufferbarre.drawString(":|",7,15);
		
		//T
		if(buffert==null){
		
        imaget = createImage(22,22);
        buffert = imaget.getGraphics();
        }
        
        //buffert.setColor(Color.white);
		//buffert.fillRect(0,0,22,22);
       	
       	
        buffert.setColor(new Color(187, 207, 223));
		buffert.fillRoundRect(0,0,21,21,4,4);
		
		
		buffert.setColor(Color.black);
		buffert.drawPolygon(polyx[0], polyy[0], 8);
		buffert.drawString(":b",7,15);
		
		//L
		if(bufferl==null){
			
        imagel = createImage(22,22);
        bufferl = imagel.getGraphics();
        }
       	
       	//bufferl.setColor(Color.white);
		//bufferl.fillRect(0,0,22,22);
       	
        bufferl.setColor(Color.red);
		bufferl.fillRoundRect(0,0,21,21,4,4);
		
		
		bufferl.setColor(Color.black);
		bufferl.drawPolygon(polyx[0], polyy[0], 8);
		bufferl.drawString("q:",7,15);
		
		//Lenvers
		if(bufferle==null){
			
        imagele = createImage(22,22);
        bufferle = imagele.getGraphics();
        }
       	
       	//bufferle.setColor(Color.white);
		//bufferle.fillRect(0,0,22,22);
       	
        bufferle.setColor(new Color(0, 145, 255));
		bufferle.fillRoundRect(0,0,21,21,4,4);
		
		
		bufferle.setColor(Color.black);
		bufferle.drawPolygon(polyx[0], polyy[0], 8);
		bufferle.drawString("d:",7,15);
		
		if(buffer1==null){
			
        image1 = createImage(22,22);
        buffer1 = image1.getGraphics();
        }
        
        buffer1.setColor(Color.white);
		buffer1.fillRect(0,0,22,22);
       	
       	buffer1.setColor(Color.black);
		buffer1.drawString(":D",7,15);
		
		for(jp=0;jp<26;jp++){
			for(ip=0;ip<10;ip++){
				if (D[ip][jp]==true){
					m.drawImage(image1, x[ip], y[jp], this);
				}
			
			}
		}
		
		if(gover1==false){
		
		
		for(jp=0;jp<26;jp++){
			for(ip=0;ip<10;ip++){
				if (xynonoqp[ip][jp]==false){
					if (signature[ip][jp]==1) {
						m.drawImage(image, x[ip], y[jp], this);
					}else if(signature[ip][jp]==2){
						m.drawImage(imagezig, x[ip], y[jp], this);
					}else if (signature[ip][jp]==3){
						m.drawImage(imagezag, x[ip], y[jp], this);
					}else if (signature[ip][jp]==4){
						m.drawImage(imagebarre, x[ip], y[jp], this);
					}else if (signature[ip][jp]==5){
						m.drawImage(imaget, x[ip], y[jp], this);
					}else if (signature[ip][jp]==6){
						m.drawImage(imagel, x[ip], y[jp], this);
					}else if (signature[ip][jp]==7){
						m.drawImage(imagele, x[ip], y[jp], this);
					}
				}						
			}
		}
		
		for(jp=0;jp<26;jp++){
			for(ip=0;ip<10;ip++){
				if (D[ip][jp]==true){
					m.drawImage(image1, x[ip], y[jp], this);
				}
			
			}
		}
		
		
		
		if(quellepiece==0){
			m.drawImage(image, x[i[t]], y[j[t]], this);
			m.drawImage(image, x[i[t]+1], y[j[t]], this);
			m.drawImage(image, x[i[t]], y[j[t]+1], this);
			m.drawImage(image, x[i[t]+1], y[j[t]+1], this);
		}else if(quellepiece==1){
			if(up%2==0){
				m.drawImage(imagezig, x[i[t]], y[j[t]], this);
				m.drawImage(imagezig, x[i[t]+1], y[j[t]+2], this);
				m.drawImage(imagezig, x[i[t]], y[j[t]+1], this);
				m.drawImage(imagezig, x[i[t]+1], y[j[t]+1], this);
			}else{
				m.drawImage(imagezig, x[i[t]], y[j[t]+1], this);
				m.drawImage(imagezig, x[i[t]+1], y[j[t]+1], this);
				m.drawImage(imagezig, x[i[t]], y[j[t]+2], this);
				m.drawImage(imagezig, x[i[t]-1], y[j[t]+2], this);
			}
		}else if (quellepiece==2){
			if(up%2==0){
				m.drawImage(imagezag, x[i[t]], y[j[t]], this);
				m.drawImage(imagezag, x[i[t]-1], y[j[t]+2], this);
				m.drawImage(imagezag, x[i[t]], y[j[t]+1], this);
				m.drawImage(imagezag, x[i[t]-1], y[j[t]+1], this);
			}else{
				m.drawImage(imagezag, x[i[t]], y[j[t]+1], this);
				m.drawImage(imagezag, x[i[t]+1], y[j[t]+2], this);
				m.drawImage(imagezag, x[i[t]], y[j[t]+2], this);
				m.drawImage(imagezag, x[i[t]-1], y[j[t]+1], this);
			}
		}else if (quellepiece==3){
			if(up%2==0){
				m.drawImage(imagebarre, x[i[t]], y[j[t]], this);
				m.drawImage(imagebarre, x[i[t]], y[j[t]+1], this);
				m.drawImage(imagebarre, x[i[t]], y[j[t]+2], this);
				m.drawImage(imagebarre, x[i[t]], y[j[t]+3], this);
			}else{
				m.drawImage(imagebarre, x[i[t]-1], y[j[t]+2], this);
				m.drawImage(imagebarre, x[i[t]], y[j[t]+2], this);
				m.drawImage(imagebarre, x[i[t]+1], y[j[t]+2], this);
				m.drawImage(imagebarre, x[i[t]+2], y[j[t]+2], this);
			}	
		}else if (quellepiece==4){
			if(up==0){
				m.drawImage(imaget, x[i[t]], y[j[t]], this);
				m.drawImage(imaget, x[i[t]-1], y[j[t]+1], this);
				m.drawImage(imaget, x[i[t]], y[j[t]+1], this);
				m.drawImage(imaget, x[i[t]+1], y[j[t]+1], this);
			}else if(up==1){
				m.drawImage(imaget, x[i[t]], y[j[t]], this);
				m.drawImage(imaget, x[i[t]], y[j[t]+2], this);
				m.drawImage(imaget, x[i[t]], y[j[t]+1], this);
				m.drawImage(imaget, x[i[t]+1], y[j[t]+1], this);
			}else if(up==2){
				m.drawImage(imaget, x[i[t]], y[j[t]+1], this);
				m.drawImage(imaget, x[i[t]+1], y[j[t]+1], this);
				m.drawImage(imaget, x[i[t]], y[j[t]+2], this);
				m.drawImage(imaget, x[i[t]-1], y[j[t]+1], this);
			}else if(up==3){
				m.drawImage(imaget, x[i[t]], y[j[t]], this);
				m.drawImage(imaget, x[i[t]], y[j[t]+1], this);
				m.drawImage(imaget, x[i[t]], y[j[t]+2], this);
				m.drawImage(imaget, x[i[t]-1], y[j[t]+1], this);
			}
		}else if (quellepiece==5){
			if(up==0){
				m.drawImage(imagel, x[i[t]], y[j[t]], this);
				m.drawImage(imagel, x[i[t]], y[j[t]+1], this);
				m.drawImage(imagel, x[i[t]], y[j[t]+2], this);
				m.drawImage(imagel, x[i[t]+1], y[j[t]+2], this);
			}else if(up==1){
				m.drawImage(imagel, x[i[t]], y[j[t]+1], this);
				m.drawImage(imagel, x[i[t]], y[j[t]+2], this);
				m.drawImage(imagel, x[i[t]+1], y[j[t]+1], this);
				m.drawImage(imagel, x[i[t]+2], y[j[t]+1], this);
			}else if(up==2){
				m.drawImage(imagel, x[i[t]], y[j[t]], this);
				m.drawImage(imagel, x[i[t]+1], y[j[t]], this);
				m.drawImage(imagel, x[i[t]+1], y[j[t]+1], this);
				m.drawImage(imagel, x[i[t]+1], y[j[t]+2], this);
			}else if(up==3){
				m.drawImage(imagel, x[i[t]], y[j[t]+2], this);
				m.drawImage(imagel, x[i[t]+1], y[j[t]+2], this);
				m.drawImage(imagel, x[i[t]+2], y[j[t]+2], this);
				m.drawImage(imagel, x[i[t]+2], y[j[t]+1], this);
			}
		}else if (quellepiece==6){
			if(up==0){
				m.drawImage(imagele, x[i[t]], y[j[t]], this);
				m.drawImage(imagele, x[i[t]], y[j[t]+1], this);
				m.drawImage(imagele, x[i[t]], y[j[t]+2], this);
				m.drawImage(imagele, x[i[t]-1], y[j[t]+2], this);
			}else if(up==1){
				m.drawImage(imagele, x[i[t]], y[j[t]+1], this);
				m.drawImage(imagele, x[i[t]], y[j[t]+2], this);
				m.drawImage(imagele, x[i[t]+1], y[j[t]+2], this);
				m.drawImage(imagele, x[i[t]+2], y[j[t]+2], this);
			}else if(up==2){
				m.drawImage(imagele, x[i[t]], y[j[t]], this);
				m.drawImage(imagele, x[i[t]+1], y[j[t]], this);
				m.drawImage(imagele, x[i[t]], y[j[t]+2], this);
				m.drawImage(imagele, x[i[t]], y[j[t]+1], this);
			}else if(up==3){
				m.drawImage(imagele, x[i[t]], y[j[t]+1], this);
				m.drawImage(imagele, x[i[t]+1], y[j[t]+1], this);
				m.drawImage(imagele, x[i[t]+2], y[j[t]+1], this);
				m.drawImage(imagele, x[i[t]+2], y[j[t]+2], this);
			}
		}
		
		
		
		m.setColor(Color.red);
		m.drawLine(0, y[5], 222, y[5]);
		
		}
		
		
		
		m.dispose();
		
	}
	
	public void updatelibre(){
		
		if(quellepiece==0){
			//carre
			if(i[t]<8 && i[t]>0 && j[t]<23){
				libredroite = xynonoqp[i[t]+2][j[t]] && xynonoqp[i[t]+2][j[t]+1];
				libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1];
				librebas = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+1][j[t]+2];
			}
			if(i[t]==0){
				if (j[t]==23){
					librebas = false;
					libredroite = xynonoqp[i[t]+2][j[t]] && xynonoqp[i[t]+2][j[t]+1];
					libregauche = false;
				}else{
					libregauche = false;
					libredroite = xynonoqp[i[t]+2][j[t]] && xynonoqp[i[t]+2][j[t]+1];
					librebas = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+1][j[t]+2];
				}
			}
			if (i[t]==8){
				if (j[t]==23){
					librebas = false;
					libredroite = false;
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1];
				}else{
					libredroite = false;
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1];
					librebas = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+1][j[t]+2];
				}
			}
			if (i[t]<8 && i[t]>0 && j[t]==23){
				librebas = false;
				libredroite = xynonoqp[i[t]+2][j[t]] && xynonoqp[i[t]+2][j[t]+1];
				libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1];
			}
		}else if(quellepiece==1){
			if(up%2==0){
				//zig debout
				if(i[t]<8 && i[t]>0 && j[t]<22){
					librerotat = xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]][j[t]+2];
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+2][j[t]+2];
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]][j[t]+2];
					librebas = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+1][j[t]+3];
				}
				if(i[t]==0){
					if (j[t]==22){
						librerotat = false;
						librebas = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+2][j[t]+2];
						libregauche =false;
					}else{
						librerotat = false;
						libregauche = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+2][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+1][j[t]+3];
					}
				}
				if (i[t]==8){
					if (j[t]==22){
						librerotat = xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]][j[t]+2];
						librebas = false;
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]][j[t]+2];
					}else{
						librerotat = xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]][j[t]+2];
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+1][j[t]+3];
					}
				}
				if (i[t]<8 && i[t]>0 && j[t]==22){
					librerotat = xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]][j[t]+2];
					librebas = false;
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+2][j[t]+2];
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]][j[t]+2];
				}
			}else if(up%2==1){
				//zig couché
				if(i[t]<8 && i[t]>1 && j[t]<22){
					librerotat = xynonoqp[i[t]][j[t]] && xynonoqp[i[t]+1][j[t]+2];
					libredroite = xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
					libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-2][j[t]+2];
					librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]-1][j[t]+3];
				}
				if(i[t]==1){
					if (j[t]==22){
						librerotat = xynonoqp[i[t]][j[t]] && xynonoqp[i[t]+1][j[t]+2];
						librebas = false;
						libredroite = xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
						libregauche = false;
					}else{
						librerotat = xynonoqp[i[t]][j[t]] && xynonoqp[i[t]+1][j[t]+2];
						libregauche=false;
						libredroite = xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]-1][j[t]+3];
					}
				}
				if (i[t]==8){
					if (j[t]==22){
						librerotat = xynonoqp[i[t]][j[t]] && xynonoqp[i[t]+1][j[t]+2];
						librebas = false;
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-2][j[t]+2];
					}else{
						librerotat = xynonoqp[i[t]][j[t]] && xynonoqp[i[t]+1][j[t]+2];
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-2][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]-1][j[t]+3];
					}
				}
				if (i[t]<8 && i[t]>1 && j[t]==22){
					librerotat = xynonoqp[i[t]][j[t]] && xynonoqp[i[t]+1][j[t]+2];
					librebas = false;
					libredroite = xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
					libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-2][j[t]+2];
				}
			}
		}else if(quellepiece==2){
			if(up%2==0){
				//zag debout
				if(i[t]<9 && i[t]>1 && j[t]<22){
					librerotat = xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]][j[t]+2];
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]][j[t]+2];
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-2][j[t]+2];
					librebas = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]-1][j[t]+3];
				}
				if(i[t]==1){
					if (j[t]==22){
						librerotat = xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]][j[t]+2];
						librebas = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]][j[t]+2];
						libregauche =false;
					}else{
						librerotat = xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]][j[t]+2];
						libregauche = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]-1][j[t]+3];
					}
				}
				if (i[t]==9){
					if (j[t]==22){
						librerotat = false;
						librebas = false;
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-2][j[t]+2];
					}else{
						librerotat = false;
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-2][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]-1][j[t]+3];
					}
				}
				if (i[t]<9 && i[t]>1 && j[t]==22){
					librerotat = xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]][j[t]+2];
					librebas = false;
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]][j[t]+2];
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-2][j[t]+2];
				}
			}else if(up%2==1){
				//zag couché
				if(i[t]<8 && i[t]>1 && j[t]<22){
					librerotat = xynonoqp[i[t]][j[t]] && xynonoqp[i[t]-1][j[t]+2];
					libredroite = xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+2][j[t]+2];
					libregauche = xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
					librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3] && xynonoqp[i[t]-1][j[t]+2];
				}
				if(i[t]==1){
					if (j[t]==22){
						librerotat = xynonoqp[i[t]][j[t]] && xynonoqp[i[t]-1][j[t]+2];
						librebas = false;
						libredroite = xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+2][j[t]+2];
						libregauche =  false;
					}else{
						librerotat = xynonoqp[i[t]][j[t]] && xynonoqp[i[t]-1][j[t]+2];
						libregauche= false;
						libredroite = xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+2][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3] && xynonoqp[i[t]-1][j[t]+2];
					}
				}
				if (i[t]==8){
					if (j[t]==22){
						librerotat = xynonoqp[i[t]][j[t]] && xynonoqp[i[t]-1][j[t]+2];
						librebas = false;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
					}else{
						librerotat = xynonoqp[i[t]][j[t]] && xynonoqp[i[t]-1][j[t]+2];
						libredroite = false;
						libregauche =  xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3] && xynonoqp[i[t]-1][j[t]+2];
					}
				}
				if (i[t]<8 && i[t]>1 && j[t]==22){
					librerotat = xynonoqp[i[t]][j[t]] && xynonoqp[i[t]-1][j[t]+2];
					librebas = false;
					libredroite = xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+2][j[t]+2];
					libregauche =  xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
				}
			}
		}else if(quellepiece==3){
			if(up%2==0){
				//barre debout
				if(i[t]<8 && i[t]>0 && j[t]<21){
					librerotat = xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+2][j[t]+2];
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+1][j[t]+3];
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]-1][j[t]+3];
					librebas = xynonoqp[i[t]][j[t]+4];
				}
				if(i[t]==0){
					if (j[t]==21){
						librerotat = false;
						librebas = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+1][j[t]+3];
						libregauche =false;
					}else{
						librerotat = false;
						libregauche = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+1][j[t]+3];
						librebas = xynonoqp[i[t]][j[t]+4];
					}
				}
				if (i[t]==9){
					if (j[t]==21){
						librerotat = false;
						librebas = false;
						libredroite = false;
						libregauche =xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]-1][j[t]+3];
					}else{
						librerotat = false;
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]-1][j[t]+3];
						librebas = xynonoqp[i[t]][j[t]+4];
					}
				}
				if (i[t]==8){
					if (j[t]==21){
						librerotat = false;
						librebas = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+1][j[t]+3];
						libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]-1][j[t]+3];
					}else{
						librerotat = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+1][j[t]+3];
						libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]-1][j[t]+3];
						librebas = xynonoqp[i[t]][j[t]+4];
					}
				}
				if (i[t]<8 && i[t]>0 && j[t]==21){
					librerotat = xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+2][j[t]+2];
					librebas = false;
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+1][j[t]+3];
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]-1][j[t]+3];
				}
			}else if(up%2==1){
				//barre couchée
				if(i[t]<7 && i[t]>1 && j[t]<22){
					librerotat = xynonoqp[i[t]][j[t]+1] && xynonoqp[i[t]][j[t]-1] && xynonoqp[i[t]][j[t]-2];
					libredroite = xynonoqp[i[t]+3][j[t]+2];
					libregauche = xynonoqp[i[t]-2][j[t]+2];
					librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3] && xynonoqp[i[t]-1][j[t]+3] && xynonoqp[i[t]+2][j[t]+3];
				}
				if(i[t]==1){
					if (j[t]==22){
						librerotat = false;
						librebas = false;
						libredroite = xynonoqp[i[t]+3][j[t]+2];
						libregauche =  false;
					}else{
						librerotat = xynonoqp[i[t]][j[t]+1] && xynonoqp[i[t]][j[t]-1] && xynonoqp[i[t]][j[t]-2];
						libregauche= false;
						libredroite = xynonoqp[i[t]+3][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3] && xynonoqp[i[t]-1][j[t]+3] && xynonoqp[i[t]+2][j[t]+3];
					}
				}
				if (i[t]==7){
					if (j[t]==22){
						librerotat = false;
						librebas = false;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-2][j[t]+2];
					}else{
						librerotat = xynonoqp[i[t]][j[t]+1] && xynonoqp[i[t]][j[t]-1] && xynonoqp[i[t]][j[t]-2];
						libredroite = false;
						libregauche =  xynonoqp[i[t]-2][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3] && xynonoqp[i[t]-1][j[t]+3] && xynonoqp[i[t]+2][j[t]+3];
					}
				}
				if (i[t]<7 && i[t]>1 && j[t]==22){
					librerotat = false;
					librebas = false;
					libredroite = xynonoqp[i[t]+3][j[t]+2];
					libregauche =   xynonoqp[i[t]-2][j[t]+2];
				}
				
			}
			
		}else if(quellepiece==4){
			if(up==0){
				//T haut
				if(i[t]<8 && i[t]>1 && j[t]<23){
					librerotat = xynonoqp[i[t]][j[t]+2];
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+2][j[t]+1] ;
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-2][j[t]+1] ;
					librebas = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]-1][j[t]+2];
				}
				if(i[t]==1){
					if (j[t]==23){
						librerotat = false;
						librebas = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+2][j[t]+1] ;
						libregauche =false;
					}else{
						librerotat = xynonoqp[i[t]][j[t]+2];
						libregauche = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+2][j[t]+1] ;
						librebas = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]-1][j[t]+2];
					}
				}
				if (i[t]==8){
					if (j[t]==23){
						librerotat = false;
						librebas = false;
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-2][j[t]+1] ;
					}else{
						librerotat = xynonoqp[i[t]][j[t]+2];
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-2][j[t]+1] ;
						librebas = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]-1][j[t]+2];
					}
				}
				if (i[t]<8 && i[t]>1 && j[t]==23){
					librerotat = false;
					librebas = false;
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+2][j[t]+1] ;
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-2][j[t]+1] ;
				}
			}else if(up==1){
				//T droite
				if(i[t]<8 && i[t]>0 && j[t]<22){
					librerotat = xynonoqp[i[t]-1][j[t]+1];
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
					libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+2];
					librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+2];
				}
				if(i[t]==0){
					if (j[t]==22){
						librerotat = false;
						librebas = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
						libregauche =  false;
					}else{
						librerotat = false;
						libregauche= false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+2];
					}
				}
				if (i[t]==8){
					if (j[t]==22){
						librerotat = xynonoqp[i[t]-1][j[t]+1];
						librebas = false;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
					}else{
						librerotat = xynonoqp[i[t]-1][j[t]+1];
						libredroite = false;
						libregauche =  xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+2];
					}
				}
				if (i[t]<8 && i[t]>0 && j[t]==22){
					librerotat = xynonoqp[i[t]-1][j[t]+1];
					librebas = false;
					libredroite =  xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
					libregauche =  xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+2];
				}
			}else if(up==2){
				//T bas
				if(i[t]<8 && i[t]>1 && j[t]<22){
					librerotat = xynonoqp[i[t]][j[t]-1] ;
					libredroite = xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
					libregauche = xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
					librebas = xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+2];
				}
				if(i[t]==1){
					if (j[t]==22){
						librerotat = xynonoqp[i[t]][j[t]-1] ;
						librebas = false;
						libredroite =  xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
						libregauche =  false;
					}else{
						librerotat = xynonoqp[i[t]][j[t]-1] ;
						libregauche= false;
						libredroite =  xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
						librebas = xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+2];
					}
				}
				if (i[t]==8){
					if (j[t]==22){
						librerotat =xynonoqp[i[t]][j[t]-1] ;
						librebas = false;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
					}else{
						librerotat = xynonoqp[i[t]][j[t]-1] ;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
						librebas = xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+2];
					}
				}
				if (i[t]<8 && i[t]>1 && j[t]==22){
					librerotat = xynonoqp[i[t]][j[t]-1] ;
					librebas = false;
					libredroite =  xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
					libregauche =  xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
				}
			}else if(up==3){
				//T gauche
				if(i[t]<9 && i[t]>1 && j[t]<22){
					librerotat = xynonoqp[i[t]+1][j[t]+1];
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+1][j[t]+1];
					libregauche = xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+2];
					librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]-1][j[t]+2];
				}
				if(i[t]==1){
					if (j[t]==22){
						librerotat =xynonoqp[i[t]+1][j[t]+1];
						librebas = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+1][j[t]+1];
						libregauche =  false;
					}else{
						librerotat =xynonoqp[i[t]+1][j[t]+1];
						libregauche= false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+1][j[t]+1];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]-1][j[t]+2];
					}
				}
				if (i[t]==9){
					if (j[t]==22){
						librerotat = false;
						librebas = false;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+2];
					}else{
						librerotat = false;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]-1][j[t]+2];
					}
				}
				if (i[t]<9 && i[t]>1 && j[t]==22){
					librerotat = xynonoqp[i[t]+1][j[t]+1];
					librebas = false;
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+1][j[t]+1];
					libregauche =  xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+2];
				}
			}
				
		}else if(quellepiece==5){
			if(up==0){
				//L haut
				if(i[t]<8 && i[t]>0 && j[t]<22){
					librerotat = xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+2][j[t]+1];
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1]  && xynonoqp[i[t]+2][j[t]+2];
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1]  && xynonoqp[i[t]-1][j[t]+2];
					librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3];
				}
				if(i[t]==0){
					if (j[t]==22){
						librerotat = xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+2][j[t]+1];
						librebas = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1]  && xynonoqp[i[t]+2][j[t]+2];
						libregauche =false;
					}else{
						librerotat = xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+2][j[t]+1];
						libregauche = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1]  && xynonoqp[i[t]+2][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3];
					}
				}
				if (i[t]==8){
					if (j[t]==22){
						librerotat = false;
						librebas = false;
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1]  && xynonoqp[i[t]-1][j[t]+2];
					}else{
						librerotat = false;
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1]  && xynonoqp[i[t]-1][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3];
					}
				}
				if (i[t]<8 && i[t]>0 && j[t]==22){
					librerotat = xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+2][j[t]+1];
					librebas = false;
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1]  && xynonoqp[i[t]+2][j[t]+2];
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1]  && xynonoqp[i[t]-1][j[t]+2];
				}
			}else if(up==1){
				//L droite
				if(i[t]<7 && i[t]>0 && j[t]<23){
					librerotat = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+2];
					libredroite = xynonoqp[i[t]+3][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
					libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
					librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+2][j[t]+2];
				}
				if(i[t]==0){
					if (j[t]==23){
						librerotat = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+2];
						librebas = false;
						libredroite = xynonoqp[i[t]+3][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
						libregauche =  false;
					}else{
						librerotat = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+2];
						libregauche= false;
						libredroite = xynonoqp[i[t]+3][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+2][j[t]+2];
					}
				}
				if (i[t]==7){
					if (j[t]==23){
						librerotat =xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+2];
						librebas = false;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
					}else{
						librerotat = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+2];
						libredroite = false;
						libregauche =  xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
						librebas =xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+2][j[t]+2];
					}
				}
				if (i[t]<7 && i[t]>0 && j[t]==23){
					librerotat = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+2];
					librebas = false;
					libredroite =  xynonoqp[i[t]+3][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
					libregauche =  xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
				}
			}else if(up==2){
				//L bas
				if(i[t]<8 && i[t]>0 && j[t]<22){
					librerotat = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+2][j[t]+2] ;
					libredroite = xynonoqp[i[t]+2][j[t]] && xynonoqp[i[t]+2][j[t]+2] && xynonoqp[i[t]+2][j[t]+1];
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]][j[t]+1] && xynonoqp[i[t]][j[t]+2];
					librebas = xynonoqp[i[t]][j[t]+1] && xynonoqp[i[t]+1][j[t]+3];
				}
				if(i[t]==0){
					if (j[t]==22){
						librerotat = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+2][j[t]+2] ;
						librebas = false;
						libredroite =  xynonoqp[i[t]+2][j[t]] && xynonoqp[i[t]+2][j[t]+2] && xynonoqp[i[t]+2][j[t]+1];
						libregauche =  false;
					}else{
						librerotat = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+2][j[t]+2] ;
						libregauche= false;
						libredroite = xynonoqp[i[t]+2][j[t]] && xynonoqp[i[t]+2][j[t]+2] && xynonoqp[i[t]+2][j[t]+1];
						librebas = xynonoqp[i[t]][j[t]+1] && xynonoqp[i[t]+1][j[t]+3];
					}
				}
				if (i[t]==8){
					if (j[t]==22){
						librerotat =false ;
						librebas = false;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]][j[t]+1] && xynonoqp[i[t]][j[t]+2];
					}else{
						librerotat = false ;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]][j[t]+1] && xynonoqp[i[t]][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+1] && xynonoqp[i[t]+1][j[t]+3];
					}
				}
				if (i[t]<8 && i[t]>0 && j[t]==22){
					librerotat = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+2][j[t]+2] ;
					librebas = false;
					libredroite = xynonoqp[i[t]+2][j[t]] && xynonoqp[i[t]+2][j[t]+2] && xynonoqp[i[t]+2][j[t]+1];
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]][j[t]+1] && xynonoqp[i[t]][j[t]+2];
				}
			}else if(up==3){
				//L gauche
				if(i[t]<7 && i[t]>0 && j[t]<22){
					librerotat = xynonoqp[i[t]][j[t]+1] ;
					libredroite = xynonoqp[i[t]+3][j[t]+1] && xynonoqp[i[t]+3][j[t]+2] ;
					libregauche = xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]+1][j[t]+1] ;
					librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3] && xynonoqp[i[t]+2][j[t]+3];
				}
				if(i[t]==0){
					if (j[t]==22){
						librerotat =xynonoqp[i[t]][j[t]+1] ;
						librebas = false;
						libredroite = xynonoqp[i[t]+3][j[t]+1] && xynonoqp[i[t]+3][j[t]+2] ;
						libregauche =  false;
					}else{
						librerotat =xynonoqp[i[t]][j[t]+1] ;
						libregauche= false;
						libredroite = xynonoqp[i[t]+3][j[t]+1] && xynonoqp[i[t]+3][j[t]+2] ;
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3] && xynonoqp[i[t]+2][j[t]+3];
					}
				}
				if (i[t]==7){
					if (j[t]==22){
						librerotat = xynonoqp[i[t]][j[t]+1] ;
						librebas = false;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]+1][j[t]+1] ;
					}else{
						librerotat = xynonoqp[i[t]][j[t]+1] ;
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]+2] && xynonoqp[i[t]+1][j[t]+1] ;
						librebas =  xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3] && xynonoqp[i[t]+2][j[t]+3];
					}
				}
				if (i[t]<7 && i[t]>0 && j[t]==22){
					librerotat = xynonoqp[i[t]][j[t]+1] ;
					librebas = false;
					libredroite = xynonoqp[i[t]+3][j[t]+1] && xynonoqp[i[t]+3][j[t]+2] ;
					libregauche =  xynonoqp[i[t]-2][j[t]+1] && xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+2];
				}
			}
		}else if(quellepiece==6){
			if(up==0){
				//Lenvers haut
				if(i[t]<8 && i[t]>1 && j[t]<22){
					librerotat = xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+2][j[t]+2];
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1]  && xynonoqp[i[t]+1][j[t]+2];
					libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+1]  && xynonoqp[i[t]-2][j[t]+2];
					librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]-1][j[t]+3];
				}
				if(i[t]==1){
					if (j[t]==22){
						librerotat = xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+2][j[t]+2];
						librebas = false;
						libredroite =xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1]  && xynonoqp[i[t]+1][j[t]+2];
						libregauche =false;
					}else{
						librerotat = xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+2][j[t]+2];
						libregauche = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1]  && xynonoqp[i[t]+1][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]-1][j[t]+3];
					}
				}
				if (i[t]==8){
					if (j[t]==22){
						librerotat = false;
						librebas = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1]  && xynonoqp[i[t]+1][j[t]+2];
						libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+1]  && xynonoqp[i[t]-2][j[t]+2];
					}else{
						librerotat = false;
						libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1]  && xynonoqp[i[t]+1][j[t]+2];
						libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+1]  && xynonoqp[i[t]-2][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]-1][j[t]+3];
					}
				}
				if (i[t]==9){
					if (j[t]==22){
						librerotat = false;
						librebas = false;
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+1]  && xynonoqp[i[t]-2][j[t]+2];
					}else{
						librerotat = false;
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+1]  && xynonoqp[i[t]-2][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]-1][j[t]+3];
					}
				}
				if (i[t]<8 && i[t]>1 && j[t]==22){
					librerotat = xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+2][j[t]+2];
					librebas = false;
					libredroite = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]+1][j[t]+1]  && xynonoqp[i[t]+1][j[t]+2];
					libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+1]  && xynonoqp[i[t]-2][j[t]+2];
				}
			}else if(up==1){
				//Lenvers droite
				if(i[t]<7 && i[t]>0 && j[t]<22){
					librerotat = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]][j[t]];
					libredroite = xynonoqp[i[t]+3][j[t]+2] && xynonoqp[i[t]+1][j[t]+1];
					libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
					librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3] && xynonoqp[i[t]+2][j[t]+3];
				}
				if(i[t]==0){
					if (j[t]==22){
						librerotat = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]][j[t]];
						librebas = false;
						libredroite = xynonoqp[i[t]+3][j[t]+2] && xynonoqp[i[t]+1][j[t]+1];
						libregauche =  false;
					}else{
						librerotat = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]][j[t]];
						libregauche= false;
						libredroite =xynonoqp[i[t]+3][j[t]+2] && xynonoqp[i[t]+1][j[t]+1];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3] && xynonoqp[i[t]+2][j[t]+3];
					}
				}
				if (i[t]==7){
					if (j[t]==22){
						librerotat =xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]][j[t]];
						librebas = false;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
					}else{
						librerotat = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]][j[t]];
						libredroite = false;
						libregauche =  xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
						librebas =xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+3] && xynonoqp[i[t]+2][j[t]+3];
					}
				}
				if (i[t]<7 && i[t]>0 && j[t]==22){
					librerotat = xynonoqp[i[t]+1][j[t]] && xynonoqp[i[t]][j[t]];
					librebas = false;
					libredroite =  xynonoqp[i[t]+3][j[t]+2] && xynonoqp[i[t]+1][j[t]+1];
					libregauche =  xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
				}
			}else if(up==2){
				//Lenvers bas
				if(i[t]<8 && i[t]>0 && j[t]<22){
					librerotat = xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+2][j[t]+2] ;
					libredroite = xynonoqp[i[t]+2][j[t]] && xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
					librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+1];
				}
				if(i[t]==0){
					if (j[t]==22){
						librerotat =xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+2][j[t]+2] ;
						librebas = false;
						libredroite =  xynonoqp[i[t]+2][j[t]] && xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
						libregauche =  false;
					}else{
						librerotat = xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+2][j[t]+2] ;
						libregauche= false;
						libredroite = xynonoqp[i[t]+2][j[t]] && xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+1];
					}
				}
				if (i[t]==8){
					if (j[t]==22){
						librerotat =false ;
						librebas = false;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
					}else{
						librerotat = false ;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
						librebas = xynonoqp[i[t]][j[t]+3] && xynonoqp[i[t]+1][j[t]+1];
					}
				}
				if (i[t]<8 && i[t]>0 && j[t]==22){
					librerotat = xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+2][j[t]+1] && xynonoqp[i[t]+2][j[t]+2] ;
					librebas = false;
					libredroite = xynonoqp[i[t]+2][j[t]] && xynonoqp[i[t]+1][j[t]+1] && xynonoqp[i[t]+1][j[t]+2];
					libregauche = xynonoqp[i[t]-1][j[t]] && xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]-1][j[t]+2];
				}
			}else if(up==3){
				//Lenvers gauche
				if(i[t]<7 && i[t]>0 && j[t]<22){
					librerotat = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]][j[t]] && xynonoqp[i[t]-1][j[t]+2];
					libredroite = xynonoqp[i[t]+3][j[t]+1] && xynonoqp[i[t]+3][j[t]+2] ;
					libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]+1][j[t]+2] ;
					librebas = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+2][j[t]+3];
				}
				if(i[t]==0){
					if (j[t]==22){
						librerotat =false ;
						librebas = false;
						libredroite = xynonoqp[i[t]+3][j[t]+1] && xynonoqp[i[t]+3][j[t]+2] ;
						libregauche =  false;
					}else{
						librerotat =false ;
						libregauche= false;
						libredroite = xynonoqp[i[t]+3][j[t]+1] && xynonoqp[i[t]+3][j[t]+2] ;
						librebas = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+2][j[t]+3];
					}
				}
				if (i[t]==7){
					if (j[t]==22){
						librerotat = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]][j[t]] && xynonoqp[i[t]-1][j[t]+2];
						librebas = false;
						libredroite = false;
						libregauche =  xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]+1][j[t]+2] ;
					}else{
						librerotat = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]][j[t]] && xynonoqp[i[t]-1][j[t]+2];
						libredroite = false;
						libregauche = xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]+1][j[t]+2] ;
						librebas =  xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]+1][j[t]+2] && xynonoqp[i[t]+2][j[t]+3];
					}
				}
				if (i[t]<7 && i[t]>0 && j[t]==22){
					librerotat = xynonoqp[i[t]][j[t]+2] && xynonoqp[i[t]][j[t]] && xynonoqp[i[t]-1][j[t]+2];
					librebas = false;
					libredroite = xynonoqp[i[t]+3][j[t]+1] && xynonoqp[i[t]+3][j[t]+2] ;
					libregauche =  xynonoqp[i[t]-1][j[t]+1] && xynonoqp[i[t]+1][j[t]+2] ;
				}
			}
		}
		
		
	}
	
	public void updateoccupation(){
		if(quellepiece==0){
			//carre
			xynonoqp[i[t]][j[t]]=false;
			signature[i[t]][j[t]]=1;
			
			xynonoqp[i[t]+1][j[t]]=false;
			signature[i[t]+1][j[t]]=1;
			
			xynonoqp[i[t]][j[t]+1]=false;
			signature[i[t]][j[t]+1]=1;
			
			xynonoqp[i[t]+1][j[t]+1]=false;
			signature[i[t]+1][j[t]+1]=1;
		}else if(quellepiece==1){
			if(up%2==0){
				//zig debout
				xynonoqp[i[t]][j[t]]=false;
				signature[i[t]][j[t]]=2;
				
				xynonoqp[i[t]+1][j[t]+2]=false;
				signature[i[t]+1][j[t]+2]=2;
				
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=2;
				
				xynonoqp[i[t]+1][j[t]+1]=false;
				signature[i[t]+1][j[t]+1]=2;
				
				
			}else{
				//zig couché
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=2;
				
				xynonoqp[i[t]+1][j[t]+1]=false;
				signature[i[t]+1][j[t]+1]=2;
				
				xynonoqp[i[t]][j[t]+2]=false;
				signature[i[t]][j[t]+2]=2;
				
				xynonoqp[i[t]-1][j[t]+2]=false;
				signature[i[t]-1][j[t]+2]=2;
				
			}
		}else if(quellepiece==2){
			if(up%2==0){
				//zag debout
				xynonoqp[i[t]][j[t]]=false;
				signature[i[t]][j[t]]=3;
				
				xynonoqp[i[t]-1][j[t]+2]=false;
				signature[i[t]-1][j[t]+2]=3;
				
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=3;
				
				xynonoqp[i[t]-1][j[t]+1]=false;
				signature[i[t]-1][j[t]+1]=3;
				
				
			}else{
				//zag couché
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=3;
				
				xynonoqp[i[t]+1][j[t]+2]=false;
				signature[i[t]+1][j[t]+2]=3;
				
				xynonoqp[i[t]][j[t]+2]=false;
				signature[i[t]][j[t]+2]=3;
				
				xynonoqp[i[t]-1][j[t]+1]=false;
				signature[i[t]-1][j[t]+1]=3;
				
			}
		}else if(quellepiece==3){
			if(up%2==0){
				//barre debout
				xynonoqp[i[t]][j[t]]=false;
				signature[i[t]][j[t]]=4;
				
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=4;
				
				xynonoqp[i[t]][j[t]+2]=false;
				signature[i[t]][j[t]+2]=4;
				
				xynonoqp[i[t]][j[t]+3]=false;
				signature[i[t]][j[t]+3]=4;
				
				
			}else{
				//barre couchée
				xynonoqp[i[t]-1][j[t]+2]=false;
				signature[i[t]-1][j[t]+2]=4;
				
				xynonoqp[i[t]][j[t]+2]=false;
				signature[i[t]][j[t]+2]=4;
				
				xynonoqp[i[t]+1][j[t]+2]=false;
				signature[i[t]+1][j[t]+2]=4;
				
				xynonoqp[i[t]+2][j[t]+2]=false;
				signature[i[t]+2][j[t]+2]=4;	
			}
			
		}else if(quellepiece==4){
			if(up==0){
				//T haut
				xynonoqp[i[t]][j[t]]=false;
				signature[i[t]][j[t]]=5;
				
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=5;
				
				xynonoqp[i[t]-1][j[t]+1]=false;
				signature[i[t]-1][j[t]+1]=5;
				
				xynonoqp[i[t]+1][j[t]+1]=false;
				signature[i[t]+1][j[t]+1]=5;
				
				
			}else if(up==1){
				//T droite
				xynonoqp[i[t]][j[t]]=false;
				signature[i[t]][j[t]]=5;
				
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=5;
				
				xynonoqp[i[t]][j[t]+2]=false;
				signature[i[t]][j[t]+2]=5;
				
				xynonoqp[i[t]+1][j[t]+1]=false;
				signature[i[t]+1][j[t]+1]=5;
					
			}else if (up==2){
				//T bas
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=5;
				
				xynonoqp[i[t]][j[t]+2]=false;
				signature[i[t]][j[t]+2]=5;
				
				xynonoqp[i[t]+1][j[t]+1]=false;
				signature[i[t]+1][j[t]+1]=5;
				
				xynonoqp[i[t]-1][j[t]+1]=false;
				signature[i[t]-1][j[t]+1]=5;
				
			}else if (up==3){
				//T gauche
				xynonoqp[i[t]][j[t]]=false;
				signature[i[t]][j[t]]=5;
				
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=5;
				
				xynonoqp[i[t]][j[t]+2]=false;
				signature[i[t]][j[t]+2]=5;
				
				xynonoqp[i[t]-1][j[t]+1]=false;
				signature[i[t]-1][j[t]+1]=5;
			}
		}else if(quellepiece==5){
			if(up==0){
				//L haut
				xynonoqp[i[t]][j[t]]=false;
				signature[i[t]][j[t]]=6;
				
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=6;
				
				xynonoqp[i[t]][j[t]+2]=false;
				signature[i[t]][j[t]+2]=6;
				
				xynonoqp[i[t]+1][j[t]+2]=false;
				signature[i[t]+1][j[t]+2]=6;
				
				
			}else if(up==1){
				//L droite
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=6;
				
				xynonoqp[i[t]][j[t]+2]=false;
				signature[i[t]][j[t]+2]=6;
				
				xynonoqp[i[t]+2][j[t]+1]=false;
				signature[i[t]+2][j[t]+1]=6;
				
				xynonoqp[i[t]+1][j[t]+1]=false;
				signature[i[t]+1][j[t]+1]=6;
					
			}else if (up==2){
				//L bas
				xynonoqp[i[t]][j[t]]=false;
				signature[i[t]][j[t]]=6;
				
				xynonoqp[i[t]+1][j[t]]=false;
				signature[i[t]+1][j[t]]=6;
				
				xynonoqp[i[t]+1][j[t]+1]=false;
				signature[i[t]+1][j[t]+1]=6;
				
				xynonoqp[i[t]+1][j[t]+2]=false;
				signature[i[t]+1][j[t]+2]=6;
				
			}else if (up==3){
				//L gauche
				xynonoqp[i[t]][j[t]+2]=false;
				signature[i[t]][j[t]+2]=6;
				
				xynonoqp[i[t]+2][j[t]+2]=false;
				signature[i[t]+2][j[t]+2]=6;
				
				xynonoqp[i[t]+1][j[t]+2]=false;
				signature[i[t]+1][j[t]+2]=6;
				
				xynonoqp[i[t]+2][j[t]+1]=false;
				signature[i[t]+2][j[t]+1]=6;
			}
		}else if(quellepiece==6){
			if(up==0){
				//Lenvers haut
				xynonoqp[i[t]][j[t]]=false;
				signature[i[t]][j[t]]=7;
				
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=7;
				
				xynonoqp[i[t]][j[t]+2]=false;
				signature[i[t]][j[t]+2]=7;
				
				xynonoqp[i[t]-1][j[t]+2]=false;
				signature[i[t]-1][j[t]+2]=7;
				
				
			}else if(up==3){
				//Lenvers gauche
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=7;
				
				xynonoqp[i[t]+2][j[t]+2]=false;
				signature[i[t]+2][j[t]+2]=7;
				
				xynonoqp[i[t]+2][j[t]+1]=false;
				signature[i[t]+2][j[t]+1]=7;
				
				xynonoqp[i[t]+1][j[t]+1]=false;
				signature[i[t]+1][j[t]+1]=7;
					
			}else if (up==2){
				//Lenvers bas
				xynonoqp[i[t]][j[t]]=false;
				signature[i[t]][j[t]]=7;
				
				xynonoqp[i[t]+1][j[t]]=false;
				signature[i[t]+1][j[t]]=7;
				
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=7;
				
				xynonoqp[i[t]][j[t]+2]=false;
				signature[i[t]][j[t]+2]=7;
				
			}else if (up==1){
				//Lenvers droite
				xynonoqp[i[t]][j[t]+1]=false;
				signature[i[t]][j[t]+1]=7;
				
				xynonoqp[i[t]][j[t]+2]=false;
				signature[i[t]][j[t]+2]=7;
				
				xynonoqp[i[t]+1][j[t]+2]=false;
				signature[i[t]+1][j[t]+2]=7;
				
				xynonoqp[i[t]+2][j[t]+2]=false;
				signature[i[t]+2][j[t]+2]=7;
			}
		}
		
	}
			
		
	
	
	public void updateligne() {
		jp=0;
												for(jp=0;jp<26;jp++){
														ligneoqp[jp] = true;
													for(ip=0;ip<10;ip++){
														ligneoqp[jp] &= !xynonoqp[ip][jp];
													}
													
												}
												nbl=0;
												for(jp=0;jp<26;jp++){
													if(ligneoqp[jp] == true){
															nbl=nbl+1;
															cassage=true;
															
														final Timer G = new Timer();
														G.schedule(new TimerTask() {public void run(){
															cassage=false;
															}},600);
														nblignecassee=nblignecassee+1;
													}
												}
												
												if(nbl>0 && nbl <4){
													lignedisp.play();
												}
												if (nbl==4){
													tetrisdisp.play();
												}
												if (nbl>0){
													if (nblignecassee%5==0){
														lvlup.play();
													}
												}
												nbl=0;
												
												e=0;
												
														
													
																
														final Timer C = new Timer();
														C.schedule(new TimerTask() {public void run(){
															
															
																
																if(e<10){
																	for(d=25;d>-1;d--){
																		if(d>-1){
																			if (ligneoqp[d]==true){
																			
																				D[e][d]=true;
																				
																				
																				
																				repaint();
																			}
																		}
																	}
																e=e+1;
																}else{
																	e=0;
																	C.cancel();
																}
																
														}
														}
														,1,20);
														
														
														final Timer E = new Timer();
														E.schedule(new TimerTask() {public void run(){
															
															
																
																if(e<10){
																	for(d=0;d<26;d++){
																		if(d<26){
																			if (ligneoqp[d]==true){
																				D[e][d]=false;
																				
																				xynonoqp[e][d]=true;
																				
																				for(t0=d;t0>0;t0--){
																					
																					
																					xynonoqp[e][t0]=xynonoqp[e][t0-1];
																					signature[e][t0]=signature[e][t0-1];
																					
																					xynonoqp[e][0]=true;
																					signature[e][0]=0;
																				}
																				
																			
																					
																				
																				
																				
																				repaint();
																			}
																		}
																	}
																e=e+1;
																}else{
																	e=0;
																	E.cancel();
																}
																
														}
														}
														,450,20);
														
														
																																																	
												
														
												
												
													
													
														
														
														
											
											
												
											
												
												
											
												
												
												
												
												
	}
	
	//renvoie le nombre de ligne cassées par le joueur
	public int lignecassee(){
		return nblignecassee;
	}
	
	
	
	//renvoie la hauteur maximale de piece en jeu
	public int hauteurmax(){
		ie=0;
		je=0;
		while(xynonoqp[ie][je]==true)
			if(je<25){
				if(ie<9){
					ie=ie+1;
				}else{
					ie=ie-9;
					je=je+1;
				}
			
				jmax=je;
			}else{
				jmax=25;
				break;
		}
		return (25-jmax);	
		
	}
	
	public boolean gameover0(){
		if (hauteurmax()>20){
			
			gover=true;
			System.out.println("gover : "+gover);
		}
		return gover;
	}
	
	public boolean casse(){
		return cassage;
	}
	
	public boolean gameover(){
		return gover1;
	}
		
	
	
	
		

	
	
}