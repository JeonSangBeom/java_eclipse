package lecture;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
//서버
public class CalcServerTest {
	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		BufferedReader input = null;
		BufferedWriter output = null;
		try {
			listener = new ServerSocket(9999);// 내가 열 소켓
			System.out.println("서버가 클라이언트 연결을 기다리고 있습니다.");
			socket = listener.accept();
			System.out.println("클라이언트 연결되었습니다.");
			input = new BufferedReader(   new InputStreamReader( socket.getInputStream() ) );
			output = new BufferedWriter(  new OutputStreamWriter( socket.getOutputStream() ) );
			while(true) {
				//클라이언트에서 받아오기
				String inputMsg = input.readLine(); //10 + 10
				String result = "";
				StringTokenizer st = new StringTokenizer(inputMsg," ");//글자 구분하기(인풋을 받아서 3개로 분리)
				int total = st.countTokens(); //10,+,10// 3개만 넘기게
				if(total>3) return;
				//나눈 글자 변수에 담기
				int num01 = Integer.parseInt( st.nextToken() );
				String calcOperator = st.nextToken();
				int num02 = Integer.parseInt( st.nextToken() );
				//조건 걸기
				if(calcOperator.equals("+")) {
					result = ""+(num01+num02);
				} else if(calcOperator.equals("-")) {
					result = ""+(num01-num02);
				} else if(calcOperator.equals("*")) {
					result = ""+(num01*num02);
				}
				output.write(result+"\r\n");
				output.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
