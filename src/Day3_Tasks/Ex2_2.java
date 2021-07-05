package Day3_Tasks;

public class Ex2_2 {
    public static void main(String[] args) {
        System.out.println(checkChars("Abc"));
        System.out.println(checkChars("Ab2"));
    }
    public static Boolean checkChars (String str){
        //return str.chars().allMatch(Character::isLetter);
        return str.chars().allMatch((c1)->Character.isLetter(c1));
    }
}
