import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class Checking {
	private static int checksum;
	
	public Checking() {
		checksum = 0;
	}
	
	private <T extends List<String>> void checkMynum(T list) {
		try {
			list.stream()
				.peek(s-> {
					if(s.length() == 0) {
						checksum = -2;
					}
				})
				.mapToInt(s-> Integer.valueOf(s))
				
				.forEach(n-> System.out.print(n + "\t"));
			
		} catch (NumberFormatException e) {
			if(checksum == 0)
				checksum = -1;
		}
		
	}
	
	public <T extends List<String>> int getChecksum(T list) {
		checkMynum(list);
		return checksum;
		
	}
}
