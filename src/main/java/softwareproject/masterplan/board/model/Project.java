package softwareproject.masterplan.board.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="t_project")
@NoArgsConstructor
@Data
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int projectidx;

    @Column(nullable=false)
    private String creatorid;

    @Column(nullable=false)
    private String title;

    private int year;

    private int month;

    private int date;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }


    public int getProjectidx() {
        return projectidx;
    }

    public void setProjectidx(int projectidx) {
        this.projectidx = projectidx;
    }

    public String getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(String creatorid) {
        this.creatorid = creatorid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
