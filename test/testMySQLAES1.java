import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class testMySQLAES1 {
    // MySQL specific key padding to 16 bytes (128 bit)
    private static SecretKeySpec createMySQLKey(String key) {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        byte[] finalKey = new byte[16];  // 128-bit key

        // Copy key bytes into finalKey array
        for (int i = 0; i < keyBytes.length && i < finalKey.length; i++) {
            finalKey[i] = keyBytes[i];
        }

        // Return the SecretKeySpec
        return new SecretKeySpec(finalKey, "AES");
    }

    // MySQL's AES_ENCRYPT equivalent
    public static String aesEncrypt(String valueToEncrypt, String key) throws Exception {
        SecretKeySpec secretKey = createMySQLKey(key);
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");

        byte[] valueBytes = valueToEncrypt.getBytes(StandardCharsets.UTF_8);
        
        // Pad the value to a multiple of 16 bytes
        int blockSize = cipher.getBlockSize();
        int padding = blockSize - (valueBytes.length % blockSize);
        byte[] paddedValueBytes = new byte[valueBytes.length + padding];
        System.arraycopy(valueBytes, 0, paddedValueBytes, 0, valueBytes.length);
        
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(paddedValueBytes);
        
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // MySQL's AES_DECRYPT equivalent
    public static String aesDecrypt(String encryptedValue, String key) throws Exception {
        SecretKeySpec secretKey = createMySQLKey(key);
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
        
        // Trim trailing padding bytes
        int paddingIndex = decryptedBytes.length;
        while (paddingIndex > 0 && decryptedBytes[paddingIndex - 1] == 0) {
            paddingIndex--;
        }
        
        return new String(decryptedBytes, 0, paddingIndex, StandardCharsets.UTF_8);
    }

    // Example usage
    public static void main(String[] args) {
        try {
            String key = "08220326"; // Replace with your MySQL AES key
            String originalText = "5000.00";
            
            String encryptedText = aesEncrypt(originalText, key);
            System.out.println("Encrypted: " + encryptedText);
            
            String decryptedText = aesDecrypt(encryptedText, key);
            System.out.println("Decrypted: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
