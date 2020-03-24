
public class XContainsY {

	public static void main(String[] args) {

		String x = "abac";
		String y = "x";

		System.out.println(contains(x, y));

	}

	public static String contains(String x, String y) {

		String xyz = "yes";		
		
		for (char c : y.toCharArray()) {
			int len = 0;
			for (char ch : x.toCharArray()) {
				if (c != ch) {
					if (len > x.length()-2) {
						return "no";
					}
					len++;
					continue;
				}else {
					break;
				}
			}
		}

		return xyz;
	}

}
