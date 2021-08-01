//Aishwarya Manoj
//Team MelonCoding
//7/31/21
//RejuviMindCabin.java

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class RejuviMindCabin
{
	public static void main (String []args)
	{
		RejuviMindCabin rjm = new RejuviMindCabin();
		rjm.runProgram();
	}
	
	public void runProgram()
	{
		JFrame frame = new JFrame("RejuviMind Cabin");
		frame.setSize(900,800);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocation(0,0);
		BackgroundPanelRejuviMind bp = new BackgroundPanelRejuviMind();
		frame.getContentPane().add(bp);
		frame.setVisible(true);
	}
}

class BackgroundPanelRejuviMind extends JPanel
{
	public BackgroundPanelRejuviMind()
	{
		setLayout(new BorderLayout());
		
		RejuviCabinPanel rcp = new RejuviCabinPanel();
		rcp.setPreferredSize(new Dimension(600,800));
		
		RejuviCabinChatPanel rccp = new RejuviCabinChatPanel();
		rccp.setPreferredSize(new Dimension(300,800));
		
		add(rcp, BorderLayout.WEST);
		add(rccp, BorderLayout.EAST);
	}
	
}

class RejuviCabinPanel extends JPanel implements ActionListener
{
	private int x;
	public RejuviCabinPanel()
	{
		Color sky = new Color(47,64,82);
		setBackground(sky);
		Timer t = new Timer(100, this);
		x = 0;
		t.start();
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(new Color(141,177,136));
		g.fillRect(0,600,600,200);
		
		//body of house
		g.setColor(new Color(130,97,97));
		g.fillRect(50,250,500,350);
		//300 in the middle
		
		
		
		g.setColor(new Color(204,206,206));
		g.fillOval(470 + x,10 - x,75,50);
		
		g.setColor(new Color(204,206,206));
		g.fillOval(430 + x,75 - x,75,50);
		
		g.setColor(new Color(204,206,206));
		g.fillOval(400 + x,90 - x,40,40);
		
		g.setColor(new Color(204,206,206));
		g.fillOval(430 + x,150 - x,50,40);
		
		g.setColor(new Color(189,124,67));
		
		g.setColor(new Color(189,124,67));
		g.fillRect(255,450,90,150);
		
		g.setColor(new Color(90,63,34));
		g.fillRect(310,520,25,10);
		g.fillRect(70,300,170,150);
		
		g.setColor(new Color(253,202,105));
		g.fillRect(80,310,150,130);
		
		g.setColor(new Color(90,63,34));
		g.fillRect(150,300,10,150);
		g.fillRect(70,370,170,10);
		
		g.setColor(new Color(189,124,67));
		g.fillRect(50,175,500,75);
		g.fillRect(425,140,75,70);
		
		if(x % 60 == 0)
		{
			x = 0;
		}
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		x++;
		repaint();
	}
}

class RejuviCabinChatPanel extends JPanel
{
	private JButton topButton;
	private JButton bottomButton;
	private int[] answers;
	private int[] questionNumber;
	
	public RejuviCabinChatPanel()
	{
		answers = new int[11];
		questionNumber = new int[1];
		
		setLayout(new BorderLayout());
		Color sky = new Color(228,228,228);
		setBackground(sky);
		topButton = new JButton("Yes");
		bottomButton = new JButton("No");
		topButton.setPreferredSize(new Dimension(300,90));

		bottomButton.setPreferredSize(new Dimension(300,100));
		bottomButton.setBackground(new Color(255,124,0));
		topButton.setBackground(new Color(255,167,0));
		bottomButton.setOpaque(true);
		topButton.setOpaque(true);
		topButton.setBorderPainted(false);
		bottomButton.setBorderPainted(false);
		topButton.setFont(new Font("Sans Serif", Font.PLAIN, 25));
		bottomButton.setFont(new Font("Sans Serif", Font.PLAIN, 25));
		
		QuestionPanelRejuviMind qp = new QuestionPanelRejuviMind(answers, questionNumber, topButton, bottomButton);
		qp.setPreferredSize(new Dimension(300,580));
		
		add(qp, BorderLayout.NORTH);
		
		TopButtonHandler tbh = new TopButtonHandler(qp, answers, questionNumber);
		topButton.addActionListener(tbh);
		
		BottomButtonHandler bbh = new BottomButtonHandler(qp, answers, questionNumber);
		bottomButton.addActionListener(bbh);
		
		
		add(topButton, BorderLayout.CENTER);
		add(bottomButton, BorderLayout.SOUTH);	
	}
	
