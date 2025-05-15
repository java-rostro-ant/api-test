
import org.rmj.appdriver.MySQLAESCrypt;

public class testMySQLAES {
    public static void main(String [] args){
        String lsOriginal = "5000.00";
        String lsEncryptd;
        String lsDecryptd;
        
        lsEncryptd = MySQLAESCrypt.Encrypt(lsOriginal, "08220326");
        System.out.println(lsEncryptd);
        
        lsDecryptd = MySQLAESCrypt.Decrypt(lsEncryptd, "08220326");
        System.out.println(lsDecryptd);
    }
}
