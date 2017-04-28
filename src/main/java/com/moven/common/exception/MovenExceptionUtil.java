package com.moven.common.exception;
public abstract class MovenExceptionUtil {

    public static void throwMovenException() {
        throw new MovenException();
    }

    public static void throwMovenException(String msg) {
        throw new MovenException(msg);
    }

    public static void throwMovenException(int code, String msg) {
        throw new MovenException(code, msg);
    }

    public static void throwLoggedMovenException() {
        throw new LoggedMovenException();
    }

    public static void throwLoggedMovenException(String msg) {
        throw new LoggedMovenException(msg);
    }

    public static void throwLoggedMovenException(int code, String msg) {
        throw new LoggedMovenException(code, msg);
    }

    /**
     * expression为false时，抛出MovenException异常
     * 
     * @return
     */
    public static void checkTrue(boolean expression) {
        if (!expression) {
            throw new MovenException();
        }
    }

    /**
     * expression为false时，抛出MovenException异常
     * 
     * @param errMsg 错误消息
     * @return
     */
    public static void checkTrue(boolean expression, Object errMsg) {
        if (!expression) {
            throw new MovenException(String.valueOf(errMsg));
        }
    }

    /**
     * expression为false时，抛出MovenException异常
     * 
     * @param errCode 错误码
     * @param errMsg 错误消息
     * @return
     */
    public static void checkTrue(boolean expression, int errCode, Object errMsg) {
        if (!expression) {
            throw new MovenException(errCode, String.valueOf(errMsg));
        }
    }

    /**
     * expression为false时，抛出MovenException异常.
     * 
     * @param errMsgTpl 错误消息模板，其中的%s会被后面的参数填充
     * @param errMsgArgs 填充错误消息的模板
     */
    public static void checkTrue(boolean expression, String errMsgTpl, Object... errMsgArgs) {
        if (!expression) {
            throw new MovenException(format(errMsgTpl, errMsgArgs));
        }
    }

    /**
     * expression为false时，抛出MovenException异常
     * 
     * @param errCode 错误码
     * @param errMsgTpl 错误消息模板，其中的%s会被后面的参数填充
     * @param errMsgArgs 填充错误消息的模板
     */
    public static void checkTrue(boolean expression, int errCode, String errMsgTpl, Object... errMsgArgs) {
        if (!expression) {
            throw new MovenException(format(errMsgTpl, errMsgArgs));
        }
    }
    
    /**
     * expression为true时，抛出MovenException异常
     * 
     * @return
     */
    public static void checkFalse(boolean expression) {
        if (expression) {
            throw new MovenException();
        }
    }

    /**
     * expression为true时，抛出MovenException异常
     * 
     * @param errMsg 错误消息
     * @return
     */
    public static void checkFalse(boolean expression, Object errMsg) {
        if (expression) {
            throw new MovenException(String.valueOf(errMsg));
        }
    }

    /**
     * expression为true时，抛出MovenException异常
     * 
     * @param errCode 错误码
     * @param errMsg 错误消息
     * @return
     */
    public static void checkFalse(boolean expression, int errCode, Object errMsg) {
        if (expression) {
            throw new MovenException(errCode, String.valueOf(errMsg));
        }
    }

    /**
     * expression为true时，抛出MovenException异常.
     * 
     * @param errMsgTpl 错误消息模板，其中的%s会被后面的参数填充
     * @param errMsgArgs 填充错误消息的模板
     */
    public static void checkFalse(boolean expression, String errMsgTpl, Object... errMsgArgs) {
        if (expression) {
            throw new MovenException(format(errMsgTpl, errMsgArgs));
        }
    }

    /**
     * expression为true时，抛出MovenException异常
     * 
     * @param errCode 错误码
     * @param errMsgTpl 错误消息模板，其中的%s会被后面的参数填充
     * @param errMsgArgs 填充错误消息的模板
     */
    public static void checkFalse(boolean expression, int errCode, String errMsgTpl, Object... errMsgArgs) {
        if (expression) {
            throw new MovenException(format(errMsgTpl, errMsgArgs));
        }
    }

    /**
     * ref为null时，抛出MovenException异常
     * 
     * @param ref 对象引用
     * @return
     */
    public static <T> T checkNotNull(T ref) {
        if (ref == null) {
            throw new MovenException();
        }
        return ref;
    }

