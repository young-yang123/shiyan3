/**
 * A class representing a Thoroughbred horse.
 * This class models the horse's parents and birth year,
 * and provides methods to calculate its age and retrieve its parents.
 */
public class Thoroughbred {

    // 1. 定义私有属性 (对应类图中的 - 属性)
    private Thoroughbred mother;
    private Thoroughbred father;
    private int birthyear;

    // 2. 添加构造方法 (Constructor)
    // 类图中通常不画出构造方法，但代码实现中必须有，用于创建对象
    /**
     * Constructs a new Thoroughbred horse.
     * @param mother The mother of this horse.
     * @param father The father of this horse.
     * @param birthyear The year this horse was born.
     */
    public Thoroughbred(Thoroughbred mother, Thoroughbred father, int birthyear) {
        this.mother = mother;
        this.father = father;
        this.birthyear = birthyear;
    }

    // 3. 实现公有方法 (对应类图中的 + 操作)
    /**
     * Calculates and returns the current age of the horse.
     * @return The current age as an integer.
     */
    public int getCurrentAge() {
        // 为了使方法可测试，我们可以传入一个当前年份，或者在这里固定一个值
        // 这里我们假设当前年份是 2024 年
        int currentYear = 2024;
        return currentYear - this.birthyear;
    }

    /**
     * Retrieves the father of this horse.
     * @return The father as a Thoroughbred object.
     */
    public Thoroughbred getFather() {
        return this.father;
    }

    /**
     * Retrieves the mother of this horse.
     * @return The mother as a Thoroughbred object.
     */
    public Thoroughbred getMother() {
        return this.mother;
    }

    // 可选：添加一个 main 方法来测试这个类
    public static void main(String[] args) {
        // 创建一个祖父马
        Thoroughbred grandSire = new Thoroughbred(null, null, 2000);
        // 创建一个祖母马
        Thoroughbred grandDam = new Thoroughbred(null, null, 2005);
        
        // 创建一个父马，其父母是祖父和祖母
        Thoroughbred sire = new Thoroughbred(grandDam, grandSire, 2010);
        // 创建一个母马
        Thoroughbred dam = new Thoroughbred(null, null, 2012);

        // 创建一个小马，其父母是 sire 和 dam
        Thoroughbred foal = new Thoroughbred(dam, sire, 2022);
        
        // 测试方法
        System.out.println("小马的出生年份: " + 2022);
        System.out.println("小马的当前年龄: " + foal.getCurrentAge()); // 应该输出 2
        System.out.println("小马的父亲是: " + foal.getFather()); // 会打印出 sire 对象的内存地址
        System.out.println("小马的祖父是: " + foal.getFather().getFather()); // 会打印出 grandSire 对象的内存地址
    }
}