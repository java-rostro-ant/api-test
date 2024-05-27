package org.rmj.api.test.integsys;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testSendSelfieLogin {
    public static void main(String[] args) {
        String sURL = "https://restgk.guanzongroup.com.ph/integsys/hcm/selfie_log.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("sEmployID", "M00111005387");
        param.put("dLogTimex", "2022-06-10 14:55:26");
        param.put("sBranchCd", "M001");
        param.put("nLatitude", 0.01);
        param.put("nLongitud", 0.02);
        
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
