import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.File; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.net.MalformedURLException; 
import java.net.URL; 
import java.net.URLConnection; 
import java.net.Proxy; 
import java.net.InetSocketAddress; 

/**
* Without mentionning the point parameter
*/
public class NoaWaveWatchIIISample { 
        public static void main(String[] args) { 

                URL url; 

                try { 

                        //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("some_ip_adress_or_dns_sovable_host_name_here", 80)); 

                        // get URL content 
                        // Planet OS sample data access example 
                        url = new URL("http://api.planetos.com/v1/datasets/noaa_ww3_global_1.25x1d?apikey=YOUR_API_KEY_HERE"); 
                        URLConnection conn = url.openConnection(/*proxy*/); 


                        // open the stream and put it into BufferedReader 
                        BufferedReader br = new BufferedReader( 
                               new InputStreamReader(conn.getInputStream())); 

                        String inputLine; 

                        //save to this filename 
                        String fileName = "./content_noawaveiii_no_point.json"; 
                        File file = new File(fileName); 

                        if (!file.exists()) { 
                                file.createNewFile(); 
                        } 

                        //use FileWriter to write file 
                        FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
                        BufferedWriter bw = new BufferedWriter(fw); 

                        while ((inputLine = br.readLine()) != null) { 
                                bw.write(inputLine); 
                        } 

                        bw.close(); 
                        br.close(); 

                        System.out.println("Done"); 

                } catch (MalformedURLException e) { 
                        e.printStackTrace(); 
                } catch (IOException e) { 
                        e.printStackTrace(); 
                } 

        } 
}