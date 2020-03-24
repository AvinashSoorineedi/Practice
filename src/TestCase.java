import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestCase {

    public static void main(String[] args) throws UnsupportedEncodingException {
		
		String url = "https://reputation-com-enterprise-qa.s3.us-east-1.amazonaws.com/enterprise-assets/1569316801724_Logo2.png";
		
		String encodedUrl = null;
		try {
             encodedUrl = URLEncoder.encode(url, java.nio.charset.StandardCharsets.UTF_8.toString());
            System.out.println(encodedUrl);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		
		
		
		System.out.println(URLDecoder.decode(url, java.nio.charset.StandardCharsets.UTF_8.toString()));
		  
	}

}
