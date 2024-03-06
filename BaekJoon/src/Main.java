import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		String st = str.toLowerCase();
		
		int ch = 'a';
		
		while(ch <= 'z') {
			int num = -1;
			for (int i = 0 ; i < st.length() ; i++) {
				if( ch == st.charAt(i) ) { // 'o' == charAt(6)
					num = i;
					break;
				}
			}
			System.out.print(num + " ");
			ch++;
		}
				
		sc.close();
	}

}
