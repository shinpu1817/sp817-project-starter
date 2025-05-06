//package top.sp817.handle;
//
//import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
//import org.apache.ibatis.reflection.MetaObject;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class MyMetaObjectHandler implements MetaObjectHandler {
//    @Override
//    public void insertFill(MetaObject metaObject) {
//        Long userId = 1L;
//        this.setFieldValByName("createTime", new Date(), metaObject);
//        this.setFieldValByName("createBy", userId, metaObject);
//        this.setFieldValByName("commitTime", new Date(), metaObject);
//        this.setFieldValByName("commitBy", userId, metaObject);
//        this.setFieldValByName("updateTime", new Date(), metaObject);
//        this.setFieldValByName("updateBy", userId, metaObject);
//    }
//
//    @Override
//    public void updateFill(MetaObject metaObject) {
//        Long userId = 1L;
//        this.setFieldValByName("updateTime", new Date(), metaObject);
//        this.setFieldValByName("updateBy", userId, metaObject);
//    }
//}