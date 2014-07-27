
import java.awt.*;
import javax.swing.*;
import javax.swing.JComponent;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.Graphics.*;
import java.awt.image.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Sample application using Frame.
 *
 * @author 
 * @version 1.00 05/12/09
 */

public class TetrisFrame extends JFrame {
    
    /**
     * The constructor.
     */  
   
    
		
     
     public TetrisFrame() {
     	
     	JScrollPane jScrollPanebouton = new JScrollPane();
		final paneljeu jeu = new paneljeu();
		
		
     	
     	final JLabel JLabellevel = new JLabel();
     	final JLabel JLabelscore = new JLabel();
     	final JPanel contentPane = new JPanel(); 
     	JPanel contentPaneabout;
     	JLabel abouttext;
		JLabel abouttext1;
		JLabel abouttext2;
		JLabel aboutimage;
     	
     	ImageIcon fondi = new ImageIcon("fond.gif"); 
     	final JLabel fond = new JLabel(fondi);
     	
     	ImageIcon fondi1 = new ImageIcon("fond1.gif"); 
     	final JLabel fond1 = new JLabel(fondi1);
     	
     	
     	ImageIcon fondiwin = new ImageIcon("fondwin.gif"); 
     	final JLabel fondwin = new JLabel(fondiwin);
     	
     	ImageIcon fondilvlup = new ImageIcon("fondlvlup.gif"); 
     	final JLabel fondlvlup = new JLabel(fondilvlup);
     	
     	ImageIcon fondigover = new ImageIcon("gameover.gif"); 
     	final JLabel fondgover = new JLabel(fondigover);
     	
     	fondgover.setOpaque(false);
     	
    	JButton jButtonbouton  = new JButton();
		ActionListener activerbouton;
		
		JButton jButtonboutonabout  = new JButton();
		ActionListener activerboutonabout;
		final JScrollPane jScrollPaneboutonabout = new JScrollPane();
		
		JButton jButtonboutonaboutclose  = new JButton();
		ActionListener activerboutonaboutclose;
		JScrollPane jScrollPaneboutonaboutclose = new JScrollPane();
		final JFrame about;
		about = new JFrame();
		
		
		
		
		
		
		 super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);               
		this.setLocation(new Point(200, 110));
		
		ImageIcon icone = new ImageIcon("moi2.gif");
		abouttext = new JLabel("Gilles Masselot AKA confi");
		abouttext2 = new JLabel("gilles.masselot@student.ecp.fr");
		abouttext1 = new JLabel(":p");
		aboutimage = new JLabel(icone);
        about.setTitle("About me");
		about.setLocation(new Point(40, 81));
		about.setSize(new Dimension(280, 450));
		about.setResizable(false);
        
        contentPaneabout = (JPanel)about.getContentPane();
        setSize(new Dimension(400, 700));
        setResizable(false);
        setTitle("Confi-Tetris");
        jScrollPanebouton.setViewportView(jButtonbouton);
        jScrollPaneboutonabout.setViewportView(jButtonboutonabout);
        jScrollPaneboutonaboutclose.setViewportView(jButtonboutonaboutclose);
        contentPane.setLayout(null);
        jButtonboutonaboutclose.setText("Close");
        jButtonboutonabout.setText("About");
        jButtonbouton.setText("Close");
        setContentPane(contentPane);
        about.setContentPane(contentPaneabout);
        contentPaneabout.setLayout(null);
        addComponent(contentPaneabout,jScrollPaneboutonaboutclose,70,360,140,40);
        
        addComponent(contentPane,JLabellevel,282,380,100,25);
      	addComponent(contentPaneabout, abouttext, 65,300,280,40);
		addComponent(contentPaneabout, abouttext2, 50,320,280,40);
		addComponent(contentPaneabout, abouttext1, 245,385,25,25);
		addComponent(contentPaneabout, aboutimage, 15,20,240,262);
        addComponent(contentPane,JLabelscore,282,405,100,25);
        addComponent(contentPane,jScrollPaneboutonabout,282,450,100,30);
        
        addComponent(contentPane,jScrollPanebouton,100,610,200,30);
        
