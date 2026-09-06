import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer> myScores = readScores("scores.txt");

        // Step 2: calculate statistics
        double avg = calculateAverage(myScores);

        // Step 5: find highest and lowest
        int highest = Integer.MIN_VALUE; // start really small
        int lowest = Integer.MAX_VALUE;  // start really big

        if (myScores.size() == 0) {
            highest = 0;
            lowest = 0;
        } else {
            // standard loop through the list
            for (int i = 0; i < myScores.size(); i++) {
                int currentScore = myScores.get(i);
                
                if (currentScore > highest) {
                    highest = currentScore;
                }
                if (currentScore < lowest) {
                    lowest = currentScore;
                }
            }
        }

        // Step 3: write and print report
        writeReport(myScores, avg, highest, lowest, "report.txt");
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        try {
            FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr);
            
            String line = reader.readLine();

            while (line != null) {
                line = line.trim();
                
                // check if the line is not empty
                if (line.isEmpty() == false) {
                    try {
                        int num = Integer.parseInt(line);
                        list.add(num);
                    } catch (NumberFormatException e) {
                        System.out.println("Warning: Invalid line skipped - \"" + line + "\"");
                    }
                }
                
                // read the next line for the loop
                line = reader.readLine();
            }
            
            // close the reader when done
            reader.close();
            
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        return list;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.size() == 0) {
            return 0.0;
        }

        double total = 0.0;
        
        // loop to add up all scores
        for (int i = 0; i < scores.size(); i++) {
            total = total + scores.get(i);
        }

        double average = total / scores.size();
        return average;
    }

    // wwrites and prints the report
    public static void writeReport(ArrayList<Integer> scores, double avg, int high, int low, String outputFile) {
        // Step 6: Count the Grade Bands
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int i = 0; i < scores.size(); i++) {
            int s = scores.get(i);
            
            // new coders usually spell out both sides of the condition just to be safe
            if (s >= 90) {
                countA = countA + 1;
            } else if (s >= 80 && s < 90) {
                countB = countB + 1;
            } else if (s >= 70 && s < 80) {
                countC = countC + 1;
            } else if (s >= 60 && s < 70) {
                countD = countD + 1;
            } else {
                countF = countF + 1;
            }
        }

        // Formatting strings step by step
        String title = "\n=== Grade Analysis Report ===\n";
        String totalLine = "Total scores processed: " + scores.size() + "\n\n";
        
        String avgLine = String.format("Average score: %.2f%n", avg);
        String highLine = String.format("Highest score: %d%n", high);
        String lowLine = String.format("Lowest score:  %d%n\n", low);
        
        String gradesTitle = "Grade distribution:\n";
        String aLine = String.format("  A (90-100):   %d%n", countA);
        String bLine = String.format("  B (80-89):    %d%n", countB);
        String cLine = String.format("  C (70-79):    %d%n", countC);
        String dLine = String.format("  D (60-69):    %d%n", countD);
        String fLine = String.format("  F (below 60): %d%n", countF);

        // Print to terminal one by one
        System.out.print(title);
        System.out.print(totalLine);
        
        if (scores.size() > 0) {
            System.out.print(avgLine);
            System.out.print(highLine);
            System.out.print(lowLine);
            System.out.print(gradesTitle);
            System.out.print(aLine);
            System.out.print(bLine);
            System.out.print(cLine);
            System.out.print(dLine);
            System.out.print(fLine);
        } else {
            System.out.println("No valid scores to display.");
        }

        // Write to file one by one
        try {
            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(title);
            bw.write(totalLine);
            
            if (scores.size() > 0) {
                bw.write(avgLine);
                bw.write(highLine);
                bw.write(lowLine);
                bw.write(gradesTitle);
                bw.write(aLine);
                bw.write(bLine);
                bw.write(cLine);
                bw.write(dLine);
                bw.write(fLine);
            } else {
                bw.write("No valid scores to display.\n");
            }
            
            // gotta remember to close it!
            bw.close();
            
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}