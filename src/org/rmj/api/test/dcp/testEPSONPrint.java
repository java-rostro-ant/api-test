package org.rmj.api.test.dcp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testEPSONPrint {
    public static void main(String[] args) {
        String sURL = "http://localhost/escpos-php/src/2023.php";
        
        Map<String, String> headers = APIParam.getHeader2();
        
        JSONObject param = new JSONObject();
        param.put("printer", "localhost/EPSON TM-U220 Receipt");
        param.put("sEventDsc", "Awards Night");
        
        param.put("sCtrlNoxx", "23001");
        param.put("sTableDsc", "TABLE #1");
        param.put("sLocation", "Left Wing");
        
        param.put("cAttndTyp", "1");
        
        param.put("sPrefixNm", "CEO");
        param.put("sFirstNme", "Joseph");
        param.put("sLastName", "Lo");
        param.put("sAttendNm", "Lo, Joseph");
        param.put("sProxyNme", "");
        
        
        
        
        
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
