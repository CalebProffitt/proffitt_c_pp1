public class App {
    /**
     * The app class uses the Hash file to gather information from a file
     * @author Caleb Proffitt
     * @version 1.0
     * Programming Project One
     * CS322 - Compiler Construction
     * Spring 2019
     */

    public static void main(String args[]){
        /**
         * This method asks the user what information they want then uses the Hash class to generate that information and return it to the user
         */
        Hash testHash = new Hash();

        args[0] = Hash.FileTotalLines() + " lines in the log file were parsed.\n" +
                    "There are " + Hash.IPv4Size() + " unique IP addresses in the log.\n" +
                    "There are " + Hash.UsernameSize() + " unique users in the log.";

        args[1] = testHash.fileProcessorIPv4();
                  System.out.println(Hash.FileTotalLines() + " lines in the log file were parsed.\n" +
                    "There are " + Hash.IPv4Size() + " unique IP addresses in the log.\n" +
                    "There are " + Hash.UsernameSize() + " unique users in the log.");
        args[2] = testHash.fileProcessorUsername();
                  System.out.println(Hash.FileTotalLines() + " lines in the log file were parsed.\n" +
                    "There are " + Hash.IPv4Size() + " unique IP addresses in the log.\n" +
                    "There are " + Hash.UsernameSize() + " unique users in the log.");
    }
}

