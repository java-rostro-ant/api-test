/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rmj.api.test.integsys;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testGetCASApprovals {
    public static void main(String[] args) {
        String sURL = "https://restgk.guanzongroup.com.ph/integsys/param/download_approval_requests.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("sEmployID", "M00103001137");
        param.put("sSourceCD", "POxx");
        param.put("dFrom", "2026-04-01");
        param.put("dTo", "2026-04-30");
        
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

