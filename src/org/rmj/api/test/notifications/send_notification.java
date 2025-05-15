/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rmj.api.test.notifications;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.rmj.api.test.login.WebClient;
import org.rmj.appdriver.SQLUtil;
/**
 *
 * @author User
 */
public class send_notification {
    public static void main(String[] args) throws Exception{
        String sURL = "https://restgk.guanzongroup.com.ph/notification/send_request.php";        
        Calendar calendar = Calendar.getInstance();
        //Create the header section needed by the API
        Map<String, String> headers = 
                        new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("g-api-id", "GuanzonApp");
        headers.put("g-api-imei", "356060072281722");
        headers.put("g-api-key", SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss"));    
        headers.put("g-api-hash", org.apache.commons.codec.digest.DigestUtils.md5Hex((String)headers.get("g-api-imei") + (String)headers.get("g-api-key")));    
        headers.put("g-api-user", "GAP0190001");   
        headers.put("g-api-mobile", "09171870011"); 
        headers.put("g-api-token", "cPYKpB-pPYM:APA91bE82C4lKZduL9B2WA1Ygd0znWEUl9rM7pflSlpYLQJq4Nl9l5W4tWinyy5RCLNTSs3bX3JjOVhYnmCpe7zM98cENXt5tIHwW_2P8Q3BXI7gYtEMTJN5JxirOjNTzxWHkWDEafza");    

        JSONArray rcpts = new JSONArray();
        JSONObject rcpt = new JSONObject();
        rcpt.put("app", "GuanzonApp");
        rcpt.put("user", "GAP024002233");
        rcpts.add(rcpt);
        
        for(int x = 0; x < 1; x++){
            //Create the parameters needed by the API
            JSONObject param = new JSONObject();
            param.put("type", "00000");
            param.put("parent", null);
            param.put("title", "Panalo");
            param.put("message", "Ref. 123456");
            param.put("rcpt", rcpts);
            param.put("infox", "");
//            param.put("infox", createBranchOpeningMessage());
           
            
            JSONParser oParser = new JSONParser();
            JSONObject json_obj = null;

            String response = WebClient.sendHTTP(sURL, param.toJSONString(), (HashMap<String, String>) headers);
            if(response == null){
                System.out.println("HTTP Error detected: " + System.getProperty("store.error.info"));
                System.exit(1);
            }
            //json_obj = (JSONObject) oParser.parse(response);
            //System.out.println(json_obj.toJSONString());

            System.out.println(response);
        }
    }
    
    private static String createJSON(){
        JSONObject loJSON = new JSONObject();
        JSONObject loData = new JSONObject();
        
        loJSON.put("module", "00001");

        loData.put("table", "xxxSysConfig");       
        
        JSONObject loKey = new JSONObject();
        loKey.put("sConfigCd", "dcp.coordinates.capturing.interval");    
        loData.put("key", loKey);
        
        JSONObject loFields = new JSONObject();
        loFields.put("sConfigDs", "Capture collector coordinates with this interval.");
        loFields.put("sConfigVl", "15");
        loData.put("fields", loFields);
        
        loJSON.put("data", loData);
        
        return loJSON.toJSONString();
    }
    
    private static String createBranchOpeningMessage(){
        JSONObject loJSON = new JSONObject();
        
        loJSON.put("module", "00001");
        
        JSONObject loFields = new JSONObject();
        loFields.put("cTranStat", "2");
//        loFields.put("sOrderIDx", "MX0122000030");
        loFields.put("sListIDxx", "C00122000002");
        loJSON.put("data", loFields);
        
        return loJSON.toJSONString();
    }
}
