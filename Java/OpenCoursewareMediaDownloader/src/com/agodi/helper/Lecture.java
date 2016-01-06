package com.agodi.helper;

/**
 * Value object to hold the name of the lecture and its video URL.
 */
public class Lecture {

  private String title;
  private String videoUrl;
  
  public Lecture(String title, String videoUrl) {
    this.title = title;
    this.videoUrl = videoUrl;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @return the videoUrl
   */
  public String getVideoUrl() {
    return videoUrl;
  }
  
}

