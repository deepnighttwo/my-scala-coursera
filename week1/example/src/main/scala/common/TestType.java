package common;

import java.util.ArrayList;
import java.util.List;

public class TestType {
    public static void main(String[] args) {




        List<? extends Object> a = null;
        List<? extends Number> b = null;
        List<? extends Double> c = new ArrayList<Double>();

        b = c;

        List<Number> bb = null;
        bb.add(9);

        List<? super Number> d = null;
        d.add(12312.0);
        d.add(((Number)111));

        a = d;


        /**
         * 错误，因为list 里的具体引用类型 eventually是CharSequence的某个父类，而后面new出来的ArrayList就是String的引用。
         * 如果允许赋值，那就意味着可以向List里add一个CharSequence的实例，甚至是一个Object。这样就相当于破坏了原本
         * new ArrayList<String>()里“里面都是String的实例”的泛型保证。
         */
        // List<? super CharSequence> list = new ArrayList<String>();

        /**
         * 可以添加元素，因为无论list实际指向的List所声明的类型是什么，肯定都是CharSequence的父类。
         * 而CharSequence本身又是String的父类，所以这个list实际指向的列表所声明的元素类型（也就是ArrayList<E>）里的
         * 那个E，肯定是String的父类，所以父类指向子类的对象没问题。
         */
        List<? super CharSequence> list =null;
        list.add("");

        /**
         * 可以，因为List里距离引用类型eventually是Double类型的某个子类。所以允许的类型都是Double的子类，当然可以被Double
         * 的引用所指向。而ArrayList里的引用都是Double类型，都可以指向Double类型子类的实例。
         */
        List<? extends Double> keyi = new ArrayList<Double>();

        /**
         * 首先不要被上面的赋值语句限制，List<? extends Double>的意思是这个列表里的元素都是Double或其子类。
         * 不行，因为keyi这个列表具体指向的可能是类型都SubDouble的list，随便向里面添加元素相当于break了原List里
         * 里面都是SubDouble的实例”的泛型保证。
         */
        // keyi.add(1.3)


    }

    /**
     * https://www.linuxidc.com/Linux/2013-10/90928.htm
     * @param a
     * @param n
     * @param <T>
     */



    //对一组数组对象运用插入排序，n指数组元素的个数
    public static <T extends Comparable<? super T>>
    void selectionSort(T[] a,int n) {
        for (int index = 0; index < n-1; index++) {
            int indexOfSmallest = getIndexOfSmallest(a,index,n-1);
            swap(a,index,indexOfSmallest);
        }
    }

    static class Student implements Comparable<Student>{
        private int id;

        public Student(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(Student o) {
            return (id > o.id) ? 1 : ((id < o.id) ? -1 : 0);
        }
    }

    static class CollegeStudent extends Student{
        public CollegeStudent(int id) {
            super(id);
        }
    }

    public static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last) {
        T minValue = a[first]; // 假设第一个为minValue
        int indexOfMin = first; // 取得minValue的下标
        for (int index = first + 1; index <= last; index++) {
            if (a[index].compareTo(minValue) < 0) {
                minValue = a[index];
                indexOfMin = index;
            }
        }

        return indexOfMin;
    }

    public static void swap(Object[] a,int first,int second) {
        Object temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    public static void main2(String[] args) {
        CollegeStudent[] stu = new CollegeStudent[]{
                new CollegeStudent(3),
                new CollegeStudent(2),
                new CollegeStudent(5),
                new CollegeStudent(4)};
        selectionSort(stu, 4);
        for (Student student : stu) {
            System.out.println(student);
        }
    }

}
