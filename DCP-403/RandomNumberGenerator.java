import java.util.Random;

public class RandomNumberGenerator{
  public static void main(String[] args) {
    try{
      Integer n = Integer.parseInt(args[0]);
      for(int i =0; i < n; i++){
        System.out.println(rand7());
      }
    }catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
      System.out.println("Please add valid number in the cli args");
    }
  }

  public static int rand5(){
    Random random = new Random();
    return random.nextInt(5) + 1;
  }

  public static int rand7(){
    int r = 5 * (rand5() - 1) + (rand5() - 1);
    //rejection Sampling
    if(r < 21) return (r % 7) + 1;
    return rand7();
  }
}
