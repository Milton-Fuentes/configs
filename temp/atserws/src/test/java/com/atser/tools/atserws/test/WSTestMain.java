/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.test;

import com.atser.tools.atserutil.crypt.CryptSupport;
import com.atser.tools.atserutil.enumerator.parser.eUserInformation;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.globuser.GlobUserPluginDirector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.poi.openxml4j.util.ZipSecureFile;

/**
 *
 * @author droldan
 */
public class WSTestMain {

    /* Dont delete it*/
    public static void generateUserPwd(String pwd) {
        String salt = UUID.randomUUID().toString();
        System.out.println("SALT: " + salt);
        System.out.println("PWD : " + CryptSupport.cryptHMACSHA256(pwd, salt));
        System.out.println("BASE64: " + Base64.getEncoder().encodeToString(pwd.getBytes()));

    }

    public static void parseFromList(String filter) {
        String[] operatorList = new String[]{"!=", "!%=", "%=", ":=", ">=", "<=", ">", "<", "="};
        for (String operator : operatorList) {
            if (filter.contains(operator)) {
                String[] split = filter.split(operator);
                System.out.println(split.length);
                System.out.println(operator);
                System.out.println(split[0] + operator + split[1]);
                break;
            }
        }
    }

    public static void validateXmlBomb() {
        GlobUserPluginDirector director;
        try {
            ZipSecureFile.setMinInflateRatio(0);
            //ZipSecureFile.setMaxEntrySize(302400);
            ZipSecureFile.setMaxTextSize(255);
            director = new GlobUserPluginDirector(new File("C:\\Users\\droldan\\Videos\\XmlBomb\\bomb.xlsx"), eUserInformation.valueOf("MassDOTUserInformationTpl"));
            System.out.println("Size: " + director.getUserInformationModel().size());
        } catch (FormatDocumentNotAllowedException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundMimeTypeException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateDifferentException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExcelParsingException ex) {
            System.out.println("ExcelParsingException");
            //Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("IOException");
            //Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmptyDocumentException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void generateOutUserPwd() {
        // Actual HCTRA Test
        //generateUserPwd("HCT3@Xkj*0QRt99nh.");
        // HCTRA Prod
        //generateUserPwd("KxH3kuqt@83jsyJ*Q3.");
        //generateUserPwd("TYE73gap289*34KjaQ3.");
        // Batch
        //generateUserPwd("ETY4.34fFGHWT*34WER5.");
        // MASSDOT TEST API
        //generateUserPwd("TYE73gap289*34KjaQ3.");
        // CME
        //generateUserPwd("Atser2018UTJ.1KDJ");
        // Testing
        generateUserPwd("atser2018");
        // MASSDOT DEV BATCH
        //generateUserPwd("atser2018");
        // MASSDOT GATEWAY API
        generateUserPwd("J372Hdkw42YTw23EdkQ3KTemm");
    }

    public static void sortListOfMap() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap();
        map1.put("test_id", "5789");
        map1.put("test_name", "Soil Atterberg Limits");
        map1.put("woNo", "001");
        list.add(map1);
        Map<String, String> map2 = new HashMap();
        map2.put("test_id", "5790");
        map2.put("test_name", "Concrete Sieve Analysis");
        map2.put("woNo", "002");
        list.add(map2);
        Map<String, String> map3 = new HashMap();
        map3.put("test_id", "5791");
        map3.put("test_name", "Soil Atterberg Limits");
        map3.put("woNo", "003");
        list.add(map3);
        Map<String, String> map4 = new HashMap();
        map4.put("test_id", "5792");
        map4.put("test_name", "Concrete Compressive Strength");
        map4.put("woNo", "004");
        list.add(map4);
        Map<String, String> map5 = new HashMap();
        map5.put("test_id", "5793");
        map5.put("test_name", "Concrete Sieve Analysis");
        map5.put("woNo", "005");
        list.add(map5);

        list.sort(Comparator.comparing(m -> m.get("test_name"), Comparator.nullsLast(Comparator.naturalOrder())));

        list.forEach(System.out::println);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //generateOutUserPwd();
        //testExcelParser();
        // "!=", "!%=", "%=", ":=", "=", ">", "<", ">=", "<="
        //parseEmailList("   droldan@atser.com   , pepe@asetr.com;   rock@gmail.com   ");
        /*Consumer<Integer> display = f -> System.out.println(f);
            
            display.accept(10);
            
            Consumer<List<Integer>> modify = list -> {
            for (int i = 0; i < list.size(); i++) {
            list.set(i, 2 * list.get(i));
            }
            };
            
            // Consumer to display a list of numbers
            Consumer<List<Integer>> dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));
            
            List<Integer> list = new ArrayList<>();
            list.add(2);
            list.add(1);
            list.add(3);
            
            // Implement modify using accept()
            modify.accept(list);
            
            // Implement dispList using accept()
            dispList.accept(list);*/
 /*UriInfo pUriInfo = new ResteasyUriInfo("", "&f=clientId%=3&f=name%=Dayron&f=edad%=4", "");
            MultivaluedMap<String, String> queryParams = pUriInfo.getQueryParameters();
            List<String> paramLength = queryParams.get("f");
            Map<String, String> search = new HashMap();
            paramLength.stream().map((string) -> string.split("%=")).filter((split) -> (split.length == 2)).forEachOrdered((split) -> {
            search.put(split[0], split[1]);
            });
            
            search.forEach((k, v) -> System.out.println(k + ": " + v));*/
        //validateXmlBomb();
        /*try {
            System.out.println(DateSupport.formatDate(DateSupport.addChronoUnitToDate(DateSupport.parseString("07/23/2020", DateSupport.FORMAT_US), ChronoUnit.DAYS, 1L), DateSupport.FORMAT_US) + " " + "10:15");
        } catch (ParseException ex) {
            Logger.getLogger(WSTestMain.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        /*BigDecimal c = new BigDecimal(100000);
        BigDecimal d = new BigDecimal(50000);
        BigDecimal e = new BigDecimal(110000);
        BigDecimal g = new BigDecimal(60000);
        BigDecimal h = new BigDecimal(70000);

        CostMgmtKeyPerformanceIndicatorsBO rs = new CostMgmtKeyPerformanceIndicatorsBO();
        rs.setSchedulePerformanceIndex(NumberSupport.calcBigDecimal(g, d, "/"));
        rs.setScheduleVariance(NumberSupport.calcBigDecimal(g, d, "-"));
        rs.setCostPerformanceIndex(NumberSupport.calcBigDecimal(g, h, "/"));
        rs.setCostVariance(NumberSupport.calcBigDecimal(g, h, "-"));
        rs.setVarianceAtCompletion(NumberSupport.calcBigDecimal(c, e, "-"));
        System.out.println(rs);*/
        
        String c1 = "test<img src=x onerror=alert(document.domain)>.jpg";
        String c2 = "Abc > 5\" < 8 . & apasp = 10" ;
        String e2 = "Abc &gt; 5\" &lt; 8 . &amp; apasp = 10" ;
        
        System.out.println(StringEscapeUtils.escapeHtml(c1));
        System.out.println(StringEscapeUtils.unescapeHtml("test&lt;img src=x onerror=alert(document.domain)&gt;.jpg"));
        
        //String result =  "test&lt;img src=x onerror=alert(document.domain)&gt;.jpg";
        //System.out.println(StringEscapeUtils.escapeHtml4(result));              
                        

    }
}
