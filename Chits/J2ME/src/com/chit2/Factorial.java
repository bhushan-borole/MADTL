package com.chit2;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Factorial extends MIDlet implements CommandListener{
	private Form form;
	private Display display;
	private TextField name;
	private Command ok;
	private StringItem stringItem;
	
	public Factorial(){
		name = new TextField("Enter number:", "", 30, TextField.ANY);
		ok = new Command("OK", Command.OK, 2);
	}

	public void startApp(){
		display = Display.getDisplay(this);
		form = new Form("Factorial");
		form.append(name);
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
		int n = Integer.parseInt(name.getString());
		
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
