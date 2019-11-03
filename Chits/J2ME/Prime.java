package com.chit3;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Prime extends MIDlet implements CommandListener{
	private Form form;
	private Display display;
	private TextField input;
	private Command com;
	private StringItem stringItem;

	public Prime() {
		input = new TextField("Enter number: ", "", 30, TextField.NUMERIC);
		com = new Command("OK", Command.OK, 2);
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		notifyDestroyed();
	}

	protected void pauseApp() {}

	protected void startApp() throws MIDletStateChangeException {
		display = Display.getDisplay(this);
		form = new Form("Prime");
		form.append(input);
		form.addCommand(com);
		form.setCommandListener(this);
		display.setCurrent(form);
	}
	
	public static boolean checkPrime(int num){
	    int count = 0;
	    for(int i=1; i<=num; i++){
	        if(num%i == 0)
	            count += 1;
	    }
	
	    if(count == 2)
	        return true;
	    return false;
	}
	
	public void showInput() {
		display = Display.getDisplay(this);
		int num = Integer.parseInt(input.getString());
		if(checkPrime(num))
			stringItem = new StringItem("Prime: True", "");
		else 
			stringItem = new StringItem("Prime: False", "");
		form.append(stringItem);
		display.setCurrent(form);
	}

	public void commandAction(Command c, Displayable d) {
		String n = c.getLabel();
		if(n.equals("OK")) {
			try {
				form.delete(1);
			}
			catch(Exception e) {}
			showInput();
		}
	}

}
