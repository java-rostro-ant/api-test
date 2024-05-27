package org.rmj.api.test.integsys;

import org.rmj.api.test.dcp.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.rmj.api.test.login.WebClient;

public class testSendCashCount {
    public static void main(String[] args) {
        String sURL = "https://restgk.guanzongroup.com.ph/integsys/cashcount/submit_cash_count.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        String lsSQL = "{\"nCn0005cx\":0,\"nCn0010cx\":0,\"nCn0025cx\":0,\"nCn0050cx\":0,\"nCn0001px\":0,\"nCn0005px\":0,\"nCn0010px\":0,\"nNte0020p\":0,\"nNte0050p\":0,\"nNte0100p\":1,\"nNte0200p\":1,\"nNte0500p\":1,\"nNte1000p\":1,\"sTransNox\":\"220000000002\",\"sBranchCd\":\"M001\",\"sORNoxxxx\":\"123456\",\"sSINoxxxx\":\"123456\",\"sPRNoxxxx\":\"123456\",\"sCRNoxxxx\":\"123456\",\"dTransact\":\"2022-01-28\",\"dEntryDte\":\"2022-01-28 05:49:44\",\"sReqstdBy\":\"M00111005387\"}";
        
        String response;
        try {
            response = WebClient.sendHTTP(sURL, lsSQL, (HashMap<String, String>) headers);
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
