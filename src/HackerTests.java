import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HackerTests {

	public static void main(String[] args) {
		
		int[] arr = {1,2,1,2,3,4,1,1};
		
		System.out.println(sockMerchant(9, arr));

	}
	
	static int sockMerchant(int n, int[] ar) {

		Map<String, Integer> pairCount = new HashMap<String, Integer>();
		
		for(Integer i: ar) {
			if(pairCount.get(String.valueOf(i))!=null) {
				pairCount.put(String.valueOf(i), pairCount.get(String.valueOf(i)).intValue()+1);
			}else {
				pairCount.put(String.valueOf(i), new Integer(1));
			}
			
		}

		int count = 0;
		for(Integer entry:pairCount.values()) {
				count = count + (entry/2);
		}
		
		return count;
    }

}
