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
		StringTokenizer strTk;
		try {
			// strs 배열에 첫줄에 입력받은 숫자들을 띄어쓰기를 기준으로 하나씩 add
			strTk = new StringTokenizer(br.readLine(), " ");
			// 첫 번째 숫자는 N 두 번째 숫자는 M
			int N = Integer.parseInt(strTk.nextToken());
			int M = Integer.parseInt(strTk.nextToken());
			// 각 바구니의 번호는 순차적으로 부여됐기에 바구니 번호의 집합을 int형 배열로 가정
			// 앞서 입력받은 숫자 N은 곧 바구니의 갯수를 의미하기에 이를 배열의 크기로 대입
			int busket[] = new int[N];
			// 생성한 배열에 순차적으로 번호 부여함으로써 바구니 번호 생성
			for(int i = 0; i < busket.length ; i++) {
				busket[i] = i + 1;
			}
			// 두 번째 줄부터 입력받을 숫자들을 넣기 위한 int형 변수 선언
			int a = 0;
			int b = 0;
			//M개의 줄을 입력받기 위한 반복문
			for(int i = 0 ; i < M ; i++) {
				// 한 줄씩 2개의 숫자들을 입력받아 배열에 추가
				strTk = new StringTokenizer(br.readLine(), " ");
				// 미리 선언한 변수들에 대입(단, 인덱스는 0부터 시작하기에 1을 빼서 대입)
				a = Integer.parseInt(strTk.nextToken()) - 1;
				b = Integer.parseInt(strTk.nextToken()) - 1;
				// 역순을 만들기 위해 숫자 한 개를 임시로 대입할 변수 선언
				int tmp = 0;
				// 역순은
				// 1. a번째 값 - b번째 값 자리 변경
				// 2. (a+1)번째 값 - (b-1)번째 값 자리 변경
				// 3. 단 a >= b 가 되면 안됨
				while(a < b) {
					// b번째 값을 미리 tmp 변수에 대입
					tmp = busket[b];
					// b번째 값에 a번째 값 대입
					busket[b] = busket[a];
					// a번째 값에는 tmp의 값 대입
					busket[a] = tmp;
					// 자리를 변경한 후에는 다음 (a+n)번째 - (b-n)번째 값의 자리를 바꿔야 함
					a++;
					b--;
				}
			}
			for(int i : busket) {
				bw.write(i + " ");
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
