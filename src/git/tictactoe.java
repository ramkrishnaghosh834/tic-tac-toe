package git;



import java.util.List;
import java.util.Random;
import java.util.Scanner;


import java.util.ArrayList;
import java.util.Arrays;

public class tictactoe {
	static ArrayList <Integer> player=new ArrayList<>();
	   static ArrayList<Integer> cpu=new ArrayList<>();
public static void main(String args[]) {
  
   char  ar[][]={ {' ','|',' ','|',' '},
   {'-','+','-','+','-'},
   {' ','|',' ','|',' '},
   {'-','+','-','+','-'},
   {' ','|',' ','|',' '}};
  display(ar);
  
  String l="";
 Random random=new Random();
  
  while(true) {
	  int n=input();
	  while((player.contains(n))||(cpu.contains(n))){
		  System.out.println("already entered");
		  n=input();
  }
	      
		  place(n,ar,"player");
		  display(ar);
		  l= check();
			 System.out.println(l);
	 System.out.println();
	  
	 
	  int ran=random.nextInt(9)+1;
	 while(cpu.contains(ran)||player.contains(ran)) {
		 ran=random.nextInt(9)+1;
	 
  }
	  
		   
		   place(ran,ar,"cpu");
			  display(ar);
			  System.out.println();
			 l= check();
			 System.out.println(l);
	  
   }
  }
static void display(char ar[][]) {
	 for(int i=0;i<5;i++) {
		   for(int j=0;j<5;j++) {
			   System.out.print(ar[i][j]);
		   }
		   System.out.println();
		   
	   }
}
static int input() {
	Scanner scan=new Scanner(System.in);
	int n=scan.nextInt();
	return n;
}
static void place(int n,char ar[][],String str) {
	char symbol='O';
	
	if(str=="player") {
		symbol='X';
		player.add(n);
	}else {
		cpu.add(n);
	}
	switch(n){
		case 1:{
			
			ar[0][0]=symbol;
		
		}
		break;
		case 2:{
			ar[0][2]=symbol;
		}
		break;
		case 3:{
			ar[0][4]=symbol;
		}
		break;
		case 4:{
			ar[2][0]=symbol;
		}
		break;
		case 5:{
			ar[2][2]=symbol;
		}
		break;
		case 6:{
			ar[2][4]=symbol;
		}
		break;
		case 7:{
			ar[4][0]=symbol;
		}
		break;
		case 8:{
			ar[4][2]=symbol;
		}
		break;
		case 9:{
			ar[4][4]=symbol;
		}
		break;
	default:
	}}
	static String  check() {
		List toprow= Arrays.asList(1,2,3);
		List midrow= Arrays.asList(4,5,6);
		List lowrow= Arrays.asList(7,8,9);
		List leftcol= Arrays.asList(1,4,7);
		List midcol= Arrays.asList(2,4,8);
		List rightcol= Arrays.asList(3,6,9);
		List crossrow= Arrays.asList(1,5,9);
		List crossrow1= Arrays.asList(3,5,7);
		List<List> win=new ArrayList<>();
		win.add(toprow);
		win.add(midrow);
		win.add(lowrow);
		win.add(leftcol);
		win.add(midcol);
		win.add(rightcol);
		win.add(crossrow);
		win.add(crossrow1);
		for(List l:win) {
		if(player.containsAll(l)) {
			return "You won:";
		}
		else if(cpu.containsAll(l)) {
			return "Cpu won:";
		}
		else if(player.size()+cpu.size()==9) {
			return "Draw:";
		}
		}
		return " ";
	}
}



