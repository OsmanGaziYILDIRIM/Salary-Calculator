import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ReadFromFile readFromFile1=new ReadFromFile();
        String[] personelList=readFromFile1.readFile(args[0]);
        ReadFromFile readFromFile2=new ReadFromFile();
        String[] monitoringList=readFromFile2.readFile(args[1]);
        CalculateSalary calculateSalary=new CalculateSalary();
        calculateSalary.WriteFile(personelList,monitoringList);
    }
}
