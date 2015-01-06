import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/*
Created by: Cade Ayres
Date: 05/Jan/2015
*/

public class UseCode {
    
    static void UsePost(String id, String CommandType, String command) throws MalformedURLException, IOException {
        
        String GetID = Window.getid();
        String Com = Window.getcommand();
        
        System.out.println(GetID+" "+Com);
        
    URL url;
    URLConnection urlConn;
    DataOutputStream printout;
    DataInputStream     input;
    url = new URL ("http://example.com/ExamplePHP.php");
    urlConn = url.openConnection();
    urlConn.setDoInput (true);
    urlConn.setDoOutput (true);
    urlConn.setUseCaches (false);
    urlConn.setRequestProperty
    ("Content-Type", "application/x-www-form-urlencoded");
    printout = new DataOutputStream (urlConn.getOutputStream ());
    String content =
    "id=" + URLEncoder.encode (GetID) +
    "&command=" + URLEncoder.encode (Com);
    printout.writeBytes (content);
    printout.flush ();
    printout.close ();
    
    input = new DataInputStream (urlConn.getInputStream ());
    String str;
    while (null != ((str = input.readLine())))
    {
    System.out.println (str);
    }
    input.close ();
    
    }

}
