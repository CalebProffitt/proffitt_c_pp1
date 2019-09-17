import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hash {
    /**
     * The Hash class gathers information from a file and stores that information in a hashmap
     * @author Caleb Proffitt
     * @version 1.0
     * Programming Project One
     * CS322 - Compiler Construction
     * Spring 2019
     * @return
     */
    public String fileProcessorIPv4() {
        /**
         * This method gathers the IP address information from a log file
         */
        Scanner input = new Scanner(System.in);
        System.out.println("Enter filename: ");
        String fileName = input.nextLine();

        BufferedReader br;
        String str;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((str = br.readLine()) != null) {

                String pattern = "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}";
                Pattern r = Pattern.compile(pattern);
                HashMap<String, Integer> iphash = new HashMap<String, Integer>();
                Matcher m = r.matcher(pattern);

                int occurrence = 0;
                while (m.find()) {
                    occurrence++;
                }
                iphash.put(pattern, occurrence);

                if (m.find()) {
                    iphash.put(pattern, occurrence);
                } else {
                    System.out.println("NO MATCH");
                }

                int IPv4HashSize = iphash.size();
                int lines = 0;
                while (br.readLine() != null) lines++;
                System.out.println("There are " + IPv4HashSize + " IP addresses");
                System.out.println(lines + " where parsed");


            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file");
        }
        return fileName;
    }

    public String fileProcessorUsername() {
        /**
         * This method gathers the username information from a log file
         */
        Scanner input = new Scanner(System.in);
        System.out.println("Enter filename: ");
        String fileName = input.nextLine();

        BufferedReader br;
        String str;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((str = br.readLine()) != null) {

                String pattern = "(?<=\\buser\\s)(\\w+)";
                Pattern r = Pattern.compile(pattern);
                HashMap<String, Integer> username = new HashMap<String, Integer>();
                Matcher m = r.matcher(pattern);

                int occurrence = 0;
                while (m.find()) {
                    occurrence++;
                }
                username.put(pattern, occurrence);

                if (m.find()) {
                    username.put(pattern, occurrence);
                } else {
                    System.out.println("NO MATCH");
                }

                int usernameSize = username.size();
                System.out.println(usernameSize);

            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        return fileName;
    }

    public static String IPv4Size(){
        /**
         * This method gets the size of the IP hashmap
         */
        return fileProcessorIPv4.iphash.size();
    }

    public static String UsernameSize(){
        /**
         * This method gets the size of the username hashmap
         */
        return fileProcessorUsername.username.size();
    }

    public static String FileTotalLines(){
        /**
         * This method gets the total number of lines from the log file
         */
        return fileProcessorIPv4.lines();
    }
}
