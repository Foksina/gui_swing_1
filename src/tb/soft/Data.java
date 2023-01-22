package tb.soft;

import java.io.*;
import java.util.*;

public class Data{
    public Map<String, char[]> userData = new HashMap<String, char[]>();
    public Data() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("Data.txt")));
        String line = br.readLine();
        while(line!= null){
            String[] txt = line.split("#");
            char[] actualCharArray = txt[1].toCharArray();
            userData.put(txt[0],actualCharArray);
            line = br.readLine();
        }
    }

    public Map<String, char[]> userData() {
        return userData;
    }
}