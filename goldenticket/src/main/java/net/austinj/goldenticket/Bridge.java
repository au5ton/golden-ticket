package net.austinj.goldenticket;

import java.io.File;

public class Bridge {
    public void exit() {
        GoldenTicket.safelyExit();
    }
    public void submit(String program, String arguments){
    	Execution.doTheThing(program, arguments);
    }
    public boolean checkFile(String path){
    	return new File(path).exists();
    }
}
