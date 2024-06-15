public class p30 {
    public static void main(String[] args) {
        String input = "Hello World! This is a Java Program.";
        String result = removeVowels(input);
        System.out.println("Original String: " + input);
        System.out.println("String without vowels: " + result);
    }

    public static String removeVowels(String str) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!isVowel(ch)) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
