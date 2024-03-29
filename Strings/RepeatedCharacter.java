package Strings;
import java.util.*;
public class RepeatedCharacter {
    char firstRep(String s) {
        LinkedHashMap<Character, Integer> frequencyMap = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        for (char c : frequencyMap.keySet()) {
            if (frequencyMap.get(c) > 1) {
                return c; // First repeated character found
            }
        }
        return '#'; // No repeating character found
    }
}