    /**
     * ref为null时，抛出MovenException异常
     * 
     * @param ref 对象引用
     * @param errMsg 错误消息
     * @return
     */
    public static <T> T checkNotNull(T ref, Object errMsg) {
        if (ref == null) {
            throw new MovenException(String.valueOf(errMsg));
        }
        return ref;
    }

    /**
     * ref为null时，抛出MovenException异常
     * 
     * @param ref 对象引用
     * @param errCode 错误码
     * @param errMsg 错误消息
     * @return
     */
    public static <T> T checkNotNull(T ref, int errCode, Object errMsg) {
        if (ref == null) {
            throw new MovenException(errCode, String.valueOf(errMsg));
        }
        return ref;
    }

    /**
     * ref为null时，抛出MovenException异常
     * 
     * @param ref 对象引用
     * @param errMsgTpl 错误消息模板，其中的%s会被后面的参数填充
     * @param errMsgArgs 填充错误消息的模板
     * @return
     */
    public static <T> T checkNotNull(T ref, String errMsgTpl, Object... errMsgArgs) {
        if (ref == null) {
            throw new MovenException(format(errMsgTpl, errMsgArgs));
        }
        return ref;
    }

    /**
     * ref为null时，抛出MovenException异常
     * 
     * @param ref 对象引用
     * @param errCode 错误码
     * @param errMsgTpl 错误消息模板，其中的%s会被后面的参数填充
     * @param errMsgArgs 填充错误消息的模板
     * @return
     */
    public static <T> T checkNotNull(T ref, int errCode, String errMsgTpl, Object... errMsgArgs) {
        if (ref == null) {
            throw new MovenException(errCode, format(errMsgTpl, errMsgArgs));
        }
        return ref;
    }
    
    /**
     * ref不为null时，抛出MovenException异常
     * 
     * @param ref 对象引用
     * @return
     */
    public static <T> T checkNull(T ref) {
        if (ref != null) {
            throw new MovenException();
        }
        return ref;
    }

    /**
     * ref不为null时，抛出MovenException异常
     * 
     * @param ref 对象引用
     * @param errMsg 错误消息
     * @return
     */
    public static <T> T checkNull(T ref, Object errMsg) {
        if (ref != null) {
            throw new MovenException(String.valueOf(errMsg));
        }
        return ref;
    }

    /**
     * ref不为null时，抛出MovenException异常
     * 
     * @param ref 对象引用
     * @param errCode 错误码
     * @param errMsg 错误消息
     * @return
     */
    public static <T> T checkNull(T ref, int errCode, Object errMsg) {
        if (ref != null) {
            throw new MovenException(errCode, String.valueOf(errMsg));
        }
        return ref;
    }

    /**
     * ref不为null时，抛出MovenException异常
     * 
     * @param ref 对象引用
     * @param errMsgTpl 错误消息模板，其中的%s会被后面的参数填充
     * @param errMsgArgs 填充错误消息的模板
     * @return
     */
    public static <T> T checkNull(T ref, String errMsgTpl, Object... errMsgArgs) {
        if (ref != null) {
            throw new MovenException(format(errMsgTpl, errMsgArgs));
        }
        return ref;
    }

    /**
     * ref不为null时，抛出MovenException异常
     * 
     * @param ref 对象引用
     * @param errCode 错误码
     * @param errMsgTpl 错误消息模板，其中的%s会被后面的参数填充
     * @param errMsgArgs 填充错误消息的模板
     * @return
     */
    public static <T> T checkNull(T ref, int errCode, String errMsgTpl, Object... errMsgArgs) {
        if (ref != null) {
            throw new MovenException(errCode, format(errMsgTpl, errMsgArgs));
        }
        return ref;
    }

    private static String format(String template, Object... args) {
        template = String.valueOf(template); // null -> "null"

        // start substituting the arguments into the '%s' placeholders
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;
        int i = 0;
        while (i < args.length) {
            int placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }
            builder.append(template.substring(templateStart, placeholderStart));
            builder.append(args[i++]);
            templateStart = placeholderStart + 2;
        }
        builder.append(template.substring(templateStart));

        // if we run out of placeholders, append the extra args in square braces
        if (i < args.length) {
            builder.append(" [");
            builder.append(args[i++]);
            while (i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }
            builder.append(']');
        }

        return builder.toString();
    }
}
