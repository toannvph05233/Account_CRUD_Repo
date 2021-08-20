package codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.ArrayList;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Size(min = 8, message = "nhap ngan qua")
    private String userName;

    @Column(nullable = false)
    @Pattern(regexp = "^[A-Za-z0-9]{8,}$", message = "> 8 kytu")
    private String passWord;

    private Date createDate;

    public Account() {
    }

    public Account(long id, String userName, String passWord, Date createDate) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
