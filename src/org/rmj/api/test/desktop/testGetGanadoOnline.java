package org.rmj.api.test.desktop;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.rmj.api.test.login.WebClient;
import org.rmj.appdriver.SQLUtil;
import org.rmj.appdriver.agent.GRiderX;
import org.rmj.appdriver.agentfx.CommonUtils;

public class testGetGanadoOnline {
    public static void main(String[] args) {
        String sURL = "http://localhost/gcircle/ganado/download_ganado.php";
        
        String path;
        if(System.getProperty("os.name").toLowerCase().contains("win")){
            path = "D:/GGC_Java_Systems";
        }
        else{
            path = "/srv/GGC_Java_Systems";
        }
        System.setProperty("sys.default.path.config", path);

        GRiderX instance = new GRiderX("TeleMktg");

        if (!instance.logUser("TeleMktg", "M001230011")){
            System.err.println(instance.getMessage() + instance.getErrMsg());
            System.exit(1);
        }
        
        try {
            String sql;
            String param;
            ResultSet ors;
            
            JSONObject json = new JSONObject();
            
            if (args.length > 0){
                param = args[0];
                
                if (CommonUtils.isDate(param, SQLUtil.FORMAT_TIMESTAMP)){
                    json.put("sTransNox", "");
                    json.put("dTimeStmp", param);
                } else {
                    json.put("sTransNox", param);
                    json.put("dTimeStmp", "");
                }
            } else {
                sql = "SELECT dTimeStmp FROM Ganado_Online ORDER BY dTimeStmp DESC LIMIT 1";
                ors = instance.executeQuery(sql);

                json.put("sTransNox", "");
                json.put("dTimeStmp", "1900-01-01 00:00:01");
                
                if (ors.next()){
                    json.put("dTimeStmp", ors.getString("dTimeStmp"));
                }
            }

            Map<String, String> headers = getHeader();

            String response;
            
            response = WebClient.sendHTTP(sURL, json.toJSONString(), (HashMap<String, String>) headers);
            if(response == null){
                System.out.println("No Response");
                System.exit(1);
            } 
            
            JSONParser parser = new JSONParser();
            json = (JSONObject) parser.parse(response);
            
            
            if ("success".equals((String) json.get("result"))){
                JSONArray arr = (JSONArray) json.get("payload");
                
                
                for (int lnCtr = 0; lnCtr <= arr.size() - 1; lnCtr++){
                    json = (JSONObject) arr.get(lnCtr);
                    
                    sql = "SELECT sTransNox FROM Ganado_Online WHERE sTransNox = " + SQLUtil.toSQL(json.get("sTransNox"));
                    ors = instance.executeQuery(sql);
                    
                    if (ors.next()){
                        sql = "UPDATE Ganado_Online SET" +
                                    "  dTransact = " + SQLUtil.toSQL(json.get("dTransact")) +
                                    ", sClientNm = " + SQLUtil.toSQL(json.get("sClientNm")) +
                                    ", cSourcexx = " + SQLUtil.toSQL(json.get("cSourcexx")) +
                                    ", cGanadoTp = " + SQLUtil.toSQL(json.get("cGanadoTp")) +
                                    ", cPaymForm = " + SQLUtil.toSQL(json.get("cPaymForm")) +
                                    ", sCltInfox = " + SQLUtil.toSQL(json.get("sCltInfox")) +
                                    ", sFinancex = " + SQLUtil.toSQL(json.get("sFinancex")) +
                                    ", sPrdctInf = " + SQLUtil.toSQL(json.get("sPrdctInf")) +
                                    ", sPaymInfo = " + SQLUtil.toSQL(json.get("sPaymInfo")) +
                                    ", sCltInfoF = " + SQLUtil.toSQL(json.get("sCltInfoF")) +
                                    ", sFinanceF = " + SQLUtil.toSQL(json.get("sFinanceF")) +
                                    ", sPrdctxxF = " + SQLUtil.toSQL(json.get("sPrdctxxF")) +
                                    ", sPaymInfF = " + SQLUtil.toSQL(json.get("sPaymInfF"));
                        
                        if ("".equals((String) json.get("dTargetxx"))){
                            sql += ", dTargetxx = NULL";
                        } else {
                            sql += ", dTargetxx = " + SQLUtil.toSQL(json.get("dTargetxx"));
                        }
                        
                        if ("".equals((String) json.get("dFollowUp"))){
                            sql += ", dFollowUp = NULL";
                        } else {
                            sql += ", dFollowUp = " + SQLUtil.toSQL(json.get("dFollowUp"));
                        }
                        
                        sql = sql +
                                    ", sRemarksx = " + SQLUtil.toSQL(json.get("sRemarksx")) +
                                    ", sReferdBy = " + SQLUtil.toSQL(json.get("sReferdBy")) +
                                    ", sRelatnID = " + SQLUtil.toSQL(json.get("sRelatnID")) +
                                    ", dCreatedx = " + SQLUtil.toSQL(json.get("dCreatedx")) +
                                    ", nLatitude = " + SQLUtil.toSQL(json.get("nLatitude")) +
                                    ", nLongitud = " + SQLUtil.toSQL(json.get("nLongitud")) +
                                    ", sClientID = " + SQLUtil.toSQL(json.get("sClientID")) +
                                    ", sTLMAgent = " + SQLUtil.toSQL(json.get("sTLMAgent")) +
                                    ", cTranStat = " + SQLUtil.toSQL(json.get("cTranStat")) +
                                    ", sModified = " + SQLUtil.toSQL(json.get("sModified")) +
                                    ", dModified = " + SQLUtil.toSQL(json.get("dModified")) +
                                    ", dTimeStmp = " + SQLUtil.toSQL(json.get("dTimeStmp")) +
                                " WHERE sTransNox = " + SQLUtil.toSQL(json.get("sTransNox"));
                    } else {
                        sql = "INSERT INTO Ganado_Online SET" +
                                    "  sTransNox = " + SQLUtil.toSQL(json.get("sTransNox")) +
                                    ", dTransact = " + SQLUtil.toSQL(json.get("dTransact")) +
                                    ", sClientNm = " + SQLUtil.toSQL(json.get("sClientNm")) +
                                    ", cSourcexx = " + SQLUtil.toSQL(json.get("cSourcexx")) +
                                    ", cGanadoTp = " + SQLUtil.toSQL(json.get("cGanadoTp")) +
                                    ", cPaymForm = " + SQLUtil.toSQL(json.get("cPaymForm")) +
                                    ", sCltInfox = " + SQLUtil.toSQL(json.get("sCltInfox")) +
                                    ", sFinancex = " + SQLUtil.toSQL(json.get("sFinancex")) +
                                    ", sPrdctInf = " + SQLUtil.toSQL(json.get("sPrdctInf")) +
                                    ", sPaymInfo = " + SQLUtil.toSQL(json.get("sPaymInfo")) +
                                    ", sCltInfoF = " + SQLUtil.toSQL(json.get("sCltInfoF")) +
                                    ", sFinanceF = " + SQLUtil.toSQL(json.get("sFinanceF")) +
                                    ", sPrdctxxF = " + SQLUtil.toSQL(json.get("sPrdctxxF")) +
                                    ", sPaymInfF = " + SQLUtil.toSQL(json.get("sPaymInfF"));
                        
                        if ("".equals((String) json.get("dTargetxx"))){
                            sql += ", dTargetxx = NULL";
                        } else {
                            sql += ", dTargetxx = " + SQLUtil.toSQL(json.get("dTargetxx"));
                        }
                        
                        if ("".equals((String) json.get("dFollowUp"))){
                            sql += ", dFollowUp = NULL";
                        } else {
                            sql += ", dFollowUp = " + SQLUtil.toSQL(json.get("dFollowUp"));
                        }
                        
                        sql = sql +
                                    ", sRemarksx = " + SQLUtil.toSQL(json.get("sRemarksx")) +
                                    ", sReferdBy = " + SQLUtil.toSQL(json.get("sReferdBy")) +
                                    ", sRelatnID = " + SQLUtil.toSQL(json.get("sRelatnID")) +
                                    ", dCreatedx = " + SQLUtil.toSQL(json.get("dCreatedx")) +
                                    ", nLatitude = " + SQLUtil.toSQL(json.get("nLatitude")) +
                                    ", nLongitud = " + SQLUtil.toSQL(json.get("nLongitud")) +
                                    ", sClientID = " + SQLUtil.toSQL(json.get("sClientID")) +
                                    ", sTLMAgent = " + SQLUtil.toSQL(json.get("sTLMAgent")) +
                                    ", cTranStat = " + SQLUtil.toSQL(json.get("cTranStat")) +
                                    ", sModified = " + SQLUtil.toSQL(json.get("sModified")) +
                                    ", dModified = " + SQLUtil.toSQL(json.get("dModified")) +
                                    ", dTimeStmp = " + SQLUtil.toSQL(json.get("dTimeStmp"));
                    }
                    
                    System.out.println(sql);
                    if (instance.executeUpdate(sql) <= 0){
                        System.err.println(instance.getMessage() + instance.getErrMsg());
                        System.exit(1);
                    }
                }
            }
            
            System.out.println("Done. Thank you.");
            System.exit(0);
        } catch (IOException | ParseException | SQLException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
    
    public static HashMap getHeader(){
        String clientid = "GGC_BM001";
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
