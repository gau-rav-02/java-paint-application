import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class Temp
{
	public static int count = 0;
	public static int count1 = 0;
	public static int count2 = 0;
	public static int count3 = 0;
	public static String bgColor = "WHITE";
	public static String penColor = "BLACK";
	public static Color c = Color.WHITE,c1 = Color.BLACK;

	public static Button b[];
	//public static int x1,x2,y1,y2;
	public static int a = -1; 
	public static Graphics g,g1;
	public static Label l1,l2,l3,l4,l5,l6;
	public static Choice ch1,ch2,ch3;
	public static JMenuBar mb;
	public static JMenu file;
	public static JMenuItem m1i1,m1i2,m1i3,m1i4;
	public static ImageIcon img1,img2,img3,img4;
}

class Panel1 extends Panel implements ItemListener, MenuContainer
{
	public Panel1()
	{
		setLayout(null);
		Temp.b = new Button[21];

		for(int i=0; i<19; i++)
		{
			Temp.b[i] = new Button(" ");
		}	

		Temp.b[9].setLabel("Clear");

		Temp.l1 = new Label("--- Pen Colors ---");
		Temp.l1.setBounds(700,50,150,40);

		Temp.l2 = new Label("--- Background Colors ---");
		Temp.l2.setBounds(150,50,250,40);

		Temp.l3 = new Label("--- Pen Pattern | Pen Size ---");
		Temp.l3.setBounds(1400,50,250,40);

		Temp.l4 = new Label("--- Shapes ---");
		Temp.l4.setBounds(1700,50,250,40);

		Temp.l5 = new Label("Color 1");
		Temp.l5.setBounds(1165,50,100,40);

		Temp.l6 = new Label("Color 2");
		Temp.l6.setBounds(1275,50,100,40);

		add(Temp.l1); add(Temp.l2); add(Temp.l3); add(Temp.l4); add(Temp.l5); add(Temp.l6);

		Temp.b[0].setBackground(Color.RED);
		Temp.b[1].setBackground(Color.BLUE);
		Temp.b[2].setBackground(Color.GREEN);
		Temp.b[3].setBackground(Color.YELLOW);
		Temp.b[4].setBackground(Color.ORANGE);	
		Temp.b[5].setBackground(Color.PINK);	
		Temp.b[6].setBackground(Color.CYAN);
		Temp.b[7].setBackground(Color.WHITE);
		Temp.b[8].setBackground(Color.BLACK);

		Temp.b[9].setBounds(1000,95,100,50);

		Temp.b[10].setBackground(Color.RED);
		Temp.b[11].setBackground(Color.BLUE);
		Temp.b[12].setBackground(Color.GREEN);
		Temp.b[13].setBackground(Color.YELLOW);
		Temp.b[14].setBackground(Color.ORANGE);	
		Temp.b[15].setBackground(Color.PINK);	
		Temp.b[16].setBackground(Color.CYAN);
		Temp.b[17].setBackground(Color.WHITE);
		Temp.b[18].setBackground(Color.BLACK);

		int in=1;
		for(int i=10; i<19; i++)
		{
			Temp.b[i].setBounds((in*50),95,50,50);
			in++;
		}

		in=11;
		for(int i=0; i<9; i++)
		{
			Temp.b[i].setBounds((in*50),95,50,50);
			in++;
		}
	
		this.setFont(new Font("TimesRoman",Font.BOLD,20));


		for(int i=0; i<19; i++)
		{
			add(Temp.b[i]);
		}

		//Additional Features...
		Temp.ch1 = new Choice();
		Temp.ch1.add("Normal");
		Temp.ch1.add("Round");
		Temp.ch1.add("Rect");
		Temp.ch1.setBounds(1410,105,100,50);
		add(Temp.ch1);
        

		Temp.ch2 = new Choice();
		Temp.ch2.add("Default");
		Temp.ch2.add("2px");
		Temp.ch2.add("4px");
		Temp.ch2.add("6px");
		Temp.ch2.setBounds(1520,105,100,50);
		add(Temp.ch2);

		Temp.ch3 = new Choice();
		Temp.ch3.add("None");
		Temp.ch3.add("Rectangle");
		Temp.ch3.add("Circle");
		Temp.ch3.add("Filled Rectangle");
		Temp.ch3.add("Filled Circle");
		Temp.ch3.setBounds(1710,105,100,50);
		add(Temp.ch3);

		Temp.b[19] = new Button("");
		Temp.b[19].setBounds(1150,105,100,30);
		Temp.b[19].setBackground(Color.BLACK);
		add(Temp.b[19]);

		Temp.b[20] = new Button("");
		Temp.b[20].setBounds(1260,105,100,30);
		Temp.b[20].setBackground(Color.WHITE);
		add(Temp.b[20]);

		Temp.mb = new JMenuBar();
		Temp.file = new JMenu("File");
		Temp.m1i1 = new JMenuItem("New");
		Temp.m1i2 = new JMenuItem("Open");
		Temp.m1i3 = new JMenuItem("Save");
		Temp.m1i4 = new JMenuItem("Save As");
		Temp.file.add(Temp.m1i1);
		Temp.file.add(Temp.m1i2);
		Temp.file.add(Temp.m1i3);
		Temp.file.add(Temp.m1i4);
		Temp.mb.add(Temp.file);
		
		Temp.img1 = new ImageIcon("NewIcon.png");
		Temp.m1i1.setIcon(Temp.img1);
		Temp.img2 = new ImageIcon("FileIcon.png");
		Temp.m1i2.setIcon(Temp.img2);
		Temp.img3 = new ImageIcon("SaveIcon.png");
		Temp.m1i3.setIcon(Temp.img3);
		Temp.img4 = new ImageIcon("SaveAsIcon.png");
		Temp.m1i4.setIcon(Temp.img4);

		Temp.ch1.addItemListener(this);
        Temp.ch2.addItemListener(this);
		Temp.ch3.addItemListener(this);
		this.setBackground(Color.GRAY);	
	}

