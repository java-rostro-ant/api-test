package org.rmj.api.test.notifications;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rmj.api.test.login.WebClient;
import org.rmj.appdriver.SQLUtil;
import org.rmj.appdriver.agent.GRiderX;

public class send_notification_system {
    public static void main(String [] args){
        String path;
        if(System.getProperty("os.name").toLowerCase().contains("win")){
            path = "D:/GGC_Java_Systems";
        }
        else{
            path = "/srv/GGC_Java_Systems";
        }
        System.setProperty("sys.default.path.config", path);
        
        GRiderX instance = new GRiderX("gRider");
        
        if (!instance.logUser("gRider", "M001111122")){
            System.err.println(instance.getMessage() + instance.getErrMsg());
            System.exit(1);
        }
        
        String lsSQL = " SELECT a.sProdctID, a.sUserIDxx" +
                        " FROM App_User_Master a" +
                                ", Employee_Master001 b" +
                        " WHERE a.sEmployNo = b.sEmployID" +
                                " AND a.sProdctID = 'gRider'" +
                                " AND a.sUserIDxx = 'GAP023000374'";
        
        ResultSet loRS = instance.executeQuery(lsSQL);
        
        try {
            JSONArray rcpts = new JSONArray();
            JSONObject rcpt;
            while (loRS.next()){
                rcpt = new JSONObject();
                rcpt.put("app", loRS.getString("sProdctID"));
                rcpt.put("user",loRS.getString("sUserIDxx"));
                rcpts.add(rcpt);
            }
            
            SendRegularSystemNotification(rcpts, 
                                         "Guanzon Circle Update", 
                                                "KAY gandang araw!\n" +
                                                "\n" +
                                                "Maaari niyo ng i-download ang pinakabagong version ng Guanzon Circle sa google play. I-uninstall lamang ang inyong gamit na app ngayon, magpunta sa Google Play Store, hanapin ang Guanzon Circle at idownload para makuha ang mga bagong update ng ating app. Narito ang ilan sa mga pagbabago:\n" +
                                                "\n" +
                                                "1. Benta (Product Inquiry)\n" +
                                                "2. Viewing of Terms and Conditions\n" +
                                                "3. Downloading and viewing of Payslip\n" +
                                                "4. Fix on data retention for payroll applications\n" +
                                                "\n" +
                                                "Guanzon Circle v3.17.058.071 s\n" +
                                                "\n" +
                                                "Maraming salamat po!");
        } catch (SQLException e) {
            System.err.println();
            System.exit(1);
        }
     
//        SendSystemPanaloRaffleNotification("GuanzonApp", 
//                                    "GAP023000374", 
//                                    "Raffle Promo!", 
//                                    "Nanalo ka ng raffle entry para sa iyong pagbili ng motor noong Oct. 1, 2023. Ref no. 123456", 
//                                    0);
    }
    
