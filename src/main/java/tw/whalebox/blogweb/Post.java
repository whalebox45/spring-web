/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tw.whalebox.blogweb;
import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author hsean
 */
@Entity
@Table(name="blogpost")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "context")
    private String context;
    @Column(name = "create_date")
    private java.sql.Timestamp createDate;
    
    public String getTitle(){return this.title;}
    public String getContext(){return this.context;}
    public long getId(){return this.id;}
    public String getCreateDateStr() {return this.createDate.toString();}
    
    public Post(){
    }
    public Post(String title, String context){
        this.title = title;
        this.context = context;
    }
}