	public void itemStateChanged(ItemEvent e)
    {
        Object ob = e.getSource();

		if(ob.equals(Temp.ch1))
		{
			int sel = Temp.ch1.getSelectedIndex();
			if(sel==0)
			{
				Temp.count1 = 0;
			}
			else if(sel == 1)
			{
			    Temp.count1 = 1;
			}
			else if(sel == 2)
			{
			    Temp.count1 = 2;
			}
		}
		if(ob.equals(Temp.ch2))
		{
			int sel = Temp.ch2.getSelectedIndex();
			if(sel==0)
			{
				Temp.count2 = 0;
			}
			else if(sel == 1)
			{
			    Temp.count2 = 1;
			}
			else if(sel == 2)
			{
			    Temp.count2 = 2;
			}
			else if(sel == 3)
			{
			    Temp.count2 = 3;
			}
		}
		if(ob.equals(Temp.ch3))
		{
			int sel = Temp.ch3.getSelectedIndex();
			System.out.println("sel2 = "+sel);
			if(sel == 0)
			{
				Temp.count3 = 0;
			}
			else if(sel == 1)
			{
				Temp.count3 = 1;
			}
			else if(sel == 2)
			{
			    Temp.count3 = 2;
			}
			else if(sel == 3)
			{
			    Temp.count3 = 3;
			}
			else if(sel == 4)
			{
			    Temp.count3 = 4;
			}
			System.out.println("count2 = "+Temp.count3);
		}
	}
}

class Panel2 extends Panel implements MouseMotionListener, MouseListener
{
	int x1,x2,y1,y2;
	int xx1,yy1,xx2,yy2;
	int xxx1,yyy1,xxx2,yyy2;
	int last;
	boolean first = true;
	String prevdir = "";
	Vector<Integer> v;

