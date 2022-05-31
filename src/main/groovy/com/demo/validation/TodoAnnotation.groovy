package com.demo.validation

import java.lang.annotation.*

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

@interface TodoAnnotation {
	
	String TaskTitleValidator() default "Tittle can't be blank"
	
	String TaskDateValidator() default "Due date is not valid"  
}
