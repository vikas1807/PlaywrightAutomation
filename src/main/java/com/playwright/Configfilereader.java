package com.playwright;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configfilereader {

    Properties pr;
    public Configfilereader() throws IOException {
        FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"/config.properties"));
        pr = new Properties();
        pr.load(file);
    }
    public String getBrowser()
    {
        return pr.getProperty("browser");
    }
    public String getURL()
    {
        return pr.getProperty("url");
    }
}
