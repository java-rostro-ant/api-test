package org.rmj.api.test.dcp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testMobileUpdate {
    public static void main(String [] args){
        String sURL = "http://192.168.10.140/integsys/dcp/request_mobile_update.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("sTransNox", "M00121000001");
        param.put("sClientID", "M00111000001");
        param.put("cReqstCDe", "2");
        param.put("sMobileNo", "09260375777");
        param.put("cPrimaryx", "1");
        param.put("sRemarksx", "change mobile");
        param.put("sSourceCD", "DCPa");
        param.put("sSourceNo", "M00121000002");
        
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
