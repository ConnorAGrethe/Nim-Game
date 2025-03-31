import java.util.Scanner;


public class Nim{
    int pieces;
    int greatest;
    Player p1;
    Player p2;
    int up;
    boolean pa;
    int score1;
    int score2;

    public Nim(Player p, Player f){
        pieces = (int)(10+Math.random()*41);
        setGreatest();
        up = (int)(1+Math.random()*2);
        p1 = p;
        p2 = f;
        score1 = 0;
        score2 = 0;
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
        if(hm && (pieces == 13 || pieces == 31)){
            up = 1;
        } else if(hm){
            up = (int)((15+Math.random()*11)/10);
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
            System.out.println(up);
            if(up==1){
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                score2++;
                p2.win(score2);
            } else{
                System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
                score1++;
                p1.win(score1);
            }
            score();
            //user input
            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to play again? Yes or no?");
            String plAg = sc.nextLine();
            boolean looping = true;
            while(looping == true){
                if(plAg.toLowerCase().equals("yes")){
                    pa = true;
                    looping = false;
                    System.out.println("fffffffffffffffffffffffffffffffffffffffffffffffffffffffff1");
                    playAgain();
                }
                else if(plAg.toLowerCase().equals("no")){
                    pa = false;
                    looping = false;
                    end();
                }
                else{
                    System.out.println("Invalid answer. Yes or No?");
                    plAg = sc.nextLine();
                }
           }
            // if(pa){
            //     playAgain();
            // }
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
    public void end(){
        System.out.println("djkshfjkshlkf");
        //sc.close();
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
    public void score(){
        System.out.println(p1.getName() + " has " + score1 + " points");
        System.out.println(p2.getName() + " has " + score2 + " points");
    }
}
//Wyatt Judge was here