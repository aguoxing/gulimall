package com.gulimall.common.core.bus.constant.ware;

/**
 * @author: admin
 */
public class WareOrderTaskConstant {

    /**
     * 采购单状态枚举
     */
    public enum LockStatusEnum {
        LOCKED(1, "已锁定"),
        UNLOCKED(2, "已解锁"),
        DEDUCTED(3, "已扣减"),
        ;
        private Integer code;
        private String msg;

        LockStatusEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

    }
}
