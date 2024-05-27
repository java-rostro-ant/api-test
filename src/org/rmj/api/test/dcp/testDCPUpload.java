package org.rmj.api.test.dcp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;

public class testDCPUpload {
    public static void main (String args []){
        String sURL = "http://192.168.10.140/integsys/dcp/dcp_upload.php";
        
        Map<String, String> headers = APIParam.getHeader2();
        
        JSONObject master = new JSONObject();
        master.put("sTransNox", "M00121000014");
        master.put("dTransact", "2021-02-04");
        master.put("sReferNox", "dcp1");
        master.put("sCollctID", "M00110006088");
        master.put("dReferDte", "2021-02-04");
        master.put("cDCPTypex", "1");
        master.put("nEntryNox", 0);
        master.put("sModified", "M001111122");
        master.put("dModified", "2021-02-04 08:00:00");
        
        JSONArray detail = new JSONArray();
        JSONObject param;
        
        ArrayList<String> sAcctNmbr = new ArrayList();
        sAcctNmbr.add("M001170119");
        sAcctNmbr.add("M002170040");
        sAcctNmbr.add("M005170428");
        sAcctNmbr.add("M028180002");
        sAcctNmbr.add("M050180019");
        sAcctNmbr.add("M001180265");
        sAcctNmbr.add("GCO1190010");
        sAcctNmbr.add("M001190075");
        sAcctNmbr.add("M001200033");
        sAcctNmbr.add("M028200009");
        
        for (int lnCtr = 0; lnCtr < 10; lnCtr++){
            param = new JSONObject();
            param.put("nEntryNox", lnCtr + 1);
            param.put("sAcctNmbr", sAcctNmbr.get(lnCtr));
            param.put("sReferNox", "");
            param.put("cPaymForm", "0");
            param.put("dPromised", null);
            param.put("sRemCodex", "");
            param.put("sRemarksx", "");
            param.put("cIsDCPxxx", "1");
            param.put("cIsNwNmbr", "0");
            param.put("cIsNwAddx", "0");
            param.put("cIsNwCltx", "0");
            param.put("dModified", "2021-02-04 08:00:00");
            detail.add(param);
        }

        param = new JSONObject();
        param.put("master", master);
        param.put("detail", detail);
        
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
