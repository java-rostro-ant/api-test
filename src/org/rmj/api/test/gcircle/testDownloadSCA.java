package org.rmj.api.test.gcircle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.dcp.APIParam;
import org.rmj.api.test.login.WebClient;

public class testDownloadSCA {
    public static void main(String[] args) {
        String sURL = "http://localhost/integsys/param/download_sca_request.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();        
        param.put("descript", "all");
        param.put("timestamp", "2024-07-15 12:00:00");
        
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