	public Panel2()
	{
		setLayout(new GridLayout(1,0));
		this.setBackground(Color.WHITE);
		this.addMouseMotionListener(this);

		v = new Vector<Integer>();
	}

	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}  
	public void mousePressed(MouseEvent me){}

	public void mouseMoved(MouseEvent me)
	{
		first = true;

		//xx1 = me.getX();
		//yy1 = me.getY();		

		x1 = me.getX();
		y1 = me.getY();
		x2 = me.getX();
		y2 = me.getY();
	}

	public void mouseDragged(MouseEvent me)
	{
		Graphics g = getGraphics();
		Object ob = me.getSource();

		xx2 = me.getX();
		yy2 = me.getY();

		if(first)
		{
			xx1 = me.getX();
			yy1 = me.getY();

			xxx2 = me.getX();
			yyy2 = me.getY();
			first = false;
		}

		v.add(me.getX());
		v.add(me.getY());

		if(Temp.count%2==0)
		{
			x1 = me.getX();
			y1 = me.getY();
		}
		else
		{
			x2 = me.getX();
			y2 = me.getY();
		}
		int i = 0;
		/*do
		{
			if(v.elementAt(i) == xx2)
				xxx2 = v.elementAt(i-2);
			if(v.elementAt(i) == yy2)
				yyy2 = v.elementAt(i-2);
			i++;

		}while(v.elementAt(i) != v.lastElement());*/
	
		if(Temp.a==0)
		{
			g.setColor(Color.RED);
			Temp.c1 = Color.RED;
		}
		else if(Temp.a==1)
		{
			g.setColor(Color.BLUE);
			Temp.c1 = Color.BLUE;
		}
		else if(Temp.a==2)
		{
			g.setColor(Color.GREEN);
			Temp.c1 = Color.GREEN;
		}
		else if(Temp.a==3)
		{
			g.setColor(Color.YELLOW);
			Temp.c1 = Color.YELLOW;
		}
		else if(Temp.a==4)
		{
			g.setColor(Color.ORANGE);
			Temp.c1 = Color.ORANGE;
		}
		else if(Temp.a==5)
		{
			g.setColor(Color.PINK);
			Temp.c1 = Color.PINK;
		}
		else if(Temp.a==6)
		{
			g.setColor(Color.CYAN);
			Temp.c1 = Color.CYAN;
		}
		else if(Temp.a==7)
		{
			g.setColor(Color.WHITE);
			Temp.c1 = Color.WHITE;
		}
		else if(Temp.a==8)
		{
			g.setColor(Color.BLACK);
			Temp.c1 = Color.BLACK;
		}

		if(Temp.count3 == 1)
		{
			if(prevdir.equals("NE"))
			{
				g.setColor(Temp.c);
				g.drawRect(xxx2,yyy2,(xx1-xxx2),(yy1-yyy2));
			}
			else if(prevdir.equals("SE"))
			{
				g.setColor(Temp.c);
				g.drawRect(xxx2,yy1,(xx1-xxx2),(yyy2-yy1));
			}
			else if(prevdir.equals("NW"))
			{
				g.setColor(Temp.c);
				g.drawRect(xx1,yyy2,(xxx2-xx1),(yy1-yyy2));
			}
			else if(prevdir.equals("SW"))
			{
				g.setColor(Temp.c);
				g.drawRect(xx1,yy1,(xxx2-xx1),(yyy2-yy1));
			}

			if(xx2 < xx1 && yy2 < yy1)
			{
				g.setColor(Temp.c);
				g.drawRect(xxx2,yyy2,(xx1-xxx2),(yy1-yyy2));
				g.setColor(Temp.c1);
				g.drawRect(xx2,yy2,(xx1-xx2),(yy1-yy2));

				prevdir = "NE";
			}
			if(xx2 < xx1 && yy2 > yy1)
			{
				g.setColor(Temp.c);
				g.drawRect(xxx2,yy1,(xx1-xxx2),(yyy2-yy1));
				g.setColor(Temp.c1);
				g.drawRect(xx2,yy1,(xx1-xx2),(yy2-yy1));

				prevdir = "SE";
			}
			if(xx2 > xx1 && yy2 < yy1)
			{
				g.setColor(Temp.c);
				g.drawRect(xx1,yyy2,(xxx2-xx1),(yy1-yyy2));
				g.setColor(Temp.c1);
				g.drawRect(xx1,yy2,(xx2-xx1),(yy1-yy2));

				prevdir = "NW";
			}
			if(xx2 > xx1 && yy2 > yy1)
			{
				g.setColor(Temp.c);
				g.drawRect(xx1,yy1,(xxx2-xx1),(yyy2-yy1));
				g.setColor(Temp.c1);
				g.drawRect(xx1,yy1,(xx2-xx1),(yy2-yy1));

				prevdir = "SW";
			}
		}
		else if(Temp.count3 == 2)
		{
			//g.fillOval(xx1,yy1,(xx2-xx1),(yy2-yy1));

			if(prevdir.equals("NE"))
			{
				g.setColor(Temp.c);
				g.drawOval(xxx2,yyy2,(xx1-xxx2),(yy1-yyy2));
			}
			else if(prevdir.equals("SE"))
			{
				g.setColor(Temp.c);
				g.drawOval(xxx2,yy1,(xx1-xxx2),(yyy2-yy1));
			}
			else if(prevdir.equals("NW"))
			{
				g.setColor(Temp.c);
				g.drawOval(xx1,yyy2,(xxx2-xx1),(yy1-yyy2));
			}
			else if(prevdir.equals("SW"))
			{
				g.setColor(Temp.c);
				g.drawOval(xx1,yy1,(xxx2-xx1),(yyy2-yy1));
			}

			if(xx2 < xx1 && yy2 < yy1)
			{
				g.setColor(Temp.c);
				g.drawRect(xxx2,yyy2,(xx1-xxx2),(yy1-yyy2));
				g.setColor(Temp.c1);
				g.drawOval(xx2,yy2,(xx1-xx2),(yy1-yy2));

				prevdir = "NE";
			}
			if(xx2 < xx1 && yy2 > yy1)
			{
				g.setColor(Temp.c);
				g.drawOval(xxx2,yy1,(xx1-xxx2),(yyy2-yy1));
				g.setColor(Temp.c1);
				g.drawOval(xx2,yy1,(xx1-xx2),(yy2-yy1));

				prevdir = "SE";
			}
			if(xx2 > xx1 && yy2 < yy1)
			{
				g.setColor(Temp.c);
				g.drawOval(xx1,yyy2,(xxx2-xx1),(yy1-yyy2));
				g.setColor(Temp.c1);
				g.drawOval(xx1,yy2,(xx2-xx1),(yy1-yy2));

				prevdir = "NW";
			}
			if(xx2 > xx1 && yy2 > yy1)
			{
				g.setColor(Temp.c);
				g.drawOval(xx1,yy1,(xxx2-xx1),(yyy2-yy1));
				g.setColor(Temp.c1);
				g.drawOval(xx1,yy1,(xx2-xx1),(yy2-yy1));

				prevdir = "SW";
			}
		}
		else if(Temp.count3 == 3)
		{
			//g.fillOval(xx1,yy1,(xx2-xx1),(yy2-yy1));

			if(prevdir.equals("NE"))
			{
				g.setColor(Temp.c);
				g.fillRect(xxx2,yyy2,(xx1-xxx2),(yy1-yyy2));
			}
			else if(prevdir.equals("SE"))
			{
				g.setColor(Temp.c);
				g.fillRect(xxx2,yy1,(xx1-xxx2),(yyy2-yy1));
			}
			else if(prevdir.equals("NW"))
			{
				g.setColor(Temp.c);
				g.fillRect(xx1,yyy2,(xxx2-xx1),(yy1-yyy2));
			}
			else if(prevdir.equals("SW"))
			{
				g.setColor(Temp.c);
				g.fillRect(xx1,yy1,(xxx2-xx1),(yyy2-yy1));
			}

			if(xx2 < xx1 && yy2 < yy1)
			{
				g.setColor(Temp.c);
				g.drawRect(xxx2,yyy2,(xx1-xxx2),(yy1-yyy2));
				g.setColor(Temp.c1);
				g.fillRect(xx2,yy2,(xx1-xx2),(yy1-yy2));

				prevdir = "NE";
			}
			if(xx2 < xx1 && yy2 > yy1)
			{
				g.setColor(Temp.c);
				g.fillRect(xxx2,yy1,(xx1-xxx2),(yyy2-yy1));
				g.setColor(Temp.c1);
				g.fillRect(xx2,yy1,(xx1-xx2),(yy2-yy1));

				prevdir = "SE";
			}
			if(xx2 > xx1 && yy2 < yy1)
			{
				g.setColor(Temp.c);
				g.fillRect(xx1,yyy2,(xxx2-xx1),(yy1-yyy2));
				g.setColor(Temp.c1);
				g.fillRect(xx1,yy2,(xx2-xx1),(yy1-yy2));

				prevdir = "NW";
			}
			if(xx2 > xx1 && yy2 > yy1)
			{
				g.setColor(Temp.c);
				g.fillRect(xx1,yy1,(xxx2-xx1),(yyy2-yy1));
				g.setColor(Temp.c1);
				g.fillRect(xx1,yy1,(xx2-xx1),(yy2-yy1));

				prevdir = "SW";
			}
		}
		else if(Temp.count3 == 4)
		{
			//g.fillOval(xx1,yy1,(xx2-xx1),(yy2-yy1));

			if(prevdir.equals("NE"))
			{
				g.setColor(Temp.c);
				g.fillOval(xxx2,yyy2,(xx1-xxx2),(yy1-yyy2));
			}
			else if(prevdir.equals("SE"))
			{
				g.setColor(Temp.c);
				g.fillOval(xxx2,yy1,(xx1-xxx2),(yyy2-yy1));
			}
			else if(prevdir.equals("NW"))
			{
				g.setColor(Temp.c);
				g.fillOval(xx1,yyy2,(xxx2-xx1),(yy1-yyy2));
			}
			else if(prevdir.equals("SW"))
			{
				g.setColor(Temp.c);
				g.fillOval(xx1,yy1,(xxx2-xx1),(yyy2-yy1));
			}

			if(xx2 < xx1 && yy2 < yy1)
			{
				g.setColor(Temp.c);
				g.drawRect(xxx2,yyy2,(xx1-xxx2),(yy1-yyy2));
				g.setColor(Temp.c1);
				g.fillOval(xx2,yy2,(xx1-xx2),(yy1-yy2));

				prevdir = "NE";
			}
			if(xx2 < xx1 && yy2 > yy1)
			{
				g.setColor(Temp.c);
				g.fillOval(xxx2,yy1,(xx1-xxx2),(yyy2-yy1));
				g.setColor(Temp.c1);
				g.fillOval(xx2,yy1,(xx1-xx2),(yy2-yy1));

				prevdir = "SE";
			}
			if(xx2 > xx1 && yy2 < yy1)
			{
				g.setColor(Temp.c);
				g.fillOval(xx1,yyy2,(xxx2-xx1),(yy1-yyy2));
				g.setColor(Temp.c1);
				g.fillOval(xx1,yy2,(xx2-xx1),(yy1-yy2));

				prevdir = "NW";
			}
			if(xx2 > xx1 && yy2 > yy1)
			{
				g.setColor(Temp.c);
				g.fillOval(xx1,yy1,(xxx2-xx1),(yyy2-yy1));
				g.setColor(Temp.c1);
				g.fillOval(xx1,yy1,(xx2-xx1),(yy2-yy1));

				prevdir = "SW";
			}
		}
		else if(Temp.count1 == 0)
		{
			g.drawLine(x1,y1,x2,y2);
			if(Temp.count2 == 1)
			{
				g.drawLine((x1+1), (y1+1), (x2+1), (y2+1));
				g.drawLine((x1-1), (y1-1), (x2-1), (y2-1));
				g.drawLine((x1+2), (y1+2), (x2+2), (y2+2));
				g.drawLine((x1-2), (y1-2), (x2-2), (y2-2));
			}
			else if(Temp.count2 == 2)
			{
				g.drawLine((x1+1), (y1+1), (x2+1), (y2+1));
				g.drawLine((x1-1), (y1-1), (x2-1), (y2-1));
				g.drawLine((x1+2), (y1+2), (x2+2), (y2+2));
				g.drawLine((x1-2), (y1-2), (x2-2), (y2-2));
				g.drawLine((x1+3), (y1+3), (x2+3), (y2+3));
				g.drawLine((x1-3), (y1-3), (x2-3), (y2-3));
			}
			else if(Temp.count2 == 3)
			{
				g.drawLine((x1+1), (y1+1), (x2+1), (y2+1));
				g.drawLine((x1-1), (y1-1), (x2-1), (y2-1));
				g.drawLine((x1+2), (y1+2), (x2+2), (y2+2));
				g.drawLine((x1-2), (y1-2), (x2-2), (y2-2));
				g.drawLine((x1+3), (y1+3), (x2+3), (y2+3));
				g.drawLine((x1-3), (y1-3), (x2-3), (y2-3));
				g.drawLine((x1+4), (y1+4), (x2+4), (y2+4));
				g.drawLine((x1-4), (y1-4), (x2-4), (y2-4));
			}
		}
		else if(Temp.count1 == 1)
		{
			g.fillOval(x1,y1,10,10);
			if(Temp.count2 == 1)
			{
				g.fillOval(x1,y1,20,20);
			}
			if(Temp.count2 == 2)
				g.fillOval(x1,y1,25,25);
			if(Temp.count2 == 3)
				g.fillOval(x1,y1,30,30);
		}
		else if(Temp.count1 == 2)
		{
			g.fillRect(x1,y1,10,10);
			if(Temp.count2 == 1)
				g.fillRect(x1,y1,20,20);
			if(Temp.count2 == 2)
				g.fillRect(x1,y1,25,25);
			if(Temp.count2 == 3)
				g.fillRect(x1,y1,30,30);
		}

		Temp.count++;	
		xxx2 = me.getX();
		yyy2 = me.getY();
	}

	public void mouseReleased(MouseEvent me)
	{
		first = true;
	}
}

