package patrik.smolicek.cinema;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SharedList {
    private static List<Customer> sharedList;
    public static void list(String filepath){
        sharedList=readed(filepath);
    }

    public static List<Customer> getList() {
        return sharedList;
    }

    public static void addList(Customer item) {
        sharedList.add(item);
    }

    public static void removeList(Customer item, String filepath) {
        sharedList.remove(item);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\javaprojekty\\filmy\\"+filepath+".txt"))) {
            for (Customer customer : sharedList) {
                writer.write(customer.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readed(String filepath){
        List<Customer> objectList = new ArrayList<>();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\javaprojekty\\filmy\\"+filepath+".txt",true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\javaprojekty\\filmy\\"+filepath+".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {

                Customer obj = StringToCustromer(line);
                objectList.add(obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectList;

    }
    public static Customer StringToCustromer(String c){
        String[] tempPole=c.split("\\|");
        return new Customer(Integer.parseInt(tempPole[0]),tempPole[1]);
    }
}
