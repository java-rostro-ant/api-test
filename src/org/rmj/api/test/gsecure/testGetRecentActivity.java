package org.rmj.api.test.gsecure;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testGetRecentActivity {
    public static void main(String[] args) {
        String sURL = "http://localhost/gsecure/patrol/get_recent_activity.php";
        
        Map<String, String> headers = APIParam.getHeader1();
       
        JSONArray array = new JSONArray();
        
        JSONObject param = new JSONObject();
        param.put("sUserIDxx", "");

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
