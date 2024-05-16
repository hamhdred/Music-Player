package main;

import controller.Controller;
import view.Finestra;

public class Main {



    
	public static void main(String[] args) {
		
		Finestra finestra = new Finestra();
		
		
		Controller controller = new Controller(finestra.returnPannello());
		
		
			
		
		
		
	}

}
