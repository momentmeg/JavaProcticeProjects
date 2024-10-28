package primary.SPMS;

import java.util.*;

/**
 * @FileName 学生成绩管理系统
 * @Description 对学生成绩的简单增删查改
 * @Author fahrtwind
 * @date 2024-10-23
 **/


public class ScoreManagementSystem {
    static {
        menu();
        Student s1 = new Student(202401, "张三", 1, new HashMap<>() {{
            put("语文", 78.0);
            put("数学", 68.5);
            put("英语", 89.5);

        }});
        Student s2 = new Student(202402, "李四", 0, new HashMap<>() {{
            put("语文", 78.0);
            put("数学", 68.5);
            put("英语", 89.5);

        }});
        Student s3 = new Student(202403, "王五", 1, new HashMap<>() {{
            put("语文", 78.0);
            put("数学", 68.5);
            put("英语", 89.5);

        }});

        ScoreDB.scoreList.add(s1);
        ScoreDB.scoreList.add(s2);
        ScoreDB.scoreList.add(s3);
    }

    private static ManageService manageService = new ManegeServiceImpl();

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            switch (input) {
                case 0:
                    menu();
                    break;
                case 1:
                    manageService.add();
                    System.out.println("请选择操作：");
                    break;
                case 2:
                    manageService.delete();
                    System.out.println("请选择操作：");
                    break;
                case 3:
                    manageService.update();
                    System.out.println("请选择操作：");
                    break;
                case 4:
                    manageService.query();
                    System.out.println("请选择操作：");
                    break;
                case 5:
                    manageService.findAll();
                    System.out.println("请选择操作：");
                    break;
                case 6:
                    System.exit(1);
                default:
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("========欢迎进入学生成绩管理系统========");
        System.out.println("请你选择想要进行的操作：");
        System.out.print("0:查看菜单\n" +
                "1:添加学生成绩\n" +
                "2:删除学生成绩\n" +
                "3:修改学生成绩\n" +
                "4:查找学生成绩\n" +
                "5:查看全部学生成绩\n" +
                "6:退出系统\n\n\n");
    }
}
