import java.io.*;

public class CSVReader {

    public static void main(String[] args) throws IOException {

        final String csvFile = "country.csv";

        File file = new File(csvFile);
        if (!file.exists()){
            file.createNewFile();
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = "";

        String csvSplitBy = ",";

        try{
            while ((line = reader.readLine())!=null){
                String [] country =line.split(csvSplitBy);
                System.out.println("Country [ code = "+country[4]+" , name "+country[5]+" ]");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
