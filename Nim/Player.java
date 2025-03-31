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
    public void win(int s){
        System.out.println(name + " has won the game");
        score = s;
    }
    public int doMove(int p, int g){
        int val;
        boolean loop = true;
        System.out.println("There are " + p + " pieces left. You can take up to " + g + " pieces.");
        System.out.println("How many pieces would you like to take?");
        Scanner sc = new Scanner(System.in);
        val = sc.nextInt();
        sc.nextLine();
        while(loop){
            if(0<val && val<=g){
                loop = false;
            }
            else{
            System.out.println("Invalid move!");
            System.out.println("There are " + p + " pieces left. You can take up to " + g + " pieces.");
            System.out.println("How many pieces would you like to take?");
            val = sc.nextInt();
            sc.nextLine();
            }
        }
        // game.move(val);
        return val;
    }
}