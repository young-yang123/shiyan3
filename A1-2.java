import java.util.List;

/**
 * 学院类，聚合Building，组合Course
 */
public class College {
    // 聚合关系：College包含多个Building（弱关联，Building可独立存在）
    private List<Building> buildings;
    // 组合关系：College包含多个Course（强关联，Course依赖College存在）
    private List<Course> courses;

    /**
     * 初始化学院的建筑和课程
     * @param buildings 建筑列表
     * @param courses 课程列表
     */
    public College(List<Building> buildings, List<Course> courses) {
        this.buildings = buildings;
        this.courses = courses;
    }
}

/**
 * 建筑类
 */
public class Building {
    private String name;  // 建筑名称（如"教学楼A"）

    public Building(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

/**
 * 课程类，必须关联一个Building（约束）
 */
public class Course {
    private String name;      // 课程名称（如"Java编程"）
    private Building building; // 关联的建筑（课程必须在某个建筑中进行）

    /**
     * 初始化课程名称和关联的建筑
     * @param name 课程名称
     * @param building 关联建筑
     */
    public Course(String name, Building building) {
        this.name = name;
        this.building = building;
    }
}