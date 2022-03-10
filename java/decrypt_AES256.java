import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

class DecryptAES256 {

public static String decrypt(String encrypted, String initVector, String key) {
    try {
        initVector = new String(Base64.getDecoder().decode(initVector));
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        return new String(original);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
     return null;
}

   public static void main(String[] args) {

    // Key given to you by Instaleap
    String key= "7ZEYKlLdCA5fVySubsetmjdknROS7wFB";
    // Initial vector, you can find it in the payload of the webhook inside "identification" object
    String iv = "6maEJ/ULdKB";
    // Encrypted data that you can find in the payload of the webhook inside "identification" object
    String encryptedData = "CPEqmqjdpqx86dVRtU8mENJ3mwh5P3nYYa7WWyU5NTvqWuiFD2t74jvBR7YpIDHf";


    // Here we call and print the function decrypt defined above
    System.out.println(decrypt(encryptedData, iv,key));


  }
}
