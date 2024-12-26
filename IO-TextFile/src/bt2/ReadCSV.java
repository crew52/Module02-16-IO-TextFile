package bt2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String csvFile = "text\\countries.csv"; // Đường dẫn tới file CSV
        String line;
        String csvSplitBy = ","; // Dấu phân cách trong file CSV

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            System.out.println("Danh sách các quốc gia:");
            while ((line = br.readLine()) != null) {
                // Cắt chuỗi bằng dấu phẩy
                String[] country = line.split(csvSplitBy);

                // Hiển thị thông tin quốc gia
                System.out.println("ID: " + country[0] +
                        ", Code: " + country[1] +
                        ", Name: " + country[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
