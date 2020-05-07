package exercise3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ProductReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	private IntWritable result = new IntWritable();

	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		result = new IntWritable();
		for (IntWritable value : values) {
			int data = value.get();
			System.out.println(data+" ");
			sum += data;
		}
		result.set(sum);
		context.write(key, result);		
	}
}
