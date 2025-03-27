import java.util.Scanner;


public class Nim{
    int pieces;
    int greatest;
    Player p1;
    Player p2;
    int up;
    boolean pa;

    public Nim(Player p, Player f){
        pieces = (int)(10+Math.random()*41);
        setGreatest();
        up = (int)(1+Math.random()*2);
        p1 = p;
        p2 = f;
        if(up == 1){
            System.out.println(p1.getName() + " is first");
            move(p1.doMove(pieces, greatest));
        }else{
            System.out.println(p2.getName() + " is first");
            move(p2.doMove(pieces, greatest));
        }
    }
    public Nim(Player p, boolean hm){
        pieces = (int)(10+Math.random()*41);
        setGreatest();
        if(hm){
            up = (int)((10+Math.random()*11)/20);
        } else{
            up = (int)(1+Math.random()*2);
        }
        p1 = p;
        p2 = new Computer(hm);
        if(up == 1){
            System.out.println(p1.getName() + " is first");
            move(p1.doMove(pieces, greatest));
        }else{
            System.out.println(p2.getName() + " is first");
            move(p2.doMove(pieces, greatest));
        }
    }
    public void setGreatest(){
        greatest = pieces/2;
        if(greatest == 0){
            greatest = 1;
        }
    }
    public void move(int n){
        pieces-=n;
        setGreatest();
        if(pieces == 0){
            if(up==1){
                p2.win();
            } else{
                p1.win();
            }
            //user input
            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to play again? Yes or no?");
            String plAg = sc.nextLine();
            boolean looping = true;
            while(looping == true){
                if(plAg.toLowerCase().equals("yes")){
                    pa = true;
                    looping = false;
                }
                else if(plAg.toLowerCase().equals("no")){
                    pa = false;
                    looping = false;
                }
                else{
                    System.out.println("Invalid answer. Yes or No?");
                    plAg = sc.nextLine();
                }
            }
            if(pa){
                playAgain();
            }
        }else {
            if(up==1){
                up=2;
                System.out.println(p2.getName() + " is up");
                move(p2.doMove(pieces, greatest));
            }else{
                up=1;
                System.out.println(p1.getName() + " is up");
                move(p1.doMove(pieces, greatest));
            }
        }

    }
    public void playAgain(){
        pieces = (int)(10+Math.random()*41);
        setGreatest();
        up = (int)(1+Math.random()*2);
        if(up == 1){
            System.out.println(p1.getName() + " is first");
            p1.doMove(pieces, greatest);
        }else{
            System.out.println(p2.getName() + " is first");
            p2.doMove(pieces, greatest);
        }
    }
    public int getPieces(){
        return pieces;
    }
    public int getGreatest(){
        return greatest;
    }
    public int getUp(){
        return up;
    }
}
//Wyatt Judge was here