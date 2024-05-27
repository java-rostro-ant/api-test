package org.rmj.api.test.gsecure;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testGetCategory {
    public static void main(String[] args) {
        String sURL = "http://localhost/gsecure/place/get_category.php";
        
        Map<String, String> headers = APIParam.getHeaderGSecure();
        
        JSONObject param = new JSONObject();
        param.put("dTimeStmp", "2023-12-03 22:50:23");
        
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