	public void paintComponent(Graphics g)
	{
		
	}
}

class QuestionPanelRejuviMind extends JPanel
{
	private int[] answers;
	private int[] count;
	private JButton top;
	private JButton bottom;
	public QuestionPanelRejuviMind(int[] ans, int[] num, JButton t, JButton b)
	{
		Color sky = new Color(228,228,228);
		setBackground(sky);
		answers = ans;
		count = num;
		top = t;
		bottom = b;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if(answers[0] == 0)
		{	
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("Hello!",10,35);
			g.drawString("Welcome to the",10,65);
			g.drawString("RejuviMind Cabin!",10,95);
			
			g.setColor(new Color(141,177,136));
			g.fillRect(0,130,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("Would you like to",10,155);
			g.drawString("come inside",10,185);
			g.drawString("for a chat?",10,215);
		}
		
		if(count[0] == 1 && answers[0] == 1)
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("Awesome!",10,35);
			g.drawString("Make yourself",10,65);
			g.drawString("comfortable!",10,95);
			
			g.setColor(new Color(141,177,136));
			g.fillRect(0,130,280,75);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("How are you",10,155);
			g.drawString("doing today?",10,185);
			
			top.setText("Great!");
			bottom.setText("Not Great.");
		}
		
		if(count[0] == 1 && answers[0] == 2)
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("That's okay!",10,35);
			g.drawString("Let's take a moment",10,65);
			g.drawString("to breathe and relax.",10,95);
			
			g.setColor(new Color(141,177,136));
			g.fillRect(0,130,280,75);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("When you're ready,",10,155);
			g.drawString("feel free to pass by!",10,185);
			
			top.setText("Let's pass by!");
			bottom.setText("I'd like to pass by.");
			
			answers[10] = 5;
		}
		
		if(count[0] == 2 && answers[1] == 1)
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("Awesome! Then",10,35);
			g.drawString("let's take a moment",10,65);
			g.drawString("to breathe and relax.",10,95);
			
			g.setColor(new Color(141,177,136));
			g.fillRect(0,130,280,75);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("When you're ready,",10,155);
			g.drawString("feel free to pass by!",10,185);
			
			top.setText("Let's pass by!");
			bottom.setText("I'd like to pass by.");
			
