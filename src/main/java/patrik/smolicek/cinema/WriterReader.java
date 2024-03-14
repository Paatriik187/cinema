package patrik.smolicek.cinema;

import java.io.*;

public class WriterReader {

    public static void write (String a, String path) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\javaprojekty\\filmy\\"+path+".txt", true));
            BufferedReader reader = new BufferedReader(new FileReader("C:\\javaprojekty\\filmy\\"+path+".txt"));
            if(reader.readLine()==null){
                writer.write(a);
            }
            else{
                writer.write("\n"+a);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

