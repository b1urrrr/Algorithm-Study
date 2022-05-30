import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Do_Not_Touch_Anything {
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double R = Double.parseDouble(st.nextToken());
		double C = Double.parseDouble(st.nextToken());
		double N = Double.parseDouble(st.nextToken());
		
		long RCCTV = (long) Math.ceil(R / N);
		long CCCTV = (long) Math.ceil(C / N);
		
		//넓이
		long CCTV = RCCTV * CCCTV;
		
		System.out.println(CCTV);
}
