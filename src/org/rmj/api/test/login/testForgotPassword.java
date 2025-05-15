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

public class testForgotPassword {
    public static void main(String [] args){
        String sURL = "https://restgk.guanzongroup.com.ph/security/forgotpswd.php";
        
        String clientid = "";
        String productid = "gRider";
        String imei = "GMC_SEG09";
        String mobile = "";
        
        Calendar calendar = Calendar.getInstance();
        Map<String, String> headers = 
                        new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("g-api-id", productid);
        headers.put("g-api-imei", imei);
        headers.put("g-api-mobile", mobile);
        
        headers.put("g-api-key", SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss"));        
        headers.put("g-api-hash", org.apache.commons.codec.digest.DigestUtils.md5Hex((String)headers.get("g-api-imei") + (String)headers.get("g-api-key")));
        headers.put("g-api-client", clientid);    
        headers.put("g-api-user", "");    
        headers.put("g-api-log", "");    
        headers.put("g-api-token", "12312312");    
        

        JSONObject param = new JSONObject();
        param.put("email", "jonalindaroya77@gmail.com");
        
        JSONParser oParser = new JSONParser();
        JSONObject json_obj = null;
        
        String response;
        try {
            response = WebClient.sendHTTP(sURL, param.toJSONString(), (HashMap<String, String>) headers);
            if(response == null){
                System.out.println("No Response");
                System.exit(1);
            } 
            
            System.out.println(response);
        } catch (IOException ex) {
            Logger.getLogger(testForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
