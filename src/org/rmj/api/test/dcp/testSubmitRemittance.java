package org.rmj.api.test.dcp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testSubmitRemittance {
    public static void main(String[] args) {
        String sURL = "http://192.168.10.140/integsys/dcp/dcp_remit.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("sTransNox", "M00121000001");
        param.put("nEntryNox", 2);
        param.put("dTransact", "2021-04-20");
        param.put("cRemitTyp", "1");
        param.put("sCompnyNm", "GMC Dagupan - Honda");
        param.put("sBankAcct", "1234567");
        param.put("sReferNox", "11111");
        param.put("cPaymType", "0");
        param.put("nAmountxx", 30000.00);

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
