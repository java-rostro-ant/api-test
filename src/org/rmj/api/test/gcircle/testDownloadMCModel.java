package org.rmj.api.test.gcircle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.dcp.APIParam;
import org.rmj.api.test.login.WebClient;

public class testDownloadMCModel {
    public static void main(String[] args) {
        String sURL = "https://restgk.guanzongroup.com.ph/integsys/param/download_mc_model.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();        
        param.put("descript", "all"); //used to specify a model id, can be empty ex. "M00120011"
        param.put("timestamp", ""); //used to specify price last update date, can be empty ex. "2022-11-26"

        
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
