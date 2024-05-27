package org.rmj.api.test.dcp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.rmj.api.test.login.WebClient;

public class testDCPSubmit {
    public static void main(String [] args){
        String sURL = "https://restgk.guanzongroup.com.ph/integsys/dcp/dcp_submit.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        String lsValue = "{\"sTransNox\": \"M02821000231\", \"nEntryNox\": 1, \"sAcctNmbr\": \"M080180041\", \"sRemCodex\": \"NV\", \"dModified\": \"2021-10-21 06:05:56\", \"sJsonData\": {\"sRemarksx\": \"Not visited\"},\"dReceived\": \"\",\"sUserIDxx\": \"GAP021003548\"}";
        
        try {
            String response = WebClient.sendHTTP(sURL, lsValue, (HashMap<String, String>) headers);
            
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
