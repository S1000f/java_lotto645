import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class Checking {
	private static int checksum;
	
	public static <T extends List<String>> int checkNynum(T list) {
		try {
			list.stream()
				.peek(s-> {
					if(s.length() == 0) {
						checksum = -2;
						return;
					}
				})
				.mapToInt(s-> Integer.valueOf(s))
				.forEach(n-> System.out.print(n + "\t"));
			
		} catch (NumberFormatException e) {
			return checksum = -1;
		}	
			
					
		
		
		
		
		
		return checksum;
	}
}
