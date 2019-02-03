package cn.jcet.springmvc.conversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateCoversion implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.parse(source);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
