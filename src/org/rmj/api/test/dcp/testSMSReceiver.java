package org.rmj.api.test.dcp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testSMSReceiver {
    public static void main(String[] args) {
        String sURL = "http://localhost/telemarketing/SMSClassify.php";
        
        Map<String, String> headers = APIParam.getHeader2();
        
        JSONObject param = new JSONObject();
        param.put("mobile", "09260375777");
        param.put("message", "Michael Nuñez.");
        param.put("timestamp", "2023-03-09 02:45:26");
        
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
