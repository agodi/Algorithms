package com.agodi.downloader;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.agodi.helper.Lecture;

public class MediaDownloadManager {
	
	public static List<Lecture> downloadCourseLectures(String courseURL, String parentDirectory) {
		List<Lecture> lectures = null;
		try {
		    
			String courseName = WebContentExtractor.getCourseName(courseURL);
			List<String> urls = WebContentExtractor.extractLecturesUrls(courseURL);
			lectures = WebContentExtractor.getLecturesFromUrls(urls);
			
			String parentFolderName = new StringBuilder(parentDirectory)
			                                .append(courseName)
			                                .append(File.separator)
			                                .toString();

		    File parentFolder = new File(parentFolderName);
		    if (!parentFolder.exists()) {
			    parentFolder.mkdir();
		    }

		    for (Lecture lecture : lectures) {
			    WebContentExtractor.downloadVideo(parentFolderName, lecture);
		    }
		
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lectures;
	}

	public static void main(String args[]) {
		downloadCourseLectures(
				"http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/",
				"/home/agodi/");
	}

}
