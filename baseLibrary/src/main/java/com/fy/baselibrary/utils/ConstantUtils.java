package com.fy.baselibrary.utils;

/**
 * 常量
 * Created by fangs on 2017/5/8.
 */
public class ConstantUtils {

    /**
     * 默认的超时时间
     */
    public static int DEFAULT_MILLISECONDS = 60000;

    /**
     * 服务器地址
     */
//    public static String BASE_URL = "http://192.168.100.251:8080/wuliu/tb/";

    public static String BASE_URL = "http://116.196.95.169/wuliu/tb/";

    /**
     * 图片 地址 (可选)
     */
    public static String IMG_BASE_URL = BASE_URL + "image";

    /**
     * 动态服务器地址
     */
    public static String custom_Url = "";

    /**
     * 用户id
     */
    public static String userId = "userid";

    /**
     * 操作令牌
     */
    public static String token = "";

    /**
     * 用户是否登录 key
     */
    public static String isLogin = "is_Login";

    /**
     * 缓存用户名 key
     */
    public static String userName = "User_Name";


    /**
     * APP 当前模式 （日间/夜间）
     */
    public static final String appMode = "appModeSwitch";

    /**
     * 用户是否 第一次打开APP
     */
    public static final String isfirstOpenApp = "userIsFirstOpenApp";


    /**
     * 吸附 ViewType
     */
    public static final int StickyType = 58;

    /**
     * 进入 搜索 界面 传递搜索关键字的 key
     */
    public static final String queryKey = "QueryKey";

}
