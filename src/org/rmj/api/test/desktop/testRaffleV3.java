package org.rmj.api.test.desktop;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.dcp.APIParam;
import org.rmj.api.test.login.WebClient;
import org.rmj.appdriver.SQLUtil;

public class testRaffleV3 {
    public static void main (String [] args){
        String sURL = "https://restgk.guanzongroup.com.ph/promo/v3/manual_entry.php";
        
        Map<String, String> headers = APIParam.getHeader2();
        
        JSONObject param = new JSONObject();
        param.put("sBranchCd", "P001");
        param.put("dTransact", "2022-10-06");
        param.put("sReferNox", "2222");
        param.put("sClientNm", "Cuison, Michael Torres");
        param.put("sAddressx", "027 Pogo grande, Dagupan City");
        param.put("sMobileNo", "09260375777");
        param.put("nAmtPaidx", 100.0);
        
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
    public static HashMap getHeader(){
        String clientid = "GGC_BGK01";
        String productid = "gRider";
        String imei = "GMC_SEG09";
        String user = "M001111122";
        String log = "";
        
        Calendar calendar = Calendar.getInstance();
        Map<String, String> headers = 
                        new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("g-api-id", productid);
        headers.put("g-api-imei", imei);
        
        headers.put("g-api-key", SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss"));        
        headers.put("g-api-hash", org.apache.commons.codec.digest.DigestUtils.md5Hex((String)headers.get("g-api-imei") + (String)headers.get("g-api-key")));
        headers.put("g-api-client", clientid);    
        headers.put("g-api-user", user);    
        headers.put("g-api-log", log);    
        headers.put("g-char-request", "UTF-8");
        headers.put("g-api-token", "");    
        
        return (HashMap) headers;
    }
}
