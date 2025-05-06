package top.sp817.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data // 自动生成 getter 和 setter 方法
@NoArgsConstructor // 自动生成无参构造函数
@AllArgsConstructor // 自动生成全参构造函数
public class MyObject {
    private String name; // 姓名
    private int age; // 年龄
    private String email; // 邮箱
    private boolean isStudent; // 是否是学生
    private double height; // 身高（单位：米）
    private String address; // 地址
    private LocalDateTime birthDate; // 出生日期
}