package org.rmj.api.test.desktop;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;
import org.rmj.appdriver.MySQLAESCrypt;

public class testCreateRaffle {
    public static void main(String[] args) {
        String  qr;
        
        qr = "M00123000001;GAP0190004;2023-05-17 10:49:00";
        System.out.println(MySQLAESCrypt.Encrypt(qr, "20190625"));
        qr = "MCSO;M001230;GAP019000;2023-05-17 10:49:00";
        System.out.println(MySQLAESCrypt.Encrypt(qr, "20190625"));

//        String sURL = "https://restgk.guanzongroup.com.ph/gconnect/create_raffle.php";
//        
//        Map<String, String> headers = APIParam.getHeader2();
//        
//        JSONObject param = new JSONObject();
//        param.put("payload", "2E3DF71A4AEF0657C946EDAD0DA9132C65DCD6123DD2BC0E6CDF83CDBD7EDED3455604BF6C17689F62EF2E2F1026D44343EC6CD05EEFB93D5BEE8C12ADAC76F9");
//        
//        String response;
//        try {
//            response = WebClient.sendHTTP(sURL, param.toJSONString(), (HashMap<String, String>) headers);
//            if(response == null){
//                System.out.println("No Response");
//                System.exit(1);
//            } 
//            
//            System.out.println(response);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }
}
