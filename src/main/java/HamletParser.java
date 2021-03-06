import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){

        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){

        return hamletData;
    }

    public String changeHamletToLeon(String ham){
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(ham);
        return matcher.replaceAll("Leon");
    }

    public String changeHoratioToTariq(String hor){
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(hor);
        return matcher.replaceAll("Tariq");
    }

    public Boolean findHoratio(String hor){
        Pattern pattern = Pattern.compile("Horatio");
        return pattern.matcher(hor).find();
    }

    public Boolean findHamlet(String ham){
        Pattern pattern = Pattern.compile("Hamlet");
        return pattern.matcher(ham).find();
    }



}
