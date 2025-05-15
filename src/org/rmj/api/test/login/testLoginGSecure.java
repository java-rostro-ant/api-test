package org.rmj.api.test.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.rmj.api.test.dcp.APIParam;

public class testLoginGSecure {
    public static void main(String [] args){
        String sURL = "http://localhost/gsecure/auth/login_mpin.php";   
        
        //Create the parameters needed by the API
        JSONObject param = new JSONObject();
        param.put("mpin", "912191");
        param.put("vrsnNumber", "123");
        
        String response;
        try {
            response = WebClient.sendHTTP(sURL, param.toJSONString(), (HashMap<String, String>) APIParam.getHeaderGSecure());
            if(response == null){
                System.out.println("No Response");
                System.exit(1);
            } 
            
            System.out.println(response);
        } catch (IOException ex) {
            Logger.getLogger(testLogoutGSecure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
