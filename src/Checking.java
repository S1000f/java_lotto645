import java.util.Collection;
import java.util.stream.IntStream;

public class Checking {
	public static int checkNynum(Collection<String> list) {
		try {
			list.stream()
				.mapToInt(s-> Integer.valueOf(s))
				.forEach(n-> System.out.print(n + "\t"));
			
		} catch (NumberFormatException e) {
			return -1;
		}
		
								
								
			
					
		
		
		
		
		
		return 0;
	}
}
