import java.util.Scanner;

public class Gplayer {
	int z = 0;
	
	Scanner sc = new Scanner(System.in);
	
	public void guess() {
	System.out.println("��������µ���(0-9)��");

	if(sc.hasNext())
		z = sc.nextInt();
	
	System.out.println("You guess the number is" + " " + z);
	}

}
