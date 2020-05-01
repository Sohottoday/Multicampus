package hdfsexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

public class FileTest {
	
	private static final String srcDir = "/edudata/" ;

	public static void main(String[] args) throws Exception {
		String fileName = "president_moon.txt";
		Path path = new Path(srcDir + fileName);
		Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");
		FileSystem fs = FileSystem.get(URI.create(srcDir + fileName), conf);
		
		if(fs.exists(path)) { 
			BufferedReader br =new BufferedReader(new InputStreamReader(fs.open(path)));
			
			while(br.ready()){ 	  	
				String line = br.readLine();
				System.out.println(line);
	        }
			
			FileStatus fStatus = fs.getFileStatus(path);
			if(fStatus.isFile()) {
				System.out.println("");
				System.out.println("===========================================");
				System.out.println("File Block Size : " + fStatus.getBlockSize());
				System.out.println("Group of File   : " + fStatus.getGroup());
				System.out.println("Owner of File   : " + fStatus.getOwner());
				System.out.println("File Length     : " + fStatus.getLen());
			} else {
				System.out.println("파일이 아닙니다.");
			}
			path = new Path(srcDir);
			RemoteIterator<LocatedFileStatus> list = fs.listFiles(path,  false);
			while(list.hasNext()) {
				LocatedFileStatus ls = list.next();
				Path p = ls.getPath();
				System.out.println(p.getName());
			}
		} else {
			System.out.println("파일을 찾을 수 없습니다.");
		}
	}

}
