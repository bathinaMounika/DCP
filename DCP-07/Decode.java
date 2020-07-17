public class Decode {
    public static int numDecodings(String s) {
        int count = 0;
        if(s.length() == 0) return 0;
        if(s.length() == 1){
            if(Integer.parseInt(s) != 0)
                return 1;
            return 0;
        } 
        if(s.length() == 2){
            //count ++;
            if(Integer.parseInt(s) <= 26 && Integer.parseInt(s) >=10){
                count++;
            }
        }
        if(Integer.parseInt(s.substring(0,1)) != 0){
            count += numDecodings(s.substring(1));
            if(Integer.parseInt(s.substring(0, 2)) <= 26){
                count += numDecodings(s.substring(2));
            }
        }
        return count;
    }

    public static void main(String[] args){
    	System.out.println(numDecodings(String[0]));
    }
}