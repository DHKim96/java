import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String[] strs, strs2;
		
		try {
			
			strs = br.readLine().split(" ");
			
			
			int m = Integer.parseInt(strs[0]);
			int n = Integer.parseInt(strs[1]);
			
			int[] arr = new int[m];
			
			for(int i = 0 ; i < arr.length; i++) {
				arr[i] = i+1;
			}
			
			strs2 = br.readLine().split(" ");
			int num1 = Integer.parseInt(strs[0]);
			int num2 = Integer.parseInt(strs[1]);
			
			int k = num2 - num1;
			
			for(int i = 0 ; i < k ; i++) {
				
				for(int j = num1 ; j < k-1 ; j++) {
					if(arr[j+1] > arr[j]) {
						int temp = arr[j+1];
						arr[j+1] = arr[j];
						arr[j] = temp;
					}
				}
			}
			
			for(int a : arr) {
				bw.write(a + " ");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
