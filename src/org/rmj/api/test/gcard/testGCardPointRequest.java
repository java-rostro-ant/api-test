package org.rmj.api.test.gcard;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.rmj.api.test.dcp.APIParam;
import org.rmj.api.test.login.WebClient;

public class testGCardPointRequest {
    public static void main(String[] args) {
        String sURL = "http://localhost/gcard/ms/dgcard_points_request.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        //Map<String, String> headers = APIParam.getHeader2();
        
        JSONObject param = new JSONObject();
        param.put("sGCardNox", "M0R123000134");
        param.put("dTransact", "2024-04-03");
        param.put("sBranchCD", "M002");
        param.put("sReferNox", "654329");
        param.put("sSourceCd", "M02910000002");
        param.put("sOTPasswd", "335723");
        
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

