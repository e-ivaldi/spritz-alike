package com.manuv.spritzalike.utils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ResourceLoader {

  @SuppressWarnings("resource")
  public static String[] getAllWordsFromFile(String filename) throws IOException{
    File file = new File(filename);
    String fileContent =  new Scanner(file).useDelimiter("\\Z").next();
    return fileContent.split(" ");
   }
}
