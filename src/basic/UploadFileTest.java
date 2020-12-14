package basic;

import actions.commons.GlobalConstants;

public class UploadFileTest {
    public static void uploadMultipleFiles(String... fileNames) {
        String allFiles = "";
        for (String file : fileNames) {
            allFiles += GlobalConstants.UPLOAD_FOLDER + file + "\n";
        }
        allFiles = allFiles.trim();
        System.out.println(allFiles);
    }

    public static void main(String[] args) {
        //uploadMultipleFiles("file1.png", "file2.png", "file3.txt");
        String abc = "IE.abdqwe";
        String[] aaa = abc.split("\\.");
        for(String eee:aaa){
            System.out.println(eee);
        }
    }
}
