package com.chit7;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Circle extends MIDlet implements CommandListener{
	
	private Form form;
	private Display display;
	private TextField inp;
	private StringItem op1;
	private StringItem op2;
	private Command com;

	public Circle() {
		inp = new TextField("Enter radius:", "", 40, TextField.DECIMAL);
		com = new Command("OK", Command.OK, 2);
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		notifyDestroyed();
	}

	protected void pauseApp() {}

	protected void startApp() throws MIDletStateChangeException {
		display = Display.getDisplay(this);
		form = new Form("Circle");
		form.append(inp);
		form.addCommand(com);
		form.setCommandListener(this);
		display.setCurrent(form);

	}
	
	public void show() {
		display = Display.getDisplay(this);
		double r = Double.parseDouble(inp.getString());
		double area = Math.PI * r * r;
		double circum = 2 * Math.PI * r;
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
				form.delete(1);
				form.delete(2);
			}
			catch(Exception e) {}
			show();
		}
		
	}

}
