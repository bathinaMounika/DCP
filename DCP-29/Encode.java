public class Encode{
    public static void main(String[] args) {
        if(args.length !=0){
            String s = args[0];
            System.out.println("encoded string: " + encode(s));
        }
    }

    public static String encode(String s){
        int count = 0;
        char prev = ' ';
        String encoded_s = "";
        for(int i = 0; i < s.length(); i++){
            if(prev == s.charAt(i) || prev == ' '){
                count ++;
            }else{
                encoded_s += Integer.toString(count)+prev;
                count = 1;
            }
            prev = s.charAt(i);
        }
        encoded_s += Integer.toString(count)+prev;
        return encoded_s;
    }
}