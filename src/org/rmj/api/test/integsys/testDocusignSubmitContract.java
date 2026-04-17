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
public class testDocusignSubmitContract {
    public static void main(String[] args) {
        String sURL = "http://localhost/integsys/param/submit_mc_contract.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("sBranchCd", "M001");
        param.put("dTransact", "2026-04-17");
        param.put("sClientID", "");
        param.put("sAcctNmbr", "");
        param.put("sReferNox", "FH9Q92600004");
        param.put("dPurchase", "2026-04-16");
        param.put("sSerialID", "M0W524001093");
        param.put("nDownPaym", 10000.00);
        param.put("nAcctTerm", 36);
        param.put("nMonAmort", 4057.00);
        param.put("sRemarksx", "");
        param.put("cTranStat", "0");
        
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
