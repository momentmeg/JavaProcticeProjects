package primary.SPMS;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @FileName Student
 * @Description
 * @Author fahrtwind
 * @date 2024-10-23
 **/


public class Student {
    private Integer StuId;
    private String Name;
    private Integer Sex; //0 表示女，1表示男
    private HashMap<String,Double> Score;  //语文，数学，英语

    public Student() {
    }

    public Student(Integer stuId, String name, Integer sex, HashMap<String, Double> score) {
        StuId = stuId;
        Name = name;
        Sex = sex;
        Score = score;
    }

    public Integer getStuId() {
        return StuId;
    }

    public void setStuId(Integer stuId) {
        StuId = stuId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getSex() {
        return Sex;
    }

    public void setSex(Integer sex) {
        Sex = sex;
    }

    public HashMap<String, Double> getScore() {
        return Score;
    }

    public void setScore(HashMap<String, Double> score) {
        Score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StuId=" + StuId +
                ", Name='" + Name + '\'' +
                ", Sex=" + Sex +
                ", Score=" + Score +
                '}';
    }
}
