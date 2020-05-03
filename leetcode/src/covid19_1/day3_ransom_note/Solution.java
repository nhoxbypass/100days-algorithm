package covid19_1.day3_ransom_note;

class Solution {
    public static void main(String[] args) {
        boolean res = canConstruct("aab", "aba");
        System.out.println(res);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] allNotesCount = new int[26]; // All chars count of the ransom note
        int distinctNoteCount = 0; // Distinct char count of the ransom note
        // Analyze the ransom notes
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (allNotesCount[index] == 0) {
                distinctNoteCount++;
            }
            allNotesCount[index]++;
        }

        // Check with the magazine
        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            if (allNotesCount[index] == 1) {
                // This character from magazine is only show once --> reduce distinct char count
                distinctNoteCount--;
            }

            if (distinctNoteCount == 0) {
                // We cleared all distinct char in the ransom note
                return true;
            }

            allNotesCount[index]--;
        }

        return distinctNoteCount == 0;
    }

    /*public static boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.contains(ransomNote))
            return true;

        char[] notes = ransomNote.toCharArray();

        for (int i = 0; i < magazine.length(); i++) {
            int lastMatch = -1;
            int lastOffset = 0;

            for (int j = 0; j < notes.length; j++) {
                if (magazine.charAt(i) == notes[j]) {
                    int offset = 0;
                    while ((i + offset < magazine.length()) && (j + offset < notes.length)) {
                        if (magazine.charAt(i + offset) == notes[j + offset]) {
                            // Seem good
                            offset++;
                        } else {
                            break;
                        }
                    }
                    // We prefer the bigger match
                    if (offset > lastOffset) {
                        lastMatch = j;
                        lastOffset = offset;
                    }
                }
            }

            if (lastMatch != -1) {
                // Clear matched notes
                for (int j = lastMatch; j < (lastMatch + lastOffset); j++) {
                    notes[j] = ' ';
                }
                // Jump to matched offset
                i += (lastOffset - 1);
            } else {
                // A magazine char doesn't matched with any char in notes
            }
        }

        return isCleared(notes);
    }

    private static boolean isCleared(char[] notes) {
        for (char note : notes) {
            if (note != ' ')
                return false;
        }
        return true;
    }*/
}