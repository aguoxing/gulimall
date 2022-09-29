package com.gulimall.common.core.bus.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {

    private Set<Integer> set = new HashSet<>();

    /**
     * 初始化方法
     *
     * @param constraintAnnotation
     */
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] vals = constraintAnnotation.vals();
        if (vals != null && vals.length != 0) {
            for (int val : vals) {
                set.add(val);
            }
        }
    }

    /**
     * 校验逻辑
     *
     * @param value   需要校验的值
     * @param context 上下文
     * @return
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        /**
         * 如果set length==0，会返回false
         */
        return set.contains(value);
    }
}
