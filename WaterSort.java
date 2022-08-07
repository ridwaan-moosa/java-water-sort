
import java.util.Scanner;
import java.util.Random;
import java.util.*;
class WaterSort {
    Character top = null;
    // create constants for colors
    static Character red= new Character('r');
    static Character blue = new Character('b');
    static Character yellow= new Character('g');
    // Bottles declaration
    
    
    public static void showAll( StackAsMyArrayList bottles[])
    {
        for (int i = 0; i<=4; i++)
         {
             System.out.println("Bottle "+ i+ ": " + bottles[i]);
         }
    }
    
    public static void main(String args[])
    {
             int moves = 0;// number of moves to mix the water
             int source = 0; // number of bottle to pour FROM
             int target = 0; // number of bottle to pour TO
             int max = 4; // total number of items allowed per bottle
             Random randomNum = new Random();
             // Bottles declaration
             StackAsMyArrayList bottles[] = new StackAsMyArrayList[5];
             //You can do this with a for also
             bottles[0] = new StackAsMyArrayList<Character>();
             bottles[1] = new StackAsMyArrayList<Character>();
             bottles[2] = new StackAsMyArrayList<Character>();
             bottles[3] = new StackAsMyArrayList<Character>();
             bottles[4] = new StackAsMyArrayList<Character>();
             
             //////STRATEGY #1
             while (moves<4) // 4 moves per 3 colors = 12 moves required
             {
              // get source bottle
              target = randomNum.nextInt(max+1);
              while (bottles[target].getStackSize() == 4)// target is full
                 {
                   target = randomNum.nextInt(max);
                 }
              bottles[target].push(blue);
              target = randomNum.nextInt(max+1);
              while (bottles[target].getStackSize() == 4)// target is full
                 {
                   target = randomNum.nextInt(max);
                 }
              bottles[target].push(red);
              target = randomNum.nextInt(max+1);
              while (bottles[target].getStackSize() == 4)// target is full
                 {
                   target = randomNum.nextInt(max);
                 }
              bottles[target].push(yellow);
              showAll(bottles);
              // increment valid moves
              moves++;
            }
            
            Scanner input = new Scanner(System.in);
            //System.out.print("enter s to start or x to exit: ");
            char play = 's';//input.next().charAt(0);
            
            while(play != 'x'){
                System.out.print("Enter a target,soure (eg. 2,3): ");
                String st[]= input.nextLine().split(",");
                target = Integer.parseInt(st[0]);
                source = Integer.parseInt(st[1]);
            if(bottles[target].peek() != bottles[source].peek() && bottles[target].peek() != null){
                    System.out.print("you cannot put different colours on top of each other,Enter a target,soure (eg. 2,3): ");
                    st= input.nextLine().split(",");
                    showAll(bottles);
                }
                else 
                {
                    switch(source){
                        
                        case 0:if(target == 1){bottles[1].push(bottles[0].pop());}
                                if(target == 2){bottles[2].push(bottles[0].pop());}
                                if(target == 3){bottles[3].push(bottles[0].pop());}
                                if(target == 4){bottles[4].push(bottles[0].pop());}
                                if(target == 0){
                                    System.out.print("cant move into the same bottle,Enter a target,soure: ");
                                    st= input.nextLine().split(",");
                                }
                                showAll(bottles);
                                break;
                        case 1:if(target == 0){bottles[0].push(bottles[1].pop());}
                                if(target == 3){bottles[3].push(bottles[1].pop());}
                                if(target == 4){bottles[4].push(bottles[1].pop());}
                                if(target == 2){bottles[2].push(bottles[1].pop());}
                                if(target == 1){
                                    System.out.print("cant move into the same bottle,Enter a target,soure: ");
                                    st= input.nextLine().split(",");
                                }
                                showAll(bottles);
                                break;
                        case 2:if(target == 1){bottles[1].push(bottles[2].pop());}
                                if(target == 3){bottles[3].push(bottles[2].pop());}
                                if(target == 4){bottles[4].push(bottles[2].pop());}
                                if(target == 0){bottles[0].push(bottles[2].pop());}
                                if(target == 2){
                                    System.out.print("cant move into the same bottle,Enter a target,soure: ");
                                    st= input.nextLine().split(",");
                                }
                                showAll(bottles);
                                break;
                        case 3:if(target == 1){bottles[1].push(bottles[3].pop());}
                                if(target == 2){bottles[2].push(bottles[3].pop());}
                                if(target == 4){bottles[4].push(bottles[3].pop());}
                                if(target == 0){bottles[0].push(bottles[3].pop());}
                                if(target == 3){
                                    System.out.print("cant move into the same bottle,Enter a target,soure: ");
                                    st= input.nextLine().split(",");
                                }
                                showAll(bottles);
                                break;
                        case 4:if(target == 1){bottles[1].push(bottles[4].pop());}
                                if(target == 2){bottles[2].push(bottles[4].pop());}
                                if(target == 3){bottles[3].push(bottles[4].pop());}
                                if(target == 0){bottles[0].push(bottles[4].pop());}
                                if(target == 4){
                                    System.out.print("cant move into the same bottle,Enter a target,soure: ");
                                    st= input.nextLine().split(",");
                                }
                                showAll(bottles);
                                break;
                   
                    }
                    if(!solved(bottles)){
                        play = 's';}
                        else{
                            play = 'x';
                            System.out.print("game complete!");
                        }
                        
         }
     }
    }
    public static boolean solved(StackAsMyArrayList bottles[]){
        boolean value = true;
        
        for(int a = 0; a < bottles.length; a++){
        value = bottles[a].checkStackUniform();
        if(!value){
            break;
        }
        }
        return value;
    }
    
}

