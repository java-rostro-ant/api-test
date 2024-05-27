package org.rmj.api.test.gsecure;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testAddPeronnel {
    public static void main(String[] args) {
        String sURL = "https://restgk.guanzongroup.com.ph/gsecure/personnel/add_personnel.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("sLastName", "Sabiniano");
        param.put("sFrstName", "Jonathan");
        param.put("sMiddName", "");
        param.put("sPositnID", "001");
        param.put("nUserLvel", 0);
        
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
