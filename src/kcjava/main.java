package kcjava;

import controller.*;
import model.*;
import view.*;

public class main {

	public static void main(String[] args) {
		View view = new View("Time tracker emulator - V1.4");
		Model model = new Model();
		Controller controller = new Controller(model,view);
		controller.initController();
	}

}

/*public class main{
	public static void main(String[] args) throws Exception{
		Company comp = new Company("comp", 15);
		

	}

}*/
