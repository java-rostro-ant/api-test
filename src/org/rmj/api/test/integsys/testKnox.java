package org.rmj.api.test.integsys;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testKnox {
    public static void main(String[] args) {
        String sURL = "http://localhost/samsung/knox.php";
        
        Map<String, String> headers = APIParam.getHeader2();
        
        JSONObject param = new JSONObject();
        
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
