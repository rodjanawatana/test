package jp.co.fitec.lesson.yoneyama.web.bookstore.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;

import jp.co.fitec.lesson.yoneyama.web.bookstore.dao.UserAccountDAO;
import jp.co.fitec.lesson.yoneyama.web.bookstore.entity.EntityValidator;
import jp.co.fitec.lesson.yoneyama.web.bookstore.entity.UserAccount;

import org.apache.commons.beanutils.BeanUtils;

public class RegisterAction implements Action {

	public String doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegisterFormBean formBean = new RegisterFormBean();
		
		try {
			
			BeanUtils.populate(formBean, request.getParameterMap());
			request.setAttribute("formBean", formBean);

		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new ServletException(e);
		}	
		
		if(formBean.getConfirmed()) { // 確認済みの場合
						
			// データベースに登録
			UserAccountDAO.insert(new UserAccount(
				request.getParameter("email"),
				request.getParameter("name"),
				request.getParameter("password1")
			));
			
			// 結果ページに表示するメッセージのセット
			response.sendRedirect("result.jsp");
			
			return null;
				
		} else {
			
			Set<String> messages = new HashSet<>(); // エラー・メッセージを格納するSet
			request.setAttribute("messages", messages);
			
			// Validatorを使用した入力値の妥当性検証（UserAccountAccountオブジェクトを対象とする）
			Set<ConstraintViolation<RegisterFormBean>> violations = EntityValidator.validate(formBean);
			
			if(violations.size() > 0) { // 検証エラーが存在する場合
				// すべてのエラー・メッセージの取出し
				for (ConstraintViolation<RegisterFormBean> violation : violations) {
					// エラー・メッセージのセット
				    messages.add(violation.getMessage());
		        }
			} 
						
			if(messages.isEmpty()) { // 検証エラーが存在しなければ確認画面へ移行するための情報をセット
				
				formBean.setReadOnly("readonly");
				formBean.setButtonCaption("Register");
				formBean.setConfirmed(true);
			}
		}
		
		return "/register/";
	}
}
