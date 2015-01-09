
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 *
 * @author Cade
 */
public class LoginHandler {
    
    public static String ConnectionID = "0";
    
    public static boolean CanLogin(String user, String pass) throws MalformedURLException, IOException {
        
        URL url;
        URLConnection urlConn;
        DataOutputStream printout;
        url = new URL ("http://example.com/ExPHP.php");
        urlConn = url.openConnection();
        urlConn.setDoInput (true);
        urlConn.setDoOutput (true);
        urlConn.setUseCaches (false);
        urlConn.setRequestProperty
        ("Content-Type", "application/x-www-form-urlencoded");
        printout = new DataOutputStream (urlConn.getOutputStream ());
        String content =
        "User=" + URLEncoder.encode (user) +
        "&Pass=" + URLEncoder.encode (pass);
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
        
        if (!"".equals(res) && !" ".equals(res)) {
            new Commands().setVisible(true);
            ConnectionID = res;
        }
        
        
        return true;
    }
    
}
