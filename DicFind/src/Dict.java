import java.io.*;
import java.util.*;

public class Dict {
    private HashMap<String, String> engToKorDict;
    private HashMap<String, String> korToEngDict;

    public Dict() {
        engToKorDict = new HashMap<>();
        korToEngDict = new HashMap<>();
    }

    public boolean loadDictionary(String filePath) {
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fr);
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String engWord = parts[0].trim().toLowerCase();
                    String korWord = parts[1].trim().toLowerCase();

                    engToKorDict.put(engWord, korWord);
                    korToEngDict.put(korWord, engWord);
                }
            }
            fr.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("파일 오류");
            return false;
        }
        return true;
    }
    
    public String translateToKorean(String input) {
        return engToKorDict.getOrDefault(input, "");
    }

    public String translateToEnglish(String input) {
        return korToEngDict.getOrDefault(input, "");
    }

    public void showAllWords() {
        for (String eng : engToKorDict.keySet()) {
            System.out.println(eng + " : " + engToKorDict.get(eng));
        }
    }
}
