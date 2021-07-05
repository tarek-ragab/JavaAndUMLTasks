package Day2_Ex1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("Day2_Ex1.txt"));
        String data=null;
        do {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader sbr = new BufferedReader(isr);
            System.out.println("Enter data : ");
            data = sbr.readLine();
            bw.append(data);
            bw.append(",");
            System.out.println("The data is : " + data);

        }while (!data.equalsIgnoreCase("stop"));
        bw.close();
        BufferedReader br = new BufferedReader(new FileReader("Day2_Ex1.txt"));
        String line = br.readLine();
        System.out.println(line);
        br.close();
    }
}
