import java.util.List;

public class Checking {
	private static int checksum;
	
	public Checking() {
		checksum = 0;
	}
	
	private <T extends List<String>> void checkMynum(T list) {
		try {
			boolean allMatch = list.stream()
									.peek(s-> {
										if(s.length() == 0) {
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
	}
	
	public <T extends List<String>> int getChecksum(T list) {
		checkMynum(list);
		return checksum;
	}
}
