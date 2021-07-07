package by.levchenko.TicketService.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {
	public static List<Integer> convertStringToList(String s) {
		return Arrays.stream(s.split(",")).map(Integer::parseInt).collect(Collectors.toList());
	}

	public static Date convertStringToDate(String s) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy").parse(s);
	}
}
