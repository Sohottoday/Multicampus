package dao;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class HadoopDAO3 {
	@Autowired
	private Configuration conf;

	public HadoopDAO3() {
		System.out.println("HadoopDAO3");
		
	}
	public String mapreduce() {
		String result = "";
		try (FileSystem hdfs = FileSystem.get(conf)) {
			Path filePath = new Path("/result/springmr");
			if (hdfs.exists(filePath)) {
				hdfs.delete(filePath, true);
			}

			Job job = Job.getInstance(conf, "SPRINGHW");

		    job.setJarByClass(HadoopDAO3.class);
		    job.setMapperClass(mapred.MyMapper.class);
		    job.setReducerClass(mapred.MyReducer.class);

		    job.setInputFormatClass(TextInputFormat.class);
		    job.setOutputFormatClass(TextOutputFormat.class);

		    job.setOutputKeyClass(Text.class);		//내보내지는 key타입과 value타입 설정
		    job.setOutputValueClass(IntWritable.class);

		    FileInputFormat.addInputPath(job, new Path("/edudata/product_click.log"));
		    FileOutputFormat.setOutputPath(job, new Path("/result/springmr"));

		    job.waitForCompletion(true);	// job 객체를 보내는 작업 수행. 반드시 수행해야 한다.
	
			result = "맵리듀스작업 성공!! ";
		} catch (Exception e) {
			e.printStackTrace();
			result = "맵리듀스작업 실패!! ";
		}
		return result;
	}

	public String mrresult() {
		String result = "";
		try (FileSystem hdfs = FileSystem.get(conf)) {
			Path filePath = new Path("/result/springmr/part-r-00000");
			if (hdfs.exists(filePath)) {
				BufferedReader r = new BufferedReader(new InputStreamReader(hdfs.open(filePath), "utf-8"));
				String line = null;
				while ((line = r.readLine()) != null) {
					System.out.println(line);
					result += line + "<br>";
				}
				r.close();
			} else {
				result = "MR 결과가 존재하지 않습니다!!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "오류가 발생했어요";
		}
		return result;
	}
}
