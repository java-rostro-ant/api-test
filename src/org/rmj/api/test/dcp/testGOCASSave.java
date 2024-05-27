package org.rmj.api.test.dcp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.rmj.api.test.login.WebClient;

public class testGOCASSave {
    public static void main(String[] args) {
        String sURL = "http://192.168.10.140/integsys/gocas/gocas_save.php";
        
        Map<String, String> headers = APIParam.getHeader1();
        
        String lsSQL = "{\"sClientNm\":\"Cariño, Michael Cuison\",\"sBranchCd\":\"M015\",\"comaker_info\":{\"sFrstName\":\"edwin\",\"sReltnCde\":\"1\",\"sNickName\":\"\",\"sSuffixNm\":\"\",\"dBirthDte\":\"1960-05-28\",\"cIncmeSrc\":\"1\",\"residence_info\":{\"present_address\":{\"sBrgyIDxx\":\"1105678\",\"sAddress1\":\"\",\"sLandMark\":\"\",\"sAddress2\":\"\",\"sTownIDxx\":\"0383\",\"sHouseNox\":\"6\"},\"cHouseTyp\":\"\",\"sCtkReltn\":\"\",\"cOwnershp\":\"\",\"cGaragexx\":\"\",\"permanent_address\":{\"sBrgyIDxx\":\"\",\"sAddress1\":\"\",\"sLandMark\":\"\",\"sAddress2\":\"\",\"sTownIDxx\":\"\",\"sHouseNox\":\"\"}},\"sFBAcctxx\":\"\",\"sMiddName\":\"pinlac\",\"sLastName\":\"briones\",\"mobile_number\":[{\"cPostPaid\":\"0\",\"sMobileNo\":\"09973714586\",\"nPostYear\":0}],\"sBirthPlc\":\"0383\"},\"dCreatedx\":\"2021-04-22\",\"other_info\":{\"sUnitUser\":\"0\",\"sUnitPayr\":\"0\",\"sSrceInfo\":\"Friends\",\"sPurposex\":\"1\",\"personal_reference\":[{\"sRefrMPNx\":\"09261495523\",\"sRefrTown\":\"0383\",\"sRefrNmex\":\"katrin Gonzales \",\"sRefrAddx\":\"pinget\"},{\"sRefrMPNx\":\"09670081777\",\"sRefrTown\":\"0383\",\"sRefrNmex\":\"mac labador\",\"sRefrAddx\":\"Cabinet Hill \"},{\"sRefrMPNx\":\"09556084360\",\"sRefrTown\":\"0383\",\"sRefrNmex\":\"armac gapasin \",\"sRefrAddx\":\"san Vicente \"}]},\"cUnitAppl\":\"0\",\"residence_info\":{\"present_address\":{\"sBrgyIDxx\":\"1105678\",\"sAddress1\":\"\",\"sLandMark\":\"\",\"sAddress2\":\"\",\"sTownIDxx\":\"0383\",\"sHouseNox\":\"6\"},\"cHouseTyp\":\"0\",\"sCtkReltn\":\"\",\"cOwnershp\":\"0\",\"cGaragexx\":\"1\",\"permanent_address\":{\"sBrgyIDxx\":\"1105678\",\"sAddress1\":\"\",\"sLandMark\":\"\",\"sAddress2\":\"\",\"sTownIDxx\":\"0383\",\"sHouseNox\":\"6\"}},\"applicant_info\":{\"cGenderCd\":\"0\",\"sNickName\":\"\",\"cCvilStat\":\"0\",\"sVibeAcct\":\"\",\"facebook\":{\"nYearxxxx\":0,\"sFBAcctxx\":\"\",\"cAcctStat\":\"\",\"nNoFriend\":0},\"dBirthDte\":\"1984-04-11\",\"sMiddName\":\"De Mesa\",\"sLastName\":\"Cariño\",\"sBirthPlc\":\"0383\",\"sCitizenx\":\"01\",\"sFrstName\":\"Michael\",\"email_address\":[{\"sEmailAdd\":\"brionesmartyll@gmail.com\"}],\"sSuffixNm\":\"\",\"sMaidenNm\":\"Cuison\",\"landline\":[{\"sPhoneNox\":\"\"}],\"mobile_number\":[{\"cPostPaid\":\"0\",\"sMobileNo\":\"09614908244\",\"nPostYear\":0}]},\"means_info\":{\"other_income\":{\"nOthrIncm\":\"\",\"sOthrIncm\":\"\"},\"pensioner\":{\"nRetrYear\":0,\"nPensionx\":0.0,\"cPenTypex\":\"\"},\"cIncmeSrc\":\"0\",\"self_employed\":{\"cBusTypex\":\"1\",\"sIndstBus\":\"Business Services\",\"cOwnSizex\":\"1\",\"nBusLenxx\":2.0,\"nBusIncom\":10000,\"nMonExpns\":1000,\"sBusTownx\":\"0383\",\"sBusiness\":\"Labada Republic\",\"sBusAddrx\":\"Cabinet Hill \"},\"employed\":{\"sIndstWrk\":\"\",\"cEmpSectr\":\"\",\"nSalaryxx\":0.0,\"sEmployer\":\"\",\"sPosition\":\"\",\"sWrkAddrx\":\"\",\"cEmpStatx\":\"\",\"nLenServc\":0.0,\"sFunction\":\"\",\"sWrkTownx\":\"\",\"sWrkTelno\":\"\"},\"financed\":{\"sReltnCde\":\"\",\"nEstIncme\":0.0,\"sFinancer\":\"\",\"sMobileNo\":\"\",\"sFBAcctxx\":\"\",\"sNatnCode\":\"\",\"sEmailAdd\":\"\"}},\"disbursement_info\":{\"credit_card\":{\"nCrdLimit\":0.0,\"nSinceYrx\":0,\"sBankName\":\"\"},\"monthly_expenses\":{\"nElctrcBl\":600.0,\"nFoodAllw\":2000.0,\"nLoanAmtx\":0.0,\"nWaterBil\":500.0},\"dependent_info\":{\"nHouseHld\":0,\"children\":[]},\"properties\":{\"cWith4Whl\":\"0\",\"cWithRefx\":\"1\",\"cWithTVxx\":\"1\",\"sProprty1\":\"\",\"sProprty2\":\"\",\"cWith2Whl\":\"0\",\"sProprty3\":\"\",\"cWith3Whl\":\"0\",\"cWithACxx\":\"0\"},\"bank_account\":{\"sAcctType\":\"0\",\"sBankName\":\"\"}},\"sModelIDx\":\"M00119014\",\"nMonAmort\":4770.0,\"nDownPaym\":7000.0,\"nAcctTerm\":24,\"dTargetDt\":\"\",\"dAppliedx\":\"2021-04-22\",\"cApplType\":\"0\",\"sUnitAppl\":\"HONDA\"}";

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
