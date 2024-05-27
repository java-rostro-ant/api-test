package org.rmj.api.test.dcp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.rmj.api.test.login.WebClient;

public class testSubmitCIForm {
    public static void main (String [] args){
        String lsValue = "{\"sTransNox\":\"CI4022100019\",\"sCredInvx\":\"GAP020202408\",\"sLandMark\":\"sjjs\",\"cOwnershp\":\"0\",\"cOwnOther\":\"1\",\"cHouseTyp\":\"1\",\"cGaragexx\":\"1\",\"nLatitude\":16.0357522,\"nLongitud\":120.3315923,\"cHasOther\":\"0\",\"cHasRecrd\":\"0\",\"sRemRecrd\":\"\",\"sNeighbr1\":\"nsnbsn\",\"sAddress1\":\"nsns\",\"sReltnCD1\":\"01\",\"sMobileN1\":\"09123464548\",\"cFeedBck1\":\"1\",\"sFBRemrk1\":\"vgx\",\"sNeighbr2\":\"hdhd\",\"sAddress2\":\"bh\",\"sReltnCD2\":\"20\",\"sMobileN2\":\"09757554544\",\"cFeedBck2\":\"1\",\"sFBRemrk2\":\"vg\",\"sNeighbr3\":\"hshs\",\"sAddress3\":\"jsjd\",\"sReltnCD3\":\"03\",\"sMobileN3\":\"09464646655\",\"cFeedBck3\":\"1\",\"sFBRemrk3\":\"bsbdd\",\"nWaterBil\":0,\"nElctrcBl\":0,\"nFoodAllw\":0,\"nLoanAmtx\":0,\"nEducExpn\":0,\"nOthrExpn\":0,\"cGamblerx\":\"0\",\"cWomanizr\":\"0\",\"cHvyBrwer\":\"0\",\"cWithRepo\":\"0\",\"cWithMort\":\"0\",\"cArrogant\":\"0\",\"sOtherBad\":\"0\",\"sRemarksx\":\"hhshshs\",\"cTranStat\":\"1\",\"dApproved\":\"2021-05-15 13:03:02\"}";
        
        String sURL = "http://192.168.10.140/integsys/gocas/upload_ci_result.php";
        
        Map<String, String> headers = APIParam.getHeader1();

        String response;
        try {
            response = WebClient.sendHTTP(sURL, lsValue, (HashMap<String, String>) headers);
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
