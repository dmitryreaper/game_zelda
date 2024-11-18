package main;

import java.util.Timer;
import javax.swing.AbstractAction;
import javax.swing.*;
import java.awt.event.ActionEvent;

import display.Display;

public class Main {
	public static void main(String[] args) {
		
		Display.create(800,600, "Title");

		//fps
		Timer timer = new Timer( 1000 / 60, new AbstractAction() {
				public void actionPerformed(ActionEvent e ) {
					Display.render();
				}
			});
		timer.setRepeats(true);
		timer.start();
	}
		   
}
