package org.rmj.api.test.marketplace;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testUpdateEmail {
    public static void main(String [] args){
        String sURL = "http://localhost/integsys/marketplace/update_client_email.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("sEmailAdd", "xurpas7@gmail.com");
        
        try {
            String response = WebClient.sendHTTP(sURL, param.toJSONString(), (HashMap<String, String>) headers);
            
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
