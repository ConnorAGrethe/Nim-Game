public class Computer extends Player{
    
    int[] winCons = {3,7,13,31};
    boolean hardMode;
    
    
    public Computer(boolean hm){
        super("Computer");
        hardMode = hm;
    }
    public void doMove(int p, int g){
        if(hardMode){
            smartMove(p,g);
        } else {
            game.move(Math.random()*g);
        }
    }
    public void smartMove(int p, int g){
        boolean didMove = true;
        for(int i=winCons.length; i>=0; i--){
            if(didMove && p-g <= winCons[i] && p<winCons[i]){
                game.move(p-winWons[i]);
                didMove = false;
            }
        }
        if(didMove){
            game.move(1);
        }
    }
}