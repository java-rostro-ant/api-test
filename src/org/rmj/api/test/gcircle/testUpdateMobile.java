package org.rmj.api.test.gcircle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.dcp.APIParam;
import org.rmj.api.test.login.WebClient;

public class testUpdateMobile {
    public static void main(String[] args) {
        String sURL = "https://restgk.guanzongroup.com.ph/security/request_mobile_update.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("sTransNox", "000000000001");
        param.put("sClientID", "");
        param.put("cReqstCDe", "0");
        param.put("sMobileNo", "09176340516");
        param.put("cPrimaryx", "");
        param.put("sRemarksx", "");
        param.put("sSourceCD", "SKit");
        param.put("sSourceNo", "GAP0190004");
        param.put("sEmailAdd", "michael_cuison07@yahoo.com");

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
