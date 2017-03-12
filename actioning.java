package fuzzy;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class actioning implements ActionListener {


	public void actionPerformed(ActionEvent ae){
		JButton b=(JButton)ae.getSource(); 

		b.setText("started");
		b.setBackground(Color.yellow);


	}
}