package jp.co.fitec.lesson.yoneyama.web.bookstore.entity;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * <p>Bean Validationの仕組みを使用して、エンティティ・オブジェクトにセットされた値の妥当性検証を実行するクラス。</p>
 * 
 * @author M.Yoneyama
 *
 */
public class EntityValidator {

    /**
     * <p>妥当性検証を実行する。</p>
     * 
     * @param entity 妥当性検証の対象となるエンティティ・オブジェクト
     * @return 検証違反が格納されたSetオブジェクト
     */
    public static <T> Set<ConstraintViolation<T>> validate(T entity) {
    	
    	ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        
    	return validator.validate(entity);
    }
}
