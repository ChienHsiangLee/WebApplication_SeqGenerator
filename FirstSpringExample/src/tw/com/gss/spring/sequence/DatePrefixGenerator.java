package tw.com.gss.spring.sequence;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePrefixGenerator implements ISeqGenerator{

	private DateFormat formatter;
	private String prefix;
	private String suffix;
	private int initial;
	private int counter;
	
	
	
	public DatePrefixGenerator() {
		super();
	}


	public DatePrefixGenerator(DateFormat formatter, String prefix,
			String suffix, int initial) {
		super();
		this.formatter = formatter;
		this.prefix = prefix;
		this.suffix = suffix;
		this.initial = initial;
	}


	public synchronized String getSequence() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.prefix);
		buffer.append(this.formatter.format(new Date()));
		DecimalFormat formatter = new DecimalFormat("0000");
		buffer.append(formatter.format(initial + counter++));
		buffer.append(suffix);
		return buffer.toString();		
	}
		
		
	public void setPattern(String pattern) {
		this.formatter = new SimpleDateFormat(pattern);
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public void setInitial(int initial) {
		this.initial = initial;
	}

}