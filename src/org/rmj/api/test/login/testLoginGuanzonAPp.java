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

public class testLoginGuanzonAPp {
    public static void main(String [] args){
        String sURL = "http://192.168.10.64/security/signin.php";
        
        String clientid = "GGC_BM001";
        String productid = "GuanzonApp";
        String imei = "GMC_SEG09";
        
        Calendar calendar = Calendar.getInstance();
        Map<String, String> headers = 
                        new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("g-api-id", productid);
        headers.put("g-api-imei", imei);
        
        headers.put("g-api-key", SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss"));        
        headers.put("g-api-hash", org.apache.commons.codec.digest.DigestUtils.md5Hex((String)headers.get("g-api-imei") + (String)headers.get("g-api-key")));
        headers.put("g-api-client", clientid);    
        headers.put("g-api-user", "");    
        headers.put("g-api-log", "");    
        headers.put("g-api-token", "12312312");    
        

        JSONObject param = new JSONObject();
        param.put("user", "michael_cuison07@yahoo.com");
        param.put("pswd", "abcdefg");
        
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
            Logger.getLogger(testLoginGuanzonAPp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
