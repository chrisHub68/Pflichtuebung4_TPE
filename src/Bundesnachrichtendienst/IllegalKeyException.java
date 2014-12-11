package Bundesnachrichtendienst;

public class IllegalKeyException extends CrypterException {

	public IllegalKeyException() {
		super("Ungültiger Schlüssel!");
		// TODO Auto-generated constructor stub
	}

	public IllegalKeyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
