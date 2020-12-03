package org.ieti.lucrarea6;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtility {

	public static void writeToFile(SubscriptionPlan plan) {

		XmlMapper xmlMapper= new XmlMapper();

		File file = new File("src/main/resources/plan.xml");

		try {
			xmlMapper.writeValue(file, plan);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SubscriptionPlan readFromFile() {
		XmlMapper xmlMapper= new XmlMapper();
		File file = new File("src/main/resources/plan.xml");
		try {
			String xml= inputStreamToString(new FileInputStream(file));
			SubscriptionPlan subscriptionPlan = xmlMapper.readValue(xml, SubscriptionPlan.class);


			return subscriptionPlan;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	public static String inputStreamToString(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}
}
