package org.rmj.api.test.notifications;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.dcp.APIParam;
import org.rmj.api.test.login.WebClient;

public class testSendVoteOTP {
    public static void main (String [] args){
        String sURL = "https://restgk.guanzongroup.com.ph/notification/sendVotingOTP.php";
        
        Map<String, String> headers = APIParam.getHeader3();
        
        JSONObject param = new JSONObject();
        param.put("mobile", "09176340516");
        param.put("message", "Guanzon: 123456 is your PIN to login to Guanzon Festival 2024 events voting. PIN validity is within the day. Thank you.");
        param.put("referno", "GFEST2024");
        
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