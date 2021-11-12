import java.util.*;

public class Crypto {
    // Crypto
    public static int stringToInt(String str, HashMap<Character, Integer> charIntMap) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res = res * 10 + charIntMap.get(str.charAt(i));
        }
        return res;
    }

    public static void crypto(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
            String s1, String s2, String s3) {
        if (idx == unique.length()) {
            int x = stringToInt(s1, charIntMap);
            int y = stringToInt(s2, charIntMap);
            int z = stringToInt(s3, charIntMap);

            if (x + y == z) {
                for (int i = 0; i < 26; i++) {
                    char ch = (char) (i + 'a');
                    if (charIntMap.containsKey(ch))
                        System.out.print(ch + "-" + charIntMap.get(ch) + " ");
                }
                System.out.println();
            }
            return;
        }

        char ch = unique.charAt(idx);
        for (int num = 0; num < 10; num++) {
            if (!usedNumbers[num]) {
                usedNumbers[num] = true;
                charIntMap.put(ch, num);

                crypto(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);

                charIntMap.remove(ch);
                usedNumbers[num] = false;
            }
        }
    }
}
