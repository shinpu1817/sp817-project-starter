package top.sp817.Utils;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BeanUtils {

    private BeanUtils() {
    }
    
    public static <V> V copyBean(Object source,Class<V> clazz) {
        //创建目标对象
        V result = null;
        try {
            result = clazz.newInstance();
            //实现属性copy
            org.springframework.beans.BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回结果
        return result;
    }
    public static <O,V> List<V> copyBeanList(List<O> list, Class<V> clazz){
        if(Objects.isNull(list)) return null;
        return list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }

}