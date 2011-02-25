package org.doneta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class PingIpv6 extends TestCase{

	public static String inputStream2String(InputStream in) throws IOException {
		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			out.append(new String(b, 0, n));
		}
		return out.toString();
	}

	public void test() {
		assertTrue(true);
	}
	
	public static void main(String[] args) {

		String cmd = "ping -6 -n 1 -w 1 {0} ";
		String path = "c:/address.txt";
		List<String> address = new ArrayList<String>();

		try {
			FileReader io = new FileReader(new File(path));
			BufferedReader reader = new BufferedReader(io);
			String str = null;
			while ((str = reader.readLine()) != null) {
				address.add(str);
			}
			reader.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("c:/ping.txt"));
			for (int i = 0; i < address.size(); i++) {
				Process process = Runtime.getRuntime().exec(MessageFormat.format(cmd, address.get(i)));
				String temp = inputStream2String(process.getInputStream());
				String temp2 = null;
				if(temp.indexOf("[") == -1)
					 temp2 = address.get(i);
				else { 
					temp2 = temp.substring(temp.indexOf("[") + 1, temp.indexOf("]")) + address.get(i);
				}
				System.out.println(temp2);
				writer.write(temp2);
				writer.newLine();
				writer.flush();  
			}
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
