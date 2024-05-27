package org.rmj.api.test.login;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.rmj.appdriver.SQLUtil;

public class testSignUp {
    public static void main(String [] args){
        String sURL = "https://restgk.guanzongroup.com.ph/security/signup.php";
        
        String clientid = "GGC_BM001";
        String productid = "gRider";
        String imei = "GMC_SEG09";
        
        Calendar calendar = Calendar.getInstance();
        Map<String, String> headers = 
                        new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("g-api-id", productid);
        headers.put("g-api-imei", imei);
        
        headers.put("g-api-key", SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss"));        
        //headers.put("g-api-hash", md5Hex((String)headers.get("g-api-imei") + (String)headers.get("g-api-key")));    
        headers.put("g-api-hash", org.apache.commons.codec.digest.DigestUtils.md5Hex((String)headers.get("g-api-imei") + (String)headers.get("g-api-key")));
        headers.put("g-api-client", clientid);    
        headers.put("g-api-user", "");    
        headers.put("g-api-log", "");    
        headers.put("g-api-token", "12312312");    
        
        //Create the parameters needed by the API
        JSONObject param = new JSONObject();
        param.put("name", "Cena, John Doe");
        param.put("mail", "michael.cuison@gmail.com");
        param.put("pswd", "123456");
        param.put("mobile", "09260375777");
        
        String response;
        try {
            response = WebClient.sendHTTP(sURL, param.toJSONString(), (HashMap<String, String>) headers);
            if(response == null){
                System.out.println("No Response");
                System.exit(1);
            } 
            
            System.out.println(response);
        } catch (IOException ex) {
            Logger.getLogger(testSignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
