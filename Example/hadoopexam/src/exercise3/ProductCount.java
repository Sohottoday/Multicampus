package exercise3;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import exercise3.ProductCount;
import exercise3.ProductMapper;
import exercise3.ProductReducer;

public class ProductCount {
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");
		
		try(FileSystem hdfs = FileSystem.get(conf)) {
			Path filePath = new Path("/result/exerout6");
			if (hdfs.exists(filePath)) {
				hdfs.delete(filePath, true);
			}
		
		Job job = Job.getInstance(conf, "productcount");
		
		job.setJarByClass(ProductCount.class);	
		job.setMapperClass(ProductMapper.class);
		job.setReducerClass(ProductReducer.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		job.setOutputKeyClass(Text.class);	
		job.setOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(job, new Path("/edudata/product_click.log"));
		FileOutputFormat.setOutputPath(job, new Path("/result/exerout6"));
		
		job.waitForCompletion(true);
		System.out.println("처리가 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("작업 실패 ㅠ.ㅠ");
		}
	}
}
