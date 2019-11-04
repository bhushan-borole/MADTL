package com.fibo;

// program to display nth fibonacci number(n given by user).

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author rishabh
 */

public class Midlet extends MIDlet implements CommandListener{
    Form form;
    Command ok;
    Display display;
    
    TextField numberField;          // for taking input.
    StringItem resField;            // for displaying output
    
    public void startApp() {
        form = new Form("Fibonacci Application");
        ok = new Command("Calculate", Command.OK, 1);
        display = Display.getDisplay(this);
        
        numberField = new TextField("Enter N:", "", 2, TextField.NUMERIC); 
            // creates an input text field with default "" of max width 2
            // accepting only number input (including negative numbers as well).

        resField = new StringItem("Nth Fbonacci Number:", "");
        
        form.append(numberField);
        form.append(resField);
        form.addCommand(ok);
        form.setCommandListener(this);
        
        display.setCurrent(form);
    }
    
    public void pauseApp() {}
    
    public void destroyApp(boolean unconditional) {}
    
    public int getNthFibo(int n){
        if(n < 1) return -1;                                  // invalid case.
        else if(n == 1 || n == 2) return 1;                   // base case
        else return getNthFibo(n - 1) + getNthFibo(n - 2);    // recursion.
    }
    
    public void commandAction(Command c, Displayable d) {
        int n = Integer.parseInt(numberField.getString());
        int ans = getNthFibo(n);
        resField.setText(ans < 0 ? "Invalid Input" : String.valueOf(ans));
    }
}

