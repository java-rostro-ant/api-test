package org.rmj.api.test.dcp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testAddressUpdate {
    public static void main(String [] args){
        String sURL = "http://192.168.10.140/integsys/dcp/request_address_update.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        JSONObject param = new JSONObject();
        param.put("sTransNox", "210000000001");
        param.put("sClientID", "M05014000168");
        param.put("cReqstCDe", "0");
        param.put("cAddrssTp", "0");
        param.put("sHouseNox", "464");
        param.put("sAddressx", "Haha");
        param.put("sTownIDxx", "0315");
        param.put("sBrgyIDxx", "1103664");
        param.put("cPrimaryx", "0");
        param.put("nLatitude", 1.00);
        param.put("nLongitud", 2.00);
        param.put("sRemarksx", "");
        param.put("sSourceCD", "DCPa");
        param.put("sSourceNo", "M001170119");
        
        String lsSQL = "{\"sTransNox\":\"210000000001\",\"sClientID\":\"M05014000168\",\"cReqstCDe\":\"0\",\"cAddrssTp\":\"0\",\"sHouseNox\":\"464\",\"sAddressx\":\"Haha\",\"sTownIDxx\":\"0315\",\"sBrgyIDxx\":\"1103664\",\"cPrimaryx\":\"0\",\"sRemarksx\":\"\",\"sSourceCD\":\"DCPa\",\"sSourceNo\":\"M001170119\"}";
        
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
