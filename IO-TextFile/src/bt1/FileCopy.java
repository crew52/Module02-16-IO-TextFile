package bt1;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Nhập đường dẫn tập tin nguồn
            System.out.print("Nhập đường dẫn tập tin nguồn: ");
            String sourcePath = reader.readLine();
            File sourceFile = new File(sourcePath);

            // Kiểm tra sự tồn tại của tập tin nguồn
            if (!sourceFile.exists() || !sourceFile.isFile()) {
                System.out.println("Tập tin nguồn không tồn tại hoặc không hợp lệ.");
                return;
            }

            // Nhập đường dẫn tập tin đích
            System.out.print("Nhập đường dẫn tập tin đích: ");
            String targetPath = reader.readLine();
            File targetFile = new File(targetPath);

            // Cảnh báo nếu tập tin đích đã tồn tại
            if (targetFile.exists()) {
                System.out.println("Cảnh báo: Tập tin đích đã tồn tại.");
                System.out.print("Bạn có muốn ghi đè không? (y/n): ");
                String choice = reader.readLine();
                if (!choice.equalsIgnoreCase("y")) {
                    System.out.println("Hủy thao tác sao chép.");
                    return;
                }
            }

            // Đọc từ tập tin nguồn và ghi vào tập tin đích
            int characterCount = copyFile(sourceFile, targetFile);
            System.out.println("Sao chép hoàn tất. Số ký tự trong tập tin: " + characterCount);

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    public static int copyFile(File sourceFile, File targetFile) throws IOException {
        int characterCount = 0;

        // Sử dụng FileReader và FileWriter để đọc/ghi file
        try (FileReader fileReader = new FileReader(sourceFile);
             FileWriter fileWriter = new FileWriter(targetFile)) {

            int character;
            while ((character = fileReader.read()) != -1) {
                fileWriter.write(character);
                characterCount++;
            }
        }

        return characterCount;
    }
}
