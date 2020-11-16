
public class GuessGame {
	Gplayer p1;
	Gplayer p2;
	Gplayer p3;//Ë½ÓĞ³ÉÔ±
	
	public void startGame() {
	
		int number1;
		int number2;
		int number3;
	
		p1 = new Gplayer();
		p2 = new Gplayer();
		p3 = new Gplayer();
	
		p1.guess();
		p2.guess();
		p3.guess();
	
		number1 = p1.z;
		number2 = p2.z;
		number3 = p3.z;	
	
		System.out.println("The first people guess the number is " + number1);
		System.out.println("The second people guess the number is " + number2);
		System.out.println("The third people guess the number is " + number3);
	
		boolean Isnum1 = false;
		boolean Isnum2 = false;
		boolean Isnum3 = false;
	
		int guessnum = (int) (Math.random() * 10);
		System.out.println("The right number is " + guessnum);
	
		if (number1 == guessnum) 
			Isnum1 = true;
	
		if (number2 == guessnum)
			Isnum2 = true;
	
		if (number3 == guessnum)
			Isnum3 = true;
	
		System.out.println("Is people first right? " + Isnum1);
		System.out.println("Is people second right? " + Isnum2);
		System.out.println("Is people third right? " + Isnum3);
	
		if (Isnum1 == Isnum2 == Isnum3 == false)
			startGame();
		else 
			if (Isnum1 == true | Isnum2 == true | Isnum3 == true) 
				System.out.println("Game is over...");
		
	}
	
}
