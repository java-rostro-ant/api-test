package org.rmj.api.test.marketplace;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testCompleteProfile {
    public static void main(String [] args){
        String sURL = "https://restgk.guanzongroup.com.ph/integsys/marketplace/complete_account_detail.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("dTransact", "2024-08-29");
        param.put("sLastName", "Cuison");
        param.put("sFrstName", "Michael");
        param.put("sMiddName", "Torres");
        param.put("sMaidenNm", "Marivic Torres");
        param.put("dBirthDte", "1991-07-07");
        param.put("sBirthPlc", "0314");
        param.put("sHouseNo1", "027");
        param.put("sAddress1", "Purok Centro");
        param.put("sBrgyIDx1", "0314");
        param.put("sTownIDx1", "0314");
        param.put("cGenderCd", "0");
        param.put("cCvilStat", "0");
        param.put("sSuffixNm", "");
        param.put("sGCashNox", "09260375777");
        param.put("sClientID", "M00111005387");
        
        try {
            String response = WebClient.sendHTTP(sURL, param.toJSONString(), (HashMap<String, String>) headers);
            
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
