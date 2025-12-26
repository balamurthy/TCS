package utils;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static Object[][] readLoginData(String filePath) {

        List<Object[]> data = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            String[] line;
            boolean skipHeader = true;

            while ((line = reader.readNext()) != null) {

                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                String username = line[0];
                String password = line[1];

                data.add(new Object[]{username, password});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data.toArray(new Object[0][0]);
    }
}
