import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FindStringFromFile {
public static void main(String[] aregs) {
	String fileName="";
	
	/*
	 * for (String toFindUrl : urlsToTest) { streamService(toFindUrl, fileName); }
	 */


	streamService("mrinal","F:\\Tutorial\\sts_workspace\\JavaSamples\\src\\test.txt");
	
	
}

private static void streamService(String item, String fileName) {
    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
       stream.filter(lines -> lines.contains(item))
                   .forEach(System.out::println);

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
