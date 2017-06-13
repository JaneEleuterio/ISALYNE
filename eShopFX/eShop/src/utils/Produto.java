package utils;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe que guarda informações referente ao produto.
 * @author Avatar
 *
 */
public class Produto {
	
	private final IntegerProperty id;
	
	private final StringProperty name;
	    
    private final FloatProperty value;
	    
    private final IntegerProperty amount;
	    
    private final StringProperty description; 
	
	
    
    /**
     * Construtor vazio.
     */    
    public Produto() {
        this(0, null, (float) 0.00, 0, null);
    }
    
    /**
     * Construtor da classe Produto.
     * @param name
     * @param value
     * @param amount
     * @param description 
     */
	public Produto(int id , String name , float value , int amount ,String description){
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
        this.value = new SimpleFloatProperty(value);
        this.amount = new SimpleIntegerProperty(amount);
        this.description = new SimpleStringProperty(description);
	}
	
	
	public int getId() {
		return id.get();
	}
	
	public void setId(int id) {
		if(id >= 0)
			this.id.set(id);
	}
	
	public StringProperty nameProperty() {
        return name;
    }
	
	public String getName() {
		return name.get();
	}
	
	public void setName(String name) {
		if(name != null)
			this.name.set(name);
	}
	
	public float getValue() {
		return value.get();
	}
	
	public void setValue(float value) {
		if(value >= 0.1)
			this.value.set(value);
	}
	
	public int getAmount() {
		return amount.get();
	}
	
	public void setAmount(int amount) {
		if(amount > -1)
			this.amount.set(amount);
	}
	
	public String getDescription() {
		return description.get();
	}
	public void setDescription(String description) {
		this.description.set(description);
	}

}
