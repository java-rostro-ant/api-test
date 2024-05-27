package org.rmj.api.test.gsecure;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testCreateSchedule {
    public static void main(String[] args) {
        String sURL = "http://localhost/gsecure/patrol/create_schedule.php";
        
        Map<String, String> headers = APIParam.getHeader1();
       
        JSONObject param = new JSONObject();
        param.put("sUserIDxx", "MX0123000001");
        param.put("sWHouseID", "001");
        param.put("sNotesxxx", "Security Patrol");
        
        JSONArray array = new JSONArray();
        
        JSONObject detail = new JSONObject();
        detail.put("nSchedule", 1);
        detail.put("dTimexxxx", "12-02-2023 12:00:00");
        array.add(detail);
        
        detail = new JSONObject();
        detail.put("nSchedule", 2);
        detail.put("dTimexxxx", "12-02-2023 14:00:00");
        array.add(detail);
        
        param.put("sSchedule", array);
        
        array = new JSONArray();
        
        detail = new JSONObject();
        detail.put("nPatrolNo", 1);
        detail.put("sNFCIDxxx", "0001");
        array.add(detail);
        
        detail = new JSONObject();
        detail.put("nPatrolNo", 2);
        detail.put("sNFCIDxxx", "0002");
        array.add(detail);
        
        param.put("sRoutexxx", array);
        
        String response;
        try {
            response = WebClient.sendHTTP(sURL, param.toJSONString(), (HashMap<String, String>) headers);
            if(response == null){
                System.out.println("No Response");
                System.exit(1);
            } 
            
            System.out.println(response);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
