
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.math.BigInteger;

import java.util.*;


class Main {

public static String signV1(Map<String, String> payload, String key){
  String result = "";
try{
String stringToSign = String.format("%s&%s&%s",payload.get("id"),payload.get("created_at"),payload.get("type"));
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
payload.put("id", "90aa7525-3b40-4f9e-a7ff-347630d38aae");
payload.put("created_at", "2022-01-01T0:00:00+0000");
payload.put("type", "PICKING_FINISHED");

//This is an example of the key that Instaleap provided you
String key = "e179017a-62b0-4996-8a38-e91aa9f1";

System.out.print("instaleap-signature: "+Main.signV1(payload, key));

}

}







    