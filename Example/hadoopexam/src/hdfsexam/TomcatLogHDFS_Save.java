package hdfsexam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class TomcatLogHDFS_Save {

	public static void main(String[] args) throws IOException {

		File f = new File(
				"C:\\Sohottoday\\eclipse-jee-2019-09-R-win32-x86_64\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\logs");

		File merged = new File("c:/Sohottoday/tomcat_access_log.txt");
		if (!merged.exists()) {
			merged.createNewFile();
		}

		PrintWriter pw = new PrintWriter(merged);

		String[] s = f.list();

		for (String s1 : s) {
			File f1 = new File(f, s1);
			BufferedReader br = new BufferedReader(new FileReader(f1));

			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				pw.println(line);
			}
		}
		pw.flush();    
		pw.close();

		FileSystemOperations client = new FileSystemOperations();
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");
		
		System.out.println(merged.getAbsolutePath().toString());
		client.addFile("c:/Sohottoday/tomcat_access_log.txt", "/edudata", conf);
		
		Path remotePath = new Path("/edudata/tomcat_access_log.txt");
		FileSystem fs = FileSystem.get(URI.create("/edudata/tomcat_access_log.txt"), conf);
		FileStatus fStatus = fs.getFileStatus(remotePath);

		if (fStatus.isFile()) {
			System.out.println("File Length     : " + fStatus.getLen());
		} else {
			System.out.println("파일이 아닙니다.");
		}
		
	}
}