    public static boolean SendRegularSystemNotification(String app,
                                                        String userid,
                                                        String title,
                                                        String message){
        try{
            String sURL = "https://restgk.guanzongroup.com.ph/notification/send_request_system.php";
            Calendar calendar = Calendar.getInstance();
            //Create the header section needed by the API
            Map<String, String> headers =
                    new HashMap<String, String>();
            headers.put("Accept", "application/json");
            headers.put("Content-Type", "application/json");
            headers.put("g-api-id", "IntegSys");
            headers.put("g-api-imei", "356060072281722");
            headers.put("g-api-key", SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss"));
            headers.put("g-api-hash", org.apache.commons.codec.digest.DigestUtils.md5Hex((String)headers.get("g-api-imei") + (String)headers.get("g-api-key")));
            headers.put("g-api-user", "GAP0190001");
            headers.put("g-api-mobile", "09171870011");
            headers.put("g-api-token", "cPYKpB-pPYM:APA91bE82C4lKZduL9B2WA1Ygd0znWEUl9rM7pflSlpYLQJq4Nl9l5W4tWinyy5RCLNTSs3bX3JjOVhYnmCpe7zM98cENXt5tIHwW_2P8Q3BXI7gYtEMTJN5JxirOjNTzxWHkWDEafza");

            JSONArray rcpts = new JSONArray();
            JSONObject rcpt = new JSONObject();
            rcpt.put("app", app);
            rcpt.put("user", userid);
            rcpts.add(rcpt);

            JSONObject param = new JSONObject();
            param.put("type", "00000");
            param.put("parent", null);
            param.put("title", title);
            param.put("message", message);
            param.put("rcpt", rcpts);
            param.put("infox", null);

            String response = WebClient.sendHTTP(sURL, param.toJSONString(), (HashMap<String, String>) headers);
            if(response == null){
                System.out.println("HTTP Error detected: " + System.getProperty("store.error.info"));
                System.exit(1);
            }

            System.out.println(response);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean SendRegularSystemNotification(JSONArray rcpts,
                                                        String title,
                                                        String message){
        try{
            String sURL = "https://restgk.guanzongroup.com.ph/notification/send_request_system.php";
            Calendar calendar = Calendar.getInstance();
            //Create the header section needed by the API
            Map<String, String> headers =
                    new HashMap<String, String>();
            headers.put("Accept", "application/json");
            headers.put("Content-Type", "application/json");
            headers.put("g-api-id", "IntegSys");
            headers.put("g-api-imei", "356060072281722");
            headers.put("g-api-key", SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss"));
            headers.put("g-api-hash", org.apache.commons.codec.digest.DigestUtils.md5Hex((String)headers.get("g-api-imei") + (String)headers.get("g-api-key")));
            headers.put("g-api-user", "GAP0190001");
            headers.put("g-api-mobile", "09171870011");
            headers.put("g-api-token", "cPYKpB-pPYM:APA91bE82C4lKZduL9B2WA1Ygd0znWEUl9rM7pflSlpYLQJq4Nl9l5W4tWinyy5RCLNTSs3bX3JjOVhYnmCpe7zM98cENXt5tIHwW_2P8Q3BXI7gYtEMTJN5JxirOjNTzxWHkWDEafza");

            JSONObject param = new JSONObject();
            param.put("type", "00000");
            param.put("parent", null);
            param.put("title", title);
            param.put("message", message);
            param.put("rcpt", rcpts);
            param.put("infox", null);

            String response = WebClient.sendHTTP(sURL, param.toJSONString(), (HashMap<String, String>) headers);
            if(response == null){
                System.out.println("HTTP Error detected: " + System.getProperty("store.error.info"));
                System.exit(1);
            }

            System.out.println(response);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     *
     * @param app set recipient product id
     * @param userid set recipient user id
     * @param title notification title
     * @param message notification message
     * type of Panalo notification 0 = raffle, 1 = reward, 2 = claim, 3 = redeemed, 4 = warning
     * @param status status of panalo raffle 0 = No Status, 1 = Starting Soon, 2 = Started, 3 = Ended
     * @return returns true if process has been successfully executed.
     */
    private static boolean SendSystemPanaloRaffleNotification(String app,
                                                       String userid,
                                                       String title,
                                                       String message,
                                                       int status){
        try{
            String sURL = "https://restgk.guanzongroup.com.ph/notification/send_request_system.php";
            Calendar calendar = Calendar.getInstance();
            //Create the header section needed by the API
            Map<String, String> headers =
                    new HashMap<String, String>();
            headers.put("Accept", "application/json");
            headers.put("Content-Type", "application/json");
            headers.put("g-api-id", "IntegSys");
            headers.put("g-api-imei", "356060072281722");
            headers.put("g-api-key", SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss"));
            headers.put("g-api-hash", org.apache.commons.codec.digest.DigestUtils.md5Hex((String)headers.get("g-api-imei") + (String)headers.get("g-api-key")));
            headers.put("g-api-user", "GAP0190001");
            headers.put("g-api-mobile", "09171870011");
            headers.put("g-api-token", "cPYKpB-pPYM:APA91bE82C4lKZduL9B2WA1Ygd0znWEUl9rM7pflSlpYLQJq4Nl9l5W4tWinyy5RCLNTSs3bX3JjOVhYnmCpe7zM98cENXt5tIHwW_2P8Q3BXI7gYtEMTJN5JxirOjNTzxWHkWDEafza");

            JSONArray rcpts = new JSONArray();
            JSONObject rcpt = new JSONObject();
            rcpt.put("app", app);
            rcpt.put("user", userid);
            rcpts.add(rcpt);

            JSONObject loInfo = new JSONObject();
            loInfo.put("module", "002");
            loInfo.put("panalo", "0");

            JSONObject loData = new JSONObject();
            loData.put("status", status);

            loInfo.put("data", loData);

            String lsInfoxx = loInfo.toJSONString();

            JSONObject param = new JSONObject();
            param.put("type", "00000");
            param.put("parent", null);
            param.put("title", title);
            param.put("message", message);
            param.put("rcpt", rcpts);
            param.put("infox", lsInfoxx);

            String response = WebClient.sendHTTP(sURL, param.toJSONString(), (HashMap<String, String>) headers);
            if(response == null){
                System.out.println("HTTP Error detected: " + System.getProperty("store.error.info"));
                System.exit(1);
            }

            System.out.println(response);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     *
     * @param app set recipient product id
     * @param userid set recipient user id
     * @param title notification title
     * @param message notification message
     * @return returns true if process has been successfully executed.
     */
    public static boolean SendSystemPanaloRewardNotification(String app,
                                                             String userid,
                                                             String title,
                                                             String message){
        try{
            String sURL = "https://restgk.guanzongroup.com.ph/notification/send_request_system.php";
            Calendar calendar = Calendar.getInstance();
            //Create the header section needed by the API
            Map<String, String> headers =
                    new HashMap<String, String>();
            headers.put("Accept", "application/json");
            headers.put("Content-Type", "application/json");
            headers.put("g-api-id", "IntegSys");
            headers.put("g-api-imei", "356060072281722");
            headers.put("g-api-key", SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss"));
            headers.put("g-api-hash", org.apache.commons.codec.digest.DigestUtils.md5Hex((String)headers.get("g-api-imei") + (String)headers.get("g-api-key")));
            headers.put("g-api-user", "GAP0190001");
            headers.put("g-api-mobile", "09171870011");
            headers.put("g-api-token", "cPYKpB-pPYM:APA91bE82C4lKZduL9B2WA1Ygd0znWEUl9rM7pflSlpYLQJq4Nl9l5W4tWinyy5RCLNTSs3bX3JjOVhYnmCpe7zM98cENXt5tIHwW_2P8Q3BXI7gYtEMTJN5JxirOjNTzxWHkWDEafza");

            JSONArray rcpts = new JSONArray();
            JSONObject rcpt = new JSONObject();
            rcpt.put("app", app);
            rcpt.put("user", userid);
            rcpts.add(rcpt);

            JSONObject loInfo = new JSONObject();
            loInfo.put("module", "001");
            loInfo.put("panalo", "1");

            JSONObject loData = new JSONObject();
            loData.put("sReferNox", "MX01123456789");
            loData.put("cTranStat", "0");

            loInfo.put("data", loData);

            String lsInfoxx = loInfo.toJSONString();

            JSONObject param = new JSONObject();
            param.put("type", "00008");
            param.put("parent", null);
            param.put("title", title);
            param.put("message", message);
            param.put("rcpt", rcpts);
            param.put("infox", lsInfoxx);

            String response = WebClient.sendHTTP(sURL, param.toJSONString(), (HashMap<String, String>) headers);
            if(response == null){
                System.out.println("HTTP Error detected: " + System.getProperty("store.error.info"));
                System.exit(1);
            }

            System.out.println(response);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
