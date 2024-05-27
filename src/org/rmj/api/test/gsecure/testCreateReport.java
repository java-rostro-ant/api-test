package org.rmj.api.test.gsecure;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testCreateReport {
    public static void main(String[] args) {
        String sURL = "https://restgk.guanzongroup.com.ph/gsecure/reports/get_personnel_report.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("sUserIDxx", "MX0124000004");
        param.put("dStartDte", "2024-12-30");
        param.put("dEndDatex", "2024-12-30");
        
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
