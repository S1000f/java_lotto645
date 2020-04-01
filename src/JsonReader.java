import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {
	public JSONObject connectionUrlToJSON(String turn) {
		try {
		URL url = new URL("https://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=" + turn); 
		HttpsURLConnection conn = null;
		HostnameVerifier myhost = new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true; 
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(myhost);
		conn = (HttpsURLConnection)url.openConnection(); 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
		String iLine = br.readLine();
				
		JSONParser ps = new JSONParser();
		JSONObject jobj = (JSONObject)ps.parse(iLine);
		
		return jobj;
		
		} catch (Exception e) {
			System.out.println("접속실패!");
			return null;
		}
	}
}
