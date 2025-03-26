public class Nim{
    int pieces;
    int greatest;
    Player p1;
    Player p2;
    int up;
    boolean pa;

    public Nim(Player p, Player f){
        pieces = 10+Math.random()*41;
        setGreatest();
        up = 1+Math.random()*2;
        p1 = p;
        p2 = f;
        if(up == 1){
            System.out.println(p1.getName() + " is first");
        }else{
            System.out.println(p2.getName() + " is first");
        }
    }
    public Nim(Player p, boolean hm){
        pieces = 10+Math.random()*41;
        setGreatest();
        up = 1+Math.random()*2;
        p1 = p;
        p2 = new Computer(hm);
        
    }
    public void setGreatest(){
        greatest = pices/2;
        if(greatest == 0){
            greatest = 1;
        }
    }
    public void move(int n){
        if(n >= greatest){
            pieces -= n;
        }
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
        }
        else{
            if(up==1){
                up=2;
                System.out.println(p2.getName() + " is up");
            }else{
                up=1;
                System.out.println(p1.getName() + " is up");
            }
        }

    }
    public void playAgain(){
        pieces = 10+Math.random()*41;
        setGreatest();
        up = 1+Math.random()*2;
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