import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class Checking {
	public static <T extends List<String>> int checkNynum(T list) {
		int checksum = 0;
			
		try {
			
			list.stream()
				//.peek(s-> list.get(5))
				.mapToInt(s-> Integer.valueOf(s))
				.forEach(n-> System.out.print(n + "\t"));
			
		} catch (NumberFormatException e) {
			return checksum = -1;
		}
			
		
								
								
			
					
		
		
		
		
		
		return checksum;
	}
}
