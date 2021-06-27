package trickyquestion;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomSet {
public static void main(String args[]) {
	Set<Integer> s = new HashSet<Integer>();
	for(int i=0;i<100;i++) {
		s.add(RandomSet.randomInteger());
	}
	
	System.out.println(s.size());
	Random r = new Random(123456789L);
	System.out.println(r.nextInt());
	System.out.println(r.nextInt());
	System.out.println(r.nextInt());
}
private static Integer randomInteger() {
	//return new Random(123456789L).nextInt();
	return new Random().nextInt();
}
}