import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.util.*;


class SignV1 {

public static String signChat(Map<String, String> payload, String key){
  String result = "";
try{
String stringToSign = String.format(
    "%s&%s&%s&%s",
    payload.get("timestamp"),
    payload.get("client_id"),
    payload.get("sender"),
    payload.get("job_id")
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
payload.put("timestamp", "2022-03-08T00:18:39.115Z");
payload.put("client_id", "YINYANG");
payload.put("job_id", "f0b9930f-8aca-4ace-9d9c-d5684343b9a7");
payload.put("sender", "SUP");

//This is an example of the key that Instaleap provided you
String key = "sdfsdfsdf234234234sdfsdfsdfsdfdsf";

System.out.print("instaleap-signature-v3: t="+payload.get("timestamp")+",v3="+SignV1.signChat(payload, key));

}

}
