package org.discbase;

import java.lang.reflect.Type;
import java.util.Locale;

public class Disc {
    private String DiscType;
    private String DiscCategory;
    private String DiscName;
    private String Description;

    public Disc (String dType, String dCategory, String dName, String dDescription) {
        DiscType = dType;
        DiscCategory = dCategory;
        DiscName = dName;
        Description = dDescription;
    }

    public String getDiscType () {return DiscType;}
    public void setDiscType(String dType) {DiscType = dType;}

    public String getDiscCategory () {return DiscCategory;}
    public void setDiscCategory(String dCategory) {DiscCategory = dCategory;}

    public String getDiscName() {return DiscName;}
    public void setDiscName(String dName) {DiscType = dName;}

    public String getDescription () {return Description;}
    public void setDescription(String dDescription) {DiscType = dDescription;}


}
