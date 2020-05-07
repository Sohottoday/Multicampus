package mrexam;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	private IntWritable result = new IntWritable();	//똑같이 key타입은 text, value타입은 int타입 이라는 의미. 받는타입 2개 내보내는 타입 2개

	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {	//iterable => java의 collection객체(몇개가 올지 모른다는 의미)
		System.out.print("reduce : "+key+"---");
		int sum = 0;
		for (IntWritable val : values) {
			int data = val.get();
			System.out.print(data+" ");
			sum += data;
		}
		result.set(sum);
		context.write(key, result);
	}
}