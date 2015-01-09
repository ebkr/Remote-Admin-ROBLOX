
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/*
Created by: Cade Ayres
Date: 9/Jan/2015
*/

public class CommandHandler {
    
    public static void SendToPHP(String comt, String command) throws MalformedURLException, IOException {
    
        URL url;
        URLConnection urlConn;
        DataOutputStream printout;
        url = new URL ("http://example.org/AnotherExPHP.php");
        urlConn = url.openConnection();
        urlConn.setDoInput (true);
        urlConn.setDoOutput (true);
        urlConn.setUseCaches (false);
        urlConn.setRequestProperty
        ("Content-Type", "application/x-www-form-urlencoded");
        printout = new DataOutputStream (urlConn.getOutputStream ());
        String content =
        "id=" + URLEncoder.encode (LoginHandler.ConnectionID, "UTF-8") +
        "&comtype=" + URLEncoder.encode (comt, "UTF-8") +
        "&command=" + URLEncoder.encode(command, "UTF-8");
        printout.writeBytes (content);
        printout.flush ();
        
        BufferedReader rd = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
        String line = "", res = "";
        while ((line = rd.readLine()) != null) {
          res += line;
        }
        
        res = res.replaceAll("\\<[^>]*>","");
        
        printout.flush ();
        printout.close ();
        System.out.println(res);
        
    }
    
}
