import java.util.Scanner;



public class Player{
    private int score;
    private String name;

    public Player(String n){
        name = n;
        score = 0;
    }
    public String getName(){
        return name;
    }
    public int getScore(){
        return score;
    }
    public void win(){
        score++;
    }
    public void doMove(int p, int g){
        int val;
        boolean loop = true;
        System.out.println("There are" + p + " pieces left. You can take up to " + g + " pieces.");
        Scanner sc = new Scanner(System.in);
        val = sc.nextInt();
        System.out.println("How many pieces would you like to take?");
        while(loop){
            if(0<val && val<=g){
                game.move(val);
                loop = false;
            }
            else{
            System.out.println("Invalid move!");
            System.out.println("There are" + p + " pieces left. You can take up to " + g + " pieces.");
            val = sc.nextInt();
            System.out.println("How many pieces would you like to take?");
            }
        }
        game.move(val);
    }
}