package org.rmj.api.test.gsecure;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testPostPlaceVisited {
    public static void main(String[] args) {
        String sURL = "https://restgk.guanzongroup.com.ph/gsecure/patrol/post_place_visited.php";
        
        Map<String, String> headers = APIParam.getHeaderGSecure();
       
        JSONArray array = new JSONArray();
        
        JSONObject param = new JSONObject();
        param.put("sNFCIDxxx", "0001");
        param.put("dSchedule", "2024-12-30 01:22:00");
        param.put("dVisitedx", "2024-12-30 02:22:00");
        param.put("sRemarksx", "My remarks");
        param.put("cRequestd", "0");
        array.add(param);
        
        param = new JSONObject();
        param.put("sNFCIDxxx", "0002");
        param.put("dSchedule", "2024-12-30 02:22:00");
        param.put("dVisitedx", "2024-12-30 03:22:00");
        param.put("sRemarksx", "My remarks");
        param.put("cRequestd", "1");
        array.add(param);
        
        param = new JSONObject();
        param.put("data", array);

        String response;
        try {
            response = WebClient.sendHTTP(sURL, param.toJSONString(), (HashMap<String, String>) APIParam.getHeaderGSecure());
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
