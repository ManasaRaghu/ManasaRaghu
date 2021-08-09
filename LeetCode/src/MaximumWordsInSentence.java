import java.util.stream.Stream;

public class MaximumWordsInSentence {
	public static int solution(String S) {
		String[] spilt = S.split("");
		
		//String[] secondSpilt = 
		if (S == null || S.isEmpty())
            return 0;

        return Stream
                .of(S.split("[?!.]"))
                .map(String::trim)
                .mapToInt(sentence -> sentence.split("\\s+").length)
                .max()
                .orElse(0);
    }

	public static void main(String[] args) {
		
		String sample = "We test coders. Give us a try?";
		System.out.println(solution(sample));
		
	}

}
