package utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe que guarda informações gerais do e-shop.
 * @author Avatar
 *
 */
public class Information {
	
	private static float ghob;
	
	private static int card_type = 2;
	
	private static String msg;

    private static StringProperty text = new SimpleStringProperty();

    public static float getGhob(float a, float b) {
    	return a - b;
    }
    
    public static StringProperty textProperty() {
        return text ;
    }

    public static final String getTextInfo() {
        return textProperty().get();
    }

    public static final void setTextInfo(String text) {
        textProperty().set(text);
    }
    
    public static void setCardType(int type) {
    	card_type = type;
    }
    
    public static int getCardType() {
    	return card_type;
    }
    
    public static void setMsg(String m) {
    	msg = m;
    }
    
    public static String getMsg() {
    	return msg;
    }
    
}