class PaintEx1 extends JFrame implements ActionListener
{
	Panel1 p1;
	Panel2 p2;

	public PaintEx1()
	{	
		setLayout(null);
		p1 = new Panel1();
		p2 = new Panel2();

		p1.setBounds(0,0,2000,200);
		p2.setBounds(0,200,2000,800);
		add(p1); add(p2);
		for(int i=0; i<19; i++)
		{
			Temp.b[i].addActionListener(this);
		}

		setJMenuBar(Temp.mb);

		//p2.addMouseMotionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		Object ob = ae.getSource();

		if(ob.equals(Temp.b[0]))
		{
			Temp.a = 0;
			Temp.b[19].setBackground(Color.RED);
		}
		else if(ob.equals(Temp.b[1]))
		{
			Temp.a = 1;
			Temp.b[19].setBackground(Color.BLUE);
		}
		else if(ob.equals(Temp.b[2]))
		{
			Temp.a = 2;
			Temp.b[19].setBackground(Color.GREEN);
		}
		else if(ob.equals(Temp.b[3]))
		{
			Temp.a = 3;
			Temp.b[19].setBackground(Color.YELLOW);
		}
		else if(ob.equals(Temp.b[4]))
		{
			Temp.a = 4;
			Temp.b[19].setBackground(Color.ORANGE);
		}
		else if(ob.equals(Temp.b[5]))
		{
			Temp.a = 5;
			Temp.b[19].setBackground(Color.PINK);
		}
		else if(ob.equals(Temp.b[6]))
		{
			Temp.a = 6;
			Temp.b[19].setBackground(Color.CYAN);
		}
		else if(ob.equals(Temp.b[7]))
		{
			Temp.a = 7;
			Temp.b[19].setBackground(Color.WHITE);
		}
		else if(ob.equals(Temp.b[8]))
		{
			Temp.a = 8;
			Temp.b[19].setBackground(Color.BLACK);
		}
		else if(ob.equals(Temp.b[10]))
		{
			p2.setBackground(Color.RED);
			Temp.c = Color.RED;
		}
		else if(ob.equals(Temp.b[11]))
		{
			p2.setBackground(Color.BLUE);
			Temp.c = Color.BLUE;
		}
		else if(ob.equals(Temp.b[12]))
		{
			p2.setBackground(Color.GREEN);
			Temp.c = Color.GREEN;
		}
		else if(ob.equals(Temp.b[13]))
		{
			p2.setBackground(Color.YELLOW);
			Temp.c = Color.YELLOW;
		}
		else if(ob.equals(Temp.b[14]))
		{
			p2.setBackground(Color.ORANGE);
			Temp.c = Color.ORANGE;
		}
		else if(ob.equals(Temp.b[15]))
		{
			p2.setBackground(Color.PINK);
			Temp.c = Color.PINK;
		}
		else if(ob.equals(Temp.b[16]))
		{
			p2.setBackground(Color.CYAN);
			Temp.c = Color.CYAN;
		}
		else if(ob.equals(Temp.b[17]))
		{
			p2.setBackground(Color.WHITE);
			Temp.c = Color.WHITE;
		}
		else if(ob.equals(Temp.b[18]))
		{
			p2.setBackground(Color.BLACK);
			Temp.c = Color.BLACK;
		}
		else if(ob.equals(Temp.b[9]))
		{
			p2.repaint();
		}

		Temp.b[20].setBackground(Temp.c);
	}
        
	public static void main(String ar[])
	{
		PaintEx1 mp = new PaintEx1();
		mp.setVisible(true);
		mp.setSize(2000,1050);
		mp.setResizable(false);
	}
}