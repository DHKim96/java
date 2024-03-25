import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stk;
		try {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			int f = Integer.parseInt(stk.nextToken());
			
			for(int i = -999; i <= 999; i++) {
				for(int j = -999; j <= 999; j++) {
					if((a * i) + (b * j) == c) {
						if( (d * i) + (e * j) == f ) {
							bw.write(i + " " + j);
							return;
						}
					}
				}
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
