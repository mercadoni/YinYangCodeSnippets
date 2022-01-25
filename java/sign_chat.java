import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.util.*;


class SignV1 {

public static String signChat(Map<String, String> payload, String key){
  String result = "";
try{
String stringToSign = String.format(
    "%s&%s&%s%s&%s",
    payload.get("id"),
    payload.get("client_id"),
    payload.get("created_at"),
    payload.get("job_id"),
    payload.get("sender")
    );
Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"),"HmacSHA256");
sha256_HMAC.init(secret_key);

String hex = new BigInteger(1, sha256_HMAC.doFinal(stringToSign.getBytes("UTF-8"))).toString(16);
result =hex;
}catch (Exception e) {
  result = e.getMessage();
}    
return result;
}

public static void main(String [] args) throws Exception {

//This is a mock with a reduced payload example used only for demonstration purposes
Map<String, String> payload = new HashMap<String, String>();
payload.put("id", "e33cc801-9f47-4077-9892-fd4a6db5d51f");
payload.put("client_id", "6c5801a7-23ce-40be-8f60-aefdd2c48fef");
payload.put("created_at", "2022-01-01T0:00:00+0000");
payload.put("job_id", "cb7f44ba-71ac-428e-b752-dfa757f36dfb");
payload.put("sender", "SH");

//This is an example of the key that Instaleap provided you
String key = "e179017a-62b0-4996-8a38-e91aa9f1";

System.out.print(Main.signChat(payload, key));

}

}







