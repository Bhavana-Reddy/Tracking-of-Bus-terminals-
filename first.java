package fuzzy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import javax.swing.*;


import java.awt.*;
class fram extends JFrame {
	JButton b[][];
	action a;


	public int check=0;

	fram(){
		super();

		setExtendedState(Frame.MAXIMIZED_BOTH); 
		setDefaultLookAndFeelDecorated(true);	
		setVisible(true);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(1000,1000);
		setLocation(0,0);
		setDefaultCloseOperation(EXIT_ON_CLOSE) ; 
		setVisible(true);
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();		
		p1.setLayout(new BorderLayout());
		p2.setLayout(new GridLayout(10,10));
		b=new JButton[10][10];

		int i;
		int j;
		a=new action();
		for(i=0;i<10;i++)
		{
			for(j=0;j<10;j++){
				b[i][j]=new JButton();
				b[i][j].addActionListener(a);
				p2.add(b[i][j]);
			}
		}

		b[9][9].setText("START");
		b[9][9].removeActionListener(a);
		p1.add(p2,BorderLayout.CENTER);
		add(p1);


		actioning w=new actioning();

		b[9][9].addActionListener(w);


	}
	//----frame()


	public Point getMid(JButton btemp){
		Point p1=new Point();
		Point p2=new Point();
		Point p3=new Point();
		p1=b[0][0].getLocationOnScreen();
		p2=b[1][0].getLocationOnScreen();
		p3=b[0][1].getLocationOnScreen();
		Point ret=new Point();
		ret.x=(p3.x-p1.x)/2+btemp.getLocationOnScreen().x;
		ret.y=(p2.y-p1.y)/2+btemp.getLocationOnScreen().y;
		return ret;
	}





	public void paint(Graphics g) { 
		super.paint(g);
		b[0][0].setBackground(Color.BLUE);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g.setColor(Color.red);
		if(b[9][9].getText().equals("started")){


			int icount,kcount;
			for(icount=0;icount<10;icount++){
				for(kcount=0;kcount<10;kcount++){
					b[icount][kcount].removeActionListener(a);
				}
			}




			int i,j,k;k=0;
			int m=0;

			Point p1=getMid(b[0][0]);
			Point p2=new Point();
			int count=0;
			for(i=0;i<10;i++){
				count=0;
				for(j=0;j<10;j++){

					if(b[i][j].getText().equals("X")&&count>=1&&j<m){
						b[i][j].setText(" ");
						b[i][j].setBackground(Color.yellow);
						continue;
					}

					if(b[i][j].getText().equals("X")){
						count++;

						k=j;
						b[i][j].setText(" ");
						p2=getMid(b[i][j]);
						//drawfrom p1 to p2
						int d=(p2.x-p1.x)/100;
						int iloop;

						int reww=10;
						System.out.println(d);
						for(iloop=0;iloop<100;iloop++){
							g.drawLine(p1.x, p1.y, p1.x+d, p1.y);
							p1.x=p1.x+d;
							reww=reww+2;
							try {
								Thread.sleep(reww);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}


						g.drawLine(p1.x, p1.y, p2.x, p1.y);
						p1=p2;
						b[i][j].setBackground(Color.yellow);

					}

				}
				//draw from p1 to p3=getMid(b[i+1][k])
				p2=getMid(b[i+1][k]);
				m=k;
				int d=(p2.y-p1.y)/70;
				int iloop;

				int reww=10;
				System.out.println(d);
				for(iloop=0;iloop<70;iloop++){
					g.drawLine(p1.x, p1.y, p1.x, p1.y+d);
					p1.y=p1.y+d;
					reww=reww+1;
					try {
						Thread.sleep(reww);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if(b[i+1][k].getText().equals("X")){

					b[i+1][k].setText(" ");      	
					b[i+1][k].setBackground(Color.yellow);
				}

				p1=p2;
			}







			/* Point p1=new Point();
        Point p2=new Point();
        p1=getMid(b[4][4]);
        p2=getMid(b[5][4]);

        int d=(p2.y-p1.y)/50;
        int iloop;
        int reww=10;
        System.out.println(d);
        for(iloop=0;iloop<100;iloop++){
        	g.drawLine(p1.x, p1.y, p2.x, p1.y+d);
        p1.y=p1.y+d;
        reww=reww+1;
        try {
			Thread.sleep(reww);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }

    }*/
		}






	}}





public class first {
	public static void main(String args[]){
		fram f=new fram();
		f.setExtendedState(Frame.MAXIMIZED_BOTH);  
		f.setDefaultLookAndFeelDecorated(true);
		f.setVisible(true);



		while(true){
			if(f.b[9][9].getText().equals("started")){
				f.repaint();
				break;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			Thread.sleep(1000000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}