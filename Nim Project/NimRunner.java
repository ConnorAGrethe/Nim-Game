public class NimRunner
{
    public static void main(String[] args){
        int playerCount;
        Scanner scan = new Scanner(System.in);
        System.out.println("1 or 2 players? Please answer with only a number.");
        playerCount = scan.nextInt();
        if(playerCount == 1){
            System.out.println("What is your name?");
            String name = scan.nextLine();
            Player p1 = new Player(name);
            //scaner ask for hard mode
            System.out.println("Would you like to play hard mode? Yes or No.");
            String hardMode = scan.nextLine();
            boolean l = true;
            while(l = true){
                if(hardMode.toLowerCase().equals("yes")){
                    Nim game = new Nim(p1, true);
                    l = false;
                }
                else if(hardMode.toLowerCase().equals("no")){
                    Nim game = new Nim(p1, false);
                    l = false;
                }
                else{
                    System.out.println("Invalid answer, Yes or No?");
                    System.out.println("Would you like to play hard mode? Yes or No.");
                    hardMode = scan.nextLine();
                }
            }
            

            
        } else {
            System.out.println("Player 1 what is your name?");
            String name = scan.nextLine();
            Player p1 = new Player(name);
            System.out.println("Player 1 what is your name?");
            String name2 = scan.nextLine();
            Player p2 = new Player(name2);
            Nim game = new Nim(p1,p2);
        }
        
    }
}