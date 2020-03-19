package module2;

import java.io.*;
import java.util.List;

public class XuLyFile {
    public void write(String FilePath, List<Book> bookList) {
        try {
            FileWriter file = new FileWriter(FilePath);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            for (int i = 0; i< bookList.size(); i++){
                bufferedWriter.write("ID:" +bookList.get(i).getId() + "|\n" + "Tên sách:" +bookList.get(i).getName() + "|\n" + "Tên tác giả:"+bookList.get(i).getAuthor() + "|\n" +"Giá bán:"+bookList.get(i).getPrice() + "|\n" + "Xuất xứ sách:" +bookList.get(i).getOrigin() + "\n-------------------------------------\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void read( List<Book> bookList) throws Exception {
        try {
            File file = new File("/Users/holoi/IdeaProjects/Case Study Module2/file.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
