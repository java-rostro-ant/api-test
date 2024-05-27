package org.rmj.api.test.dcp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testSubmitCoordinates {
    public static void main(String[] args) {
        String sURL = "http://192.168.10.140/integsys/dcp/dcp_sumbit_coordinates.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("dTransact", "2021-04-20 08:00:00");
        param.put("nLatitude", 1);
        param.put("nLongitud", 2);

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
