import java.io.*;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Miner implements ActionListener{
	static JLabel jl;
	static JTextArea jf;
	static String s1;
	Miner()
	{
			
			JFrame f = new JFrame("TwitMiner");
			f.setBounds(0, 0, 1200, 1000);
			f.setLayout(null);
			Container contentPane=f.getContentPane();
			JButton b = new JButton("Tweet It!");
			b.setBounds(500, 200, 100, 30);
			contentPane.add(b);
			jf= new JTextArea(2,5);
			jf.setBounds(300,100,500,50);
			contentPane.add(jf);
			f.setContentPane(contentPane);
			jl=new JLabel("");
			jl.setBounds(300,300,400,50);
			JLabel jl1=new JLabel("CATEGORY OF TWEET:");
			jl1.setBounds(150,300,400,50);
			contentPane.add(jl1);
			contentPane.add(jl);
			
			f.setVisible(true);
			b.addActionListener(this);
			
		}
		
	
public static void main(String args[])throws IOException,ClassNotFoundException
	{
		
		Miner m1 = new Miner();
	}

	public void actionPerformed(ActionEvent arg0) {
		
		MaxentTagger tagger = new MaxentTagger("taggers/wsj-0-18-left3words-distsim.tagger");
		String str;
		String tagged;
		String category;
		PrimitiveClassifier pc;
		Prototype pt;
		UpdateInfo ui;
		str=jf.getText();
		tagged = tagger.tagString(str);		
		pc = new PrimitiveClassifier(tagged);
		pt = new Prototype(tagged);
		jl.setText(null);
		try{
		category = pt.PatternMatch();
		ui = new UpdateInfo(tagged,category);
		
		if (category.equalsIgnoreCase("sports")) {
			
			System.out.println("Tweet is Sports in Nature");
			s1 = "Tweet is Sports in Nature";
			ui.Update();			
		}
		
		else if(category.equalsIgnoreCase("politics")) {
			
			System.out.println("Tweet is Political in Nature");
			s1 = "Tweet is Political in Nature";
			ui.Update();			
		}
		
		else if (category.equalsIgnoreCase("undetermined")) {
			
			category = pc.BayesianClassifier();
			ui = new UpdateInfo(tagged,category);
			
			if (category.equalsIgnoreCase("sports")) {
				
				System.out.println("Tweet is Sports in Nature");
				s1 = "Tweet is Sports in Nature";
				ui.Update(); 
				
			} else {
				
				System.out.println("Tweet is Political in Nature");
				s1 = "Tweet is Political in Nature";
				ui.Update(); 
			}
		  }
		}
		catch(Exception e)
		{}
		
		jl.setText(s1);
		
	}
}


