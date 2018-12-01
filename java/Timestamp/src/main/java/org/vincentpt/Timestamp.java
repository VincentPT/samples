package org.vincentpt;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.util.Date;

public class Timestamp {
    
    public static void setFileCreationDate(String filePath, Date creationDate) throws IOException {
        BasicFileAttributeView attributes = Files.getFileAttributeView(Paths.get(filePath), BasicFileAttributeView.class);
        FileTime time = FileTime.fromMillis(creationDate.getTime());
        attributes.setTimes(time, time, time);
    }
    
	public static void main(String[] args) {
        try {
            Date dt = new Date();
            //dt.setTime(0);
            setFileCreationDate(args[0], dt);
            System.out.println("Set timestamp successfully!");
        }
        catch (Exception e) {
            System.out.println("Failed to set timestamp" + e.getMessage());
        }

	}
}