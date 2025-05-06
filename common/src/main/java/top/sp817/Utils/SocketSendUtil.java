//package top.sp817.Utils;
//
//import com.alibaba.fastjson2.JSONObject;
//import lombok.Data;
//
//@Data
//public class SocketSendUtil {
//
//    @Data
//    public static class sendObj {
//        private int op;   // 事件提示符
//        private int s;    // 流程符
//        private Object d; // 数据
//        private Long t;   // 时间戳
//
//        public sendObj(int op, int s, Object d) {
//            this.op = op;
//            this.s = s;
//            this.d = d;
//            t = System.currentTimeMillis();
//        }
//    }
//
//    public static String create (int op, int s, JSONObject d) {
//        return JsonUtils.ObjToJSON(new sendObj(op, s, d.toJavaObject(Object.class)));
//    }
//
//    public static String create (int op, int s, Object d) {
//        return JsonUtils.ObjToJSON(new sendObj(op, s, d));
//    }
//
//    public static String create (int op, int s, String d) {
//        return JsonUtils.ObjToJSON(new sendObj(op, s, d));
//    }
//
//}
