package commonUtils;

import java.util.Random;

public class JavaUtil {
	
	public int getRandomNumbers()
	{
		Random r= new Random();
		int num = r.nextInt(500) ;
		return num;
		
	}

	

}
