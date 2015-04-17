package com.bbs.validator;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * 请求参数的校验
 * 
 * @author jie.xu 2014年11月25日 下午10:08:20
 */
public class ParamsValidatorParser {

	/**
	 * 校验
	 */
	public static ParamsParseResult validator(Method method,
			HttpServletRequest request) {
		Validator validatorAnno = method.getAnnotation(Validator.class);
		if (validatorAnno != null) {
			// 处理参数的验证
			StringBuilder sb = new StringBuilder(400);
			FieldValidator[] fieldsValitors = validatorAnno.fieldsValidate();
			int flag = 0;
			for (FieldValidator fv : fieldsValitors) {
				flag++;
				String paramField = fv.field();
				boolean isRequired = fv.required();
				String paramValue = request.getParameter(paramField);
				if (isRequired) {
					boolean failFlag = false;
					// 参数不能为空，且字符长度不能超过最大值
					if (StringUtils.isEmpty(paramValue)) {
						failFlag = true;
						sb.append(paramField + " 不能为空！");
					} else if (StringUtils.length(paramValue) > fv.maxLength()) {
						failFlag = true;
						sb.append(fv.message());
					}
					if (failFlag) {

						if (flag < fieldsValitors.length) {
							sb.append(";\n");
						}
					}
				} else {
					if (StringUtils.length(paramValue) > fv.maxLength()) {
						sb.append(fv.message());
						if (flag < fieldsValitors.length) {
							sb.append(";\n");
						}
					}
				}
			}
			if (sb.length() > 0) {
				return new ParamsParseResult(false, validatorAnno.view(),
						sb.toString());
			} else {
				return new ParamsParseResult(true, null, null);
			}
		}
		return null;
	}

	public static class ParamsParseResult {

		private boolean success;
		private String view;// 返回的视图
		private String errorMsg;

		public ParamsParseResult() {

		}

		public ParamsParseResult(boolean success, String view, String errorMsg) {
			this.success = success;
			this.view = view;
			this.errorMsg = errorMsg;
		}

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public String getView() {
			return view;
		}

		public void setView(String view) {
			this.view = view;
		}

		public String getErrorMsg() {
			return errorMsg;
		}

		public void setErrorMsg(String errorMsg) {
			this.errorMsg = errorMsg;
		}

	}
}
