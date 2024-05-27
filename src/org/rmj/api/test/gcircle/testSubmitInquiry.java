package org.rmj.api.test.gcircle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.dcp.APIParam;
import org.rmj.api.test.login.WebClient;

public class testSubmitInquiry {
    public static void main(String[] args) {
        String sURL = "https://restgk.guanzongroup.com.ph/gcircle/ganado/submit_inquiry.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("sClientNm", "Garcia, Michael Permison");
        param.put("cGanadoTp", "1");
        param.put("cPaymForm", "0");
        param.put("dCreatedx", "2023-05-26 11:00:00");
        param.put("dTargetxx", "2023-05-31");
        param.put("sRelatnID", "00");
        param.put("nLatitude", 1.00);
        param.put("nLongitud", 2.00);

        param.put("sClntInfo", "[{}]");
        param.put("sProdInfo", "[{}]");
        param.put("sPaymInfo", "[{}]");
        
        
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
