package org.rmj.api.test.dcp;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.rmj.appdriver.SQLUtil;

public class APIParam {
    public static HashMap getHeaderGSecure(){
        String clientid = "GGC_BM001";
        String productid = "gRider";
        String imei = "GMC_SEG09";
        String user = "MX0125000001";
        
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
        headers.put("g-api-user", user);    
        headers.put("g-api-log", "GAP025000007");    
        headers.put("g-api-token", "TEST API TOKEN ONLY FOR MAC LAPTOP"); 
        
        return (HashMap) headers;
    }
    
    public static HashMap getHeader1(){
        String clientid = "GGC_BM001";
        String productid = "gRider";
        String imei = "GMC_SEG09";
        String user = "GAP022002117";
        String log = "GAP025035090";
        String token = "";
        
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
        headers.put("g-api-user", user);    
        headers.put("g-api-log", log);    
        headers.put("g-api-mobile", "09260375777");    
        headers.put("g-char-request", "UTF-8");
        headers.put("g-api-token", token);    
        
        return (HashMap) headers;
    }
    
    public static HashMap getHeader2(){
        String clientid = "GGC_BM001";
        String productid = "gRider";
        String imei = "GMC_SEG09";
        String user = "M001111122";
        String log = "";
        
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
        headers.put("g-api-user", user);    
        headers.put("g-api-log", log);    
        headers.put("g-char-request", "UTF-8");
        headers.put("g-api-token", "");    
        
        return (HashMap) headers;
    }
    
    public static HashMap getHeader3(){
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("g-api-id", "IntegSys");
        headers.put("g-api-imei", "GMC_SEG09");
        headers.put("g-api-client", "GGC_BM001");    
        headers.put("g-api-user", "M001111122");      
        headers.put("g-char-request", "UTF-8"); 
        
        return (HashMap) headers;
    }
}
