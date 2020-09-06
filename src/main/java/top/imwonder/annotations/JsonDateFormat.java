/*
 * @Author: Wonder2019
 * @Date: 2020-09-06 14:19:40
 * @Last Modified by:   Wonder2019
 * @Last Modified time: 2020-09-06 14:19:40
 */
package top.imwonder.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface JsonDateFormat {


	public String pattern() default "yyyy-MM-dd";

	public String timezone() default "##default";
}
