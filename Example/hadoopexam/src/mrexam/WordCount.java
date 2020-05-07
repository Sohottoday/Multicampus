package mrexam;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class WordCount {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");	//hadoop 버전 2번대 명령어
		//conf.set("fs.default.name", "hdfs://192.168.111.120:9000"); //hadoop 버전 1번대 명령어

		Job job = Job.getInstance(conf, "WordCount");

		job.setJarByClass(WordCount.class);	//드라이버 클래스의 클래스 객체 지정
		job.setMapperClass(WordCountMapper.class);		//입력받은것을 key value로 내보냄	//
		job.setReducerClass(WordCountReducer.class);	//처리한 결과를 key value로 내보냄 //결과에 대한 집계같은 것들을 reduce에서 처리한다고 보면 됨.

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		job.setOutputKeyClass(Text.class);	//하둡 개발자들은 자바측에서 만든 integer, string 객체는 무겁다고 생각하여 직접 만들게 됨.(text, int)
		job.setOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(job, new Path("/edudata/fruits.txt"));
		FileOutputFormat.setOutputPath(job, new Path("/result/fruits1"));		//파일이 없으면 일하고 있으면 에러가 뜸. 따라서 반복수행 테스트를 하고 싶다면 파일명을 바꾸고 진행
		//그러므로 그러한 작업이 귀찮기 때문에 폴더명까지만 지정. 그렇게 되면 파일 명을 자동으로 지정하여 반복수행.

		job.waitForCompletion(true);
		System.out.println("처리가 완료되었습니다.");
	}
}