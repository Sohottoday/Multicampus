package mapred;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	private final static IntWritable outputvalue=new IntWritable(1);
	private Text outputkey=new Text();
	
	public void map(LongWritable key, Text value, Context context)
	throws IOException, InterruptedException{		
		LogParser parser=new LogParser(value);
		outputkey.set(parser.getProduct());
		context.write(outputkey, outputvalue);
	}
}
