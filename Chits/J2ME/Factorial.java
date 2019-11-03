package com.chit2_9;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Factorial extends MIDlet implements CommandListener{
	private Form form;
	private Display display;
	private TextField input;
	private Command ok;
	private StringItem stringItem;
	
	public Factorial(){
		input = new TextField("Enter number:", "", 30, TextField.NUMERIC);
		ok = new Command("OK", Command.OK, 2);
	}

	public void startApp(){
		display = Display.getDisplay(this);
		form = new Form("Factorial");
		form.append(input);
		form.addCommand(ok);
		form.setCommandListener(this);
		display.setCurrent(form);
	}

	public void pauseApp(){
	
	}

	public void destroyApp(boolean destroy){
		notifyDestroyed();
	}
	
	public static int fact(int n) {
		if(n == 0)
			return 1;
		else
			return n * fact(n-1);
	}
	public void showInput(){
		display = Display.getDisplay(this);
		int n = Integer.parseInt(input.getString());
		
		stringItem = new StringItem("Factorial: ", String.valueOf(fact(n)));
		form.append(stringItem);
		display.setCurrent(form);
	}


	public void commandAction(Command c, Displayable d) {
		String label = c.getLabel();
		if(label.equals("OK")){
			try{
				form.delete(1);
			} 
			catch(Exception e) {}
			showInput();
		} 
	}
}
