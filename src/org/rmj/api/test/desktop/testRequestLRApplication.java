package org.rmj.api.test.desktop;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testRequestLRApplication {
    public static void main(String[] args) {
        String sURL = "http://192.168.10.140/integsys/gocas/lr_application_request.php";
        
        Map<String, String> headers = APIParam.getHeader2();
        
        JSONObject param = new JSONObject();
        param.put("refernox", "");
        
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
