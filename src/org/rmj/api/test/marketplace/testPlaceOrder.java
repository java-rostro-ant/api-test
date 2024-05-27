package org.rmj.api.test.marketplace;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.rmj.api.test.login.WebClient;
import org.rmj.appdriver.SQLUtil;

public class testPlaceOrder {
    public static void main(String [] args){
        String sURL = "https://restgk.guanzongroup.com.ph/integsys/marketplace/place_order.php";
        
        String clientid = "GGC_BM001";
        String productid = "GuanzonApp";
        String imei = "GMC_SEG09";
        
        Calendar calendar = Calendar.getInstance();
        Map<String, String> headers = 
                        new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("g-api-id", productid);
        headers.put("g-api-imei", imei);
        
        headers.put("g-api-key", SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss"));        
        //headers.put("g-api-hash", md5Hex((String)headers.get("g-api-imei") + (String)headers.get("g-api-key")));    
        headers.put("g-api-hash", org.apache.commons.codec.digest.DigestUtils.md5Hex((String)headers.get("g-api-imei") + (String)headers.get("g-api-key")));
        headers.put("g-api-client", clientid);    
        headers.put("g-api-user", "GAP0190004");    
        headers.put("g-api-mobile", "09260375777");    
        headers.put("g-api-token", "");
        headers.put("g-api-log", "");    
        
        //Create the parameters needed by the API
        JSONObject loJSON;
        JSONArray loArray = new JSONArray();
        
        loJSON = new JSONObject();
        loJSON.put("sListngID", "C00122000001");
        loJSON.put("nQuantity", 1);
        loArray.add(loJSON);
        
        loJSON = new JSONObject();
        loJSON.put("sListngID", "C00122000002");
        loJSON.put("nQuantity", 2);
        loArray.add(loJSON);
        
        loJSON = new JSONObject();
        loJSON.put("sListngID", "C00122000003");
        loJSON.put("nQuantity", 3);
        loArray.add(loJSON);
        
        JSONObject param = new JSONObject();
        param.put("cCartItem", 0); //0 - direct place order; 1 - place order of cart item
        param.put("nFreightx", 100.00); //Freight charge
       
        //param.put("sTermCode", "PAYM"); //payment term : PayMaya
        //param.put("sReferNox", ""); //payment reference no.
        
        //param.put("sTermCode", "GCSH"); //payment term : GCash
        //param.put("sReferNox", ""); //payment reference no.
        
        //param.put("sTermCode", "NP"); //payment term : nortpoint
        //param.put("sReferNox", ""); //credit application number
        
        param.put("detail", loArray); //items
        
        JSONParser oParser = new JSONParser();
        JSONObject json_obj = null;
        
        String response;
        try {
            response = WebClient.sendHTTP(sURL, param.toJSONString(), (HashMap<String, String>) headers);
            if(response == null){
                System.out.println("No Response");
                System.exit(1);
            } 
            
            System.out.println(response);
        } catch (IOException ex) {
            Logger.getLogger(testPlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}