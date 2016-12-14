import java.util.Scanner;

class Player {
	private int location=0;		// field
	public int getLocation(){		// getter
		return location;
	}
	public void movePlayer(int num){
		if(num==4||num==6){				// if the dice roll is 4 or 6
			this.location-=num;			// move backwards
		}
		else this.location+=num;		// if the dice roll is not 4 or 6
		if(this.location<0){			// move forward
			this.location=0;
		}
	}
	public void penalty(){
		this.location=0;
	}
	public static void main(String args[]){
		Player a=new Player();				// create player A
		Player b=new Player();				// create player B
		String cumulativeAnswer="";
		System.out.println("Yo enter a line");
		Scanner input=new Scanner (System.in);
		String line=input.nextLine();
		int count=1;
		while(count<6){								// run the game 5 times
			String[] bsMoveNums=line.split(",");		// split the user input at "," to numbers
			int [] moveNums=new int[bsMoveNums.length];			
			for(int i=0; i<moveNums.length; i++){
				moveNums[i]=Integer.parseInt(bsMoveNums[i]);
			}


			int move=moveNums[0];
			for(int i=0; move!=0; i++){ 		// a moves
				if(i%2==0){
					a.movePlayer(move);
					if (a.getLocation()==b.getLocation()){
						b.penalty();
					}


				}
				if(i%2==1){
					b.movePlayer(move);


					if (a.getLocation()==b.getLocation()){
						a.penalty();
					}
				}
				move=moveNums[i+1];
				if(a.getLocation()>=39||b.getLocation()>=39){
					move=0;
				}
			}
			String aFinal;
			String bFinal;	
			if(a.getLocation()>=39){
				aFinal="END";
			} else { aFinal=""+a.getLocation();}
			if(b.getLocation()>=39){
				bFinal="END";
			} else{bFinal=""+b.getLocation();}
			String answer="A-"+aFinal+", B-"+bFinal;
			System.out.println(answer);

			cumulativeAnswer+=count+":"+ answer+"   ";
			a.penalty();
			b.penalty();
			if(count<5){
				line=input.nextLine();
			}
			count++;
		}
		System.out.println("This is the summary.  "+cumulativeAnswer);
	}
}