			answers[10] = 5;
		}
		
		if(count[0] == 2 && answers[1] == 2)
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,75);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("I'm sorry",10,35);
			g.drawString("to hear that.",10,65);
			
			g.setColor(new Color(141,177,136));
			g.fillRect(0,115,280,80);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("What has your mood",10,145);
			g.drawString("been like today?",10,175);
			
			top.setText("I've been sad");
			bottom.setText("I've been anxious");
		}
		
		if(count[0] == 3 && answers[2] == 1)
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("Is there a",10,35);
			g.drawString("certain reason",10,65);
			g.drawString("you've been sad?",10,95);
			top.setText("Yes");
			bottom.setText("No");
		}
		
		if(count[0] == 3 && answers[2] == 2)
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("Is there a",10,35);
			g.drawString("certain reason",10,65);
			g.drawString("you've been anxious?",10,95);
			top.setText("Yes");
			bottom.setText("No");
		}
		
		if(count[0] == 4 && (answers[3] == 1 || answers[3] == 2))
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,130);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("Have you spoken",10,35);
			g.drawString("to an adult about",10,65);
			g.drawString("how you've been",10,95);
			g.drawString("feeling?",10,125);
			top.setText("Yes");
			bottom.setText("I can't do that");
		}
		
		
		if(count[0] == 5 && answers[4] == 1)
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("Fantastic!",10,35);
			g.drawString("Then let's do",10,65);
			g.drawString("a cool-down activity.",10,95);
			
			g.setColor(new Color(141,177,136));
			g.fillRect(0,130,280,75);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("It may help you cope",10,155);
			g.drawString("with your mood.",10,185);
			top.setText("Okay");
			bottom.setText("Sounds good");
			
		}
		
		if(count[0] == 5 && answers[4] == 2)
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("That's okay!",10,35);
			g.drawString("Let's do a",10,65);
			g.drawString("cool-down activity.",10,95);
			
			g.setColor(new Color(141,177,136));
			g.fillRect(0,130,280,75);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("It may help you cope",10,155);
			g.drawString("with your mood.",10,185);
			top.setText("Okay");
			bottom.setText("Sounds good");
		}
		
		if(count[0] == 6 && (answers[5] == 1 || answers[5] == 2))
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("First off,",10,35);
			g.drawString("Let's take 5 deep",10,65);
			g.drawString("breaths.",10,95);
			
			g.setColor(new Color(141,177,136));
			g.fillRect(0,115,280,80);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("Have you",10,145);
			g.drawString("done that?",10,175);
			top.setText("Yes!");
			bottom.setText("Yup!");
			
		}
		
		if(count[0] == 7 && (answers[6] == 1 || answers[6] == 2)) 
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,160);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("You're doing",10,35);
			g.drawString("great! Next, let's",10,65);
			g.drawString("visualize a place",10,95);
			g.drawString("where you feel most",10,125);
			g.drawString("comfortable.",10,155);
			
			top.setText("Done!");
			bottom.setText("I'm finished.");
		}
		
		if(count[0] == 8)
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("Now that we've",10,35);
			g.drawString("relaxed a bit, let's",10,65);
			g.drawString("do an activity.",10,95);
			
			g.setColor(new Color(141,177,136));
			g.fillRect(0,115,280,240);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("Go grab a glass of",10,145);
			g.drawString("water and draw out",10,175);
			g.drawString("the place you",10,205);
			g.drawString("visualized.",10,235);
			g.drawString("Feel free to use",10,265);
			g.drawString("as many colors as",10,295);
			g.drawString("you'd like.",10,325);
			top.setText("I'm done!");
			bottom.setText("I did that.");
		}
		
		if(count[0] == 9 && answers[2] == 1)
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("Hopefully that",10,35);
			g.drawString("helped a bit with",10,65);
			g.drawString("your sadness.",10,95);
			
			top.setText("It did.");
			bottom.setText("I'm still sad.");
			
		}
		
		if(count[0] == 9 && answers[2] == 2)
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("Hopefully that",10,35);
			g.drawString("helped a bit with",10,65);
			g.drawString("your anxiousness.",10,95);
			
			top.setText("It did.");
			bottom.setText("I'm still anxious.");
		}
		
		if(count[0] == 10 && answers[9] == 1)
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("That's great! Then",10,35);
			g.drawString("let's take a moment",10,65);
			g.drawString("to breathe and relax.",10,95);
			
			g.setColor(new Color(141,177,136));
			g.fillRect(0,130,280,75);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("When you're ready,",10,155);
			g.drawString("feel free to pass by!",10,185);
			
			top.setText("Let's pass by!");
			bottom.setText("I'd like to pass by.");
			
			answers[10] = 5;
		}
		
		if(count[0] == 10 && answers[9] == 2)
		{
			g.setColor(new Color(141,177,136));
			g.fillRect(0,10,280,100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("That's okay.",10,35);
			g.drawString("Let's take a moment",10,65);
			g.drawString("to relax.",10,95);
			
			g.setColor(new Color(141,177,136));
			g.fillRect(0,130,280,75);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.PLAIN, 25));
			g.drawString("When you're ready,",10,155);
			g.drawString("feel free to pass by!",10,185);
			
			top.setText("Let's pass by!");
			bottom.setText("I'd like to pass by.");
			
			answers[10] = 5;
		}
		
	}
}

class TopButtonHandler implements ActionListener
{
	private QuestionPanelRejuviMind qprm;
	private int[] answers;
	private int[] questionNumber;
	public TopButtonHandler(QuestionPanelRejuviMind rcp, int[] ans, int[] num)
	{
		qprm = rcp;
		answers = ans;
		questionNumber = num;
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(answers[10] == 5)
		{
			System.exit(0);
		}
		answers[questionNumber[0]] = 1;
		int x = questionNumber[0];
		questionNumber[0] = x + 1;
		qprm.repaint();
	}
}

class BottomButtonHandler implements ActionListener
{
	private QuestionPanelRejuviMind qprm;
	private int[] answers;
	private int[] questionNumber;
	public BottomButtonHandler(QuestionPanelRejuviMind rcp, int[] ans, int[] num)
	{
		qprm = rcp;
		answers = ans;
		questionNumber = num;
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(answers[10] == 5)
		{
			System.exit(1);
		}
		answers[questionNumber[0]] = 2;
		int x = questionNumber[0];
		questionNumber[0] = x + 1;
		qprm.repaint();
	}
}
