public class Computer extends Player{
    
    int[] winCons = {3,7,13,31};
    boolean hardMode;
    
    
    public Computer(boolean hm){
        super("Computer");
        hardMode = hm;
    }
    public int doMove(int p, int g){
        System.out.println("There are "+ p +" pieces left.");
        if(hardMode){
            // smartMove(p,g);
            int a = smartMove(p,g);
            System.out.println("The computer takes "+ a +" pieces");
            return a;
        } else {
            // game.move((int)(Math.random()*g));
            int a =(int)(Math.random()*g);
            System.out.println("The computer takes "+ a +" pieces");
            return a;
        }
    }
    public int smartMove(int p, int g){
        // boolean didMove = true;
        for(int i=winCons.length-1; i>=0; i--){
            if(p-g <= winCons[i] && p>winCons[i]){
                //game.move(p-winWons[i]);
                return p-winCons[i];
                // didMove = false;
            }
        }
        // if(didMove){
        //     // game.move(1);
        //     return 1;
        // }
        return 1;
    }
}