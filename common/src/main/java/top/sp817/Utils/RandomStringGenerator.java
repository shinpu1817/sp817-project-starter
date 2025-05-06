//package top.sp817.Utils;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import net.sourceforge.pinyin4j.PinyinHelper;
//import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
//import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
//import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
//import top.sp817.sources.question_evaluate.entity.Vo.SpQuestionDetail;
//import top.sp817.sources.question_evaluate.entity.pojo.SpQuestion;
//
//import java.lang.reflect.Field;
//import java.util.*;
//
//public class RandomStringGenerator {
//
//    public static <T, M extends BaseMapper<T>>
//    T itemCheck(Class<T> selectType, M mapper, Long id, String ...item) {
//        QueryWrapper<T> wrapper = new QueryWrapper<>();
//        wrapper.eq("id", id);
//        wrapper.select(item);
//        return mapper.selectOne(wrapper);
//    }
//
//    interface FollowFunction<POJO, VO> {
//        void Handle(POJO pojo, VO vo);
//    }
//
//    public static <POJO, VO> VO getVoBean(Class<VO> voClass, POJO obj, FollowFunction<POJO, VO> func) {
//        VO vo = null;
//        try {
//            vo = voClass.getDeclaredConstructor().newInstance();
//            Map<String, Object> pojoItems = new HashMap<>();
//            for (Field field : obj.getClass().getDeclaredFields()) {
//                field.setAccessible(true);
//                String name = field.getName();
//                Class<?> type = field.getType();
//                Object value = field.get(obj);
//                pojoItems.put(type.getName() + "@" + name, value);
//            }
//            for (Field field : voClass.getDeclaredFields()) {
//                field.setAccessible(true);
//                String name = field.getName();
//                Class<?> type = field.getType();
//                field.set(vo, pojoItems.get(type.getName() + "@" + name));
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (Objects.nonNull(func)) {
//            func.Handle(obj, vo);
//        }
//        return vo;
//    }
//
//
//    public static void main(String[] args) {
//
//        SpQuestion question = new SpQuestion(
//                1L, // id
//                "如何使用Lombok简化Java代码？", // title
//                "提供详细的步骤和示例", // tip
//                "Lombok是一个Java库，旨在通过注解来减少样板代码，提高开发效率。", // content
//                "[1,2,3]", // tagIds
//                "技术问题", // type
//                "{\"option1\":\"答案1\",\"option2\":\"答案2\"}", // config
//                "示例说明：使用@Data注解可以自动生成getter、setter、toString、equals和hashCode方法。", // eg
//                1, // isPublish
//                1001L, // createBy
//                1002L, // updateBy
//                new Date(), // createTime
//                new Date(), // updateTime
//                "/question/1", // route
//                0  // isDelete
//        );
//        SpQuestionDetail voBean = getVoBean(
//                SpQuestionDetail.class,
//                question,
//                (pojo,vo) -> {
//
//                });
//
//        System.out.println(voBean);
//
//
//    }
//
//
//    public static String pyToStr(String word){
//        StringBuilder pinyin = new StringBuilder();
//        // 设置format
//        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//        format.setCaseType(HanyuPinyinCaseType.LOWERCASE); // 设置拼音为小写
//        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//        // 生成
//        Boolean flag = null;
//        for (char c : word.toCharArray()) {
//            String[] pinyinArray = null;
//            try {pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, format);}
//            catch (Exception ignore){}
//            if (pinyinArray != null && pinyinArray.length > 0) {
//                if(Boolean.FALSE.equals(flag)) {
//                    flag = true;
//                    pinyin.append(" ");
//                }
//                pinyin.append(pinyinArray[0]).append(" ");
//            }else if(
//                    c >= 'A' && c <= 'Z' ||
//                    c >= 'a' && c <= 'z' ||
//                    c >= '0' && c <= '9' ||
//                    c == ' ' || c == '-' ){
//                flag = false;
//                pinyin.append(c);
//            }
//        }
//
//        if (pinyin.length() > 0 && pinyin.charAt(pinyin.length() - 1) == ' ') {
//            pinyin.deleteCharAt(pinyin.length() - 1);
//        }
//
//        String time = "" + System.currentTimeMillis();
//        time = time.substring(time.length() - 5);
//        pinyin.append("-")
//                .append(getRandomStr(5))
//                .append(time);
//        return pinyin.toString()
//                .replaceAll("\\s+", " ")
//                .replaceAll("-+", "-")
//                .replaceAll(" ", "-");
//    }
//
//
//
//
//    public static String getRandomStr(int n) {
//        String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        Random random = new Random();
//        StringBuilder sb = new StringBuilder(n);
//        for (int i = 0; i < n; i++) {
//            char randomChar = charSet.charAt(random.nextInt(charSet.length()));
//            sb.append(randomChar);
//        }
//        return sb.toString();
//    }
//
//
//    public static String getBotStr(long number) {
//        return getRandomStr(5) + number + System.currentTimeMillis();
//    }
//
//
//}