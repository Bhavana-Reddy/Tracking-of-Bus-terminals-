package fuzzy;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class action implements ActionListener{


	public void actionPerformed(ActionEvent e){
		JButton b=(JButton)e.getSource();
		b.setForeground(Color.BLUE);
		b.setText("X");
		b.setBackground(Color.yellow);
	}

}