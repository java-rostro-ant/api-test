package org.rmj.api.test.desktop;

import org.rmj.appdriver.MySQLAESCrypt;

public class testMySQLAES {
    public static void main(String[] args) {
        String lsSQL = "MCSO;M00123000001;GAP023000001;2023-05-06 14:27:00";
        System.out.print(MySQLAESCrypt.Encrypt(lsSQL, "20190625"));
        
        
    }
}
