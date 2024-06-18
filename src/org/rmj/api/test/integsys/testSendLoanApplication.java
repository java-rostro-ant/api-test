package org.rmj.api.test.integsys;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testSendLoanApplication {
    public static void main(String[] args) {
        String sURL = "http://localhost/petmgr/send_loan_application.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("sEmployID", "M00111005387");
        param.put("dTransact", "2024-06-03");
        param.put("dLoanDate", "2024-06-03");
        param.put("sLoanIDxx", "11003");
        param.put("nLoanAmtx", 20000.00);
        param.put("sPurposed", "test only");
        
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
