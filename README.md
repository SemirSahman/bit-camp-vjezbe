package ba.bitcamp.week6.day2.ObjectOrientedProgramming;

public class ArrayManipulation {
	
	public static Computer[] extendArray(Computer[] c){
		
		Computer[] a = new Computer[c.length+1];
		
		for(int i = 0; i<c.length;i++){
			a[i] = c[i];
		}
		return a;
	}
	public static Computer[] shrinkArray(Computer[] c, int idx){
		int counter = 0;
		Computer[] a = new Computer[c.length-1];
		for(int i = 0;i<a.length;i++){
			if(counter == idx){
				counter++;
			}
			a[i]=c[counter];
			counter++;
			
		}
		return a;
	}

}
