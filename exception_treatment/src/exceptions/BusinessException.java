package exceptions;

public class BusinessException extends RuntimeException{
//It's mandatory to treat Exception, but not RuntimeException 	
	private static final long serialVersionUID = 1L;
	
	public BusinessException(String msg) {
		super(msg);
	}
}
