import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Checking {
	private static int checksum;
	
	public Checking() {
		checksum = 0;
	}
	
	private void checkMynum(List<String> list) {
		try {
			boolean allMatch = list.stream()
					.peek(s-> { if(s.length() == 0) {
						checksum = -2;
						}
					})
					.mapToInt(s-> Integer.valueOf(s))
					.allMatch(n-> n > 0 && n < 47);
			
			if(!allMatch) {
				checksum = -3;
			}
		} catch (NumberFormatException e) {
			if(checksum == 0)
				checksum = -1;
		}
		
		HashSet<String> set = new HashSet<>(list);
		list = new ArrayList<>(set);
		
		if(list.size() < 6) {
			checksum = -4;
		}
	}
	
	public int getChecksum(List<String> list) {
		checkMynum(list);
		return checksum;
	}
}
