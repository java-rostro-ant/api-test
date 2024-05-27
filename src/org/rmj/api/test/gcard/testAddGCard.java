package org.rmj.api.test.gcard;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.dcp.APIParam;
import org.rmj.api.test.login.WebClient;
import org.rmj.appdriver.MySQLAESCrypt;

public class testAddGCard {
    public static void main(String[] args) {
        String sURL = "http://localhost/gcard/ms/add_gcardnumber.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("secureno", MySQLAESCrypt.Encrypt("4500401502301", "20190625"));
        param.put("bday", "1975-04-29");
        param.put("newdevce", "1");
        
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

