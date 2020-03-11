package reorderlogfiles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 * <p>
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * <p>
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 * <p>
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 * <p>
 * Return the final order of the logs.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */

class Solution {
    String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        String[] res = new String[logs.length];
        String regex = "\\d+";
        for (String log : logs) {
            if (!log.split(" ")[1].matches(regex)) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }
        letterLogs.sort(Comparator.comparing((String a) -> a.substring(a.indexOf(" ") + 1))
                .thenComparing(a -> a.split(" ")[0]));

        int idx = 0;
        for (String log : letterLogs) {
            res[idx++] = log;
        }
        for (String log : digitLogs) {
            res[idx++] = log;
        }
        return res;
    }
}

/*
Success
Details
Runtime: 10 ms, faster than 14.79% of Java online submissions for Reorder Data in Log Files.
Memory Usage: 42.8 MB, less than 5.88% of Java online submissions for Reorder Data in Log Files.
 */