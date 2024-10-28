package primary.SPMS;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @FileName ManegeService
 * @Description
 * @Author fahrtwind
 * @date 2024-10-23
 **/


public class ManegeServiceImpl implements ManageService {

    private static Scanner sc = new Scanner(System.in);
    private static String[] subject = {"语文", "数学", "英语"};


    @Override
    public void add() {
        preOperate();
        int stuId = sc.nextInt();
        sc.nextLine();
        System.out.println("请输入要添加的学生姓名:");
        String name = sc.nextLine();
        System.out.println("请输入要添加的学生性别(0/1):");
        int sex = sc.nextInt();
        sc.nextLine();
        System.out.println("请依次输入学生的成绩(语文/数学/英语,以分号隔开):");
        String scoresStr = sc.nextLine();

        //字符串转换为double数组
        double[] scores = Arrays.stream(scoresStr.split(";"))
                .mapToDouble(Double::parseDouble).toArray();

        //将成绩加入到hashmap中
        Map<String, Double> fScores = IntStream.range(0, scores.length)
                .boxed()
                .collect(Collectors.toMap(
                        i -> subject[i],
                        i -> scores[i]
                ));

        Student student = new Student(stuId, name, sex, (HashMap<String, Double>) fScores);
        ScoreDB.scoreList.add(student);
        System.out.println("添加成功");


    }

    @Override
    public void delete() {
        preOperate();
        int stuId = sc.nextInt();
        if (ScoreDB.scoreList != null) {
            if (ScoreDB.scoreList.removeIf(student -> student.getStuId() == stuId)) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败或未找到该学生");
            }
        } else {
            System.out.println("当前成绩单为空");
        }
    }

    @Override
    public void query() {
        preOperate();
        int stuId = sc.nextInt();
        if (ScoreDB.scoreList != null) {
            Student student = null;
            for (Student s : ScoreDB.scoreList) {
                if (s.getStuId() == stuId) {
                    student = s;
                    break;
                }
            }
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("未找到此学生");
            }
        } else {
            System.out.println("当前成绩单为空");
        }
    }

    @Override
    public void update() {
        preOperate();
        int stuId = sc.nextInt();
        sc.nextLine();

        if (ScoreDB.scoreList != null) {
            Student student = null;
            for (Student s : ScoreDB.scoreList) {
                if (s.getStuId() == stuId) {
                    student = s;
                    break;
                }
            }
            if (student != null) {

                System.out.println("请依次输入要修改学生的成绩(语文/数学/英语,以分号隔开):");
                String scoresStr = sc.nextLine();

                double[] scores = Arrays.stream(scoresStr.split(";"))
                        .mapToDouble(Double::parseDouble).toArray();

                Map<String, Double> fScores = IntStream.range(0, scores.length)
                        .boxed()
                        .collect(Collectors.toMap(
                                i -> subject[i],
                                i -> scores[i]
                        ));
                student.setScore((HashMap<String, Double>) fScores);
                System.out.println("更新成功");
            } else {
                System.out.println("未找到此学生");
            }

        } else {
            System.out.println("当前成绩单为空");
        }


    }

    @Override
    public void findAll() {
        if (ScoreDB.scoreList != null) {
            for (Student s : ScoreDB.scoreList) {
                System.out.println(s);
            }
        } else {
            System.out.println("当前成绩单为空");
        }


    }

    private static void preOperate() {
        System.out.println("请输入你要操作的学生Id:");
    }


}
