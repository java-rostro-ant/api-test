/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rmj.api.test.integsys;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.dcp.APIParam;
import org.rmj.api.test.login.WebClient;

/**
 *
 * @author user
 */
public class testConfirmOBApplication {
    public static void main(String[] args) {
        String sURL = "https://restgk.guanzongroup.com.ph/petmgr/confirm_ob_application.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("sTransNox", "MX0124000092");
        param.put("dAppldFrx", "2024-02-12");
        param.put("dAppldTox", "2024-02-12");
        param.put("cTranStat", "1");
        param.put("nWithPayx", 1);
        param.put("nWithOPay", 0);
        param.put("dApproved", "2024-02-19");
        
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
