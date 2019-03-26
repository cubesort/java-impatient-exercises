package ch8;

public class Ch8_6 {
    public static void main(String[] args) {
        boolean isWord1 = isWord("word");
        boolean isWord2 = isWord("word2");
        System.out.println(isWord1);
        System.out.println(isWord2);
    }

    public static boolean isWord(String str) {
        return str.length() > 0 && str.codePoints().allMatch(Character::isAlphabetic);
    }
}
