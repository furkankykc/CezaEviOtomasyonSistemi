package Entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author furkankykc
 */
public class File {
  
    private String contetType;
    private String name;
    private byte[] content;

   

    public String getContetType() {
        return contetType;
    }

    public void setContetType(String contetType) {
        this.contetType = contetType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "File{" + "contetType=" + contetType + ", name=" + name +  '}';
    }
    
    
}