        addComponent(contentPane,jeu,30,30,222,552);
        
        
        addComponent(contentPane,fond,30,30,222,552);
        final Timer H = new Timer();
		H.schedule(new TimerTask() {public void run(){
			String level;
     		int lvl;
     		
			lvl = jeu.lignecassee() / 5;
			level = "Level : "+lvl;
			JLabellevel.setText(level);
			
			int score;
			score = jeu.lignecassee()*100;
			JLabelscore.setText("Score : "+score);
			
			if(jeu.hauteurmax() <11){
				
				
				contentPane.remove(fond1);
				addComponent(contentPane,fond,30,30,222,552);
				
			}
			
			if(jeu.hauteurmax() >10 && jeu.hauteurmax() <21){
				
				
				contentPane.remove(fond);
				addComponent(contentPane,fond1,30,30,222,552);
				
			}
			
			if(jeu.hauteurmax() >20){
				
				//contentPane.remove(jeu);
				contentPane.remove(fond1);
				addComponent(contentPane,fondgover,30,30,222,552);
				
				
			
				
			
				
			}
			
		}
		},5,35);
		final Timer K = new Timer();
		K.schedule(new TimerTask() {public void run(){
			
			if(jeu.casse()){
				if(jeu.lignecassee()%5==0){
					
					if(jeu.hauteurmax() <11 ){
				
						contentPane.remove(fond);
						addComponent(contentPane,fondlvlup,30,30,222,552);
				
					}	
				
					if(jeu.hauteurmax() >10 && jeu.hauteurmax() <21){
				
						contentPane.remove(fond1);
						addComponent(contentPane,fondlvlup,30,30,222,552);
				
					}
			
					if(jeu.hauteurmax() >20){
				
						contentPane.remove(fondgover);
						addComponent(contentPane,fondlvlup,30,30,222,552);
				
					}	
					
					
					
				}else{
				
				
					if(jeu.hauteurmax() <11 ){
				
						contentPane.remove(fond);
						addComponent(contentPane,fondwin,30,30,222,552);
				
					}	
				
					if(jeu.hauteurmax() >10 && jeu.hauteurmax() <21){
				
						contentPane.remove(fond1);
						addComponent(contentPane,fondwin,30,30,222,552);
				
					}
			
					if(jeu.hauteurmax() >20){
				
						contentPane.remove(fondgover);
						addComponent(contentPane,fondwin,30,30,222,552);
				
					}		
				}	
			}
			
			
			
		}
		},5,20);
		final Timer L = new Timer();
		L.schedule(new TimerTask() {public void run(){
			
			if(jeu.casse()==false){
				if(jeu.lignecassee()%5==0){
					
					if(jeu.hauteurmax() <11 ){
				
						contentPane.remove(fondlvlup);
						addComponent(contentPane,fond,30,30,222,552);
				
					}
				
					if(jeu.hauteurmax() >10 && jeu.hauteurmax() <21){
				
						contentPane.remove(fondlvlup);
						addComponent(contentPane,fond1,30,30,222,552);
				
					}
					
					if(jeu.hauteurmax() >20){
				
						contentPane.remove(fondlvlup);
						addComponent(contentPane,fondgover,30,30,222,552);
				
					}	
					
					
				}else{
				
			
					if(jeu.hauteurmax() <11 ){
				
						contentPane.remove(fondwin);
						addComponent(contentPane,fond,30,30,222,552);
				
					}
				
					if(jeu.hauteurmax() >10 && jeu.hauteurmax() <21){
				
						contentPane.remove(fondwin);
						addComponent(contentPane,fond1,30,30,222,552);
				
					}
					
					if(jeu.hauteurmax() >20){
				
						contentPane.remove(fondwin);
						addComponent(contentPane,fondgover,30,30,222,552);
				
					}	
				
				}
				
			}
			
			
			
		}
		},600,20);
		
		
			
        	
        // Add action listener.for the menu button
        activerbouton = new ActionListener(){
       		public void actionPerformed(ActionEvent e) {
       			System.exit(0);
       			
       		}
       	};
       	jButtonbouton.addActionListener(activerbouton);
       	
       	activerboutonabout = new ActionListener(){
       		public void actionPerformed(ActionEvent f) {
       			about.setVisible(true);
       			
       		}
       	};
       	jButtonboutonabout.addActionListener(activerboutonabout);
       	
       	activerboutonaboutclose = new ActionListener(){
       		public void actionPerformed(ActionEvent g) {
       			about.setVisible(false);
       			jeu.requestFocusInWindow();
       			
       		}
       	};
       	jButtonboutonaboutclose.addActionListener(activerboutonaboutclose);
        
	
        // Add window listener.
          
    }
    
    
    /**
     * Shutdown procedure when run as an application.
     */
     
    protected void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
		
	}
    protected void windowClosed() {
    	
    	// TODO: Check if it is safe to close the application
    	
        // Exit application.
        System.out.println("close");
        System.exit(0);
        
    };
    
    
   
  	
}
