package com.chit8;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Rectangle extends MIDlet implements CommandListener{
	
	private Form form;
	private Display display;
	private TextField inp_len;
	private TextField inp_br;
	private StringItem op1;
	private StringItem op2;
	private Command com;

	public Rectangle() {
		inp_len = new TextField("Enter length:", "", 40, TextField.DECIMAL);
		inp_br = new TextField("Enter breadth:", "", 40, TextField.DECIMAL);
		com = new Command("OK", Command.OK, 2);
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		notifyDestroyed();
	}

	protected void pauseApp() {}

	protected void startApp() throws MIDletStateChangeException {
		display = Display.getDisplay(this);
		form = new Form("Circle");
		form.append(inp_len);
		form.append(inp_br);
		form.addCommand(com);
		form.setCommandListener(this);
		display.setCurrent(form);

	}
	
	public void show() {
		display = Display.getDisplay(this);
		double len = Double.parseDouble(inp_len.getString());
		double breadth = Double.parseDouble(inp_br.getString());
		double area = len * breadth;
		double circum = 2 * (len + breadth);
		op1 = new StringItem("Area: ", String.valueOf(area));
		op2 = new StringItem("Circumference: ", String.valueOf(circum));
		form.append(op1);
		form.append(op2);
		display.setCurrent(form);
	}

	public void commandAction(Command c, Displayable arg1) {
		String label = 	c.getLabel();
		if(label.equals("OK")) {
			try {
				form.delete(2);
				form.delete(3);
			}
			catch(Exception e) {}
			show();
		}
		
	}

}
