package org.rmj.api.test.integsys;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testCreditOnlineApplicationList {
    public static void main(String[] args) {
        String sURL = "http://192.168.10.140/integsys/param/download_credit_online_application_list.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("value", "CI5F72100002");// ->> Credit Online Trans to download
        param.put("bsearch", true); //->> always true
        //param.put("bycode", false);
        
        
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
